package parking_publisher;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Parking_M_Publisher_Activator implements BundleActivator {

	ServiceRegistration  publishServiceRegistration;


	
	public void start(BundleContext context) throws Exception {
		System.out.println("Parking Managment Publisher Service Started...");
		Parking_M_Publisher publisherService = new Parking_M_PublisherImpl();
		publishServiceRegistration = context.registerService(Parking_M_Publisher.class.getName(), publisherService,null);
		

		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Parking Managment Publisher Service Stopped...");
		publishServiceRegistration.unregister();
		
	}

}
