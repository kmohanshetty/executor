package test.program;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FiftyThreeTest {

	public static void main(String[] args) {
//		System.out.println(getEndWeek(202552, 53));
//		for(int i = 2019;i<2119;i++) {
////			System.out.println("year: "+i+" "+getWeeksInCurrentSeihanYearOrig(i, LocalDate.of(i,12,31)));
//            System.out.println("year: "+i+" "+getMaxWeekOfYear(i));
//        }
		//duplicateKeyException();
		System.out.println("me me:"+convertDateFormatWeek("20200821"));
		
//		Set<Integer> weekNumbersBetween = getAllWeekNumbersBetween(LocalDate.of(2019, 12, 31), 53);
//		for(Integer wk : weekNumbersBetween)
//			System.out.println(wk);
//		System.out.println(":: "+convertDateFormatWeek(LocalDateTime.of(2020, 12, 31, 10, 30) ));
//		System.out.println(">> "+getWeekNumber(LocalDateTime.of(2021, 12, 31, 10, 30)));
//		System.out.println(":: "+getDateFormat(LocalDateTime.of(2020, 12, 31, 10, 30))); 
//		System.out.println(">> "+toUTCDateTime(LocalDateTime.of(2020, 12, 31, 10, 30)));
//		System.out.println("FD>> "+getFirstDayOfWeek(202152));
		System.out.println("RSW>> "+getRSWWithFirstDayOfWeek("202012"));
		System.out.println("getWk>> "+getWk(2020L, 1L, 52));
	}
	
	private static Long getWk(Long year, Long wk, int weeks) {
		LocalDate date = LocalDate.now(ZoneOffset.UTC).with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, wk)
				.with(WeekFields.ISO.weekBasedYear(), year).plusWeeks(weeks);
		return (long) ((date.get(WeekFields.ISO.weekBasedYear()) * 100)
				+ date.get(WeekFields.ISO.weekOfWeekBasedYear()));
	}
	
	public static String getRSWWithFirstDayOfWeek(String rsw){
        StringBuilder wkformat= new StringBuilder("WK");
        wkformat.append(rsw.substring(4)).append(" ").append(getFirstDayOfWeek(Integer.parseInt(rsw)));
        return wkformat.toString();
    }

    public static String formatDate(LocalDate ld,String dateFormat) {
        return  ld.format(DateTimeFormatter.ofPattern(dateFormat));
    }

    public static LocalDate  getNextSaturdayDayofWeek(LocalDate ld){
        return ld.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
    }
	
	public static String getFirstDayOfWeek(Integer week) {
        return  LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), week / 100)
                .with(WeekFields.ISO.weekOfWeekBasedYear(), week % 100)
                .with(WeekFields.ISO.getFirstDayOfWeek())
                .format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
	
	private static String getDateFormat(LocalDateTime date) {
        return date != null ? date.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd")) : "";
    }
	
	public static LocalDateTime toUTCDateTime(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
    }
	
	private Integer findSeihanMonth(ZonedDateTime dateTime) {

        Calendar cal = GregorianCalendar.from(dateTime);
        int year = cal.getWeekYear();
        int week = dateTime.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);

        LocalDateTime firstDay = dateTime.toLocalDateTime()
                .with(WeekFields.of(Locale.UK).getFirstDayOfWeek())
                .with(WeekFields.of(Locale.UK).weekOfWeekBasedYear(), week);

        List<Integer> days = IntStream.rangeClosed(0, 6).mapToObj(firstDay::plusDays).map(LocalDateTime::getMonthValue)
                .collect(Collectors.toList());

        Optional<Map.Entry<Integer, Long>> month = days.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        return Integer.parseInt(year + "" + String.format("%02d", month.get().getKey()));
    }
	
	
	public static Long convertDateFormatWeek(LocalDateTime localDateTime) {
        return Long.parseLong(localDateTime.get(IsoFields.WEEK_BASED_YEAR) + String.format("%02d", getWeekNumber(localDateTime)));
    }
	
	public static Set<Integer> getAllWeekNumbersBetween(LocalDate fromWeek, Integer addWeeks) {
        Set<Integer> dates = new LinkedHashSet<>();
        for (int add = 0; add <= addWeeks; add++) {
            LocalDate date = fromWeek.plusWeeks(add);
            dates.add(date.get(IsoFields.WEEK_BASED_YEAR) * 100 +
                    Integer.parseInt(String.format("%02d", date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR))));
        }
        return new LinkedHashSet<>(dates);
    }
	
	public static Long convertDateFormatWeek(String strDate) {
        LocalDateTime dateTime = convertToLocalDateTime(strDate);
        if (dateTime != null) {
            return Long.parseLong(dateTime.get(IsoFields.WEEK_BASED_YEAR) + String.format("%02d", getWeekNumber(dateTime)));
        }
        return null;
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
	private static Integer getWeekNumber(LocalDateTime localDateTime) {
        int week = localDateTime.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        return Integer.parseInt(String.format("%02d", week));
    }

	private static void duplicateKeyException() {
		List<MyObject> list = Arrays.asList(
			    new MyObject("key1", "value1"),
			    new MyObject("key2", "value2"),
			    new MyObject("key2", "value3") // Duplicate key
			);

		Map<String, String> map = list.stream()
			    .collect(Collectors.toMap(
			        item -> item.getKey(),  // Key function
			        item -> item.getValue() // Value function
			    ));
	}
	
	public static long getMaxWeekOfYear(int year){
        LocalDate localDate = LocalDate.of(year, 1, 1).with(WeekFields.ISO.weekBasedYear(), year);
        return Integer.parseInt(year+""+localDate.range(WeekFields.ISO.weekOfWeekBasedYear()).getMaximum());
    }
	
	public static long getWeeksInCurrentSeihanYearOrig(int currentSeihanYear, LocalDate currentSehanYearlastDay) {
        long weeksInCurrentSeihanYear = Long.parseLong(currentSeihanYear +""+ IsoFields.WEEK_OF_WEEK_BASED_YEAR.rangeRefinedBy(currentSehanYearlastDay).getMaximum());
        return weeksInCurrentSeihanYear;
    }
	
	public static long getWeeksInCurrentSeihanYear(int currentSeihanYear, LocalDate currentSehanYearLastDay) {
        // Get the first day of the year
        LocalDate firstDayOfYear = LocalDate.of(currentSeihanYear, 1, 1);

        // Check if the year has 53 weeks based on Seihan rules
        boolean has53Weeks = firstDayOfYear.getDayOfWeek() == DayOfWeek.THURSDAY ||
                currentSehanYearLastDay.getDayOfWeek() == DayOfWeek.THURSDAY;

        // Return the correct Seihan week count
        return Long.parseLong(currentSeihanYear + "" + (has53Weeks ? 53 : 52));
    }
	
	public static Long getEndWeek(Integer seihanWeek, int weekRange) {
        long year = seihanWeek / 100;
        long wk = seihanWeek % 100;
        LocalDate date = LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), year).with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, wk).plusWeeks(weekRange);
        return (long) ((date.get(WeekFields.ISO.weekBasedYear()) * 100)+ date.get(WeekFields.ISO.weekOfWeekBasedYear()));
    }

}

class MyObject {
    private String key;
    private String value;

    // Constructor
    public MyObject(String key, String value) {
        this.key = key;
        this.value = value;
    }

    // Getters
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MyObject{" +
               "key='" + key + '\'' +
               ", value='" + value + '\'' +
               '}';
    }
}

