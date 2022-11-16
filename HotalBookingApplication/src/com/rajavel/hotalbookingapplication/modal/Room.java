package modal;

import java.util.ArrayList;

public class Room {
	private String roomType;
	private float roomPrice;
	private int roomNumber;
	private boolean ac;
	private boolean avilability;

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
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

	public boolean isAvilability() {
		return avilability;
	}

	public void setAvilability(boolean avilability) {
		this.avilability = avilability;
	}

	public void display() {
		System.out.println(roomNumber + "\t" + roomType + "\t" + roomPrice + "\t" + ac + "\t" + avilability);

	}

}
