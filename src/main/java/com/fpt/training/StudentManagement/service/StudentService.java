package com.fpt.training.StudentManagement.service;

import java.util.List;

import com.fpt.training.StudentManagement.models.Student;

public interface StudentService {
	public List<Student> getStudents();

	public void saveStudent(Student theStudent/*, String courseId*/);

	public Student getStudent(String theId);

	public void deleteStudent(String theId);

}
