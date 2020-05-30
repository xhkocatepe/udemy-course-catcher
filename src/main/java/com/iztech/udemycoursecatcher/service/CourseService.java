package com.iztech.udemycoursecatcher.service;

import java.util.Optional;

import com.iztech.udemycoursecatcher.model.Course;

public interface CourseService {
	
	public Optional<Course> getCourse(String id);
	public boolean saveCourse(Course course);
	public boolean deleteCourse(String id);

}
