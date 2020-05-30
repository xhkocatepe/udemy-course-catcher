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
import com.iztech.udemycoursecatcher.repository.SubscriberCourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("subscriberCourse")
@AllArgsConstructor
public class SubscriberCourseController {

	private final SubscriberCourseRepository subscriberCourseRepository;

	@GetMapping("/{id}")
	public ResponseEntity<SubscriberCourse> getSubscriberCourse(@PathVariable String id) {
		Optional<SubscriberCourse> subscriberCourse = subscriberCourseRepository.findById(id);
		if (subscriberCourse.isPresent() == true) {
			return new ResponseEntity<>(subscriberCourse.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<String> postSubscriberCourse(@Valid @RequestBody SubscriberCourse subscriberCourse) {
		try {
			subscriberCourseRepository.save(subscriberCourse);
		} catch (Exception e) {
			return new ResponseEntity<>("The subscriberCourse is not saved", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("The subscriberCourse is saved", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> putSubscriberCourse(@PathVariable String id,
			@Valid @RequestBody SubscriberCourse subscriberCourse) {
		try {
			subscriberCourse.setId(id);
			subscriberCourseRepository.save(subscriberCourse);
		} catch (Exception e) {
			return new ResponseEntity<>("The subscriberCourse is not updated", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("The subscriberCourse is updated", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSubscriberCourse(@Valid @PathVariable String id) {
		try {
			subscriberCourseRepository.deleteById(id);
		} catch (Exception e) {
			return new ResponseEntity<>("The subscriberCourse is not deleted", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("The subscriberCourse is deleted", HttpStatus.OK);
	}

}
