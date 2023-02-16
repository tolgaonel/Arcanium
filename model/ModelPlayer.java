package model;
public class ModelPlayer implements Comparable<ModelPlayer> {
	private int lives = 3;
	private int score = 0;
	private String time;
	private String name;
	private String Surname;
	private String date;
	private String fordisplayscore;

	public ModelPlayer() {}

	public ModelPlayer(String name,String surname,String score,String time,String date){
		this.name = name;
		this.Surname = surname;
		this.time =time;
		this.fordisplayscore = score;
		this.date = date;
	}
	public void decreseLive() {
		lives--;
	}

	public int getLives() {
		return lives;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}


	public String getSurname() {
		return Surname;
	}
	public String getdispayscore() {
		return fordisplayscore;
	}
	public String getTime() {
		return time;
	}

	public String getDate() {
		return date;
	}

	@Override
	public int compareTo(ModelPlayer p) {
		int score1 = Integer.parseInt((this.getdispayscore()).substring(7));
		int score2 = Integer.parseInt((p.getdispayscore()).substring(7));
		return score1-score2;
	}	

}

