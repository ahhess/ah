package bwbv.rlt.client.service;

import bwbv.rlt.client.ClientState;

public interface RltService {

	void sendGetRltsRequest(ClientState clientState);
	
	//	Rlt[] getRlts();
	//Rlt[] getRltsByKat(RltKat kat);
	
//	public static class Holder {
//		
//		private static RltService service = null;
//		
//		public static RltService get() {
////			if (service == null) {
////				service = new RltJsonService();
////			}
//			return service;
//		}
//		
//		public static void set(RltService rltService) {
//			service = rltService;
//		}
//	}
}
