package test.program;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.sony.gsois.sellinfct.domain.SalesCompany;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static final String YEAR_MONTH_DATE_TIME="yyyyMMddHHmm";
	public static final String YEAR_MONTH_DATE ="yyyyMMdd";
    public static void main(String[] args) {
//    	Date dt = new Date(1738760400000L);
//    	System.out.println("dt: "+dt);
    	//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
     //  System.out.println(addWeeksToYearWk(202505,52) );

     //   System.out.println(getEndWeek(202505,52) );

    //    System.out.println(getEndWeek(202505,52) );

//        System.out.println(getWeeksFromNow(202505) );
//
//        System.out.println(getWeeksFromNowOld(202505) );
//
//        System.out.println(addWeeksToYearWk(202505, 52) );
//        System.out.println(":: "+isDateBetweenWeeks(LocalDate.of(2020, 12, 31),202052L, 51 ));
//    	System.out.println(":: "+isDateBetweenMonths(LocalDate.of(2020, 12, 31),202001L, 11 ));
//    	Calendar calendar1 = Calendar.getInstance();
//    	calendar1.set(2020, Calendar.MARCH, 9, 0, 0, 0);
//    	calendar1.set(Calendar.MILLISECOND, 0);
//    	
//    	Calendar calendar2 = Calendar.getInstance();
//    	calendar2.set(2021, Calendar.MARCH, 9, 0, 0, 0);
//    	calendar2.set(Calendar.MILLISECOND, 0);
////    	
//    	System.out.println(":: "+isDateBetween(LocalDateTime.of(2020, 12, 31, 0, 0),calendar1.getTime(), calendar2.getTime() ));
//    	System.out.println(getFirstPerfectWeek(202509));
//    	System.out.println(getFirstPureWeek("202108"));
//    	System.out.println(getInitialFinalShipWeek(LocalDate.of(2021, 12, 31)));
//    	System.out.println(getEndWeek(202150,3));
//    	System.out.println(convertDateFormatWeek(LocalDateTime.of(2021, 12, 31, 0, 0)));
//    	System.out.println(convertYearWeekToYearMonth(202134));
//    	System.out.println(getDatesForSeihanWeek_OLD("202053"));
//    	System.out.println(getDatesForSeihanWeek("202053"));
//    	System.out.println(getSeihanWeekOld(LocalDate.of(2020, 12, 31)));//====>TODO
//    	System.out.println(getSeihanWeekOld(LocalDate.of(2019, 12, 31)));//====>TODO
//    	System.out.println(getSeihanWeekOld(LocalDate.of(2025, 12, 31)));//====>TODO
//    	System.out.println(getSeihanWeekOld(LocalDate.of(2028, 01, 01)));//====>TODO
//    	System.out.println();
//    	System.out.println(getSeihanWeekSimple(LocalDate.of(2020, 12, 31)));//====>TODO
//    	System.out.println(getSeihanWeekSimple(LocalDate.of(2019, 12, 31)));//====>TODO
//    	System.out.println(getSeihanWeekSimple(LocalDate.of(2025, 12, 31)));//====>TODO
//    	System.out.println(getSeihanWeekSimple(LocalDate.of(2028, 01, 01)));//====>TODO
//    	System.out.println();
//    	System.out.println();
//    	System.out.println(addWeeksToSeihanWeek(202152, 1));
//    	System.out.println(addWeeksToSeihanWeek2(202552, 3));
//    	System.out.println(addMonthsToProcessingDate(202012, 1));
    	
//        System.out.println(convertToLocalDateTime("202012311212","MK"));
    	
//    	System.out.println(getAllWeekNumbersBetween(202640, 20));
    	
//    	System.out.println(getAllMonthNumbersBetween(LocalDate.of(2020, 10, 1), 3));
//    	System.out.println(getFirstDayOfWeekScorp(202153));
//        
////        getRSWWithFirstDayOfWeek();
//        System.out.println("now: "+getYearWkForDate(LocalDateTime.now()));
//        System.out.println("--> "+getWeekNumber(LocalDate.of(2025, 12, 31)));
//        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.MARCH, 9, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        SalesCompany company = new SalesCompany();
        company.setCompCode("260600");
        company.setCompName("mk company");
        company.setSeihanMonth(202412);
        company.setSeihanWeek(202549);
        company.setProcessingDate(calendar.getTime());
        company.setCompShortName("SEU D2C Central Planning SKW0");
        company.setEmailDistributionList("GISC-GSOIS-TEAM@sony.com");
        company.setDefaultFdc("TLB");
//        
        List<Long> wkFromCurrMon = generateWkFromCurrMon(company);
        
        for(Long val:wkFromCurrMon) {
        	System.out.println("val: "+val);
        }
//        
//        List<Long> wksInCurMon = generateWksInCurMon(company);
//        wksInCurMon.forEach(p -> System.out.println("new val:"+p));
//        
//        List<String> seihanWeeks = calculateSeihanWeeksNew(LocalDate.of(2025, 04, 01));
//        List<String> seihanWeeks = calculateSeihanWeeks(LocalDate.of(2025, 12, 31));
//        
//        seihanWeeks.forEach(p -> System.out.println("seih: "+p));
//        
//    	List<LocalDate> seihanWeek1 = getDatesForSeihanWeekOld("202053");
//    	System.out.println(seihanWeek1);
//        seihanWeek1.forEach(p -> System.out.println("seih-dts: "+p));
    	
//        List<LocalDate> seihanWeek2 = getDatesForSeihanWeek("202053");
//        System.out.println(seihanWeek2);
//        seihanWeek2.forEach(p -> System.out.println("seih-dts: "+p));
//        
//        System.out.println(getSeiha-nWeek(LocalDate.of(2021, 12, 31)));
//        System.out.println(addWeeks(202152L, 1));
//        
//        System.out.println(getPrevSeihanWk("202155"));
//        System.out.println(getSeihanProcessingMonth());
//    	System.out.println(getFirstMonthLastWeekLastDaysCount(LocalDate.of(2024, 12, 20)));
//    	System.out.println(getFirstDayOfWeekFSMC(202053));
//    	System.out.println(addWeeksFSMC(202052L,1));
//    	System.out.println(getWeekNumberFSMC(LocalDateTime.of(2021, 12, 31, 0, 0)));
//    	ZonedDateTime zonedDateTime = ZonedDateTime.of(2021, 12, 5, 15, 30, 0, 0, ZoneId.of("America/New_York"));
//    	System.out.println("seihanmon: "+findSeihanMonth(zonedDateTime));
//    	System.out.println("seihanmon: "+findSeihanMonth2(zonedDateTime));
//    	System.out.println(convertLocalDateToYearWeek(LocalDate.of(2026, 12, 31)));
//    	List<Long> allWeekNumbersFromFSMC = getAllWeekNumbersFromFSMC(202650,4L);
//    	List<Long> allWeekNumbersFromFSMC = getAllWeekNumbersFrom(202950,4L);
//    	allWeekNumbersFromFSMC.forEach(p -> System.out.println(p));
//    	System.out.println(addWeeksToYearWkFSMC(202552, 1));
//    	List<Integer> numbersBetween = getAllWeekNumbersBetween(202650, 4);
//    	numbersBetween.forEach(p -> System.out.println(":: "+p));
//    	LocalDate MonthFirstDay = LocalDate.now().withYear(2020).withMonth(11).withDayOfMonth(1);
//    	LocalDate MonthLastDate = MonthFirstDay
//                .withDayOfMonth(MonthFirstDay.getMonth().length(MonthFirstDay.isLeapYear()));
//    	System.out.println(MonthLastDate);
//    	System.out.println(getFirstDayOfWeek(202653));
//    	System.out.println(getAllWeekNosBetweenOld(202650, 202702));
//    	System.out.println(SeihanWkUtil.getAllWeekNosBetween(202650, 202702));
//    	System.out.println(calculateLastWeekOfMonthOld(202911L));
//    	System.out.println(calculateLastWeekOfMonth(202911L));
//    	
//    	System.out.println(calculateLastWeekOfMonthOld(202512L));
//    	System.out.println(calculateLastWeekOfMonth(202512L));
//    	
//    	System.out.println(calculateLastWeekOfMonthOld(202012L));
//    	System.out.println(calculateLastWeekOfMonth(202012L));
//    	
//    	System.out.println(calculateLastWeekOfMonthOld(202912L));
//    	System.out.println(calculateLastWeekOfMonth(202912L));
//    	
//    	System.out.println(calculateLastWeekOfMonthOld(202312L));
//    	System.out.println(calculateLastWeekOfMonthOld(202412L));
//    	System.out.println(calculateLastWeekOfMonthOld(202512L));
//    	System.out.println(calculateLastWeekOfMonthOld(202612L));
//    	System.out.println(calculateLastWeekOfMonthOld(202712L));
//    	System.out.println();
//    	System.out.println(calculateLastWeekOfMonth(202312L));
//    	System.out.println(calculateLastWeekOfMonth(202412L));
//    	System.out.println(calculateLastWeekOfMonth(202512L));
//    	System.out.println(calculateLastWeekOfMonth(202612L));
//    	System.out.println(calculateLastWeekOfMonth(202712L));
//    	System.out.println();
//    	System.out.println();
//    	System.out.println();
    	
//    	List<Integer> weeksOfMonth = fetchWeeksOfMonth("202612");
//    	weeksOfMonth.forEach(val -> System.out.println("val:: "+val));
//    	List<LocalDate> allDaysOfTheWeek = getAllDaysOfTheWeek(202653L);
//    	allDaysOfTheWeek.forEach(val -> System.out.println("val:: "+val));
//    	
//    	int confirmedYear = 2020;
//    	int confirmedMonth = 12;
//    	
//    	
//    	Calendar calendar = Calendar.getInstance();
//        calendar.clear();
//        calendar.set(Calendar.YEAR, confirmedYear);
//        calendar.set(Calendar.MONTH, confirmedMonth - 1);
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//
//        LocalDateTime lastDay = LocalDateTime.of(confirmedYear, confirmedMonth, calendar.getActualMaximum(Calendar.DATE), 0, 0);
//        System.out.println("lastDay: "+lastDay);
//    	test(202452);
        
    }
    
    
    public static void  test(int currentTime) {
    	int year = currentTime/100;
        int week = currentTime%100;
        
    	WeekFields weekFields = WeekFields.ISO;
        LocalDate startDate = LocalDate.now ( )
                .withYear ( year )
                .with ( weekFields.weekOfYear ( ), week )
                .with ( weekFields.dayOfWeek ( ), 1 );
        LocalDate endDate = LocalDate.now ( )
                .withYear ( year )
                .with ( weekFields.weekOfYear ( ), week )
                .with ( weekFields.dayOfWeek ( ), 7 );
        
        System.out.println("startDate: "+startDate);
        System.out.println("endDate: "+endDate);
    }
    
    public static List<Integer> getAllWeekNosBetweenOld(Integer startWk, Integer endWk) {
    	final String YEAR_WEEK = "yyyyww";
        if (startWk > endWk) {
            return new ArrayList<>();
        }
        LocalDate startDt = getFirstDayOfWeekk(startWk);
        LocalDate endDt = getFirstDayOfWeekk(endWk).plusDays(1);
        return startDt.datesUntil(endDt)
                .map(d -> Integer.parseInt(d.format(DateTimeFormatter.ofPattern(YEAR_WEEK)))).distinct()
                .collect(Collectors.toList());
    }
    
    public static LocalDate getFirstDayOfWeekk(Integer yearWeek) {
		return LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), yearWeek / 100)
				.with(WeekFields.ISO.weekOfWeekBasedYear(), yearWeek % 100).with(WeekFields.ISO.getFirstDayOfWeek());
	}
    
    public static int calculateLastWeekOfMonth(Long confirmedWeekMonth) {
    	int year = (int) (confirmedWeekMonth / 100);
        int month = (int) (confirmedWeekMonth % 100);
        // Get the last day of the given month
        LocalDate lastDayOfMonth = LocalDate.of(year, month, Month.of(month).length(Year.isLeap(year)));

        // Get ISO week number of the last day
        WeekFields weekFields = WeekFields.ISO;
        return lastDayOfMonth.get(weekFields.weekBasedYear()) * 100 + lastDayOfMonth.get(weekFields.weekOfWeekBasedYear());
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
        List<Integer> days = IntStream.rangeClosed(0, 6).mapToObj(lastDay::minusDays).map(Main ::getWeekNumber)
                .collect(Collectors.toList());

        Optional<Map.Entry<Integer, Long>> month = days.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        return Long.parseLong(calendar.getWeekYear() + "" + String.format("%02d", month.get().getKey()));
    }
    
    private static List<LocalDate> getAllDaysOfTheWeek(Long wk) {
        LocalDate firstDayOfWeek = getFirstDayOfWeek(wk.intValue());
        return IntStream.range(0, 7)
                .mapToObj(firstDayOfWeek::plusDays)
                .collect(Collectors.toList());

    }
    
    
    static List<Integer> fetchWeeksOfMonth(String monthNumber) {
        Integer MonthNumber = Integer.parseInt(monthNumber);// November...YYYYMM
        Integer s = MonthNumber % 100;
        Integer Year = MonthNumber / 100;
        LocalDate MonthFirstDay = LocalDate.now().withYear(Year).withMonth(s).withDayOfMonth(1);
        LocalDate MonthLastDate = MonthFirstDay
                .withDayOfMonth(MonthFirstDay.getMonth().length(MonthFirstDay.isLeapYear()));
        Integer MonthLastWeek = MonthLastDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        Integer MonthStartWeek = MonthFirstDay.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        List<LocalDate> ls = new ArrayList<>();
        for (LocalDate i = MonthFirstDay; i.isBefore(MonthLastDate.plusDays(1)); i = i.plusDays(1)) {
            ls.add(i);
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendValue(WeekFields.ISO.weekOfYear())
                .toFormatter();
        Map<Integer, List<LocalDate>> collect = ls.stream()
                .collect(Collectors.groupingBy(c -> Integer.valueOf((c.format(formatter)))));
        List<List<LocalDate>> alldatesinList = new LinkedList<>();
        List<Integer> MonthALlWeeks = new ArrayList<Integer>();
        for (Integer key : collect.keySet()) {
            Integer weekNumberOfMonth = MonthNumber - s + key;
            if(s==1 && key==0 && MonthStartWeek == 53) {
                key = 53;
                Integer WeekNumber = MonthNumber - s +key;
                weekNumberOfMonth = WeekNumber;
            }
            if(s==12 && key==53 && MonthLastWeek == 1) {
                key = 01;
                Integer WeekNumber = MonthNumber - s +key;
                weekNumberOfMonth = WeekNumber+100;
            }
            MonthALlWeeks.add(weekNumberOfMonth);
        }
        return MonthALlWeeks;
    }
    
    
    public static List<Integer> getAllWeekNosBetween(Integer startWk, Integer endWk) {
        final String YEAR_WEEK = "YYYYww";  // Use week-based year

        if (startWk > endWk) {
            return new ArrayList<>();
        }

        LocalDate startDt = getFirstDayOfWk(startWk);
        LocalDate endDt = getFirstDayOfWk(endWk).plusDays(1);

        return startDt.datesUntil(endDt, Period.ofWeeks(1))  // Step by weeks
                .map(d -> Integer.parseInt(d.format(DateTimeFormatter.ofPattern(YEAR_WEEK))))
                .collect(Collectors.toList());
    }

    public static LocalDate getFirstDayOfWk(Integer yearWeek) {
        int weekBasedYear = yearWeek / 100;
        int weekOfYear = yearWeek % 100;

        return LocalDate.of(weekBasedYear, 1, 1)
                .with(WeekFields.ISO.weekBasedYear(), weekBasedYear)
                .with(WeekFields.ISO.weekOfWeekBasedYear(), weekOfYear);
    }

        
    public static Integer convertYearWeekToYearMonth(Integer yearWeek) {
        LocalDate date = LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), yearWeek / 100)
                .with(WeekFields.ISO.weekOfWeekBasedYear(), yearWeek % 100).with(WeekFields.ISO.getFirstDayOfWeek());
        return Integer.parseInt(date.format(DateTimeFormatter.ofPattern("yyyyMM")));
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
                System.out.println("Error occurred while date conversion for {}"+ date + ignored);
            }
        }
        return null;
    }
    
    public static Long getEndWeek(Integer seihanWeek, int weekRange) {

        long year = seihanWeek / 100;
        long wk = seihanWeek % 100;

        LocalDate date = LocalDate.now(ZoneOffset.UTC)
                .with(WeekFields.ISO.weekBasedYear(), year)
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, wk).plusWeeks(weekRange);
        return (long) ((date.get(WeekFields.ISO.weekBasedYear()) * 100)
                + date.get(WeekFields.ISO.weekOfWeekBasedYear()));
    }
    
    public static Long convertDateFormatWeek(LocalDateTime localDateTime) {
        return Long.parseLong(localDateTime.get(IsoFields.WEEK_BASED_YEAR) + String.format("%02d", getWeekNumber(localDateTime)));
    }
    
    public static Integer addMonthsToProcessingDate(Integer processingDate, int monthsToAdd) {
        int year = processingDate / 100;
        int month = processingDate % 100;

        LocalDate localDate = LocalDate.of(year, month, 1);

        localDate = localDate.plusMonths(monthsToAdd);
        year = localDate.getYear();
        month = localDate.getMonthValue();

        return Integer.parseInt(year + String.format("%02d", month));
    }
    
    public static Integer addWeeksToSeihanWeek(Integer seihanWeek, int weeksToAdd) {
        int year = seihanWeek / 100;
        int week = seihanWeek % 100;

        LocalDate localDate = LocalDate
                .of(year, 2, 1)
                .with(WeekFields.of(Locale.UK).getFirstDayOfWeek())
                .with(WeekFields.of(Locale.UK).weekOfWeekBasedYear(), week);

        localDate = localDate.plusWeeks(weeksToAdd);
        year = localDate.getYear();
        week = localDate.get(WeekFields.of(Locale.UK).weekOfWeekBasedYear());

        return Integer.parseInt(year + String.format("%02d", week));
    }
    
    private static Long addWeeksToSeihanWeek2(Integer seihanWeek, int weeksToAdd) {
        long year = seihanWeek/100;
        long wk =  seihanWeek % 100;

        LocalDate date = LocalDate.now(ZoneOffset.UTC)
                .with(WeekFields.ISO.weekBasedYear(), year)
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, wk).plusWeeks(weeksToAdd);

        return (long) ((date.get(WeekFields.ISO.weekBasedYear()) * 100)
                + date.get(WeekFields.ISO.weekOfWeekBasedYear()));
    }
    
    public static Long getInitialFinalShipWeek(LocalDate intialFinalShipDate) {

        Integer week = intialFinalShipDate.get(WeekFields.of(Locale.UK).weekOfYear());
        Integer month = intialFinalShipDate.get(ChronoField.MONTH_OF_YEAR);
        Integer year = intialFinalShipDate.getYear();

        String wk = "";
        if(week < 10)
            wk = String.format("%02d", week);

        int weekYear = year;

        if(month == 1 && week > 6 ){
            weekYear = year-1;
        }

        return Long.parseLong(String.valueOf(weekYear).concat(wk));
    }
    
    public static Integer getFirstPerfectWeek(Integer rsm) {
        Integer yearMon = rsm;
        Integer week = LocalDate.of(yearMon / 100, yearMon % 100, 1).get(WeekFields.ISO.weekOfWeekBasedYear());
        week = week > 51 ? 1 : week;
        week = LocalDate.of(yearMon / 100, yearMon % 100, 1).with(WeekFields.ISO.getFirstDayOfWeek())
                .with(WeekFields.ISO.weekOfWeekBasedYear(), week).getDayOfMonth() > 7 ? week + 1 : week;
        yearMon = ((yearMon - (yearMon % 100)) + week);
        return yearMon; // yearweek
    }
    
    public static Long getFirstPureWeek(String rsm) {
        Integer year = Integer.parseInt(rsm.substring(0, 4));
        Integer month = Integer.parseInt(rsm.substring(4, 6));

        LocalDate localDate = LocalDate.of(year, month, 1);

        Integer week = localDate.get(WeekFields.of(Locale.UK).weekOfWeekBasedYear());
        Integer dayOfWeek = localDate.getDayOfWeek().getValue();

        String firstPureWeek = "";

        firstPureWeek = year.toString().concat(
                week.toString().length() == 1 ? "0".concat(week.toString()) : week.toString());

        if (dayOfWeek != 1) {
            ++week;
            firstPureWeek = year.toString().concat(
                    (week.toString().length() == 1 ? "0".concat(week.toString()) : week.toString()));
        }

        if (month == 1 && dayOfWeek != 1)
            firstPureWeek = year.toString().concat("01");

        return Long.parseLong(firstPureWeek);
    }
    
    public static LocalDate getFirstDayOfWeekScorp(int week) {
        return LocalDate.of(week / 100, 2, 1)
                .with(WeekFields.ISO.getFirstDayOfWeek())
                .with(WeekFields.ISO.weekOfWeekBasedYear(), week % 100);
    }
    
    public static Set<Integer> getAllMonthNumbersBetween(LocalDate fromMonth, Integer addMonths) {
        Set<Integer> dates = new HashSet<>();
        for (int add = 0; add <= addMonths; add++) {
            LocalDate date = fromMonth.plusMonths(add);
            dates.add(date.getYear() * 100 + Integer.parseInt(String.format("%02d", date.getMonthValue())));
        }
        return new HashSet<>(dates);
    }
    
    public static Set<Integer> getAllWeekNumbersBetween(LocalDate fromWeek, Integer addWeeks) {
        Set<Integer> dates = new HashSet<>();
        for (int add = 0; add <= addWeeks; add++) {
            LocalDate date = fromWeek.plusWeeks(add);
            dates.add(date.get(IsoFields.WEEK_BASED_YEAR) * 100 +
                    Integer.parseInt(String.format("%02d", date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR))));
        }
        return new HashSet<>(dates);
    }
    
    public static List<Integer> getAllWeekNumbersBetween(Integer fromWeek, Integer addWeeks) {
		List<Integer> dates = new ArrayList<>();
		LocalDate firstDayOfWeek = getFirstDayOfWk2(fromWeek);
		for (int add = 1; add <= addWeeks; add++) {
			LocalDate date = firstDayOfWeek.plusWeeks(add);
			dates.add(date.get(WeekFields.ISO.weekBasedYear()) * 100 + date.get(WeekFields.ISO.weekOfWeekBasedYear()));
		}
		return dates;
	}
    
    public static LocalDate getFirstDayOfWk2(Integer yearWeek) {
        return LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), yearWeek / 100)
                .with(WeekFields.ISO.weekOfWeekBasedYear(), yearWeek % 100).with(WeekFields.ISO.getFirstDayOfWeek());
    }
    
    public static List<Long> getAllWeekNumbersFromFSMC(Integer fromYearWeek, Long addWeeks) {
        List<Long> dates = new ArrayList();
        LocalDate firstDayOfWeek = getFirstDayOfWeekFSMC2(fromYearWeek);

        for(int add = 0; (long)add < addWeeks; ++add) {
            LocalDate date = firstDayOfWeek.plusWeeks((long)add);
            dates.add((long)(date.get(WeekFields.ISO.weekBasedYear()) * 100 + date.get(WeekFields.ISO.weekOfWeekBasedYear())));
        }

        return dates;
    }
    
    public static Integer addWeeksToYearWkFSMC(Integer yearWeek, Integer addWeeks) {
        LocalDate date = LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), (long)(yearWeek / 100)).with(WeekFields.ISO.weekOfWeekBasedYear(), (long)(yearWeek % 100)).with(WeekFields.ISO.getFirstDayOfWeek()).plusWeeks((long)addWeeks);
        return date.get(WeekFields.ISO.weekBasedYear()) * 100 + date.get(WeekFields.ISO.weekOfWeekBasedYear());
    }
    
    public static LocalDate getFirstDayOfWeekFSMC2(Integer yearWeek) {
        return LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), (long)(yearWeek / 100)).with(WeekFields.ISO.weekOfWeekBasedYear(), (long)(yearWeek % 100)).with(WeekFields.ISO.getFirstDayOfWeek());
    }
    
    public static Integer convertLocalDateToYearWeekFSMC(LocalDate date) {
        return (date.get(WeekFields.ISO.weekBasedYear()) * 100) + date.get(WeekFields.ISO.weekOfWeekBasedYear());
    }
    
    public static Integer findSeihanMonth(ZonedDateTime dateTime) {

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
    
    public static Long findSeihanMonth2(ZonedDateTime dateTime) {

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

        return year * 100L + month.get().getKey();
    }
    
    public static Integer convertLocalDateToYearWeek(LocalDate date) {
        return (date.get(WeekFields.ISO.weekBasedYear()) * 100) + date.get(WeekFields.ISO.weekOfWeekBasedYear());
    }
    public static LocalDate getFirstDayOfWeekFSMC(Integer yearWeek) {
        return LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), yearWeek / 100)
                .with(WeekFields.ISO.weekOfWeekBasedYear(), yearWeek % 100).with(WeekFields.ISO.getFirstDayOfWeek());
    }
    
    private static Integer getWeekNumberFSMC(LocalDateTime localDateTime) {
        int week = localDateTime.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        return Integer.parseInt(String.format("%02d", week));
    }
    
    private static LocalDate addWeeksFSMC(Long startWeek, int weeks) {
        LocalDate initialDate = getFirstDayOfWeek(startWeek.intValue());
        return initialDate.plusWeeks(weeks);
    }
    
    private static LocalDate getFirstDayOfWeekFSMC(int week) {
        return LocalDate.of(week / 100, 2, 1)
                .with(WeekFields.ISO.getFirstDayOfWeek())
                .with(WeekFields.ISO.weekOfWeekBasedYear(), week % 100);
    }
    
    private static List<LocalDate> getFirstMonthLastWeekLastDaysCount(LocalDate startDate) {
        LocalDate lastDate= startDate.plusDays(7);
//        System.out.println(startDate);
        List<LocalDate> ls = new ArrayList<LocalDate>();
        Integer count = 0;
        Integer month  = 0;
        for(LocalDate i =startDate;i.isBefore(lastDate);i=i.plusDays(1)) {
            Integer mn = Integer.parseInt(i.format(DateTimeFormatter.ofPattern("MM")));
            if(month!=mn) {
                count++;
                month = mn;
            }
            if(count<2) {
                ls.add(i);
                continue;
            }
            count = 0;
            break;
        }
        return ls;
    }
    
    public static Integer getSeihanProcessingMonth() {
    	Date processingDate;
    	Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.MARCH, 9, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    	processingDate = calendar.getTime();
    	
        LocalDate seihanWeek = processingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        return Integer.parseInt(seihanWeek.format(formatter));
    }
    
    public static String getPrevSeihanWk(String inputWeek) {
        // Validate the input format
        if (inputWeek.length() != 6 || !inputWeek.matches("\\d{6}")) {
            return null;
        }

        // Extract year and week
        String year = inputWeek.substring(0, 4);
        int week = Integer.parseInt(inputWeek.substring(4));

        // Calculate previous week
        if (week == 1) {
            // If current week is 01, we need to go to the last week of the previous year
            year = String.valueOf(Integer.parseInt(year) - 1);
            week = 52; // Adjust to last week of the previous year
        } else {
            week -= 1; // Just subtract 1 from the week number
        }

        // Format output week to always have 2 digits for the week
        String previousWeek = year + String.format("%02d", week);

        // Output the previous week
        return previousWeek;
    }
    
