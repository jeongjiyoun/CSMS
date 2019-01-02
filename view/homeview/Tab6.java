package csms.view.homeview;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import csms.manager.PopupManager;
import csms.manager.StringMaker;
import csms.service.CompanyService;
import csms.util.RoundedButton;
import csms.view.HomeView;
import csms.vo.Company;

public class Tab6 extends JPanel {

	private static final long serialVersionUID = -5244853905588282496L;
	@SuppressWarnings("unused")
	private HomeView window;
	private JTextField txtId;
	private JPasswordField passwordField;
	private JTextField txtName;
	private JTextField txtAddre;
	private JTextField txtRegi1;
	private JTextField txtRegi2;
	private JTextField txtRegi3;
	private JTextField txtTel1;
	private JTextField txtTel2;
	private JTextField txtTel3;
	private JTextArea textArea;
	private RoundedButton button;
	private Company user;
	private CompanyService cs = new CompanyService();
	private PopupManager pm = new PopupManager();
	private StringMaker sm = new StringMaker();

	public Tab6(HomeView homeview, String cid) {
		setBackground(SystemColor.text);
		this.window = homeview;
		user = cs.getCompanyInfo(cid);
		startFrameConstruct();
		startDefaultSetting(user);
		startActionListener();
	}

	private void startDefaultSetting(Company user) {
		String id = user.getCid();
		String userName = user.getCname();
		String[] Regi = user.getCreginum().split("-", 3);
		String[] tel = user.getCtel().split("-", 3);
		String address = user.getCaddress();
		String comment = user.getCcomment();
		textDefault(id, userName, Regi, tel, address, comment);
	}

	private void startFrameConstruct() {

		JLabel label = new JLabel("회사명");
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setBounds(14, 153, 42, 28);
		add(label);

		JLabel label_1 = new JLabel("비밀번호");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setBounds(14, 115, 56, 28);
		add(label_1);

		JLabel label_2 = new JLabel("아이디");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_2.setBounds(14, 77, 42, 28);
		add(label_2);

		JLabel label_3 = new JLabel("내 정보");
		label_3.setFont(new Font("굴림", Font.PLAIN, 13));
		label_3.setBounds(14, 12, 330, 28);
		add(label_3);

		JLabel label_4 = new JLabel("회사 정보를 조회하고 수정할 수 있습니다");
		label_4.setFont(new Font("굴림", Font.PLAIN, 13));
		label_4.setBounds(14, 38, 330, 28);
		add(label_4);

		JSeparator separator = new JSeparator();
		separator.setBounds(14, 38, 330, 2);
		add(separator);
		JLabel label_11 = new JLabel("주소");
		label_11.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_11.setBounds(14, 274, 56, 28);
		add(label_11);
		JLabel label_12 = new JLabel("회사 소개글");
		label_12.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_12.setBounds(14, 311, 77, 28);
		add(label_12);
		JLabel label_5 = new JLabel("사업자등록번호");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_5.setBounds(14, 193, 99, 28);
		add(label_5);

		JLabel label_6 = new JLabel("  -");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_6.setBounds(173, 200, 21, 15);
		add(label_6);

		JLabel label_7 = new JLabel(" -");
		label_7.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_7.setBounds(243, 200, 21, 15);
		add(label_7);

		JLabel label_9 = new JLabel(" -");
		label_9.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_9.setBounds(170, 240, 21, 15);
		add(label_9);

		JLabel label_10 = new JLabel(" -");
		label_10.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_10.setBounds(257, 240, 21, 15);
		add(label_10);

		JLabel label_8 = new JLabel("전화번호");
		label_8.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_8.setBounds(14, 233, 56, 28);
		add(label_8);

		txtId = new JTextField();
		txtId.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtId.setHorizontalAlignment(SwingConstants.LEFT);
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBorder(new LineBorder(Color.gray));
		txtId.setBounds(124, 78, 216, 28);
		txtId.setOpaque(false);
		add(txtId);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		passwordField.setBounds(124, 116, 216, 28);
		passwordField.setOpaque(false);
		add(passwordField);

		txtName = new JTextField();
		txtName.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(Color.gray));
		txtName.setBounds(124, 153, 216, 30);
		txtName.setOpaque(false);
		add(txtName);

