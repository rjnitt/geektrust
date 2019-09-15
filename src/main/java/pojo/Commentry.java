package pojo;

public class Commentry {

//	private String bowler;
	private String batsman;
	private Integer run;
	private Boolean isOut;
	private Integer bowlNumber;
	private Boolean isOver;
	private Integer remainingRun;
	private Integer remainingOver;


	public Integer getBowlNumber() {
		return bowlNumber;
	}

	public void setBowlNumber(Integer bowlNumber) {
		this.bowlNumber = bowlNumber;
	}

	public Integer getRemainingRun() {
		return remainingRun;
	}

	public void setRemainingRun(Integer remainingRun) {
		this.remainingRun = remainingRun;
	}

	public Integer getRemainingOver() {
		return remainingOver;
	}

	public void setRemainingOver(Integer remainingOver) {
		this.remainingOver = remainingOver;
	}

	public Commentry() {
		super();
	}

	public Commentry(String batsman, boolean isOut, Integer bowlNumber) {
		super();
		this.batsman = batsman;
		this.isOut = isOut;
		this.bowlNumber = bowlNumber;
	}
	
	public Commentry(String batsman, Integer run, boolean isOut, Integer bowlNumber, boolean isOver) {
		super();
		this.batsman = batsman;
		this.run = run;
		this.isOut = isOut;
		this.bowlNumber = bowlNumber;
		this.isOver = isOver;
	}

	public Commentry(String bats, Integer run, Integer bowl) {
		this.batsman = bats;
		this.run = run;
		this.bowlNumber = bowl;
		this.isOut = false;
	}

	public Commentry(String bats, Integer bowl,Integer run,  Boolean flag) {
		this.batsman = bats;
		this.run = run;
		this.bowlNumber = bowl;
		this.isOut = flag;
	}

	public Commentry(int remainingOver, int remainingRun, boolean isOver) {
		this.remainingOver = remainingOver;
		this.remainingRun = remainingRun;
		this.isOver = isOver;
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

	public Boolean isOut() {
		return isOut;
	}

	public void setOut(Boolean isOut) {
		this.isOut = isOut;
	}

	public Integer getBowl() {
		return bowlNumber;
	}

	public void setBowl(Integer bowl) {
		this.bowlNumber = bowl;
	}

	public Boolean isOver() {
		return isOver;
	}

	public void setOver(Boolean isOver) {
		this.isOver = isOver;
	}

}
