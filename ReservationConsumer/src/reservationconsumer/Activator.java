package reservationconsumer;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import reservationproducer.ReservationPublish;
import reservationproducer.ReservationPublishImpl;

public class Activator implements BundleActivator {

	private static BundleContext context = null;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		System.out.println("Reservation Subscriber Service Started Successfully...");
		System.out.println(" ");
		
		try {
			String releaseRoom, releaseTable, username, password, choice, roomAddType, tableAddType;
			int reservedRoomNo, addRoomNo, removeRoomNo, reservedTableNo, addTableNo, removeTableNo;
			String roomType = null;
			String tableType = null;
			int noOfRooms = 0;
			int noOfTables = 0;
			float totalRoomCharge, totalTableCharge;
			
			ArrayList<Integer> availableACRooms = new ArrayList<Integer>();
			ArrayList<Integer> availableNACRooms = new ArrayList<Integer>();
			
			ArrayList<Integer> availableRTables = new ArrayList<Integer>();
			ArrayList<Integer> availableTTables = new ArrayList<Integer>();
			
			ArrayList<Integer> reservedRooms = new ArrayList<Integer>();
			
			ArrayList<Integer> reservedTables = new ArrayList<Integer>();
			
			availableACRooms.add(1);
			availableACRooms.add(2);
			availableACRooms.add(3);
			availableACRooms.add(4);
			availableACRooms.add(5);
			
			availableNACRooms.add(11);
			availableNACRooms.add(12);
			availableNACRooms.add(13);
			availableNACRooms.add(14);
			availableNACRooms.add(15);
			
			availableRTables.add(21);
			availableRTables.add(22);
			availableRTables.add(23);
			availableRTables.add(24);
			availableRTables.add(25);
			
			availableTTables.add(31);
			availableTTables.add(32);
			availableTTables.add(33);
			availableTTables.add(34);
			availableTTables.add(35);
			
			System.out.println("Available AC Rooms      : " + availableACRooms);
			System.out.println("Available NON AC Rooms  : " + availableNACRooms);
			System.out.println(" ");
			
			System.out.println("Available Restaurant Tables	: " + availableRTables);
			System.out.println("Available Terrace Tables	: " + availableTTables);
			System.out.println(" ");
			
			Scanner sc = new Scanner(System.in);
			ReservationPublish rp = new ReservationPublishImpl();
			
			while (true) {
				
				//Logout from the system
				System.out.println("===================== Login to the System =====================");
				System.out.println(" ");
				System.out.println("<< If you want to exit, you can enter '-1' for the username >>");
				System.out.println(" ");
				
				System.out.print("Enter the username : ");
				username = sc.next();

				if (username.equals("-1")) {
					System.out.println("Ending the service");
					System.out.println("---------------------------------------------------------------");
					break;
				}
				
				System.out.print("Enter the password : ");
				password = sc.next();
				System.out.println(" ");
				
				choice = rp.LoginVerification(username, password);
				
				if (choice == "manager") {
					
					System.out.println("==================== Resort Management System ====================");
					System.out.println(" ");
					System.out.println(" Welcome Manager! ");
					System.out.println(" ");
					System.out.println("\tAvailable AC Rooms      : " + availableACRooms);
					System.out.println("\tAvailable NON-AC Rooms  : " + availableNACRooms);
					System.out.println(" ");
					System.out.println("\tAvailable Restaurant Tables	: " + availableRTables);
					System.out.println("\tAvailable Terrace Tables	: " + availableTTables);
					System.out.println(" ");
					
					System.out.println("Hello Manager, What do you want to do?");
					System.out.print("Manage Rooms or Manage Tables or Logout (rooms / tables / 0) : ");
					choice = sc.next();
					
					if (choice.equalsIgnoreCase("rooms")) {

						System.out.print("Add Room or Remove Room or Logout (add / remove / 0) : ");
						choice = sc.next();
						
						//Add rooms
						if(choice.equalsIgnoreCase("add"))
						{
							System.out.print("Enter the Room Type (AC,ac or NAC,nac) : ");
							roomAddType = sc.next();
					          
					        System.out.print("Enter the New Room Number : ");
					        addRoomNo = sc.nextInt();
					          
					        rp.addRoom(roomAddType, availableACRooms, availableNACRooms, addRoomNo);
					    }
						
						//Remove rooms
						else if (choice.equalsIgnoreCase("remove")) {
							System.out.print("Enter the Room Type (AC,ac or NAC,nac) : ");
							roomAddType = sc.next();
					          
					        System.out.print("Enter the Remove Room Number : ");
					        removeRoomNo = sc.nextInt();
					        
					        rp.removeRoom(roomAddType, availableACRooms, availableNACRooms, removeRoomNo);
						}
						
						//Logout from the system
						else {
							System.out.println("Manager logout from the system, Thank you.");
							System.out.println(" ");
						}
					}
					if (choice.equalsIgnoreCase("tables")) {

						System.out.print("Add Table or Remove Table or Logout (add / remove / 0) : ");
						choice = sc.next();
						
						//Add tables
						if(choice.equalsIgnoreCase("add"))
						{
							System.out.print("Enter the Table Type (RT,rt or TT,tt) : ");
							tableAddType = sc.next();
					          
					        System.out.print("Enter the New Table Number : ");
					        addTableNo = sc.nextInt();
					          
					        rp.addTable(tableAddType, availableRTables, availableTTables, addTableNo);
					    }
						
						//Remove tables
						else if (choice.equalsIgnoreCase("remove")) {
							System.out.print("Enter the Table Type (RT,rt or TT,tt) : ");
							tableAddType = sc.next();
					          
					        System.out.print("Enter the Remove Table Number : ");
					        removeTableNo = sc.nextInt();
					        
					        rp.removeTable(tableAddType, availableRTables, availableTTables, removeTableNo);
						}
						
						//Logout from the system
						else {
							System.out.println("Manager logout from the system, Thank you.");
							System.out.println(" ");
						}
					}
					
				}
				else if (choice == "receptionist") {
					
					System.out.println("=================== Resort Management System ===================");
					System.out.println(" ");
					System.out.println(" Welcome Receptionist! ");
					System.out.println(" ");
					System.out.println("\t - - - - - - - - - - - - - - - - - - - - - - - - - -");
					System.out.println("\t\tA/C Room Charge         : Rs. 4500/=");
					System.out.println("\t\tNON A/C Room Charge     : Rs. 4000/=");
					System.out.println("\t\tRestaurant Table Charge : Rs. 500/=");
					System.out.println("\t\tTerrace Table Charge    : Rs. 300/=");
					System.out.println(" ");
					System.out.println("\tAvailable AC Rooms      	: " + availableACRooms);
					System.out.println("\tAvailable NON AC Rooms  	: " + availableNACRooms);
					System.out.println(" ");
					System.out.println("\tAvailable Restaurant Tables	: " + availableRTables);
					System.out.println("\tAvailable Terrace Tables	: " + availableTTables);
					System.out.println("\t - - - - - - - - - - - - - - - - - - - - - - - - - -");
					System.out.println(" ");
					
					System.out.print("Manage Rooms or Manage Tables or Logout (rooms / tables / 0) : ");
					choice = sc.next();
					
					if (choice.equalsIgnoreCase("rooms")) {

						System.out.print("Enter the Service Type (BOOK,book or RELEASE,release) : ");
						releaseRoom = sc.next();
						
						// book room
						if((releaseRoom.equals("BOOK") || releaseRoom.equals("book"))) { 
							System.out.print("Enter the Room Type (AC,ac or NAC,nac) : ");
					        roomType = sc.next();
					
					        System.out.print("Enter Number Of Rooms : ");
					        noOfRooms = sc.nextInt();
				        }
						
						if(roomType.length() == 0 || releaseRoom.length() == 0){
							System.out.print("Error: room type not entered or nothing booked to release :(");
							break;
						} 
						
						else if((releaseRoom.equals("BOOK") || releaseRoom.equals("book")) ){ 
						
							if(roomType.equals("AC") || roomType.equals("ac")){
								rp.reserveACRoom(noOfRooms, availableACRooms, availableNACRooms, reservedRooms);
							
							} else if(roomType.equals("NAC") || roomType.equals("nac")){
								rp.reserveNACRoom(noOfRooms, availableACRooms, availableNACRooms, reservedRooms);
						 	
						 	} else{
						 		System.out.println("Room type is invalid...");
						 	}
					
						}
						// release room
						else if((releaseRoom.equals("RELEASE") || releaseRoom.equals("release"))){ 
							System.out.print("Enter the release room number : ");
							reservedRoomNo = sc.nextInt();
		                    System.out.println(" ");

							rp.releaseRoom(reservedRoomNo, availableACRooms, availableNACRooms, reservedRooms);
							 
						}
						else{
							System.out.println("Service type is Invalid..."); 
						}
					}
					if (choice.equalsIgnoreCase("tables")) {

						System.out.print("Enter the Service Type (BOOK,book or RELEASE,release) : ");
						releaseTable = sc.next();
						
						// book table
						if((releaseTable.equals("BOOK") || releaseTable.equals("book"))) { 
							System.out.print("Enter the Table Type (RT,rt or TT,tt) : ");
					        tableType = sc.next();
					
					        System.out.print("Enter Number Of Tables : ");
					        noOfTables = sc.nextInt();
				        }
						
						if(tableType.length() == 0 || releaseTable.length() == 0){
							System.out.print("Error: table type not entered or nothing booked to release :(");
							break;
						} 
						
						else if((releaseTable.equals("BOOK") || releaseTable.equals("book")) ){ 
						
							if(tableType.equals("RT") || tableType.equals("rt")){
								rp.reserveRTable(noOfTables, availableRTables, availableTTables, reservedTables);
							
							} else if(tableType.equals("TT") || tableType.equals("tt")){
								rp.reserveTTable(noOfTables, availableRTables, availableTTables, reservedTables);
						 	
						 	} else{
						 		System.out.println("Table type is invalid...");
						 	}
					
						}
						// release table
						else if((releaseTable.equals("RELEASE") || releaseTable.equals("release"))){ 
							System.out.print("Enter the release table number : ");
							reservedTableNo = sc.nextInt();
		                    System.out.println(" ");

							rp.releaseTable(reservedTableNo, availableRTables, availableTTables, reservedTables);
							 
						}
						else{
							System.out.println("Service type is Invalid..."); 
						}
					}
					
			
				}

			}
		} catch (Exception e) {}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Reservation Subscriber Service Stopped Successfully...\nGood Bye !!!");
		Activator.context = null;
	}

}
