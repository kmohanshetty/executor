package test.program.streams;

import java.util.stream.IntStream;

public class Fibonacci {

  public static void main(String[] args) {
    int n = 10;
    
    IntStream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
             .limit(n)
             .mapToObj(f -> f[0])
             .forEach(System.out::println);
  }

}