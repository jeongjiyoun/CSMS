package csms.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import csms.manager.PopupManager;
import csms.manager.StringMaker;
import csms.service.CategoryService;
import csms.service.CompanyService;
import csms.util.RoundedButton;
import csms.util.ScreenSize;
import csms.vo.Company;

public class JoinView extends JFrame {
	private static final long serialVersionUID = 576097424579258157L;
	private JTextField txtId;
	private JPasswordField pw1;
	private JPasswordField pw2;
	private JTextField txtName;
	private JTextField txtReg1;
	private JTextField txtReg2;
	private JTextField txtReg3;
	private JTextField txtAddress;
	private JTextField txtComment;
	private JTextField txtTel1;
	private JTextField txtTel2;
	private JTextField txtTel3;
	private RoundedButton btnJoin;
	private JComboBox<String> cLcate;
	private JComboBox<String> cScate;
	private boolean dataAdj = false;
	private JTextPane txtIdAl = new JTextPane();
	private JTextPane txtPwA = new JTextPane();
	private JTextPane txtpnQ = new JTextPane();
	private JTextPane txtRegiA = new JTextPane();
	private JTextPane txtAddA = new JTextPane();

	private CompanyService cs = new CompanyService();
	private CategoryService gs = new CategoryService();
	private StringMaker sm = new StringMaker();
	private PopupManager pm = new PopupManager();

	public JoinView() {
		startFrameSetting();
		startButtonEvents();
	}

	private void startButtonEvents() {

		txtId.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				String id = txtId.getText();
				if (id.length() < 5 || id.length() >= 20) {
					JTextPane textPane = new JTextPane();
					textPane.setFont(new Font("나눔고딕", Font.PLAIN, 10));
					textPane.setEditable(false);
					textPane.setForeground(new Color(220, 20, 60));
					textPane.setText("아이디는 5자 이상, 20자 미만으로 작성해주세요");
					textPane.setBackground(new Color(255, 255, 255));
					textPane.setBounds(186, 102, 222, 23);
					getContentPane().add(textPane);
					dataAdj = false;

					// 아이디에는 공백 또는 한글이 들어가서는 안됨
				} else if (id.contains(" ") || !id.matches("(^[a-zA-Z0-9]*$)")) {
					txtIdAl.setFont(new Font("나눔고딕", Font.PLAIN, 10));
					txtIdAl.setEditable(false);
					txtIdAl.setForeground(new Color(220, 20, 60));
					txtIdAl.setText("아이디는 영문대소문자, 숫자로 입력해주세요.");
					txtIdAl.setBackground(new Color(255, 255, 255));
					txtIdAl.setBounds(186, 102, 222, 23);
					getContentPane().add(txtIdAl);
					dataAdj = false;
				} else { // 입력에는 문제가 없음

					if (cs.idCheck(id)) { // 아이디가 중복일 경우,
						txtIdAl.setFont(new Font("나눔고딕", Font.PLAIN, 10));
						txtIdAl.setEditable(false);
						txtIdAl.setForeground(new Color(220, 20, 60));
						txtIdAl.setText("이미 사용중인 아이디입니다.");
						txtIdAl.setBackground(new Color(255, 255, 255));
						txtIdAl.setBounds(186, 102, 222, 23);
						getContentPane().add(txtIdAl);

						dataAdj = false;
					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtIdAl.setForeground(new Color(220, 20, 60));
				txtIdAl.setText("");
				txtIdAl.setBackground(new Color(255, 255, 255));
				txtIdAl.setBounds(186, 102, 222, 23);
				getContentPane().add(txtIdAl);
			}
		});

