package com.iztech.udemycoursecatcher.service;

import java.util.Optional;

import com.iztech.udemycoursecatcher.model.SubscriberCourse;

public interface SubscriberCourseService {
	
	public Optional<SubscriberCourse> getSubscriberCourse(String id);
	public boolean saveSubscriberCourse(SubscriberCourse subscriberCourse);
	public boolean deleteSubscriberCourse(String id);
	
}
