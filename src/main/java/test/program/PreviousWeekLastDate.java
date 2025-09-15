package test.program;

import java.time.*;
import java.time.temporal.*;

public class PreviousWeekLastDate {
    public static void main(String[] args) {
        LocalDate givenDate = LocalDate.of(2025, 4, 16); // Example: 2025-04-16 (Wednesday)

        LocalDate previousWeekEnd = getPreviousWeekLastDate(givenDate);
        System.out.println("Previous week last date: " + previousWeekEnd);
    }

    public static LocalDate getPreviousWeekLastDate(LocalDate date) {
        // Move to previous week’s Sunday
        return date.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
    }
}

