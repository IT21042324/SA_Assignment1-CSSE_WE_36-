package recorddirectoryagent;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import menu.Menu;
import recordsProvider.RecordServiceComplaintImp;
import recordsProvider.RecordServiceRequestImp;

public class Activator implements BundleActivator {

	private ServiceReference servRefComplaint, servRefRequest;
	private static BundleContext context;
	private Scanner myScanner;
	private String desc;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		System.out.println("Starting Agent Services\n");

		myScanner = new Scanner(System.in);

		servRefRequest = context.getServiceReference(RecordServiceRequestImp.class.getName());
		RecordServiceRequestImp recordServiceRequest = (RecordServiceRequestImp) context.getService(servRefRequest);

		servRefComplaint = context.getServiceReference(RecordServiceComplaintImp.class.getName());
		RecordServiceComplaintImp recordServiceComplaint = (RecordServiceComplaintImp) context
				.getService(servRefComplaint);

		boolean shouldExit = false;
		System.out.println("Do you want to start the Agent Service (Y/N)\n");
		desc = myScanner.nextLine();

		if (desc.equalsIgnoreCase("N"))
			shouldExit = true;

		while (!shouldExit) {
			Menu.menu();
			int inp = Menu.validateInput(1, 2);

			if (inp == 1) {
				recordServiceRequest.printHistory();

				System.out.println("\nEnter Request ID to update: ");
				inp = Menu.validateInput(1, recordServiceRequest.getListLength());

				if (inp != -1) {
					System.out.println("\nEnter Action Taken : ");
					desc = myScanner.nextLine();

					recordServiceRequest.update(desc, inp);
				}
			} else if (inp == 2) {
				recordServiceComplaint.printHistory();

				System.out.println("\nEnter Complaint ID to update: ");
				inp = Menu.validateInput(1, recordServiceComplaint.getListLength());

				if (inp != -1) {
					System.out.println("\nEnter Action Taken : ");
					desc = myScanner.nextLine();

					recordServiceComplaint.update(desc, inp);
				}
			}

			System.out.println("\nDo you want to exit? (Y/N)");
			String answer = myScanner.nextLine();
			if (answer.equalsIgnoreCase("Y")) {
				shouldExit = true;
			}
		}

	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		context.ungetService(servRefComplaint);
		context.ungetService(servRefRequest);

		System.out.println("\nExiting Agent Service");
	}
}
