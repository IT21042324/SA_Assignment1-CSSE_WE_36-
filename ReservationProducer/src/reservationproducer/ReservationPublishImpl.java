package reservationproducer;

import java.util.ArrayList;
import java.util.Collections;

public class ReservationPublishImpl implements ReservationPublish {

	@Override
	public String publishService() {
		return "excecution of service";
	}
	
	float totalRoomCharge = (float) 0.0;
	float totalTableCharge = (float) 0.0;

	//reserve AC rooms
	@Override
	public void reserveACRoom(int noOfRooms, ArrayList availableACRooms, ArrayList availableNACRooms,
			ArrayList reservedRooms) {
		
		if (noOfRooms <= availableACRooms.size()) {
			for (int i = 0; i < noOfRooms; i++) {
				int j = 0;
				int room = (int)availableACRooms.remove(j);
				reservedRooms.add(room);
			}
			
			totalRoomCharge = noOfRooms*4500;
			
			System.out.println("Toatl AC Room Charge : Rs." + totalRoomCharge);
			System.out.println(" ");
			
			Collections.sort(availableACRooms);
			Collections.sort(availableNACRooms);
			
			System.out.println("Available AC Rooms      : " + availableACRooms);
			System.out.println("Available NON AC Rooms  : " + availableNACRooms);
			System.out.println(" ");
		} else {
			System.out.println("Sorry!!! All our AC rooms are reserved");
			System.out.println(" ");
		}
	}

	// reserve Non AC rooms
	@Override
	public void reserveNACRoom(int noOfRooms, ArrayList availableACRooms, ArrayList availableNACRooms,
			ArrayList reservedRooms) {
		
		if (noOfRooms <= availableNACRooms.size()) {
			for (int i = 0; i < noOfRooms; i++) {
				int j = 0;
				int room = (int)availableNACRooms.remove(j);
				reservedRooms.add(room);
			}
			
			totalRoomCharge = noOfRooms*4000;
			
			System.out.println("Toatl Non-AC Room Charge : Rs." + totalRoomCharge);
			System.out.println(" ");
			
			Collections.sort(availableACRooms);
			Collections.sort(availableNACRooms);
			
			System.out.println("Available AC Rooms      : " + availableACRooms);
			System.out.println("Available NON AC Rooms  : " + availableNACRooms);
			System.out.println(" ");
		} else {
			System.out.println("Sorry!!! All our Non-AC rooms are reserved");
			System.out.println(" ");
		}
		
	}

	// release rooms
	@Override
	public void releaseRoom(int reservedRoomNo, ArrayList availableACRooms, ArrayList availableNACRooms,
			ArrayList reservedRooms) {
		
		for (int i = 0; i < reservedRooms.size(); i++) {
			if (reservedRoomNo == (int)reservedRooms.get(i)) {
				
				if ((int)reservedRooms.get(i) <= 10) {
					
					availableACRooms.add((int)reservedRooms.get(i));
					reservedRooms.remove(i);
					
					Collections.sort(availableACRooms);
					Collections.sort(availableNACRooms);
					
					System.out.println("Available AC Rooms      : " + availableACRooms);
					System.out.println("Available NON AC Rooms  : " + availableNACRooms);
					System.out.println(" ");
				}
				else if ((int)reservedRooms.get(i) >= 11 && (int)reservedRooms.get(i) <= 20) 
				{
					availableNACRooms.add(reservedRooms.get(i));
					reservedRooms.remove(i);
					
					Collections.sort(availableACRooms);
					Collections.sort(availableNACRooms);
					
					System.out.println("Available AC Rooms      : " + availableACRooms);
					System.out.println("Available NON AC Rooms  : " + availableNACRooms);
					System.out.println(" ");
				}
			}
		}
		
	}

