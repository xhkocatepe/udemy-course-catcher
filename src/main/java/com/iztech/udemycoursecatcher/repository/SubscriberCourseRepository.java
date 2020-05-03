package com.iztech.udemycoursecatcher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iztech.udemycoursecatcher.model.SubscriberCourse;

public interface SubscriberCourseRepository extends MongoRepository<SubscriberCourse,String>{

}
