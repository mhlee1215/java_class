package fileinout_qz;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class ScoreReaderDemo {
	public static void main(String[] args) throws Exception {

		String  thisLine = null;
		List<Student> stdList = new Vector<Student>();
		try{
			// open input stream test.txt for reading purpose.
			FileReader fr = new FileReader("studentData.txt");
			BufferedReader br = new BufferedReader(fr);
			boolean isHead = true;
			while ((thisLine = br.readLine()) != null) {
				System.out.println(thisLine);
				//Skip the first raw
				if(isHead){
					isHead = false;
					continue;
				}
				
				//Complete this part!
				String[] strParts = thisLine.split("\t");
				//use split function
				//use \t for division
				
				
				//add to stdList
				//stdList.add(??);
			}       
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(stdList);
	}
}