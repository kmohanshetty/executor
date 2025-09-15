package test.program;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class SeihanWeekCheck {

    public static void main(String[] args) {
        // Seihan week in "YYYYWW" format
        String seihanWeek = "202437"; // Example: 202437 means 37th week of 2024

        // Date to check
        LocalDate dateToCheck = LocalDate.of(2024, 9, 10); // Example date to check

        // Check if the date falls within the Seihan week
        boolean result = isDateInSeihanWeek(seihanWeek, dateToCheck);
        
        System.out.println("Does the date " + dateToCheck + " fall in Seihan week " + seihanWeek + "? " + result);
    }

    public static boolean isDateInSeihanWeek(String seihanWeek, LocalDate dateToCheck) {
        // Parse the year and week number from the Seihan week string
        int year = Integer.parseInt(seihanWeek.substring(0, 4));
        int week = Integer.parseInt(seihanWeek.substring(4, 6));
        
        // Get the first day of the week based on the Seihan week
        LocalDate startOfWeek = LocalDate.now()
                .withYear(year)
                .with(WeekFields.of(Locale.getDefault()).weekOfYear(), week)
                .with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1); // Start of the week (Monday)
        
        // End of the week (Sunday)
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        
        // Check if the dateToCheck falls within the week
        return !dateToCheck.isBefore(startOfWeek) && !dateToCheck.isAfter(endOfWeek);
    }
}

