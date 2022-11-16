package view;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import controler.ManageUserController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import model.*;
import view.*;
public class ManageUsers {
	Scanner scan=new Scanner(System.in);
	static int id=1;
	//this method is remove user in userList
	private void removeUser() {
		System.out.println("Enter the user Id");
		int studentId=0; 
		try {
			studentId=scan.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("InputMixMatchException");
			ManageUsers user=new ManageUsers();
			user.removeUser();
		}
		List<User>userList=LibraryDatabase.getInstance().getUserList();
		int count=0;
		for(User user:userList){
			if(studentId==user.getUserId()){
				userList.remove(count);
				System.out.println("USER REMOVED SUCESSFULY");
				break;
			}
			count++;
		}
		ManageUsers manage=new ManageUsers();
		manage.mantainBook();
	}
	//this method is user && book menu;
	public void mantainBook() {
		System.out.println("\n1 AsignBook\n2 returnBook\n3 createUser\n4 removeUser\n5 back to menu\n--Select your Option--");
		SetupLibrary library=new SetupLibrary();
		int option=scan.nextInt();
		ManageUsers manage=new ManageUsers();
		switch(option){
		case 1:
			manage.asignBook();
			break;
		case 2:
			manage.returnBook();
			break;
		case 3:
			manage.createUser();
			break;
		case 4:
			manage.removeUser();
			break;
		case 5:
			library.init();
		}
	}
	//this operation is createUser in this user field
	private void createUser()
	{
		User user=new User();
		System.out.println("-----Please Enter your details-----\nENTER THE USER NAME");
		int userId=id;
		id++;
		String userName=scan.nextLine();
		System.out.println("ENTER THE PHONENO");
		Long phoneNo=scan.nextLong();
		boolean isValied=true;
		while(isValied)
		{	
			if(ManageUserController.getInstance().checkPhoneNumber(phoneNo.toString())) {
				break;
			}
			else
			{
				System.out.println("Invalied PhoneNumber\n  please RE ENTER THE PHONENO");
				phoneNo=scan.nextLong();
			}
		}
		System.out.println("ENTER THE EMAILID");
		String emailId=scan.nextLine();
		System.out.println("ENTER THE ADDRESS");
		String address=scan.nextLine();
		System.out.println("HASMAMBERSHIP STATUS \n1 Yes\n2 no");
		boolean hasMembership=false;
		String select=scan.nextLine();
		switch(select) {
		case "1":
			hasMembership=true;
			break;
		case "2":
			hasMembership=false;
			break;	
		}	
		user.setUserId(userId);
		user.setPhoneNo(phoneNo);
		user.setEmailId(emailId);
		user.setUserName(userName);
		user.setHasMembership(hasMembership);
		user.setAddress(address);
		//add user object in the insertuserList method;
		LibraryDatabase.getInstance().insertUserList(user);
		System.out.println(".....>create User Sucessfully<....\n YOUR USERID = "+userId);
		ManageUsers manage=new ManageUsers();
		manage.mantainBook();
	}
	/*
	 this method is return=book and modify the bookAvilability and add
	  transaction History //to add fine ,fineAmount ,fineDate dueDate,and paiedFine*/
	private void returnBook() {
		System.out.println("ENTER THE BOOK ID");
		long bookId=scan.nextLong();
		System.out.println("ENTER THE STUDENT ID");
		int studentId=scan.nextInt();
		ManageUsers user=new ManageUsers();
		ManageUserController control=new ManageUserController();
		if(control.transactionDetails(studentId, bookId))
		{
			List<BookTransactions>transactionList=LibraryDatabase.getInstance().getBookTransaction();
			for(BookTransactions transaction:transactionList) 
			{
				if(bookId==transaction.getBookId())
				{
					long dateToBeReturn=transaction.getDateToBeReturn();
					long returnDate=System.currentTimeMillis();
					long days=TimeUnit.MILLISECONDS.toDays(returnDate-dateToBeReturn);
					//this operation is compare Bookreturndate is higher then BookreturnTobeDate 
					if(returnDate>dateToBeReturn)
					{
						System.out.println("You Paid Fine\n1 paied fine\n2 paied fine Latter");
						int option=scan.nextInt();
						if(option==1)
						{
							System.out.println("Fine Amount = "+days*10);
							transaction.setFineAmount((int)days*10);
							transaction.setFined(true);
							transaction.setPaied(false);
							transaction.setFinedDate(returnDate);
							transaction.setReturnedDate(returnDate);
							control.addAvilability(bookId, true);
							System.out.println("Rook Return Sucessfully");
						}
						else
						{
							System.out.println("your Fine Amount Is = "+(days*10)+"\n1 TO U PAIED FINE\n2 PAID FINE LATTER");
							transaction.setFineAmount((int)days*10);
							transaction.setFined(true);
							transaction.setPaied(false);
							transaction.setFinedDate(returnDate);
							transaction.setFineDueDate(returnDate+TimeUnit.DAYS.toMillis(1));
							transaction.setReturnedDate(returnDate);
							control.addAvilability(bookId, true);
							System.out.println("Book Return Sucessfully");
						}
						user.mantainBook();
					}
					else
					{
						transaction.setFineAmount(0);transaction.setFined(false);transaction.setPaied(false);transaction.setFinedDate(1);
						transaction.setFineDueDate(1);transaction.setReturnedDate(returnDate);
						control.addAvilability(bookId, true);
						System.out.println("Book Return Sucessfully");
						user.mantainBook();
					}
				}
			}
		}
		else 
		{
			System.out.println("InValied Users");
			user.mantainBook();
		}
	}
	//users to take book asign the details to store booktransaction list;
	//return date asign and Avilability to false;
	private void asignBook()
	{   
		ManageUsers user=new ManageUsers();
		//to current System time Store;
		long toDate=System.currentTimeMillis();
		//to current SystemTime and to add 15 days to convert in millisecond; 
		long endDate=System.currentTimeMillis()+TimeUnit.DAYS.toMillis(15);
		List<User>userList=LibraryDatabase.getInstance().getUserList();
		System.out.println("Enter The Your Id");
		int studentId=0;
		studentId=scan.nextInt();
		boolean isValied=true;
		for(User users:userList)
		{
			if(studentId==users.getUserId())
			{
				isValied=false;
				System.out.println("Enter The Book Id");
				long bookId=scan.nextLong();
				ManageUserController control=new ManageUserController();
				if(control.checkBookId(bookId))
				{
					LibraryDatabase.getInstance().insertBookTransaction(new BookTransactions(bookId,studentId,toDate,endDate,0l,false,0,false,0l,0l,0l));
					DateFormat date=new SimpleDateFormat("dd-MM-yy");
					System.out.println("\nBook RETURN DATE -"+date.format(new Date(endDate))+" ");
				}else {
					System.out.println("Book is not Avilable\n");
				}
			}
		}
		if(isValied)
		{
			System.out.println("TO JOIN THE LIBRARY MEMBER\n");
			user.createUser();
		}
		user.mantainBook();
	}
	//booktransaction details operation view booktransaction details
	private void bookTransaction()
	{
		System.out.println("-------Book Transaction Details---------\n");
		System.out.println("ID\tSID\tDateBrowed\treturnDate\treturenedDate\tisFine\tAmount\tisPaid\tfineDate\tfineDueDate\tfinePaidDate");
		List<BookTransactions>transactionList=LibraryDatabase.getInstance().getBookTransaction();
		for(BookTransactions transaction:transactionList)
		{
			transaction.display();
		}
	}
	//this method is used to manage BookDetails menu add,remove,view,transactionList,
	public void menu()
	{
		ManageUsers user=new ManageUsers();
		String option=scan.nextLine();
		switch(option)
		{
		case "1":	
			ManageBooks.getInstance().addBook();
			break;	
		case "2":
			System.out.println("----------BOOK LIST--------------\n");
			System.out.println("Id\ttitle\tauthor\tpublication\tedition\tjoner\tvolume\tAvilability\n");
			ManageBooks.getInstance().viewBook();	
			break;	
		case "3":
			ManageBooks.getInstance().removebook();
			break;
		case "4":
			user.bookTransaction();
		case "5":
			user.mantainBook();
			break;
		default:
			System.out.println("invalied option and choise correct option");
			user.menu();
		}
	}
}