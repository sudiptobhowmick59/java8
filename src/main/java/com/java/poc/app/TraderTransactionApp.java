package com.java.poc.app;

import java.util.Arrays;
import java.util.List;

import com.java.poc.dto.Trader;
import com.java.poc.dto.Transaction;


public class TraderTransactionApp {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
											new Transaction(brian, 2011, 300),
											new Transaction(raoul, 2012, 1000),
											new Transaction(raoul, 2011, 400),
											new Transaction(mario, 2012, 710),
											new Transaction(mario, 2012, 700),
											new Transaction(alan, 2012, 950)
										 );
		
		System.out.println("#################### Find all transactions in 2011 and sort by value (small to high) ####################");
		transactions.stream()
							.filter(trans -> trans.getYear() == 2011)
							.sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
							.forEach(System.out::println);
		
		System.out.println();
		System.out.println("#################### All the unique cities where the traders work ####################");
		transactions.stream()
							.map(trans -> trans.getTrader().getCity())
							.distinct()
							.forEach(System.out::println);
		
		System.out.println();
		System.out.println("#################### Find all traders from Cambridge and sort them by name ####################");
		transactions.stream()
							.map(Transaction::getTrader)
							.filter(trader -> trader.getCity().equalsIgnoreCase("Cambridge"))
							.sorted((t1, t2) -> t1.getName().compareToIgnoreCase(t2.getName()))
							.distinct()
							.forEach(System.out::println);
		
		System.out.println();
		System.out.println("#################### Are any traders based in Milan? ####################");
		System.out.println(transactions.stream()
							.map(Transaction::getTrader)
							.anyMatch(trader -> trader.getCity().equalsIgnoreCase("Milan")));
		
		System.out.println();
		System.out.println("#################### Print all transactions’ values from the traders living in Cambridge ####################");
		transactions.stream()
							.filter(trans -> trans.getTrader().getCity().equalsIgnoreCase("Cambridge"))
							.forEach(System.out::println);
		
	}

}
