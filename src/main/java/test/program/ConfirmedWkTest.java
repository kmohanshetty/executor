package test.program;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConfirmedWkTest {
	
	public static final String YEAR_WEEK = "yyyyww";

	public static void main(String[] args) {
//		System.out.println(calculateLastWeekOfMonthOld(202012L));
//		System.out.println(calculateLastWeekOfMonth(202012L));
		System.out.println(getAllWeekNosBetween(202650, 202702));
	}
	
	public static Long calculateLastWeekOfMonth(Long confirmedWeekMonth) {
        int year = (int) (confirmedWeekMonth / 100);
        int month = (int) (confirmedWeekMonth % 100);
        // Get the last day of the given month
        LocalDate lastDayOfMonth = LocalDate.of(year, month, Month.of(month).length(Year.isLeap(year)));

        // Get ISO week number of the last day
        WeekFields weekFields = WeekFields.ISO;
        return Long.valueOf(lastDayOfMonth.get(weekFields.weekBasedYear()) * 100 + lastDayOfMonth.get(weekFields.weekOfWeekBasedYear()));
    }
	
    private static Long calculateLastWeekOfMonthOld(Long confirmedWeekMonth) {
        int confirmedYear = (int) (confirmedWeekMonth / 100);
        int confirmedMonth = (int) (confirmedWeekMonth % 100);

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, confirmedYear);
        calendar.set(Calendar.MONTH, confirmedMonth - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        LocalDateTime lastDay = LocalDateTime.of(confirmedYear, confirmedMonth, calendar.getActualMaximum(Calendar.DATE), 0, 0);
        List<Integer> days = IntStream.rangeClosed(0, 6).mapToObj(lastDay::minusDays).map(ConfirmedWkTest::getWeekNumber)
                .collect(Collectors.toList());

        Optional<Map.Entry<Integer, Long>> month = days.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        return Long.parseLong(calendar.getWeekYear() + "" + String.format("%02d", month.get().getKey()));
    }
    
    private static Integer getWeekNumber(LocalDateTime localDateTime) {
        int week = localDateTime.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        return Integer.parseInt(String.format("%02d", week));
    }
	
    public static List<Integer> getAllWeekNosBetween1(Integer startWk, Integer endWk) {
        if (startWk > endWk) {
            return new ArrayList<>();
        }
        LocalDate startDt = getFirstDayOfWeek(startWk);
        LocalDate endDt = getFirstDayOfWeek(endWk).plusDays(1);
        return startDt.datesUntil(endDt)
                .map(d -> Integer.parseInt(d.format(DateTimeFormatter.ofPattern(YEAR_WEEK)))).distinct()
                .collect(Collectors.toList());
    }
    
    public static LocalDate getFirstDayOfWeek(Integer yearWeek) {
        return LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), yearWeek / 100)
                .with(WeekFields.ISO.weekOfWeekBasedYear(), yearWeek % 100).with(WeekFields.ISO.getFirstDayOfWeek());
    }
    
    
    
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

    private static boolean isValidSeihanWeek(int yearWeek) {
        int weekBasedYear = yearWeek / 100;
        int weekOfYear = yearWeek % 100;
        int maxWeeks = getMaxWeeksInYear(weekBasedYear);
        return weekOfYear >= 1 && weekOfYear <= maxWeeks;
    }

    private static int getMaxWeeksInYear(int year) {
        return LocalDate.of(year, 12, 28).get(WeekFields.ISO.weekOfWeekBasedYear());
    }

}
