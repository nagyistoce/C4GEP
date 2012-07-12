package domain.core.algconfiguration;

import java.io.Serializable;
import java.util.Deque;

/**
 * 函数抽象类，请确保任何继承此类的子类都具有默认构造函数，否则系统会出现错误
 */
public abstract class Function implements Serializable,Cloneable{
	private static final long serialVersionUID = -5233529550458131848L;
	private String name;
	private String symbol;
	private int arity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getArity() {
		return arity;
	}
	public void setArity(int arity) {
		this.arity = arity;
	}
	@Override
	public Function clone() {
		// TODO Auto-generated method stub
		Function o=null;
		try {
			o = (Function) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	/**
	 * 进行具体的函数运算，并返回运算结果
	 * @param operators 函数参数队列，第一个参数在队首
	 * @return 函数进行运算后的返回值。
	 */
	public abstract float operate(Deque<Float> operators);
}
