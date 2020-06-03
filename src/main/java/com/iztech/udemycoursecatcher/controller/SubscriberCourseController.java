package com.iztech.udemycoursecatcher.controller;

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

import com.iztech.udemycoursecatcher.model.SubscriberCourse;
import com.iztech.udemycoursecatcher.service.SubscriberCourseServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("subscriberCourse")
@AllArgsConstructor
public class SubscriberCourseController {

	private final SubscriberCourseServiceImpl subscriberCourseServiceImpl;

	@GetMapping("/{id}")
	public ResponseEntity<SubscriberCourse> getSubscriberCourse(@PathVariable String id) {
		Optional<SubscriberCourse> subscriberCourse = subscriberCourseServiceImpl.getSubscriberCourse(id);
		if (subscriberCourse.isPresent() == true) {
			return new ResponseEntity<>(subscriberCourse.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<String> postSubscriberCourse(@Valid @RequestBody SubscriberCourse subscriberCourse) {
		boolean isSaved = subscriberCourseServiceImpl.saveSubscriberCourse(subscriberCourse);
		if (isSaved) {
			return new ResponseEntity<>("The subscriberCourse is not saved", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>("The subscriberCourse is saved", HttpStatus.OK);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> putSubscriberCourse(@PathVariable String id,
			@Valid @RequestBody SubscriberCourse subscriberCourse) {

		subscriberCourse.setId(id);
		boolean isSaved = subscriberCourseServiceImpl.saveSubscriberCourse(subscriberCourse);

		if (isSaved) {
			return new ResponseEntity<>("The subscriberCourse is updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("The subscriberCourse is not updated", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSubscriberCourse(@Valid @PathVariable String id) {
		boolean isDeleted = subscriberCourseServiceImpl.deleteSubscriberCourse(id);
		if (isDeleted) {
			return new ResponseEntity<>("The subscriberCourse is deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("The subscriberCourse is not deleted", HttpStatus.BAD_REQUEST);
		}
	}

}
