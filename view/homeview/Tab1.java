package csms.view.homeview;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import csms.service.DealingCService;
import csms.service.GoodsService;
import csms.service.InquiryService;
import csms.view.HomeView;

public class Tab1 extends JPanel {

	private static final long serialVersionUID = -5244853905588282496L;
	@SuppressWarnings("unused")
	private HomeView window;
	private JTextField txtHwan;
	private JTextField txtMes;
	private JTextField txtReq;
	private JTextField txtGNum;
	private JPanel panel_1;
	private JSeparator separator;

	private InquiryService is = new InquiryService();
	private GoodsService gs = new GoodsService();
	private DealingCService ds = new DealingCService();

	public Tab1(HomeView homeView, String userId) {
		setBackground(SystemColor.text);
		this.window = homeView;
		construct();
		dynamics(userId);
		startActionListener();
	}

	private void dynamics(String userId) {
		int numG = gs.getMyGoods(userId).size();
		String numGMessage = "▶총 " + numG + "개의 상품이 등록되어 있습니다.";
		int numC = ds.countDeal(userId);
		String numCMessage = "▶총 " + numC + "개사와 정보를 공유중입니다.";
		int numM = is.unReadIn(userId);
		String numIMessage = "▶처리하지 않은 메시지가 " + numM + "건 있습니다.";
		textDefault(numGMessage, numCMessage, numIMessage);
	}

	private void textDefault(String numGMessage, String numCMessage, String numIMessage) {
		txtMes.setText(numIMessage);
		txtGNum.setText(numGMessage);
		txtHwan.setText(numCMessage);
		panel_1.add(txtMes);
		panel_1.add(txtGNum);
		panel_1.add(txtHwan);

	}

	private void construct() {

		separator = new JSeparator();
		add(separator);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 371, 444);
		add(panel_1);

		JLabel label_17 = new JLabel("좌측 메뉴를 이용해주세요.");
		label_17.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_17.setBounds(12, 36, 330, 28);
		panel_1.add(label_17);

		JLabel label_18 = new JLabel("홈 화면");
		label_18.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_18.setBounds(12, 10, 330, 28);
		panel_1.add(label_18);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 36, 330, 2);
		panel_1.add(separator_1);

		txtHwan = new JTextField();
		txtHwan.setBounds(42, 94, 270, 33);
		txtHwan.setOpaque(false);
		txtHwan.setBorder(null);
		txtHwan.setEditable(false);
		txtHwan.setFont(new Font("굴림체", Font.PLAIN, 15));
		txtHwan.setColumns(10);

		txtGNum = new JTextField();
		txtGNum.setBounds(42, 247, 270, 33);
		txtGNum.setColumns(10);
		txtGNum.setOpaque(false);
		txtGNum.setEditable(false);
		txtGNum.setFont(new Font("굴림체", Font.PLAIN, 15));
		txtGNum.setBorder(null);

		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(42, 287, 270, 33);
		txtMes.setOpaque(false);
		txtMes.setEditable(false);
		txtMes.setFont(new Font("굴림체", Font.PLAIN, 15));
		txtMes.setBorder(null);

		txtReq = new JTextField();
		txtReq.setColumns(10);
		txtReq.setBounds(42, 327, 270, 33);

	}

	private void startActionListener() {
	}
}
