package csms.vo;

public class Goods {
	private String gName;
	private String gid;
	private String gCID;
	private int gStock;
	private int gPrice;
	private String gCaption;

	public Goods(String gName, String gid, String gCID, int gStock, int gPrice, String gCaption) {
		this.gName = gName;
		this.gid = gid;
		this.gCID = gCID;
		this.gStock = gStock;
		this.gPrice = gPrice;
		this.gCaption = gCaption;
	}

	public Goods() {
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getgCID() {
		return gCID;
	}

	public void setgCID(String gCID) {
		this.gCID = gCID;
	}

	public int getgStock() {
		return gStock;
	}

	public void setgStock(int gStock) {
		this.gStock = gStock;
	}

	public int getgPrice() {
		return gPrice;
	}

	public void setgPrice(int gPrice) {
		this.gPrice = gPrice;
	}

	public String getgCaption() {
		return gCaption;
	}

	public void setgCaption(String gCaption) {
		this.gCaption = gCaption;
	}

	@Override
	public String toString() {
		return "gName:" + gName + ", gid:" + gid + ", gCID:" + gCID + ", gStock:" + gStock + ", gPrice:" + gPrice
				+ ", gCaption:" + gCaption;
	}

}
