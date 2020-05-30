package com.iztech.udemycoursecatcher.integration.udemy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UdemyDiscount {

	private UdemyPrice price;
	private UdemyPrice list_price;
	private boolean has_discount_saving;
	private int discount_percent;

}
