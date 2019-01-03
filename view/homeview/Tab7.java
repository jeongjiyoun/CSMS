package csms.view.homeview;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import csms.manager.PopupManager;
import csms.manager.TableManager;
import csms.util.RoundedButton;
import csms.view.HomeView;
import csms.vo.Inquiry;

public class Tab7 extends JPanel {
	private static final long serialVersionUID = 5631121597437548135L;
	@SuppressWarnings("unused")
	private HomeView window;
	private JPanel pn6_Message;
	private String[] name1 = { "제목", "발신인", "일자" };
	private DefaultTableModel dt1 = new DefaultTableModel(name1, 0);
	private JTable jt1 = new JTable(dt1);
	private JScrollPane jsp1 = new JScrollPane(jt1);
	private String[] name2 = { "제목", "수신인", "일자" };
	private DefaultTableModel dt2 = new DefaultTableModel(name2, 0);
	private JTable jt2 = new JTable(dt2);
	private JScrollPane jsp2 = new JScrollPane(jt2);
	private RoundedButton btnSendMs;
	private RoundedButton btnShowMs;
	private JTabbedPane tabbedPane;
	private RoundedButton btnrefresh;

	private PopupManager pm = new PopupManager();
	private TableManager tm = new TableManager();
//	private InquiryService is = new InquiryService();
	private String userId;

	public Tab7(HomeView homeview, String userId) {
		this.window = homeview;
		this.userId = userId;
		setLayout(null);
		pn6_Message = new JPanel();
		pn6_Message.setLayout(null);

		contents();
		startTableSetting();
		showTable();
		startActionListener();
	}

	private void startTableSetting() {

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);

		jt1.getColumn("제목").setPreferredWidth(130);
		jt1.getColumn("발신인").setPreferredWidth(50);
		jt1.getColumn("발신인").setCellRenderer(celAlignCenter);
		jt1.getColumn("일자").setPreferredWidth(30);
		jt1.getColumn("일자").setCellRenderer(celAlignRight);
		jt1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt1.setFont(new Font("굴림", Font.PLAIN, 13));

		jt1.setRowHeight(25);

		this.setBackground(Color.WHITE);
		this.setLayout(null);
		jt2.getColumn("제목").setPreferredWidth(130);
		jt2.getColumn("수신인").setPreferredWidth(50);
		jt2.getColumn("수신인").setCellRenderer(celAlignCenter);
		jt2.getColumn("일자").setPreferredWidth(30);
		jt2.getColumn("일자").setCellRenderer(celAlignRight);
		jt2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt2.setFont(new Font("굴림", Font.PLAIN, 13));

		jt2.setRowHeight(25);

		this.setBackground(Color.WHITE);
		this.setLayout(null);
	}

	private void contents() {
		// 컨텐츠
		JLabel label = new JLabel("메시지 확인");
		label.setFont(new Font("굴림", Font.PLAIN, 13));
		label.setBounds(12, 12, 330, 28);
		add(label);

		JLabel label_1 = new JLabel("다른 기업과 주고받은 메시지를 확인할 수 있습니다.");
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

		btnSendMs = new RoundedButton("메시지 보내기");
		btnSendMs.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnSendMs.setBackground(SystemColor.menu);
		btnSendMs.setForeground(SystemColor.desktop);
		btnSendMs.setBounds(33, 383, 137, 34);
		add(btnSendMs);

		btnShowMs = new RoundedButton("메시지 보기");
		btnShowMs.setFont(new Font("굴림체", Font.PLAIN, 15));
		btnShowMs.setForeground(SystemColor.desktop);
		btnShowMs.setBackground(SystemColor.menu);
		btnShowMs.setBounds(196, 383, 137, 34);
		add(btnShowMs);
		btnrefresh.setBounds(281, 72, 77, 24);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(12, 78, 347, 289);
		add(tabbedPane);

	}

	private void showTable() {
		tm.getSendInquiry(dt1, userId);
		tm.getReciInquiry(dt2, userId);
		tabbedPane.addTab("보낸 메시지", null, jsp1, null);
		tabbedPane.setBackgroundAt(0, SystemColor.text);
		tabbedPane.addTab("받은 메시지", null, jsp2, null);

	}

	private void startActionListener() {
		btnSendMs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메시지 발송하는 다이얼로그 만들기
				pm.sendMessage(userId);
			}
		});

		btnrefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tm.getSendInquiry(dt1, userId);
				tm.getReciInquiry(dt2, userId);
				jt1.revalidate();
				jt2.revalidate();
			}
		});

		btnShowMs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int j = tabbedPane.getSelectedIndex();
				Inquiry inq = null;
				try {
					if (j == 0) {
						int i = jt1.getSelectedRow();
						List<Inquiry> list = tm.getMyIlist1();
						inq = list.get(i);
						pm.openMessage(userId, inq, 1);
					} else if (j == 1) {
						int i = jt2.getSelectedRow();
						List<Inquiry> list = tm.getMyIlist2();
						inq = list.get(i);
						pm.openMessage(userId, inq, 2);
//						is.readingInquiry(inq);
					}
				} catch (ArrayIndexOutOfBoundsException e2) {
					// 어떠한 메시지도 선택하지 않은 채 열라고 하는 행위
					// 무시한다.
				}
			}
		});

	}
}
