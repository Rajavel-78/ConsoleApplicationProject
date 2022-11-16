package view;

import java.util.Scanner;

import controler.LoginControler;

public class LoginInfo {
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		LoginInfo login = new LoginInfo();
		login.logInMenu();
	}

	public void logInMenu() {
		System.out.println("---------------\nSELECT YOUR OPTION\n1 USER\n2 ADMIN");
		String option = scan.nextLine();
		switch (option) {
		case "1":
			UserView user = new UserView();
			user.userMenu();
			break;
		case "2":
			LoginControler check = new LoginControler();
			System.out.println("ENTER USER NAME");
			String name = scan.nextLine();
			System.out.println("ENTER PASSWORD");
			String password = scan.nextLine();
			if (check.checkAdmin(name, password)) {
				AdminView admin = new AdminView();
				admin.adminMenu();
			} else {
				System.out.println("--INVALIED UE=SER NAME AND PASSWORD---");
				this.logInMenu();
			}
			break;
		}

	}

}
