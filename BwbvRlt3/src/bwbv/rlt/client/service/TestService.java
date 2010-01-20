package bwbv.rlt.client.service;

import java.util.ArrayList;

import bwbv.rlt.client.domain.Candidate;

import com.google.gwt.user.client.rpc.RemoteService;

public interface TestService extends RemoteService {
	public String myMethod(String s);
	public ArrayList<Candidate> getCandidates();
	public String longRunningMethod(int runningTime);
}