	// add new rooms
	@Override
	public void addRoom(String roomType, ArrayList availableACRooms, ArrayList availableNACRooms, int roomNo) {
		
		if (roomType.equals("AC") || roomType.equals("ac")) {
			availableACRooms.add(roomNo);
			System.out.println("New AC Room Added : " + roomNo); 
			System.out.println(" ");

			Collections.sort(availableACRooms);
			Collections.sort(availableNACRooms);
			
			System.out.println("Available AC Rooms      : " + availableACRooms);
			System.out.println("Available NON AC Rooms  : " + availableNACRooms);
			System.out.println(" ");
		}
		else if (roomType.equals("NAC") || roomType.equals("nac")) {
			availableNACRooms.add(roomNo);
			System.out.println("New Non-AC Room Added : " + roomNo); 
			System.out.println(" ");

			Collections.sort(availableACRooms);
			Collections.sort(availableNACRooms);
			
			System.out.println("Available AC Rooms      : " + availableACRooms);
			System.out.println("Available NON AC Rooms  : " + availableNACRooms);
			System.out.println(" ");
		}
		
	}

	// remove rooms
	@Override
	public void removeRoom(String roomType, ArrayList availableACRooms, ArrayList availableNACRooms, int roomNo) {
		
		if (roomType.equals("AC") || roomType.equals("ac")) {
			for (int i = 0; i < availableACRooms.size(); i++) {
				if (roomNo == (int)availableACRooms.get(i)) {
					availableACRooms.remove(i);
					System.out.println("AC Room Removed : " + roomNo); 
					System.out.println(" ");

					Collections.sort(availableACRooms);
					Collections.sort(availableNACRooms);
					
					System.out.println("Available AC Rooms      : " + availableACRooms);
					System.out.println("Available NON AC Rooms  : " + availableNACRooms);
					System.out.println(" ");
				}
			}
		}
		else if (roomType.equals("NAC") || roomType.equals("nac")) {
			for (int i = 0; i < availableNACRooms.size(); i++) {
				if (roomNo == (int)availableNACRooms.get(i)) {
					availableNACRooms.remove(i);
					System.out.println("Non-AC Room Removed : " + roomNo); 
					System.out.println(" ");

					Collections.sort(availableACRooms);
					Collections.sort(availableNACRooms);
					
					System.out.println("Available AC Rooms      : " + availableACRooms);
					System.out.println("Available NON AC Rooms  : " + availableNACRooms);
					System.out.println(" ");
				}
			}
		}
		
	}

	@Override
	public String LoginVerification(String username, String password) {
		if ((username.equals("manager")) && (password.equals("man1"))) {
			return "manager";
			
		}else if ((username.equals("receptionist")) && (password.equals("recep1"))) {
			return "receptionist";
			
		}else {
			System.out.println("Invalid Login... Try Again...");
			System.out.println(" ");
		}
		return null;
	}

	// reserve restaurant table
	@Override
	public void reserveRTable(int noOfTables, ArrayList availableRTables, ArrayList availableTTables,
			ArrayList reservedTables) {
		if (noOfTables <= availableRTables.size()) {
			for (int i = 0; i < noOfTables; i++) {
				int j = 0;
				int table = (int)availableRTables.remove(j);
				reservedTables.add(table);
			}
			
			totalTableCharge = noOfTables*500;
			
			System.out.println("Toatl Table Charge : Rs." + totalTableCharge);
			System.out.println(" ");
			
			Collections.sort(availableRTables);
			Collections.sort(availableTTables);
			
			System.out.println("Available Restaurant Tables : " + availableRTables);
			System.out.println("Available Terrace Tables    : " + availableTTables);
			System.out.println(" ");
		} else {
			System.out.println("Sorry!!! All our Restaurant tables are reserved");
			System.out.println(" ");
		}
		
	}

	// reserve terrace table
	@Override
	public void reserveTTable(int noOfTables, ArrayList availableRTables, ArrayList availableTTables,
			ArrayList reservedTables) {
		if (noOfTables <= availableTTables.size()) {
			for (int i = 0; i < noOfTables; i++) {
				int j = 0;
				int table = (int)availableTTables.remove(j);
				reservedTables.add(table);
			}
			
			totalTableCharge = noOfTables*300;
			
			System.out.println("Toatl Table Charge : Rs." + totalTableCharge);
			System.out.println(" ");
			
			Collections.sort(availableRTables);
			Collections.sort(availableTTables);
			
			System.out.println("Available Restaurant Tables : " + availableRTables);
			System.out.println("Available Terrace Tables    : " + availableTTables);
			System.out.println(" ");
		} else {
			System.out.println("Sorry!!! All our Terrace tables are reserved");
			System.out.println(" ");
		}
		
	}

