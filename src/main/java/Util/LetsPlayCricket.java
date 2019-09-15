package Util;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import pojo.Commentry;
import pojo.Inning;
import pojo.Match;
import pojo.Player;
import simulator.SimulateMatchImpl;

public class LetsPlayCricket {

	public static void main(String[] args) throws FileNotFoundException {

		////////////////////////////////////////////////////////////////////
		/////////////////////////// 2nd Problem (last 4 over) /////////////////////////
		////////////////////////////////////////////////////////////

		try {
			// Last 4 Over - Match
			SimulateMatchImpl sm = new SimulateMatchImpl();
			Match matchDetails = CricketUtils.transformMatchFromJson("last_4_over.json");
			Map<Integer, Player> players = CricketUtils.transformPlayerFromJson("last_4_over_players.json");

			if (matchDetails != null && !players.isEmpty()) {
				Inning inningsResult = sm.targetInning(matchDetails, players);
				List<Commentry> commentaryList = inningsResult.getCommentry();
				for (int i = 0; i < commentaryList.size(); i++) {

					if (commentaryList.get(i).isOver() != null && commentaryList.get(i).isOver())
						System.out.println("\n" + commentaryList.get(i).getRemainingRun()
								+ (commentaryList.get(i).getRemainingRun() > 1 ? " runs " : " run ") + "to win. "
								+ commentaryList.get(i).getRemainingOver()
								+ (commentaryList.get(i).getRemainingOver() > 1 ? " overs " : " over ")
								+ "remaining.\n");
					else if (commentaryList.get(i).isOut())
						System.out.println(
								(commentaryList.get(i).getBowl() / 6) + "." + (commentaryList.get(i).getBowl() % 6)
										+ " " + commentaryList.get(i).getBatsman() + " is out.");
					else
						System.out.println((commentaryList.get(i).getBowl() / 6) + "."
								+ (commentaryList.get(i).getBowl() % 6) + " " + commentaryList.get(i).getBatsman()
								+ " scores " + commentaryList.get(i).getRun()
								+ (commentaryList.get(i).getRun() > 1 ? " runs." : " run."));
				}

				System.out.println("\nMatch Summary of " + matchDetails.getMatchName());

				for (int i = 1; i <= inningsResult.getPlayer().size(); i++) {
					if (inningsResult.getPlayer().containsKey(i))
						System.out.println("\n" + inningsResult.getPlayer().get(i).getName() + " "
								+ inningsResult.getPlayer().get(i).getRunScore()
								+ (inningsResult.getPlayer().get(i).getIsOut() ? "" : "*") + " ("
								+ inningsResult.getPlayer().get(i).getBallFaced() + ")");
				}

				if (inningsResult.getSummary().getIsVistory()) {
					Integer wicketWinningMarginLeft = inningsResult.getSummary().getWicketLeft() + 1;
					System.out.print("\n" + inningsResult.getSummary().getWinningTeam() + " won by "
							+ wicketWinningMarginLeft + (wicketWinningMarginLeft > 1 ? " wickets" : " wicket") + " and "
							+ inningsResult.getSummary().getBallLeft()
							+ (inningsResult.getSummary().getBallLeft() > 1 ? " balls" : " ball") + " remaining");
				} else
					System.out.println("\nLengaluru Lost");
			}

		} catch (Exception e) {
			System.out.println("Last 4 over exception ");
		}

		////////////////////////////////////////////////////////////////////
		/////////////////////////// 3rd Problem Tie /////////////////////////
		////////////////////////////////////////////////////////////

		try {
			// Last 4 Over - Match
			SimulateMatchImpl sm = new SimulateMatchImpl();
			Match matchDetails = CricketUtils.transformMatchFromJson("super_over.json");
			Map<Integer, Player> lengaburuPlayers = CricketUtils
					.transformPlayerFromJson("super_over_legaburu_players.json");

			if (matchDetails != null && !lengaburuPlayers.isEmpty()) {

				Inning lengaburuInningsResult = sm.firstInning(matchDetails, lengaburuPlayers);
				System.out.println("\nMatch Details of " + matchDetails.getMatchName());
				List<Commentry> lengaburuCommentaryList = lengaburuInningsResult.getCommentry();
				System.out.println("\nLengaburu Innning's Commentry --");
				for (int i = 0; i < lengaburuCommentaryList.size(); i++) {

					if (lengaburuCommentaryList.get(i).isOver() != null && lengaburuCommentaryList.get(i).isOver())
						System.out.println("\n" + lengaburuCommentaryList.get(i).getRemainingRun()
								+ (lengaburuCommentaryList.get(i).getRemainingRun() > 1 ? " runs " : " run ")
								+ "to win. " + lengaburuCommentaryList.get(i).getRemainingOver()
								+ (lengaburuCommentaryList.get(i).getRemainingOver() > 1 ? " overs " : " over ")
								+ "remaining.\n");
					else if (lengaburuCommentaryList.get(i).isOut())
						System.out.println((lengaburuCommentaryList.get(i).getBowl() / 6) + "."
								+ (lengaburuCommentaryList.get(i).getBowl() % 6) + " "
								+ lengaburuCommentaryList.get(i).getBatsman() + " is out.");
					else
						System.out.println((lengaburuCommentaryList.get(i).getBowl() / 6) + "."
								+ (lengaburuCommentaryList.get(i).getBowl() % 6) + " "
								+ lengaburuCommentaryList.get(i).getBatsman() + " scores "
								+ lengaburuCommentaryList.get(i).getRun()
								+ (lengaburuCommentaryList.get(i).getRun() > 1 ? " runs." : " run."));
				}

				System.out.println("\n Lengaburu inning summary for " + matchDetails.getMatchName());

				for (int i = 1; i <= lengaburuInningsResult.getPlayer().size(); i++) {
					if (lengaburuInningsResult.getPlayer().containsKey(i))
						System.out.println("\n" + lengaburuInningsResult.getPlayer().get(i).getName() + " "
								+ lengaburuInningsResult.getPlayer().get(i).getRunScore()
								+ (lengaburuInningsResult.getPlayer().get(i).getIsOut() ? "" : "*") + " ("
								+ lengaburuInningsResult.getPlayer().get(i).getBallFaced() + ")");
				}

				int l = lengaburuInningsResult.getSummary().getTotalScore() + 1;
				matchDetails.setTarget(Long.valueOf(l));

				System.out.println("Target : " + l);

				System.out.println("\nEnchai Innning's Commentry --");

				// --------- second inning
				Map<Integer, Player> enchai_Players = CricketUtils
						.transformPlayerFromJson("super_over_enchai_players.json");

				Inning echai_InningsResult = sm.targetInning(matchDetails, enchai_Players);
				List<Commentry> enchai_CommentaryList = echai_InningsResult.getCommentry();
				for (int i = 0; i < enchai_CommentaryList.size(); i++) {

					if (enchai_CommentaryList.get(i).isOver() != null && enchai_CommentaryList.get(i).isOver())
						System.out.println("\n" + enchai_CommentaryList.get(i).getRemainingRun()
								+ (enchai_CommentaryList.get(i).getRemainingRun() > 1 ? " runs " : " run ") + "to win. "
								+ enchai_CommentaryList.get(i).getRemainingOver()
								+ (enchai_CommentaryList.get(i).getRemainingOver() > 1 ? " overs " : " over ")
								+ "remaining.\n");
					else if (enchai_CommentaryList.get(i).isOut())
						System.out.println((enchai_CommentaryList.get(i).getBowl() / 6) + "."
								+ (enchai_CommentaryList.get(i).getBowl() % 6) + " "
								+ enchai_CommentaryList.get(i).getBatsman() + " is out.");
					else
						System.out.println((enchai_CommentaryList.get(i).getBowl() / 6) + "."
								+ (enchai_CommentaryList.get(i).getBowl() % 6) + " "
								+ enchai_CommentaryList.get(i).getBatsman() + " scores "
								+ enchai_CommentaryList.get(i).getRun()
								+ (enchai_CommentaryList.get(i).getRun() > 1 ? " runs." : " run."));
				}

				System.out.println("\nEnchai inning summary for " + matchDetails.getMatchName());

				for (int i = 1; i <= echai_InningsResult.getPlayer().size(); i++) {
					if (echai_InningsResult.getPlayer().containsKey(i))
						System.out.println("\n" + echai_InningsResult.getPlayer().get(i).getName() + " "
								+ echai_InningsResult.getPlayer().get(i).getRunScore()
								+ (echai_InningsResult.getPlayer().get(i).getIsOut() ? "" : "*") + " ("
								+ echai_InningsResult.getPlayer().get(i).getBallFaced() + ")");
				}

//				System.out.println("lengaburuInningsResult.getSummary()   " +  lengaburuInningsResult.getSummary());
//				System.out.println("echai_InningsResult.getSummary()   " +  echai_InningsResult.getSummary());
				if (lengaburuInningsResult.getSummary().getTotalScore() >= echai_InningsResult.getSummary()
						.getTotalScore())
					System.out.println("\n Lenagaburu won ");
				else
					System.out.println("\n Enchai won ");

			}

		} catch (Exception e) {
			System.out.println("super over match exception");
			e.printStackTrace();
		}

	}

}
