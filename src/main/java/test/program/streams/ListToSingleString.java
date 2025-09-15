package test.program.streams;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListToSingleString {

	public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        String result = list.stream()
                            .collect(Collectors.joining("##"));

        System.out.println(result); // Output: one##two##three
    }

}
