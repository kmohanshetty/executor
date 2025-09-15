package test.program.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExampleCollectors {

   public static void main(String[] args) {

      List<String> names =
          Arrays.asList("Jon", "Ajeet", "Steve",
             "Ajeet", "Jon", "Ajeet");

      Map<String, Long> map =
      names.stream().collect(
          Collectors.groupingBy(
             Function.identity(), Collectors.counting()
          )
      );

      System.out.println(map);
      
      //sorted order
      List<String> sortedList = names.stream().sorted().collect(Collectors.toList());
      System.out.println(sortedList);

      //reverse order
      List<String> reverse = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
      System.out.println(reverse);
   }
}