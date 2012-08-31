package domain.service.algOutput;

import java.util.ArrayList;
import java.util.List;

import domain.core.algOutput.GepAlgRun;
import domain.core.algOutput.Individual;
import domain.core.algOutput.Population;

public class AlgCudaRunStep extends AlgRunStep{
	@Override
	public List<Float> calculateFitness(Population population){
		GepAlgRun gepAlgRun=population.getGepAlgRun();
		calcOnCuda(gepAlgRun);
		List<Float> fList=new ArrayList<Float>(population.getIndividuals().size());
		for(Individual individual:population.getIndividuals())
			fList.add(individual.getFitness());
		return fList;
	}
	private native float[] calcOnCuda(GepAlgRun gepAlgRun);
}