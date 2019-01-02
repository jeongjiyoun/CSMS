package csms.service;

import java.util.List;

import csms.dao.CategoryDAO;
import csms.manager.MapManager;

public class CategoryService {
	CategoryDAO gdao = new CategoryDAO();
	MapManager mm = new MapManager();

	// 대분류 받아오기
	public List<String> getLCateInfo() {
		List<String> result = gdao.getLCateInfo();
		return result;
	}

	// 소분류 받아오기
	public List<String> getSCateInfo(String lcateInfo) {
		List<String> result = gdao.getSCateInfo(lcateInfo);
		return result;
	}

	// Ctype 찾아오기
	public int getCtype(String tScatename) {
		int result = gdao.getCtype(tScatename);
		return result;
	}

}
