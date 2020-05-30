package com.iztech.udemycoursecatcher.integration.udemy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UdemyPrice {
	
	private float amount;
	private String currency;

}
