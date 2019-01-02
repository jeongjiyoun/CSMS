package csms.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import csms.util.RoundedButton;
import csms.util.ScreenSize;
import csms.view.homeview.Tab1;
import csms.view.homeview.Tab2;
import csms.view.homeview.Tab3;
import csms.view.homeview.Tab4;
import csms.view.homeview.Tab5;
import csms.view.homeview.Tab6;
import csms.view.homeview.Tab7;

public class HomeView extends JDialog {
	private static final long serialVersionUID = -3633546927611353797L;
	private JTabbedPane tabbedPane;
	private String cid;
	private JTextPane txtpndate;

	public Tab1 tab1 = null;
	public Tab2 tab2 = null;
	public Tab3 tab3 = null;
	public Tab4 tab4 = null;
	public Tab5 tab5 = null;
	public Tab6 tab6 = null;
	public Tab7 tab7 = null;
	private RoundedButton button;

	public HomeView(String cid) {
		getContentPane().setBackground(SystemColor.text);
		this.cid = cid;
		setLocation(ScreenSize.getCenterPosition(this));
		startFrameSetting();
		startButton();
		getDate();
		startTab1();
		startTab2();
		startTab3();
		startTab4();
		startTab5();
		startTab6();
		startTab7();
		startActionListener();
	}

	private void startTab7() {
		JPanel pn7_Message = new Tab7(this, cid);
		tabbedPane.addTab("메시지 확인", null, pn7_Message, null);
		pn7_Message.setLayout(null);
	}

	private void startTab6() {
		JPanel pn6_MyInfo = new Tab6(this, cid);
		tabbedPane.addTab("내 회사 정보", null, pn6_MyInfo, null);
		pn6_MyInfo.setLayout(null);
	}

	private void startTab5() {
		JPanel pn5_FindCom = new Tab5(this, cid);
		tabbedPane.addTab("거래 회사 검색", null, pn5_FindCom, null);
		pn5_FindCom.setLayout(null);
	}

	private void startTab4() {
		JPanel pn4_ShowCom = new Tab4(this, cid);
		tabbedPane.addTab("거래 회사 조회", null, pn4_ShowCom, null);
		pn4_ShowCom.setLayout(null);
	}

	private void startTab3() {
		JPanel pn3_ShowShare = new Tab3(this, cid);
		tabbedPane.addTab("공유 상품 조회", null, pn3_ShowShare, null);
		pn3_ShowShare.setLayout(null);
	}

	private void startTab2() {
		JPanel pn2_MyProd = new Tab2(this, cid);
		tabbedPane.addTab("등록 상품 조회", null, pn2_MyProd, null);
		pn2_MyProd.setLayout(null);
	}

	private void startTab1() {
		JPanel pn1_home = new Tab1(this, cid);
		tabbedPane.addTab("홈", null, pn1_home, null);
		pn1_home.setLayout(null);
	}

	private void getDate() {
		Calendar date = Calendar.getInstance();
		String result = "날짜 : " + new SimpleDateFormat("yyyy년 MM월 dd일 E요일").format(date.getTime());
		txtpndate.setText(result);
		getContentPane().add(txtpndate);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(0, 475, 510, 40);
			getContentPane().add(panel);
		}
	}

	// 프레임
	private void startFrameSetting() {
		setTitle("재고 관리 시스템");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(516, 548);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	// 프레임에 내 버튼
	private void startButton() {

		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(12, 20, 486, 449);
		getContentPane().add(tabbedPane);

		button = new RoundedButton("로그아웃");
		button.setBackground(Color.DARK_GRAY);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("굴림체", Font.PLAIN, 15));
		button.setBounds(401, 484, 97, 23);
		getContentPane().add(button);

		txtpndate = new JTextPane();
		txtpndate.setFont(new Font("굴림체", Font.PLAIN, 15));
		txtpndate.setForeground(Color.WHITE);
		txtpndate.setBackground(Color.DARK_GRAY);
		txtpndate.setBounds(12, 482, 230, 26);

	}

	private void startActionListener() {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainView().setVisible(true);
			}
		});
	}
}
