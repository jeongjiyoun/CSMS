package csms.manager;

public class StringMaker {

	public String makeTel(String txt1, String txt2, String txt3) {
		String ctel = txt1 + "-" + txt2 + "-" + txt3;
		return ctel;
	}

	public String makeRegi(String txt1, String txt2, String txt3) {
		String creginum = txt1 + "-" + txt2 + "-" + txt3;
		return creginum;
	}

	public String MakePw(char[] pw) {
		String cpw = new String(pw);
		return cpw;
	}

}
