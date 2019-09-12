package Util;

import java.io.FileNotFoundException;

import simulator.SimulateMatch;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

//		CricketUtils file = new CricketUtils();
//		JSONObject playerJsonList = file.getFileFromResources("player-list.json");
//		System.out.println(playerJsonList);

//		List<Player> l = CricketUtils.transformPlayerFromJson(playerJsonList);
//		Player player1 = l.get(0);
//		Player player2 = l.get(1);
//		
//		System.out.println("before" + player1);
//		List<Player> rotateStrike = CricketUtils.rotateStrike(player1, player2);
//		System.out.println(rotateStrike.get(0));
//		
		
//		for (int i = 0; i < 10; i++) {
//			System.out.println(player1.runGenerator());;
//		}

		SimulateMatch sm = new SimulateMatch();
		sm.startMatch();
	}

}
