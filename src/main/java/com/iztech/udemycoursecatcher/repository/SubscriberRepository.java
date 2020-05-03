package com.iztech.udemycoursecatcher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iztech.udemycoursecatcher.model.Subscriber;

public interface SubscriberRepository extends MongoRepository<Subscriber,String>{

}
