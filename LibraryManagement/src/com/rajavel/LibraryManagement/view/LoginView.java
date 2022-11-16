package view;

import java.util.Scanner;
import controler.LoginController;

public class LoginView {
	private Scanner scanner = new Scanner(System.in);
	private LoginController loginControler;

	LoginView() {
		loginControler = new LoginController();
	}

	private void initLogin() {
		System.out.println("Welcome to Library Management System\n ------------------------");
		checkForLogin();
	}

	// this operation is checkForLogin to check username and password;
	private void checkForLogin() {
		System.out.println("Enter User Name");
		String userName = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		if (loginControler.checkCredentials(userName, password)) {
			System.out.println("\n-->Welcome " + userName + "<--\n");
			SetupLibrary setupLibrary = new SetupLibrary();
			setupLibrary.init();
		} else {
			System.out.println("\nInvalid Credentials. Please try again!\n");
			checkForLogin();
		}
	}

	public static void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.initLogin();
	}
}
