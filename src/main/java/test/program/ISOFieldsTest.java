package test.program;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

public class ISOFieldsTest {

	public static void main(String[] args) {
		firstTest();
		secondTest();
		getPrevWk();
		System.out.println("-------->>"+getWeekNumber(LocalDate.of(2020, 12, 1)));
		thirdTest(2026, 12);
		System.out.println("-:"+getWk(2026L, 01L, 52));
		System.out.println("convertDateFormatWeek: "+convertDateFormatWeek("20201231"));
		
		System.out.println("zoned: "+findSeihanMonth(ZonedDateTime.parse("2026-12-31T10:00:00+05:30[Asia/Kolkata]")));
	}

	private static void firstTest() {
		Integer Year = 2020;
		Integer Month = 12;
		LocalDate MonthFirstDay = LocalDate.now().withYear(Year).withMonth(Month).withDayOfMonth(1);
		Integer MonthLastWeek = MonthFirstDay.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		System.out.println(MonthLastWeek);
		System.out.println("--------");
		System.out.println("-->"+convertDateFormat(LocalDate.of(2026, 1, 1)));
	}
	
	public static void secondTest() {
		LocalDate MonthFirstDay = LocalDate.now().withYear(2020).withMonth(12).withDayOfMonth(1);
		System.out.println("MonthFirstDay: "+MonthFirstDay);
		LocalDate MonthLastDate = MonthFirstDay
                .withDayOfMonth(MonthFirstDay.getMonth().length(MonthFirstDay.isLeapYear()));
		System.out.println("MonthLastDate: "+MonthLastDate);
		Integer MonthLastWeek = MonthLastDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		System.out.println("MonthLastWeek: "+MonthLastWeek);
	}
	
	public static void getPrevWk() {
		int year = 2021;
		LocalDate currentWeek = LocalDate.of(year,1,1);
		Long  pastwk =Long.parseLong(year-1+""+currentWeek.get( IsoFields.WEEK_OF_WEEK_BASED_YEAR ));
		System.out.println("pastwk: "+pastwk);
	}

	private static Long convertDateFormat(LocalDate date) {
        if (date != null) {
            return Long.parseLong(date.get(IsoFields.WEEK_BASED_YEAR) + String.format("%02d", getWeekNumber(date)));
        }
        return null;
    }
	private static Integer getWeekNumber(LocalDate localDate) {
        int week = localDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        return Integer.parseInt(String.format("%02d", week));
    }
	private static void thirdTest(int Year, int month) {
		LocalDate MonthFirstDay = LocalDate.now().withYear(Year).withMonth(month).withDayOfMonth(1);
        LocalDate MonthLastDate = MonthFirstDay
                .withDayOfMonth(MonthFirstDay.getMonth().length(MonthFirstDay.isLeapYear()));
        Integer MonthLastWeek = MonthLastDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        Integer MonthStartWeek = MonthFirstDay.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        System.out.println("MonthLastWeek: "+MonthLastWeek);
        System.out.println("MonthStartWeek: "+MonthStartWeek);
	}
	
	private static Long getWk(Long year, Long wk, int weeks) {
		LocalDate date = LocalDate.now(ZoneOffset.UTC).with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, wk)
				.with(WeekFields.ISO.weekBasedYear(), year).plusWeeks(weeks);
		return (long) ((date.get(WeekFields.ISO.weekBasedYear()) * 100)
				+ date.get(WeekFields.ISO.weekOfWeekBasedYear()));
	}
	
	public static Long convertDateFormatWeek(String strDate) {
        LocalDateTime dateTime = convertToLocalDateTime(strDate);
        if (dateTime != null) {
            return Long.parseLong(dateTime.get(IsoFields.WEEK_BASED_YEAR) + String.format("%02d", getWeekNumber(dateTime)));
        }
        return null;
    }
	
	private static Integer getWeekNumber(LocalDateTime localDateTime) {
        int week = localDateTime.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        return Integer.parseInt(String.format("%02d", week));
    }
	
	public static LocalDateTime convertToLocalDateTime(String date) {
        if (date != null) {
            try {
                String strDate = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8) + " 00:00:00";
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                return LocalDateTime.parse(strDate, formatter);
            } catch (Exception ignored) {
            }
        }
        return null;
    }
	
	private static Integer findSeihanMonth(ZonedDateTime dateTime) {

        Calendar cal = GregorianCalendar.from(dateTime);
        int year = cal.getWeekYear();
        int week = dateTime.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);

        LocalDateTime firstDay = dateTime.toLocalDateTime()
                .with(WeekFields.of(Locale.UK).getFirstDayOfWeek())
                .with(WeekFields.of(Locale.UK).weekOfWeekBasedYear(), week);

        List<Integer> days = IntStream.rangeClosed(0, 6).mapToObj(firstDay::plusDays).map(LocalDateTime::getMonthValue)
                .collect(toList());

        Optional<Map.Entry<Integer, Long>> month = days.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        return Integer.parseInt(year + "" + String.format("%02d", month.get().getKey()));
    }
}