		pw1.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				String pw = sm.MakePw(pw1.getPassword());
				if (!pw.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$")) {
					txtPwA.setFont(new Font("나눔고딕", Font.PLAIN, 10));
					txtPwA.setText("8~16자 영문자, 숫자, 특수문자를 혼합하세요.");
					txtPwA.setForeground(new Color(220, 20, 60));
					txtPwA.setEditable(false);
					txtPwA.setBackground(new Color(255, 255, 255));
					txtPwA.setBounds(179, 164, 229, 23);
					getContentPane().add(txtPwA);
					dataAdj = false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtPwA.setText(" ");
				txtPwA.setBackground(new Color(255, 255, 255));
				txtPwA.setBounds(179, 164, 229, 23);
				getContentPane().add(txtPwA);
				dataAdj = true;
			}
		});

		pw2.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				String pass1 = sm.MakePw(pw1.getPassword());
				String pass2 = sm.MakePw(pw2.getPassword());

				if (!pass1.equals(pass2)) {
					txtpnQ.setText("비밀번호가 일치하지 않습니다.");
					txtpnQ.setForeground(new Color(220, 20, 60));
					txtpnQ.setFont(new Font("나눔고딕", Font.PLAIN, 10));
					txtpnQ.setEditable(false);
					txtpnQ.setBackground(new Color(255, 255, 255));
					txtpnQ.setBounds(263, 223, 145, 23);
					getContentPane().add(txtpnQ);
					dataAdj = false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				dataAdj = true;
				txtpnQ.setText(" ");
				txtpnQ.setBackground(new Color(255, 255, 255));
				txtpnQ.setBounds(263, 223, 145, 23);
				getContentPane().add(txtpnQ);
			}
		});

		txtReg3.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				String reignum = sm.makeRegi(txtReg1.getText(), txtReg2.getText(), txtReg3.getText());
				if (!txtReg1.getText().matches("(0)|\\d{3,3}") || !txtReg2.getText().matches("(0)|\\d{2,2}")
						|| !txtReg3.getText().matches("((0)|\\d{5,5})")) {
					txtRegiA.setText("사업자등록 번호를 확인해주세요");
					txtRegiA.setForeground(new Color(220, 20, 60));
					txtRegiA.setFont(new Font("나눔고딕", Font.PLAIN, 10));
					txtRegiA.setEditable(false);
					txtRegiA.setBackground(new Color(255, 255, 255));
					txtRegiA.setBounds(253, 352, 155, 23);
					getContentPane().add(txtRegiA);
					dataAdj = false;
				} else if (cs.regiNumCheck(reignum)) {
					txtRegiA.setText("이미 등록된 회원입니다");
					txtRegiA.setForeground(new Color(220, 20, 60));
					txtRegiA.setFont(new Font("나눔고딕", Font.PLAIN, 10));
					txtRegiA.setEditable(false);
					txtRegiA.setBackground(new Color(255, 255, 255));
					txtRegiA.setBounds(293, 352, 121, 23);
					getContentPane().add(txtRegiA);
					dataAdj = false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				dataAdj = true;
				txtRegiA.setText("");
				txtRegiA.setBackground(new Color(255, 255, 255));
				txtRegiA.setBounds(287, 352, 121, 23);
				getContentPane().add(txtRegiA);
			}
		});

		txtTel3.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// 일단 글자수 2자이상-3자이상-4자이상
				// 숫자로만 입력되도록
				if (!txtTel1.getText().matches("(0)|\\d{2,3}") || !txtTel2.getText().matches("(0)|\\d{3,4}")
						|| !txtTel3.getText().matches("(0)|\\d{4,4}")) {
					JTextPane textPane_3 = new JTextPane();
					textPane_3.setText("형식에 맞지 않는 번호입니다.");
					textPane_3.setForeground(new Color(220, 20, 60));
					textPane_3.setFont(new Font("나눔고딕", Font.PLAIN, 10));
					textPane_3.setEditable(false);
					textPane_3.setBackground(new Color(255, 255, 255));
					textPane_3.setBounds(270, 417, 138, 23);
					getContentPane().add(textPane_3);
					dataAdj = false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				JTextPane textPane_3 = new JTextPane();
				textPane_3.setText(" ");
				textPane_3.setForeground(new Color(220, 20, 60));
				textPane_3.setFont(new Font("나눔고딕", Font.PLAIN, 10));
				textPane_3.setEditable(false);
				textPane_3.setBackground(new Color(255, 255, 255));
				textPane_3.setBounds(270, 417, 138, 23);
				getContentPane().add(textPane_3);
				dataAdj = true;
			}
		});

		txtAddress.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				String txt1 = txtAddress.getText();
				if (txt1.length() < 10) {
					// 주소 마스크는 너무 짧게 쓴 경우를 거른다.
					txtAddA.setText("주소를 제대로 입력하세요");
					txtAddA.setForeground(new Color(220, 20, 60));
					txtAddA.setFont(new Font("나눔고딕", Font.PLAIN, 10));
					txtAddA.setEditable(false);
					txtAddA.setBackground(new Color(255, 255, 255));
					txtAddA.setBounds(277, 481, 131, 23);
					getContentPane().add(txtAddA);
					dataAdj = false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				dataAdj = true;
				txtAddA.setText(" ");
				txtAddA.setBackground(new Color(255, 255, 255));
				txtAddA.setBounds(277, 481, 131, 23);
				getContentPane().add(txtAddA);
			}
		});

		cLcate.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				List<String> list = gs.getSCateInfo((String) cLcate.getSelectedItem());
				String[] sCate = new String[list.size()];
				for (int i = 0; i < list.size(); i++) {
					sCate[i] = list.get(i);
				}
				cScate.setModel(new DefaultComboBoxModel<String>(sCate));
			}

			@Override
			public void focusGained(FocusEvent e) {
				List<String> listL = gs.getLCateInfo();
				String[] lCate = new String[listL.size()];
				for (int i = 0; i < listL.size(); i++) {
					lCate[i] = listL.get(i);
				}
				cLcate.setModel(new DefaultComboBoxModel<String>(lCate));
				dataAdj = true;
			}
		});

		btnJoin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (dataAdj) {

					String cid = txtId.getText();
					String cpw = sm.MakePw(pw1.getPassword());
					String cname = txtName.getText();
					String ctel = sm.makeTel(txtTel1.getText(), txtTel2.getText(), txtReg3.getText());
					String creginum = sm.makeRegi(txtReg1.getText(), txtReg2.getText(), txtReg3.getText());
					String caddress = txtAddress.getText();
					String ccomment = txtComment.getText();
					String cScateName = (String) cScate.getSelectedItem();
					int ctype = gs.getCtype(cScateName);
					Company company = new Company(cid, cpw, creginum, ctel, cname, caddress, ccomment, ctype);
					cs.insertUser(company);

					pm.sucJoin();
					dispose();
				}
			}

		});

	}

	private void startFrameSetting() {

		setTitle("재고 관리 시스템");
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel label = new JLabel("회원가입");
		label.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 25));
		label.setBounds(194, 23, 102, 31);
		getContentPane().add(label);

		btnJoin = new RoundedButton("가입하기");
		btnJoin.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnJoin.setBounds(128, 663, 199, 41);
		getContentPane().add(btnJoin);

		JLabel label_1 = new JLabel("아이디");
		label_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_1.setBounds(72, 42, 42, 28);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("비밀번호");
		label_2.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_2.setBounds(72, 102, 56, 28);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("비밀번호 재확인");
		label_3.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_3.setBounds(72, 162, 114, 28);
		getContentPane().add(label_3);

		txtId = new JTextField();
		txtId.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtId.setColumns(10);
		txtId.setBounds(72, 70, 336, 30);
		getContentPane().add(txtId);

		pw1 = new JPasswordField();
		pw1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pw1.setBounds(72, 130, 336, 30);
		getContentPane().add(pw1);

		pw2 = new JPasswordField();
		pw2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pw2.setBounds(72, 190, 336, 30);
		getContentPane().add(pw2);

		txtName = new JTextField();
		txtName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBounds(72, 258, 336, 30);
		getContentPane().add(txtName);

		JLabel label_4 = new JLabel("회사명");
		label_4.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_4.setBounds(72, 230, 42, 28);
		getContentPane().add(label_4);

		JLabel label_5 = new JLabel("사업자 등록번호");
		label_5.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_5.setBounds(72, 290, 116, 28);
		getContentPane().add(label_5);

		txtReg1 = new JTextField();
		txtReg1.setHorizontalAlignment(SwingConstants.CENTER);
		txtReg1.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtReg1.setColumns(10);
		txtReg1.setBounds(72, 320, 90, 30);
		getContentPane().add(txtReg1);

		txtReg2 = new JTextField();
		txtReg2.setHorizontalAlignment(SwingConstants.CENTER);
		txtReg2.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtReg2.setColumns(10);
		txtReg2.setBounds(194, 320, 56, 30);
		getContentPane().add(txtReg2);

		txtReg3 = new JTextField();
		txtReg3.setHorizontalAlignment(SwingConstants.CENTER);
		txtReg3.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtReg3.setColumns(10);
		txtReg3.setBounds(277, 320, 131, 30);
		getContentPane().add(txtReg3);

		JLabel label_6 = new JLabel("  -");
		label_6.setFont(new Font("나눔고딕", Font.PLAIN, 19));
		label_6.setBounds(167, 327, 30, 15);
		getContentPane().add(label_6);

		JLabel label_7 = new JLabel(" -");
		label_7.setFont(new Font("나눔고딕", Font.PLAIN, 19));
		label_7.setBounds(255, 327, 21, 15);
		getContentPane().add(label_7);

		JLabel label_8 = new JLabel("주소");
		label_8.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_8.setBounds(72, 421, 56, 28);
		getContentPane().add(label_8);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBounds(72, 449, 336, 30);
		getContentPane().add(txtAddress);

		JLabel label_9 = new JLabel("업종");
		label_9.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_9.setBounds(72, 489, 56, 28);
		getContentPane().add(label_9);

		cLcate = new JComboBox<String>();
		cLcate.setModel(new DefaultComboBoxModel<String>(new String[] { "대분류" }));
		cLcate.setBounds(72, 516, 163, 31);
		getContentPane().add(cLcate);

		cScate = new JComboBox<String>();
		cScate.setBounds(245, 516, 163, 31);
		getContentPane().add(cScate);

		JLabel label_10 = new JLabel("회사 소개글");
		label_10.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_10.setBounds(72, 557, 77, 28);
		getContentPane().add(label_10);

		txtComment = new JTextField();
		txtComment.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtComment.setColumns(10);
		txtComment.setBounds(72, 585, 336, 48);
		getContentPane().add(txtComment);

		JLabel label_11 = new JLabel("전화번호");
		label_11.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_11.setBounds(72, 360, 56, 28);
		getContentPane().add(label_11);

		txtTel1 = new JTextField();
		txtTel1.setHorizontalAlignment(SwingConstants.CENTER);
		txtTel1.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtTel1.setColumns(10);
		txtTel1.setBounds(72, 384, 90, 30);
		getContentPane().add(txtTel1);

		JLabel label_12 = new JLabel("  -");
		label_12.setFont(new Font("나눔고딕", Font.PLAIN, 19));
		label_12.setBounds(167, 392, 21, 15);
		getContentPane().add(label_12);

		txtTel2 = new JTextField();
		txtTel2.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtTel2.setHorizontalAlignment(SwingConstants.CENTER);
		txtTel2.setColumns(10);
		txtTel2.setBounds(194, 384, 95, 30);
		getContentPane().add(txtTel2);

		JLabel label_13 = new JLabel(" -");
		label_13.setFont(new Font("나눔고딕", Font.PLAIN, 19));
		label_13.setBounds(291, 392, 21, 15);
		getContentPane().add(label_13);

		txtTel3 = new JTextField();
		txtTel3.setHorizontalAlignment(SwingConstants.CENTER);
		txtTel3.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtTel3.setColumns(10);
		txtTel3.setBounds(313, 384, 95, 30);
		getContentPane().add(txtTel3);
		cScate.setModel(new DefaultComboBoxModel<String>(new String[] { "소분류" }));
		setSize(494, 754);
		setLocation(ScreenSize.getCenterPosition(this));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocation(ScreenSize.getCenterPosition(this));
	}
}
