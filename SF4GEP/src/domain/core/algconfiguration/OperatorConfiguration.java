package domain.core.algconfiguration;

public class OperatorConfiguration {
	private Float mutateRate;
	private Float isTransportRate;
	private int[] isElement;
	private Float risTransportRate;
	private int[] risElement;
	private Float geneTransportRate;
	private Float onePointRecombineRate;
	private Float twoPointRecombineRate;
	private Float geneRecombineRate;
	public Float getMutateRate() {
		return mutateRate;
	}
	public void setMutateRate(Float mutateRate) {
		this.mutateRate = mutateRate;
	}
	public Float getIsTransportRate() {
		return isTransportRate;
	}
	public void setIsTransportRate(Float isTransportRate) {
		this.isTransportRate = isTransportRate;
	}
	public int[] getIsElement() {
		return isElement;
	}
	public void setIsElement(int[] isElement) {
		this.isElement = isElement;
	}
	public Float getRisTransportRate() {
		return risTransportRate;
	}
	public void setRisTransportRate(Float risTransportRate) {
		this.risTransportRate = risTransportRate;
	}
	public int[] getRisElement() {
		return risElement;
	}
	public void setRisElement(int[] risElement) {
		this.risElement = risElement;
	}
	public Float getGeneTransportRate() {
		return geneTransportRate;
	}
	public void setGeneTransportRate(Float geneTransportRate) {
		this.geneTransportRate = geneTransportRate;
	}
	public Float getOnePointRecombineRate() {
		return onePointRecombineRate;
	}
	public void setOnePointRecombineRate(Float onePointRecombineRate) {
		this.onePointRecombineRate = onePointRecombineRate;
	}
	public Float getTwoPointRecombineRate() {
		return twoPointRecombineRate;
	}
	public void setTwoPointRecombineRate(Float twoPointRecombineRate) {
		this.twoPointRecombineRate = twoPointRecombineRate;
	}
	public Float getGeneRecombineRate() {
		return geneRecombineRate;
	}
	public void setGeneRecombineRate(Float geneRecombineRate) {
		this.geneRecombineRate = geneRecombineRate;
	}
}
