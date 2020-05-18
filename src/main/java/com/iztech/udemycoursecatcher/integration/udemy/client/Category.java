package com.iztech.udemycoursecatcher.integration.udemy.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

	private String title;
	private String url;
	private String type;

}
