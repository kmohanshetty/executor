package test.program;

import java.time.*;
import java.time.temporal.*;

public class SplitWeekCheck {
    public static void main(String[] args) {
        LocalDate givenDate = LocalDate.of(2025, 4, 28); // Example date

        boolean isSplitWeek = isSplitWeek(givenDate);
        System.out.println("Is split week? " + isSplitWeek);
    }

    public static boolean isSplitWeek(LocalDate date) {
        LocalDate startOfWeek = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        return startOfWeek.getMonth() != endOfWeek.getMonth();
    }
}
