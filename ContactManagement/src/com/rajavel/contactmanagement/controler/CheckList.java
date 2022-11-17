package controler;

import java.util.List;
import java.util.regex.Pattern;

import modal.Contact;
import modal.ContactDatabases;

public class CheckList {
private static CheckList checkList;
	public static CheckList getInstance() {
		if(checkList==null) {
			checkList=new CheckList();
		}
		return checkList;
	}
	public Boolean conformDelete(String name,String phoneNumber){
	    List<Contact>contactList=ContactDatabases.getInstance().getContactList();
	    int count=0;
	    for(Contact contact:contactList) {
	    	if(contact.getName().equals(name)&&contact.getPhoneNumber()==phoneNumber){
	    		contactList.remove(count);
	    		return true;
	    	}
	    	count++;
	    }
		return false; 
	}
	 public boolean checkMobileNumber(String mobileNumber) {
		 return Pattern.matches("[6-9][0-9]{9}",mobileNumber);
	 }  
	 public boolean cheakMailId(String mailId) {
		 return Pattern.matches("[a-z][@gmail.com]", mailId);
	 }
}