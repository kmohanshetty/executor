package test.program;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class SeihanSplitWeekChecker {

    public static void main(String[] args) {
        // Example Seihan week: 202435
        String seihanWeek = "202441";

        // Check if the Seihan week is a split week
        boolean isSplitWeek = isSeihanWeekSplitWeek(seihanWeek);

        System.out.println("Is Seihan week " + seihanWeek + " a split week? " + isSplitWeek);
    }

    public static boolean isSeihanWeekSplitWeek(String seihanWeek) {
        // Parse year and week number from the Seihan week string
        int year = Integer.parseInt(seihanWeek.substring(0, 4));
        int week = Integer.parseInt(seihanWeek.substring(4, 6));
        
        // Define the first day of the week as Monday (ISO standard)
        WeekFields weekFields = WeekFields.ISO;

        // Calculate the start of the week (Monday)
        LocalDate startOfWeek = LocalDate.of(year, 1, 1)
                .with(weekFields.weekOfYear(), week)
                .with(weekFields.dayOfWeek(), 1); // 1 = Monday
        
        // Calculate the end of the week (Sunday)
        LocalDate endOfWeek = startOfWeek.plusDays(6);

        // Check if the start and end of the week fall in different months
        return startOfWeek.getMonth() != endOfWeek.getMonth();
    }
}


