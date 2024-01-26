/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.studentregister;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ttakoj
 */
public class StudentRegister {

	private ArrayList<Student> students;
	private ArrayList<Course> courses;
	private HashMap<String, ArrayList<Attainment>> attainments;

	public StudentRegister() {
		this.students = new ArrayList<>();
		this.courses = new ArrayList<>();
		this.attainments = new HashMap<>();
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public void addAttainment(Attainment att) {
		String studentNumber = att.getStudentNumber();
		if (attainments.containsKey(studentNumber)) {
			attainments.get(studentNumber).add(att);
		} else {
			ArrayList<Attainment> attList = new ArrayList<>();
			attList.add(att);
			attainments.put(studentNumber, attList);
		}
	}

}
