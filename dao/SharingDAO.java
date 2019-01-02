package csms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import csms.mapper.SharingMapper;
import csms.vo.SharingGoods;

public class SharingDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	/*Sharing DAO
	테이블 : SHARING

	순서 : Select - Insert - Update - Delete
	주석 표기방법
	  -MAPPER에서의 ID가 메소드명과 동일하지 않은 경우만 표기한다.
	  -사용하는 SIUD를 가장 앞에 위치.
	  -기능 설명 작성.
	  -소괄호를 사용해 테이블명을 적되, 두 테이블을 조인하여 사용하는 경우에는 SHARING를 앞에 표기함
	  -그 외 설명은 다른 줄로 새롭게 작성
	*/

//SELECT
	//SELECT SHARED GOODS (SHARES, GOODS)
	public List<SharingGoods> getShared(String userId) {
		SqlSession session = null;
		List<SharingGoods> result = null;
		try {
			session = factory.openSession();
			SharingMapper mapper = session.getMapper(SharingMapper.class);
			result = mapper.getShared(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	//SELECT SHARING GOODS(SHARES, GOODS)
	public List<SharingGoods> getSharing(String userid) {
		SqlSession session = null;
		List<SharingGoods> result = null;
		try {
			session = factory.openSession();
			SharingMapper mapper = session.getMapper(SharingMapper.class);
			result = mapper.getSharing(userid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	//SELECT SHAREGOODS(SHARES, GOODS)
	// 공유한사람, 공유받은 사람, 공유받은 물건을 토대로 객체받기
	public SharingGoods findSgd(SharingGoods shares) {
		SqlSession session = null;
		SharingGoods result = null;
		try {
			session = factory.openSession();
			SharingMapper mapper = session.getMapper(SharingMapper.class);
			result = mapper.findSgd(shares);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}
	
//INSERT
	//INSERT SHAREING(SHARES)
	public int insertShares(SharingGoods goods) {
		SqlSession session = null;
		int result = 0;
		try {
			session = factory.openSession();
			SharingMapper mapper = session.getMapper(SharingMapper.class);
			result = mapper.insertSharing(goods);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
//UPDATE
	//UPDATE SHARING(SHARES)
	public boolean updateShares(SharingGoods shares) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			SharingMapper mapper = session.getMapper(SharingMapper.class);
			mapper.updateShares(shares);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return false;
	}

//DELETE
	//DELETE SHARES(SHARES)
	//공유받은 물건과 공유한 물건 모두 이 메소드를 사용
	public void deleteShares(SharingGoods shares) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			SharingMapper mapper = session.getMapper(SharingMapper.class);
			mapper.deleteShares(shares);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
