package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookTransactions {
	private long bookId;
	private int userId;
	private long dateBorrowed;
	private long dateToBeReturn;
	private long returnedDate;
	private boolean isFined;
	private int fineAmount;
	private boolean isPaied;
	private long finedDate;
	private long fineDueDate;
	private long finePaidDate;
	public BookTransactions(long bookId, int userId, long dateBorrowed, long dateToBeReturn, long returnedDate,
			boolean isFined, int fineAmount, boolean isPaied, long finedDate, long fineDueDate, long finePaidDate) {
		super();
		this.bookId = bookId;
		this.userId = userId;
		this.dateBorrowed = dateBorrowed;
		this.dateToBeReturn = dateToBeReturn;
		this.returnedDate = returnedDate;
		this.isFined = isFined;
		this.fineAmount = fineAmount;
		this.isPaied = isPaied;
		this.finedDate = finedDate;
		this.fineDueDate = fineDueDate;
		this.finePaidDate = finePaidDate;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getDateBorrowed() {
		return dateBorrowed;
	}
	public void setDateBorrowed(long dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}
	public long getDateToBeReturn() {
		return dateToBeReturn;
	}
	public void setDateToBeReturn(long dateToBeReturn) {
		this.dateToBeReturn = dateToBeReturn;
	}
	public long getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(long returnedDate) {
		this.returnedDate = returnedDate;
	}
	public boolean isFined() {
		return isFined;
	}
	public void setFined(boolean isFined) {
		this.isFined = isFined;
	}
	public int getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}
	public boolean isPaied() {
		return isPaied;
	}
	public void setPaied(boolean isPaied) {
		this.isPaied = isPaied;
	}
	public long getFinedDate() {
		return finedDate;
	}
	public void setFinedDate(long finedDate) {
		this.finedDate = finedDate;
	}
	public long getFineDueDate() {
		return fineDueDate;
	}
	public void setFineDueDate(long fineDueDate) {
		this.fineDueDate = fineDueDate;
	}
	public long getFinePaidDate() {
		return finePaidDate;
	}
	public void setFinePaidDate(long finePaidDate) {
		this.finePaidDate = finePaidDate;
	}
	public void display() {
		DateFormat date=new SimpleDateFormat("dd-MM-yy");		
		System.out.println(bookId+"\t"+userId+"\t"+date.format(new Date(dateBorrowed))+"\t"+date.format(new Date(dateToBeReturn))+"\t"+date.format(new Date(returnedDate))+"\t"+isFined+
				"\t"+fineAmount+"\t"+isPaied+"\t"+date.format(new Date(finedDate))+"\t"+date.format(new Date(fineDueDate))+"\t"+date.format(new Date(finePaidDate)));

	}
}
