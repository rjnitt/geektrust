package Util;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import pojo.Player;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		CricketUtils file = new CricketUtils();
		JSONObject playerJsonList = file.getFileFromResources("player-list.json");
//		System.out.println(playerJsonList);

		List<Player> l = CricketUtils.transformFromJson(playerJsonList);
		Player player1 = l.get(0);
		Player player2 = l.get(1);
		
		System.out.println("before" + player1);
		List<Player> rotateStrike = CricketUtils.rotateStrike(player1, player2);
		System.out.println(rotateStrike.get(0));

	}

}