	// release table
	@Override
	public void releaseTable(int reservedTableNo, ArrayList availableRTables, ArrayList availableTTables,
			ArrayList reservedTables) {
		for (int i = 0; i < reservedTables.size(); i++) {
			if (reservedTableNo == (int)reservedTables.get(i)) {
				if ((int)reservedTables.get(i) >= 21 && (int)reservedTables.get(i) <= 30) {
					availableRTables.add(reservedTables.get(i));
					reservedTables.remove(i);
					
					Collections.sort(availableRTables);
					Collections.sort(availableTTables);
					
					System.out.println("Available Restaurant Tables : " + availableRTables);
					System.out.println("Available Terrace Tables    : " + availableTTables);
					System.out.println(" ");
				}
				else if ((int)reservedTables.get(i) >= 31 && (int)reservedTables.get(i) <= 40) {
					availableTTables.add(reservedTables.get(i));
					reservedTables.remove(i);
					
					Collections.sort(availableRTables);
					Collections.sort(availableTTables);
					
					System.out.println("Available Restaurant Tables : " + availableRTables);
					System.out.println("Available Terrace Tables    : " + availableTTables);
					System.out.println(" ");
				}
			}
		}
		
	}
	
	// add table
	@Override
	public void addTable(String tableType, ArrayList availableRTables, ArrayList availableTTables, int tableNo) {
		
		if (tableType.equals("RT") || tableType.equals("rt")) {
			availableRTables.add(tableNo);
			System.out.println("New Restaurant Table Added : " + tableNo); 
			System.out.println(" ");

			Collections.sort(availableRTables);
			Collections.sort(availableTTables);
			
			System.out.println("Available Restaurant Tables : " + availableRTables);
			System.out.println("Available Terrace Tables    : " + availableTTables);
			System.out.println(" ");
		}
		else if (tableType.equals("TT") || tableType.equals("tt")) {
			availableTTables.add(tableNo);
			System.out.println("New Terrace Table Added : " + tableNo); 
			System.out.println(" ");

			Collections.sort(availableRTables);
			Collections.sort(availableTTables);
			
			System.out.println("Available Restaurant Tables : " + availableRTables);
			System.out.println("Available Terrace Tables    : " + availableTTables);
			System.out.println(" ");
		}
		
	}

	// remove table
	@Override
	public void removeTable(String tableType, ArrayList availableRTables, ArrayList availableTTables, int tableNo) {
		
		if (tableType.equals("RT") || tableType.equals("rt")) {
			for (int i = 0; i < availableRTables.size(); i++) {
				if (tableNo == (int)availableRTables.get(i)) {
					availableRTables.remove(i);
					System.out.println("Restaurant table Removed : " + tableNo); 
					System.out.println(" ");

					Collections.sort(availableRTables);
					Collections.sort(availableTTables);
					
					System.out.println("Available Restaurant Tables : " + availableRTables);
					System.out.println("Available Terrace Tables    : " + availableTTables);
					System.out.println(" ");
				}
			}
		}
		else if (tableType.equals("TT") || tableType.equals("tt")) {
			for (int i = 0; i < availableTTables.size(); i++) {
				if (tableNo == (int)availableTTables.get(i)) {
					availableTTables.remove(i);
					System.out.println("Terrace Table Removed : " + tableNo); 
					System.out.println(" ");

					Collections.sort(availableRTables);
					Collections.sort(availableTTables);
					
					System.out.println("Available Restaurant Tables : " + availableRTables);
					System.out.println("Available Terrace Tables    : " + availableTTables);
					System.out.println(" ");
				}
			}
		}
		
	}

}
