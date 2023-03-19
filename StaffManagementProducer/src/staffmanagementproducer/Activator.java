package staffmanagementproducer;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;



public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("Language", "English");
		
		bundleContext.registerService(StaffPublish.class.getName(), new StaffPublishImpl(), props);
		System.out.println("Staff Management Publisher Service Started Successfully.....................");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Staff Management Publisher Service Stopped Successfully...");
	}

}
