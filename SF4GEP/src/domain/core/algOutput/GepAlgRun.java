package domain.core.algOutput;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import domain.core.algInputDataProcess.DataColumn;
import domain.core.algInputDataProcess.DataSet;
import domain.core.algconfiguration.Function;
import domain.core.algconfiguration.GepAlgConfiguration;

public class GepAlgRun implements Serializable{
	private static final long serialVersionUID = -6809763278870156382L;
	private Integer id;
	private GepAlgConfiguration gepAlgConfiguration;
	private DataSet dataSet;
	private List<Population> populations=new ArrayList<Population>(2);
	private Long period;
	private List<Float> maxFitnesses=new LinkedList<Float>();
	private List<Float>	minFitnesses=new LinkedList<Float>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public GepAlgConfiguration getGepAlgConfiguration() {
		return gepAlgConfiguration;
	}
	public void setGepAlgConfiguration(GepAlgConfiguration gepAlgConfiguration) {
		this.gepAlgConfiguration = gepAlgConfiguration;
	}
	public DataSet getDataSet() {
		return dataSet;
	}
	public void setDataSet(DataSet dataSet) {
		this.dataSet = dataSet;
	}
	public Population getPrePopulation(){
		if(populations.size()==0)
			return null;
		else
			return populations.get(0);
	}
	public Population getCurrentPopulation(){
		removeRedundancyPopulation();
		if(populations.size()==0)
			return null;
		else
			return populations.get(populations.size()-1);
	}
	public List<Population> getPopulations() {
		removeRedundancyPopulation();
		return populations;
	}
	public void setPopulations(List<Population> population) {
		this.populations = population;
		removeRedundancyPopulation();
	}
	public Long getPeriod() {
		return period;
	}
	public void setPeriod(Long period) {
		this.period = period;
	}
	public List<Function> getUsedFunctions(){
		return gepAlgConfiguration.getIndividualConfiguration().getGeneConfiguration().getFunctionUsed();
	}
	public List<DataColumn> getUsedVariables(){
		return dataSet.getDataRows().get(0).getDataColumns();
	}
	public Individual getBestIndividual(){
		return Collections.max(getCurrentPopulation().getIndividuals());
	}
	public List<Float> getMaxFitnesses() {
		return maxFitnesses;
	}
	public void setMaxFitnesses(List<Float> maxFitnesses) {
		this.maxFitnesses = maxFitnesses;
	}
	public List<Float> getMinFitnesses() {
		return minFitnesses;
	}
	public void setMinFitnesses(List<Float> minFitnesses) {
		this.minFitnesses = minFitnesses;
	}
	private void removeRedundancyPopulation(){
		while(populations.size()>2)
			populations.remove(0);
	}
	@Override
	public int hashCode(){
		int result = 37;
		result = 37 * result + gepAlgConfiguration.hashCode();
		result = 37 * result + dataSet.hashCode();
		result = 37 * result + populations.hashCode();
		result = 37 * result  +period.hashCode();
		return result;
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof GepAlgRun){
			GepAlgRun gac = (GepAlgRun)o;
			return 	gac.getGepAlgConfiguration().equals(gepAlgConfiguration)
				&&	gac.getDataSet().equals(dataSet)
				&&	gac.getPopulations().equals(populations)
				&&  gac.getPeriod().equals(period);
		}
		else {
			return false;
		}
	}
}
