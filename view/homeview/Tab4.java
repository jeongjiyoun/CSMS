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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import csms.manager.PopupManager;
import csms.service.CompanyService;
import csms.service.DealingCService;
import csms.util.RoundedButton;
import csms.view.HomeView;

import javax.swing.JTabbedPane;

public class Tab4 extends JPanel {
	private static final long serialVersionUID = 5631121597437548135L;
	@SuppressWarnings("unused")
	private HomeView window;
	private String[] name = { "회사명", "전화번호", "공유수" };
	private DefaultTableModel dt1 = new DefaultTableModel(name, 0);
	private JTable jt1 = new JTable(dt1);
	private JScrollPane j1 = new JScrollPane(jt1);
	private DefaultTableModel dt2 = new DefaultTableModel(name, 0);
	private JTable jt2 = new JTable(dt2);
	private JScrollPane j2 = new JScrollPane(jt2);

	private RoundedButton btnShowCom;
	private RoundedButton btnDeleteDeal;
	private TableManager tdao = new TableManager();
	private CompanyService cs = new CompanyService();
	private PopupManager pm = new PopupManager();
	private DealingCService ds = new DealingCService();
	private String userId;
	private RoundedButton btnrefresh;
	private JTabbedPane tabbedPane;

	public Tab4(HomeView homeview, String userId) {
		this.window = homeview;
		this.userId = userId;

		contents();
		startTableSetting();
		showTable();
		startActionListener();
	}

	private void showTable() {
		tdao.getDealCompany(dt1, userId);
		tdao.getDealedCompany(dt2, userId);
	}

	private void contents() {

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 78, 347, 289);
		add(tabbedPane);
		tabbedPane.addTab("공유한 기업", null, j1, null);
		tabbedPane.addTab("공유받은 기업", null, j2, null);

		JLabel label = new JLabel("거래 기업 보기");
		label.setFont(new Font("굴림", Font.PLAIN, 13));
		label.setBounds(12, 12, 330, 28);
		add(label);

		JLabel label_1 = new JLabel("정보를 공유중인 기업의 정보를 확인할 수 있습니다.");
		label_1.setFont(new Font("굴림", Font.PLAIN, 13));
		label_1.setBounds(12, 38, 330, 28);
		add(label_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 38, 330, 2);
		add(separator);

		btnrefresh = new RoundedButton();
		btnrefresh.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnrefresh.setForeground(SystemColor.desktop);
		btnrefresh.setText("새로고침");
		btnrefresh.setBackground(SystemColor.menu);
		add(btnrefresh);

		btnShowCom = new RoundedButton("정보 보기");
		btnShowCom.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnShowCom.setBackground(SystemColor.menu);
		btnShowCom.setForeground(SystemColor.desktop);
		btnShowCom.setBounds(33, 383, 137, 34);
		add(btnShowCom);

		btnDeleteDeal = new RoundedButton("등록 삭제");
		btnDeleteDeal.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnDeleteDeal.setForeground(SystemColor.desktop);
		btnDeleteDeal.setBackground(SystemColor.menu);
		btnDeleteDeal.setBounds(196, 383, 137, 34);
		btnrefresh.setBounds(281, 72, 77, 24);
		add(btnDeleteDeal);

	}

	private void startTableSetting() {

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		jt1.getColumn("회사명").setPreferredWidth(130);
		jt1.getColumn("전화번호").setPreferredWidth(80);
		jt1.getColumn("공유수").setPreferredWidth(30);
		jt1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt1.setFont(new Font("굴림", Font.PLAIN, 13));
		jt1.setRowHeight(25);

		this.setBackground(Color.WHITE);
		this.setLayout(null);

		jt2.getColumn("회사명").setPreferredWidth(130);
		jt2.getColumn("전화번호").setPreferredWidth(80);
		jt2.getColumn("공유수").setPreferredWidth(30);
		jt2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt2.setFont(new Font("굴림", Font.PLAIN, 13));
		jt2.setRowHeight(25);
	}

	private void startActionListener() {
		btnShowCom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int index = tabbedPane.getSelectedIndex();
					if (index == 0) {
						String name = (String) jt1.getValueAt(jt1.getSelectedRow(), 0);
						pm.showComInfo(cs.getCompanyInfo(name));
					} else if (index == 1) {
						String name = (String) jt2.getValueAt(jt2.getSelectedRow(), 0);
						pm.showComInfo(cs.getCompanyInfo(name));
					}
				} catch (ArrayIndexOutOfBoundsException e1) {
					// 선택하지 않고 기업정보 보기 버튼
					// 무시한다.
				}
			}
		});

		btnrefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tdao.getDealCompany(dt1, userId);
				jt1.revalidate();
				jt2.revalidate();
			}
		});

		btnDeleteDeal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int index = tabbedPane.getSelectedIndex();
					if (index == 0) {
						String toname = (String) jt1.getValueAt(jt1.getSelectedRow(), 0);
						ds.deleteDeal(userId, toname);
						pm.sucDel();
					} else if (index == 1) { // 공유받은 기업
						String fromname = (String) jt2.getValueAt(jt2.getSelectedRow(), 0);
						ds.deleteDeal(fromname, userId);
						pm.sucDel();
					}
				} catch (ArrayIndexOutOfBoundsException e2) {
					// 선택하지 않고 삭제버튼
					// 무시한다.
				}

			}
		});
	}
}