//    public static String getSeihanWeek(LocalDate date) {
//        // Use ISO week fields for consistency (weeks start on Monday)
//        WeekFields weekFields = WeekFields.ISO;
//
//        // Adjust Sunday to count as part of the previous week
//        LocalDate adjustedDate = date.getDayOfWeek() == DayOfWeek.SUNDAY 
//                ? date.minusDays(1) 
//                : date;
//
//        // Get week-based year and week number
//        int weekBasedYear = adjustedDate.get(weekFields.weekBasedYear());
//        int weekOfYear = adjustedDate.get(weekFields.weekOfYear());
//
//        // Handle case where last days of the year belong to Week 1 of the next year
//        if (weekBasedYear > adjustedDate.getYear()) {
//            // Assign to Week 1 of the next year
//            return String.format("%d%02d", weekBasedYear, 1);
//        }
//
//        // Format as Seihan week YYYYWW
//        return String.format("%d%02d", weekBasedYear, weekOfYear);
//    }
    public static String getSeihanWeek(LocalDate date) {
        // Use ISO week fields (weeks start on Monday)
        WeekFields weekFields = WeekFields.ISO;

        // Get week-based year and week number
        int weekBasedYear = date.get(weekFields.weekBasedYear());
        int weekOfYear = date.get(weekFields.weekOfYear());

        // Handle week 0 scenario by shifting to previous week's last valid entry
        if (weekOfYear == 0) {
            LocalDate lastWeekDate = date.minusWeeks(1);
            weekBasedYear = lastWeekDate.get(weekFields.weekBasedYear());
            weekOfYear = lastWeekDate.get(weekFields.weekOfYear());
        }

        // Special case: if it's the end of the year and week exceeds 52 or 53, roll to Week 1
        if (weekOfYear > 52) {
            LocalDate firstDayOfNextYear = LocalDate.of(weekBasedYear + 1, 1, 1);
            if (date.isAfter(firstDayOfNextYear.minusDays(1))) {
                weekBasedYear += 1;
                weekOfYear = 1;
            }
        }

        // Format as Seihan week YYYYWW
        return String.format("%d%02d", weekBasedYear, weekOfYear);
    }
    
    public static String getSeihanWeekNew(LocalDate date) {
        // Use ISO week fields for consistency (weeks start on Monday)
        WeekFields weekFields = WeekFields.ISO;

        // Adjust Sunday to count as part of the previous week
        LocalDate adjustedDate = date.getDayOfWeek() == DayOfWeek.SUNDAY
                ? date.minusDays(1)
                : date;

        // Get week-based year and week number
        int weekBasedYear = adjustedDate.get(weekFields.weekBasedYear());
        int weekOfYear = adjustedDate.get(weekFields.weekOfYear());

        // Handle case where last days of the year belong to Week 1 of the next year
        if (weekBasedYear > adjustedDate.getYear()) {
            // Assign to Week 1 of the next year
            return String.format("%d%02d", weekBasedYear, 1);
        }

        // Format as Seihan week YYYYWW
        return String.format("%d%02d", weekBasedYear, weekOfYear);
    }
    
    public static String getSeihanWeekNewest(LocalDate date) {
        // Use ISO week fields for consistency (weeks start on Monday)
        WeekFields weekFields = WeekFields.ISO;

        // Adjust Sunday to count as part of the previous week
        LocalDate adjustedDate = date.getDayOfWeek() == DayOfWeek.SUNDAY
                ? date.minusDays(1)
                : date;

        // Get week-based year and week number
        int weekBasedYear = adjustedDate.get(weekFields.weekBasedYear());
        int weekOfYear = adjustedDate.get(weekFields.weekOfWeekBasedYear());

        // Check the last day of the week-based year to determine max weeks
        LocalDate lastDayOfYear = LocalDate.of(weekBasedYear, 12, 31);
        int maxWeeks = lastDayOfYear.get(weekFields.weekOfWeekBasedYear());

        // If the last week spills into next year but still belongs to the current year
        if (weekOfYear > maxWeeks) {
            weekOfYear = maxWeeks; // Ensure it's correctly assigned
        }

        // Format as Seihan week YYYYWW
        return String.format("%d%02d", weekBasedYear, weekOfYear);
    }



    public static String getSeihanWeekOld(LocalDate date) {
        // Ensure the week starts on Monday
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        LocalDate adjustedDate = date;

        // Adjust the date if it's Sunday to count it in the previous week
        if (date.getDayOfWeek().getValue() == 7) {
            adjustedDate = date.minusDays(1);
        }

        // Get the year and week number based on adjusted date
        int year = adjustedDate.getYear();
        int weekOfYear = adjustedDate.get(weekFields.weekOfYear());

        // Format the Seihan week as YYYYWW (e.g., 202436)
        return String.format("%d%02d", year, weekOfYear);
    }



    
    public static String getSeihanWeek_Old(LocalDate date) {
        // Ensure the week starts on Monday
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        LocalDate adjustedDate = date;

        // Adjust the date if it's Sunday to count it in the previous week
        if (date.getDayOfWeek().getValue() == 7) {
            adjustedDate = date.minusDays(1);
        }

        // Get the year and week number based on adjusted date
        int year = adjustedDate.getYear();
        int weekOfYear = adjustedDate.get(weekFields.weekOfYear());

        // Format the Seihan week as YYYYWW (e.g., 202436)
        return String.format("%d%02d", year, weekOfYear);
    }
    
    public static String getSeihanWeekSimple(LocalDate date) {
        return "" + ((date.get(WeekFields.ISO.weekBasedYear()) * 100) + date.get(WeekFields.ISO.weekOfWeekBasedYear()));
    }
    
    public static List<LocalDate> getDatesForSeihanWeek(String seihanWeek) {
        // Validate input
        if (seihanWeek == null || seihanWeek.length() != 6) {
            throw new IllegalArgumentException("Invalid Seihan week format. Expected YYYYWW.");
        }

        int year = Integer.parseInt(seihanWeek.substring(0, 4));
        int week = Integer.parseInt(seihanWeek.substring(4));

        // Use ISO week fields for consistency
        WeekFields weekFields = WeekFields.ISO;

        // Get first day of the week (Monday)
        LocalDate firstDayOfWeek = LocalDate.of(year, 1, 4)  // ISO week starts near Jan 4
                .with(weekFields.weekOfYear(), week)
                .with(weekFields.dayOfWeek(), 1); // Monday

        // Generate all 7 days
        return IntStream.range(0, 7)
                .mapToObj(firstDayOfWeek::plusDays)
                .collect(Collectors.toList());
    }
    
    public static List<LocalDate> getDatesForSeihanWeekOld(String seihanWeek) {
        // Extract year and week number from Seihan week
        int year = Integer.parseInt(seihanWeek.substring(0, 4));
        int week = Integer.parseInt(seihanWeek.substring(4));

        // Get the first day of the week based on ISO rules (Week starts on Monday)
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        LocalDate firstDayOfWeek = LocalDate.of(year, 1, 1)
                .with(weekFields.weekOfYear(), week)
                .with(weekFields.dayOfWeek(), 2); // Monday

        // Get all days in the week (7 days)
        return IntStream.range(0, 7)
                .mapToObj(firstDayOfWeek::plusDays)
                .collect(Collectors.toList());
    }


    
    public static List<LocalDate> getDatesForSeihanWeek_OLD(String seihanWeek) {
        // Extract year and week number from Seihan week
        int year = Integer.parseInt(seihanWeek.substring(0, 4));
        int week = Integer.parseInt(seihanWeek.substring(4));

        // Get the first day of the week based on ISO rules (Week starts on Monday)
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        LocalDate firstDayOfWeek = LocalDate.of(year, 1, 1)
                .with(weekFields.weekOfYear(), week)
                .with(weekFields.dayOfWeek(), 2); // Monday

        // Get all days in the week (7 days)
        return IntStream.range(0, 7)
                .mapToObj(firstDayOfWeek::plusDays)
                .collect(Collectors.toList());
    }
    
    public static List<String> calculateSeihanWeeks(LocalDate currentDate) {
        List<String> seihanWeeks = new ArrayList<>();

        // Get the first Monday of the year
        LocalDate firstMondayOfYear = LocalDate.of(currentDate.getYear(), 1, 1);
        while (firstMondayOfYear.getDayOfWeek() != java.time.DayOfWeek.MONDAY) {
            firstMondayOfYear = firstMondayOfYear.plusDays(1);
        }

        // Get the last day of the current month
        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());

        // Iterate through weeks till the end of the month
        LocalDate currentWeekStart = currentDate.with(java.time.DayOfWeek.MONDAY);

        while (!currentWeekStart.isAfter(lastDayOfMonth)) {
            // Calculate the Seihan week number manually from the first Monday of the year
            long daysSinceFirstMonday = java.time.temporal.ChronoUnit.DAYS.between(firstMondayOfYear, currentWeekStart);
            int seihanWeekForDate = (int) (daysSinceFirstMonday / 7) + 1;

            seihanWeeks.add(formatSeihanWeek(currentWeekStart, seihanWeekForDate));
            currentWeekStart = currentWeekStart.plusWeeks(1);
        }

        return seihanWeeks;
    }
    
    public static List<String> calculateSeihanWeeksNew(LocalDate currentDate) {
        List<String> seihanWeeks = new ArrayList<>();

        // Get the last day of the current month
        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());

        // Start from the Monday of currentDate's week
        LocalDate currentWeekStart = currentDate.with(DayOfWeek.MONDAY);

        while (!currentWeekStart.isAfter(lastDayOfMonth)) {
            // Get ISO week number and ISO week-based year
            int isoWeekNumber = currentWeekStart.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
            int isoWeekYear = currentWeekStart.get(IsoFields.WEEK_BASED_YEAR);

            // Format as "YYYYWW"
            String seihanWeek = String.format("%04d%02d", isoWeekYear, isoWeekNumber);
            seihanWeeks.add(seihanWeek);

            // Move to next week
            currentWeekStart = currentWeekStart.plusWeeks(1);
        }

        return seihanWeeks;
    }

    
    private static String formatSeihanWeek(LocalDate currentWeekStart, int seihanWeekForDate) {
        int year = currentWeekStart.getYear();
        return String.format("%d%02d", year, seihanWeekForDate); // Year followed by zero-padded week number
    }
    
    public static List<Long> generateWksInCurMon(SalesCompany salesCompany) {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        List<Long> wksOfMonth = new ArrayList<Long>();
        // Get the year and month as strings
        Integer year = Integer.parseInt(yearFormat.format(salesCompany.getProcessingDate()));
        Integer month = Integer.parseInt(monthFormat.format(salesCompany.getProcessingDate()));
        // Get the first and last day of the month
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());

        System.out.println("firstDayOfMonth: "+firstDayOfMonth);
        // Get the week fields based on ISO-8601, Monday as the first day of the week
        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        // Loop through the days of the month to generate SEIHAN weeks
        LocalDate currentDate = firstDayOfMonth;
        while (currentDate.getMonthValue() == month) {
            int currentWeek = currentDate.get(weekFields.weekOfWeekBasedYear());
            System.out.println("currentWeek: "+currentWeek);
            // Ensure we only add new weeks (skip duplicates)
            if (!wksOfMonth.contains(year + String.format("%02d", currentWeek))) {
                wksOfMonth.add(Long.parseLong(year + String.format("%02d", currentWeek)));
            }
            // Move to the next week
            currentDate = currentDate.plusWeeks(1);
        }
        return wksOfMonth;
    }
    
    
    public static List<Long> generateWkFromCurrMon(SalesCompany salesCompany) {
        Integer year = salesCompany.getSeihanWeek() / 100;
        Integer wk = salesCompany.getSeihanWeek() % 100;
        String zero="";
        if(wk<10){
            zero="0";
        }
        Integer wkNo= Integer.valueOf(year+zero+wk);
        return getAllWeekNumbersFrom(wkNo,6l);
    }
    public static List<Long> getAllWeekNumbersFrom(Integer fromYearWeek, Long addWeeks) {
        List<Long> dates = new ArrayList<>();
        LocalDate firstDayOfWeek = getFirstDayOfWeekNew(fromYearWeek);
        for (int add = 0; add < addWeeks; add++) {
            LocalDate date = firstDayOfWeek.plusWeeks(add);
            dates.add((long) (date.get(WeekFields.ISO.weekBasedYear()) * 100
                    + date.get(WeekFields.ISO.weekOfWeekBasedYear())));
        }
        return dates;
    }
    
    public static LocalDate getFirstDayOfWeekNew(Integer yearWeek) {
        return LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), yearWeek / 100)
                .with(WeekFields.ISO.weekOfWeekBasedYear(), yearWeek % 100).with(WeekFields.ISO.getFirstDayOfWeek());
    }
    
    private static Integer getWeekNumber(LocalDate localDate) {
		int week = localDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		return Integer.parseInt(String.format("%02d", week));
	}
    
    public static Integer getYearWkForDate(LocalDateTime date) {
        if (date != null) {
            return (date.get(WeekFields.ISO.weekBasedYear()) * 100) + date.get(WeekFields.ISO.weekOfWeekBasedYear());
        }
        return 0;
    }
    
    public static String getFirstDayOfWeek(Integer week) {
        return  LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), week / 100)
                .with(WeekFields.ISO.weekOfWeekBasedYear(), week % 100)
                .with(WeekFields.ISO.getFirstDayOfWeek())
                .format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    public static String getRSWWithFirstDayOfWeek(String rsw){
        StringBuilder wkformat= new StringBuilder("WK");
        wkformat.append(rsw.substring(4)).append(" ").append(getFirstDayOfWeek(Integer.parseInt(rsw)));
        return wkformat.toString();
    }
    
    public static LocalDateTime convertToLocalDateTime(String dateTimeField,String fieldName){
        String dateFormat=YEAR_MONTH_DATE_TIME;
        boolean startOfDay=false;
        if(dateTimeField != null){
            if(dateTimeField.length()==8){
                dateFormat=YEAR_MONTH_DATE;
                startOfDay=true;
            }
            return toDateTime(fieldName, dateTimeField, dateFormat, startOfDay);

        }
        return null;
    }
    
    public static LocalDateTime toDateTime(String dateName, String dateTime, String format, boolean startOfDay) {
        LocalDateTime localDateTime = null;
        if (dateTime != null && format != null) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                if (startOfDay)
                    localDateTime = LocalDate.parse(dateTime, formatter).atStartOfDay();
                else
                    localDateTime = LocalDateTime.parse(dateTime, formatter);
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }
        return localDateTime;
    }
    
    public static boolean isDateBetween(LocalDateTime localDateTime, Date fromDate, Date toDate) {
        LocalDateTime initialShipDt = null;
        LocalDateTime finalShipDt = null;
        if(fromDate != null) {
            initialShipDt = Instant.ofEpochMilli(fromDate.getTime())
                    .atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
        if(toDate != null) {
            finalShipDt = Instant.ofEpochMilli(toDate.getTime())
                    .atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
        if(initialShipDt != null && finalShipDt != null) {
            return (localDateTime.equals(initialShipDt) || localDateTime.isAfter(initialShipDt))
                    && (localDateTime.equals(finalShipDt) || localDateTime.isBefore(finalShipDt));
        }
        if(initialShipDt != null && finalShipDt == null) {
            return (localDateTime.equals(initialShipDt) || localDateTime.isAfter(initialShipDt));
        }
        if(initialShipDt == null && finalShipDt != null) {
            return (localDateTime.equals(finalShipDt) || localDateTime.isBefore(finalShipDt));
        }
        return true;
    }
    
    public static boolean isDateBetweenWeeks(LocalDate localDate, Long fromWeek, int toAdd) {
        LocalDateTime dateTime = LocalDateTime.of(addWeeks(fromWeek, 1), LocalTime.of(0, 0, 0));
        LocalDate initialShipDt = getFirstDayOfWeek(dateTime.getYear() * 100 + getWeekNumber(dateTime));
        LocalDate finalShipDt = initialShipDt.plusWeeks(toAdd);
        return (localDate.equals(initialShipDt) || localDate.isAfter(initialShipDt))
                && (localDate.equals(finalShipDt) || localDate.isBefore(finalShipDt));
    }
    
    public static boolean isDateBetweenMonths(LocalDate localDate, Long fromMonth, int toAdd) {
        LocalDateTime dateTime = LocalDateTime.of(addMonths(fromMonth, 1), LocalTime.of(0, 0, 0));
        LocalDate initialShipDt = getFirstDayOfMonth(dateTime.getYear() * 100 + getMonthNumber(dateTime));
        LocalDate finalShipDt = initialShipDt.plusMonths(toAdd);
        return (localDate.equals(initialShipDt) || localDate.isAfter(initialShipDt))
                && (localDate.equals(finalShipDt) || localDate.isBefore(finalShipDt));
    }
    
    public static LocalDate addMonths(Long startMonth, int months) {
        LocalDate initialDate = getFirstDayOfMonth(startMonth.intValue());
        return initialDate.plusMonths(months);
    }
    
    private static LocalDate getFirstDayOfMonth(int month) {
        return LocalDate.of(month / 100, month % 100, 1);
    }
    
    private static Integer getMonthNumber(LocalDateTime localDateTime) {
        return Integer.parseInt(String.format("%02d", localDateTime.getMonthValue()));
    }
    
    private static Integer getWeekNumber(LocalDateTime localDateTime) {
        int week = localDateTime.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        return Integer.parseInt(String.format("%02d", week));
    }
    
    public static LocalDate addWeeks(Long startWeek, int weeks) {
        LocalDate initialDate = getFirstDayOfWeek(startWeek.intValue());
        return initialDate.plusWeeks(weeks);
    }
    
    public static LocalDate getFirstDayOfWeek(int week) {
        return LocalDate.of(week / 100, 2, 1)
                .with(WeekFields.ISO.getFirstDayOfWeek())
                .with(WeekFields.ISO.weekOfWeekBasedYear(), week % 100);
    }

   /* public static Integer addWeeksToYearWk(Integer yearWeek, Integer addWeeks) {

        LocalDate date = LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), yearWeek / 100)
                .with(WeekFields.ISO.weekOfWeekBasedYear(), yearWeek % 100).with(WeekFields.ISO.getFirstDayOfWeek())
                .plusWeeks(addWeeks);
        return date.get(WeekFields.ISO.weekBasedYear()) * 100 + date.get(WeekFields.ISO.weekOfWeekBasedYear());

    }

    public static Long getEndWeek(Integer seihanWeek, int weekRange) {

        long year = seihanWeek / 100;
        long wk = seihanWeek % 100;

        LocalDate date = LocalDate.now(ZoneOffset.UTC)
                .with(WeekFields.ISO.weekBasedYear(), year)
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, wk).plusWeeks(weekRange);
        return (long) ((date.get(WeekFields.ISO.weekBasedYear()) * 100)
                + date.get(WeekFields.ISO.weekOfWeekBasedYear()));
    }*/
    
    public static Integer addWeeksToYearWk(Integer yearWeek, Integer addWeeks) {
        LocalDate date = LocalDate.now(ZoneOffset.UTC).with(WeekFields.ISO.weekBasedYear(), (long)(yearWeek / 100)).with(WeekFields.ISO.weekOfWeekBasedYear(), (long)(yearWeek % 100)).with(WeekFields.ISO.getFirstDayOfWeek()).plusWeeks((long)addWeeks);
        return date.get(WeekFields.ISO.weekBasedYear()) * 100 + date.get(WeekFields.ISO.weekOfWeekBasedYear());
    }

    public static long getMaxWeekOfYear(int currentSeihanYear){
        LocalDate localDate = LocalDate.of(currentSeihanYear, 1, 1).with(WeekFields.ISO.weekBasedYear(), currentSeihanYear);
        return localDate.range(WeekFields.ISO.weekOfWeekBasedYear()).getMaximum();
    }

    private static Integer getWeeksFromNow(Integer currentSeihanWeek) {
        int currentSeihanYear = filterNull(currentSeihanWeek / 100);
        long weeksInCurrentSeihanYear = Long.parseLong(currentSeihanYear+""+ getMaxWeekOfYear(currentSeihanYear));
        int getRemainingWeeksInCurrentSeihar =Math.abs( (int)((weeksInCurrentSeihanYear%100)) - (currentSeihanWeek.intValue() %100));
        long weeksInNextSeihanYear = Long.parseLong((currentSeihanYear+1)+""+ getMaxWeekOfYear(currentSeihanYear+1));
        int finalWeek = (int) weeksInNextSeihanYear%100 - getRemainingWeeksInCurrentSeihar%100;
        String finalWeekStr = finalWeek < 10? "0"+finalWeek: "" + finalWeek;
        int _52weeksFromNow = Integer.parseInt((currentSeihanYear+1)+finalWeekStr);
        return _52weeksFromNow;
    }

    private static Integer getWeeksFromNowOld(Integer currentSeihanWeek) {
        int currentSeihanYear = filterNull(currentSeihanWeek / 100);
        LocalDate currentSehanYearlastDay = LocalDate.of(currentSeihanYear, 12, 31);
        long weeksInCurrentSeihanYear = Long.parseLong(currentSeihanYear+""+ IsoFields.WEEK_OF_WEEK_BASED_YEAR.rangeRefinedBy(currentSehanYearlastDay).getMaximum());
        int getRemainingWeeksInCurrentSeihar =Math.abs( (int)((weeksInCurrentSeihanYear%100)) - (currentSeihanWeek.intValue() %100));
        LocalDate sehanNextYearlastDay = LocalDate.of(currentSeihanYear+1, 12, 31);
        long weeksInNextSeihanYear = Long.parseLong((currentSeihanYear+1)+""+ IsoFields.WEEK_OF_WEEK_BASED_YEAR.rangeRefinedBy(sehanNextYearlastDay).getMaximum());
        int finalWeek = (int) weeksInNextSeihanYear%100 - getRemainingWeeksInCurrentSeihar%100;
        String finalWeekStr = finalWeek < 10? "0"+finalWeek: "" + finalWeek;
        int _52weeksFromNow = Integer.parseInt((currentSeihanYear+1)+finalWeekStr);
        return _52weeksFromNow;
    }



    private static Integer filterNull(Integer toIntExact) {
        return null!= toIntExact ?toIntExact:null;
    }

}