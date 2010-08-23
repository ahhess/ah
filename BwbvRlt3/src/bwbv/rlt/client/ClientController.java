package bwbv.rlt.client;

import bwbv.rlt.client.service.RltService;

public class ClientController {

	private ClientState clientState;
	private RltService rltService = null;
	
	public ClientController(ClientState clientState, RltService rltService) {
		this.clientState = clientState;
		this.rltService = rltService;
	}
	
	public RltService getRltService() {
		return rltService;
	}

	public ClientState getClientState() {
		return clientState;
	}
}
