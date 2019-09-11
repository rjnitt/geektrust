package model;

public class Player {

	private String name;
	private String hand;
	private String role;
	private Integer battingOrder;
	private PlayerProbabilityRun probability;

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

	public PlayerProbabilityRun getProbability() {
		return probability;
	}

	public void setProbability(PlayerProbabilityRun probability) {
		this.probability = probability;
	}
}
