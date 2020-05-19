package com.iztech.udemycoursecatcher.integration.udemy.client;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iztech.udemycoursecatcher.model.Discount;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {
	private long id;
	private String title;
	private Discount discount;
	private String url;
	@JsonProperty("is_paid")
	private boolean isPaid;
	@JsonProperty("avg_rating")
	private float rating;
	@JsonProperty("num_reviews")
	private int numReviews;
	@JsonProperty("primary_category")
	private Category category;
	@JsonProperty("primary_subcategory")
	private Category subCategory;
	@JsonProperty("published_time")
	private Date publishDate;
}
