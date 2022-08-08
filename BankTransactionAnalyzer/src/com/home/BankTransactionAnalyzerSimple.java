package com.home;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzerSimple {

	private static final String RESOURCES = "resources/";
	
	private static final BankTransactionCSVParser parser =
			new BankTransactionCSVParser();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final String fileName = args[0];
		final Path path = Paths.get(RESOURCES, fileName);
		
		final List<BankTransaction> transactions = 
				parser.parseCSV(Files.readAllLines(path));
		
		final BankTransactionProcessor processor =
				new BankTransactionProcessor(transactions);
		
		System.out.println("Total amount = " + processor.calculateTotalAmount());
		System.out.println("Amount in January = " + processor.selectInMonth(Month.JANUARY));
		System.out.println("Amount by Tesco = " + processor.calculateAmountByCategory("Tesco"));
		System.out.println("The most expensive from 01.02.2017 to 04.02.2017 = " + 
				processor.calculateMostExpensiveTransaction(LocalDate.of(2017, 2, 1), LocalDate.of(2017, 2, 4)));		
		System.out.println("The cheapest from 01.02.2017 to 04.02.2017 = " + 
				processor.calculateCheapestTransaction(LocalDate.of(2017, 2, 1), LocalDate.of(2017, 2, 4)));
		
//		Double total = 0d;
//		final List<String> lines = Files.readAllLines(path);
//		final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		for(int i = 0; i < lines.size(); i++) {
//			final String[] columns = lines.get(i).split(",");
//			final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
//			if(date.getMonth() == Month.JANUARY) {
//				final double amount = Double.parseDouble(columns[1]);
//				total += amount;
//			}	
//		}
		
//		System.out.println("Total: " + total);
	}

//	public static double calculateTotalAmount(final List<BankTransaction> transactions) {
//		double total = 0d;
//		
//		for(int i = 0; i < transactions.size(); i++) {
//			final double amount = transactions.get(i).getAmount();
//			total += amount;
//		}
//		
//		return total;
//	}
//	
//	public static double selectInMonth(final List<BankTransaction> transactions, final Month month) {
//		double total = 0d;
//		
//		for(int i = 0; i < transactions.size(); i++) {
//			final BankTransaction transaction = transactions.get(i);
//			if(transaction.getDate().getMonth() == month) {
//				final double amount = transaction.getAmount();
//				total += amount;
//			}
//		}
//		
//		return total;
//	}
}
