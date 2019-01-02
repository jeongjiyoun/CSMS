package csms.mapper;

import java.util.List;

import csms.vo.SharingGoods;

public interface SharingMapper {

	//공유받은 물건 목록 받아오기
	public List<SharingGoods> getShared(String userid);
	
	//공유한 물건 목록 받아오기
	public List<SharingGoods> getSharing(String userid);

	//공유한사람, 공유받은 사람, 공유받은 물건을 토대로 객체받기
	public SharingGoods findSgd(SharingGoods shares);

	//물건 입력
	public int insertSharing(SharingGoods goods);
	
	//물건 수정
	public void updateShares(SharingGoods shares);

	//물건 삭제
	public void deleteShares(SharingGoods shares);



}
