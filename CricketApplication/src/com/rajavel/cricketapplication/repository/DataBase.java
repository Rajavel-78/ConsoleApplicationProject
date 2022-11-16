package repository;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
	private static DataBase database;
	List<String> teamList;
	List<String> playerList1;
	List<String> playerList2;
	List<String> scoreList;

	public DataBase() {
		teamList = new ArrayList<>();
		playerList1 = new ArrayList<>();
		playerList2 = new ArrayList<>();
		scoreList = new ArrayList<>();
	}

	public static DataBase getInstance() {
		if (database == null) {
			database = new DataBase();
		}
		return database;
	}

	public List<String> getTeamList() {
		return teamList;
	}

	public void setTeamList(String teamList) {
		this.teamList.add(teamList);
	}

	public List<String> getPlayerList1() {
		return playerList1;
	}

	public void setPlayerList1(String playerList) {
		this.playerList1.add(playerList);
	}

	public void setPlayerList2(String playerList) {
		this.playerList2.add(playerList);
	}

	public List<String> getScoreList() {
		return scoreList;
	}

	public void setScoreList(String scoreList) {
		this.scoreList.add(scoreList);
	}

	public List<String> getPlayerList2() {

		return playerList2;
	}

}
