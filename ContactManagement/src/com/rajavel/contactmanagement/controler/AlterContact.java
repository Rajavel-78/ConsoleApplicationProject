package controler;
import java.util.Scanner;
import modal.Contact;
public class AlterContact 
{
	private Scanner scan=new Scanner(System.in);
	public void editContact(Contact contact)
	{
		System.out.println("1 EDIT USER NAME\n2 EDIT MOBILE NUMBER\n3 EDIT EMAILID\n4 EDIT DATE OF BIRTH\n5 "
				+ "EDIT RELATIONSHIP\n6 EDIT FAVOURITS\n7 ADDRESS\n8 AGIN MODIFIED\nSELECT YOUR OPTION");	
		String option=scan.nextLine();
		switch(option) {
		case "1":
			System.out.println("ENTER NEW USER NAME");
			String name=scan.nextLine();
			contact.setName(name);
		break;
		case "2":
			System.out.println("ENTER NEW MOPILENUMBER");
			String mopileNumber=scan.nextLine();
			contact.setPhoneNumber(mopileNumber);
		break;
		case "3":
			System.out.println("ENTER NEW EMAILID");
			String emailId=scan.nextLine();
			contact.setEmail(emailId);
		break;
		case "4":
			System.out.println("ENTER DATE OF BIRTH");
			String dateOFBirth=scan.nextLine();
			contact.setDateOfBirth(dateOFBirth);
		break;
		case "5":
			System.out.println("ENTER RELATIONSHIP");
			String relationship=scan.nextLine();
			contact.setDateOfBirth(relationship);
		break;
		case "6":
			System.out.println("ENTER FAVOURITS");
			boolean favourits=scan.nextBoolean();
			contact.setFavourites(favourits);;
		break;
		case "7":
			System.out.println("ENTER NEW ADDRESS");
			String address=scan.nextLine();
			contact.setAddress(address);;
		break;
		case "8":
			AlterContact alter=new AlterContact();
			alter.editContact(contact);
		break;
		default:
			System.out.println("INVALIED INPUTS PLEASE INSERT THE CORRECT INPUT");			
		}
	}
}