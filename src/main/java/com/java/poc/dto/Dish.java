package com.java.poc.dto;

import lombok.Data;

@Data
public class Dish {
	public enum Type { MEAT, FISH, OTHER }
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;
}
