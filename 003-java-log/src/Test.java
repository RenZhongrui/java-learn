import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test {
	
	public static void main(String[] args) {
		try {
			LoganParser loganParser = new LoganParser("AgreeLogAESEncry".getBytes(), "AgreeLogAESEncry".getBytes());
			File infile = new File("D:\\Learn\\java-learn\\003-java-log\\src\\1586275200000");
			FileInputStream is = new FileInputStream(infile);
			File outFile = new File("D:\\Learn\\java-learn\\003-java-log\\src\\log.txt");
			FileOutputStream os = new FileOutputStream(outFile);
			loganParser.parse(is, os);
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}

}
