package com.rest.api.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.db.model.Course;
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

}
