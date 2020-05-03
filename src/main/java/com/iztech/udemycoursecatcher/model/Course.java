package com.iztech.udemycoursecatcher.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Courses")
@Data
public class Course {
	
	@Id
	@Indexed
	private String id;

	private long udemyId;
	private String title;
	private boolean isPaid;
	private Discount discount;
	private String url;
	private String rating;
	private int numReviews;
	private String category;
	private String subCategory;
	private String publishDate;

}
