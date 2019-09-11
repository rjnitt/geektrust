package Util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import pojo.Player;
import pojo.PlayerProbabilityRun;
import pojo.PlayerWrapper;

public class CricketUtils {

	public JSONObject getFileFromResources(String filename) throws FileNotFoundException {
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
	
	
	public static List<Player> transformFromJson(JSONObject playerJsonList) {
		JSONArray ja = (JSONArray) playerJsonList.get("players");
		List<Player> list = new ArrayList<Player>();
		for (Object object : ja) {
			JSONObject json = (JSONObject) object;
			Player p = new Player();
			
			p.setName((String) json.get("name"));
			p.setHand((String) json.get("hander"));
			p.setRole((String) json.get("role"));
			p.setBattingOrder((Long) json.get("battingOrder"));
			
			JSONObject probObject = (JSONObject) json.get("probability");
			// PlayerProbabilityRun pp = PlayerProbabilityRun.transformFromJson(probObject);
			
			p.setDot((Long)probObject.get("dot"));
			p.setFive((Long)probObject.get("five"));
			p.setFour((Long)probObject.get("four"));
			p.setOne((Long)probObject.get("one"));
			p.setSix((Long)probObject.get("six"));
			p.setThree((Long)probObject.get("three"));
			p.setTwo((Long)probObject.get("two"));
			p.setWicket((Long)probObject.get("wicket"));
			
			// p.setProbability(pp);
			list.add(p);
		}

		return list;
	}
	
	public static List<Player> rotateStrike (Player pw1 , Player pw2) {
//		PlayerWrapper pw1 = new PlayerWrapper(p1);
//		PlayerWrapper pw2 = new PlayerWrapper(p2);
		List<Player> l = new ArrayList<Player>();
		
		Player temp = pw1;
		pw1 = pw2;
		pw2 = temp;
		l.add(pw1);
		l.add(pw2);
		return l;
	}
	

}
