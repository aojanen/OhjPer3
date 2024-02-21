/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.json;

/**
 *
 * @author ttakoj
 */

public class ValueNode extends Node{
	public enum NodeType {
		DOUBLE,
		BOOLEAN,
		STRING,
		NULL;
	}
	String s;
	double d;
	boolean b;
	NodeType type;
	
	public ValueNode(){
		this.type = NodeType.NULL;
	}
	public ValueNode(String s){
		this.type = NodeType.STRING;
		this.s = s;
	}
	public ValueNode(double d){
		this.type = NodeType.DOUBLE;
		this.d = d;
	}
	
	public ValueNode(boolean b){
		this.type = NodeType.BOOLEAN;
		this.b = b;
	}
	
	public boolean isNull(){
		return type == NodeType.NULL;
	}
	
	public boolean isBoolean(){
		return type == NodeType.BOOLEAN;
	}
	
	public boolean isString(){
		return type == NodeType.STRING;
	}
	
	public boolean isNumber(){
		return type == NodeType.DOUBLE;
	}
	
	public Object getNull(){
		return null;
	}
	
	public double getNumber(){
		return d;
	}
	
	public String getString(){
		return s;
	}
	
	public boolean getBoolean(){
		return b;
	}
}
