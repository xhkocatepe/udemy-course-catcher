package com.iztech.udemycoursecatcher.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.iztech.udemycoursecatcher.model.Subscriber;
import com.iztech.udemycoursecatcher.service.SubscriberServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("subscribers")
@AllArgsConstructor
public class SubscriberController {

	private final SubscriberServiceImpl subscriberServiceImpl;

	@GetMapping("/{id}")
	public ResponseEntity<Subscriber> getSubscriber(@PathVariable String id) {
		Optional<Subscriber> subscriber = subscriberServiceImpl.getSubscriber(id);
		if (subscriber.isPresent() == true) {
			return new ResponseEntity<>(subscriber.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<String> postSubscriber(@Valid @RequestBody Subscriber subscriber) {

		boolean isSaved = subscriberServiceImpl.saveSubscriber(subscriber);

		if (isSaved) {
			return new ResponseEntity<>("The subscriber is saved", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("The subscriber is not saved", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> putSubscriber(@PathVariable String id, @Valid @RequestBody Subscriber subscriber) {

		subscriber.setId(id);
		boolean isSaved = subscriberServiceImpl.saveSubscriber(subscriber);

		if (isSaved) {
			return new ResponseEntity<>("The subscriber is updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("The subscriber is not updated", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSubscriber(@Valid @PathVariable String id) {

		boolean isDeleted = subscriberServiceImpl.deleteSubscriber(id);

		if (isDeleted) {
			return new ResponseEntity<>("The subscriber is deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("The subscriber is not deleted", HttpStatus.BAD_REQUEST);
		}
	}

}
