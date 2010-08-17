package bwbv.rlt.client.service;

import bwbv.rlt.client.ClientState;

public interface RltService {

	void sendGetRltsRequest(ClientState clientState);
	void sendGetRltRequest(ClientState clientState, int rltId);

	//TODO AuthenticationException?
    void login(ClientState clientState, String userName, String pwd);
    void logout(ClientState clientState);
//    void isLoggedIn(ClientState clientState);

}
