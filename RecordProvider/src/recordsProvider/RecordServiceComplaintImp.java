package recordsProvider;

import java.util.ArrayList;

public class RecordServiceComplaintImp implements RecordServiceComplaintInterface {
	private ArrayList<ArrayList<Object>> complaintList = new ArrayList<>();

	public RecordServiceComplaintImp() {
		if (complaintList.size() == 0) {

			ArrayList<Object> tempList = new ArrayList<>();
			tempList.add(complaintList.size() + 1);
			tempList.add("Bad Food Order");
			tempList.add(1000);
			tempList.add("Ongoing");
			tempList.add("Awaiting Agent Response");
			complaintList.add(tempList);

			tempList = new ArrayList<>();
			tempList.add(complaintList.size() + 1);
			tempList.add("Bad Drink Order");
			tempList.add(1000);
			tempList.add("Ongoing");
			tempList.add("Awaiting Agent Response");
			complaintList.add(tempList);
		}
	}

	public void save(String descr, int custId) {
		ArrayList<Object> tempList = new ArrayList<>();
		tempList.add(complaintList.size() + 1);
		tempList.add(descr);
		tempList.add(custId);
		tempList.add("Ongoing");
		tempList.add("Awaiting Agent Response");
		complaintList.add(tempList);
	}

	public void update(String action, int reqID) {
		for (ArrayList<Object> minList : complaintList) {
			if ((Integer) minList.get(0) == reqID) {
				minList.set(3, "Completed");
				minList.set(4, action);

				System.out.println("Complaint Updated");
			}
		}
	}

	public void printHistory() {
		System.out.println("Complaint History \n");
		System.out.printf("%-10s %-30s %-15s %-25s\n", "ComplaintID", "Complaint", "Status", "Action");

		for (ArrayList<Object> minList : complaintList) {
			System.out.printf("%-10d %-30s %-15s %-25s\n", minList.get(0), minList.get(1), minList.get(3),
					minList.get(4));
		}
	}

	public void printHistory(int custID) {
		System.out.println("Request Histroy \n");
		System.out.printf("%-10s %-30s %-15s %-25s\n", "ComplaintID", "Complaint", "Status", "Action");

		for (ArrayList<Object> minList : complaintList) {
			if ((Integer) minList.get(2) == custID) {
				System.out.printf("%-10d %-30s %-15s %-25s\n", minList.get(0), minList.get(1), minList.get(3),
						minList.get(4));
			}
		}
	}

	public void printOngoing() {
		System.out.println("Ongoing Complaints \n");

		System.out.printf("%-10s %-30s %-15s %-25s\n", "ComplaintID", "Complaint", "Status", "Action");

		for (ArrayList<Object> minList : complaintList) {
			if (((String) minList.get(3)).equalsIgnoreCase("Ongoing")) {
				System.out.printf("%-10d %-30s %-15s %-25s\n", minList.get(0), minList.get(1), minList.get(3),
						minList.get(4));
			}
		}
	}

	public void printOngoing(int custID) {
		System.out.println("Ongoing Request \n");
		System.out.printf("%-10s %-30s %-15s %-25s\n", "ComplaintID", "Complaint", "Status", "Action");

		for (ArrayList<Object> minList : complaintList) {
			if (((String) minList.get(3)).equalsIgnoreCase("Ongoing") && (Integer) minList.get(2) == custID) {
				System.out.printf("%-10d %-30s %-15s %-25s\n", minList.get(0), minList.get(1), minList.get(3),
						minList.get(4));
			}
		}
	}

	public int getListLength() {
		return complaintList.size();
	}
}
