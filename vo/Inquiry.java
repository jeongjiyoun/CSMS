package csms.vo;

public class Inquiry {
	int iorigin;
	String icFrom;
	String icTo;
	String iTitle;
	String icontents;
	String idate;

	public Inquiry() {
		super();
	}

	public int getIorigin() {
		return iorigin;
	}

	public void setIorigin(int iorigin) {
		this.iorigin = iorigin;
	}

	public Inquiry(String icFrom, String icTo, String iTitle, String icontents, String idate) {
		super();
		this.icFrom = icFrom;
		this.icTo = icTo;
		this.iTitle = iTitle;
		this.icontents = icontents;
		this.idate = idate;
	}

	public String getIcFrom() {
		return icFrom;
	}

	public void setIcFrom(String icFrom) {
		this.icFrom = icFrom;
	}

	public String getIcTo() {
		return icTo;
	}

	public void setIcTo(String icTo) {
		this.icTo = icTo;
	}

	public String getiTitle() {
		return iTitle;
	}

	public void setiTitle(String iTitle) {
		this.iTitle = iTitle;
	}

	public String getIcontents() {
		return icontents;
	}

	public void setIcontents(String icontents) {
		this.icontents = icontents;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	@Override
	public String toString() {
		return "icFrom:" + icFrom + ", icTo:" + icTo + ", iTitle:" + iTitle + ", icontents:" + icontents + ", idate:"
				+ idate;
	}

}
