package bwbv.rlt.client.service;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * 
 * Make and hold a singleton (per app user) reference to service proxy.
 * Pass this to every screen
 *
 */
public class ServiceRegistry {
	//proxies to our services
//	private TestServiceAsync testService;
	private SampleRemoteServiceAsync sampleRemoteService;
	private SecurityServiceAsync securityService;

	
//	public TestServiceAsync getTestService() {
//		if(testService == null) {
//			testService = GWT.create(TestService.class);
//			((ServiceDefTarget)testService).setServiceEntryPoint(GWT.getModuleBaseURL() + "testService");
//		}
//		return testService;
//	}
	
	public SampleRemoteServiceAsync getSampleRemoteService() {
		if(sampleRemoteService == null) {
			sampleRemoteService = GWT.create(SampleRemoteService.class);
			((ServiceDefTarget)sampleRemoteService).setServiceEntryPoint(GWT.getModuleBaseURL() + "sampleRemoteService");
		}
		return sampleRemoteService;
	}
	
	public SecurityServiceAsync getSecurityService() {
		if(securityService == null) {
			securityService = GWT.create(SecurityService.class);
			((ServiceDefTarget)securityService).setServiceEntryPoint(GWT.getModuleBaseURL() + "securityService");
		}
		return securityService;
	}
	
}
