package com.iztech.udemycoursecatcher.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Subscribers")
@Data
public class Subscriber {
	
	@Id
	private String id;
	private String name;
	
	@Indexed(unique= true)
	private String email;
	private List<SubCategory> subCategories;

}
