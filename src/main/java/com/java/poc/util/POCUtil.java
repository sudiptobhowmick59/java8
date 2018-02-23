package com.java.poc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.java.poc.dto.Apple;


public class POCUtil {
	
	public static Boolean isGreenApple(Apple apple){
		return "green".equalsIgnoreCase(apple.getColor());
	}
	
	public static Boolean isHeavyApple(Apple apple){
		return apple.getWeight() > 100;
	}
	
	public static List<Apple> filterApple(List<Apple> inventory, Predicate<Apple> pred){
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if(pred.test(apple)){
				result.add(apple);
			}
		}
		return result;
		
	}

}
