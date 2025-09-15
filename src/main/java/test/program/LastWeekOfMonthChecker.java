package test.program;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class LastWeekOfMonthChecker {

    public static boolean isWeekLastOfMonth(int yyyymm, int yyyywk) {
        int monthYear = yyyymm / 100;
        int month = yyyymm % 100;

        int weekYear = yyyywk / 100;
        int week = yyyywk % 100;

        // Get last day of the given month
        LocalDate lastDayOfMonth = YearMonth.of(monthYear, month).atEndOfMonth();

        // Get Monday of the ISO week
        LocalDate weekStart = LocalDate.of(weekYear, 1, 4)  // Jan 4 ensures correct ISO year alignment
                .with(WeekFields.ISO.weekOfYear(), week)
                .with(WeekFields.ISO.dayOfWeek(), 1); // Monday

        // Check if any day from Monday to Sunday includes the last day of the month
        for (int i = 0; i < 7; i++) {
            LocalDate dateInWeek = weekStart.plusDays(i);
            if (dateInWeek.equals(lastDayOfMonth)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int yyyymm = 202504; // April 2025
        int yyyywk = 202514; // Week 14 of 2025

        boolean result = isWeekLastOfMonth(yyyymm, yyyywk);
        System.out.println("Is week " + yyyywk + " the last week of month " + yyyymm + "? " + result);
    }
}

