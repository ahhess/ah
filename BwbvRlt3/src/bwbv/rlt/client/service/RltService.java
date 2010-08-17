package bwbv.rlt.client.service;

import bwbv.rlt.client.ClientState;
import bwbv.rlt.client.domain.AuthenticationException;

public interface RltService {

	void sendGetRltsRequest(ClientState clientState);
	void sendGetRltRequest(ClientState clientState, int rltId);

	//TODO AuthenticationException?
    void login(ClientState clientState, String userName, String pwd) throws AuthenticationException;
    void logout();
    Boolean isLoggedIn();

}
