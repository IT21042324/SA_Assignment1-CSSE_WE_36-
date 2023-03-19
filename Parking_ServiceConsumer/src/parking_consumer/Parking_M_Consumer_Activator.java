package parking_consumer;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import parking_publisher.Parking_M_Publisher;
import parking_publisher.Parking_M_PublisherImpl;


public class Parking_M_Consumer_Activator implements BundleActivator {

	
	//The Service tacker object
//	private ServiceTracker serviceTracker = null;
	
	ServiceReference serviceReference;
	
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Parking Management Consumer Started Successfully...\n");
		serviceReference = context.getServiceReference(Parking_M_Publisher.class.getName());
		Parking_M_Publisher servicePublish = (Parking_M_Publisher) context.getService(serviceReference);

	
		try {
			
			String  username, password, choice, Slot_Add_type;
	    	int  Add_Slot_No, Remove_Slot_No;
	    	String Slot_type = null;
			int no_of_slots = 0;
			
			ArrayList<Integer> A1_Slots = new ArrayList<Integer>();
			ArrayList<Integer> B1_Slots = new ArrayList<Integer>();
			
			
			A1_Slots.add(1);
			A1_Slots.add(2);
			A1_Slots.add(3);
			A1_Slots.add(4);
			A1_Slots.add(5);
			A1_Slots.add(6);
			A1_Slots.add(7);
			A1_Slots.add(8);
			
			B1_Slots.add(1);
			B1_Slots.add(2);
			B1_Slots.add(3);

			
			
			Scanner sc = new Scanner(System.in);
			Parking_M_Publisher parkingservice = new Parking_M_PublisherImpl();
			
			while (true) {
				System.out.println("==========================================================================");
				System.out.println("                          Login to the System                             ");
				System.out.println("========================================================================\n");
				System.out.println("<< If you want to exit, you can enter 'end' for the username >>\n");
				System.out.print("Enter the username : ");
				username = sc.next();
				
				if (username.equals("exit")) {
					System.out.println("Ending the service");
					System.out.println("---------------------------------------------------------------");
					break;
				}
				
				System.out.print("Enter the password : ");
				password = sc.next();
				System.out.println(" \n");
				
				choice = parkingservice.LoginVerification(username, password);
				
				if (choice == "Manager") {
					
					System.out.println("====================== Resort Management System ======================");
					System.out.println(" ");
					System.out.println("\tReserved Slots in A1 [10] : " + A1_Slots);
					System.out.println("\tReserved Slots in B1 [10] : " + B1_Slots);
					System.out.println(" ");
					
					System.out.println("Hello Parking Manager, What do you want to do?\n");
					System.out.print("Add vehicle to a parking slot or Remove vehicle in parking slot or Logout (add / remove / 0) : ");
					choice = sc.next();
					
					//Add slots
					if(choice.equalsIgnoreCase("add"))
					{
						System.out.print("Enter Parking Area (A1,a1 or B1,b1 ) : ");
						Slot_Add_type = sc.next();
				          
				        System.out.print("Enter the Slot Number in "+Slot_Add_type+" : ");
				        Add_Slot_No = sc.nextInt();
				          
				        parkingservice.Add_Slot(Slot_Add_type, A1_Slots, B1_Slots, Add_Slot_No);
				        }
					
					//Remove slots
					else if (choice.equalsIgnoreCase("remove")) {
						System.out.print("Enter Parking Area (A1,a1 or B1,b1 ) : ");
						Slot_Add_type = sc.next();
				          
				        System.out.print("Enter the Remove Slot Number in "+Slot_Add_type+" : ");
				        Remove_Slot_No = sc.nextInt();
				        
				        parkingservice.Remove_Slot(Slot_Add_type, A1_Slots, B1_Slots, Remove_Slot_No);
					}
					
					//Logout from the system
					else {
						System.out.println("Parking Manager logout from the system, Thank you.");
						System.out.println(" ");
					}
				}
				
			}	 
			
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Parking Managment Consumer Service Stopped...");
		context.ungetService(serviceReference);
	}

}
