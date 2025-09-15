package test.program;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class TestDist {

	public static void main(String[] args) {
		Long MonthNumber = 202506L;
		Long s = MonthNumber % 100;
		Long lastWeek = 0L;
		Long TotalFourweeksSum = 0L;
		float weekFCT = 0.0f;
		Float monthlyFctAverage = 9.29667f;
		Long MonthLastWeek = 27L;
		LinkedHashMap<Long, Long> mp = new LinkedHashMap<>();
		Long monQty = 2001L;
		
		List<Long> MonthALlWeeks = new LinkedList<>();
		Stream.of(202522L,202523L,202524L,202525L,202526L,202527L).forEach(MonthALlWeeks::add);
		
		
		List<Long> sumOfAllEachWeekDaysOfMonthOfWeek = new LinkedList<>();
		Stream.of(0L,100L,100L,0L,0L,0L).forEach(sumOfAllEachWeekDaysOfMonthOfWeek::add);
		
		for (int m = 0; m < MonthALlWeeks.size(); m++) {
            lastWeek = MonthALlWeeks.get(m) % 100;
		
            weekFCT = (sumOfAllEachWeekDaysOfMonthOfWeek.get(m)) * monthlyFctAverage;
            long fctc = (long) weekFCT;
            if (MonthALlWeeks.get(m) % 100 == 53 && MonthLastWeek == 1) {
                Long key = 01L;
                Long WeekNumber = MonthNumber - s + key;
                Long weekNumberOfMonthLast = WeekNumber + 100;
                mp.put(weekNumberOfMonthLast, Long.valueOf(Math.toIntExact((Long.valueOf(monQty)) - TotalFourweeksSum)));
            } else if (MonthLastWeek.equals(lastWeek)) {
                mp.put(MonthALlWeeks.get(m), Long.valueOf(Math.toIntExact(Long.valueOf(monQty)) - TotalFourweeksSum));
            } else {
                TotalFourweeksSum = TotalFourweeksSum + fctc;
                mp.put(MonthALlWeeks.get(m), fctc);
            }
		}
            
		System.out.println(mp);
	}

}
