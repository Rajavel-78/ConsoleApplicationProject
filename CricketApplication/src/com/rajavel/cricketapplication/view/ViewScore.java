package view;

import java.util.ArrayList;

import modal.Bowler;
import modal.Player;

public class ViewScore {

	public void display(ArrayList<Player> batingScoreCard, ArrayList<Bowler> bowlingList) {
	   int count=0;
	   int total=0;
	   int wicket=0;
	  
	  
	  System.out.println("name\trun\tball\tfour\tsix");
		for(Player player:batingScoreCard) {
	 		if(count<=2) {
		    System.out.println(player.getName()+"\t"+player.getScore()+"\t  "+player.getBall()+"\t  "+player.getFour()+"\t  "+player.getSix()+"\t  "+player.getStrickRate());
			total+=player.getScore();}
			count++;
			
		}
		System.out.println("\n\nname\tover\tother\twicket\trun\t");		
		for(Bowler bowler:bowlingList) {
			System.out.println(bowler.getName()+"\t"+(int)Math.floor(bowler.getBall()/6)+"."+(bowler.getBall()%6)+"\t"+bowler.getOther()+"\t"+bowler.getWicket());
			total+=bowler.getOther();
			wicket+=bowler.getWicket();
		}
		System.out.println("\nScore :: "+total+" \\"+wicket);
	}

}
