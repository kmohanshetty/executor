package test.program;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DateTimeUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime toUTCDateTime(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault())
                       .withZoneSameInstant(ZoneId.of("UTC"))
                       .toLocalDateTime();
    }

    public static String formatAsUTC(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }

    public static void main(String[] args) {
    	List<LocalDate> ls = new ArrayList<>();
    	for (int i = 10; i <= 31; i++) {
            ls.add(LocalDate.of(2025, 12, i));
        }
    	
        testBasicFormatter();
        test53WkGen(ls);
        test53WkNew(ls);
    }

	private static void testBasicFormatter() {
		LocalDateTime now = LocalDateTime.now();
        LocalDateTime utcDateTime = toUTCDateTime(now);

        // Display UTC date-time as LocalDateTime
        System.out.println("UTC LocalDateTime: " + utcDateTime);

        // Display formatted UTC date-time as a string
        System.out.println("Formatted UTC LocalDateTime: " + formatAsUTC(utcDateTime));
	}
    
    public static void test53WkGen(List<LocalDate> ls) {
    	
    	DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendValue(WeekFields.ISO.weekOfWeekBasedYear()).toFormatter();
    	Map<Integer, List<LocalDate>> collectWithoutSort = ls.stream().collect(Collectors.groupingBy(c -> Integer.valueOf((c.format(formatter)))));
    	
    	System.out.println(collectWithoutSort);
    	
    }
    
    static void test53WkNew(List<LocalDate> ls) {
    	WeekFields weekFields = WeekFields.ISO;

    	Map<Integer, List<LocalDate>> grouped = ls.stream()
    			.collect(Collectors.groupingBy(c -> {
    				int year = c.get(weekFields.weekBasedYear());
    				int week = c.get(weekFields.weekOfWeekBasedYear());
    				return Integer.valueOf(String.format("%d%02d", year, week));
    			}));

    	Map<Integer, List<LocalDate>> sortedGrouped = grouped.entrySet()
    			.stream()
    			.sorted(Map.Entry.comparingByKey())  // ascending order
    			.collect(Collectors.toMap(
    					Map.Entry::getKey,
    					Map.Entry::getValue,
    					(e1, e2) -> e1,               // merge function (won't happen here)
    					LinkedHashMap::new             // preserve order
    					));

    	System.out.println(sortedGrouped);
    }
}
