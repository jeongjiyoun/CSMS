package csms.view.homeview;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import csms.manager.PopupManager;
import csms.manager.TableManager;
import csms.service.GoodsService;
import csms.util.RoundedButton;
import csms.view.HomeView;
import csms.vo.Goods;

public class Tab2 extends JPanel {
	private static final long serialVersionUID = -5244853905588282496L;
	@SuppressWarnings("unused")
	private HomeView window;
	private RoundedButton btnAddGoods;
	private RoundedButton btnUpGoods;
	private RoundedButton btnNewButton;
	private String[] name = { "품번", "상품명", "가격", "재고량" };
	private DefaultTableModel demodel = new DefaultTableModel(name, 0);
	private JTable jt = new JTable(demodel);
	private JScrollPane jsp = new JScrollPane(jt);
	private TableManager tdao = new TableManager();
	private String cid;
	private PopupManager pm = new PopupManager();
	private GoodsService gs = new GoodsService();

	public Tab2(HomeView test1, String cid) {
		this.window = test1;
		this.cid = cid;
		startContents();
		startTableSetting();
		showTable();
		startActionListener();
	}

	private void startContents() { // 컨텐츠
		btnUpGoods = new RoundedButton("상세 정보");
		btnUpGoods.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnUpGoods.setBackground(SystemColor.menu);
		btnUpGoods.setForeground(SystemColor.desktop);
		btnUpGoods.setBounds(196, 383, 137, 34);
		add(btnUpGoods);

		JLabel label = new JLabel("등록 상품 조회");
		label.setFont(new Font("굴림", Font.PLAIN, 13));
		label.setBounds(14, 12, 330, 28);
		add(label);

		btnNewButton = new RoundedButton("새로 고침");
		btnNewButton.setText("새로고침");
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setBounds(281, 72, 77, 24);
		add(btnNewButton);

		JLabel label_1 = new JLabel("내가 등록한 상품을 확인할 수 있습니다.");
		label_1.setFont(new Font("굴림", Font.PLAIN, 13));
		label_1.setBounds(14, 38, 330, 28);
		add(label_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(14, 38, 330, 2);
		add(separator);

		btnAddGoods = new RoundedButton("물품 추가");
		btnAddGoods.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnAddGoods.setBackground(SystemColor.menu);
		btnAddGoods.setForeground(SystemColor.desktop);
		btnAddGoods.setBounds(33, 383, 137, 34);
		add(btnAddGoods);

	}

	private void showTable() {
		tdao.getMyGoods(demodel, cid);
		jsp.setBounds(12, 107, 347, 260);
		add(jsp, "Center");
	}

	private void startTableSetting() {

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);

		jt.getColumn("품번").setPreferredWidth(40);
		jt.getColumn("품번").setCellRenderer(celAlignCenter);
		jt.getColumn("상품명").setPreferredWidth(150);
		jt.getColumn("상품명").setCellRenderer(celAlignCenter);
		jt.getColumn("가격").setPreferredWidth(30);
		jt.getColumn("가격").setCellRenderer(celAlignRight);
		jt.getColumn("재고량").setPreferredWidth(10);
		jt.getColumn("재고량").setCellRenderer(celAlignRight);
		jt.setFont(new Font("굴림", Font.PLAIN, 13));

		// 행간을 조절한다.
		jt.setRowHeight(25);

		this.setBackground(Color.WHITE);
		this.setLayout(null);

	}

	private void startActionListener() {
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tdao.getMyGoods(demodel, cid);
				jt.revalidate();
			}
		});

// 물건 정보 수정창을 띄움.
		btnUpGoods.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String gid = (String) jt.getValueAt(jt.getSelectedRow(), 0); // 물건 PK를 받음
					Goods goods = gs.getGoods(gid); // PK로 물건 전체 자료를 받음
					if (goods == null) {
						pm.failDel();
					} else {
						pm.updateGoods(goods);
					}
				} catch (ArrayIndexOutOfBoundsException e1) {
					//아무것도 선택하지 않은 채, 수정 버튼을 누르면 나는 오류
					//무시한다.
				}

			}
		});

		btnAddGoods.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 물건 추가창을 띄움
				pm.addGoods(cid);
			}
		});
	}

}
