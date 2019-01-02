package csms.service;

import java.util.List;

import csms.dao.InquiryDAO;
import csms.vo.Inquiry;

public class InquiryService {
	InquiryDAO idao = new InquiryDAO();

	// 보낸 메시지 리스트
	public List<Inquiry> getSendInquiry(String userId) {
		List<Inquiry> result = null;
		result = idao.getSendInquiry(userId);
		return result;
	}

	// 받은 메시지 리스트
	public List<Inquiry> getReciInquiry(String userId) {
		List<Inquiry> result = null;
		result = idao.getReciInquiry(userId);
		return result;
	}

	// 메시지 찾기
	public int findInquiry(Inquiry inq) {
		int result = 0;
		result = idao.findInquiry(inq);
		return result;
	}

	// 메시지 작성
	public void insertInquiry(Inquiry inq) {
		idao.insertInquiry(inq);
	}

	// 읽지 않은 메시지 수
	public int unReadIn(String userId) {
		int result = 0;
		result = idao.unReadInquiry(userId);
		return result;
	}

	//메시지 읽음 표시
	public void readingInquiry(Inquiry inq) {
		idao.readingInquiry(inq);
	}
}
