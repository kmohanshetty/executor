package test.program;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class SeihanWeekChecker2 {
	// Method to convert Date to Seihan week
    public static int getSeihanWeek(LocalDate date) {
        // Assuming Seihan week starts from the first Monday of the year
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return date.get(weekFields.weekOfYear());
    }

    // Check if the week is a split week (spans two months)
    public static boolean isSplitWeek(LocalDate date) {
        // Get start of the week (Monday)
        LocalDate startOfWeek = date.with(TemporalAdjusters.previousOrSame(WeekFields.of(Locale.getDefault()).getFirstDayOfWeek()));
        // Get end of the week (Sunday)
        LocalDate endOfWeek = startOfWeek.plusDays(6); 

        // Check if the start and end of the week are in different months
        if (startOfWeek.getMonthValue() != endOfWeek.getMonthValue()) {
            // If the week spans two months, we check how many days fall into each month
            int daysInStartMonth = 0;
            int daysInEndMonth = 0;
            
            // Count days in the start and end month within the week
            for (LocalDate d = startOfWeek; !d.isAfter(endOfWeek); d = d.plusDays(1)) {
                if (d.getMonthValue() == startOfWeek.getMonthValue()) {
                    daysInStartMonth++;
                } else {
                    daysInEndMonth++;
                }
            }
            
            // Only return true if the week is truly split (i.e., more than 3 days in one month and the rest in another)
            return daysInStartMonth > 0 && daysInEndMonth > 0;
        }
        return false; // If the week does not span two months
    }
    
    public static void main(String[] args) {
    	// Example 1: July 1, 2024
        LocalDate date = LocalDate.of(2024, 7, 1);
        boolean isSplit = isSplitWeek(date);
        System.out.println("Is split week for 2024-07-01: " + isSplit);  // Should be false

        // Example 2: June 30, 2024
        LocalDate date2 = LocalDate.of(2024, 6, 30);
        boolean isSplit2 = isSplitWeek(date2);
        System.out.println("Is split week for 2024-06-30: " + isSplit2);  // Should be true
    }
}
