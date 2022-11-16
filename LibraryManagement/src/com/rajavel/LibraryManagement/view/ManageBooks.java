package view;
import java.util.*;
import model.*;
public class ManageBooks 
{
	private Scanner scan=new Scanner(System.in);
	//this static  variable to generatebookId unique
	static long generateBookId=1001;
	private static ManageBooks manageBook;
	public static ManageBooks getInstance()
	{
		if(manageBook==null) {
			manageBook=new ManageBooks();
			return manageBook;
		}
		return manageBook;
	}
	//this Operation insertBook in libraryDatabase BookList
	public void addBook()
	{
		Book book=new Book();
		long bookId=generateBookId;
		generateBookId++;
		System.out.println("-------ENTER THE BOOKDETAILS-------\n\nENTER THE BOOK TITLE");
		String title=scan.nextLine();
		System.out.println("ENTER THE BOOK AUTHOR");
		String author=scan.nextLine();
		System.out.println("ENTER THE BOOK PUBLICATION");
		String publication=scan.nextLine();
		System.out.println("ENTER THE BOOK EdITION");
		String edition=scan.nextLine();
		System.out.println("ENTER THE BOOK JORNER");
		String joner=scan.nextLine();
		int volume=0;
		boolean isvalied=true;
		while(isvalied)
		{
			try {	
				System.out.println("ENTER THE BOOK volume");
				 volume=scan.nextInt();
				 isvalied=false;
				 }
			catch(InputMismatchException e)
			{
                System.out.println("inputMisMatch please! Enter the correct Format");
			}
		}
		book.setId(bookId);
		book.setAuthor(author);
		book.setAvailablity(true);
		book.setEdition(edition);
		book.setJourner(joner);
		book.setPublication(publication);
		book.setTitle(title);
		book.setVolume(volume);
		LibraryDatabase.getInstance().insertBook(book);
		System.out.println(".........Book Added sucessfuly\n1 do you want add more book \n2 press any key to back\n--- select your option---/n");
		String option1=scan.next();
		if(option1.equals("1"))
		{
			ManageBooks manage=new ManageBooks();
			manage.addBook();
		}
		else 
		{
			SetupLibrary setup=new SetupLibrary();
			setup.init();
		}
		SetupLibrary setup=new SetupLibrary();
		setup.init();
	}
	//this opoeration is view all bookList
	public void viewBook() 
	{
		List<Book> bookList=LibraryDatabase.getInstance().getBookList();
		for(Book book:bookList)
		{
			book.display();
		}
		SetupLibrary manage=new SetupLibrary();
		manage.init();
	}
	//this operation remove book in BookList
	public void removebook() 
	{
		List<Book> bookList=LibraryDatabase.getInstance().getBookList();
		System.out.println("ENTER THE BOOK ID");
		long bookId=scan.nextLong();
		int count=0;
		for(Book book:bookList)
		{
			if(book.getId()==bookId)
			{
				bookList.remove(count);
				System.out.println("REMOVE SUCESSFULY");
				break;
			}
			count++;
		}
		SetupLibrary manage=new SetupLibrary();
		manage.init();
	}
}