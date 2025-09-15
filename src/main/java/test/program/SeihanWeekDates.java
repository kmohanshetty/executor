package test.program;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SeihanWeekDates {

    public static void main(String[] args) {
    	List<List<LocalDate>> alldatesinList = new LinkedList<>();
    	LocalDate currDate = LocalDate.of(2024, 12, 1);
    	LocalDate lastDayOfMonth = currDate.with(TemporalAdjusters.lastDayOfMonth());
    	List<String> seihanWeeks = calculateSeihanWeeks2(currDate);
    	
    	System.out.println("------->"+seihanWeeks);
    	System.out.println("lastDayOfMonth: "+lastDayOfMonth);
//        String seihanWeek = "202437"; // Example Seihan week

    	for(String week:seihanWeeks) {
    		// Get the dates for the Seihan week
    		List<LocalDate> dates = getDatesForSeihanWeek(week);
    		List<LocalDate> updDates = new ArrayList<LocalDate>();
    		for(LocalDate eachDate:dates) {
    			if(eachDate.isEqual(currDate) || 
    					(eachDate.isAfter(currDate) && ( eachDate.isEqual(lastDayOfMonth) || eachDate.isBefore(lastDayOfMonth)))) {
    				updDates.add(eachDate);
    			}
    		}
    		alldatesinList.add(updDates);
    	}
        
        // Print the dates
    	alldatesinList.forEach(date -> System.out.println(date));
    }

    public static List<LocalDate> getDatesForSeihanWeek(String seihanWeek) {
        // Extract year and week number from Seihan week
        int year = Integer.parseInt(seihanWeek.substring(0, 4));
        int week = Integer.parseInt(seihanWeek.substring(4));

        // Get the first day of the week based on ISO rules (Week starts on Monday)
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        LocalDate firstDayOfWeek = LocalDate.of(year, 1, 1)
                .with(weekFields.weekOfYear(), week)
                .with(weekFields.dayOfWeek(), 2); // Monday

        // Get all days in the week (7 days)
        return IntStream.range(0, 7)
                .mapToObj(firstDayOfWeek::plusDays)
                .collect(Collectors.toList());
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
            seihanWeeks.add(formatSeihanWeek(currentWeekStart, seihanWeekForDate));
            currentWeekStart = currentWeekStart.plusWeeks(1);
            seihanWeekForDate++;
        }

        return seihanWeeks;
    }
    
    public static String formatSeihanWeek(LocalDate weekStartDate, int seihanWeek) {
        int year = weekStartDate.getYear();
        return String.format("%d%02d", year, seihanWeek);
    }
    
    public static List<String> calculateSeihanWeeks2(LocalDate currentDate) {
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

            seihanWeeks.add(formatSeihanWeek(currentWeekStart, seihanWeekForDate));
            currentWeekStart = currentWeekStart.plusWeeks(1);
        }

        return seihanWeeks;
    }
}
