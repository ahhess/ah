package bwbv.rlt.client.service;

import bwbv.rlt.client.domain.Authentication;

import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SecurityServiceAsync {
	public void login(String userName, AsyncCallback callback);
	public void logout(AsyncCallback callback);
	public void isLoggedIn(AsyncCallback<Boolean> callback);
	public void getCurrentAuthentication(AsyncCallback<Authentication> callback);

}
