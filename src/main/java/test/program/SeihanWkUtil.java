package test.program;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;

public class SeihanWkUtil {

    public static List<Integer> getAllWeekNosBetween(Integer startWk, Integer endWk) {
        if (!isValidSeihanWeek(startWk) || !isValidSeihanWeek(endWk) || startWk > endWk) {
            return new ArrayList<>();
        }

        List<Integer> weeks = new ArrayList<>();
        int currentWk = startWk;

        while (currentWk <= endWk) {
            weeks.add(currentWk);
            currentWk = getNextWeek(currentWk);
        }

        return weeks;
    }

    private static int getNextWeek(int yearWeek) {
        int weekBasedYear = yearWeek / 100;
        int weekOfYear = yearWeek % 100;

        LocalDate firstDayOfWeek = getFirstDayOfWeek(yearWeek);
        int maxWeeks = getMaxWeeksInYear(weekBasedYear);

        if (weekOfYear < maxWeeks) {
            return (weekBasedYear * 100) + (weekOfYear + 1);
        } else {
            return ((weekBasedYear + 1) * 100) + 1; // Move to Week 1 of next year
        }
    }

//    public static LocalDate getFirstDayOfWeek(Integer yearWeek) {
//        int weekBasedYear = yearWeek / 100;
//        int weekOfYear = yearWeek % 100;
//
//        return LocalDate.of(weekBasedYear, 1, 4)  // Jan 4 ensures correct ISO week year
//                .with(WeekFields.ISO.weekBasedYear(), weekBasedYear)
//                .with(WeekFields.ISO.weekOfWeekBasedYear(), weekOfYear)
//                .with(WeekFields.ISO.getFirstDayOfWeek());
//    }
    public static LocalDate getFirstDayOfWeek(Integer yearWeek) {
        return LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), yearWeek / 100)
                .with(WeekFields.ISO.weekOfWeekBasedYear(), yearWeek % 100).with(WeekFields.ISO.getFirstDayOfWeek());
    }

    private static boolean isValidSeihanWeek(int yearWeek) {
        int weekBasedYear = yearWeek / 100;
        int weekOfYear = yearWeek % 100;
        int maxWeeks = getMaxWeeksInYear(weekBasedYear);
        return weekOfYear >= 1 && weekOfYear <= maxWeeks;
    }

    private static int getMaxWeeksInYear(int year) {
        return LocalDate.of(year, 12, 28).get(WeekFields.ISO.weekOfWeekBasedYear());
    }

    public static void main(String[] args) {
        System.out.println(getAllWeekNosBetween(202601, 202701)); // ✅ [202653, 202701]
        System.out.println(getAllWeekNosBetween(202450, 202501)); // ✅ [202452, 202453, 202501]
        System.out.println(getAllWeekNosBetween(202399, 202400)); // ✅ [] (Invalid)
        System.out.println(getAllWeekNosBetween(202049, 202103));
    }
}

