package chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerSimple {
	
	private static final String RESOURCES = "C:/Users/kingk/eclipse-workspace/testG/src/main/resources/bank-data-simple.csv/";
	public static void main(final String... args) throws IOException {
		
		final Path path = Paths.get(RESOURCES);
		//final Path path = Paths.get(RESOURCES + args[0]); -->기존 구문 , 에러발생, args[0] 
		final List<String> lines = Files.readAllLines(path);
		double total = 0d;
		
		for(final String line: lines) {
			final String[] columns = line.split(","); // ,로 열분리
			final double amount = Double.parseDouble(columns[1]);
			total += amount;
		}
		System.out.println("The total for all transcations is " + total);
		
		}

}
