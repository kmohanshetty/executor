package test.program.sellinbulkupld.queries;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HibernateQueryExtractor {
    public static void main(String[] args) throws Exception {
    	String fileName = "log.txt";
    	
    	InputStream inputStream = ApacheCommonsLogParser.class.getClassLoader().getResourceAsStream(fileName);
    	
    	if (inputStream == null) {
            System.err.println("File not found: " + fileName);
            return;
        }
    	
    	 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
         String line = "";
         
         System.out.println("Reading file from classpath:");

        // Read all lines

        // Match "Hibernate:" anywhere in the line, ignore case
        Pattern pattern = Pattern.compile("(?i)Hibernate:\\s*(.*)");

        while ((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String sqlQuery = matcher.group(1).trim();
                System.out.println(sqlQuery);
            }
        }
    }
}

