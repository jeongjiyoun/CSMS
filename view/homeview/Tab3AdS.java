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
import csms.service.CompanyService;
import csms.service.SharingService;
import csms.util.RoundedButton;
import csms.vo.Goods;
import csms.vo.SharingGoods;

public class Tab3AdS extends JFrame {
	private static final long serialVersionUID = -7512622558196639238L;
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
	private RoundedButton btnNewButton;
	private SharingService ss = new SharingService();
	private CompanyService cs = new CompanyService();
	private PopupManager pm = new PopupManager();
	private String userId;
	private Goods goods;

	public Tab3AdS(String userId, Goods goods) {
		this.userId = userId;
		this.goods = goods;
		startFrame();
		content();
		startDefaultValue();
		startActionListener();
	}

	/**
	 * @wbp.parser.constructor
	 */
	public Tab3AdS(String userId) {
		this.userId = userId;
		startFrame();
		content();
		startActionListener();
		txtGid.setEditable(true);
		txtName.setEditable(true);
		startJtext();
	}

	private void startDefaultValue() {
		String gid = goods.getGid();
		String price = Integer.toString(goods.getgPrice());
		String name = goods.getgName();
		String comment = goods.getgCaption();

		txtComment.setText(comment);
		txtPrice.setText(price);
		txtName.setText(name);
		txtGid.setText(gid);
		startJtext();
	}

	private void startJtext() {
		contentPane.add(txtComment);
		contentPane.add(txtPrice);
		contentPane.add(txtGid);
		contentPane.add(txtName);
	}

	private void startFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 413);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void startActionListener() {
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 회사명이 없거나 입력되지 않으면
				// 불량 입력시 DB체크를 하지 않고도 불량을 검사할 수 있다.
				if (txtPrice.getText().length() < 1 || txtPrice.getText().length() > 10) {
					pm.overPrice();
					txtPrice.setText("");
				} else if (txtName.getText().length() < 1) {
					pm.nulName();
				} else if (txtSTo.getText().equals(userId)) {
					// 자기에게 공유를 하면
					pm.notGdub();
				} else if (!cs.idCheck(txtSTo.getText())) {
					// 없는 아이디면
					pm.noIdfind();
				} else {
					try {
						SharingGoods goods1 = new SharingGoods();
						goods1.setgCID(txtGid.getText());
						goods1.setgName(txtName.getText());
						goods1.setsCfrom(userId);
						goods1.setsCto(txtSTo.getText());
						goods1.setgPrice(Integer.parseInt(txtPrice.getText()));
						goods1.setgCaption(txtComment.getText());
						goods1.setgStock(goods.getgStock());
						goods1.setGid(goods.getGid());
						ss.insertSharing(goods1);
						pm.sucAdd();
						dispose();
					} catch (NumberFormatException e1) {
						pm.notPNum();
						txtPrice.setText("");
					}
				}

			}
		});
	}

	private void content() {
		label_1 = new JLabel("회사명");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setBounds(32, 180, 56, 28);
		contentPane.add(label_1);

		txtSTo = new JTextField();
		txtSTo.setHorizontalAlignment(SwingConstants.LEFT);
		txtSTo.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		txtSTo.setColumns(10);
		txtSTo.setBounds(119, 176, 145, 30);
		contentPane.add(txtSTo);

		label_2 = new JLabel("한줄소개");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_2.setBounds(32, 262, 56, 28);
		contentPane.add(label_2);

		txtComment = new JTextField();
		txtComment.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtComment.setColumns(10);
		txtComment.setBounds(119, 260, 336, 30);

		label_3 = new JLabel("물품 공유 추가");
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
		txtName.setColumns(10);
		txtName.setOpaque(false);
		txtName.setBorder(new LineBorder(Color.GRAY));
		txtName.setBounds(119, 92, 145, 30);

		lblid = new JLabel("고유물품ID");
		lblid.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblid.setBounds(32, 136, 73, 28);
		contentPane.add(lblid);

		txtGid = new JTextField();
		txtGid.setEditable(false);
		txtGid.setOpaque(false);
		txtGid.setBorder(new LineBorder(Color.GRAY));
		txtGid.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtGid.setColumns(10);
		txtGid.setBounds(119, 134, 145, 30);

		label_4 = new JLabel("가격");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_4.setBounds(32, 220, 56, 28);
		contentPane.add(label_4);

		txtPrice = new JTextField();
		txtPrice.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		txtPrice.setColumns(10);
		txtPrice.setBounds(119, 220, 90, 30);

		btnNewButton = new RoundedButton("등 록");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		btnNewButton.setBounds(154, 320, 165, 36);
		contentPane.add(btnNewButton);
	}

}
