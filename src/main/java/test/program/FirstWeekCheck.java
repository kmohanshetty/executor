package test.program;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstWeekCheck {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2025, 4, 2); // Example date

        boolean isFirstWeek = isFirstWeekOfMonth(date);
        System.out.println("Is first week of month? " + isFirstWeek);
        
        
        LocalDate firstOfMonth = LocalDate.of(2025, 4, 29);

        List<LocalDate> weekDates = getWeekDatesInSameMonth(firstOfMonth);

        System.out.println("Dates in week starting from 1st of month (excluding previous month dates):");
        weekDates.forEach(System.out::println);
    }

    public static boolean isFirstWeekOfMonth(LocalDate date) {
    	WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekOfMonth = date.get(weekFields.weekOfMonth());
        return weekOfMonth == 1;
    }
    
    public static List<LocalDate> getWeekDatesInSameMonth(LocalDate date) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        LocalDate startOfWeek = date.with(weekFields.dayOfWeek(), 1);

        Month inputMonth = date.getMonth();

        return Stream.iterate(startOfWeek, d -> d.plusDays(1))
                .limit(7)
                .filter(d -> d.getMonth().equals(inputMonth))
                .collect(Collectors.toList());
    }
}
