package recorddirectorysubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import menu.Menu;
import recordsProvider.Login;
import recordsProvider.RecordServiceComplaintImp;
import recordsProvider.RecordServiceRequestImp;

public class Activator implements BundleActivator {

	private ServiceReference servRefLogin, servRefComplaint, servRefRequest;
	private static BundleContext context;
	private Scanner myScanner;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		System.out.println("Starting Customer Services");

		myScanner = new Scanner(System.in);

		servRefRequest = context.getServiceReference(RecordServiceRequestImp.class.getName());
		RecordServiceRequestImp recordServiceRequest = (RecordServiceRequestImp) context.getService(servRefRequest);

		servRefComplaint = context.getServiceReference(RecordServiceComplaintImp.class.getName());
		RecordServiceComplaintImp recordServiceComplaint = (RecordServiceComplaintImp) context
				.getService(servRefComplaint);

		servRefLogin = context.getServiceReference(Login.class.getName());
		Login loginService = (Login) context.getService(servRefLogin);

		int custID;
		String input;

		do {
			System.out.println("\nValidate User");
			System.out.print("Enter User ID: ");
			custID = myScanner.nextInt();
			myScanner.nextLine(); // consume the newline character
		} while (!loginService.validateLogin(custID) && custID != -1);

		if (custID != -1) {
			do {
				Menu.menu();
				int inp = Menu.validateInput(1, 2);

				if (inp == 1) {
					Menu.reqMenu();
					inp = Menu.validateInput(1, 2);

					if (inp == 1) {
						System.out.print("\nEnter new Request: ");
						String request = myScanner.nextLine();
						recordServiceRequest.save(request, custID);
						System.out.println("Request Saved!!\n");
					} else if (inp == 2) {
						recordServiceRequest.printHistory(custID);
					}
				} else if (inp == 2) {
					Menu.compMenu();
					inp = Menu.validateInput(1, 2);

					if (inp == 1) {
						System.out.print("\nEnter your complaint: ");
						String complaint = myScanner.nextLine();
						recordServiceComplaint.save(complaint, custID);
						System.out.println("Complaint Saved\n");
					} else if (inp == 2) {
						recordServiceComplaint.printHistory(custID);
					}
				}

				System.out.print("\nDo you want to continue? (y/n) ");
				input = myScanner.nextLine().toLowerCase();
			} while (input.equals("y"));
		}
		System.out.println("\nGoodbye!");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		context.ungetService(servRefComplaint);
		context.ungetService(servRefRequest);
		context.ungetService(servRefLogin);
		System.out.println("Stopping Customer Service");
	}

}
