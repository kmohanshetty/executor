package test.program;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class SeihanMonth {

	static Date processingDate = new Date();
	
	public static void main(String[] args) {
		System.out.println(getSeihanMonth());
		
		Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.NOVEMBER, 29, 15, 30, 0); // Year, Month, Day, Hour, Minute, Second
        Date date = calendar.getTime();
        processingDate = date;
        System.out.println(getSeihanMonth());
	}
	
	public static Integer getSeihanMonth() {
        LocalDate seihanWeek = processingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return seihanWeek.getMonthValue();
    }

}
