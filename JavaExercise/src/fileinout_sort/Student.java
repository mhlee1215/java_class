package fileinout_sort;

//class for data saving
public class Student {
	String id;
	int scoreMath;
	int scoreScience;
	int scoreHistory;
	int scoreEnglish;

	public Student(String id){
		this.id = id;
	}

	public int getScoreMath() {
		return scoreMath;
	}
	public void setScoreMath(int scoreMath) {
		this.scoreMath = scoreMath;
	}
	public int getScoreScience() {
		return scoreScience;
	}
	public void setScoreScience(int scoreScience) {
		this.scoreScience = scoreScience;
	}
	public int getScoreHistory() {
		return scoreHistory;
	}
	public void setScoreHistory(int scoreHistory) {
		this.scoreHistory = scoreHistory;
	}
	public int getScoreEnglish() {
		return scoreEnglish;
	}
	public void setScoreEnglish(int scoreEnglish) {
		this.scoreEnglish = scoreEnglish;
	}
	@Override
	public String toString() {
		return id + "\t" + scoreMath+"\t"+
				scoreScience+"\t"+scoreHistory+"\t"+scoreEnglish;
	}

	public int compareTo(Student std){
		//ascending order
		//return this.scoreMath - std.getScoreMath();

		//decending order
		return std.getScoreMath() - this.scoreMath;
	}
}
