package fileinout_complete;


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
				if(isHead){
					isHead = false;
					continue;
				}
				
				//Complete this part!
				String[] strParts = thisLine.split("\t");
				//use split function
				//use \t for division
				String id = strParts[0];
				int scoreMath = Integer.parseInt(strParts[1]);
				int scoreScience = Integer.parseInt(strParts[2]);
				int scoreHistory = Integer.parseInt(strParts[3]);
				int scoreEnglish = Integer.parseInt(strParts[4]);
				
				Student std = new Student(id);
				//uset set function
				std.setScoreMath(scoreMath);
				std.setScoreScience(scoreScience);
				std.setScoreHistory(scoreHistory);
				std.setScoreEnglish(scoreEnglish);
				
				//add to stdList
				stdList.add(std);
			}       
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(stdList);
		
	}
}