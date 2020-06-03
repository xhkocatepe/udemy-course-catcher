package com.iztech.udemycoursecatcher.service;

import java.util.Optional;

import com.iztech.udemycoursecatcher.model.Subscriber;

public interface SubscriberService {
	
	public Optional<Subscriber> getSubscriber(String id);
	public boolean saveSubscriber(Subscriber subscriber);
	public boolean deleteSubscriber(String id);

}
