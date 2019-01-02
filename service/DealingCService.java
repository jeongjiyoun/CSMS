package csms.service;

import java.util.ArrayList;
import java.util.Map;

import csms.dao.DealingCDAO;
import csms.manager.MapManager;
import csms.vo.DealingCompany;

public class DealingCService {
	private DealingCDAO ddao = new DealingCDAO();
	private MapManager mm = new MapManager();

	// 파는 거래중인 기업 목록
	public ArrayList<DealingCompany> getDealing(String userId) {
		ArrayList<DealingCompany> result = null;
		result = ddao.getDealing(userId);
		return result;
	}

	// 사는 거래중인 기업목록
	public ArrayList<DealingCompany> getDealed(String userId) {
		ArrayList<DealingCompany> result = null;
		result = ddao.getDealed(userId);
		return result;
	}

	// 거래 기업 수
	public int countDeal(String userId) {
		int result = 0;
		ArrayList<DealingCompany> result1 = ddao.getDealed(userId);
		ArrayList<DealingCompany> result2 = ddao.getDealing(userId);
		int dub = 0;
		for (DealingCompany dealingCompany : result2) {
			for (DealingCompany dealingCompany2 : result1) {
				if (dealingCompany.getDcidFrom().equals(dealingCompany2.getDcidTo())
						&& dealingCompany.getDcidTo().equals(dealingCompany2.getDcidFrom())) {
					dub++;
				}
			}
		}
		result = result1.size() + result2.size() - dub;
		return result;
	}

	// 기업 삭제
	public void deleteDeal(String fromname, String toname) {
		Map<String, String> map = mm.MakeMap(fromname, toname, "DCIDFROM", "DCIDTO");
		ddao.deleteDeal(map);
	}

	// 기업 추가
	public void addCom(String fromname, String toname) {
		Map<String, String> map = mm.MakeMap(fromname, toname, "DCIDFROM", "DCIDTO");
		ddao.addDeal(map);
	}

}
