package simulator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		for(int i=0;i<m.getMaximumOver() ;i++) {
			for (int j = 1; j <= m.getBallAllowedPerOver() && currentScore < targetScore && m.getPartnershipAllow() >= playerDown  ; j++) {
				// 0.1 rohit score 1
				Integer runCame = striker.runGenerator().intValue();
				striker.setBallFaced(striker.getBallFaced() + 1);
				
				if (runCame < 0) { // out
					striker.setIsOut(true);
					System.out.println(i + "."  + j + " " + striker.getName() + " got out. ");	
					playerDown++;
					striker = players.get(playerDown);
				}
				
				if (runCame % 2 == 1) {
					striker.setRunScore(striker.getRunScore() + runCame);
					List<Player> rotateStrike = CricketUtils.rotateStrike(striker, nonStriker);
					striker = rotateStrike.get(1);
					nonStriker = rotateStrike.get(0);
					String s = (runCame > 1 ) ? " runs" : " run";
					System.out.println(i + "."  + j + " " + striker.getName() +  " score " + runCame  + s);
				}
				
				if (runCame % 2 == 0) {
					striker.setRunScore(striker.getRunScore() + runCame);
					String s = (runCame > 1 ) ? " runs" : " run";
					System.out.println(i + "."  + j + " " + striker.getName() +  " score " + runCame  + s);
				}
				
				currentScore += runCame;
				
			}
			
			System.out.println("--");
			System.out.println("Over " + (i+1) + " Run Left : " + (targetScore-currentScore));
			List<Player> rotateStrike = CricketUtils.rotateStrike(striker, nonStriker);
			striker = rotateStrike.get(1);
			nonStriker = rotateStrike.get(0);
			
		}

		System.out.println("Player Name Run Scored ( Ball faced ) ");
		
		for (Entry<Integer, Player> e : players.entrySet()) {
			Player value = e.getValue();
			System.out.println(value.getName() + " " + value.getRunScore() + " ( " + value.getBallFaced() + " ) ");
		}
		
		
	}
}
