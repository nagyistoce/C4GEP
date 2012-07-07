package domain.core.algmodel.individualcomponent;

import java.util.List;

import domain.core.algmodel.genecomponent.GenePiece;

/**
 * 同源基因头部的实体类
 * @author 申远
 *
 */
public class HomeoticGeneHeader extends Header{
	private static final long serialVersionUID = 5276198147420739676L;
	/**
	 * 创建基因头部的构造函数，用户需要提供个体或或者基因中的基因片段List，并确定头部从哪个地址开始，到哪个地址结束
	 * @param genePieces 基因片段List
	 * @param start 基因头部开始的地址，包括
	 * @param end 基因头部结束的地址，不包括
	 */
	public HomeoticGeneHeader(List<GenePiece> genePieces,int start,int end) {
		// TODO Auto-generated constructor stub
		super(genePieces,start,end);
	}
	
}
