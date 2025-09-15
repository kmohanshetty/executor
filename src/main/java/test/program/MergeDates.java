package test.program;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeDates {

    public static void main(String[] args) {
        // Master list containing inner lists of LocalDate
        List<List<LocalDate>> allDatesInList = new LinkedList<>();

        // Existing inner list of dates
        List<LocalDate> existingDates = new ArrayList<>(Arrays.asList(
//                LocalDate.parse("2025-04-28"),
//                LocalDate.parse("2025-04-29"),
                LocalDate.parse("2025-04-30")
        ));
        allDatesInList.add(existingDates);

        // Full list of Seihan week dates
        List<LocalDate> datesForSeihanWeek = Arrays.asList(
                LocalDate.parse("2025-04-28"),
                LocalDate.parse("2025-04-29"),
                LocalDate.parse("2025-04-30"),
                LocalDate.parse("2025-05-01"),
                LocalDate.parse("2025-05-02"),
                LocalDate.parse("2025-05-03")
        );

     // Step 3: Find last/latest date in existingDates
        Optional<LocalDate> maxDateOpt = existingDates.stream().max(Comparator.naturalOrder());

        if (maxDateOpt.isPresent()) {
            LocalDate lastDate = maxDateOpt.get();

            // Step 4: Filter only new dates that are greater than lastDate
            List<LocalDate> newDatesToAdd = datesForSeihanWeek.stream()
                    .filter(date -> date.isAfter(lastDate))
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());

            // Step 5: Merge them into existing list
            existingDates.addAll(newDatesToAdd);
        }

        // Output result
        System.out.println("Merged dates:");
        existingDates.forEach(System.out::println);
    }
}


