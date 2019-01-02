package csms.vo;

public class DealingCompany {
	String dcidFrom;
	String dcidTo;
	int dnum;

	public DealingCompany() {
		super();
	}

	public DealingCompany(String dcidFrom, String dcidTo, int dnum) {
		super();
		this.dcidFrom = dcidFrom;
		this.dcidTo = dcidTo;
		this.dnum = dnum;
	}

	public String getDcidFrom() {
		return dcidFrom;
	}

	public void setDcidFrom(String dcidFrom) {
		this.dcidFrom = dcidFrom;
	}

	public String getDcidTo() {
		return dcidTo;
	}

	public void setDcidTo(String dcidTo) {
		this.dcidTo = dcidTo;
	}

	public int getDnum() {
		return dnum;
	}

	public void setDnum(int dnum) {
		this.dnum = dnum;
	}

	@Override
	public String toString() {
		return "dcidFrom:" + dcidFrom + ", dcidTo:" + dcidTo + ", dnum:" + dnum;
	}

}
