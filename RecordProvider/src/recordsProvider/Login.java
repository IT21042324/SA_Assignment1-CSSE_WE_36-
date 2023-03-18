package recordsProvider;

import java.util.ArrayList;

public class Login implements LoginI {
	private ArrayList<Integer> user;

	public Login() {
		user = new ArrayList<Integer>();
		user.add(1000);
		user.add(1001);
		user.add(1002);
		user.add(1003);
		user.add(1004);
		user.add(1005);
	}

	public boolean validateLogin(int id) {
		for (int custID : user) {
			if (custID == id) {
				System.out.println("User Validated \n");
				return true;
			}
		}
		return false;
	}
}
