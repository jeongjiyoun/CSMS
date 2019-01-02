package csms.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import csms.manager.PopupManager;
import csms.manager.StringMaker;
import csms.service.CompanyService;
import csms.util.RoundedButton;
import csms.util.ScreenSize;
import csms.view.homeDial.ShowId;

public class FindIdPwView extends JFrame {
	private static final long serialVersionUID = -5708195731416099395L;
	private JTextField txtPReg1;
	private JTextField txtPReg2;
	private JTextField txtPReg3;
	private JTextField txtIName;
	private JTextField txtPId;
	private JTextField txtITel1;
	private JTextField txtITel2;
	private JTextField txtITel3;
	private JTextField txtIReg1;
	private JTextField txtIReg2;
	private JTextField txtIReg3;
	private JTextField txtPTel1;
	private JTextField txtPTel2;
	private JTextField txtPTel3;

	private PopupManager pm = new PopupManager();
	private StringMaker sm = new StringMaker();
	private CompanyService cs = new CompanyService();

	private RoundedButton btn_PW;
	private RoundedButton btn_ID;

	public FindIdPwView() {
		getContentPane().setFont(new Font("굴림체", Font.PLAIN, 15));
		startFrameSetting();
		startButtonEvents();
	}

	private void startButtonEvents() {
		btn_ID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String cname = txtIName.getText();
				String ctel = sm.makeTel(txtITel1.getText(), txtITel2.getText(), txtITel3.getText());
				String creginum = sm.makeRegi(txtIReg1.getText(), txtIReg2.getText(), txtIReg3.getText());

				String result = cs.findId(cname, ctel, creginum);
				if (result == null) {
					pm.failFind();
				} else {
					ShowId a = new ShowId(result);
					a.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
					a.setVisible(true);
					txtIName.setText("");
					txtITel1.setText("");
					txtITel2.setText("");
					txtITel3.setText("");
					txtIReg1.setText("");
					txtIReg2.setText("");
					txtIReg3.setText("");
				}
			}
		});

		btn_PW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String cid = txtPId.getText();
				String ctel = sm.makeTel(txtPTel1.getText(), txtPTel2.getText(), txtPTel3.getText());
				String creginum = sm.makeRegi(txtPReg1.getText(), txtPReg2.getText(), txtPReg3.getText());

				boolean result = cs.findPw(cid, ctel, creginum);
				if (result) {
					pm.changePw(cid);
					txtPId.setText("");
					txtPReg1.setText("");
					txtPReg2.setText("");
					txtPReg3.setText("");
					txtPTel1.setText("");
					txtPTel2.setText("");
					txtPTel3.setText("");
				} else {
					pm.failFind();
				}
			}
		});
	}

	private void startFrameSetting() {
		setTitle("재고 관리 시스템");
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel label = new JLabel("아이디 찾기");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 25));
		label.setBounds(175, 36, 138, 31);
		getContentPane().add(label);

		JLabel lab_pw = new JLabel("사업자 등록번호");
		lab_pw.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lab_pw.setBounds(72, 200, 116, 28);
		getContentPane().add(lab_pw);

		btn_ID = new RoundedButton("아이디 찾기");
		btn_ID.setFont(new Font("굴림체", Font.PLAIN, 15));
		btn_ID.setBounds(175, 282, 137, 34);
		getContentPane().add(btn_ID);

		btn_PW = new RoundedButton("비밀번호찾기");
		btn_PW.setFont(new Font("굴림체", Font.PLAIN, 15));
		btn_PW.setBounds(176, 655, 137, 34);
		getContentPane().add(btn_PW);

		JLabel label_5 = new JLabel("사업자 등록번호");
		label_5.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_5.setBounds(72, 574, 116, 28);
		getContentPane().add(label_5);

		JLabel label_10 = new JLabel("비밀번호 찾기");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 25));
		label_10.setBounds(158, 410, 171, 31);
		getContentPane().add(label_10);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(72, 603, 336, 30);
		getContentPane().add(panel_1);

		txtPReg1 = new JTextField();
		txtPReg1.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtPReg1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPReg1.setColumns(10);
		txtPReg1.setBounds(0, 0, 77, 30);
		panel_1.add(txtPReg1);

		JLabel label_2 = new JLabel("  -");
		label_2.setFont(new Font("나눔고딕", Font.PLAIN, 19));
		label_2.setBounds(87, 8, 21, 15);
		panel_1.add(label_2);

		txtPReg2 = new JTextField();
		txtPReg2.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtPReg2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPReg2.setColumns(10);
		txtPReg2.setBounds(122, 0, 61, 30);
		panel_1.add(txtPReg2);

		txtPReg3 = new JTextField();
		txtPReg3.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtPReg3.setHorizontalAlignment(SwingConstants.CENTER);
		txtPReg3.setColumns(10);
		txtPReg3.setBounds(220, 0, 116, 30);
		panel_1.add(txtPReg3);

		JLabel label_3 = new JLabel(" -");
		label_3.setFont(new Font("나눔고딕", Font.PLAIN, 19));
		label_3.setBounds(194, 8, 21, 15);
		panel_1.add(label_3);

		JLabel label_6 = new JLabel("회사명");
		label_6.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_6.setBounds(72, 64, 42, 28);
		getContentPane().add(label_6);

		txtIName = new JTextField();
		txtIName.setColumns(10);
		txtIName.setBounds(72, 92, 336, 30);
		getContentPane().add(txtIName);

		JLabel label_7 = new JLabel("전화번호");
		label_7.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_7.setBounds(72, 132, 56, 28);
		getContentPane().add(label_7);

		JLabel label_11 = new JLabel("전화번호");
		label_11.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_11.setBounds(72, 506, 56, 28);
		getContentPane().add(label_11);

		JLabel label_1 = new JLabel("아이디");
		label_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_1.setBounds(72, 440, 42, 28);
		getContentPane().add(label_1);

		txtPId = new JTextField();
		txtPId.setColumns(10);
		txtPId.setBounds(72, 468, 336, 30);
		getContentPane().add(txtPId);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(72, 158, 336, 30);
		getContentPane().add(panel_2);

		txtITel1 = new JTextField();
		txtITel1.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtITel1.setHorizontalAlignment(SwingConstants.CENTER);
		txtITel1.setColumns(10);
		txtITel1.setBounds(0, 0, 95, 30);
		panel_2.add(txtITel1);

		JLabel label_4 = new JLabel("  -");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_4.setBounds(95, 8, 21, 15);
		panel_2.add(label_4);

		txtITel2 = new JTextField();
		txtITel2.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtITel2.setHorizontalAlignment(SwingConstants.CENTER);
		txtITel2.setColumns(10);
		txtITel2.setBounds(122, 0, 95, 30);
		panel_2.add(txtITel2);

		txtITel3 = new JTextField();
		txtITel3.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtITel3.setHorizontalAlignment(SwingConstants.CENTER);
		txtITel3.setColumns(10);
		txtITel3.setBounds(241, 0, 95, 30);
		panel_2.add(txtITel3);

		JLabel label_12 = new JLabel(" -");
		label_12.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_12.setBounds(219, 8, 21, 15);
		panel_2.add(label_12);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(72, 230, 336, 30);
		getContentPane().add(panel);

		txtIReg1 = new JTextField();
		txtIReg1.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtIReg1.setHorizontalAlignment(SwingConstants.CENTER);
		txtIReg1.setColumns(10);
		txtIReg1.setBounds(0, 0, 77, 30);
		panel.add(txtIReg1);

		JLabel label_8 = new JLabel("  -");
		label_8.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_8.setBounds(87, 8, 21, 15);
		panel.add(label_8);

		txtIReg2 = new JTextField();
		txtIReg2.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtIReg2.setHorizontalAlignment(SwingConstants.CENTER);
		txtIReg2.setColumns(10);
		txtIReg2.setBounds(122, 0, 61, 30);
		panel.add(txtIReg2);

		txtIReg3 = new JTextField();
		txtIReg3.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtIReg3.setHorizontalAlignment(SwingConstants.CENTER);
		txtIReg3.setColumns(10);
		txtIReg3.setBounds(220, 0, 116, 30);
		panel.add(txtIReg3);

		JLabel label_9 = new JLabel(" -");
		label_9.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_9.setBounds(194, 8, 21, 15);
		panel.add(label_9);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(72, 534, 336, 30);
		getContentPane().add(panel_3);

		txtPTel1 = new JTextField();
		txtPTel1.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtPTel1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPTel1.setColumns(10);
		txtPTel1.setBounds(0, 0, 95, 30);
		panel_3.add(txtPTel1);

		JLabel label_13 = new JLabel("  -");
		label_13.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_13.setBounds(95, 8, 21, 15);
		panel_3.add(label_13);

		txtPTel2 = new JTextField();
		txtPTel2.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtPTel2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPTel2.setColumns(10);
		txtPTel2.setBounds(122, 0, 95, 30);
		panel_3.add(txtPTel2);

		txtPTel3 = new JTextField();
		txtPTel3.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtPTel3.setHorizontalAlignment(SwingConstants.CENTER);
		txtPTel3.setColumns(10);
		txtPTel3.setBounds(241, 0, 95, 30);
		panel_3.add(txtPTel3);

		JLabel label_14 = new JLabel(" -");
		label_14.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_14.setBounds(219, 8, 21, 15);
		panel_3.add(label_14);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(0, 337, 488, 54);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel = new JLabel("Company Stock Management & Sharing");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel.setBounds(64, 12, 359, 30);
		panel_4.add(lblNewLabel);
		setSize(492, 756);
		setLocation(ScreenSize.getCenterPosition(this));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}
}
