package csms.vo;

public class SharingGoods extends Goods {
	private int sorigin;
	private String sCfrom;
	private String sCto;

	public SharingGoods() {
		super();
	}

	public int getSorigin() {
		return sorigin;
	}

	public void setSorigin(int sorigin) {
		this.sorigin = sorigin;
	}

	public SharingGoods(String gName, String gid, String gCID, int gStock, int gPrice, String gCaption, String sCfrom,
			String sCto) {
		super(gName, gid, gCID, gStock, gPrice, gCaption);
		this.sCfrom = sCfrom;
		this.sCto = sCto;
	}

	public String getsCfrom() {
		return sCfrom;
	}

	public void setsCfrom(String sCfrom) {
		this.sCfrom = sCfrom;
	}

	public String getsCto() {
		return sCto;
	}

	public void setsCto(String sCto) {
		this.sCto = sCto;
	}

	@Override
	public String toString() {
		return super.toString() + "sCfrom:" + sCfrom + ", sCto:" + sCto;
	}

}