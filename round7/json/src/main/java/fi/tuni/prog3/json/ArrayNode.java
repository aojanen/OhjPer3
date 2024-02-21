/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.json;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ttakoj
 */
public class ArrayNode extends Node implements Iterable<Node>{
	
	List<Node> nodes;
	
	public ArrayNode(){
		this.nodes = new ArrayList<>();
	}
	
	public void add(Node node){
		this.nodes.add(node);
	}
	
	public int size(){
		return this.nodes.size();
	}
	
	@Override
	public Iterator<Node> iterator(){
		return new Iterator<Node>() {
			private int currentIndex = 0;
			
			@Override
			public boolean hasNext(){
				return currentIndex < nodes.size();
			}
			
			@Override
			public Node next(){
				return nodes.get(currentIndex++);
			}
		};
	}
	
	
	
}


