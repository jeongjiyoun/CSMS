package csms.mapper;

import java.util.List;

import csms.vo.Goods;

public interface GoodsMapper {

	//내상품 모두 받기
	public List<Goods> getMyGoods(String userid);

	//상품번호로 물건 있는지 여부 반환
	public int findGid(String gid);

	//상품번호로 물건 반환
	public Goods getGoods(String gid);

	//상품 입력
	public int insertGoods(Goods goods);

	//상품 수정
	public void updateInfo(Goods goods);

	//상품 삭제
	public void deleteGoods(Goods goods);

}
