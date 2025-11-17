package test.program;

import java.util.*;

/**
 * i have a string array String[] strArr = {"baseball", "a,ba,base,ba,ball"} as input, 
 * i need to split strArr[1] as comma seperated string into collection of words and 
 * compare it with strArr[0] by splitting it into 2 parts and comparing it with the 
 * collection created earlier if found give me those words as comma seperated, 
 * in this example give me base,ball in java
 */
public class SplitMatchExample {
    public static void main(String[] args) {
//        String[] strArr = {"baseball", "a,ba,base,ba,ball"};
        String[] strArr = {"abcdefgh", "a,bc,abc,abcd,abcde,efgh"};
        String word = strArr[0];
        String[] dict = strArr[1].split(",");

        List<String> dictList = Arrays.asList(dict);
        List<String> result = new ArrayList<>();

        // Try all possible splits
        for (int i = 1; i < word.length(); i++) {
            String first = word.substring(0, i);
            String second = word.substring(i);

            if (dictList.contains(first) && dictList.contains(second)) {
                result.add(first);
                result.add(second);
                break; // stop at the first valid split
            }
        }

        if (!result.isEmpty()) {
            System.out.println(String.join(",", result));
        } else {
            System.out.println("No valid split found");
        }
    }
}
