package chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class BankTransactionAnalyzerAccordingDate {
	//private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
	
	// public static void main(final String... arg) throws IOException {
	
	public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
		//final String fileName = args[0];
			final Path path = Paths.get("C:","Users","kingk","eclipse-workspace","testG","src","main","resources","bank-data-simple.csv");
			final List<String> lines = Files.readAllLines(path);
			
			final List<BankTransaction> bankTransactions = bankStatementParser
					.parseLinesFrom(lines);
			final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
			
			collectSummary(bankStatementProcessor);
		}
	
	
	//} 
	
	private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
		System.out.println("The total all transaction is " + bankStatementProcessor.calculateTotalAmount());
		System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("The total for transaction in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
		
	}
	
	
	/*public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		double total = 0d;
		for(final BankTransaction bankTransaction: bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}
	
	public static List<BankTransaction> selectInMonth(final List<BankTransaction>
	bankTransactions, final Month month) {
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
		for(final BankTransaction bankTransaction: bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}
		}
		return bankTransactionsInMonth;
	}*/
	
}

