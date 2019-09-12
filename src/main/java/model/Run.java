package model;

import java.util.Random;

import pojo.PlayerProbabilityRun;

public class Run extends PlayerProbabilityRun implements IRunGenerator {

//	@Override
	public Long runGenerator() {

//		PlayerProbabilityRun p = getProbability();

//		Long run = 0L;
		Long dotP = getDot();
		Long oneP = getDot() + getOne();
		Long twoP= getDot() + getOne() + getTwo();
		Long threeP= getDot() + getOne() + getTwo() + getThree();
		Long fourP= getDot() + getOne() + getTwo() + getThree() + getFour();
		Long fiveP= getDot() + getOne() + getTwo() + getThree() + getFour() + getFive();
		Long sixP= getDot() + getOne() + getTwo() + getThree() + getFour() + getFive() + getSix();
		Long wicketP= getDot() + getOne() + getTwo() + getThree() + getFour() + getFive() + getSix() + getWicket();

		// long ct = System.currentTimeMillis();
		// long runScored = Math.floorMod((System.currentTimeMillis() * 125) % 123, wicketP);
		Random rand = new Random();
		long runScored = Math.floorMod(rand.nextLong() * 17, wicketP);
		// System.out.println("runScored: " + runScored);

		if(runScored <= dotP) 
			return 0L;
		if(runScored <= oneP) 
			return 1L;
		if(runScored <= twoP) 
			return 2L;
		if(runScored <= threeP) 
			return 3L;
		if(runScored <= fourP) 
			return 4L;
		if(runScored <= fiveP) 
			return 5L;
		if(runScored <= sixP) 
			return 6L;
		if(runScored <= wicketP) 
			return -1L;
		
		return runScored;

	}

//	public Long runScore() {
//		return runGenerator();
//	}

}
