package test.program;

import java.util.stream.IntStream;

public class TestStringOccurance {
    public static void main(String[] args) {
        String val = "BhiBhibhi";

        long count = IntStream.range(0, val.length() - 2)
                .filter(i -> (val.charAt(i) == 'B' || val.charAt(i) == 'b') &&
                             val.startsWith("hi", i + 1))
                .count();

        System.out.println("Count: " + count);
    }
}

