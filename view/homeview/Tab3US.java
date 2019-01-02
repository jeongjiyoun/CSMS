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

public class Tab3US extends JFrame {
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
	private SharingGoods goods;
	private RoundedButton btnChange;
	private RoundedButton btnDelete;

	private SharingService ss = new SharingService();
	private PopupManager pm = new PopupManager();

	public Tab3US(SharingGoods goods) {
		// 물건정보가 뜨는 생성자.
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
		String gid = goods.getGid();
		String price = Integer.toString(goods.getgPrice());
		String name = goods.getgName();
		String comment = goods.getgCaption();
		String tocom = goods.getsCto();

		txtComment.setText(comment);
		txtPrice.setText(price);
		txtName.setText(name);
		txtGid.setText(gid);
		txtSTo.setText(tocom);
		addTxtPField();
	}

	private void addTxtPField() {
		contentPane.add(txtComment);
		contentPane.add(txtPrice);
		contentPane.add(txtGid);
		contentPane.add(txtName);
		contentPane.add(txtSTo);

	}

	private void startActionListener() {

		btnChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goods.setgCaption(txtComment.getText());
				ss.updateShares(goods);
				dispose();
				pm.sucUpdate();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ss.deleteShares(goods);
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
		txtSTo.setHorizontalAlignment(SwingConstants.LEFT);
		txtSTo.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtSTo.setColumns(10);
		txtSTo.setBounds(119, 176, 179, 30);

		label_2 = new JLabel("한줄소개");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_2.setBounds(32, 262, 56, 28);
		contentPane.add(label_2);

		txtComment = new JTextField();
		txtComment.setHorizontalAlignment(SwingConstants.LEFT);
		txtComment.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		txtComment.setColumns(10);
		txtComment.setBounds(119, 260, 336, 30);

		label_3 = new JLabel("공유 물품 정보 변경");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label_3.setBounds(138, 24, 197, 41);
		contentPane.add(label_3);

		label = new JLabel("물품명");
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setBounds(32, 94, 42, 28);
		contentPane.add(label);

		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.LEFT);
		txtName.setEditable(false);
		txtName.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(Color.GRAY));
		txtName.setOpaque(false);
		txtName.setBounds(119, 92, 179, 30);

		lblid = new JLabel("고유물품ID");
		lblid.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblid.setBounds(32, 136, 73, 28);
		contentPane.add(lblid);

		txtGid = new JTextField();
		txtGid.setHorizontalAlignment(SwingConstants.LEFT);
		txtGid.setEditable(false);
		txtGid.setBorder(new LineBorder(Color.GRAY));
		txtGid.setOpaque(false);
		txtGid.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtGid.setColumns(10);
		txtGid.setBounds(119, 134, 179, 30);

		label_4 = new JLabel("가격");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_4.setBounds(32, 220, 56, 28);
		contentPane.add(label_4);

		txtPrice = new JTextField();
		txtPrice.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtPrice.setColumns(10);
		txtPrice.setBounds(119, 220, 179, 30);

		btnChange = new RoundedButton("변 경");
		btnChange.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		btnChange.setBounds(52, 312, 165, 36);
		contentPane.add(btnChange);

		btnDelete = new RoundedButton("삭 제");
		btnDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		btnDelete.setBounds(267, 312, 165, 36);
		contentPane.add(btnDelete);
	}
}