package test.program;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class MonthManipulation {
    public static void main(String[] args) {
        String inputDate = "202401";
        int monthsToAdd = -2;  // Replace this with the number of months to add or subtract (negative for subtract)

        // Parse the input string into YearMonth
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        YearMonth yearMonth = YearMonth.parse(inputDate, formatter);

        // Add or subtract months
        YearMonth resultYearMonth = yearMonth.plusMonths(monthsToAdd);

        // Format the result back to a string
        String resultDate = resultYearMonth.format(formatter);
        
        System.out.println("Original date: " + inputDate);
        System.out.println("Result date: " + resultDate);
        Long newMonth = Long.parseLong(resultDate);
        System.out.println("newMonth::: "+newMonth);
    }
}

