package model;

import java.util.ArrayList;
import java.util.List;

public class LibraryDatabase {
	private static LibraryDatabase libraryDb;
	private List<User> userList;
	private List<Book> bookList;
	private List<BookTransactions> bookTransaction;
	
	LibraryDatabase() {
		userList = new ArrayList<User>();
		bookList = new ArrayList<Book>();
		bookTransaction = new ArrayList<BookTransactions>();
	}

	public static LibraryDatabase getInstance() {
		if (libraryDb == null) {
			libraryDb = new LibraryDatabase();
		}
		return libraryDb;
	}

	//User related operations
	public void insertUserList(List<User> userList) {
		this.userList.addAll(userList);
	}

	public void insertUserList(User user) {
		this.userList.add(user);
	}

	public List<User> getUserList() {
		return userList;
	}

	//Books related operations
	public void insertBook(List<Book> bookList) {
		this.bookList.addAll(bookList);
	}

	public void insertBook(Book bookList) {
		this.bookList.add(bookList);
	}

	public List<Book> getBookList() {
		return bookList;
	}


	//Books transactions related operations
	public void insertBookTransaction(List<BookTransactions> bookTransaction) {
		this.bookTransaction.addAll(bookTransaction);
	}

	public void insertBookTransaction(BookTransactions bookTransaction) {
		this.bookTransaction.add(bookTransaction);
	}

	public List<BookTransactions> getBookTransaction() {
		return bookTransaction;
	}
}
