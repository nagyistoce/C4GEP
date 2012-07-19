package domain.core.algOutput;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 种群实体类
 * @author 申远
 *
 */
public class Population implements Serializable,Cloneable{
	private static final long serialVersionUID = -7846826225395737521L;
	private Integer id;
	private GepAlgRun gepAlgRun;
	private List<Individual> individuals;
	private long generationNum;
	
	/**
	 * 创建一个种群，默认的种群大小为20
	 */
	public Population() {
		// TODO Auto-generated constructor stub
		individuals=new ArrayList<Individual>(20);
	}
	
	/**
	 * 创建一个种群，用户需要提供种群大小
	 * @param size 种群大小
	 */
	public Population(int size){
		individuals=new ArrayList<Individual>(size);
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GepAlgRun getGepAlgRun() {
		return gepAlgRun;
	}
	public void setGepAlgRun(GepAlgRun gepAlgRun) {
		this.gepAlgRun = gepAlgRun;
	}
	/**
	 * 返回种群中所有的个体
	 * @return 种群中所有个体组成的List
	 */
	public List<Individual> getIndividuals(){
		return individuals;
	}
	/**
	 * 设置种群所包含的个体
	 * @param individuals 种群中个体的List
	 */
	public void setIndividuals(List<Individual> individuals) {
		this.individuals = individuals;
	}
	/**
	 * 向种群中添加个体
	 * @param individual 待添加的个体
	 */
	public void addIndividual(Individual individual){
		individuals.add(individual);
	}
	/**
	 * 返回种群中最优个体
	 * @return 种群中最优个体
	 */
	public Individual getBestIndividual(){
		Individual bestIndividual=individuals.get(0);
		for(Individual element:individuals)
			if(element.getFitness()>=bestIndividual.getFitness())
				bestIndividual=element;
		return bestIndividual;
	}
	/**
	 * 返回种群中最差个体
	 * @return 种群中最差个体
	 */
	public Individual getWorstIndividual(){
		Individual bestIndividual=individuals.get(0);
		for(Individual element:individuals)
			if(element.getFitness()<=bestIndividual.getFitness())
				bestIndividual=element;
		return bestIndividual;
	}
	/**
	 * 返回当前种群的代数，即当前种群是第几代种群
	 * @return 当前种群的代数
	 */
	public long getGenerationNum(){
		return generationNum;
	}
	/**
	 * 设置当前种群的代数，即设置当前种群是第几代种群
	 * @param generation 当前种群的代数
	 */
	public void setGenerationNum(long generationNum) {
		this.generationNum = generationNum;
	}
	/**
	 * 对当前种群进行复制，产生一个新的种群，对于string 这样的不可改变对象和int这样的基本数据类型和AlgRun，这是一个浅复制，对于其他的对象而言，这是一个深度复制
	 * @return 一个新的种群，二者不共享内存空间，只是具有相同的初始化的值。
	 */
	@Override
	public Population clone(){
		// TODO Auto-generated method stub
		Population o=null;
		try {
			o = (Population) super.clone();
			if(individuals!=null){
				List<Individual> copiedIndividual=new ArrayList<Individual>();
				if(individuals.size()!=0)
					for(int i=0;i<individuals.size();i++)
						copiedIndividual.add(individuals.get(i).clone());
				o.setIndividuals(copiedIndividual);
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
}
