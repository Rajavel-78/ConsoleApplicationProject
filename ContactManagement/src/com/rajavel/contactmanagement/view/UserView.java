package view;
import java.util.Scanner;
import modal.Contact;
import modal.ContactDatabases;
public class UserView {
	private Scanner scan=new Scanner(System.in);
	public void userMenu() {
		System.out.println("-------------------\n1 ADD CONTACT\n2 REMOVE CONTACT\n3 EDIT CONTACT\n4 VIEW CONTACT\n5 SERCHCONTACT\n6 EXIT");
		System.out.println("SELECT YOUR OPTIONS");
		String option=scan.next();
		switch(option){
		case "1":
			ManageContact.getInstance().addContact();
			break;
		case "2":
			ManageContact.getInstance().removeContact();
			break;
		case "3":
			ManageContact.getInstance().editContact();
			break;
		case "4":
			ManageContact.getInstance().viewContact();
			break;
		case "5":
			ManageContact.getInstance().serchContact();
			break;
		case "6":
			ManageContact.getInstance().exite();
			break;
		default:
			System.out.println("ENTER THE CORRECT INPUT");
			UserView  user=new UserView();
			user.userMenu();
		}
	}
}
