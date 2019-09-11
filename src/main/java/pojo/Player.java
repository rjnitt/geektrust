package pojo;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Run;

public class Player extends Run {

	private String name;
	private String hand;
	private String role;
	private Long battingOrder;
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

	

	@Override
	public String toString() {
		return "Player [name=" + name + ", hand=" + hand + ", role=" + role + ", battingOrder=" + battingOrder
				+  "]";
	}
}
