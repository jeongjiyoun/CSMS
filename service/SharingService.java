package csms.service;

import java.util.List;

import csms.dao.SharingDAO;
import csms.vo.SharingGoods;

public class SharingService {
	SharingDAO sdao = new SharingDAO();
	DealingCService ds = new DealingCService();

	// 공유받은 물건 목록 받아오기
	public List<SharingGoods> getShared(String userId) {
		List<SharingGoods> result = sdao.getShared(userId);
		return result;
	}

	// 공유한 물건 목록 받아오기
	public List<SharingGoods> getSharing(String userId) {
		List<SharingGoods> result = sdao.getSharing(userId);
		return result;
	}

	// 공유한사람, 공유받은 사람, 공유받은 물건을 토대로 객체받기
	public SharingGoods findSgd(SharingGoods shares) {
		SharingGoods result = sdao.findSgd(shares);
		return result;
	}

	// 물건 입력
	public boolean insertSharing(SharingGoods goods) {
		boolean result = false;
		int temp = sdao.insertShares(goods);
		if (temp == 1) {
			result = true;
		}
		return result;
	}

	// 공유정보 수정
	public boolean updateShares(SharingGoods shares) {
		boolean result = false;
		if (findSgd(shares) != null) {
			sdao.updateShares(shares);
			result = true;
		}
		return result;
	}

	// 공유 삭제
	public boolean deleteShares(SharingGoods shares) {
		boolean result = false;
		if (findSgd(shares) != null) {
			sdao.updateShares(shares);
			result = true;
		}
		return result;
	}

}
