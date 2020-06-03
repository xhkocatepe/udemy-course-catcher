package com.iztech.udemycoursecatcher.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.iztech.udemycoursecatcher.model.SubscriberCourse;
import com.iztech.udemycoursecatcher.repository.SubscriberCourseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubscriberCourseServiceImpl implements SubscriberCourseService{

	private final SubscriberCourseRepository subscriberCourseRepository;

	public Optional<SubscriberCourse> getSubscriberCourse(String id) {
		return subscriberCourseRepository.findById(id);
	}

	public boolean saveSubscriberCourse(SubscriberCourse subscriberCourse) {
		try {
			subscriberCourseRepository.save(subscriberCourse);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSubscriberCourse(String id) {
		try {
			subscriberCourseRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
