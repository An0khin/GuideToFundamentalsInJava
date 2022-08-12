package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.home.BankTransaction;
import com.home.BankTransactionCSVParser;
import com.home.CSVSyntaxException;

public class BankTransactionCSVParserTest {
	final BankTransactionCSVParser parser =
			new BankTransactionCSVParser();
	
	@Test
	public void parseFromCSVTest() {
		final String line = "01-01-2008,5400,Test";
		
		final BankTransaction expected = new BankTransaction(
				LocalDate.of(2008, 1, 1),
				5400d,
				"Test");
		
		try {
			assertEquals(expected, parser.parseFromCSV(line));
		} catch (CSVSyntaxException e) {
			e.printStackTrace();
		}
	}
}
