package csms.view.homeDial;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.border.EmptyBorder;

import csms.manager.PopupManager;
import csms.service.CompanyService;
import csms.service.InquiryService;
import csms.util.RoundedButton;
import csms.vo.Inquiry;

public class SendMessage extends JDialog {

	private static final long serialVersionUID = 2628226376158229759L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTo;
	private JTextField textTitle;
	private JTextArea textArea;
	private Inquiry inq;
	private String userId;
	private RoundedButton okButton;
	private RoundedButton cancelButton;
	private String titleDefault;
	private String icTo;

	private CompanyService cs = new CompanyService();
	private PopupManager pm = new PopupManager();
	private InquiryService is = new InquiryService();

	/**
	 * @wbp.parser.constructor
	 */
	public SendMessage(String userId) {
		setTitle("쪽지 발송");
		this.userId = userId;
		startFrame();
		startActionListener();
		stratAdd();
	}

	public SendMessage(String userId, String icTo, String title) {
		this.userId = userId;
		this.icTo = icTo;
		titleDefault = "[re]" + title;
		startFrame();
		startActionListener();
		setDefault();

	}

	private void startActionListener() {
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String title = textTitle.getText();
				String toCom = txtTo.getText();
				String contents = textArea.getText();
				if (title.length() < 1 || toCom.length() < 1 || !cs.idCheck(toCom)) {
					pm.failSub();
				} else {
					inq = new Inquiry(userId, toCom, title, contents, "");
					is.insertInquiry(inq);
					dispose();
					pm.sucSub();
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	private void setDefault() {
		textTitle.setText(titleDefault);
		txtTo.setText(icTo);
		txtTo.setEditable(false);
		stratAdd();
	}

	private void stratAdd() {
		textTitle.setBorder(null);
		textArea.setBorder(null);
		txtTo.setBorder(null);
		contentPanel.setBackground(Color.WHITE);

		textArea.setOpaque(false);
		txtTo.setOpaque(false);
		textTitle.setOpaque(false);

		contentPanel.add(textTitle);
		contentPanel.add(txtTo);

		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.controlShadow);
		separator.setBounds(24, 76, 387, 2);
		contentPanel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.controlShadow);
		separator_1.setBounds(24, 113, 387, 2);
		contentPanel.add(separator_1);
	}

	private void startFrame() {

		setBounds(100, 100, 450, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		txtTo = new JTextField();
		txtTo.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtTo.setBounds(108, 39, 298, 34);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.DARK_GRAY);
		buttonPane.setBounds(0, 414, 432, 47);
		contentPanel.add(buttonPane);
		buttonPane.setLayout(null);

		okButton = new RoundedButton("보내기");
		okButton.setFont(new Font("굴림", Font.PLAIN, 15));
		okButton.setForeground(new Color(255, 255, 255));
		okButton.setBackground(SystemColor.textHighlight);
		okButton.setBounds(14, 12, 80, 27);
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		cancelButton = new RoundedButton("창 닫기");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.DARK_GRAY);
		cancelButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		cancelButton.setBounds(327, 9, 91, 27);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		textArea = new JTextArea();
		textArea.setBounds(26, 125, 380, 263);
		contentPanel.add(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 18));

		textTitle = new JTextField();
		textTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		textTitle.setBounds(108, 79, 298, 34);

		JLabel lbcTo = new JLabel("받는사람");
		lbcTo.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lbcTo.setBounds(24, 44, 78, 25);
		contentPanel.add(lbcTo);

		JLabel lbTitle = new JLabel("제 목");
		lbTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lbTitle.setBounds(24, 81, 78, 25);
		contentPanel.add(lbTitle);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 432, 28);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lbNew = new JLabel("새 쪽지");
		lbNew.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbNew.setBounds(14, 4, 112, 18);
		lbNew.setForeground(Color.WHITE);
		panel.add(lbNew);
	}
}
