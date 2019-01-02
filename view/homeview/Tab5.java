package csms.view.homeview;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import csms.manager.PopupManager;
import csms.manager.StringMaker;
import csms.manager.TableManager;
import csms.service.CategoryService;
import csms.service.CompanyService;
import csms.service.DealingCService;
import csms.util.RoundedButton;
import csms.view.HomeView;

public class Tab5 extends JPanel {
	private static final long serialVersionUID = 5631121597437548135L;
	@SuppressWarnings("unused")
	private HomeView window;
	private String[] name1 = { "회사명", "아이디", "코멘트" };
	private DefaultTableModel dt1 = new DefaultTableModel(name1, 0);
	private JTable jt1 = new JTable(dt1);
	private JScrollPane jsp1 = new JScrollPane(jt1);

	private DefaultTableModel dt2 = new DefaultTableModel(name1, 0);
	private JTable jt2 = new JTable(dt2);
	private JScrollPane jsp2 = new JScrollPane(jt2);

	private DefaultTableModel dt3 = new DefaultTableModel(name1, 0);
	private JTable jt3 = new JTable(dt3);
	private JScrollPane jsp3 = new JScrollPane(jt3);

	private DefaultTableModel dt4 = new DefaultTableModel(name1, 0);
	private JTable jt4 = new JTable(dt4);
	private JScrollPane jsp4 = new JScrollPane(jt4);

	private RoundedButton btnAddCom;
	private RoundedButton btnShowInfo;

	private JPanel basic = new JPanel();

	private CompanyService cs = new CompanyService();
	private StringMaker sm = new StringMaker();
	private PopupManager pm = new PopupManager();
	private TableManager tm = new TableManager();
	private CategoryService gs = new CategoryService();
	private DealingCService ds = new DealingCService();
	private String userId;
	private RoundedButton bnReg;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JTextField txtReg1;
	private JLabel label_2;
	private JTextField txtReg2;
	private JLabel label_3;
	private JTextField txtReg3;
	private JPanel panel;
	private RoundedButton bnTel;
	private JTextField txtTel1;
	private JLabel label_4;
	private JTextField txtTel2;
	private JLabel label_5;
	private JPanel panel_2;
	private RoundedButton bnName;
	private JTextField txtName;
	private JPanel panel_3;
	private JTextField txtTel3;
	private RoundedButton bnCate;
	private JComboBox<String> cbLarge;
	private JComboBox<String> cbSmall;

