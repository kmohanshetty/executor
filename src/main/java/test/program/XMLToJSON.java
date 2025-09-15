package test.program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class XMLToJSON {

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	public static String TEST_XML_STRING =
			"<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";

	public static void main(String[] args) {
		try {
			System.out.println("Simplest xml to json here:");
			JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
			String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			System.out.println(jsonPrettyPrintString);

			System.out.println("Complex xml to json here:");

			FileInputStream fios = new FileInputStream(new File("test.xml"));
			String fileContent = getFileContent(fios,"UTF-8");
			
			JSONObject xmlJSONObj2 = XML.toJSONObject(fileContent);
			String jsonPrettyPrintString2 = xmlJSONObj2.toString(PRETTY_PRINT_INDENT_FACTOR);
			
			System.out.println("FileContent: "+fileContent);
			System.out.println("Json: "+jsonPrettyPrintString2);

		} catch (JSONException je) {
			System.out.println(je.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static String getFileContent(
			FileInputStream fis,
			String          encoding ) throws IOException
	{
		try( BufferedReader br =
				new BufferedReader( new InputStreamReader(fis, encoding )))
		{
			StringBuilder sb = new StringBuilder();
			String line;
			while(( line = br.readLine()) != null ) {
				sb.append( line );
				sb.append( '\n' );
			}
			return sb.toString();
		}
	}
}
