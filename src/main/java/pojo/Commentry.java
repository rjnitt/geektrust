package pojo;

public class Commentry {

//	private String bowler;
	private String batsman;
	private Integer run;
	private boolean isOut;
	private Integer bowlNumber;
	private boolean isOver;

	private Commentry(String bats, Integer run, Integer bowl) {
		this.batsman = bats;
		this.run = run;
		this.bowlNumber = bowl;
		this.isOut = false;
	}

	private Commentry(String bats, Integer run, Integer bowl, Boolean flag) {
		this.batsman = bats;
		this.run = run;
		this.bowlNumber = bowl;
		this.isOut = flag;
	}

	public String getBatsman() {
		return batsman;
	}

	public void setBatsman(String batsman) {
		this.batsman = batsman;
	}

	public Integer getRun() {
		return run;
	}

	public void setRun(Integer run) {
		this.run = run;
	}

	public boolean isOut() {
		return isOut;
	}

	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}

	public Integer getBowl() {
		return bowlNumber;
	}

	public void setBowl(Integer bowl) {
		this.bowlNumber = bowl;
	}

	public boolean isOver() {
		return isOver;
	}

	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}

}
