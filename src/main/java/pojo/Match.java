package pojo;

public class Match {

	private String matchName;
	private Long partnershipAllow;
	private Long maximumOver;
	private Long target;
	private Long ballAllowedPerOver;

//	private Integer wicketFall;
//	private Player striker;
//	private Player nonStriker;

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public Long getPartnershipAllow() {
		return partnershipAllow;
	}

	public void setPartnershipAllow(Long partnershipAllow) {
		this.partnershipAllow = partnershipAllow;
	}

	public Long getMaximumOver() {
		return maximumOver;
	}

	public void setMaximumOver(Long maximumOver) {
		this.maximumOver = maximumOver;
	}

	public Long getTarget() {
		return target;
	}

	public void setTarget(Long target) {
		this.target = target;
	}

	public Long getBallAllowedPerOver() {
		return ballAllowedPerOver;
	}

	public void setBallAllowedPerOver(Long ballAllowedPerOver) {
		this.ballAllowedPerOver = ballAllowedPerOver;
	}

	@Override
	public String toString() {
		return "Match [matchName=" + matchName + ", partnershipAllow=" + partnershipAllow + ", maximumOver="
				+ maximumOver + ", target=" + target + ", ballAllowedPerOver=" + ballAllowedPerOver + "]";
	}

	

}
