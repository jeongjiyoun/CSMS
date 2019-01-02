package csms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import csms.mapper.InquiryMapper;
import csms.vo.Inquiry;

public class InquiryDAO {

	/*
	 INQUIRY DAO
	 테이블 : INQUIRY
	 순서 : Select - Insert - Update - Delete
	 주석 표기방법
	 -MAPPER에서의 ID가 메소드명과 동일하지 않은 경우만 표기한다.
	 -사용하는 SIUD 명칭을 가장 앞에 위치.
	 -기능 설명 작성은 짧게.
	 -테이블은 소괄호를 사용해 적되, 조인하는 테이블을 INQUIRY 뒤에 표기함
	 -그 외 설명은 다른 줄로 새롭게 작성
	 */

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

//SELECT
	// SELECT SEND INQUIRY(INQUIRY)
	public List<Inquiry> getSendInquiry(String userId) {
		SqlSession session = null;
		List<Inquiry> result = null;
		try {
			session = factory.openSession();
			InquiryMapper mapper = session.getMapper(InquiryMapper.class);
			result = mapper.getSendInquiry(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	// SELECT RECEIVE INQUIRY(INQUIRY)
	public List<Inquiry> getReciInquiry(String userId) {
		SqlSession session = null;
		List<Inquiry> result = null;
		try {
			session = factory.openSession();
			InquiryMapper mapper = session.getMapper(InquiryMapper.class);
			result = mapper.getReciInquiry(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	// SELECT FIND INQUIRY(INQUIRY)
	public int findInquiry(Inquiry inq) {
		SqlSession session = null;
		int result = 0;
		try {
			session = factory.openSession();
			InquiryMapper mapper = session.getMapper(InquiryMapper.class);
			result = mapper.findInquiry(inq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

//INSERT
	// INSERT INQUIRY(INQUIRY)
	public void insertInquiry(Inquiry inq) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			InquiryMapper mapper = session.getMapper(InquiryMapper.class);
			mapper.insertInquiry(inq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	//SELECT UNREAD(INQUIRY)
	public int unReadInquiry(String userId) {
		SqlSession session = null;
		int temp = 0;
		try {
			session = factory.openSession();
			InquiryMapper mapper = session.getMapper(InquiryMapper.class);
			temp = mapper.unReadInquiry(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return temp;
	}

//UPDATE
	// UPDATE INQUIRY SEE(INQUIRY)
	public void readingInquiry(Inquiry inq) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			InquiryMapper mapper = session.getMapper(InquiryMapper.class);
			mapper.readingInquiry(inq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
