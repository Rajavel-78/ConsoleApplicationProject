package view;

import java.util.*;

import controler.AlterContact;
import controler.CheckList;
import modal.*;

public class ManageContact {
	private Scanner scan = new Scanner(System.in);
	private static ManageContact manageContact;

	public static ManageContact getInstance() {
		if (manageContact == null) {
			manageContact = new ManageContact();
		}
		return manageContact;
	}

	public void addContact() {
		UserView view = new UserView();
		System.out.println("--ADD CONTACT---\n-----ENTER YOUR DETAILS------\nENTER THE NAME");
		String name = scan.nextLine();
		try {
			System.out.println("ENTER THE MOBILENUMBER");
			String phoneNumber = scan.nextLine();
			boolean isValied = true;
			while (isValied) {
				if (CheckList.getInstance().checkMobileNumber(phoneNumber)) {
					break;
				} else {
					System.out.println("INVALIED MOBILENUMBER");
					phoneNumber = scan.nextLine();
				}
			}
			System.out.println("ENTER THE EMAILID");
			String email = scan.nextLine();
			System.out.println("ENTER THE RELATIONSHIP");
			String relationship = scan.nextLine();
			System.out.println("ENTER THE FAVOURITS");
			boolean favourits = scan.nextBoolean();
			System.out.println("ENTER THE ADDRESS");
			String address = scan.nextLine();
			System.out.println("ENTER THE BIRTHDAY");
			String dateOfBirth = scan.nextLine();
			Contact contact = new Contact(name, phoneNumber, email, dateOfBirth, relationship, favourits, address);
			ContactDatabases.getInstance().addContactList(contact);
		} catch (InputMismatchException e) {
			System.out.println("invalied input");
			ManageContact.getInstance().addContact();
		}
		view.userMenu();
	}

	public void removeContact() {
		System.out.println("ENTER THE CONTACT NAME");
		String name = scan.next();
		System.out.println("ENTER THE MOBILENUMBER");
		String mobileNumber = scan.next();
		if (CheckList.getInstance().conformDelete(name, mobileNumber)) {
			System.out.println("REMOVE CONTACT SUCESSFULLY");
		} else {
			System.out.println("INVALIED USER AND MOBILENUMBER");
		}
		UserView view = new UserView();
		view.userMenu();
	}

	public void editContact() {
		System.out.println("ENTER THE USER NAME");
		String name = scan.next();
		List<Contact> contactList = ContactDatabases.getInstance().getContactList();
		for (Contact contact : contactList) {
			if (contact.getName().equals(name)) {
				AlterContact alter = new AlterContact();
				alter.editContact(contact);

			} else {
				System.out.println("invalied contact number");
				ManageContact.getInstance().editContact();
			}
		}
		UserView view = new UserView();
		view.userMenu();
	}

	public void viewContact() {
		List<Contact> contactList = ContactDatabases.getInstance().getContactList();
		for (Contact contact : contactList) {
			if (contact.isFavourites()) {
				contact.display();
			}
		}
		for (Contact contact : contactList) {
			if (!(contact.isFavourites())) {
				contact.display();
			}
		}
		UserView view = new UserView();
		view.userMenu();
	}

	public void serchContact() {
		System.out.println("SELECT YOUR OPTION\n1 NAME BASED SERECH\n2 MOBILENUMBER BASED SERECH");
		int option = scan.nextInt();
		List<Contact> contactList = ContactDatabases.getInstance().getContactList();
		switch (option) {
		case 1:
			System.out.println("ENTER THE NAME");
			String name = scan.next();
			for (Contact contact : contactList) {
				if (contact.getName().startsWith(name)) {
					contact.display();
				}
			}
			break;
		case 2:
			System.out.println("ENTER THE MOBILE NUMBER");
			String mobileNumber = scan.next();
			for (Contact contactNumber : contactList) {
				if (contactNumber.getName().startsWith(mobileNumber)) {
					contactNumber.display();
				}
			}
			break;
		default:
			System.out.println("Invalied options please enter correct options");
			ManageContact.getInstance().serchContact();
		}
		UserView view = new UserView();
		view.userMenu();
	}

	public void exite() {
		System.out.println("|||---------THANKYOU----------|||");
	}
}