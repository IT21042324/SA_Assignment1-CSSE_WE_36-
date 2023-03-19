package staffmanagementconsumer;

import java.util.HashMap;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import staffmanagementproducer.StaffPublish;
import staffmanagementproducer.StaffPublishImpl;




public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceTracker serviceTracker = null;
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		serviceTracker = new ServiceTracker(context, context.createFilter("(&(objectClass = " + StaffPublish.class.getName() + ")" + "(Language=*))"), null);
		serviceTracker.open();
		
		System.out.println("Staff Management Subscriber Service Started Successfully.........................");
		System.out.println(" ");
		System.out.println("---------------------------------------------------------------------------------------------------- ");
		
		try {
			String  username, password,choice,stafftype,name;
			
			int  addStaffNo, removeStaffNo;
			
		
			
			HashMap<Integer,String> Employees = new HashMap<Integer,String>();
			HashMap<Integer,String> KitchenStaff = new HashMap<Integer,String>();
		
			
	
			
			Employees.put(1,"Nisura");
			Employees.put(2,"Binuja");
			Employees.put(3,"Sarindu");
			Employees.put(4,"Nimal");
			Employees.put(5,"Bimal");
			
			KitchenStaff .put(11,"Kamal");
			KitchenStaff.put(12,"Nadiya");
			KitchenStaff .put(13,"Srimal");
			KitchenStaff .put(14,"Sumal");
			KitchenStaff .put(15,"Bandula");
		
			
	 
	   
			
			
			Scanner sc = new Scanner(System.in);
			StaffPublish st = new StaffPublishImpl();
			
			while (true) {
				System.out.println(" ");
				System.out.println("================================== * LOGIN TO THE SYSTEM * =====================================");
				System.out.println(" ");
				System.out.println("---------------------------------------------------------------------------------------------------- ");
				
				System.out.println("<<<<<<<<< * If you want to exit, you can enter 'end' for the username * >>>>>>>>>>>");
				System.out.println(" ");
				
				System.out.print("Enter the username : ");
				username = sc.next();

				if (username.equals("end")) {
					System.out.println("Ending the service");
					System.out.println("--------------------------------------------------------------------------------------------");
					break;
				}
				
				System.out.print("Enter the password : ");
				password = sc.next();
				System.out.println(" ");
				
				choice = st.LoginVerification(username, password);
				
				if (choice == "manager") {
					
					System.out.println("================================== * STAFF MANAGEMENT SYSTEM * =====================================");
					System.out.println(" ");
					System.out.println("!!!! * WELCOME MANAGER * !!!!");
					System.out.println(" ");
					System.out.println("==================================================================================================" );
					System.out.println(" ");
				       System.out.format("%-20s%-5s%n", "Employees", "ID");
				        for (int i = 1; i <= Employees.size(); i++) {
				            String staffMember = Employees.get(i);
				            int staffID = i;
				            System.out.format("%-20s%-5d%n", staffMember, staffID);
				        }
				        System.out.println("");

				        System.out.format("%-20s%-20s%n", "KitchenStaffMember", "ID");
				        for (int i = 11; i <= KitchenStaff.size() + 10; i++) {
				            String kitchenStaffMember = KitchenStaff.get(i);
				            int kitchenStaffID = i;
				            System.out.format("%-20s%-20d%n", kitchenStaffMember, kitchenStaffID);
				        }
					System.out.println(" ");
					System.out.println("==================================================================================================" );
					
					System.out.println("----------------------- * Hello Manager, What do you want to do? * --------------------------");
				
				}
					

						System.out.print("Add staff member or Remove staff memeber or Logout (add / remove / 0) : ");
						choice = sc.next();
						
						//Add rooms
						if(choice.equalsIgnoreCase("add"))
						{
							
					          
					        System.out.print("Enter the Staff type: ");
					        stafftype = sc.next();
					        
					        System.out.print("Enter the Employee ID: ");
					        addStaffNo= sc.nextInt();
					        System.out.print("Enter the Name: ");
					        name = sc.next();
					        
					     
					 
					        
					      st.addStaff(stafftype,Employees, KitchenStaff , addStaffNo,name);
					    }
						
						//Remove rooms
						else if (choice.equalsIgnoreCase("remove")) {
						
					          
					   
					        System.out.print("Enter the Staff type: ");
					        stafftype= sc.next();
					        System.out.print("Enter the Employee ID : ");
					        removeStaffNo = sc.nextInt();
					    
					   
					        
					     
					       
					        st.removeStaff(stafftype,Employees, KitchenStaff , removeStaffNo);
						}
		
						//Logout from the system
						else {
							System.out.println("Manager logout from the system, Thank you.");
							System.out.println(" ");
						}
					
		
				}
					System.out.print("Add staff member or Remove staff memeber or Logout (add / remove / 0) : ");
					choice = sc.next();
					if(choice.equalsIgnoreCase("add"))
					{
						
				          
				      
				        
				     
				        System.out.print("Enter the Staff type: ");
				        stafftype = sc.next();
				        System.out.print("Enter the Employee ID: ");
				        addStaffNo = sc.nextInt();
				        System.out.print("Enter the Name: ");
				        name = sc.next();
				        
				      
			
				        
				        st.addStaff(stafftype,Employees, KitchenStaff , addStaffNo,name);
				    }
					
					//Remove rooms
					else if (choice.equalsIgnoreCase("remove")) {
						 System.out.print("Enter the Staff type: ");
					       stafftype = sc.next();
					     
					
				          
				        System.out.print("Enter the Employee ID : ");
				        removeStaffNo = sc.nextInt();
				        
				     
				
				     
				       
				     
				        
				        st.removeStaff(stafftype,Employees, KitchenStaff , removeStaffNo);
					}
					else {
						System.out.println("Manager logout from the system, Thank you.");
						System.out.println(" ");
					
				}
		}
		
				
		catch (Exception e) {}}
		
		


			
		
	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Staff Management Consumer Service Stopped Successfully...");
	}

}
