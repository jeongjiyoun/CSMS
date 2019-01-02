package csms.vo;

//회원정보 VO
public class Company {
	private String cid; // 회원 ID
	private String cpw; // 회원 pw
	private String creginum; // 사업자등록번호
//여기까지 company 구성내용
//로그인 처리를 빠르게 하기 위해 테이블 분리

	private String ctel; // 전화번호
	private String cname; // 회사 이름
	private String caddress; // 주소
	private String ccomment = ""; // 한줄소개
	private int ctype; // 업종 분류
//여기까지 companyData 구성 내용

	public Company() {
	}

	public Company(String cid, String cpw, String creginum, String ctel, String cname, String caddress, String ccomment,
			int ctype) {
		super();
		this.cid = cid;
		this.cpw = cpw;
		this.creginum = creginum;
		this.ctel = ctel;
		this.cname = cname;
		this.caddress = caddress;
		this.ccomment = ccomment;
		this.ctype = ctype;
	}

	public Company(String cid, String cpw, String creginum) {
		super();
		this.cid = cid;
		this.cpw = cpw;
		this.creginum = creginum;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCpw() {
		return cpw;
	}

	public void setCpw(String cpw) {
		this.cpw = cpw;
	}

	public String getCreginum() {
		return creginum;
	}

	public void setCreginum(String creginum) {
		this.creginum = creginum;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCcomment() {
		return ccomment;
	}

	public void setCcomment(String ccomment) {
		this.ccomment = ccomment;
	}

	public int getCtype() {
		return ctype;
	}

	public void setCtype(int ctype) {
		this.ctype = ctype;
	}

	@Override
	public String toString() {
		return "cid:" + cid + ", cpw:" + cpw + ", creginum:" + creginum + ", ctel:" + ctel + ", cname:" + cname
				+ ", caddress:" + caddress + ", ccomment:" + ccomment + ", ctype:" + ctype;
	}

}
