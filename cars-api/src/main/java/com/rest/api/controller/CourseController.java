package com.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.db.model.Course;
import com.rest.api.service.CourseServiceImpl;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseServiceImpl serviceImpl;

	@PostMapping("add")
	public Course addCourse(

			@RequestBody Course course) {
		// Course course = new Course("FSD");
		// course.setId(100L);
		System.out.println("Add Course.." + course);

		return serviceImpl.saveCourse(course);
	}

	@GetMapping("findCourse/{id}")
	public Course getCourse(@PathVariable("id") Long id) {

		return serviceImpl.findCourse(id);
	}

}
