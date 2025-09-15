package test.program.xml.transform;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;

public class XmlToJsonConverter {
    public static void main(String[] args) {
        try {
            // Load the XSLT stylesheet
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            StreamSource xsltSource = new StreamSource("hello.xsl");
            Transformer transformer = transformerFactory.newTransformer(xsltSource);

            // Load the XML input
            StreamSource xmlSource = new StreamSource("hello.xml");

            // Perform the transformation
            StringWriter jsonWriter = new StringWriter();
            transformer.transform(xmlSource, new StreamResult(jsonWriter));

            // Retrieve the JSON output
            String jsonOutput = jsonWriter.toString();
            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
