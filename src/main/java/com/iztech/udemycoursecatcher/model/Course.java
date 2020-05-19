package com.iztech.udemycoursecatcher.model;

import javax.validation.constraints.NotBlank;

import com.iztech.udemycoursecatcher.integration.udemy.client.Category;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.util.Date;

@Document(collection = "Courses")
@Data
@Builder
public class Course {
	
	@Id
	@Indexed
	private String id;

	@NotBlank
	private long udemyId;
	private String title;
	private boolean isPaid;
	private Discount discount;
	private String url;
	private String rating;
	private int numReviews;
	private Category category;
	private Category subCategory;
	private Date publishDate;

}
