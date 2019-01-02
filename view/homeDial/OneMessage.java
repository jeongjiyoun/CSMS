package csms.view.homeDial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import csms.util.RoundedButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class OneMessage extends JDialog {
	private static final long serialVersionUID = -4885718937922050935L;
	private final JPanel contentPanel = new JPanel();
	private RoundedButton cancelButton;
	private JTextField textField;

	public OneMessage(String message) {
		startFrameSetting();
		addtext(message);
		startActionListener();
	}

	private void startFrameSetting() {
		setTitle("안 내");
		setBounds(100, 100, 416, 178);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.DARK_GRAY);
		buttonPane.setBounds(-17, 96, 432, 37);
		contentPanel.add(buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		cancelButton = new RoundedButton("  닫 기  ");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		textField.setBounds(0, 25, 398, 44);
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setColumns(10);
	}

	public void addtext(String message) {
		textField.setText(message);
		contentPanel.add(textField);
	}

	public void startActionListener() {
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
}
