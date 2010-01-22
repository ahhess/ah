package bwbv.rlt.server;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import bwbv.rlt.client.domain.Candidate;
import bwbv.rlt.client.service.TestService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class TestServiceImpl extends RemoteServiceServlet implements TestService {

	public static final Logger LOGGER = Logger.getLogger(TestServiceImpl.class);
	public String myMethod(String s) {
		// Do something interesting with 's' here on the server.
		return s;
	}
	
	public ArrayList<Candidate> getCandidates() {
		Candidate candidate1 = new Candidate("Obama", 45);
		Candidate candidate2 = new Candidate("Hillary", 60);
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		candidates.add(candidate1);
		candidates.add(candidate2);
		LOGGER.info("returning candidates list");
		return candidates;
	}
	
	public String longRunningMethod(int runningTime) {
		
		try {
			Thread.sleep(runningTime);
		} catch (InterruptedException e) {
			// ignore
		}
		return "operation took " + runningTime + " millis";
	}

}