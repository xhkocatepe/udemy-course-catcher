package com.iztech.udemycoursecatcher.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iztech.udemycoursecatcher.model.Course;
import com.iztech.udemycoursecatcher.repository.CourseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository;

	public Optional<Course> getCourse(String id) {
		return courseRepository.findById(id);
	}

	public boolean saveCourse(Course course) {
		try {
			courseRepository.save(course);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCourse(String id) {
		try {
			courseRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
