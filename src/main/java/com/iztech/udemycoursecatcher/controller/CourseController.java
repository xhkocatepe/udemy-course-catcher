package com.iztech.udemycoursecatcher.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iztech.udemycoursecatcher.Service.CourseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("courses")
@AllArgsConstructor
public class CourseController {
	
	private final CourseService courseService;

	@GetMapping
	public ResponseEntity<String> getSubscriber() {
		
		return new ResponseEntity<>(courseService.get(), HttpStatus.OK);
		
	}

}
