package test.program;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;

public class DateChecker {

    public static void main(String[] args) {
        // Example: LocalDate for July 1, 2024
        LocalDate date = LocalDate.of(2024, 9, 3);
        
//        checkIfTuesdayAndNotFirstDayOfMonth(date);
        check();
    }

	private static void checkIfTuesdayAndNotFirstDayOfMonth(LocalDate date) {
		// Check if the date is a Tuesday
        boolean isTuesday = date.getDayOfWeek() == DayOfWeek.TUESDAY;
        
        // Check if the date is not the first day of the month
        boolean isNotFirstDayOfMonth = date.getDayOfMonth() != 1;

        // Combine both conditions
        if (isTuesday && isNotFirstDayOfMonth) {
            System.out.println(date + " is a Tuesday and is not the first day of the month.");
        } else if (isTuesday) {
            System.out.println(date + " is a Tuesday, but it is the first day of the month.");
        } else {
            System.out.println(date + " is not a Tuesday.");
        }
	}
	
	private static void check() {
		// The given date: September 3, 2024
        LocalDate givenDate = LocalDate.of(2024, 9, 3);
        
        // 1. Check if the given date is Tuesday
        boolean isTuesday = givenDate.getDayOfWeek() == DayOfWeek.TUESDAY;
        
        // 2. Check if Tuesday is not the 1st day of the month
        boolean isTuesdayNotFirstDay = isTuesday && givenDate.getDayOfMonth() != 1;
        
        // 3. Check if the previous week is a split week
        // Previous Monday
        LocalDate previousMonday = givenDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        // Previous Sunday
        LocalDate previousSunday = previousMonday.plusDays(6);
        
        // Check if the previous week crosses months (split week)
        boolean isPreviousWeekSplit = previousMonday.getMonthValue() != previousSunday.getMonthValue();
        
        // Output the results
        System.out.println("Given date: " + givenDate);
        System.out.println("Is the given day Tuesday? " + isTuesday);
        System.out.println("Is Tuesday not the 1st day of the month? " + isTuesdayNotFirstDay);
        System.out.println("Previous Monday: " + previousMonday);
        System.out.println("Previous Sunday: " + previousSunday);
        System.out.println("Does the previous week fall in a split week? " + isPreviousWeekSplit);



	}
}

