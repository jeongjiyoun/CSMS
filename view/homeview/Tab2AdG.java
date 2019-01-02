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

import csms.manager.PopupManager;
import csms.service.GoodsService;
import csms.util.RoundedButton;
import csms.vo.Goods;

public class Tab2AdG extends JFrame {
	private static final long serialVersionUID = -7367448370723157482L;
	private JPanel contentPane;
	private JLabel label_1;
	private JTextField txtStock;
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
	private GoodsService gs = new GoodsService();
	private PopupManager ps = new PopupManager();
	private String userId;

	public Tab2AdG(String userId) {
		this.userId = userId;
		content();
		startActionListener();
	}

	private void startActionListener() { // 물건 넣는 기능 구현
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 재고가 공란이거나 숫자가 아니면
				if (txtStock.getText().length() < 1 || !txtStock.getText().matches("(^[1-9999999999]*$)")) {
					ps.notSNum();
					txtStock.setText("");
					// 가격이 공란이거나 숫자가 아니면
				} else if (txtPrice.getText().length() < 1 || !txtPrice.getText().matches("(^[1-9999999999]*$)")) {
					ps.notPNum();
					txtPrice.setText("");
				} else if (txtGid.getText().length() < 1) {
					ps.notPNum();
				} else if (gs.findGid(txtGid.getText())) {
					ps.dupGid();
					txtGid.setText("");
				} else if (txtName.getText().length() < 1) { // 남은 건 이름txt 조건뿐 이름이 공란이 아니면
					ps.nulName();
				} else {
					Goods goods = new Goods();
					goods.setgCID(userId);
					goods.setGid(txtGid.getText());
					goods.setgName(txtName.getText());
					goods.setgCaption(txtComment.getText());
					goods.setgPrice(Integer.parseInt(txtPrice.getText()));
					goods.setgStock(Integer.parseInt(txtStock.getText()));
					gs.insertGoods(goods);
					ps.sucAdd();
					dispose();
				}
			}
		});

	}

	private void content() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 413);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		label_1 = new JLabel("재고량");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setBounds(32, 180, 56, 28);
		contentPane.add(label_1);

		txtStock = new JTextField();
		txtStock.setHorizontalAlignment(SwingConstants.CENTER);
		txtStock.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtStock.setColumns(10);
		txtStock.setBounds(119, 176, 90, 30);
		contentPane.add(txtStock);

		label_2 = new JLabel("비고");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_2.setBounds(32, 262, 56, 28);
		contentPane.add(label_2);

		txtComment = new JTextField();
		txtComment.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtComment.setColumns(10);
		txtComment.setBounds(119, 260, 336, 30);
		contentPane.add(txtComment);

		label_3 = new JLabel("재고 물품 등록");
		label_3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label_3.setBounds(164, 24, 145, 41);
		contentPane.add(label_3);

		label = new JLabel("물품명");
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setBounds(32, 94, 42, 28);
		contentPane.add(label);

		txtName = new JTextField();
		txtName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBounds(119, 92, 145, 30);
		contentPane.add(txtName);

		lblid = new JLabel("고유물품ID");
		lblid.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblid.setBounds(32, 136, 73, 28);
		contentPane.add(lblid);

		txtGid = new JTextField();
		txtGid.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtGid.setColumns(10);
		txtGid.setBounds(119, 134, 145, 30);
		contentPane.add(txtGid);

		label_4 = new JLabel("풀품가액");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_4.setBounds(32, 220, 56, 28);
		contentPane.add(label_4);

		txtPrice = new JTextField();
		txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtPrice.setColumns(10);
		txtPrice.setBounds(119, 220, 90, 30);
		contentPane.add(txtPrice);

		btnNewButton = new RoundedButton("등 록");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		btnNewButton.setBounds(154, 320, 165, 36);
		contentPane.add(btnNewButton);
	}

}