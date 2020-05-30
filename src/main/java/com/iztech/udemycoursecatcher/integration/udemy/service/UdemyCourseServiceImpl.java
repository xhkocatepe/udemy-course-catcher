package com.iztech.udemycoursecatcher.integration.udemy.service;

import com.iztech.udemycoursecatcher.model.Course;
import com.iztech.udemycoursecatcher.integration.udemy.connector.UdemyCourseConnector;
import com.iztech.udemycoursecatcher.integration.udemy.mapper.CourseMapper;
import com.iztech.udemycoursecatcher.repository.CourseRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UdemyCourseServiceImpl implements UdemyCourseService {
	private final CourseRepository courseRepository;
	private final UdemyCourseConnector udemyCourseConnector;

	public List<Course> saveCourse() {
		List<Course> courses = null;
		try {
			courses = CourseMapper.convertToModel(udemyCourseConnector.get());
			courseRepository.saveAll(courses);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return courses;
	}
}
