package simulator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import Util.CricketUtils;
import pojo.Match;
import pojo.Player;

public class SimulateMatch {
	
	public void firstInning() throws FileNotFoundException {
		
		
	}
	
	public void targetInning(String matchname) throws FileNotFoundException {
		// "last-4-over.json"
		Match m  = CricketUtils.transformMatchFromJson(matchname);
		System.out.println(m);
		
		Map<Integer, Player> players = CricketUtils.transformPlayerFromJson("player-list.json");
		Integer playerDown = 2;
		
		Player striker = players.get(1);
		Player nonStriker = players.get(2);
		
		Long targetScore = m.getTarget();
		Long currentScore  = 0L;
		for(int i=0;i<m.getMaximumOver();i++) {
			for (int j = 1; j <= m.getBallAllowedPerOver(); j++) {
				// 0.1 
				
			}
			
		}
		
		
	}
}
