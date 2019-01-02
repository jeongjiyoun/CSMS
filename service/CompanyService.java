package csms.service;

import java.util.List;
import java.util.Map;

import csms.dao.CategoryDAO;
import csms.dao.CompanyDAO;
import csms.manager.MapManager;
import csms.vo.Company;

public class CompanyService {
	CompanyDAO cdao = new CompanyDAO();
	CategoryDAO gdao = new CategoryDAO();
	MapManager mm = new MapManager();

	// id정보 확인
	public boolean idCheck(String id) {
		boolean result = false;
		int k = cdao.idCheck(id);
		if (k == 1) {
			result = true;
		}
		return result;
	}

	// 비밀번호 확인
	public boolean passCheck(String cid, String cpw) {
		Map<String, String> map = mm.MakeMap(cid, cpw, "cid", "cpw");
		boolean result = false;
		int k = cdao.passCheck(map);

		if (k == 1) {
			result = true;
		}
		return result;
	}

	// 사업자번호 중복 체크
	public boolean regiNumCheck(String reginum) {
		boolean result = false;
		int k = cdao.regiNumCheck(reginum);
		if (k == 1) {
			result = true;
		}
		return result;
	}

	// 회원 정보 전체 가져오기
	public Company getCompanyInfo(String cid) {
		Company result = cdao.getCompanyInfo(cid);
		return result;
	}

	// 회사명(와일드카드)으로 회사 검색하기
	public List<Company> searchbyName(String cName) {
		List<Company> result = cdao.searchbyName(cName);
		return result;
	}

	// 회사 검색 사업자번호
	public Company searchbyReginum(String creginum) {
		Company result = cdao.searchByReginum(creginum);
		return result;
	}

	// 회사 검색 전화번호
	public List<Company> searchByTel(String ctel) {
		List<Company> result = cdao.searchByTel(ctel);
		return result;
	}

	// 다른 회사 검색 기능-4 업종
	public List<Company> searchByCate(String tLcatename, String tScatename) {
//		Map<String, String> map = mm.MakeMap(tScatename, tLcatename, "tScatename", "tLcatename");
		int ctype = gdao.getCtype(tScatename);
		List<Company> result = cdao.searchByCate(ctype);
		return result;
	}

	// ID찾기
	public String findId(String cname, String ctel, String creginum) {
		Map<String, String> map = mm.MakeMap(cname, ctel, creginum, "cname", "ctel", "creginum");
		String result = cdao.findId(map);
		return result;
	}

	// PW찾기
	public boolean findPw(String cid, String ctel, String creginum) {
		boolean result = false;
		Map<String, String> map = mm.MakeMap(cid, ctel, creginum, "cid", "ctel", "creginum");
		int k = cdao.findPw(map);
		if (k == 1) {
			result = true;
		}
		return result;
	}

	public boolean insertUser(Company company) {
		boolean result = false;
		int i1 = cdao.insertUser1(company);
		int i2 = cdao.insertUser2(company);
		if (i1 == 1 && i2 == 1) {
			result = true;
		}
		return result;
	}

	// 비밀번호 정보변경
	public void updatePass(String cid, String cpw) {
		Map<String, String> map = mm.MakeMap(cid, cpw, "cid", "cpw");
		cdao.updatePass(map);
	}

	// 비밀번호 이외의 정보 변경
	public void updateInfo(Company company) {
		cdao.updateInfo(company);
	}

	// 회원 삭제
	public void deleteUser(String cid) {
		cdao.deleteUser(cid);
	}

}
