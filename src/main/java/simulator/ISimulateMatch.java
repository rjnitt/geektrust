package simulator;

import java.io.FileNotFoundException;
import java.util.Map;

import pojo.Inning;
import pojo.Match;
import pojo.Player;

public interface ISimulateMatch {
	
	public Inning firstInning(Match m, Map<Integer, Player> players) throws FileNotFoundException;

	public Inning targetInning(Match m, Map<Integer, Player> players) throws FileNotFoundException; 
}
