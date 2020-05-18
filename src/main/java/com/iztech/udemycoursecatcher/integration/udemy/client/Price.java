package com.iztech.udemycoursecatcher.integration.udemy.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
	
	private float amount;
	private String currency;

}
