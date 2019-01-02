package csms.service;

import java.util.List;

import csms.dao.GoodsDAO;
import csms.vo.Goods;

public class GoodsService {
	GoodsDAO gdao = new GoodsDAO();

	// 내상품 모두 받기
	public List<Goods> getMyGoods(String userid) {
		List<Goods> result = null;
		result = gdao.getMyGoods(userid);
		return result;
	}

	// 상품번호로 물건 있는지 여부 반환
	public boolean findGid(String gid) {
		boolean result = false;
		int temp = gdao.findGid(gid);
		if (temp == 1) {
			result = true;
		}
		return result;
	}

	// 상품번호로 물건 반환
	public Goods getGoods(String gid) {
		Goods result = gdao.getGoods(gid);
		return result;
	}

	// 상품 입력
	public boolean insertGoods(Goods goods) {
		boolean result = false;
		int temp = gdao.insertGoods(goods);
		if (temp == 1) {
			result = true;
		}
		return result;
	}

	// 상품 수정
	public boolean updateGoods(Goods goods) {
		boolean result = false;
		if (findGid(goods.getGid())) { 
			//만일 삭제한 물건을 새로고침하기 전에 다시 수정할 때를 걸러줌
			gdao.updateGoods(goods);
			result = true;
		}
		return result;
	}

	// 상품 삭제
	public boolean deleteGoods(Goods goods) {
		boolean result = false;
		//만일 삭제한 물건을 새로고침하기 전에 다시 삭제할 때를 걸러줌
		if (findGid(goods.getGid())) { 
			gdao.deleteGoods(goods);
			result = true;
		}
		return result;
	}

}
