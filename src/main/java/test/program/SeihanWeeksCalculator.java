package test.program;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SeihanWeeksCalculator {

    public static List<String> calculateSeihanWeeksNew(LocalDate currentDate) {
        List<String> seihanWeeks = new ArrayList<>();

        // Get the first Monday of the year
        LocalDate firstMondayOfYear = LocalDate.of(currentDate.getYear(), 1, 1);
        while (firstMondayOfYear.getDayOfWeek() != java.time.DayOfWeek.MONDAY) {
            firstMondayOfYear = firstMondayOfYear.plusDays(1);
        }

        // Get the last day of the current month
        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());

        // Iterate through weeks till the end of the month
        LocalDate currentWeekStart = currentDate.with(java.time.DayOfWeek.MONDAY);

        while (!currentWeekStart.isAfter(lastDayOfMonth)) {
            // Calculate the Seihan week number manually from the first Monday of the year
            long daysSinceFirstMonday = java.time.temporal.ChronoUnit.DAYS.between(firstMondayOfYear, currentWeekStart);
            int seihanWeekForDate = (int) (daysSinceFirstMonday / 7) + 1;

            seihanWeeks.add(formatSeihanWeekOld(currentWeekStart, seihanWeekForDate));
            currentWeekStart = currentWeekStart.plusWeeks(1);
        }

        return seihanWeeks;
    }

    // Format method to generate the string representation of Seihan week
    private static String formatSeihanWeek(LocalDate currentWeekStart, int seihanWeekForDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "Week " + seihanWeekForDate + " starting " + currentWeekStart.format(formatter);
    }
    
    
    
    public static List<String> calculateSeihanWeeks(LocalDate currentDate) {
        List<String> seihanWeeks = new ArrayList<>();

        // Get the first Monday of the year
        LocalDate firstMondayOfYear = LocalDate.of(currentDate.getYear(), 1, 1);
        while (firstMondayOfYear.getDayOfWeek() != DayOfWeek.MONDAY) {
            firstMondayOfYear = firstMondayOfYear.plusDays(1);
        }

        // Find the Seihan week number for the current date
        long daysSinceFirstMonday = java.time.temporal.ChronoUnit.DAYS.between(firstMondayOfYear, currentDate);
        int seihanWeekForDate = (int) (daysSinceFirstMonday / 7) + 1; // Seihan week starts at 1

        // Get the last day of the current month
        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());

        // Iterate through weeks till the end of the month
        LocalDate currentWeekStart = currentDate;
        while (!currentWeekStart.isAfter(lastDayOfMonth)) {
            seihanWeeks.add(formatSeihanWeekOld(currentWeekStart, seihanWeekForDate));
            currentWeekStart = currentWeekStart.plusWeeks(1);
            seihanWeekForDate++;
        }

        return seihanWeeks;
    }

    public static String formatSeihanWeekOld(LocalDate weekStartDate, int seihanWeek) {
        int year = weekStartDate.getYear();
        return String.format("%d%02d", year, seihanWeek);
    }    
    

    public static void main(String[] args) {
        List<String> weeks = calculateSeihanWeeksNew(LocalDate.of(2024, 12, 1));
        weeks.forEach(System.out::println);
    }
}


