package com.java.poc.dto;

@FunctionalInterface
public interface TestInterface {

	public String printMe();
	
	public default void hello(String str){
		System.out.println("This is a default method.." + str);
	}
}
