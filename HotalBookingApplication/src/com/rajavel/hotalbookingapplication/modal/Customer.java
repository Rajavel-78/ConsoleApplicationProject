package modal;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Customer {
	private String name;
	private String phoneNumber;
	private int roomNumber;
	private long checkInDay;
	private long checkOutDay;
	private String roomType;

	public String getName() {
		return name;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getCheckInDay() {
		return checkInDay;
	}

	public void setCheckInDay(long checkInDay) {
		this.checkInDay = checkInDay;
	}

	public long getCheckOutDay() {
		return checkOutDay;
	}

	public void setCheckOutDay(long checkOutDay) {
		this.checkOutDay = checkOutDay;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void display() {
		DateFormat date = new SimpleDateFormat("dd-MM-yy");
		System.out.println(name + "\t" + phoneNumber + "\t" + date.format(new Date(checkInDay)) + "\t"
				+ date.format(new Date(checkOutDay)));
	}
}
