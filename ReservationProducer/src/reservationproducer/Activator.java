package reservationproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		bundleContext.registerService(ReservationPublish.class.getName(), new ReservationPublishImpl(), null);
		System.out.println("Reservation Publisher Service Started Successfully...");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Reservation Publisher Service Stopped Successfully...");
	}

}
