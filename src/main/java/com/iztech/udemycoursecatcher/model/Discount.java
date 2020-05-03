package com.iztech.udemycoursecatcher.model;

import lombok.Data;

@Data
public class Discount {
	
	private int listPrice;
	private int currentPrice;
	private String currency;
	private int discountPercent;

}
