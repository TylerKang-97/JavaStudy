package chapter2;

import java.io.IOException;

public class MainApplication {
	public static void main(final String... args) throws IOException {
		final BankTransactionAnalyzerAccordingDate bankTransactionAnalyzerAccordingDate = new BankTransactionAnalyzerAccordingDate();
		
		final BankStatementParser bankStatementParser = new BankStatementCSVParser();
		
		bankTransactionAnalyzerAccordingDate.analyze("bank-data-simple.csv", bankStatementParser);
	}
}
