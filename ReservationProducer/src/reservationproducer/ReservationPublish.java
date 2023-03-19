package reservationproducer;

import java.util.ArrayList;

public interface ReservationPublish {
	
	public String publishService();
	
	public void reserveACRoom(int noOfRooms, ArrayList availableACRooms, ArrayList availableNACRooms, ArrayList reservedRooms);
	public void reserveNACRoom(int noOfRooms, ArrayList availableACRooms, ArrayList availableNACRooms, ArrayList reservedRooms);
	public void releaseRoom(int reservedRoomNo, ArrayList availableACRooms, ArrayList availableNACRooms, ArrayList reservedRooms);
	
	public void addRoom(String roomType, ArrayList availableACRooms, ArrayList availableNACRooms, int roomNo);
	public void removeRoom(String roomType, ArrayList availableACRooms, ArrayList availableNACRooms, int roomNo);
	
	public void reserveRTable(int noOfTables, ArrayList availableRTables, ArrayList availableTTables, ArrayList reservedTables);
	public void reserveTTable(int noOfTables, ArrayList availableRTables, ArrayList availableTTables, ArrayList reservedTables);
	public void releaseTable(int reservedTableNo, ArrayList availableRTables, ArrayList availableTTables, ArrayList reservedTables);
	
	public void addTable(String tableType, ArrayList availableRTables, ArrayList availableTTables, int tableNo);
	public void removeTable(String tableType, ArrayList availableRTables, ArrayList availableTTables, int tableNo);

	public String LoginVerification(String username, String password);

}
