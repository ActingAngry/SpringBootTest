package com.management.student.services;

import java.util.List;

import com.management.student.model.Student;

public interface StudentServices {

	public String createStudent(Student student);
	
	public String updateStudent(Student student);
	
	public List<Student> retrieveStudents(Student student, int caseID);
	
	public void deleteStudent(int ID);
	
}
