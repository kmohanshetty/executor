package test.program;

import java.util.Scanner;

public class SeihanWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Seihan week in the format YYYYWW
        System.out.print("Enter Seihan week (YYYYWW): ");
        String inputWeek = scanner.nextLine();

        extracted(inputWeek);
        
        scanner.close();
    }
    
    public static void extracted(String inputWeek) {
    	// Validate the input format
        if (inputWeek.length() != 6 || !inputWeek.matches("\\d{6}")) {
            System.out.println("Invalid input format. Please enter in YYYYWW format.");
            return;
        }

        // Extract year and week
        String year = inputWeek.substring(0, 4);
        int week = Integer.parseInt(inputWeek.substring(4));

        // Calculate previous week
        if (week == 1) {
            // If current week is 01, we need to go to the last week of the previous year
            year = String.valueOf(Integer.parseInt(year) - 1);
            week = 52; // Adjust to last week of the previous year
        } else {
            week -= 1; // Just subtract 1 from the week number
        }

        // Format output week to always have 2 digits for the week
        String previousWeek = year + String.format("%02d", week);
        
        // Output the previous week
        System.out.println("Previous Seihan week: " + previousWeek);
    }
}

