package staffmanagementproducer;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StaffPublishImpl implements StaffPublish {

	@Override
	public void addStaff(String StaffType, HashMap<Integer, String> Employees, HashMap<Integer, String> KitchenStaff,
			int stid, String nme) {
		// TODO Auto-generated method stub
		if (StaffType.equalsIgnoreCase("KITCHEN")) {
		    if (KitchenStaff.containsKey(stid)) {
		        System.out.println("Kitchen Staff Member with ID " + stid + " already exists.");
		        return;
		    }

		    KitchenStaff.put(stid, nme);
		    System.out.println("New Kitchen Staff Member Added: " + nme);
		    System.out.println("New Kitchen Staff Member ID: " + stid);
		    System.out.println("--------------------------------------------------------------------------------------------");
		    System.out.println("");

		    System.out.format("%-20s%-5s%n", "Staff Member", "ID");
		    for (int i = 1; i <= Employees.size(); i++) {
		        String staffMember = Employees.get(i);
		        int staffID = i;
		        System.out.format("%-20s%-5d%n", staffMember, staffID);
		    }
		
		    System.out.println("");
		    System.out.println("--------------------------------------------------------------------------------------------");
		    System.out.format("%-20s%-5s%n", "Kitchen Staff Member", "ID");
		    for (int kitchenStaffID = 11; kitchenStaffID <= KitchenStaff.size() + 10; kitchenStaffID++) {
		        String kitchenStaffMember = KitchenStaff.get(kitchenStaffID);
		        System.out.format("%-20s%-5d%n", kitchenStaffMember, kitchenStaffID);
		    }
		

		}else if (StaffType.equalsIgnoreCase("EMPLOYEES")) {
		    if (Employees.containsKey(stid)) {
		        System.out.println("Kitchen Staff Member with ID " + stid + " already exists.");
		        return;
		    }

		   Employees.put(stid, nme);
		    System.out.println("New Employee Added: " + nme);
		    System.out.println("New Employee ID: " + stid);
		    System.out.println("--------------------------------------------------------------------------------------------");
		    System.out.println("");

		    System.out.format("%-20s%-5s%n", "Staff Member", "ID");
		    for (int i = 1; i <= Employees.size(); i++) {
		        String staffMember = Employees.get(i);
		        int staffID = i;
		        System.out.format("%-20s%-5d%n", staffMember, staffID);
		    }
		    System.out.println("");

		    System.out.format("%-20s%-5s%n", "Kitchen Staff Member", "ID");
		    for (int kitchenStaffID = 11; kitchenStaffID <= KitchenStaff.size() + 10; kitchenStaffID++) {
		        String kitchenStaffMember = KitchenStaff.get(kitchenStaffID);
		        System.out.format("%-20s%-5d%n", kitchenStaffMember, kitchenStaffID);
		    }
		

			System.out.println(" ");
			 System.out.println("--------------------------------------------------------------------------------------------");

}
}



	public void removeStaff(String StaffType, HashMap<Integer, String> Employees, HashMap<Integer, String> KitchenStaff, int stid) {
		 if (StaffType.equalsIgnoreCase("kitchen")) {
		        Iterator<Map.Entry<Integer, String>> iter = KitchenStaff.entrySet().iterator();
		        while (iter.hasNext()) {
		            Map.Entry<Integer, String> entry = iter.next();
		            if (entry.getKey().equals(stid)) {
		                iter.remove(); // Remove the entry from the HashMap
		                System.out.println("Kitchen Staff Member Removed : " + entry.getValue() + " (ID: " + entry.getKey() + ")");
		                System.out.println("--------------------------------------------------------------------------------------------");
		                System.out.println("");
		                
		                // Print out the updated lists as a table
		                System.out.format("%-20s%-5s%n", "Employee", "ID");
		                for (int i = 1; i <=Employees.size(); i++) {
		                    String employee = Employees.get(i);
		                    int staffID = i;
		                    System.out.format("%-20s%-5d%n", employee, staffID);
		                }
		                System.out.println(" ");
		                System.out.format("%-20s%-5s%n", "KitchenstaffMember", "ID");
		                for (int i = 1; i <= KitchenStaff.size(); i++) {
		                    String kitchenStaffMember = KitchenStaff.get(i);
		                    int kitchenStaffID = i+10;
		                    System.out.format("%-20s%-5d%n", kitchenStaffMember, kitchenStaffID);
		                }
		                
		                System.out.println("");
		                System.out.println("--------------------------------------------------------------------------------------------");
		                break;
		            }
		        }
		    } else if (StaffType.equalsIgnoreCase("employees")) {
		        Iterator<Map.Entry<Integer, String>> iter = Employees.entrySet().iterator();
		        while (iter.hasNext()) {
		            Map.Entry<Integer, String> entry = iter.next();
		            if (entry.getKey().equals(stid)) {
		                iter.remove(); // Remove the entry from the HashMap
		                KitchenStaff.remove(entry.getKey());
		                System.out.println("Employee Removed : " + entry.getValue() + " (ID: " + entry.getKey() + ")");
		                System.out.println("--------------------------------------------------------------------------------------------");
		                System.out.println("");
		                
		                // Print out the updated lists as a table
		                System.out.format("%-20s%-5s%n", "Employee", "ID");
		                for (int i = 1; i <= Employees.size(); i++) {
		                    String employee = Employees.get(i);
		                    int staffID = i;
		                    System.out.format("%-20s%-5d%n", employee, staffID);
		                }
		                System.out.println(" ");
		                System.out.format("%-20s%-5s%n", "KitchenstaffMember", "ID");
		                for (int i = 1; i <= KitchenStaff.size(); i++) {
		                    String kitchenStaffMember = KitchenStaff.get(i);
		                    int kitchenStaffID = i+10;
		                    System.out.format("%-20s%-5d%n", kitchenStaffMember, kitchenStaffID);
		                }
		                
		                System.out.println("");
		                System.out.println("--------------------------------------------------------------------------------------------");
		                break;
		            }
		        }
		    }
		}

	@Override
	public String LoginVerification(String username, String password) {
		// TODO Auto-generated method stub
		if ((username.equals("manager")) && (password.equals("manager123"))) {
			return "manager";

		} else {
			System.out.println("Invalid Login....... Try Again........");
			System.out.println(" ");
		}
		return null;
	}

}
