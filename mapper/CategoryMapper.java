package csms.mapper;

import java.util.ArrayList;

public interface CategoryMapper {

	// 대분류 받아오기
	public ArrayList<String> getLCateInfo();

	// 소분류 받아오기
	public ArrayList<String> getSCateInfo(String lcateInfo);

	// Ctype 찾아오기
	public int getCtype(String tscatename);

}
