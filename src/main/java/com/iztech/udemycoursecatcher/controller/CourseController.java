package com.iztech.udemycoursecatcher.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iztech.udemycoursecatcher.integration.udemy.connector.UdemyCourseConnector;
import com.iztech.udemycoursecatcher.integration.udemy.mapper.CourseMapper;
import com.iztech.udemycoursecatcher.integration.udemy.service.UdemyCourseService;
import com.iztech.udemycoursecatcher.integration.udemy.service.UdemyCourseServiceImpl;
import com.iztech.udemycoursecatcher.model.Course;
import com.iztech.udemycoursecatcher.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("courses")
@AllArgsConstructor
public class CourseController {

	private final CourseRepository courseRepository;
	private final UdemyCourseService courseService;
	
	@GetMapping("/test")
	public List<Course> test() {
		return courseService.saveCourse();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable String id) {
		Optional<Course> subscriber = courseRepository.findById(id);
		if (subscriber.isPresent() == true) {
			return new ResponseEntity<>(subscriber.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<String> postCourse(@Valid @RequestBody Course course) {
		try {
			courseRepository.save(course);
		} catch (Exception e) {
			return new ResponseEntity<>("The course is not saved", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("The course is saved", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> putCourse(@PathVariable String id, @Valid @RequestBody Course course) {
		try {
			course.setId(id);
			courseRepository.save(course);
		} catch (Exception e) {
			return new ResponseEntity<>("The course is not updated", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("The course is updated", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@Valid @PathVariable String id) {
		try {
			courseRepository.deleteById(id);
		} catch (Exception e) {
			return new ResponseEntity<>("The course is not deleted", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("The course is deleted", HttpStatus.OK);
	}

}
