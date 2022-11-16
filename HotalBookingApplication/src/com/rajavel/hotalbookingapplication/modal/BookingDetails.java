package modal;

import java.util.ArrayList;

public class BookingDetails {
	private String roomType;
	private float roomPrice;
	private int roomNumber;
	private boolean ac;
	private ArrayList<Customer> customerDetails = new ArrayList<Customer>();

	public BookingDetails(String roomType, float roomPrice, int roomNumber, boolean ac,
			ArrayList<Customer> customerDetails) {
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.roomNumber = roomNumber;
		this.ac = ac;
		this.customerDetails = customerDetails;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public float getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(float roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

	public ArrayList<Customer> getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(ArrayList<Customer> customerDetails) {
		this.customerDetails = customerDetails;
	}

	public void display() {
		System.out.println("ROOM NO\tROOMTYPE\tTROOMPRICE\tAC/NOAC");
		System.out.println(roomNumber + "\t" + roomType + "\t" + roomPrice + "\t" + ac + "\t\n");
		System.out.println("NAME\tphonenumber\tcheckinday\tCHACEKOUTDAY");
		customerDetails.get(0).display();
		System.out.println("\n");

	}
}
