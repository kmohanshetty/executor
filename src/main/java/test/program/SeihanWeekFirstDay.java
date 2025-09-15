package test.program;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class SeihanWeekFirstDay {
    public static void main(String[] args) {
        String seihanWeek = "202441"; // Example Seihan week
        
        // Extract year and week number
        int year = Integer.parseInt(seihanWeek.substring(0, 4));
        int week = Integer.parseInt(seihanWeek.substring(4));

        // Set Monday as the first day of the week using WeekFields (ISO, Monday as first day)
        WeekFields weekFields = WeekFields.ISO;
        
        // Get the first day of the given week in the year, starting on Monday
        LocalDate firstDayOfWeek = LocalDate.of(year, 1, 1)
                .with(weekFields.weekOfYear(), week)
                .with(weekFields.dayOfWeek(), 1);  // '1' for Monday
        
        System.out.println("First day of Seihan week " + seihanWeek + " is: " + firstDayOfWeek);
    }
}


