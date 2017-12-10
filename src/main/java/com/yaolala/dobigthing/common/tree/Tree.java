package com.yaolala.dobigthing.common.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.yaolala.dobigthing.entity.Function;

/**
 * 一次性加载所有树形结构
 * @author rachelyao
 *
 */
public class Tree {
	private List<Node> nodes = new LinkedList<Node>(); //子节点
	
	private Node root = null; //根节点
	
	public Tree(List<Function> functions){
		for(Function function:functions){
			Node node = new Node(function.getId(), function.getParentId(), function.getName(), "open", 
					new NodeAttribute(null== function.getUrl()?"":function.getUrl(),function.getId()),
					function.getSerialNum());
			nodes.add(node);
			
			if (node.getId() == 0) {
				root = node;
			}
		}
	}
	
	/**
	 * 构建树形结构
	 * @return
	 */
	public List<Node> build(){
		buildTree(root);
		List<Node> result = new ArrayList<Node>();
		result.add(root);
		return result;
	}
	
	public void buildTree(Node parent){
		Node node = null;
		for(Iterator<Node> ite=nodes.iterator();ite.hasNext();){
			node = ite.next();
			if(Objects.equals(node.getParentId(), parent.getId())){
				parent.getChildren().add(node);
				buildTree(node);
			}
		}
	}
}
