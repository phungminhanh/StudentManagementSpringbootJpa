package com.fpt.training.StudentManagement.models;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fpt.training.StudentManagement.utils.Validator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "course")
public class Course  implements Serializable, Statistical {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "course_id")
	@NotNull(message = "is require")
	@Pattern(regexp=Validator.VALID_COURSE_ID_REGEX, message="course Id: 2 upper case letter follows by 3 digits")
	private String id;
	
	@Column(name = "title")
	@NotNull(message = "is require")
	private String title;
	
	@Column(name = "credit")
	@NotNull(message = "is require")
	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=10, message="must be less than or equal to 10")
	private double credit;
	
	@Column(name="enrollment")
	@NotNull(message = "is require")
	private int enrollment;
    	
//	@OneToMany(fetch=FetchType.EAGER,
//			   mappedBy="course",
//			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//						 CascadeType.DETACH, CascadeType.REFRESH})
	@OneToMany(mappedBy="course" , fetch=FetchType.LAZY )
	private Set<Student> students;
	
	public Course(String id, String title, Set<Student> students, double credit, int enrollment) {

		this.id = id;
		this.title = title;
		this.students = students;
		this.credit = credit;
		this.enrollment = enrollment;
	}
	public Course(String id, String title, double credit, int enrollment) {

		this.id = id;
		this.title = title;
		this.credit = credit;
		this.enrollment = enrollment;
	}
	public Course() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
			this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public int getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}
	public void add(Student tempStudent) {
		if (students == null) {
			students = new HashSet<Student>();
		}
		students.add(tempStudent);
		tempStudent.setCourse(this);
	}
	public Map<String, Integer> getStatistic() {
		Map<String, Integer> stats = new HashMap<String, Integer>();
		stats.put("A", 0);
		stats.put("B", 0);
		stats.put("C", 0);
		stats.put("D", 0);
		for (Student student : students) {
			if (student.getGpa() >= 8.5) {
				stats.put("A", stats.get("A") + 1);
			} else if (student.getGpa() < 8.5 && student.getGpa() >= 7) {
				stats.put("B", stats.get("B") + 1);
			} else if (student.getGpa() < 7 && student.getGpa() >= 6) {
				stats.put("C", stats.get("C") + 1);
			} else {
				stats.put("D", stats.get("D") + 1);
			}
		}
		return stats;
	}

}


