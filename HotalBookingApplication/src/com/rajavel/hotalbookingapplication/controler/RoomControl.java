package controler;

import java.util.List;
import modal.*;

public class RoomControl {
	public void addRoom(int roomNumber, String roomType, float roomPrice, boolean isAc) {
		Room room = new Room();
		room.setRoomType(roomType);
		room.setRoomNumber(roomNumber);
		room.setRoomPrice(roomPrice);
		room.setAvilability(true);
		room.setAc(isAc);
		HotalDataBase.getInstance().setHotalRoom(room);
	}

	public Room avilabilityRoom(String roomType) {
		List<Room> roomDetails = HotalDataBase.getInstance().getHotalRoom();
		for (Room room : roomDetails) {
			if (room.getRoomType().equals(roomType) && room.isAvilability() == true) {
				return room;
			}
		}
		return null;
	}

	public void cancelRoom(int roomNumber) {
		List<Room> roomDetails = HotalDataBase.getInstance().getHotalRoom();
		boolean isValied = true;
		for (Room room : roomDetails) {
			if (room.getRoomNumber() == roomNumber) {
				room.setAvilability(true);
			}
		}
	}

	public Customer bookingInfo(int roomNumber, String name) {
		List<BookingDetails> bookingDetails = HotalDataBase.getInstance().getBookingDetails();
		for (BookingDetails book : bookingDetails) {
			if (book.getRoomNumber() == roomNumber && book.getCustomerDetails().get(0).getName().equals(name)) {
				return book.getCustomerDetails().get(0);
			}
		}
		return null;
	}

	public void payBill(int day, String roomType) {
		System.out.println("----------------------------------------\n");
		System.out.println("--------WELCOME TO IARMS HOTAL----------\nROOM PRICE ==1000\nROOM TYPE ==" + roomType);
		float roomPrice = 0;
		switch (roomType) {
		case "singlebet":
			roomPrice = 1000;
			break;
		case "doublebet":
			roomPrice = 2000;
			break;
		case "dulex":
			roomPrice = 3000;
			break;
		default:
			System.out.println("....>INVALIED INPUT<...");
			this.payBill(day, roomType);
		}
		float roomRent = day * roomPrice;
		float gstAmount = ((roomRent / 100) * 21);
		float totalAmount = (gstAmount + roomRent);
		System.out.println("AMOUNT = " + roomRent + "\n\tGST = " + gstAmount + "\nTOTAL AMOUNT = " + totalAmount
				+ "\n--------------------------------");
	}

	public void removeRoom(int roomNumber) {
		List<Room> roomList = HotalDataBase.getInstance().getHotalRoom();
		int count = 0;

		for (Room room : roomList) {
			if (room.getRoomNumber() == roomNumber) {
				roomList.remove(count);
				System.out.println("REMOVE ROOM SUCESSFULLY");
				break;
			}
		}

	}
}