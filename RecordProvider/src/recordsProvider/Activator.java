package recordsProvider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration servRegLogin;
	private ServiceRegistration servRegRequest;
	private ServiceRegistration servRegComplaint;

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		System.out.println("Starting Record Services");

		servRegLogin = bundleContext.registerService(Login.class.getName(), new Login(), null);
		servRegRequest = bundleContext.registerService(RecordServiceRequestImp.class.getName(),
				new RecordServiceRequestImp(), null);
		servRegComplaint = bundleContext.registerService(RecordServiceComplaintImp.class.getName(),
				new RecordServiceComplaintImp(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;

		System.out.println("Shutting down Record Services");

		servRegLogin.unregister();
		servRegRequest.unregister();
		servRegComplaint.unregister();
	}
}
