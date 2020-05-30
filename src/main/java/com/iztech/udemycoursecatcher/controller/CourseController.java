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

import com.iztech.udemycoursecatcher.integration.udemy.service.UdemyCourseService;
import com.iztech.udemycoursecatcher.model.Course;
import com.iztech.udemycoursecatcher.service.CourseServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("courses")
@AllArgsConstructor
public class CourseController {

	private final CourseServiceImpl courseServiceImpl;
	private final UdemyCourseService courseService;

	@GetMapping("/test")
	public List<Course> test() {
		return courseService.saveCourse();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable String id) {
		Optional<Course> subscriber = courseServiceImpl.getCourse(id);
		if (subscriber.isPresent() == true) {
			return new ResponseEntity<>(subscriber.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<String> postCourse(@Valid @RequestBody Course course) {

		boolean isSaved = courseServiceImpl.saveCourse(course);

		if (isSaved) {
			return new ResponseEntity<>("The course is saved", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("The course is not saved", HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<String> putCourse(@PathVariable String id, @Valid @RequestBody Course course) {

		course.setId(id);
		boolean isSaved = courseServiceImpl.saveCourse(course);

		if (isSaved) {
			return new ResponseEntity<>("The course is updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("The course is not updated", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@Valid @PathVariable String id) {
		
		boolean isDeleted = courseServiceImpl.deleteCourse(id);
		
		if (isDeleted) {
			return new ResponseEntity<>("The course is deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("The course is not deleted", HttpStatus.BAD_REQUEST);
		}
	}

}
