package com.rest.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.db.model.Course;
import com.rest.api.repo.CourseRepository;

@Service
public class CourseServiceImpl {
	@Autowired
	private CourseRepository courseRepository;

	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	public Course findCourse(Long id) {

		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent()) {
			return course.get();
		}
		return null;
	}

}
