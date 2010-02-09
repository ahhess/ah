package bwbv.rlt.client.service;

import bwbv.rlt.client.domain.Rlt;

public interface RltService {

	Rlt[] getRlts();
	//Rlt[] getRltsByKat(RltKat kat);
	
	public static class Holder {
		
		private static RltService service = null;
		
		public static RltService get() {
			if (service == null) {
				service = new RltJsonService();
			}
			return service;
		}
	}
}
