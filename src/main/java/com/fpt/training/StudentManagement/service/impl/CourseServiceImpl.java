package com.fpt.training.StudentManagement.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpt.training.StudentManagement.models.Course;
import com.fpt.training.StudentManagement.repository.CourseRepository;
import com.fpt.training.StudentManagement.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService{
	// Dependency inject the CourseDAO
		@Autowired
		private CourseRepository courseRepository;
		
		@Override
		@Transactional
		public List<Course> getCourses() {
			return courseRepository.findAll();
		}

		@Override
		@Transactional
		public void saveCourse(Course theCourse) {
			courseRepository.save(theCourse);
			
		}

		@Override
		@Transactional
		public Course getCourse(String theId) {
			return courseRepository.findById(theId).orElse(null);
		}

		@Override
		@Transactional
		public void deleteCourse(String theId) {
			courseRepository.deleteById(theId);
		}
	}
 

