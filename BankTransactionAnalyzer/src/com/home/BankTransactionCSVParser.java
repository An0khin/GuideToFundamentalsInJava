package com.home;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionCSVParser {
	private final static DateTimeFormatter DATE_PATTERN = 
			DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private final static int EXPECTED_ATTRIBUTES_LENGTH = 3;
	
	public BankTransaction parseFromCSV(final String line) throws CSVSyntaxException {
		final String[] columns = line.split(",");
		
		if(columns.length > EXPECTED_ATTRIBUTES_LENGTH) {
			throw new CSVSyntaxException();
		}
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		
		return new BankTransaction(date, amount, description);
	}
	
	public List<BankTransaction> parseCSV(final List<String> lines) throws CSVSyntaxException {
		final List<BankTransaction> transactions = new ArrayList<>();
		
		for(int i = 0; i < lines.size(); i++) {
			transactions.add(parseFromCSV(lines.get(i)));
		}
		
		return transactions;
	}
}
