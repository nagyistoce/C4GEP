package demo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import jxl.read.biff.BiffException;

import data.dao.IHibernateDataContext;
import domain.core.algInputDataProcess.DataSet;
import domain.core.algOutput.GepAlgRun;
import domain.core.algconfiguration.GeneConfiguration;
import domain.core.algconfiguration.GepAlgConfiguration;
import domain.core.algconfiguration.IndividualConfiguration;
import domain.core.algconfiguration.OperatorConfiguration;
import domain.core.algconfiguration.function.Addition;
import domain.core.algconfiguration.function.Divide;
import domain.core.algconfiguration.function.Minus;
import domain.core.algconfiguration.function.Multiply;
import domain.iservice.algConfiguration.IgepConfigurationService;
import domain.iservice.algInputDataProcess.IDataInputService;
import domain.iservice.algOutput.IAlgOutputService;
import domain.iservice.algOutput.IAlgRunStep;
import domain.service.algConfiguration.GepConfigurationService;
import domain.service.algInputDataProcess.DataInputService;
import domain.service.algOutput.*;


public class ConfigurationTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public static void main(String[] args) throws BiffException, IOException {
		// TODO Auto-generated method stub
		IHibernateDataContext hibernateDataContext=GepConfigurationService.initSystem();
		IDataInputService dataInputService=new DataInputService(hibernateDataContext);
		DataSet dataSet=dataInputService.processData(new File("InputDemo.xls"));
		GepAlgConfiguration gepAlgConfiguration=new GepAlgConfiguration();
		gepAlgConfiguration.setAccuracy((float) 0.01);
		gepAlgConfiguration.setSelectionRange((float) 100);
		gepAlgConfiguration.setName("运行");
		gepAlgConfiguration.setMaxGeneration((long) 10000);
		IndividualConfiguration individualConfiguration=new IndividualConfiguration();
		individualConfiguration.setIndividualNumber(200);
		GeneConfiguration geneConfiguration=new GeneConfiguration();
		geneConfiguration.setUseHomeoticGene(true);
		geneConfiguration.setConnectionFunction(new Addition());
		geneConfiguration.setHomeoticGeneHeaderLength(5);
		geneConfiguration.setHomeoticGeneNumber(30);
		geneConfiguration.setNormalGeneHeaderLength(7);
		geneConfiguration.setNormalGeneNumber(3);
		geneConfiguration.setFunctionUsed(Arrays.asList(new Addition(),new Minus(),new Multiply(),new Divide()));
		individualConfiguration.setGeneConfiguration(geneConfiguration);
		gepAlgConfiguration.setIndividualConfiguration(individualConfiguration);	
		OperatorConfiguration operatorConfiguration=new OperatorConfiguration();
		operatorConfiguration.setGeneRecombineRate((float) 0.1);
		operatorConfiguration.setGeneTransportRate((float) 0.1);
		operatorConfiguration.setIsElement(new Integer[]{1,2,3});
		operatorConfiguration.setIsTransportRate((float) 0.1);
		operatorConfiguration.setMutateRate((float) 0.0444);
		operatorConfiguration.setOnePointRecombineRate((float) 0.4);
		operatorConfiguration.setRisElement(new Integer[]{1,2,3});
		operatorConfiguration.setRisTransportRate((float) 0.1);
		operatorConfiguration.setTwoPointRecombineRate((float) 0.2);
		gepAlgConfiguration.setOperatorConfiguration(operatorConfiguration);
		IgepConfigurationService gepConfigurationService=new GepConfigurationService(hibernateDataContext);
		gepAlgConfiguration=gepConfigurationService.processConf(gepAlgConfiguration, dataSet);
		gepConfigurationService.save(gepAlgConfiguration);
		run(gepAlgConfiguration,dataSet,hibernateDataContext);
	}
	private static void run(GepAlgConfiguration gepAlgConfiguration,DataSet dataSet,IHibernateDataContext hibernateDataContext){
		IAlgOutputService algOutputService=new AlgOutputService(hibernateDataContext);
		algOutputService.setWriteToDB(true);
		IAlgRunStep runStep=new AlgCpuRunStep();
		long start=System.nanoTime();
		Future<GepAlgRun> resultRun=algOutputService.run(gepAlgConfiguration, runStep, dataSet);
		GepAlgRun gepAlgRun=null;
		try {
			gepAlgRun = resultRun.get();
			algOutputService.shutdownAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end=System.nanoTime();
		long result=TimeUnit.MILLISECONDS.convert(end-start, TimeUnit.NANOSECONDS);
		System.out.println("总代数:\t"+gepAlgRun.getCurrentPopulation().getGenerationNum());
		System.out.println("总耗时：\t"+result+"\t毫秒");
		System.out.println(gepAlgRun.getBestIndividual().toExprString(gepAlgConfiguration.getIndividualConfiguration().getGeneConfiguration()));
		System.out.println(gepAlgRun.getBestIndividual().toGeneString());
		Arrays.deepToString(gepAlgRun.getCurrentPopulation().getNormalGeneIndex());
		Arrays.deepToString(gepAlgRun.getCurrentPopulation().getNormalGeneType());
		Arrays.deepToString(gepAlgRun.getCurrentPopulation().getHomeoticGeneType());
		Arrays.deepToString(gepAlgRun.getCurrentPopulation().getHomeoticGeneIndex());
	}
}
