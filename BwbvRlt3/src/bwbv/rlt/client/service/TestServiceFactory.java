package bwbv.rlt.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class TestServiceFactory {

	private static TestServiceAsync testService;

	private TestServiceFactory() {
	}

	public static TestServiceAsync getService() {
		if (testService == null) {
			testService = GWT.create(TestService.class);
			((ServiceDefTarget) testService).setServiceEntryPoint(GWT.getModuleBaseURL() + "testService");
		}
		return testService;
	}

}
