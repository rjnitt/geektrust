package Util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import pojo.Match;
import pojo.Player;

public class CricketUtils {

	public static JSONObject getFileFromResources(String filename) throws FileNotFoundException {
		ClassLoader classLoader = new CricketUtils().getClass().getClassLoader();
		InputStream resourceAsStream = classLoader.getResourceAsStream(filename);
		JSONParser parser = new JSONParser();
		// Use JSONObject for simple JSON and JSONArray for array of JSON.
		Object obj = null;

		if (resourceAsStream != null) {
			try {
				obj = parser.parse(new InputStreamReader(resourceAsStream));
			} catch (Exception e) {
				System.out.println("No file found name " + filename);
			}
		} else {
			throw new FileNotFoundException("filename : " + filename);
		}

		return (JSONObject) obj;

	}

	public static Match transformMatchFromJson(String filename) throws FileNotFoundException {
		JSONObject json = getFileFromResources(filename);

		Match p = new Match();

		p.setMatchName((String) json.get("matchName"));
		if (json.containsKey("target")) {
			p.setTarget((Long) json.get("target"));
		}
		p.setMaximumOver((Long) json.get("maximumOver"));
		p.setMaximumPlayer((Long) json.get("teamSize"));
		p.setBallAllowedPerOver((Long) json.get("ballAllowedPerOver"));

//			p.setWicketFall(0);
//			p.setIsOut(false);
//			p.setBallFaced(0);
//			p.setRunScore(0);

		return p;
	}

	public static Map<Integer, Player> transformPlayerFromJson(String filename) throws FileNotFoundException {
		Map<Integer, Player> m = new HashMap<Integer, Player>();
		JSONObject playerJsonList = getFileFromResources(filename);
		JSONArray ja = (JSONArray) playerJsonList.get("players");
//		List<Player> list = new ArrayList<Player>();
		for (Object object : ja) {
			JSONObject json = (JSONObject) object;
			Player p = new Player();

			p.setName((String) json.get("name"));
			p.setHand((String) json.get("hander"));
			p.setRole((String) json.get("role"));
			Long long1 = (Long) json.get("battingOrder");
			p.setBattingOrder(long1.intValue());

			p.setIsOut(false);
			p.setBallFaced(0);
			p.setRunScore(0);
//			p.setTotalRunScore(0);

			JSONObject probObject = (JSONObject) json.get("probability");
			// PlayerProbabilityRun pp = PlayerProbabilityRun.transformFromJson(probObject);

			p.setDot((Long) probObject.get("dot"));
			p.setFive((Long) probObject.get("five"));
			p.setFour((Long) probObject.get("four"));
			p.setOne((Long) probObject.get("one"));
			p.setSix((Long) probObject.get("six"));
			p.setThree((Long) probObject.get("three"));
			p.setTwo((Long) probObject.get("two"));
			p.setWicket((Long) probObject.get("wicket"));

			// p.setProbability(pp);
//			list.add(p);
			m.put(p.getBattingOrder().intValue(), p);

		}

		return m;
	}

	public static List<Player> rotateStrike(Player pw1, Player pw2) {
//		PlayerWrapper pw1 = new PlayerWrapper(p1);
//		PlayerWrapper pw2 = new PlayerWrapper(p2);
		List<Player> l = new ArrayList<Player>();

		Player temp = pw1;
		pw1 = pw2;
		pw2 = temp;
		l.add(pw2);
		l.add(pw1);
		return l;
	}

}
