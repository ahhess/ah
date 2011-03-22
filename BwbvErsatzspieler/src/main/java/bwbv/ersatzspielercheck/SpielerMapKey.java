package bwbv.ersatzspielercheck;

@SuppressWarnings("serial")
public class SpielerMapKey {

	private int vnr = -1;
	private String passnr;

	public SpielerMapKey(String vnr, String passnr) {
		super();
		setVnr(vnr);
		this.passnr = passnr;
	}
	
	public SpielerMapKey(int vnr, String passnr) {
		super();
		this.vnr = vnr;
		this.passnr = passnr;
	}

	public int getVnr() {
		return vnr;
	}
	
	public void setVnr(int vnr) {
		this.vnr = vnr;
	}
	
	public void setVnr(String vnr) {
		try {
			this.vnr = Integer.parseInt(vnr);
		} catch (NumberFormatException e) {
			this.vnr = -1;
		}
	}

	public String getPassnr() {
		return passnr;
	}

	public void setPassnr(String passnr) {
		this.passnr = passnr;
	}
}