	private void startActionListener() {

		bnName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtName.getText().length() < 1) {
					pm.notNullName();
				} else {
					String cName = txtName.getText();
					tm.searchbyname(dt3, cName);
					jt3.revalidate();
				}
			}
		});

		bnReg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtReg1.getText().matches("(0)|\\d{3,3}") || !txtReg2.getText().matches("(0)|\\d{2,2}")
						|| !txtReg3.getText().matches("((0)|\\d{5,5})")) {
					pm.showRegiRule();
					return;
				} else {
					String creginum = sm.makeRegi(txtReg1.getText(), txtReg2.getText(), txtReg3.getText());
					tm.getRegi(dt1, creginum);
					jt1.revalidate();
				}
			}
		});

		cbLarge.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				List<String> list = gs.getSCateInfo((String) cbLarge.getSelectedItem());
				String[] sCate = new String[list.size()];
				for (int i = 0; i < list.size(); i++) {
					sCate[i] = list.get(i);
				}
				cbSmall.setModel(new DefaultComboBoxModel<String>(sCate));
			}

			@Override
			public void focusGained(FocusEvent e) {
				List<String> listL = gs.getLCateInfo();
				String[] lCate = new String[listL.size()];
				for (int i = 0; i < listL.size(); i++) {
					lCate[i] = listL.get(i);
				}
				cbLarge.setModel(new DefaultComboBoxModel<String>(lCate));
			}
		});

		bnCate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String tLcatename = (String) cbLarge.getSelectedItem();
					String tScatename = (String) cbSmall.getSelectedItem();
					tm.getCate(dt4, tLcatename, tScatename);
					jt4.revalidate();
				} catch (ArrayIndexOutOfBoundsException e2) {
					// 덜 선택한 채로 누를 경우 무시한다.
				}
			}
		});

		bnTel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtTel1.getText().matches("(0)|\\d{2,3}") || !txtTel2.getText().matches("(0)|\\d{3,4}")
						|| !txtTel3.getText().matches("(0)|\\d{4,4}")) {
					pm.showTelRule();
					return;
				} else {
					String ctel = sm.makeTel(txtTel1.getText(), txtTel2.getText(), txtTel3.getText());
					tm.getTel(dt2, ctel);
					jt2.revalidate();
				}
			}
		});

		btnAddCom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int index = tabbedPane.getSelectedIndex();
					String result = null;
					switch (index) {
					case 0:
						result = (String) jt1.getValueAt(jt1.getSelectedRow(), 1);
						break;
					case 1:
						result = (String) jt2.getValueAt(jt2.getSelectedRow(), 1);
						break;
					case 2:
						result = (String) jt3.getValueAt(jt3.getSelectedRow(), 1);
						break;
					case 3:
						result = (String) jt4.getValueAt(jt4.getSelectedRow(), 1);
						break;
					}
					if(userId.equals(result)) {
						pm.notdub();
					} else {
						ds.addCom(userId, result);
						pm.addCom();
					}
				} catch (ArrayIndexOutOfBoundsException e2) {

				}

			}
		});

		btnShowInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int index = tabbedPane.getSelectedIndex();
					String result = null;
					switch (index) {
					case 0:
						result = (String) jt1.getValueAt(jt1.getSelectedRow(), 1);
						break;
					case 1:
						result = (String) jt2.getValueAt(jt2.getSelectedRow(), 1);
						break;
					case 2:
						result = (String) jt3.getValueAt(jt3.getSelectedRow(), 1);
						break;
					case 3:
						result = (String) jt4.getValueAt(jt4.getSelectedRow(), 1);
						break;
					}
					pm.showComInfo(cs.getCompanyInfo(result));
				} catch (ArrayIndexOutOfBoundsException e2) {
					// 아무것도 선택하지 않은 채 누르는 경우 무시
				}
			}
		});
	}

	public Tab5(HomeView homeview, String userId) {
		this.window = homeview;
		this.userId = userId;
		contents();
		startTableSetting();
		startActionListener();
	}

	private void startTableSetting() {

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);

		jt1.getColumn("회사명").setPreferredWidth(50);
		jt1.getColumn("아이디").setPreferredWidth(50);
		jt1.getColumn("코멘트").setPreferredWidth(130);
		jt1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt1.setFont(new Font("굴림", Font.PLAIN, 13));
		jt1.setRowHeight(25);

		this.setBackground(Color.WHITE);
		this.setLayout(null);

		jt2.getColumn("회사명").setPreferredWidth(50);
		jt2.getColumn("아이디").setPreferredWidth(50);
		jt2.getColumn("코멘트").setPreferredWidth(130);
		jt2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt2.setFont(new Font("굴림", Font.PLAIN, 13));
		jt2.setRowHeight(25);

		jt3.getColumn("회사명").setPreferredWidth(50);
		jt3.getColumn("아이디").setPreferredWidth(50);
		jt3.getColumn("코멘트").setPreferredWidth(130);
		jt3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt3.setFont(new Font("굴림", Font.PLAIN, 13));
		jt3.setRowHeight(25);

		jt4.getColumn("회사명").setPreferredWidth(50);
		jt4.getColumn("아이디").setPreferredWidth(50);
		jt4.getColumn("코멘트").setPreferredWidth(130);
		jt4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt4.setFont(new Font("굴림", Font.PLAIN, 13));
		jt4.setRowHeight(25);

	}

	private void contents() {
		// 컨텐츠
		JLabel label = new JLabel("기업 검색");
		label.setFont(new Font("굴림", Font.PLAIN, 13));
		label.setBounds(12, 12, 330, 28);
		add(label);

		JLabel label_1 = new JLabel("거래처를 검색할 수 있습니다.");
		label_1.setFont(new Font("굴림", Font.PLAIN, 13));
		label_1.setBounds(12, 38, 330, 28);
		add(label_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 38, 330, 2);
		add(separator);

		btnAddCom = new RoundedButton("메시지 보내기");
		btnAddCom.setText("공유 회사로 추가");
		btnAddCom.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnAddCom.setBackground(SystemColor.menu);
		btnAddCom.setForeground(SystemColor.desktop);
		btnAddCom.setBounds(33, 386, 137, 34);
		add(btnAddCom);

		btnShowInfo = new RoundedButton("메시지 보기");
		btnShowInfo.setText("회사 정보 보기");
		btnShowInfo.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnShowInfo.setForeground(SystemColor.desktop);
		btnShowInfo.setBackground(SystemColor.menu);
		btnShowInfo.setBounds(196, 386, 137, 34);
		add(btnShowInfo);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 75, 346, 292);
		add(tabbedPane);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("사업자등록번호", null, panel_1, null);
		panel_1.setLayout(null);
		jsp1.setBounds(0, 66, 342, 205);
		panel_1.add(jsp1);

		bnReg = new RoundedButton("검 색");
		bnReg.setBounds(262, 22, 65, 27);
		panel_1.add(bnReg);

		txtReg1 = new JTextField();
		txtReg1.setHorizontalAlignment(SwingConstants.CENTER);
		txtReg1.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtReg1.setColumns(10);
		txtReg1.setBounds(14, 20, 56, 30);
		panel_1.add(txtReg1);

		label_2 = new JLabel("  -");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_2.setBounds(68, 27, 30, 15);
		panel_1.add(label_2);

		txtReg2 = new JTextField();
		txtReg2.setHorizontalAlignment(SwingConstants.CENTER);
		txtReg2.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtReg2.setColumns(10);
		txtReg2.setBounds(94, 20, 51, 30);
		panel_1.add(txtReg2);

		label_3 = new JLabel(" -");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_3.setBounds(148, 27, 21, 15);
		panel_1.add(label_3);

		txtReg3 = new JTextField();
		txtReg3.setHorizontalAlignment(SwingConstants.CENTER);
		txtReg3.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtReg3.setColumns(10);
		txtReg3.setBounds(170, 20, 78, 30);
		panel_1.add(txtReg3);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("전화번호", null, panel, null);
		jsp2.setBounds(0, 66, 342, 209);
		panel.add(jsp2);

		bnTel = new RoundedButton("검 색");
		bnTel.setBounds(262, 22, 65, 27);
		panel.add(bnTel);

		txtTel1 = new JTextField();
		txtTel1.setHorizontalAlignment(SwingConstants.CENTER);
		txtTel1.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtTel1.setColumns(10);
		txtTel1.setBounds(14, 20, 65, 30);
		panel.add(txtTel1);

		label_4 = new JLabel("  -");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_4.setBounds(74, 28, 30, 15);
		panel.add(label_4);

		txtTel2 = new JTextField();
		txtTel2.setHorizontalAlignment(SwingConstants.CENTER);
		txtTel2.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtTel2.setColumns(10);
		txtTel2.setBounds(98, 20, 65, 30);
		panel.add(txtTel2);

		label_5 = new JLabel(" -");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 19));
		label_5.setBounds(166, 28, 21, 15);
		panel.add(label_5);

		txtTel3 = new JTextField();
		txtTel3.setHorizontalAlignment(SwingConstants.CENTER);
		txtTel3.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtTel3.setColumns(10);
		txtTel3.setBounds(183, 20, 65, 30);
		panel.add(txtTel3);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("회사명", null, panel_2, null);
		jsp3.setBounds(0, 66, 342, 205);
		panel_2.add(jsp3);

		bnName = new RoundedButton("검 색");
		bnName.setBounds(262, 22, 65, 27);
		panel_2.add(bnName);

		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.LEFT);
		txtName.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		txtName.setColumns(10);
		txtName.setBounds(28, 20, 215, 30);
		panel_2.add(txtName);

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("카테고리", null, panel_3, null);

		bnCate = new RoundedButton("검 색");
		bnCate.setBounds(262, 22, 65, 27);
		panel_3.add(bnCate);
		jsp4.setBounds(0, 66, 342, 201);
		panel_3.add(jsp4);

		cbLarge = new JComboBox<String>();
		cbLarge.setBounds(14, 18, 110, 32);
		panel_3.add(cbLarge);

		cbSmall = new JComboBox<String>();
		cbSmall.setBounds(138, 18, 110, 32);
		panel_3.add(cbSmall);

		basic = new JPanel();
		basic.setBackground(Color.WHITE);
		basic.setBounds(14, 140, 342, 82);
		basic.setLayout(null);
	}

}
