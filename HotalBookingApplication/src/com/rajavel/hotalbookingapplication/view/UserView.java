package view;

import java.util.Scanner;

public class UserView {
	private Scanner scan = new Scanner(System.in);

	public void userMenu() {
		System.out.println("1 ROOM BOOKING\n2 CANCEL ROOM\3 VACATED ROOM\n4 BACK TO MENU\n SELECT YOUR OPTION");
		String option = scan.nextLine();
		switch (option) {
		case "1":
			ManageUsers.getInstance().roomBooking();
			break;
		case "2":
			ManageUsers.getInstance().cancelRoom();
			break;
		case "3":
			ManageUsers.getInstance().vacatedRoom();
			break;
		case "4":
			LoginInfo login = new LoginInfo();
			login.logInMenu();
		default:
			System.out.println("Invalied input");
			this.userMenu();
		}
	}

}
