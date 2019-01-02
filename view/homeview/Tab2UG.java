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

public class Tab2UG extends JFrame {
	private static final long serialVersionUID = -6343656371168681310L;
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
	private RoundedButton btndelete;
	private GoodsService gs = new GoodsService();
	private Goods goods;
	private String userId;

	private PopupManager pm = new PopupManager();

	public Tab2UG(Goods goods) { // 물건정보 업데이트창이므로 기본적인 정보가 뜨게 해주세요.
		this.goods = goods;
		startFrame();
		content();
		setDefaultValue();
		startActionListener();
	}

	private void startFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // X버튼을 누르면 이 창만 꺼지도록
		setBounds(100, 100, 492, 413); // 창 크기
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void setDefaultValue() {
		String name = goods.getgName();
		String id = goods.getGid();
		String price = Integer.toString(goods.getgPrice());
		String stock = Integer.toString(goods.getgStock());
		String comment = " ";
		if (goods.getgCaption() != null) {
			comment += goods.getgCaption();
		}
		this.userId = goods.getgCID();
		txtName.setText(name);
		txtGid.setText(id);
		txtPrice.setText(price);
		txtStock.setText(stock);
		txtComment.setText(comment);

		contentPane.add(txtName);
		contentPane.add(txtPrice);
		contentPane.add(txtGid);
		contentPane.add(txtComment);
		contentPane.add(txtStock);
	}

	private void startActionListener() {

		btndelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gs.deleteGoods(goods)) {
					pm.sucDel();
					dispose();
				} else {
					pm.failDel();
				}
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 재고가 공란이거나 저장 범위를 넘을 때
				try {
					if (txtStock.getText().length() < 1 || txtStock.getText().length() > 10) {
						pm.overStock();
						txtStock.setText("");
					} else {
						Integer.parseInt(txtStock.getText());
					}
					// 재고가 숫자가 아닐때
				} catch (NumberFormatException e1) {
					pm.notSNum();
					txtStock.setText("");
					return;
				}

				// 가격이 공란이거나저장 범위를 넘을 때
				try {
					if (txtPrice.getText().length() < 1 || txtPrice.getText().length() > 10) {
						pm.overPrice();
						txtPrice.setText("");
						// 가격이 숫자가 아닐때
					} else {
						Integer.parseInt(txtPrice.getText());
					}
				} catch (NumberFormatException e2) {
					pm.nulName();
					return;
				}
				// 상품명이 공란이 아니면
				if (txtName.getText().length() < 1) {
				} else {
					Goods goods1 = new Goods();
					goods1.setgCaption(txtComment.getText());
					goods1.setgCID(userId);
					goods1.setGid(txtGid.getText());
					goods1.setgName(txtName.getText());
					goods1.setgPrice(Integer.parseInt(txtPrice.getText()));
					goods1.setgStock(Integer.parseInt(txtStock.getText()));
					gs.updateGoods(goods1);
					pm.sucUpdate();
					dispose();
				}
			}
		});
	}

	private void content() {
		label_1 = new JLabel("재고량");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setBounds(32, 180, 56, 28);
		contentPane.add(label_1);

		txtStock = new JTextField();
		txtStock.setHorizontalAlignment(SwingConstants.CENTER);
		txtStock.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtStock.setColumns(10);
		txtStock.setBounds(119, 176, 90, 30);

		label_2 = new JLabel("비고");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_2.setBounds(32, 262, 56, 28);
		contentPane.add(label_2);

		txtComment = new JTextField();
		txtComment.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtComment.setColumns(10);
		txtComment.setBounds(119, 260, 336, 30);

		label_3 = new JLabel("재고 물품 수정");
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

		lblid = new JLabel("고유물품ID");
		lblid.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblid.setBounds(32, 136, 73, 28);
		contentPane.add(lblid);

		txtGid = new JTextField();
		txtGid.setEditable(false);
		txtGid.setOpaque(false);
		txtGid.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtGid.setColumns(10);
		txtGid.setBounds(119, 134, 145, 30);

		label_4 = new JLabel("풀품가액");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_4.setBounds(32, 220, 56, 28);
		contentPane.add(label_4);

		txtPrice = new JTextField();
		txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtPrice.setColumns(10);
		txtPrice.setBounds(119, 220, 90, 30);

		btnNewButton = new RoundedButton("등 록");
		btnNewButton.setText("수 정");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		btnNewButton.setBounds(44, 320, 165, 36);
		contentPane.add(btnNewButton);

		btndelete = new RoundedButton("삭 제");
		btndelete.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		btndelete.setBounds(259, 320, 165, 36);
		contentPane.add(btndelete);
	}
}