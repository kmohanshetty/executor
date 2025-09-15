package test.program.sellinbulkupld.queries;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApacheCommonsLogParser {
    public static void main(String[] args) throws Exception {
        // Path to your log file
    	String fileName = "sellin-local-mon-arc-query.log";
        InputStream inputStream = ApacheCommonsLogParser.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            System.err.println("File not found: " + fileName);
            return;
        }
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String line = "";
        
        System.out.println("Reading file from classpath:");
        
        Pattern pattern = Pattern.compile("(?i)Hibernate:\\s*(.*)");
        
        
        while ((line = reader.readLine()) != null) {
        	Matcher matcher = pattern.matcher(line);
        	
        	if (matcher.find()) {
                String query = matcher.group(1).trim();
                System.out.println(query);
        	}
        	
//            System.out.println(line);
        }
        
    }
}