		txtAddre = new JTextField();
		txtAddre.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtAddre.setColumns(10);
		txtAddre.setBounds(57, 274, 283, 30);
		txtAddre.setOpaque(false);
		add(txtAddre);

		txtRegi1 = new JTextField();
		txtRegi1.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegi1.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtRegi1.setEditable(false);
		txtRegi1.setBorder(new LineBorder(Color.gray));
		txtRegi1.setColumns(10);
		txtRegi1.setOpaque(false);
		txtRegi1.setBounds(124, 195, 50, 25);
		add(txtRegi1);

		txtRegi2 = new JTextField();
		txtRegi2.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegi2.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtRegi2.setEditable(false);
		txtRegi2.setBorder(new LineBorder(Color.gray));
		txtRegi2.setColumns(10);
		txtRegi2.setBounds(200, 196, 40, 25);
		txtRegi2.setOpaque(false);
		add(txtRegi2);

		txtRegi3 = new JTextField();
		txtRegi3.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegi3.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtRegi3.setEditable(false);
		txtRegi3.setBorder(new LineBorder(Color.gray));
		txtRegi3.setColumns(10);
		txtRegi3.setBounds(265, 196, 75, 25);
		txtRegi3.setOpaque(false);
		add(txtRegi3);

		button = new RoundedButton("정보 수정");
		button.setFont(new Font("굴림체", Font.PLAIN, 15));
		button.setBounds(253, 398, 97, 23);
		add(button);

		txtTel1 = new JTextField();
		txtTel1.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtTel1.setHorizontalAlignment(SwingConstants.CENTER);
		txtTel1.setColumns(10);
		txtTel1.setBounds(105, 232, 60, 30);
		add(txtTel1);

		txtTel2 = new JTextField();
		txtTel2.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtTel2.setHorizontalAlignment(SwingConstants.CENTER);
		txtTel2.setColumns(10);
		txtTel2.setBounds(190, 232, 64, 30);
		add(txtTel2);
		txtTel3 = new JTextField();
		txtTel3.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtTel3.setHorizontalAlignment(SwingConstants.CENTER);
		txtTel3.setColumns(10);
		txtTel3.setBounds(276, 231, 64, 30);
		add(txtTel3);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textArea.setBounds(26, 338, 327, 48);
		add(textArea);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBounds(25, 337, 329, 50);
		add(panel);
	}

	private void textDefault(String id, String userName, String[] regi, String[] tel, String address, String comment) {

		txtId.setText(id);
		txtName.setText(userName);
		txtAddre.setText(address);
		if (comment != null) {
			textArea.setText(comment);
		}
		txtRegi1.setText(regi[0]);
		txtRegi2.setText(regi[1]);
		txtRegi3.setText(regi[2]);
		txtTel1.setText(tel[0]);
		txtTel2.setText(tel[1]);
		txtTel3.setText(tel[2]);

	}

	private void startActionListener() {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isok = false;
				String pw = new String(passwordField.getPassword());
				// password 셋팅
				if (pw.length() < 1) {
					// 여기에 걸릴 경우 - 비밀번호를 바꾸지 않은 경우
					// 따라서 넘어갑니다.
				} else if (pw.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$")) {
					// 비밀번호 생성자 규칙에 따를 경우 바꿔줍니다.
					cs.updatePass(user.getCid(), pw);
					isok = true;
				} else {
					// 비밀번호를 바꾸려고 입력하였으나 생성자 규칙에 적합하지 않은 경우
					pm.showPwRule();
				}
				if (txtAddre.getText().length() < 6) {
					pm.showAddrRule();
				} else if (!txtTel1.getText().matches("(0)|\\d{2,3}") || !txtTel2.getText().matches("(0)|\\d{3,4}")
						|| !txtTel3.getText().matches("(0)|\\d{4,4}")) {
					pm.showTelRule();
				} else if (textArea.getText().length() > 100) {
					pm.showComRule();
				} else {
					user.setCaddress(txtAddre.getText());
					String tel = sm.makeTel(txtTel1.getText(), txtTel2.getText(), txtTel3.getText());
					user.setCtel(tel);
					user.setCcomment(textArea.getText());
					cs.updateInfo(user);
					pm.sucUpdate();
					isok = false;
				}
				if (isok) { // 다른 정보는 바꾸지 않고 비밀번호만 바꾼 경우
					pm.sucUpdate();
				}
			}
		});
	}
}
