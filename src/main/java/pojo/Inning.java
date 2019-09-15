package pojo;

import java.util.List;
import java.util.Map;

public class Inning {

	private Map<Integer, Player> player;
	private List<Commentry> commentry;
	private Summary summary;

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

	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

}
