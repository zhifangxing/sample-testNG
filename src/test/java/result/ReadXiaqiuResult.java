package result;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.swing.text.html.parser.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.xml.XmlDependencies;
import org.xml.sax.SAXException;

public class ReadXiaqiuResult {
	
	
	public static String readXml() throws Exception{
		File file = new File("/Users/zhifang.xing/git/sample-testNG/test-output/junitreports/TEST-xiaqiu.LaunchXiaqiuTest.xml");
		String text = "执行用例耗时：";
		String time = null;
		String result = null;
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = (Document) builder.parse(file);
		NodeList bookList = doc.getElementsByTagName("testsuite");
		for (int i = 0; i < bookList.getLength(); i++) {
			time = bookList.item(i).getAttributes().getNamedItem("time").getNodeValue() + "s";
		}
		result = text + time;
		return result;
		
	}
	
	public static String readTxt() throws Exception{
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/zhifang.xing/git/sample-testNG/test-output/TestResult.txt"));
			String s = null;
			int i = 1;
			while((s = br.readLine())!=null){
				if (s.startsWith("====")) {
					i++;
				}
				if (s.startsWith("PASSED")||s.startsWith("FAILED")) {
					result = result.append(System.lineSeparator() + s );
					
				}
				
				if ((i % 2 == 0) || s.startsWith("====")) {
					result = result.append(System.lineSeparator() + s );
					
				}
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result.toString();
	}
	
	public static void writeFile(String fileName) throws Exception{
		try {
			FileWriter fileWriter = new FileWriter(new File(fileName));
			BufferedWriter buWriter = new BufferedWriter(fileWriter);
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String date = dateFormat.format(now);
			fileWriter.write(date + "\n");
			fileWriter.write(readXml());
			fileWriter.write(readTxt());
			fileWriter.flush();
			fileWriter.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws Exception  {
		
		String resultFile = "/Users/zhifang.xing/git/sample-testNG/src/test/java/result/resultXiaqiu.txt";
		writeFile(resultFile);
		

	}

}
