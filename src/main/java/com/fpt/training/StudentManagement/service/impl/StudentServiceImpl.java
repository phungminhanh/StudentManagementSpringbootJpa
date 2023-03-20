package com.fpt.training.StudentManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpt.training.StudentManagement.models.Student;
import com.fpt.training.StudentManagement.repository.StudentRepository;
import com.fpt.training.StudentManagement.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		studentRepository.save(theStudent);
		
	}

	@Override
	@Transactional
	public Student getStudent(String theId) {
		
		return studentRepository.findById(theId).orElse(null);
	}

	@Override
	@Transactional
	public void deleteStudent(String theId) {
		studentRepository.deleteById(theId);
	}
}

