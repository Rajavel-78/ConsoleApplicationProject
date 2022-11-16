package modal;

public class Bowler {
	private String name;
	private int ball;
	private int other;
	private int wicket;
	private int run;

	public Bowler(String name, int ball, int other, int wicket,int run) {
		super();
		this.name = name;
		this.ball = ball;
		this.other = other;
		this.wicket = wicket;
		this.run=run;
	}
    public int getRun() {
    	return run;
    }
    public void setRun(int run) {
    	this.run=run;
    } 
	public int getWicket() {
		return wicket;
	}

	public void setWicket(int wicket) {
		this.wicket = wicket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public int getOther() {
		return other;
	}

	public void setOther(int other) {
		this.other = other;
	}

	
	public void display() {
		System.out.println(name+"\t"+(int)Math.floor(ball/6)+"."+(ball%6)+"\t"+other+"\t"+wicket+"\t"+run);
		
	}

	

}
