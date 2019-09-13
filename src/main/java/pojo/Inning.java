package pojo;

import java.util.List;
import java.util.Map;

public class Inning {

	private Map<Integer, Player> player;
	private List<Commentry> commentry;
	private Long bowlNumber;
	private Long remainRun;
	private Long wicketFallen;
	private Boolean isWinner;

	
	public Map<Integer, Player> getPlayer() {
		return player;
	}

	public void setPlayer(Map<Integer, Player> player) {
		this.player = player;
	}

	public List<Commentry> getCommentry() {
		return commentry;
	}

	public void setCommentry(List<Commentry> commentry) {
		this.commentry = commentry;
	}

	public Long getBowlNumber() {
		return bowlNumber;
	}

	public void setBowlNumber(Long bowlNumber) {
		this.bowlNumber = bowlNumber;
	}

	public Long getRemainRun() {
		return remainRun;
	}

	public void setRemainRun(Long remainRun) {
		this.remainRun = remainRun;
	}

	public Long getWicketFallen() {
		return wicketFallen;
	}

	public void setWicketFallen(Long wicketFallen) {
		this.wicketFallen = wicketFallen;
	}

	public Boolean getIsWinner() {
		return isWinner;
	}

	public void setIsWinner(Boolean isWinner) {
		this.isWinner = isWinner;
	}

}
