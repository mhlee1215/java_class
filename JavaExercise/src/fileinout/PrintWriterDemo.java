package fileinout;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriterDemo {
	public static void main(String[] args) throws Exception {
		String filename = "fileName.txt";
		String[] linesToWrite = new String[] { "abc", "bddd" };
		boolean appendToFile = true;

		PrintWriter pw = null;
		if (appendToFile) {
			pw = new PrintWriter(new FileWriter(filename, true));
		} else {
			pw = new PrintWriter(new FileWriter(filename));
		}
		for (int i = 0; i < linesToWrite.length; i++) {
			//Use like System.out.println
			pw.println(linesToWrite[i]);
		}
		pw.flush();
		pw.close();
	}
}