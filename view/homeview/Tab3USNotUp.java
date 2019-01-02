package csms.view.homeview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import csms.manager.PopupManager;
import csms.service.SharingService;
import csms.util.RoundedButton;
import csms.vo.SharingGoods;

public class Tab3USNotUp extends JFrame {
	private static final long serialVersionUID = -6343656371168681310L;
	private JPanel contentPane;
	private JLabel label_1;
	private JTextField txtSTo;
	private JLabel label_2;
	private JTextField txtComment;
	private JLabel label_3;
	private JLabel label;
	private JTextField txtName;
	private JLabel lblid;
	private JTextField txtGid;
	private JLabel label_4;
	private JTextField txtPrice;
	private SharingGoods shares;
	private RoundedButton button_1;

	private PopupManager pm = new PopupManager();
	private SharingService ss = new SharingService();

	public Tab3USNotUp(SharingGoods goods) { // 물건정보 업데이트창이므로 기본적인 정보가 뜨게 해주세요.
		this.shares = goods;
		startFrame();
		content();
		setDefaultValue();
		startActionListener();
	}

	private void startFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 413); // 창 크기
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	private void setDefaultValue() {
		String gid = shares.getGid();
		String price = Integer.toString(shares.getgPrice());
		String name = shares.getgName();
		String comment = shares.getgCaption();
		String tocom = shares.getsCto();

		txtComment.setText(comment);
		txtPrice.setText(price);
		txtName.setText(name);
		txtGid.setText(gid);
		txtSTo.setText(tocom);

		contentPane.add(txtComment);
		contentPane.add(txtPrice);
		contentPane.add(txtGid);
		contentPane.add(txtName);
		contentPane.add(txtSTo);
	}

	private void startActionListener() {

		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ss.deleteShares(shares);
				pm.sucDel();
				dispose();
			}
		});
	}

	private void content() {

		label_1 = new JLabel("회사명");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setBounds(32, 180, 56, 28);
		contentPane.add(label_1);

		txtSTo = new JTextField();
		txtSTo.setEditable(false);
		txtSTo.setOpaque(false);
		txtSTo.setBorder(new LineBorder(Color.GRAY));
		txtSTo.setHorizontalAlignment(SwingConstants.LEFT);
		txtSTo.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		txtSTo.setColumns(10);
		txtSTo.setBounds(119, 176, 145, 30);

		label_2 = new JLabel("한줄소개");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_2.setBounds(32, 262, 56, 28);
		contentPane.add(label_2);

		txtComment = new JTextField();
		txtComment.setEditable(false);
		txtComment.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtComment.setColumns(10);
		txtComment.setBorder(new LineBorder(Color.GRAY));
		txtComment.setOpaque(false);
		txtComment.setBounds(119, 260, 336, 30);

		label_3 = new JLabel("공유 설정 변경");
		label_3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label_3.setBounds(164, 24, 145, 41);
		contentPane.add(label_3);

		label = new JLabel("물품명");
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setBounds(32, 94, 42, 28);
		contentPane.add(label);

		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtName.setBorder(new LineBorder(Color.GRAY));
		txtName.setColumns(10);
		txtName.setOpaque(false);
		txtName.setBounds(119, 92, 145, 30);

		lblid = new JLabel("고유물품ID");
		lblid.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblid.setBounds(32, 136, 73, 28);
		contentPane.add(lblid);

		txtGid = new JTextField();
		txtGid.setEditable(false);
		txtGid.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtGid.setColumns(10);
		txtGid.setBorder(new LineBorder(Color.GRAY));
		txtGid.setOpaque(false);
		txtGid.setBounds(119, 134, 145, 30);

		label_4 = new JLabel("가격");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_4.setBounds(32, 220, 56, 28);
		contentPane.add(label_4);

		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setBorder(new LineBorder(Color.GRAY));
		txtPrice.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		txtPrice.setColumns(10);
		txtPrice.setOpaque(false);
		txtPrice.setBounds(119, 220, 90, 30);

		button_1 = new RoundedButton("삭 제");
		button_1.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		button_1.setBounds(144, 320, 165, 36);
		contentPane.add(button_1);

	}
}