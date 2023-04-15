package com.fpt.training.StudentManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpt.training.StudentManagement.models.Student;
import com.fpt.training.StudentManagement.repository.CourseRepository;
import com.fpt.training.StudentManagement.repository.StudentRepository;
import com.fpt.training.StudentManagement.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent /*, String courseId*/) {
		//Course theCourse = courseRepository.findById(courseId).get();
//theStudent.setCourse(theCourse);
		//theStudent.setCourseId(courseId);
		//theStudent.setCourseId(courseId);
		
		 studentRepository.save(theStudent);
		 
//		 if(!theStudent.getId().isEmpty())
//	            studentRepository.save(theStudent);
//	        else {
//	            Student updateStudent = studentRepository.findById(theStudent.getId()).orElseThrow(() -> new RuntimeException (theStudent.getId()));
//	            updateStudent.setName(theStudent.getName());
//	            updateStudent.setPhone(theStudent.getPhone());
//	            updateStudent.setGender(theStudent.getGender());
//	            updateStudent.setGpa(theStudent.getGpa());
//	            studentRepository.save(updateStudent);
//	        }
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

