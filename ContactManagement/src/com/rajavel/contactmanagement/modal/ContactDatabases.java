package modal;

import java.util.ArrayList;
import java.util.List;

public class ContactDatabases {
	List<Contact>contactList;
	private static ContactDatabases contactDatabase;
	public ContactDatabases() {
		contactList=new ArrayList<Contact>();	
	}
	public static ContactDatabases getInstance() {
		if(contactDatabase==null) {
			contactDatabase=new ContactDatabases();
		}
		return contactDatabase;
	}
	
	public void addContactList(Contact contact) {
		 this.contactList.add(contact);
	}
	public List<Contact> getContactList(){
		return contactList;
	}

}
