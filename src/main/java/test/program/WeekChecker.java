package test.program;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;

public class WeekChecker {

    public static boolean isValidWeekOfYear(int year, int week) {
        if (week < 1 || week > 53) return false;

        // ISO 8601 rule: 53 weeks only if Jan 1 or Dec 31 is Thursday
        boolean has53Weeks =
                LocalDate.of(year, 1, 1).getDayOfWeek() == DayOfWeek.THURSDAY ||
                LocalDate.of(year, 12, 31).getDayOfWeek() == DayOfWeek.THURSDAY;

        return week <= 52 || (week == 53 && has53Weeks);
    }

    public static boolean isLastWeekOfMonth(int yearWeek) {
        int inputYear = yearWeek / 100;
        int week = yearWeek % 100;

        if (!isValidWeekOfYear(inputYear, week)) {
            return false;
        }

        WeekFields weekFields = WeekFields.ISO;

        // Get the first day (Monday) of the given week
        LocalDate weekStartDate = LocalDate.of(inputYear, 1, 4)
                .with(weekFields.weekOfYear(), week)
                .with(weekFields.dayOfWeek(), 1); // Monday

        int month = weekStartDate.getMonthValue();
        int actualYearOfMonth = weekStartDate.getYear(); // Could be previous year

        // Get the last day of that month
        LocalDate lastDayOfMonth = weekStartDate.withDayOfMonth(1).withDayOfMonth(weekStartDate.lengthOfMonth());

        // Get week numbers for both, relative to the actual year of the month
        int weekOfStart = weekStartDate.get(weekFields.weekOfYear());
        int weekOfLastDay = lastDayOfMonth.get(weekFields.weekOfYear());

        // Handle year wraparound (e.g., week 1 of 2025 vs week 1 of 2024)
        if (lastDayOfMonth.getYear() != inputYear) {
            // recalculate weekOfLastDay relative to its actual year
            weekOfLastDay = lastDayOfMonth.get(weekFields.weekOfYear());
        }

        return weekOfStart == weekOfLastDay;
    }

    public static void main(String[] args) {
        int[] testWeeks = {
            202501, // should be true (last week of Dec 2024)
            202553, // false
            202518, // true
            202452, // true
            202401,  // false
            202527,
            202601,
            202501,
            202701,
            202752
        };

        for (int yw : testWeeks) {
            System.out.printf("Week %d -> Last week of month? %s%n", yw, isLastWeekOfMonth(yw));
        }
    }
}





//import java.time.LocalDate;
//import java.time.Year;
//import java.time.temporal.WeekFields;
//import java.util.Locale;
//
//public class WeekChecker {
//    public static boolean isLastWeekOfMonth(int yearWeek) {
//        int year = yearWeek / 100;
//        int week = yearWeek % 100;
//
//        // Define the first day of the week according to ISO (Monday is default)
//        WeekFields weekFields = WeekFields.ISO;
//
//        // Get the first day of the given week
//        LocalDate dateInWeek = LocalDate.ofYearDay(year, 1)
//                .with(weekFields.weekOfYear(), week)
//                .with(weekFields.dayOfWeek(), 1); // Monday
//
//        int month = dateInWeek.getMonthValue();
//
//        // Get the last day of the month
//        LocalDate lastDayOfMonth = dateInWeek.withDayOfMonth(1).withDayOfMonth(dateInWeek.lengthOfMonth());
//
//        // Get the week number of the last day of the month
//        int lastWeekOfMonth = lastDayOfMonth.get(weekFields.weekOfYear());
//
//        // If the month changes between dateInWeek and lastDayOfMonth, the week might spill into the next month
//        return week == lastWeekOfMonth;
//    }
//
//    public static void main(String[] args) {
//        int testWeek = 202553;
//        System.out.println("Is last week of month: " + isLastWeekOfMonth(testWeek));
//    }
//}
