package csms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import csms.mapper.CompanyMapper;
import csms.vo.Company;

/*Company DAO
테이블 : COMPANY, COMPANYDATA
ID/PW/가입여부 확인 처리를 빠르게 하기 위해 테이블 분리,
두 테이블은 ID로 연결되어있음.

순서 : Select - Insert - Update - Delete
주석 표기방법
  -MAPPER에서의 ID가 메소드명과 동일하지 않은 경우만 표기한다.
  -사용하는 SIUD를 가장 앞에 위치.
  -기능 설명 작성.
  -소괄호를 사용해 테이블명을 적되, 두 테이블을 조인하여 사용하는 경우에는 COMPANY를 앞에 표기함
  -그 외 설명은 다른 줄로 새롭게 작성
*/

public class CompanyDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

// SELECT

	// SELECT ID(COMPANY)
	// 아이디의 생성 가능 여부를 확인함.
	// TRUE인 경우 현재 아이디가 없다는 의미, FALSE인 경우 아이디가 있다는 의미
	public int idCheck(String id) {
		SqlSession session = null;
		int k = 0;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			k = mapper.idCheck(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return k;

	}

	// SELECT LOGINCHECK(COMPANY)
	// 일치시 TRUE, 그렇지 않으면 false
	public int passCheck(Map<String, String> map) {
		SqlSession session = null;
		int k = 0;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			k = mapper.passCheck(map);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return k;
	}

	// SELECT REGISTERNUMBER CHECK(COMPANY)
	// 가입 중복여부 체크, 있으면 FALSE, 없으면 TRUE
	public int regiNumCheck(String reginum) {
		SqlSession session = null;
		int k = 0;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			k = mapper.regiNumCheck(reginum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return k;

	}

	// SELECT COMPANY BY ID(COMPANY,COMPANYDATA)
	public Company getCompanyInfo(String cid) {
		SqlSession session = null;
		Company user = null;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			user = mapper.getCompanyInfo(cid);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return user;
	}

	// SELECT COMPANY BY NAME(COMPANY, COMPANYDATA)
	public List<Company> searchbyName(String cName) {
		SqlSession session = null;
		List<Company> userlist = null;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			userlist = mapper.searchbyName(cName);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return userlist;
	}

	// SELECT COMPANY BY REGISTERNUMBER(COMPANY, COMPANYDATA)
	public Company searchByReginum(String creginum) {
		SqlSession session = null;
		Company company = null;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			company = mapper.searchByReginum(creginum);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return company;
	}

	// SELECT COMPANY BY TEL(COMPANY, COMPANYDATA)
	public List<Company> searchByTel(String ctel) {
		SqlSession session = null;
		List<Company> userlist = null;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			userlist = mapper.searchByTel(ctel);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return userlist;
	}

	// SELECT COMPANY BY CATEGORY(COMPANY, COMPANYDATA, CATEGORYS)
	public List<Company> searchByCate(int ctype) {
		SqlSession session = null;
		List<Company> userlist = null;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			userlist = mapper.searchByCate(ctype);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return userlist;
	}

	// SELECT ID(COMPANY)
	// 아이디 찾는 구문으로 반환값이 다름
	public String findId(Map<String, String> map) {
		SqlSession session = null;
		String result = null;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			result = mapper.findId(map);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	// SELECT PW (COMPANY)
	public int findPw(Map<String, String> map) {
		SqlSession session = null;
		int i = 0;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			i = mapper.findPw(map);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return i;

	}

//INSERT
	// Insert COMPANY (COMPANY)
	public int insertUser1(Company user) {
		SqlSession session = null;
		int result = 0;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			result = mapper.insertUser1(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	// INSERT COMPANY (COMPANYDATA)
	public int insertUser2(Company user) {
		SqlSession session = null;
		int result = 0;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			result = mapper.insertUser2(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

//UPDATE
	// UPDATE PW(COMPANYDATA)
	// ID와 사업자등록번호(REGINUM)은 변경 불가하므로 PW변경만 이루어짐
	public void updatePass(Map<String, String> map) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			mapper.updatePass(map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	// UPDATE (COMPANYDATA)
	public void updateInfo(Company user) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			mapper.updateInfo(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

//DELETE
	// DELETE COMPANY (COMPANY)
	// CASCADE DELETE에 의해 COMPANYDATA 자료도 삭제됨
	public void deleteUser(String id) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			mapper.deleteUser(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
