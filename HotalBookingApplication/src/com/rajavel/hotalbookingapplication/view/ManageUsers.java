package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import controler.CustomerControl;
import controler.RoomControl;
import modal.*;

public class ManageUsers {
	private Scanner scan = new Scanner(System.in);
	private static ManageUsers manageUser;

	public static ManageUsers getInstance() {
		if (manageUser == null) {
			manageUser = new ManageUsers();
		}
		return manageUser;
	}

	public void roomBooking() {
		System.out.println("---->WELCOME TO HOTAL ISMRA<----\nENTER THE BOOKING DETALIS\n");
		System.out.println(" Select RoomType \n1 singlebet\n2 doublebet\n3 dulex");
		String option = scan.nextLine();
		String roomType = "";
		float roomPrice = 0;
		int roomNumber = 0;
		switch (option) {
		case "1":
			roomType = "singlebet";
			roomPrice = 1000;
			break;
		case "2":
			roomType = "doublebet";
			roomPrice = 2000;
			break;
		case "3":
			roomType = "dulex";
			roomPrice = 3000;
			break;
		default:
			System.out.println("invalied input");
		}
		CustomerControl control = new CustomerControl();
		control.roomBooking(roomPrice, roomType);
		UserView user = new UserView();
		user.userMenu();

	}

	public void cancelRoom() {
		System.out.println("ENTER THE ROOMNUMBER");
		int roomNumber = scan.nextInt();
		CustomerControl control = new CustomerControl();
		control.cancelRoom(roomNumber);
		UserView user = new UserView();
		user.userMenu();

	}

	public void vacatedRoom() {
		System.out.println("ENTER THE ROOM NUMBER");
		int roomNumber = scan.nextInt();
		scan.nextLine();
		System.out.println("ENTER THE USER NAME");
		String name = scan.nextLine();
		CustomerControl control = new CustomerControl();
		control.vacateRoom(roomNumber, name);
		UserView user = new UserView();
		user.userMenu();
	}
}
