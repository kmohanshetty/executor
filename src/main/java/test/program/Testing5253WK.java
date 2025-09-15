package test.program;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Testing5253WK {

	public static void main(String[] args) {
		List<Integer> MonthALlWeeks = new LinkedList<>();
		LocalDate MonthFirstDay = LocalDate.of(2026, 12, 01);
		LocalDate MonthLastDate = LocalDate.of(2026, 12, 31);
		List<LocalDate> ls = new ArrayList<>();
		LocalDate currDate = LocalDate.of(2026, 12, 02);
		Integer MonthLastWeek = MonthLastDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		
		getGroupedDates(MonthFirstDay, MonthLastDate, currDate, ls);
		
		List<List<LocalDate>> alldatesinList = new LinkedList<>();
		Map<Integer, List<LocalDate>> collectWithoutSort = getGroupedWkDates(ls);
		Map<Integer, List<LocalDate>> collect = new TreeMap<>(collectWithoutSort);
		
		for (Integer key : collect.keySet()) {
			MonthALlWeeks.add(key);
			List<LocalDate> DatesOfWeek = collect.get(key);
			alldatesinList.add(DatesOfWeek);
		}
		
		
		System.out.println(alldatesinList);
		
		for (int l = 0; l < alldatesinList.size(); l++) {
			if ((MonthALlWeeks.get(l) % 100 == 53 || MonthALlWeeks.get(l) % 100 == 1) && MonthLastWeek == 1) {
				
			}
		}
	}
	
	public static Map<Integer, List<LocalDate>> getGroupedWkDates(List<LocalDate> ls) {
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

        return sortedGrouped;
    }

	
	private static void getGroupedDates(LocalDate MonthFirstDay, LocalDate MonthLastDate, LocalDate firstDayOfWeek, List<LocalDate> ls) {
		for (LocalDate i = MonthFirstDay; i.isBefore(MonthLastDate.plusDays(1)); i = i.plusDays(1)) {
			if (!i.isBefore(firstDayOfWeek)) {
				ls.add(i);
			}
		}
	}
}
