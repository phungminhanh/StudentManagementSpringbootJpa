package com.fpt.training.StudentManagement.service;

import java.util.List;

import com.fpt.training.StudentManagement.models.Course;

public interface CourseService {
	public List<Course> getCourses();

	public void saveCourse(Course theCourse);

	public Course getCourse(String theId);

	public void deleteCourse(String theId);

}
