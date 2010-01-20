package bwbv.rlt.server;

import bwbv.rlt.client.service.SampleRemoteService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SampleRemoteServiceImpl extends RemoteServiceServlet implements
		SampleRemoteService {

	public String doComplimentMe() {
		return RandomCompliment.get();
	}	
}
