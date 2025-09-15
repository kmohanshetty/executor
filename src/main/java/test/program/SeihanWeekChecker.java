package test.program;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class SeihanWeekChecker {

    // Method to convert Date to Seihan week
    public static int getSeihanWeek(LocalDate date) {
        // Assuming Seihan week starts from the first Monday of the year
        // Adjust logic according to Seihan week start rules if different
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return date.get(weekFields.weekOfYear());
    }

    // Check if the date falls in a split week (spans two months)
    public static boolean isSplitWeek(LocalDate date) {
        // Get the week number for the given date
        int currentWeek = getSeihanWeek(date);
        System.out.println("currentweek: "+currentWeek);
        // Check if the end of the current week falls into the next month
        LocalDate startOfWeek = date.with(TemporalAdjusters.previousOrSame(WeekFields.of(Locale.getDefault()).getFirstDayOfWeek()));
        LocalDate endOfWeek = startOfWeek.plusDays(6);  // End of the week

        // Check if start of week and end of week fall in different months
        return startOfWeek.getMonthValue() != endOfWeek.getMonthValue();
    }

    public static void main(String[] args) {
        // Example date: LocalDate for input
        LocalDate date = LocalDate.of(2024, 8, 31); // Example date

        // Check if it's a split week
        boolean isSplit = isSplitWeek(date);
        System.out.println("Is split week: " + isSplit);
    }
}

