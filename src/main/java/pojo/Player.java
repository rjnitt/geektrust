package pojo;

import model.Run;

public class Player extends Run {

	private String name;
	private String hand;
	private String role;
	
	private Long battingOrder;

	private Boolean isOut;
	private Integer ballFaced;
	private Integer runScore;
	
//	private PlayerProbabilityRun probability;

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

	public Long getBattingOrder() {
		return battingOrder;
	}

	public void setBattingOrder(Long battingOrder) {
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

	
}
