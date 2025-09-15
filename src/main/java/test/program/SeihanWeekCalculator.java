package test.program;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class SeihanWeekCalculator {

    public static String getSeihanWeek(LocalDate date) {
        // Ensure the week starts on Monday
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        LocalDate adjustedDate = date;

        // Adjust the date if it's Sunday to count it in the previous week
        if (date.getDayOfWeek().getValue() == 7) {
            adjustedDate = date.minusDays(1);
        }

        // Get the year and week number based on adjusted date
        int year = adjustedDate.getYear();
        int weekOfYear = adjustedDate.get(weekFields.weekOfYear());

        // Format the Seihan week as YYYYWW (e.g., 202436)
        return String.format("%d%02d", year, weekOfYear);
    }

    public static void main(String[] args) {
        // Example with a date falling on Sunday, September 8, 2024
        LocalDate date = LocalDate.of(2024, 9, 9); // This is a Sunday
        String seihanWeek = getSeihanWeek(date);
        System.out.println("Seihan week: " + seihanWeek); // Expected: 202436
    }
}

