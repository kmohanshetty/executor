package test.program.xml.transform;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

class XSLTransformer {
	public static void main(String[] args) {
		try {
			File sf = new File(args[0]); // source file
			File rf = new File(args[1]); // result file
			File tf = new File(args[2]); // template file
			
			TransformerFactory f = TransformerFactory.newInstance();
			
			Transformer t = f.newTransformer(new StreamSource(tf));
			
			Source s = new StreamSource(sf);
			
			Result r = new StreamResult(rf);
			
			t.transform(s, r);
		} catch (TransformerConfigurationException e) {
			System.out.println(e.toString());
		} catch (TransformerException e) {
			System.out.println(e.toString());
		}
	}
}