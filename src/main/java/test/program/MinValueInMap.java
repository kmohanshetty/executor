package test.program;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MinValueInMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 100);
        map.put(2, 50);
        map.put(3, 75);

        // Find the minimum value using streams
        Optional<Integer> minValue = map.values()
                                        .stream()
                                        .min(Integer::compareTo);

        // Print result
        minValue.ifPresent(value -> System.out.println("Lowest value: " + value));
    }
}

