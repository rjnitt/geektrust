package pojo;

import model.Run;

public class Player extends Run {

	private String name;
	private String hand;
	private String role;
	
	private Integer battingOrder;

	private Boolean isOut;
	private Integer ballFaced;
	private Integer runScore;
	private Integer totalRunScore;
	
//	private PlayerProbabilityRun probability;
	
	public Player() {
		
	}
	
	public Player(Integer run, Boolean flag ) {
		this.runScore +=  run;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getBattingOrder() {
		return battingOrder;
	}

	public void setBattingOrder(Integer battingOrder) {
		this.battingOrder = battingOrder;
	}

//	public PlayerProbabilityRun getProbability() {
//		return probability;
//	}
//
//	public void setProbability(PlayerProbabilityRun probability) {
//		this.probability = probability;
//	}

	

	public Boolean getIsOut() {
		return isOut;
	}

	public void setIsOut(Boolean isOut) {
		this.isOut = isOut;
	}

	public Integer getBallFaced() {
		return ballFaced;
	}

	public void setBallFaced(Integer ballFaced) {
		this.ballFaced = ballFaced;
	}

	public Integer getRunScore() {
		return runScore;
	}

	public void setRunScore(Integer runScore) {
		this.runScore = runScore;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", hand=" + hand + ", role=" + role + ", battingOrder=" + battingOrder
				+ ", isOut=" + isOut + ", ballFaced=" + ballFaced + ", runScore=" + runScore + "]";
	}

//	public Integer getTotalRunScore() {
//		return totalRunScore;
//	}

//	public void setTotalRunScore(Integer totalRunScore) {
//		this.totalRunScore = totalRunScore;
//	}
//
//	public void setTotalRunScoreA(Integer totalRunScore) {
//		this.totalRunScore += totalRunScore;
//	}
//	public void setBallFacedA(Integer totalRunScore) {
//		this.ballFaced += totalRunScore;
//	}

	
}
