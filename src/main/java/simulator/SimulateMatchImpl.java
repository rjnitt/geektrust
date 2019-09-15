package simulator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Util.CricketUtils;
import pojo.Commentry;
import pojo.Inning;
import pojo.Match;
import pojo.Player;
import pojo.Summary;

public class SimulateMatchImpl implements ISimulateMatch {

	@Override
	public Inning firstInning(Match m, Map<Integer, Player> players) throws FileNotFoundException {

		Inning result = new Inning();
		Integer playerDown = 2;
		Player striker = players.get(1);
		Player nonStriker = players.get(2);
		int teamPlayerSize = m.getMaximumPlayer().intValue();
		// int targetScore = m.getTarget().intValue();
		int currentScore = 0;
		int ballAllowedPerOver = m.getBallAllowedPerOver().intValue();
		int maximumOver = m.getMaximumOver().intValue();
		int maximumBalls = ballAllowedPerOver * maximumOver;
		int currentBall = 1;
		// int currentOver = 0;
		Map<Integer, Player> afterMatch = new HashMap<Integer, Player>();
		Summary summary = new Summary();
		Commentry comment = new Commentry();
		List<Commentry> commentryList = new ArrayList<>();
		List<Player> rotateStrike = new ArrayList<Player>();

		for (currentBall = 1; currentBall <= maximumBalls; currentBall++) {
			// 0.1 rohit score 1 run
			Integer runCame = striker.runGenerator().intValue();
			striker.setBallFaced(striker.getBallFaced() + 1);

			if (runCame >= 0) { // score
				striker.setRunScore(striker.getRunScore() + runCame);
				currentScore += runCame;
			}

			if (runCame < 0) { // out
				striker.setIsOut(true);
				comment = new Commentry(striker.getName(), true, currentBall);
				commentryList.add(comment);
				playerDown++;
				afterMatch.put(striker.getBattingOrder(), striker);
				afterMatch.put(nonStriker.getBattingOrder(), nonStriker);
//				summary = new Summary(currentScore, Boolean.FALSE);
				break;
			}
			// run scored

			comment = new Commentry(striker.getName(), currentBall, runCame, false);
			commentryList.add(comment);

			if (runCame % 2 == 1) { // odd runs
				rotateStrike = CricketUtils.rotateStrike(striker, nonStriker);
				striker = rotateStrike.get(1);
				nonStriker = rotateStrike.get(0);
			}

		}
		
//		summary = new Summary((maximumBalls-currentBall),(teamPlayerSize - playerDown), currentScore,
//				"Enchai", Boolean.FALSE);
		
		summary = new Summary(currentScore, Boolean.FALSE);
		
		if(playerDown == teamPlayerSize) {
			afterMatch.put(striker.getBattingOrder(), striker);
			afterMatch.put(nonStriker.getBattingOrder(), nonStriker);
		}
		
		result.setCommentry(commentryList);
		result.setSummary(summary);
		result.setPlayer(afterMatch);
		return result;

	}

	@Override
	public Inning targetInning(Match m, Map<Integer, Player> players) throws FileNotFoundException {
		// "last-4-over.json"
//		Match m  = CricketUtils.transformMatchFromJson(matchname);
//		System.out.println(m);
//		Map<Integer, Player> players = CricketUtils.transformPlayerFromJson("player-list.json");
		Inning result = new Inning();
		Integer playerDown = 2;
		Player striker = players.get(1);
		Player nonStriker = players.get(2);
		int teamPlayerSize = m.getMaximumPlayer().intValue();
		int targetScore = m.getTarget().intValue();
		int currentScore = 0;
		int ballAllowedPerOver = m.getBallAllowedPerOver().intValue();
		int maximumOver = m.getMaximumOver().intValue();
		int maximumBalls = ballAllowedPerOver * maximumOver;
		int currentBall = 1;
		int currentOver = 0;
		Map<Integer, Player> afterMatch = new HashMap<Integer, Player>();
		Summary summary = new Summary();
		Commentry comment = new Commentry();
		List<Commentry> commentryList = new ArrayList<>();
		List<Player> rotateStrike = new ArrayList<Player>();
		
		summary = new Summary(currentScore, Boolean.FALSE);
		
		for (currentBall = 1; currentBall <= maximumBalls; currentBall++) {

			// 0.1 rohit score 1 run
			Integer runCame = striker.runGenerator().intValue();
			striker.setBallFaced(striker.getBallFaced() + 1);

			if (runCame >= 0) { // score
				striker.setRunScore(striker.getRunScore() + runCame);
				currentScore += runCame;
			}

			if (runCame < 0) { // out
				striker.setIsOut(true);
//				System.out.println(currentBall / ballAllowedPerOver + "." + currentBall % ballAllowedPerOver + " "
//						+ striker.getName() + " got out. ");

				comment = new Commentry(striker.getName(), true, currentBall);
				commentryList.add(comment);

				playerDown++;

				if (currentBall % 6 == 0) {
					currentOver++;
					comment = new Commentry(maximumOver - currentOver, targetScore - currentScore, Boolean.TRUE);
					commentryList.add(comment);
				}

				afterMatch.put(striker.getBattingOrder(), striker);
				if (playerDown <= teamPlayerSize) {
					striker = players.get(playerDown);
					continue;
				} else {
					afterMatch.put(nonStriker.getBattingOrder(), nonStriker);
					summary = new Summary(currentScore, Boolean.FALSE);
//					System.out.println("All out");
					break;
				}
			}
			// run scored

			comment = new Commentry(striker.getName(), currentBall, runCame, false);
			commentryList.add(comment);

			if (runCame % 2 == 1) { // odd runs
				rotateStrike = CricketUtils.rotateStrike(striker, nonStriker);
				striker = rotateStrike.get(1);
				nonStriker = rotateStrike.get(0);
			}

			if (currentScore >= targetScore) { // score
				summary = new Summary((maximumBalls - currentBall), (teamPlayerSize - playerDown), currentScore,
						"Lengaluru", Boolean.TRUE);
				afterMatch.put(striker.getBattingOrder(), striker);
				afterMatch.put(nonStriker.getBattingOrder(), nonStriker);
				break;
			}

			if (currentBall % 6 == 0) {
				currentOver++;
//				System.out.println("--");
//				System.out.println("Over: " + (currentBall / 6) + " Run Left : " + (targetScore - currentScore));
				comment = new Commentry(maximumOver - currentOver, targetScore - currentScore, Boolean.TRUE);
				commentryList.add(comment);
				rotateStrike = CricketUtils.rotateStrike(striker, nonStriker);
				striker = rotateStrike.get(1);
				nonStriker = rotateStrike.get(0);
			}

		}

//		 summary = new Summary(currentScore, Boolean.FALSE);
		afterMatch.put(striker.getBattingOrder(), striker);
		afterMatch.put(nonStriker.getBattingOrder(), nonStriker);

//		System.out.println("Player Name Run Scored ( Ball faced ) ");
//		Map<Integer, Player> players2 = summary.getPlayers();
//		for (Entry<Integer, Player> e : players2.entrySet()) {
//			Player value = e.getValue();
//			System.out.println(value.getName() + " " + value.getRunScore() + " ( " + value.getBallFaced() + " ) ");
//		}
		result.setCommentry(commentryList);
		result.setSummary(summary);
		result.setPlayer(afterMatch);
		return result;

	}
}
