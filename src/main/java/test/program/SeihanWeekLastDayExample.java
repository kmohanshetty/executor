package test.program;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class SeihanWeekLastDayExample {
    public static void main(String[] args) {
        // Given LocalDate (e.g., current date)
        LocalDate currentDate = LocalDate.of(2024, 10, 8);

        // Calculate the last day of the past Seihan week (Sunday)
        LocalDate lastDayOfPastWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));

        // Print the last day of the past Seihan week
        System.out.println("Last day of the past Seihan week: " + lastDayOfPastWeek);
    }
}

