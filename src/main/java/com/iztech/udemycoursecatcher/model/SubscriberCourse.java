package com.iztech.udemycoursecatcher.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "SubscribersCourses")
@Data
public class SubscriberCourse {
	
	@Id
	private String id;
	@Indexed(unique= true)
	private String subscriberEmail;
	private long udemyId;

}
