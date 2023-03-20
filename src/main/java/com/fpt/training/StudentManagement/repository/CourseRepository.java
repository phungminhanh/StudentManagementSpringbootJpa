package com.fpt.training.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpt.training.StudentManagement.models.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, String>{
	
	/*/ Dependency inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Course> getCourses() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query select * form Student
		Query<Course> theQuery = currentSession.createQuery("from Course", Course.class);
		// execute query and get result list
		List<Course> Courses = theQuery.getResultList();
		// return the results
		return Courses;
	}

	@Override
	public void saveCourse(Course theCourse) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save/upate the Course
		currentSession.saveOrUpdate(theCourse);
	}

	@Override
	public Course getCourse(String theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// now retrieve/read from database using the primary key
		Course tempCourse = currentSession.get(Course.class, theId);
		// return the course
		return tempCourse;
	}

	@Override
	public void deleteCourse(String theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// delete student with primary key
		Query theQuery = currentSession.createQuery("delete from Course where id=:courseId");
		// set parameter in query
		theQuery.setParameter("courseId", theId);
		// execute query
		theQuery.executeUpdate();
	}*/
}

