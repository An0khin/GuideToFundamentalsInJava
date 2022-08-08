package com.home;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BankTransactionProcessor {
	private final List<BankTransaction> transactions;
	
	public BankTransactionProcessor(final List<BankTransaction> transactions) {
		this.transactions = transactions;
	}
	
	public double calculateTotalAmount() {
		double total = 0d;
		
		for(int i = 0; i < transactions.size(); i++) {
			final BankTransaction transaction = transactions.get(i);
			final double amount = transaction.getAmount();
			total += amount;
		}
		
		return total;
	}
	
	public double selectInMonth(final Month month) {
		double total = 0d;
		
		for(int i = 0; i < transactions.size(); i++) {
			final BankTransaction transaction = transactions.get(i);
			if(transaction.getDate().getMonth() == month) {
				final double amount = transaction.getAmount();
				total += amount;
			}
		}
		
		return total;
	}
	
	public double calculateAmountByCategory(final String category) {
		double total = 0d;
		
		for(int i = 0; i < transactions.size(); i++) {
			final BankTransaction transaction = transactions.get(i);
			if(transaction.getDescription().equals(category)) {
				final double amount = transaction.getAmount();
				total += amount;
			}
		}
		
		return total;
	}
	
	private boolean dateInTimeRange(final LocalDate date, final LocalDate from, final LocalDate to) {
		if((date.isEqual(from) || date.isAfter(from)) && 
				(date.isEqual(to) || date.isBefore(to)))
			return true;
		return false;
	}
	
	public BankTransaction calculateCheapestTransaction(final LocalDate from, final LocalDate to) {
		BankTransaction cheapestTransaction = null;
		
		for(int i = 0; i < transactions.size(); i++) {
			final BankTransaction transaction = transactions.get(i);
			final LocalDate date = transaction.getDate();
			final double amount = transaction.getAmount();
			
			if(dateInTimeRange(date, from, to)) {
				if(cheapestTransaction == null)
					cheapestTransaction = transaction;
				if(amount < cheapestTransaction.getAmount())
					cheapestTransaction = transaction;
			}
			
		}
		
		return cheapestTransaction;
	}
	
	public BankTransaction calculateMostExpensiveTransaction(final LocalDate from, final LocalDate to) {
		BankTransaction mostExpensive = null;
		
		for(int i = 0; i < transactions.size(); i++) {
			final BankTransaction transaction = transactions.get(i);
			final LocalDate date = transaction.getDate();
			final double amount = transaction.getAmount();
			
			if((date.isEqual(from) || date.isAfter(from)) && 
					(date.isEqual(to) || date.isBefore(to))) {
				if(mostExpensive == null)
					mostExpensive = transaction;
				if(amount > mostExpensive.getAmount())
					mostExpensive = transaction;
			}
			
		}
		
		return mostExpensive;
	}
}
