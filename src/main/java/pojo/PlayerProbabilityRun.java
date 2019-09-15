package pojo;

import org.json.simple.JSONObject;

public class PlayerProbabilityRun {

	private Long dot;
	private Long one;
	private Long two;
	private Long three;
	private Long four;
	private Long five;
	private Long six;
	private Long wicket;

	public Long getDot() {
		return dot;
	}

	public void setDot(Long dot) {
		this.dot = dot;
	}

	public Long getOne() {
		return one;
	}

	public void setOne(Long one) {
		this.one = one;
	}

	public Long getTwo() {
		return two;
	}

	public void setTwo(Long two) {
		this.two = two;
	}

	public Long getThree() {
		return three;
	}

	public void setThree(Long three) {
		this.three = three;
	}

	public Long getFour() {
		return four;
	}

	public void setFour(Long four) {
		this.four = four;
	}

	public Long getFive() {
		return five;
	}

	public void setFive(Long five) {
		this.five = five;
	}

	public Long getSix() {
		return six;
	}

	public void setSix(Long six) {
		this.six = six;
	}

	public Long getWicket() {
		return wicket;
	}

	@Override
	public String toString() {
		return "PlayerProbabilityRun [dot=" + dot + ", one=" + one + ", two=" + two + ", three=" + three + ", four="
				+ four + ", five=" + five + ", six=" + six + ", wicket=" + wicket + "]";
	}

	public void setWicket(Long wicket) {
		this.wicket = wicket;
	}

	public static PlayerProbabilityRun transformFromJson(JSONObject probObject) {
		PlayerProbabilityRun p = new PlayerProbabilityRun();
		p.setDot((Long) probObject.get("dot"));
		p.setFive((Long) probObject.get("five"));
		p.setFour((Long) probObject.get("four"));
		p.setOne((Long) probObject.get("one"));
		p.setSix((Long) probObject.get("six"));
		p.setThree((Long) probObject.get("three"));
		p.setTwo((Long) probObject.get("two"));
		p.setWicket((Long) probObject.get("wicket"));
		return p;
	}

}
