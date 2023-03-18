package recordsProvider;

import java.util.ArrayList;

public class RecordServiceRequestImp implements RecordServiceRequestInterface {

	private static ArrayList<ArrayList<Object>> requestList = new ArrayList<>();
	private int custID;

	public RecordServiceRequestImp() {
		if (requestList.size() == 0) {
			requestList = new ArrayList<>();

			ArrayList<Object> tempList = new ArrayList<>();
			tempList.add(requestList.size() + 1);
			tempList.add("I need Food Order");
			tempList.add(1000);
			tempList.add("Ongoing");
			tempList.add("Awaiting Agent Response");
			requestList.add(tempList);

			tempList = new ArrayList<>();
			tempList.add(requestList.size() + 1);
			tempList.add("I need Drink Order");
			tempList.add(1000);
			tempList.add("Ongoing");
			tempList.add("Awaiting Agent Response");
			requestList.add(tempList);
		}
	}

	public void save(String descr, int custId) {
		ArrayList<Object> tempList = new ArrayList<>();
		tempList.add(requestList.size() + 1);
		tempList.add(descr);
		tempList.add(custId);
		tempList.add("Ongoing");
		tempList.add("Awaiting Agent Response");
		requestList.add(tempList);
	}

	public void printHistory() {
		System.out.println("Request Histroy \n");
		System.out.printf("%-10s %-30s %-15s %-25s\n", "RequestID", "Request", "Status", "Action");

		for (ArrayList<Object> minList : requestList) {
			System.out.printf("%-10d %-30s %-15s %-25s\n", minList.get(0), minList.get(1), minList.get(3),
					minList.get(4));
		}
	}

	public void printHistory(int custID) {
		System.out.println("Request Histroy \n");
		System.out.printf("%-10s %-30s %-15s %-25s\n", "RequestID", "Request", "Status", "Action");

		for (ArrayList<Object> minList : requestList) {
			if ((Integer) minList.get(2) == custID) {
				System.out.printf("%-10d %-30s %-15s %-25s\n", minList.get(0), minList.get(1), minList.get(3),
						minList.get(4));
			}
		}
	}

	public void printOngoing() {
		System.out.println("Ongoing Request \n");
		System.out.printf("%-10s %-30s %-15s %-25s\n", "RequestID", "Request", "Status", "Action");

		for (ArrayList<Object> minList : requestList) {
			if (((String) minList.get(3)).equalsIgnoreCase("Ongoing")) {
				System.out.printf("%-10d %-30s %-15s %-25s\n", minList.get(0), minList.get(1), minList.get(3),
						minList.get(4));
			}
		}
	}

	public void printOngoing(int custID) {
		System.out.println("Ongoing Request \n");
		System.out.printf("%-10s %-30s %-15s %-25s\n", "RequestID", "Request", "Status", "Action");

		for (ArrayList<Object> minList : requestList) {
			if (((String) minList.get(3)).equalsIgnoreCase("Ongoing") && (Integer) minList.get(2) == custID) {
				System.out.printf("%-10d %-30s %-15s %-25s\n", minList.get(0), minList.get(1), minList.get(3),
						minList.get(4));
			}
		}
	}

	public void update(String action, int reqID) {
		for (ArrayList<Object> minList : requestList) {
			if ((Integer) minList.get(0) == reqID) {
				minList.set(3, "Completed");
				minList.set(4, action);

				System.out.println("Request Updated");
			}
		}
	}

	public int getListLength() {
		return requestList.size();
	}
}
