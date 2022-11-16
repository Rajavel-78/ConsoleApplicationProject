package modal;

import java.util.*;
import modal.*;

public class HotalDataBase {
	private static HotalDataBase hotalDataBase;
	private List<Room> hotalRoom;
	private List<Customer> customerDetails;
	private List<BookingDetails> bookingDetails;

	public HotalDataBase() {
		hotalRoom = new ArrayList<Room>();
		customerDetails = new ArrayList<Customer>();
		bookingDetails = new ArrayList<BookingDetails>();
	}

	public static HotalDataBase getInstance() {
		if (hotalDataBase == null) {
			hotalDataBase = new HotalDataBase();
		}
		return hotalDataBase;
	}

	public List<Room> getHotalRoom() {
		return hotalRoom;
	}

	public void setHotalRoom(Room hotalRoom) {
		this.hotalRoom.add(hotalRoom);
	}

	public List<Customer> getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails.add(customerDetails);
	}

	public List<BookingDetails> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails.add(bookingDetails);
	}

}
