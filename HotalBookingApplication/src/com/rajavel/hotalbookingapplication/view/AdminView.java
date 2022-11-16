package view;

import java.util.Scanner;

public class AdminView {
	Scanner scan = new Scanner(System.in);

	public void adminMenu() {
		System.out.println(
				"\n1 ADD ROOM\n2 REMOVEM ROOM\n3 VIEW ROOMLIST\n4 VIEW BOOKING LIST\n5 BACK TO MENU\n-------------------\n");
		System.out.println("--SELECT YOUR OPTION---");
		String option = scan.nextLine();
		switch (option) {
		case "1":
			ManageRooms.getInstance().addRoom();
			break;
		case "2":
			ManageRooms.getInstance().removeRoom();
			break;
		case "3":
			ManageRooms.getInstance().viewRoomList();
			break;
		case "4":
			ManageRooms.getInstance().bookingList();
			break;
		case "5":
			LoginInfo login = new LoginInfo();
			login.logInMenu();
		default:
			System.out.println("\n-----INVALIED INPUTS.....\n");
			this.adminMenu();

		}
	}

}
