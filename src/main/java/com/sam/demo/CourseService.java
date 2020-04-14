package com.sam.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	public List<Course> getAllCourses(){
		return courseRepo.findAll();
	}
	
	public Course getCourseById(int id) {
		return courseRepo.findById(id).orElse(null);
	}
	
	public void addCourse(Course course) {
		courseRepo.save(course);
	}
	
	public void deleteCourse(int id) {
		courseRepo.deleteById(id);
	}
	
}
