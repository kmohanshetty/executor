package test.program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

	public static void main(String[] args) {
		String inputDate = "20230403";
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MMM-dd");

		LocalDate date = LocalDate.parse(inputDate, inputFormat);
		String formattedDate = date.format(outputFormat);
		System.out.println(inputDate+" to "+formattedDate);
	}

}
