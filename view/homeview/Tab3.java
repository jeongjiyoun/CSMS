package csms.view.homeview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import csms.manager.PopupManager;
import csms.service.SharingService;
import csms.util.RoundedButton;
import csms.view.HomeView;
import csms.vo.SharingGoods;

public class Tab3 extends JPanel {

	private static final long serialVersionUID = -5244853905588282496L;
	@SuppressWarnings("unused")
	private HomeView window;
	private RoundedButton btnUpShare;
	private RoundedButton btnAddShare;
	private String[] name = { "기업명", "상품명", "가격", "재고량" };
	private DefaultTableModel dt1 = new DefaultTableModel(name, 0);
	private DefaultTableModel dt2 = new DefaultTableModel(name, 0);
	private JTable jt1 = new JTable(dt1); // 내가 공유하는 물건
	private JTable jt2 = new JTable(dt2); // 내가 공유받은 물건
	private JScrollPane jsp = new JScrollPane(jt1);
	private JScrollPane jsp2 = new JScrollPane(jt2);
	private TableManager tdao = new TableManager();
	private SharingService ss = new SharingService();
	private PopupManager pm = new PopupManager();
	private String userId;
	private JLabel label;
	private JLabel label_1;
	private JTabbedPane tabbedPane;
	private RoundedButton button;

	public Tab3(HomeView homeview, String userId) {
		this.window = homeview;
		this.userId = userId;
		showTable();
		contents();
		startTableSetting();
		startActionListener();
	}

	private void startTableSetting() {

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);

		jt1.getColumn("기업명").setPreferredWidth(60);
		jt1.getColumn("기업명").setCellRenderer(celAlignCenter);
		jt1.getColumn("상품명").setPreferredWidth(130);
		jt1.getColumn("상품명").setCellRenderer(celAlignCenter);
		jt1.getColumn("가격").setPreferredWidth(30);
		jt1.getColumn("가격").setCellRenderer(celAlignRight);
		jt1.getColumn("재고량").setPreferredWidth(20);
		jt1.getColumn("재고량").setCellRenderer(celAlignRight);
		jt1.setFont(new Font("굴림", Font.PLAIN, 13));

		// 행간을 조절한다.
		jt1.setRowHeight(25);

		this.setBackground(Color.WHITE);
		this.setLayout(null);

		jt2.getColumn("기업명").setPreferredWidth(60);
		jt2.getColumn("기업명").setCellRenderer(celAlignCenter);
		jt2.getColumn("상품명").setPreferredWidth(130);
		jt2.getColumn("상품명").setCellRenderer(celAlignCenter);
		jt2.getColumn("가격").setPreferredWidth(30);
		jt2.getColumn("가격").setCellRenderer(celAlignRight);
		jt2.getColumn("재고량").setPreferredWidth(20);
		jt2.getColumn("재고량").setCellRenderer(celAlignRight);
		jt2.setFont(new Font("굴림", Font.PLAIN, 13));

		// 행간을 조절한다.
		jt2.setRowHeight(25);

		this.setBackground(Color.WHITE);
		this.setLayout(null);

	}

	private void contents() {
		label = new JLabel("공유 상품 조회");
		label.setFont(new Font("굴림", Font.PLAIN, 13));
		label.setBounds(14, 12, 330, 28);
		add(label);

		label_1 = new JLabel("공유하거나, 공유받은 상품을 볼 수 있습니다.");
		label_1.setFont(new Font("굴림", Font.PLAIN, 13));
		label_1.setBounds(14, 38, 330, 28);
		add(label_1);

		btnUpShare = new RoundedButton("상세 보기");
		btnUpShare.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnUpShare.setBounds(33, 383, 137, 34);
		add(btnUpShare);

		JSeparator separator = new JSeparator();
		separator.setBounds(14, 38, 330, 2);
		add(separator);

		btnAddShare = new RoundedButton("공유 추가");
		btnAddShare.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnAddShare.setBounds(196, 383, 137, 34);
		add(btnAddShare);
	}

	private void showTable() {
		tdao.getSharingGoods(dt1, userId);
		tdao.getsharedGoods(dt2, userId);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 78, 347, 289);
		add(tabbedPane);
		tabbedPane.addTab("공유한 물품", null, jsp, null);
		tabbedPane.addTab("공유받은 물품", null, jsp2, null);

		button = new RoundedButton("새로 고침");
		button.setText("새로고침");
		button.setFont(new Font("굴림체", Font.PLAIN, 15));
		button.setBounds(281, 72, 77, 24);
		add(button);
	}

	private void startActionListener() {
		btnUpShare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 물건 공유 수정창을 띄움.
				int a = tabbedPane.getSelectedIndex();
				// 내가 공유하는 상품이면 0번/ 아니면 1번을 돌려받음.
				try {
					SharingGoods result = null;
					if (a == 0) {
						int k1 = jt1.getSelectedRow();
						SharingGoods shares = new SharingGoods();
						shares.setsCto((String) jt1.getValueAt(k1, 0));
						shares.setgName((String) jt1.getValueAt(k1, 1));
						shares.setgPrice(Integer.parseInt((((String) jt1.getValueAt(k1, 2)).replaceAll(",", ""))));
						shares.setsCfrom(userId);
						result = ss.findSgd(shares);
						if (result == null) { // 이미 삭제된 물건
							pm.failDel();
						} else {
							pm.ShareGoods(result);
						}
					} else if (a == 1) { // 공유받은 물건
						int k2 = jt2.getSelectedRow();
						SharingGoods shares = new SharingGoods();
						shares.setsCfrom((String) jt2.getValueAt(k2, 0));
						shares.setgName((String) jt2.getValueAt(k2, 1));
						shares.setgPrice(Integer.parseInt((((String) jt2.getValueAt(k2, 2)).replaceAll(",", ""))));
						shares.setsCto(userId);
						result = ss.findSgd(shares);
						if (result == null) { // 이미 삭제된 물건
							pm.failDel();
						}
						pm.SharedGoods(result);
					}

				} catch (ArrayIndexOutOfBoundsException e3) {
					// 아무것도 선택하지 않은 채, 상세보기를 누른 경우
					// 무시한다.
				}
			}
		});

		// 새로고침
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tdao.getSharingGoods(dt1, userId);
				tdao.getsharedGoods(dt2, userId);
				jt1.revalidate();
				jt2.revalidate();
			}
		});

		btnAddShare.addActionListener(new ActionListener() {
			// 일단 물건에 고유번호가 내가 가진 물건이면 아니면으로 나누고
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = tabbedPane.getSelectedIndex();
				// 선택이 안되어있으면, 그냥 빈 칸을 띄웁니다 <가 처리가 들어가야함.
				// 내가 공유하는 상품이면 0번/ 아니면 1번을 돌려받음.
				try {
					if (a == 0) {
						int k1 = jt1.getSelectedRow();
						SharingGoods shares = new SharingGoods();
						shares.setsCto((String) jt1.getValueAt(k1, 0));
						shares.setgName((String) jt1.getValueAt(k1, 1));
						shares.setsCfrom(userId);
						SharingGoods result = ss.findSgd(shares);
						pm.addSharing(userId, result);
					} else if (a == 1) {
						pm.addSharing(userId);
					} // 만약 어떠한 것도 선택하지 않은 채, 추가버튼을 누르면 빈 추가창 띄움
				} catch (ArrayIndexOutOfBoundsException e1) {
					pm.addSharing(userId);
				}
			}
		});
	}
}
