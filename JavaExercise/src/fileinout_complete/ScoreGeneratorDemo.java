package fileinout_complete;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ScoreGeneratorDemo {
	public static void main(String[] args) throws Exception {
		String filename = "studentData.txt";
		String[] linesToWrite = new String[] { "abc", "bddd" };
		boolean appendToFile = false;
		
		PrintWriter pw = null;
		if (appendToFile) {
			pw = new PrintWriter(new FileWriter(filename, true));
		} else {
			pw = new PrintWriter(new FileWriter(filename));
		}
		
		pw.println("ID\tMATH\tSCIENCE\tHISTORY\tENGLISH");
		int studentNum = 100;
		int idStart = 10000;
		for (int i = 0; i < studentNum; i++) {
			//Use like System.out.println
			//pw.println(linesToWrite[i]);
			Student std = new Student(Integer.toString(idStart+i));
			std.setScoreMath((int)(Math.random()*100));
			std.setScoreScience((int)(Math.random()*100));
			std.setScoreHistory((int)(Math.random()*100));
			std.setScoreEnglish((int)(Math.random()*100));
			pw.println(std.toString());
		}
		pw.flush();
		pw.close();
	}
}