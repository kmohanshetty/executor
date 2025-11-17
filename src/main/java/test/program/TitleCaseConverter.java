package test.program;

public class TitleCaseConverter {

    public static void main(String[] args) {
        String input = "iNDIAN express hiNDU";
        String output = toTitleCase(input);
        System.out.println(output); // Indian Express Hindu
    }

    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        String[] words = str.split("\\s+"); // split by spaces

        for (String word : words) {
            if (!word.isEmpty()) {
                // Lowercase everything, then uppercase the first character
                String first = word.substring(0, 1).toUpperCase();
                String rest = word.substring(1).toLowerCase();
                result.append(first).append(rest).append(" ");
            }
        }

        return result.toString().trim();
    }
}

