package test.program;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

public class SeihanWeekUtil {

    public static void main(String[] args) {
        Date inputDate = new Date(); // Or any given java.util.Date
        String seihanWeek = getSeihanWeek(inputDate);
        System.out.println("Seihan week: " + seihanWeek);
    }

    public static String getSeihanWeek(Date date) {
        // Convert java.util.Date to LocalDate
        LocalDate localDate = date.toInstant()
                                  .atZone(ZoneId.systemDefault())
                                  .toLocalDate();

        // Define week fields as ISO (Monday as first day of week)
        WeekFields weekFields = WeekFields.ISO;
        int weekNumber = localDate.get(weekFields.weekOfWeekBasedYear());
        int year = localDate.get(weekFields.weekBasedYear());

        // Format YYYYWK (like 202518)
        return String.format("%d%02d", year, weekNumber);
    }
}

