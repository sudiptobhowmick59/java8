package com.java.poc.dto;

import lombok.Data;

@Data
public class Trader {
	private final String name;
	private final String city;
	
	public Trader(String n, String c){
		this.name = n;
		this.city = c;
	}
}
