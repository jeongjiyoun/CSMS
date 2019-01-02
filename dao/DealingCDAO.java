package csms.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import csms.mapper.DealingCMapper;
import csms.vo.DealingCompany;

public class DealingCDAO {
	/*
	 * DEALING COMPANY DAO 
	 * 테이블 : DEALCOMPANY 
	 * 
	 * 순서 : Select - Insert - Update - Delete
	 * -MAPPER에서의 ID가 메소드명과 동일하지 않은 경우만 표기한다. 
	 * -사용하는 SIUD를 가장 앞에 위치. 
	 * -기능 설명 작성. 
	 * -소괄호를 사용해 테이블명을 작성 
	 * -그 외 설명은 다른 줄로 새롭게 작성
	 */
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// SELECT BUYINGCOMPANY(DEALCOMPANY)
	public ArrayList<DealingCompany> getDealing(String userId) {
		SqlSession session = null;
		ArrayList<DealingCompany> result = null;
		try {
			session = factory.openSession();
			DealingCMapper mapper = session.getMapper(DealingCMapper.class);
			result = mapper.getDealing(userId);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	// SELECT SELLINGCOMPANY(DEALCOMPANY)
	public ArrayList<DealingCompany> getDealed(String userId) {
		SqlSession session = null;
		ArrayList<DealingCompany> result = null;
		try {
			session = factory.openSession();
			DealingCMapper mapper = session.getMapper(DealingCMapper.class);
			result = mapper.getDealed(userId);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	// DELETE COMPANY(DEALCOMPANY)
	public void deleteDeal(Map<String, String> map) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			DealingCMapper mapper = session.getMapper(DealingCMapper.class);
			mapper.deleteDeal(map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void addDeal(Map<String, String> map) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			DealingCMapper mapper = session.getMapper(DealingCMapper.class);
			mapper.addDeal(map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
