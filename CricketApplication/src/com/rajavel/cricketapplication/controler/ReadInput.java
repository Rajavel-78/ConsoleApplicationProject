package controler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import repository.DataBase;

public class ReadInput {
	public void operation() {
		File file = new File("/home/rajavel/Downloads/cricket.txt");
		FileReader reader = null;
		BufferedReader read=null;
		try {
			reader = new FileReader(file);
		    read = new BufferedReader(reader);
			String line = read.readLine();
			int count = 0;
			while (line != null) {
				System.out.println(line);
				if (count == 0) {
					String[] team = line.split(",");
					System.out.println(team);
					for (String team1 : team) {
						System.out.println(team1);
						DataBase.getInstance().setTeamList(team1);
					}
				} else if (count == 1) {
					String[] playerList = line.split(",");
					for (String player : playerList) {
						DataBase.getInstance().setPlayerList1(player);
					}
				} else if (count == 2) {
					String[] playerList = line.split(",");
					for (String player : playerList) {
						DataBase.getInstance().setPlayerList2(player);
					}
				} else {
					String[] scoreList= line.split(",");
					for (String score : scoreList) {
						DataBase.getInstance().setScoreList(score);
					}
				}
				count++;
				line = read.readLine();
			}
		} 
		catch (IOException e) {
            e.printStackTrace();
		}
		
		BattingScore calculateScore = new BattingScore();
		calculateScore.calculateScore();

	}
}
