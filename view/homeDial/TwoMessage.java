package csms.view.homeDial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import csms.util.RoundedButton;

public class TwoMessage extends JDialog {
	private static final long serialVersionUID = 9149360865309847005L;
	private final JPanel contentPanel = new JPanel();
	private RoundedButton cancelButton;
	private JPanel buttonPane;
	private JTextField firstField = new JTextField();
	private JTextField secondField = new JTextField();

	public TwoMessage(String first, String second) {
		startContent();
		startSettingDefatult(first, second);
		startActionListener();
	}

	private void startContent() {
		setTitle("안 내");
		setBounds(100, 100, 446, 204);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		firstField.setHorizontalAlignment(SwingConstants.CENTER);
		firstField.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		firstField.setBounds(21, 24, 386, 37);
		firstField.setEditable(false);
		firstField.setOpaque(false);
		firstField.setBorder(null);

		buttonPane = new JPanel();
		buttonPane.setBackground(Color.DARK_GRAY);
		buttonPane.setBounds(-2, 122, 432, 37);
		contentPanel.add(buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		cancelButton = new RoundedButton("  닫 기  ");

		secondField.setForeground(Color.BLACK);
		secondField.setBorder(null);
		secondField.setHorizontalAlignment(SwingConstants.CENTER);
		secondField.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		secondField.setEditable(false);
		secondField.setOpaque(false);
		secondField.setBounds(21, 60, 386, 37);

	}

	private void startSettingDefatult(String first, String second) {
		firstField.setText(first);
		secondField.setText(second);
		contentPanel.add(firstField);
		contentPanel.add(secondField);
	}

	private void startActionListener() {
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
}