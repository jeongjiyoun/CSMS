package csms.view.homeDial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import csms.util.RoundedButton;
import csms.vo.Company;

public class ShowComInfo extends JDialog {

	private static final long serialVersionUID = 2537279770018239150L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtRegi1;
	private JTextField txtRegi2;
	private JTextField txtRegi3;
	private JTextField txtTel2;
	private JTextField txtTel1;
	private JTextField txtTel3;
	private JTextField txtAdre;
	private JTextArea txtCom;
	private RoundedButton cancelButton;
	private Company user;

	public ShowComInfo(Company user) {
		this.user = user;
		startFrame();
		startContents();
		getDefault();
		startText();
		startActionListener();
	}

	private void startActionListener() {
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	private void startFrame() {
		setBounds(100, 100, 376, 436);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	}

	private void getDefault() {
		String regi[] = user.getCreginum().split("-", 3);
		String tel[] = user.getCtel().split("-", 3);
		txtName.setText(user.getCname());
		txtId.setText(user.getCid());
		txtRegi1.setText(regi[0]);
		txtRegi2.setText(regi[1]);
		txtRegi3.setText(regi[2]);
		txtTel1.setText(tel[0]);
		txtTel2.setText(tel[1]);
		txtTel3.setText(tel[2]);
		txtAdre.setText(user.getCaddress());
		txtCom.setText(user.getCcomment());
	}

	private void startText() {
		contentPanel.add(txtName);
		contentPanel.add(txtId);
		contentPanel.add(txtRegi1);
		contentPanel.add(txtRegi2);
		contentPanel.add(txtRegi3);
		contentPanel.add(txtTel1);
		contentPanel.add(txtTel2);
		contentPanel.add(txtTel3);
		contentPanel.add(txtAdre);
		contentPanel.add(txtCom);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBounds(14, 287, 329, 50);
		contentPanel.add(panel);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(17, 214, 327, 2);
		contentPanel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBounds(16, 170, 327, 2);
		contentPanel.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.DARK_GRAY);
		separator_2.setBounds(17, 132, 327, 2);
		contentPanel.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.DARK_GRAY);
		separator_3.setBounds(16, 93, 327, 2);
		contentPanel.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.DARK_GRAY);
		separator_4.setBounds(16, 251, 327, 2);
		contentPanel.add(separator_4);

	}

	private void startContents() {

		JLabel label = new JLabel("회사명");
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setBounds(17, 104, 42, 28);
		contentPanel.add(label);
		JLabel label_1 = new JLabel("아이디");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setBounds(17, 63, 42, 28);
		contentPanel.add(label_1);
		JLabel label_2 = new JLabel("사업자등록번호");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_2.setBounds(17, 144, 99, 28);
		contentPanel.add(label_2);
		JLabel label_3 = new JLabel(" -");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_3.setBounds(246, 151, 21, 15);
		contentPanel.add(label_3);
		JLabel label_4 = new JLabel("  -");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_4.setBounds(176, 151, 21, 15);
		contentPanel.add(label_4);
		JLabel label_5 = new JLabel("전화번호");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_5.setBounds(17, 184, 56, 28);
		contentPanel.add(label_5);
		JLabel label_6 = new JLabel(" -");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_6.setBounds(173, 191, 21, 15);
		contentPanel.add(label_6);
		JLabel label_7 = new JLabel(" -");
		label_7.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_7.setBounds(260, 191, 21, 15);
		contentPanel.add(label_7);
		JLabel label_8 = new JLabel("주소");
		label_8.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_8.setBounds(17, 225, 56, 28);
		contentPanel.add(label_8);
		JLabel label_9 = new JLabel("회사 소개글");
		label_9.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_9.setBounds(17, 262, 77, 28);
		contentPanel.add(label_9);
		JLabel lblNewLabel = new JLabel("회사 정보");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(127, 12, 99, 40);
		contentPanel.add(lblNewLabel);

		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setOpaque(false);
		txtName.setBorder(null);
		txtName.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtName.setColumns(10);
		txtName.setBounds(127, 104, 216, 30);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setOpaque(false);
		txtId.setBorder(null);
		txtId.setHorizontalAlignment(SwingConstants.LEFT);
		txtId.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtId.setColumns(10);
		txtId.setBounds(127, 64, 216, 28);

		txtRegi1 = new JTextField();
		txtRegi1.setEditable(false);
		txtRegi1.setOpaque(false);
		txtRegi1.setBorder(null);
		txtRegi1.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegi1.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtRegi1.setColumns(10);
		txtRegi1.setBounds(127, 145, 50, 25);

		txtRegi2 = new JTextField();
		txtRegi2.setOpaque(false);
		txtRegi2.setBorder(null);
		txtRegi2.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegi2.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtRegi2.setEditable(false);
		txtRegi2.setColumns(10);
		txtRegi2.setBounds(203, 145, 40, 25);

		txtRegi3 = new JTextField();
		txtRegi3.setOpaque(false);
		txtRegi3.setBorder(null);
		txtRegi3.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegi3.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtRegi3.setEditable(false);
		txtRegi3.setColumns(10);
		txtRegi3.setBounds(268, 145, 75, 25);

		txtTel1 = new JTextField();
		txtTel1.setEditable(false);
		txtTel1.setOpaque(false);
		txtTel1.setBorder(null);
		txtTel1.setHorizontalAlignment(SwingConstants.CENTER);
		txtTel1.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtTel1.setColumns(10);
		txtTel1.setBounds(108, 183, 60, 30);

		txtTel2 = new JTextField();
		txtTel2.setEditable(false);
		txtTel2.setOpaque(false);
		txtTel2.setBorder(null);
		txtTel2.setHorizontalAlignment(SwingConstants.CENTER);
		txtTel2.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtTel2.setColumns(10);
		txtTel2.setBounds(193, 183, 64, 30);

		txtTel3 = new JTextField();
		txtTel3.setEditable(false);
		txtTel3.setOpaque(false);
		txtTel3.setBorder(null);
		txtTel3.setHorizontalAlignment(SwingConstants.CENTER);
		txtTel3.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtTel3.setColumns(10);
		txtTel3.setBounds(279, 182, 64, 30);

		txtAdre = new JTextField();
		txtAdre.setEditable(false);
		txtAdre.setOpaque(false);
		txtAdre.setBorder(null);
		txtAdre.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtAdre.setColumns(10);
		txtAdre.setBounds(60, 225, 283, 30);

		txtCom = new JTextArea();
		txtCom.setEditable(false);
		txtCom.setLineWrap(true);
		txtCom.setBorder(null);
		txtCom.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtCom.setBounds(15, 288, 327, 48);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.DARK_GRAY);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		cancelButton = new RoundedButton(" 닫 기 ");
		cancelButton.setFont(new Font("굴림체", Font.PLAIN, 15));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}

}
