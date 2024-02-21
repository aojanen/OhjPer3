/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.json;

import java.util.TreeMap;
import java.util.Iterator;


/**
 *
 * @author ttakoj
 */
public class ObjectNode extends Node implements Iterable<String> {
	TreeMap<String, Node> pairs;
	
	public ObjectNode(){
		pairs = new TreeMap<>();
	}
	
	public Node get(String key){
		return pairs.get(key);
	}
	
	public void set(String key, Node node){
		pairs.put(key, node);
	}
	
	public int size(){
		return pairs.size();
	}
	
	@Override
	public Iterator<String> iterator(){
		return pairs.keySet().iterator();
	}
}
