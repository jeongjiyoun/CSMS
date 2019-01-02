package csms.mapper;

import java.util.List;

import csms.vo.Inquiry;

public interface InquiryMapper {
	// 보낸 메시지 리스트
	public List<Inquiry> getSendInquiry(String userId);

	// 받은 메시지 리스트
	public List<Inquiry> getReciInquiry(String userId);

	// 메시지 찾기
	public int findInquiry(Inquiry inq);

	// 메시지 작성
	public void insertInquiry(Inquiry inq);

	// 읽지 않은 메시지수
	public int unReadInquiry(String userId);

	// 읽음 표시로 바꾸기
	public void readingInquiry(Inquiry inq);


}
