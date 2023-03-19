package parking_publisher;

import java.util.ArrayList;

public interface Parking_M_Publisher {
	
	public String LoginVerification(String username,String password);
	
	public void Add_Slot(String ParkingArea,ArrayList A1_Slots,ArrayList B1_Slots,int slotno);
	public void Remove_Slot(String ParkingArea,ArrayList A1_Slots,ArrayList B1_Slots,int slotno);

}
