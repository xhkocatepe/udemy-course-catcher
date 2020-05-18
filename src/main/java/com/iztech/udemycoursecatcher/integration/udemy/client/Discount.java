package com.iztech.udemycoursecatcher.integration.udemy.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Discount {

	private Price price;
	private Price list_price;
	private boolean has_discount_saving;
	private int discount_percent;

}
