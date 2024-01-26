/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.studentregister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

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

	public ArrayList<Student> getStudents() {
		ArrayList<Student> s = students;
		Collections.sort(s);
		return s;
	}

	public ArrayList<Course> getCourses() {
		ArrayList<Course> c = courses;
		Collections.sort(c);
		return c;
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

	public void printStudentAttainments(String studentNumber, String order) {
		if (!attainments.containsKey(studentNumber)) {
			System.out.println("Unknown student number: studentNumber");
			return;
		}

		String studentName = "";

		for (Student stud : students) {
			if (stud.getStudentNumber().equals(studentNumber)) {
				studentName = stud.getName();
			}
		}

		System.out.println(studentName + " (" + studentNumber + "):");
		ArrayList<Attainment> att = attainments.get(studentNumber);
		
		if ("by name".equals(order)){
			
		} else if ("by code".equals(order)){
			Collections.sort(att);
		} else {
			printStudentAttainments(studentNumber);
		}
		
	}

	public void printStudentAttainments(String studentNumber) {
		if (!attainments.containsKey(studentNumber)) {
			System.out.println("Unknown student number: studentNumber");
			return;
		}

		String studentName = "";

		for (Student stud : students) {
			if (stud.getStudentNumber().equals(studentNumber)) {
				studentName = stud.getName();
			}
		}

		System.out.println(studentName + " (" + studentNumber + "):");
		ArrayList<Attainment> att = attainments.get(studentNumber);
		
		for (Attainment a:att){
			String courseName = courses.stream().filter(course -> a.getCourseCode().equals(course.getCode())).map(Student::getName).findFirst();
			System.out.println("  " + a.getCourseCode() + " " + courseName + ": " + a.getGrade());
		}

	}

}
