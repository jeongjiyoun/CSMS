package csms.view.homeDial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import csms.manager.PopupManager;
import csms.manager.StringMaker;
import csms.service.CompanyService;
import csms.util.RoundedButton;

public class ChangePw extends JDialog {
	private static final long serialVersionUID = 9149360865309847005L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private RoundedButton button;
	private String cid;
	private CompanyService cs = new CompanyService();
	private PopupManager pm = new PopupManager();
	private StringMaker sm = new StringMaker();

	public ChangePw(String cid) {
		this.cid = cid;
		startFrame();
		startButtonEvents();
	}

	private void startButtonEvents() {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cpw = sm.MakePw(passwordField.getPassword());
				String cpw2 = sm.MakePw(passwordField_1.getPassword());

				if (cpw.equals(cpw2)) {
					cs.updatePass(cid, cpw);
					pm.sucChanPw();
					dispose();
				} else { // 비밀번호 입력값이 서로 다르다.
					pm.pwNotEqual();
					passwordField_1.setText("");
					passwordField.setText("");
				}
			}
		});

	}

	private void startFrame() {
		setTitle("안 내");
		setBounds(100, 100, 445, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.DARK_GRAY);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("고객님의 비밀번호를 새롭게 설정해주세요.");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
			lblNewLabel.setBounds(20, 0, 386, 64);
			contentPanel.add(lblNewLabel);
		}

		passwordField = new JPasswordField();
		passwordField.setBounds(172, 65, 214, 36);
		contentPanel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(172, 113, 214, 36);
		contentPanel.add(passwordField_1);

		JLabel lblNewLabel_1 = new JLabel("새로운 비밀번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("굴림체", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 65, 114, 36);
		contentPanel.add(lblNewLabel_1);

		JLabel label = new JLabel("비밀번호 확인");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("굴림체", Font.PLAIN, 15));
		label.setBounds(31, 113, 114, 36);
		contentPanel.add(label);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(0, 172, 427, 39);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			button = new RoundedButton("적 용");
			button.setBounds(171, 6, 85, 27);
			panel.add(button);
			button.setActionCommand("Cancel");
		}
	}
}
