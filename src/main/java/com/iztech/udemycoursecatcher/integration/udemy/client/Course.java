package com.iztech.udemycoursecatcher.integration.udemy.client;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iztech.udemycoursecatcher.model.Discount;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {
	
	private String title;
	private Discount discount;
	private String url;
	private boolean is_paid;
	private float avg_rating;
	private int num_reviews;
	private Category primary_category;
	private Category primary_subcategory;
	private Date published_time;

}
