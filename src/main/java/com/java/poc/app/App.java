package com.java.poc.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.java.poc.dto.Apple;
import com.java.poc.dto.Dish;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        
        Apple redApple = new Apple("Red", 120);
        Apple greenApple = new Apple("Green", 90);
        Apple pinkApple = new Apple("Pink", 101);
        Apple greenApple_2 = new Apple("Green", 120);
        Apple yellowApple = new Apple("Yellow", 120);
        
        List<Apple> inventory = new ArrayList<>();
        inventory.add(redApple);
        inventory.add(greenApple);
        inventory.add(pinkApple);
        inventory.add(greenApple_2);
        inventory.add(yellowApple);
        
        List<Dish> menu = Arrays.asList(
						        		new Dish("pork", false, 800, Dish.Type.MEAT),
						        		new Dish("beef", false, 700, Dish.Type.MEAT),
						        		new Dish("chicken", false, 400, Dish.Type.MEAT),
						        		new Dish("french fries", true, 530, Dish.Type.OTHER),
						        		new Dish("rice", true, 350, Dish.Type.OTHER),
						        		new Dish("season fruit", true, 120, Dish.Type.OTHER),
						        		new Dish("pizza", true, 550, Dish.Type.OTHER),
						        		new Dish("prawns", false, 300, Dish.Type.FISH),
						        		new Dish("salmon", false, 450, Dish.Type.FISH) 
						        		);
        
        //Top three high calorie dish - start
        List<String> highCalorieDish = menu.stream()
        									.filter(dish -> dish.getCalories() > 500)
        									.map(dish -> dish.getName())
        									.limit(3)
        									.collect(Collectors.toList());
        System.out.println("#################### Top three high calorie dish ####################");
        System.out.println(highCalorieDish);
        //Top three high calorie dish - Ends
        //Filter vegetarian dish - start
        System.out.println("#################### Vegetarian dish ####################");
		menu.stream()
			.filter(Dish::isVegetarian)
			.collect(Collectors.toList())
			.forEach(System.out::println);
        //Filter vegetarian dish - ends
		//Distinct -> Starts 
		// But this should have equals/hashcode override for pojo
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		System.out.println("#################### Distinct numbers ####################");
		numbers.stream().distinct().forEach(System.out::println);
		//Distinct -> Ends
		//Flat Map -> Starts 
		List<String> words = Arrays.asList("Hello","World");
		System.out.println("#################### Flat Map - 1 ####################");
		words.stream().map(str -> str.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
		//Flat Map -> Ends
		
		//Finding and matching -> Starts
		//Is there an element in the stream matching the given predicate?
		System.out.println("#################### Finding and matching ####################");
		if(menu.stream().anyMatch(Dish::isVegetarian)){
			System.out.println("The menu is (somewhat) vegetarian friendly!!");
		}
		if(menu.stream().allMatch(dish -> dish.getCalories() < 1000)){
			System.out.println("The menu is healthy!!");
		}
		//Finding and matching -> Ends.
		
		//Reduce -> Starts
		//Summing the elements
		System.out.println("#################### Summing the elements ####################");
		System.out.println("Total claories in the menu : " + menu.stream().map(Dish::getCalories).reduce(0, Integer::sum));
		System.out.println("Max calorie in the menu : " + menu.stream().map(Dish::getCalories).reduce(Integer::max).get());
		System.out.println("Min calorie in the menu : " + menu.stream().map(Dish::getCalories).reduce(Integer::min).get());
		System.out.println("Number of dishes in the menu : " + menu.stream().count());
		
		
        
    }
}
