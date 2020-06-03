package com.iztech.udemycoursecatcher.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iztech.udemycoursecatcher.model.Subscriber;
import com.iztech.udemycoursecatcher.repository.SubscriberRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubscriberServiceImpl implements SubscriberService {

	private final SubscriberRepository subscriberRepository;

	public Optional<Subscriber> getSubscriber(String id) {
		return subscriberRepository.findById(id);
	}

	public boolean saveSubscriber(Subscriber subscriber) {
		try {
			subscriberRepository.save(subscriber);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSubscriber(String id) {
		try {
			subscriberRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
