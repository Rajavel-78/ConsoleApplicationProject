package view;

import java.util.*;

import controler.RoomControl;
import modal.*;

public class ManageRooms {
	private Scanner scan = new Scanner(System.in);
	static int roomNumber = 1001;
	private static ManageRooms manageRoom;

	public static ManageRooms getInstance() {
		if (manageRoom == null) {
			manageRoom = new ManageRooms();
		}
		return manageRoom;
	}

	public void addRoom() {
		System.out.println("ENTER THE ROOMTYPE");
		String roomType = scan.nextLine();
		System.out.println("ENTER THE ROOMPRICE");
		float roomPrice = scan.nextFloat();
		System.out.println("ENTER ROOM IS AC");
		boolean isAc = scan.nextBoolean();
		RoomControl roomControl = new RoomControl();
		roomControl.addRoom(roomNumber, roomType, roomPrice, isAc);
		roomNumber++;
		System.out.println("--->ADD ROOM SUCESSFULLY<---\n ADD MORE ROOM PRESS 1 EXITE ANY OTHER KEY");
		String option = scan.nextLine();
		switch (option) {
		case "1":
			this.addRoom();
			break;
		default:
			AdminView admin = new AdminView();
			admin.adminMenu();
		}

	}

	public void removeRoom() {
		System.out.println("ENTER THE ROOM NUMBER");
		int roomnumber = scan.nextInt();
		RoomControl roomControl = new RoomControl();
		roomControl.removeRoom(roomNumber);
		AdminView admin = new AdminView();
		admin.adminMenu();
	}

	public void viewRoomList() {
		System.out.println("ROOMNO\tROOMTYPE\tROOMPRICE\tISAC\tISAVILABILITY");
		List<Room> roomList = HotalDataBase.getInstance().getHotalRoom();
		for (Room room : roomList) {
			room.display();
		}
		AdminView admin = new AdminView();
		admin.adminMenu();

	}

	public void bookingList() {
		List<BookingDetails> bookingList = HotalDataBase.getInstance().getBookingDetails();
		for (BookingDetails bookingDetails : bookingList) {
			bookingDetails.display();
		}
		AdminView admin = new AdminView();
		admin.adminMenu();
	}
}