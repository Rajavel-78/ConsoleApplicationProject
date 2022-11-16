package controler;

import java.util.ArrayList;
import java.util.List;

import modal.Bowler;
import modal.Player;
import repository.DataBase;
import view.ViewScore;

public class BattingScore {
	public void calculateScore() {
		List<String> teamList1 = DataBase.getInstance().getTeamList();
		List<String> player1 = DataBase.getInstance().getPlayerList1();
		List<String> player2 = DataBase.getInstance().getPlayerList2();

		score(teamList1.get(0), player1, player2);
		score(teamList1.get(1), player2, player1);
	}

	private void score(String string, List<String> player1, List<String> player2) {
		ArrayList<Player> battingList = new ArrayList<Player>();
		ArrayList<Bowler> bowlingList = new ArrayList<Bowler>();
		for (int i = 0; i < player1.size(); i++) {
			battingList.add(new Player(player1.get(i), 0, 0, 0, 0, 0));
		}
		for (int i = 3; i < player2.size(); i++) {
			bowlingList.add(new Bowler(player2.get(i), 0, 0, 0, 0));
		}
		calculateScore(battingList, bowlingList);
	}

	private void calculateScore(ArrayList<Player> battingList, ArrayList<Bowler> bowlingList) {
		List<String> scoreList = DataBase.getInstance().getScoreList();
		ArrayList<Player> batingScoreCard = new ArrayList<Player>();
		int over = 1;
		int wicket = 0;
		int other = 0;
		int score = 0;
		boolean strickerIsvalied = true;
		boolean nonStrickerIsValied = false;
		int stricker = 0;
		int nonStricker = 1;
		int bowler = 0;
		int wicketcount = 0;
		batingScoreCard.add(battingList.get(stricker));
		batingScoreCard.add(battingList.get(nonStricker));
		while (over < 30 && wicket < 2 && scoreList.size() > 0) {
			String ball = "";
			if (scoreList.size() != 0) {
				ball = scoreList.get(0);

				scoreList.remove(0);

			}
			if (ball.equals("0WD") || ball.equals("0NB")) {
				other++;
				score += 1;
				over--;
			} else if (ball.equals("W")) {
				wicketcount++;
				over++;
				if (strickerIsvalied) {
					score(battingList.get(stricker), -1);
					stricker = nonStricker + 1;
					batingScoreCard.add(battingList.get(stricker));

				} else {
					score(battingList.get(nonStricker), -1);
					nonStricker += 1;
					batingScoreCard.add(battingList.get(nonStricker));
				}
				wicket++;
				System.out.print("\n");
			} else {
				if (strickerIsvalied) {
					int run = Integer.parseInt(ball);
					score += run;
					if (run == 1 && over % 6 == 0) {
						strickerIsvalied = true;
					} else if (run == 0 && over % 6 == 0) {
						strickerIsvalied = false;
					} else {
						if (run == 1) {
							strickerIsvalied = false;
						} else {
							strickerIsvalied = true;
						}
					}

					score(battingList.get(stricker), run);
				} else {

					int run = 0;
					try {
						run = Integer.parseInt(ball);
						score += run;
					} catch (Exception e) {

					}
					if (run == 1 && over % 6 == 0) {
						strickerIsvalied = false;
					} else if (run == 0 && over % 6 == 0) {
						strickerIsvalied = true;
					} else {
						if (run == 1) {
							strickerIsvalied = true;
						} else {
							strickerIsvalied = false;
						}
					}

					score(battingList.get(nonStricker), run);
				}
			}
			bowl(bowlingList.get(bowler), 1 - other, other, wicketcount, score);
			other = 0;
			wicketcount = 0;
			score = 0;
			if (over % 6 == 0) {
				if (bowler == 0) {
					bowler = 1;
				} else {
					bowler = 0;
				}
			}
			over++;
		}
		ViewScore viewScore = new ViewScore();
		viewScore.display(batingScoreCard, bowlingList);
	}

	private void score(Player player, int ball) {

		if (ball == 1 || ball == 2) {
			player.setBall(player.getBall() + 1);
			player.setScore(player.getScore() + ball);

		} else if (ball == 0 || ball == -1) {
			player.setBall(player.getBall() + 1);
		} else if (ball == 4) {
			player.setBall(player.getBall() + 1);
			player.setScore(player.getScore() + 4);
			player.setFour(player.getFour() + 1);

		} else if (ball == 6) {
			player.setBall(player.getBall() + 1);
			player.setScore(player.getScore() + 6);
			player.setSix(player.getSix() + 1);
		}
	}

	private void bowl(Bowler bowler, int ball, int other, int wicket, int run) {
		bowler.setBall(bowler.getBall() + ball);
		bowler.setWicket(bowler.getWicket() + wicket);
		bowler.setOther(bowler.getOther() + other);
		bowler.setRun(bowler.getRun() + run);
	}

}
