package parking_publisher;

import java.util.ArrayList;
import java.util.Collections;

public class Parking_M_PublisherImpl implements Parking_M_Publisher{

	@Override
	public String LoginVerification(String username, String password) {
		
		if ((username.equals("Manager")) && (password.equals("parking123"))) {
			return "Manager";
			
		}else {
			System.out.println("Invalid Login... Try Again...");
			System.out.println(" ");
		}
		return null;
	}


	//Add vehicle to Parking Area 
	@Override
	public void Add_Slot(String ParkingArea, ArrayList A1_Slots, ArrayList B1_Slots, int slotno) {
		
		//Add to A1
		if(ParkingArea.equals("A1") || ParkingArea.equals("a1"))
			{
					A1_Slots.add(slotno);
					System.out.println("Add vehicle in A1(Slot_No) : " + slotno); 
					System.out.println(" ");

				    Collections.sort(A1_Slots);
				    Collections.sort(B1_Slots);
				  
				    System.out.println("\tReserved Slots in A1 [10]  : " + A1_Slots);
					System.out.println("\tReserved Slots in B1 [10]  : " + B1_Slots);
					System.out.println(" ");
				
			}
				
		//Add to B1
		else if(ParkingArea.equals("B1") || ParkingArea.equals("b1"))
		    {
					B1_Slots.add(slotno);
		       	   	System.out.println("Add vehicle in B1(Slot_No) : " + slotno);
		       	   	System.out.println(" ");
		       	  
		       	    Collections.sort(A1_Slots);
				    Collections.sort(B1_Slots);
			
				    System.out.println("\tReserved Slots in A1 [10] : " + A1_Slots);
					System.out.println("\tReserved Slots in B1 [10] : " + B1_Slots);
					System.out.println(" ");
		    }	
		else {
					System.out.println("\n****** Invalid Parking Area ******\n");
			}
		
	}


	
	//Remove vehicle in Parking Area 
	@Override
	public void Remove_Slot(String ParkingArea, ArrayList A1_Slots, ArrayList B1_Slots, int slotno) {
		
		//Remove in A1 slots
		if(ParkingArea.equals("A1") || ParkingArea.equals("a1"))
		{
			for(int i = 0; i < A1_Slots.size(); i++)
			{
				if(slotno == (int)A1_Slots.get(i))
				{
					A1_Slots.remove(i);
					System.out.println("Removed vehicle in A1(Slot_No) : " + slotno); 
					System.out.println(" ");

				    Collections.sort(A1_Slots);
				    Collections.sort(B1_Slots);

				    System.out.println("\tReserved Slots in A1 [10] : " + A1_Slots);
					System.out.println("\tReserved Slots in B1 [10]: " + B1_Slots);
					System.out.println(" ");
				}
				
			}
		}
		
		//Remove in B1 slots
		else if(ParkingArea.equals("B1") || ParkingArea.equals("b1"))
        { 
			 for(int i=0;i<B1_Slots.size();i++)
				{
					if(slotno == (int)B1_Slots.get(i))
					{
						B1_Slots.remove(i);
						System.out.println("Removed vehicle in B1(Slot_No) : " + slotno); 
						System.out.println(" ");
				 
						Collections.sort(A1_Slots);
						Collections.sort(B1_Slots);
						
					    System.out.println("\tReserved Slots in A1 [10] : " + A1_Slots);
						System.out.println("\tReserved Slots in B1 [10] : " + B1_Slots);
						System.out.println(" ");
					}	
				}
        }
		else 
		{
			System.out.println("Invalid Parking Area\n");
		}
		
	}
	
		
	
}
