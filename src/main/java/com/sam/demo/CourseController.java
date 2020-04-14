package com.sam.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	// view home page
	@GetMapping("/")
	public String viewHome() {
		return "home.html";
	}
	
	// get all courses and view them in table
	@GetMapping("/courses")
	public String viewCourses(Model model) {
		List<Course> courses = service.getAllCourses();
		model.addAttribute("coursesList", courses);
		return "courses.html";
	}
	
	// get form, passing Course object 
	@GetMapping("/form")
	public String viewForm(Model model) {
		model.addAttribute("course", new Course());
		return "form.html";
	}
	
	// add course to database when form is submitted
	@PostMapping("/courses")
	public String addCourse(@ModelAttribute("course") Course course) {
		service.addCourse(course);
		return "redirect:/courses";
	}
	
	// edit course when clicked on 'edit' link
	@GetMapping("/courses/{id}/edit")
	public String editCourse(Model model, @PathVariable int id) {
		Course course = service.getCourseById(id);
		model.addAttribute("course", course);
		return "form.html";
	} 
	
	// delete course when clicked on 'delete' link
	@GetMapping("/courses/{id}/delete")
	public String deleteCourse(Model model, @PathVariable int id) {
		service.deleteCourse(id);
		return "redirect:/courses";
	}
}
