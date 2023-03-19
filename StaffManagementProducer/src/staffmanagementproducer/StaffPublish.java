package staffmanagementproducer;


import java.util.HashMap;

public interface StaffPublish {

	

	
	public void addStaff(String StaffType, HashMap<Integer, String> Employees, HashMap<Integer, String> KitchenStaff, int stid, String nme);
	public void removeStaff(String StaffType, HashMap<Integer, String> Employees, HashMap<Integer, String> KitchenStaff, int stid);
	public String LoginVerification(String username, String password);
	
}
