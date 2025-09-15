package test.program;

import java.util.*;
import java.util.stream.Stream;

public class TestDist2 {

    public static void main(String[] args) {
        Float monthlyFctAverage = 0.0f;
        Long MonthNumber = 202506L;
        Long s = MonthNumber % 100;
        Long lastWeek = 0L;
        Long TotalFourweeksSum = 0L;
        float weekFCT = 0.0f;
        Long MonthLastWeek = 27L;
        LinkedHashMap<Long, Long> mp = new LinkedHashMap<>();
        Long monQty = 2789L;
        Float monthlyTotalWeightedRatio = 0.0f;
        Long lastValidWeek = null;

        List<Long> MonthALlWeeks = new LinkedList<>();
        Stream.of(202522L, 202523L, 202524L, 202525L, 202526L, 202527L).forEach(MonthALlWeeks::add);

        // Updated case with last week's value being nonzero
        List<Long> sumOfAllEachWeekDaysOfMonthOfWeek = new LinkedList<>();
        Stream.of(0L, 100L, 100L, 100L, 100L, 0L).forEach(sumOfAllEachWeekDaysOfMonthOfWeek::add);

        monthlyTotalWeightedRatio = (float) sumOfAllEachWeekDaysOfMonthOfWeek.stream().filter(val -> val > 0).count();
        monthlyTotalWeightedRatio = monthlyTotalWeightedRatio * 100;
        System.out.println("monthlyTotalWeightedRatio: " + monthlyTotalWeightedRatio);

        monthlyFctAverage = (Float.valueOf(monQty)) / monthlyTotalWeightedRatio;
        System.out.println("monthlyFctAverage: " + monthlyFctAverage);

        // Step 1: Calculate initial values for each week
        for (int m = 0; m < MonthALlWeeks.size(); m++) {
            lastWeek = MonthALlWeeks.get(m) % 100;
            weekFCT = sumOfAllEachWeekDaysOfMonthOfWeek.get(m) * monthlyFctAverage;
            long fctc = (long) weekFCT;

            if (sumOfAllEachWeekDaysOfMonthOfWeek.get(m) > 0) {
                lastValidWeek = MonthALlWeeks.get(m); // Track the last valid non-zero week
            }

            if (MonthALlWeeks.get(m) % 100 == 53 && MonthLastWeek == 1) {
                Long key = 01L;
                Long WeekNumber = MonthNumber - s + key;
                Long weekNumberOfMonthLast = WeekNumber + 100;
                mp.put(weekNumberOfMonthLast, monQty - TotalFourweeksSum);
            }/* else if (MonthLastWeek.equals(lastWeek)) {
                mp.put(MonthALlWeeks.get(m), monQty - TotalFourweeksSum);
            }*/ else {
                TotalFourweeksSum += fctc;
                mp.put(MonthALlWeeks.get(m), fctc);
            }
        }
        System.out.println(mp);

        // Step 2: Adjust the last valid week's value (if any discrepancy)
        long correction = monQty - TotalFourweeksSum; // Remaining quantity to adjust
        System.out.println("correction: "+correction);
        if (lastValidWeek != null && correction > 0) {
            mp.put(lastValidWeek, mp.get(lastValidWeek) + correction);
        }

        System.out.println(mp);
    }
}




//import java.util.*;
//import java.util.stream.Stream;
//
//public class TestDist2 {
//
//    public static void main(String[] args) {
//    	Float monthlyFctAverage = 0.0f;
//        Long MonthNumber = 202506L;
//        Long s = MonthNumber % 100;
//        Long lastWeek = 0L;
//        Long TotalFourweeksSum = 0L;
//        float weekFCT = 0.0f;
//        Long MonthLastWeek = 27L;
//        LinkedHashMap<Long, Long> mp = new LinkedHashMap<>();
//        Long monQty = 2002L;
//        Float monthlyTotalWeightedRatio = 0.0f;
//
//        List<Long> MonthALlWeeks = new LinkedList<>();
//        Stream.of(202522L, 202523L, 202524L, 202525L, 202526L, 202527L).forEach(MonthALlWeeks::add);
//
//        List<Long> sumOfAllEachWeekDaysOfMonthOfWeek = new LinkedList<>();
//        Stream.of(0L, 100L, 100L, 100L, 0L, 0L).forEach(sumOfAllEachWeekDaysOfMonthOfWeek::add);
//        
//        monthlyTotalWeightedRatio = (float) sumOfAllEachWeekDaysOfMonthOfWeek.stream().filter(val -> val > 0).count();
//        monthlyTotalWeightedRatio = monthlyTotalWeightedRatio * 100;
//        System.out.println("monthlyTotalWeightedRatio: "+monthlyTotalWeightedRatio);
//        
//        monthlyFctAverage = (Float.valueOf(monQty)) / monthlyTotalWeightedRatio;
//        System.out.println("monthlyFctAverage: "+monthlyFctAverage);
//        
//        // Step 1: Calculate initial values for each week
//        for (int m = 0; m < MonthALlWeeks.size(); m++) {
//            lastWeek = MonthALlWeeks.get(m) % 100;
//            weekFCT = sumOfAllEachWeekDaysOfMonthOfWeek.get(m) * monthlyFctAverage;
//            long fctc = (long) weekFCT;
//
//            if (MonthALlWeeks.get(m) % 100 == 53 && MonthLastWeek == 1) {
//                Long key = 01L;
//                Long WeekNumber = MonthNumber - s + key;
//                Long weekNumberOfMonthLast = WeekNumber + 100;
//                mp.put(weekNumberOfMonthLast, monQty - TotalFourweeksSum);
//            } else if (MonthLastWeek.equals(lastWeek)) {
//                mp.put(MonthALlWeeks.get(m), monQty - TotalFourweeksSum);
//            } else {
//                TotalFourweeksSum += fctc;
//                mp.put(MonthALlWeeks.get(m), fctc);
//            }
//        }
//        System.out.println(mp);
//        
//        
//    }
//}
