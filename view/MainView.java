package csms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import csms.manager.StringMaker;
import csms.service.CompanyService;
import csms.util.RoundedButton;
import csms.util.ScreenSize;

public class MainView extends JFrame {

	private static final long serialVersionUID = 7475122104112372165L;
	private JTextPane txtpnIctShop;
	private JTextField txtID;
	private JPasswordField txtPW;
	private RoundedButton btnLogin;
	private RoundedButton btnFindIdPw;
	private RoundedButton btnJoin;
	private RoundedButton btnExit;
	private JSeparator separator_1;

	private CompanyService cs = new CompanyService();
	private StringMaker sm = new StringMaker();

	public MainView() {
		startFrameSetting();
		middleContents();
		bottomContents();
		startimage();
		startButtonEvents();
	}

	// 버튼 이벤트
	private void startButtonEvents() {
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = "";

				String cid = txtID.getText();
				String cpw = sm.MakePw(txtPW.getPassword());

				if (!cs.idCheck(cid)) {
					msg += "아이디를 다시 확인해주세요.";
					showCheckResult(msg);
					return;
				}

				if (cs.passCheck(cid, cpw)) {
					HomeView home = new HomeView(cid);
					home.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
					dispose();
					home.setVisible(true);
				} else {
					msg += "비밀번호를 다시 확인해주세요.";
					showCheckResult(msg);
					return;
				}
			}
		});

		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnJoin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new JoinView().setVisible(true);
			}

		});

		btnFindIdPw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FindIdPwView().setVisible(true);
			}
		});
	}

	// 프레임
	private void startFrameSetting() {
		setBackground(new Color(245, 245, 245));
		getContentPane().setBackground(SystemColor.text);
		setTitle("재고 관리 시스템");
		getContentPane().setLayout(null);
		setSize(497, 474);
		setLocation(ScreenSize.getCenterPosition(this));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	private void showCheckResult(String msg) {
		JTextPane txtResult = new JTextPane();
		txtResult.setForeground(new Color(190, 34, 34));
		txtResult.setBackground(new Color(255, 250, 250));
		txtResult.setEditable(false);
		txtResult.setBounds(186, 278, 235, 23);
		txtResult.setText(msg);
		getContentPane().add(txtResult);
	}

	private void startimage() {

		JPanel imagePannel = new JPanel();
		imagePannel.setBounds(37, 46, 417, 109);
		getContentPane().add(imagePannel);

		imagePannel.setLayout(new BorderLayout());
		JButton button = new JButton("banner", new ImageIcon(MainView.class.getResource("/source/Main.png")));
		imagePannel.add("Center", button);
	}

	// 프레임에 내 버튼
	private void middleContents() {
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(127, 207, 52, 23);
		getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(113, 246, 57, 15);
		getContentPane().add(lblNewLabel_1);

		txtID = new JTextField();
		txtID.setBackground(Color.WHITE);
		txtID.setBounds(186, 200, 149, 29);
		getContentPane().add(txtID);
		txtID.setColumns(10);

		txtPW = new JPasswordField();
		txtPW.setBackground(Color.WHITE);
		txtPW.setColumns(10);
		txtPW.setBounds(186, 239, 149, 29);
		getContentPane().add(txtPW);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(245, 245, 245));
		separator.setBounds(89, 170, 325, 2);
		getContentPane().add(separator);

		btnLogin = new RoundedButton("로그인");
		btnLogin.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnLogin.setBackground(new Color(245, 245, 245));
		btnLogin.setBounds(347, 207, 83, 50);
		getContentPane().add(btnLogin);

		btnFindIdPw = new RoundedButton("아이디/비밀번호 찾기");
		btnFindIdPw.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnFindIdPw.setBackground(new Color(245, 245, 245));
		btnFindIdPw.setBounds(245, 301, 169, 29);
		getContentPane().add(btnFindIdPw);

		btnJoin = new RoundedButton("회원 가입");
		btnJoin.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnJoin.setBackground(new Color(245, 245, 245));
		btnJoin.setBounds(245, 342, 169, 29);
		getContentPane().add(btnJoin);
	}

	private void bottomContents() {
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBounds(0, 404, 491, 3);
		getContentPane().add(separator_1);

		txtpnIctShop = new JTextPane();
		txtpnIctShop.setForeground(Color.WHITE);
		txtpnIctShop.setEditable(false);
		txtpnIctShop.setFont(new Font("굴림체", Font.PLAIN, 13));
		txtpnIctShop.setBackground(Color.DARK_GRAY);
		txtpnIctShop.setText("재고 관리 시스템");
		txtpnIctShop.setBounds(10, 410, 111, 23);
		getContentPane().add(txtpnIctShop);

		JPanel bottomPannel = new JPanel();
		bottomPannel.setBackground(Color.DARK_GRAY);
		bottomPannel.setBounds(0, 404, 491, 42);
		getContentPane().add(bottomPannel);
		bottomPannel.setLayout(null);

		btnExit = new RoundedButton("E X I T");
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setForeground(Color.WHITE);
		btnExit.setBounds(390, 4, 87, 31);
		bottomPannel.add(btnExit);

	}
}
