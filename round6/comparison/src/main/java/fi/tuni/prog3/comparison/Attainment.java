/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.comparison;
import java.util.Comparator;

/**
 *
 * @author ttakoj
 */
public class Attainment implements Comparable<Attainment> {
	private String courseCode;
	private String studentNumber;
	private int grade;
	
	public Attainment(String courseCode, String studentNumber, int grade) {
		this.courseCode = courseCode;
		this.studentNumber = studentNumber;
		this.grade = grade;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public int getGrade() {
		return grade;
	}	
	
	@Override
	public int compareTo(Attainment other){
		int cmp = studentNumber.compareTo(other.studentNumber);
		if (cmp == 0){
			cmp = courseCode.compareTo(other.getCourseCode());
		}
		return cmp;
	}
	
	@Override
	public String toString(){
		return String.format("%s %s %d", courseCode, studentNumber, grade);
	}
	
	public static final Comparator<Attainment> CODE_STUDENT_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment attainment1, Attainment attainment2) {
            int cmp = attainment1.courseCode.compareTo(attainment2.getCourseCode());
            if (cmp != 0) {
                return cmp;
            }

            return attainment1.studentNumber.compareTo(attainment2.getStudentNumber());
        }
    };
	
	public static final Comparator<Attainment> CODE_GRADE_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment attainment1, Attainment attainment2) {
            int cmp = attainment1.courseCode.compareTo(attainment2.getCourseCode());
            if (cmp != 0) {
                return cmp;
            }

            return attainment2.grade - attainment1.grade;
        }
    };
}
