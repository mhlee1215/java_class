package fileinout;


import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderDemo {
	public static void main(String[] args) throws Exception {

		String  thisLine = null;
		try{
			// open input stream test.txt for reading purpose.
			FileReader fr = new FileReader("fileName.txt");
			BufferedReader br = new BufferedReader(fr);
			while ((thisLine = br.readLine()) != null) {
				System.out.println(thisLine);
			}       
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}