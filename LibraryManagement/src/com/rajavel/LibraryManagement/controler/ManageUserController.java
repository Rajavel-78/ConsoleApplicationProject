package controler;

import java.util.List;
import java.util.regex.Pattern;

import model.*;

public class ManageUserController {
	private static ManageUserController manageusercontroler;

	public static ManageUserController getInstance() {
		if (manageusercontroler == null) {
			manageusercontroler = new ManageUserController();
		}
		return manageusercontroler;
	}

	// check bookiD and avilablity status
	public boolean checkBookId(long bookId) {
		List<Book> bookList = LibraryDatabase.getInstance().getBookList();
		for (Book book : bookList) {
			if (book.getId() == bookId && book.isAvailablity()) {
				book.setAvailablity(false);
				return true;
			}
		}
		return false;
	}

	// check transactionDetails userid and bookId user take it book return true or
	// false;
	public boolean transactionDetails(int studentId, long bookId) {
		List<BookTransactions> transactionList = LibraryDatabase.getInstance().getBookTransaction();
		for (BookTransactions transaction : transactionList) {
			if (transaction.getUserId() == studentId && transaction.getBookId() == bookId) {
				System.out.println("userId BookId Verified");
				return true;
			}
		}
		return false;
	}

	// user return the book set bookstatus isAvilability=true;
	public void addAvilability(long bookId, boolean status) {
		List<Book> bookList = LibraryDatabase.getInstance().getBookList();
		for (Book book : bookList) {
			if (book.getId() == bookId) {
				book.setAvailablity(status);
			}
		}
	}

	// check phoneNumber indianFormat regex;
	public boolean checkPhoneNumber(String phoneNumber) {
		return Pattern.matches("[6-9][0-9]{9}", phoneNumber);
	}
}
