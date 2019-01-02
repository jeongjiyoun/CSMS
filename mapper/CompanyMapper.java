package csms.mapper;

import java.util.List;
import java.util.Map;

import csms.vo.Company;

public interface CompanyMapper {

	// id정보 체크
	public int idCheck(String id);

	// 비밀번호 체크함
	public int passCheck(Map<String, String> map);

	// 사업자번호 중복 체크
	public int regiNumCheck(String reginum);

	// 회원 정보 전체 가져오기
	public Company getCompanyInfo(String cid);

	// 회사명(와일드카드)으로 회사 검색하기
	public List<Company> searchbyName(String cName);

	// 회사 검색 사업자번호
	public Company searchByReginum(String creginum);

	// 회사 검색 전화번호
	public List<Company> searchByTel(String ctel);

	// 다른 회사 검색 기능-4 업종
	public List<Company> searchByCate(int ctype);

	// ID찾기
	public String findId(Map<String, String> map);

	// PW찾기
	public int findPw(Map<String, String> map);

	// company 테이블 정보 저장
	public int insertUser1(Company user);

	// companydata 테이블 정보 저장
	public int insertUser2(Company user);

	// 비밀번호 정보변경
	public void updatePass(Map<String, String> map);

	// 비밀번호 이외의 정보 변경
	public void updateInfo(Company user);

	// 회원 삭제
	public void deleteUser(String id);

}
