package csms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import csms.mapper.CategoryMapper;

public class CategoryDAO {
	/*
	 * Category DAO
	 * 테이블 : CATEGORYL, CATEGORYS
	 * SELECT만 사용
	 * -MAPPER에서의 ID가 메소드명과 동일하지 않은 경우만 표기한다.
	 * -사용하는 SIUD를 가장 앞에 위치.
	 * -기능 설명 작성.
	 * -소괄호를 사용해 테이블명을 작성
	 * -상세한 설명은 다른 줄로 새롭게 작성
	 */
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

//SELECT
	// SELECT LARGE CATEGORY(CATEGORYL)
	public List<String> getLCateInfo() {
		SqlSession session = null;
		List<String> result = null;
		try {
			session = factory.openSession();
			CategoryMapper mapper = session.getMapper(CategoryMapper.class);
			result = mapper.getLCateInfo();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	// SELECT SMALL CATEGORY(CATEGORYS, CATEGORYL)
	public List<String> getSCateInfo(String lcateInfo) {
		SqlSession session = null;
		List<String> result = null;
		try {
			session = factory.openSession();
			CategoryMapper mapper = session.getMapper(CategoryMapper.class);
			result = mapper.getSCateInfo(lcateInfo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	// SELECT CTYPE(CATEGORYS)
	public int getCtype(String tscatename) {
		SqlSession session = null;
		int result = 0;
		try {
			session = factory.openSession();
			CategoryMapper mapper = session.getMapper(CategoryMapper.class);
			result = mapper.getCtype(tscatename);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}
}
