package modal;

public class Player {
	private String name;
	private int score;
	private int ball;
	private float strickRate;
	private int four;
	private int six;
	
	public Player(String name, int score, int ball, float strickRate, int four, int six) {
		
		this.name = name;
		this.score = score;
		this.ball = ball;
		this.strickRate = strickRate;
		this.four = four;
		this.six = six;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public float getStrickRate() {
		return ((float)this.score/this.ball)*100;
	}

	public void setStrickRate(float strickRate) {
		this.strickRate = strickRate;
	}

	public int getFour() {
		return four;
	}

	public void setFour(int four) {
		this.four = four;
	}

	public int getSix() {
		return six;
	}

	public void setSix(int six) {
		this.six = six;
	}

}
