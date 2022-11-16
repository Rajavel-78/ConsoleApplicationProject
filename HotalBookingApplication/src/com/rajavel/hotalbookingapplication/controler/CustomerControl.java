package controler;

import java.util.*;
import java.util.concurrent.TimeUnit;
import modal.*;

public class CustomerControl {
	private Scanner scan = new Scanner(System.in);

	public void cancelRoom(int roomNumber) {
		List<Room> roomList = HotalDataBase.getInstance().getHotalRoom();
		boolean isValied = true;
		for (Room room : roomList) {
			if (room.getRoomNumber() == roomNumber) {
				room.setAvilability(true);
			}
		}

	}

	public void vacateRoom(int roomNumber, String name) {
		long checkOut = System.currentTimeMillis();
		RoomControl check = new RoomControl();
		Customer room = new Customer();
		room = check.bookingInfo(roomNumber, name);
		if (room != null) {
			room.setCheckOutDay(checkOut);
			int day = (int) TimeUnit.MILLISECONDS.toDays(checkOut - room.getCheckInDay()) + 1;
			check.payBill(day, room.getRoomType());
			System.out.println("....>THANK YOU<....");
		} else {
			System.out.println("invalied input");
		}
	}

	public void roomBooking(float roomPrice, String roomType) {
		int roomNumber = 0;
		boolean ac = true;
		;
		RoomControl roomcontrol = new RoomControl();
		Room checkRoom = roomcontrol.avilabilityRoom(roomType);
		if (checkRoom != null) {
			roomNumber = checkRoom.getRoomNumber();
			checkRoom.setAvilability(false);
			System.out.println("YOUR ROOM NUMBER : " + roomNumber);
			ac = checkRoom.isAc();
			Customer customer = new Customer();
			System.out.println("ENTER THE USER NAME");
			String name = scan.nextLine();
			System.out.println("ENTER THE PHONENUMBER");
			String phoneNumber = scan.nextLine();
			long chackInDay = System.currentTimeMillis();
			customer.setCheckInDay(chackInDay);
			customer.setRoomNumber(roomNumber);
			customer.setName(name);
			customer.setRoomType(roomType);
			customer.setPhoneNumber(phoneNumber);
			HotalDataBase.getInstance().setCustomerDetails(customer);
			ArrayList<Customer> customerDetails = new ArrayList<Customer>();
			customerDetails.add(customer);
			HotalDataBase.getInstance()
					.setBookingDetails(new BookingDetails(roomType, roomPrice, roomNumber, ac, customerDetails));
			System.out.println("--------> ROOM BOOKING SUCCESSFULLY <--------\n");
		} else {
			System.out.println("ROOM IS NOT AVILABLE");
		}
	}
}