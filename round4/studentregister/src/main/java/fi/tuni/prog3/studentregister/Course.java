/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.studentregister;

/**
 *
 * @author ttakoj
 */
public class Course implements Comparable<Course>{
	private String code;
	private String name;
	private int credits;

	public Course(String code, String name, int credits) {
	}
	
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public int getCredits() {
		return credits;
	}
	
		@Override public int compareTo(Course x){
		return name.compareTo(x.name);
	}
	
}
