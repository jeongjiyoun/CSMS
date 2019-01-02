package csms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import csms.mapper.GoodsMapper;
import csms.vo.Goods;

public class GoodsDAO {

	/*
	 * Goods DAO 테이블 : Goods 순서 : Select - Insert - Update - Delete
	 * 
	 * 주석 표기방법 
	 * -MAPPER에서의 ID가 메소드명과 동일하지 않은 경우만 표기한다. 
	 * -사용하는 SIUD 명칭을 가장 앞에 위치. 
	 * -기능 설명 작성은 짧게. 
	 * -테이블명은 소괄호를 사용해 적되, 조인하는 테이블을 GOODS 뒤에 표기함 
	 * -그 외 설명은 다른 줄로 새롭게 작성
	 */

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// SELECT MY GOODS ALL (GOODS)
	public List<Goods> getMyGoods(String userid) {
		SqlSession session = null;
		List<Goods> result = null;
		try {
			session = factory.openSession();
			GoodsMapper mapper = session.getMapper(GoodsMapper.class);
			result = mapper.getMyGoods(userid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	// SELECT GoodsID(GOODS)
	// GOODS테이블의 PK(GID)의 중복 여부 확인
	public int findGid(String gid) {
		SqlSession session = null;
		int temp = 0;
		try {
			session = factory.openSession();
			GoodsMapper mapper = session.getMapper(GoodsMapper.class);
			temp = mapper.findGid(gid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return temp;
	}

	// SELECT GOODS(GOODS)
	// GOODSID로 GOODS정보 가져옮
	public Goods getGoods(String gid) {
		SqlSession session = null;
		Goods result = null;
		try {
			session = factory.openSession();
			GoodsMapper mapper = session.getMapper(GoodsMapper.class);
			result = mapper.getGoods(gid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

//INSERT
	// INSERT GOODS(GOODS)
	public int insertGoods(Goods goods) {
		SqlSession session = null;
		int temp = 0;
		try {
			session = factory.openSession();
			GoodsMapper mapper = session.getMapper(GoodsMapper.class);
			temp = mapper.insertGoods(goods);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

//UPDATE
	// UPDATE GOODS(GOODS)
	public void updateGoods(Goods goods) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			GoodsMapper mapper = session.getMapper(GoodsMapper.class);
			mapper.updateInfo(goods);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

//DELETE
	// DELETE GOODS(GOODS)
	public void deleteGoods(Goods goods) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			GoodsMapper mapper = session.getMapper(GoodsMapper.class);
			mapper.deleteGoods(goods);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
