package csms.manager;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import csms.service.CompanyService;
import csms.service.DealingCService;
import csms.service.GoodsService;
import csms.service.InquiryService;
import csms.service.SharingService;
import csms.vo.Company;
import csms.vo.DealingCompany;
import csms.vo.Goods;
import csms.vo.Inquiry;
import csms.vo.SharingGoods;

//테이블 관련 데이터 처리

public class TableManager {
	private GoodsService gs = new GoodsService();
	private SharingService ss = new SharingService();
	private CompanyService cs = new CompanyService();
	private InquiryService is = new InquiryService();
	private DealingCService ds = new DealingCService();

	private List<Goods> myGlist = null;
	private List<SharingGoods> mySlist = null;
	private List<Inquiry> myIlistR = null;
	private List<Inquiry> myIlistS = null;
	private List<DealingCompany> list = null;

	public DefaultTableModel getMyGoods(DefaultTableModel dmodel, String userId) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		} // 데이터가 들어있다면 모조리 삭제

		myGlist = gs.getMyGoods(userId);
		for (Goods goods : myGlist) {
			String cid = goods.getGid();
			String name = goods.getgName();
			String price = String.format("%,d", goods.getgPrice());
			String stock = String.format("%,d", goods.getgStock());
			Object[] row = { cid, name, price, stock };
			dmodel.addRow(row); // 한줄씩 데이터 추가
		}
		return dmodel;
	}

	public String getSpGoods(int i) {
		String gid = myGlist.get(i).getGid();
		return gid;

	}

	public DefaultTableModel getSharingGoods(DefaultTableModel dmodel, String userId) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		} // 데이터가 들어있다면 모조리 삭제

		mySlist = ss.getSharing(userId);
		for (SharingGoods goods : mySlist) {
			String cid = goods.getsCto();
			String name = goods.getgName();
			String price = String.format("%,d", goods.getgPrice());
			String stock = String.format("%,d", goods.getgStock());
			Object[] row = { cid, name, price, stock };

			dmodel.addRow(row); // 한줄씩 데이터 추가
		}
		return dmodel;
	}

	public DefaultTableModel getsharedGoods(DefaultTableModel dt2, String userId) {
		for (int i = 0; i < dt2.getRowCount();) {
			dt2.removeRow(0);
		} // 데이터가 들어있다면 모조리 삭제

		mySlist = ss.getShared(userId);
		for (SharingGoods goods : mySlist) {
			String cid = goods.getsCfrom();
			String name = goods.getgName();
			String price = String.format("%,d", goods.getgPrice());
			String stock = String.format("%,d", goods.getgStock());
			Object[] row = { cid, name, price, stock };

			dt2.addRow(row); // 한줄씩 데이터 추가
		}
		return dt2;

	}

	public DefaultTableModel getSendInquiry(DefaultTableModel dmodel, String userId) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		} // 데이터가 들어있다면 모조리 삭제

		myIlistS = is.getSendInquiry(userId);
		for (Inquiry inq : myIlistS) {
			String cto = inq.getIcTo();
			String ititle = inq.getiTitle();
			String idate = inq.getIdate().substring(0, 10);
			Object[] row = { ititle, cto, idate };

			dmodel.addRow(row); // 한줄씩 데이터 추가
		}
		return dmodel;
	}

	public DefaultTableModel getReciInquiry(DefaultTableModel dmodel, String userId) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		} // 데이터가 들어있다면 모조리 삭제

		myIlistR = is.getReciInquiry(userId);
		for (Inquiry inq : myIlistR) {
			String cfrom = inq.getIcFrom();
			String ititle = inq.getiTitle();
			String idate = inq.getIdate().substring(0, 10);
			Object[] row = { ititle, cfrom, idate };
			dmodel.addRow(row); // 한줄씩 데이터 추가
		}
		return dmodel;
	}

	public Inquiry getInquiry(String s1, String s2, String s3) {
		Inquiry result = null;
		for (Inquiry inq : myIlistS) {
			if (inq.getIcTo().equals(s2) && inq.getiTitle().equals(s1) && inq.getIcontents().equals(s3)) {
				result = inq;
			}
		}
		return result;
	}

	public List<Inquiry> getMyIlist2(String userId) {
		myIlistR = is.getReciInquiry(userId);
		return myIlistR;
	}

	public List<Inquiry> getMyIlist2() {
		return myIlistR;
	}

	public List<Inquiry> getMyIlist1(String userId) {
		myIlistS = is.getSendInquiry(userId);
		return myIlistS;
	}

	public List<Inquiry> getMyIlist1() {
		return myIlistS;
	}

	public DefaultTableModel getDealCompany(DefaultTableModel dmodel, String userId) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		} // 데이터가 들어있다면 모조리 삭제

		list = ds.getDealing(userId);
		for (DealingCompany dealingCompany : list) {
			String cto = dealingCompany.getDcidTo();
			int count = 0;
			List<SharingGoods> b = ss.getSharing(userId);
			for (int i = 0; i < b.size(); i++) {
				if (b.get(i).getsCto().equals(cto)) {
					count++;
				}
			}
			String tel = cs.getCompanyInfo(cto).getCtel();
			Object[] row = { cto, tel, count };
			dmodel.addRow(row); // 한줄씩 데이터 추가
		}
		return dmodel;
	}

	public DefaultTableModel getDealedCompany(DefaultTableModel dmodel, String userId) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		} // 데이터가 들어있다면 모조리 삭제

		list = ds.getDealed(userId);
		// 공유받은 기업리스트를 받아온다.
		for (DealingCompany dealingCompany : list) {
			String cfrom = dealingCompany.getDcidFrom();
			int count = 0;

			List<SharingGoods> b = ss.getShared(userId);
			for (int i = 0; i < b.size(); i++) {
				if (b.get(i).getsCfrom().equals(cfrom)) {
					count++;
				}
			}
			String tel = cs.getCompanyInfo(cfrom).getCtel();
			Object[] row = { cfrom, tel, count };
			dmodel.addRow(row); // 한줄씩 데이터 추가
		}
		return dmodel;
	}

	public List<DealingCompany> getDC(String userId) {
		List<DealingCompany> result = null;
		result = ds.getDealing(userId);
		return result;

	}

	public DefaultTableModel searchbyname(DefaultTableModel dmodel, String cName) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		} // 데이터가 들어있다면 모조리 삭제
		List<Company> list = new ArrayList<>();
		list = cs.searchbyName(cName);
		for (Company company : list) {
			String name = company.getCname();
			String id = company.getCid();
			String comment = company.getCcomment();
			Object[] row = { name, id, comment };
			dmodel.addRow(row); // 한줄씩 데이터 추가
		}
		return dmodel;
	}

	public DefaultTableModel searchByTel(DefaultTableModel dmodel, String ctel) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		} // 데이터가 들어있다면 모조리 삭제
		List<Company> list = new ArrayList<>();
		list = cs.searchByTel(ctel);
		for (Company company : list) {
			String name = company.getCname();
			String id = company.getCid();
			String comment = company.getCcomment();
			Object[] row = { name, id, comment };
			dmodel.addRow(row); // 한줄씩 데이터 추가
		}
		return dmodel;
	}

	public DefaultTableModel searchByReginum(DefaultTableModel dmodel, String creginum) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		} // 데이터가 들어있다면 모조리 삭제
		Company company = new Company();
		company = cs.searchbyReginum(creginum);
		String name = company.getCname();
		String id = company.getCid();
		String comment = company.getCcomment();
		Object[] row = { name, id, comment };
		dmodel.addRow(row); // 한줄씩 데이터 추가
		return dmodel;
	}

	public DefaultTableModel searchByCate(DefaultTableModel dmodel, String tLcatename, String tScatename) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		} // 데이터가 들어있다면 모조리 삭제
		List<Company> list = new ArrayList<>();
		list = cs.searchByCate(tLcatename, tScatename);
		for (Company company : list) {
			String name = company.getCname();
			String id = company.getCid();
			String comment = company.getCcomment();
			Object[] row = { name, id, comment };
			dmodel.addRow(row); // 한줄씩 데이터 추가
		}
		return dmodel;
	}

	public DefaultTableModel getRegi(DefaultTableModel dmodel, String creginum) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		}
		Company company = cs.searchbyReginum(creginum);
		String cname = company.getCname();
		String cid = company.getCid();
		String ccomment = company.getCcomment();
		Object[] row = { cname, cid, ccomment };
		dmodel.addRow(row); // 한줄씩 데이터 추가
		return dmodel;
	}

	public DefaultTableModel getName(DefaultTableModel dmodel, String name) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		}
		List<Company> company = cs.searchbyName(name);
		for (Company company2 : company) {
			String cname = company2.getCname();
			String cid = company2.getCid();
			String ccomment = company2.getCcomment();
			Object[] row = { cname, cid, ccomment };
			dmodel.addRow(row); // 한줄씩 데이터 추가
		}
		return dmodel;
	}

	public DefaultTableModel getTel(DefaultTableModel dmodel, String ctel) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		}
		List<Company> company = cs.searchByTel(ctel);
		for (Company company2 : company) {
			String cname = company2.getCname();
			String cid = company2.getCid();
			String ccomment = company2.getCcomment();
			Object[] row = { cname, cid, ccomment };
			dmodel.addRow(row); // 한줄씩 데이터 추가
		}
		return dmodel;
	}

	public DefaultTableModel getCate(DefaultTableModel dmodel, String tLcatename, String tScatename) {
		for (int i = 0; i < dmodel.getRowCount();) {
			dmodel.removeRow(0);
		}
		List<Company> company = cs.searchByCate(tLcatename, tScatename);
		for (Company company2 : company) {
			String cname = company2.getCname();
			String cid = company2.getCid();
			String ccomment = company2.getCcomment();
			Object[] row = { cname, cid, ccomment };
			dmodel.addRow(row); // 한줄씩 데이터 추가
		}
		return dmodel;
	}

}