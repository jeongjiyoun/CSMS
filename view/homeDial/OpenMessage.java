package csms.view.homeDial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
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

import csms.util.RoundedButton;
import csms.vo.Inquiry;

public class OpenMessage extends JDialog {
	private static final long serialVersionUID = -2061053382835008564L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTitle;
	private JTextField textFrom;
	private JTextArea textArea;
	private Inquiry inq;
	private String userId;
	private RoundedButton okButton;
	private JTextField txtDate;
	private RoundedButton cancelButton;
	private JTextField fromla;

	// i가 1이면 보낸 메시지를 보는거고
	// i가 2이면 받은 메시지를 보는 것
	public OpenMessage(String userId, Inquiry inq, int i) {
		this.userId = userId;
		this.inq = inq;
		startFrame();
		setDefault(i);
		startActionListener();
	}

	private void setDefault(int i) {
		String ititle = inq.getiTitle();
		String icfrom = inq.getIcFrom();
		String icontents = inq.getIcontents();
		String idate = inq.getIdate();
		String ifromla;
		if (i == 1) {
			ifromla = "받는 사람";
		} else {
			ifromla = "보낸 사람";
		}

		fromla.setText(ifromla);
		txtTitle.setText(ititle);
		textFrom.setText(icfrom);
		textArea.setText(icontents);
		txtDate.setText(idate.substring(0, 11));
		statrtAction();
	}

	private void statrtAction() {
		txtDate.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textArea.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFrom.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		fromla.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPanel.setBackground(Color.WHITE);

		txtDate.setOpaque(false);
		fromla.setOpaque(false);
		textFrom.setOpaque(false);
		txtTitle.setOpaque(false);

		contentPanel.add(txtDate);
		contentPanel.add(fromla);
		contentPanel.add(textFrom);
		contentPanel.add(txtTitle);

		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.controlShadow);
		separator.setBounds(14, 72, 387, 2);
		contentPanel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.controlShadow);
		separator_1.setBounds(14, 104, 387, 2);
		contentPanel.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(SystemColor.controlShadow);
		separator_2.setBounds(26, 382, 387, 2);
		contentPanel.add(separator_2);

	}

	private void startActionListener() {
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String icTo = inq.getIcFrom();
				String title = inq.getiTitle();
				SendMessage a = new SendMessage(userId, icTo, title);
				a.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
				a.setVisible(true);
			}
		});

		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	private void startFrame() {

		setBounds(100, 100, 450, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		txtTitle = new JTextField();
		txtTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		txtTitle.setEditable(false);
		txtTitle.setBounds(108, 37, 298, 34);

		txtTitle.setColumns(10);
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.DARK_GRAY);
		buttonPane.setBounds(0, 414, 432, 47);
		contentPanel.add(buttonPane);
		buttonPane.setLayout(null);
		okButton = new RoundedButton("답 장");
		okButton.setText("보내기");
		okButton.setFont(new Font("굴림", Font.PLAIN, 15));
		okButton.setForeground(SystemColor.window);
		okButton.setBackground(SystemColor.textHighlight);
		okButton.setBounds(14, 12, 80, 27);
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		cancelButton = new RoundedButton("창 닫기");
		cancelButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		cancelButton.setBackground(Color.DARK_GRAY);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBounds(327, 10, 91, 27);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		textArea = new JTextArea();
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(26, 110, 380, 272);
		textArea.setLineWrap(true);
		contentPanel.add(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textFrom = new JTextField();
		textFrom.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		textFrom.setEditable(false);
		textFrom.setBounds(108, 72, 298, 34);

		textFrom.setColumns(10);

		fromla = new JTextField();
		fromla.setEditable(false);
		fromla.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		fromla.setBounds(24, 40, 78, 25);

		JLabel labeltitle = new JLabel("제 목");
		labeltitle.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		labeltitle.setBounds(24, 75, 78, 25);
		contentPanel.add(labeltitle);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 432, 28);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel laTop = new JLabel("쪽지");
		laTop.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		laTop.setBounds(14, 4, 112, 18);
		laTop.setForeground(Color.WHITE);
		panel.add(laTop);

		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBounds(304, 386, 109, 25);

		JLabel labeldate = new JLabel("발송 일시");
		labeldate.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		labeldate.setBounds(218, 384, 195, 25);
		contentPanel.add(labeldate);
	}
}
