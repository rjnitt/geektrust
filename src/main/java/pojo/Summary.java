package pojo;

public class Summary {

	private Integer ballLeft;
	private Integer wicketLeft;
	private Integer totalScore;
	private String winningTeam;
	private Boolean isVictory;

	public Summary(Integer ballLeft, Integer wicketLeft, Integer totalScore, String winningTeam, Boolean isVistory) {
//		super();
//		System.out.println(isVistory);
		this.ballLeft = ballLeft;
		this.wicketLeft = wicketLeft;
		this.totalScore = totalScore;
		this.winningTeam = winningTeam;
		this.isVictory = isVistory;
	}

	public Integer getBallLeft() {
		return ballLeft;
	}

	public Summary(Integer totalScore, Boolean isVistory) {
//		super();
//		System.out.println(isVistory);
		this.totalScore = totalScore;
		this.isVictory = isVistory;
	}

	public Summary() {
	}

	public void setBallLeft(Integer ballLeft) {
		this.ballLeft = ballLeft;
	}

	public Integer getWicketLeft() {
		return wicketLeft;
	}

	public void setWicketLeft(Integer wicketLeft) {
		this.wicketLeft = wicketLeft;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public String getWinningTeam() {
		return winningTeam;
	}

	public void setWinningTeam(String winningTeam) {
		this.winningTeam = winningTeam;
	}

	public boolean getIsVistory() {
		return isVictory;
	}

	public void setIsVistory(boolean isVistory) {
		this.isVictory = isVistory;
	}
	
	@Override
	public String toString() {
		return "Summary [ballLeft=" + ballLeft + ", wicketLeft=" + wicketLeft + ", totalScore=" + totalScore
				+ ", winningTeam=" + winningTeam + ", isVistory=" + isVictory + "]";
	}


}
