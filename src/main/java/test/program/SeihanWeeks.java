package test.program;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SeihanWeeks {
	public static void main(String[] args) {
//		approach1();
//		approach2();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		List<String> seihanWeeks = calculateSeihanWeeks(LocalDate.parse("15-02-2024", dateFormat));
		seihanWeeks.forEach((s)->System.out.println(s));
	}
	private static void approach2() {
		String seihanMonth = "202402";     	
		List<String> weeks = new ArrayList<>();

		// Parse year and month from seihanMonth (YYYYMM)
		int year = Integer.parseInt(seihanMonth.substring(0, 4));
		int month = Integer.parseInt(seihanMonth.substring(4, 6));

		// Get the first day of the given month
		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);

		// Get the locale-specific WeekFields (ISO week rules by default)
		WeekFields weekFields = WeekFields.of(Locale.getDefault());

		// Get the starting week number of the year
		//int startWeek = firstDayOfMonth.get(weekFields.weekOfWeekBasedYear());

		// Loop through the days of the month to generate SEIHAN weeks
		LocalDate currentDate = firstDayOfMonth;
		while (currentDate.getMonthValue() == month) {
			int currentWeek = currentDate.get(weekFields.weekOfWeekBasedYear());

			// Ensure we only add new weeks (skip duplicates)
			if (!weeks.contains(year + String.format("%02d", currentWeek))) {
				weeks.add(year + String.format("%02d", currentWeek));
			}

			// Move to the next week
			currentDate = currentDate.plusWeeks(1);
		}
		weeks.forEach((str)->System.out.println(str));
	}

	private static void approach1() {
		// Example input: 202409 (September 2024)
		int year = 2024;
		int month = 9;

		// Get the first and last day of the month
		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());

		// Get the week fields based on ISO-8601, Monday as the first day of the week
		WeekFields weekFields = WeekFields.ISO;

		System.out.println("SEIHAN Weeks for " + firstDayOfMonth.getMonth() + " " + year + ":");

		// Start with the first Monday of the month
		LocalDate firstMonday = firstDayOfMonth.with(DayOfWeek.MONDAY);
		if (firstMonday.isBefore(firstDayOfMonth)) {
			firstMonday = firstMonday.plusWeeks(1);
		}

		// Iterate through each Monday in the month and calculate the week numbers
		for (LocalDate date = firstMonday; !date.isAfter(lastDayOfMonth); date = date.plusWeeks(1)) {
			int weekNumber = date.get(weekFields.weekOfWeekBasedYear()); // ISO week number
			String formattedWeek = String.format("%04d%02d", year, weekNumber); // Format as YYYYWW
			System.out.println("Monday: " + date + " => SEIHAN Week: " + formattedWeek);
		}
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
}
