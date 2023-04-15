package com.fpt.training.StudentManagement.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpt.training.StudentManagement.models.Course;
import com.fpt.training.StudentManagement.repository.CourseRepository;
import com.fpt.training.StudentManagement.service.CourseService;

import jakarta.persistence.EntityManager;
@Service
public class CourseServiceImpl implements CourseService{
	// Dependency inject the CourseDAO
		@Autowired
		private CourseRepository courseRepository;
		@Autowired
		private EntityManager em;
		@Override
		@Transactional
		public List<Course> getCourses() {
			return courseRepository.findAll();
		}

		@Override
		@Transactional
		public void saveCourse(Course theCourse) {
//			Student a = new Student("a","0834712000","male","123457",1);
//			Set<Student> b = new HashSet<>();
//			b.add(a);
//			b.add(new Student("a","0834712000","male","123458",1));
//			b.add(new Student("a","0834712000","male","123459",1));
//			theCourse.setStudents(b);
//			a.setCourse(theCourse);
			
			courseRepository.save(theCourse);
			//b.clear();
		}

		@Override
		@Transactional
		public Course getCourse(String theId) {
			return courseRepository.findById(theId).orElse(null);
		}

		@Override
		//@Transactional
		public void deleteCourse(String theId) {
			courseRepository.deleteById(theId);
		}
	}
 

