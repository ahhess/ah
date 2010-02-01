package bwbv.rlt.client.service;

public class SecurityServiceHolder {

	private static SecurityService service;

	private SecurityServiceHolder() {
	}

	public static SecurityService getService() {
		if (service == null) {
			service = new SecurityServiceInMemoryImpl();
		}
		return service;
	}

}
