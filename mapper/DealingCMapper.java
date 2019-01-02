package csms.mapper;

import java.util.ArrayList;
import java.util.Map;

import csms.vo.DealingCompany;

public interface DealingCMapper {

	//파는 거래중인 기업 목록
	public ArrayList<DealingCompany> getDealing(String userId);

	//사는 거래중인 기업목록
	public ArrayList<DealingCompany> getDealed(String userId);

	//기업 삭제
	public void deleteDeal(Map<String, String> map);

	//기업 추가
	public void addDeal(Map<String, String> map);


}
