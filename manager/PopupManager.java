package csms.manager;

import java.awt.Dialog;

import csms.view.homeDial.ChangePw;
import csms.view.homeDial.OneMessage;
import csms.view.homeDial.OpenMessage;
import csms.view.homeDial.SendMessage;
import csms.view.homeDial.ShowComInfo;
import csms.view.homeDial.TwoMessage;
import csms.view.homeview.Tab2AdG;
import csms.view.homeview.Tab2UG;
import csms.view.homeview.Tab3AdS;
import csms.view.homeview.Tab3US;
import csms.view.homeview.Tab3USNotUp;
import csms.vo.Company;
import csms.vo.Goods;
import csms.vo.Inquiry;
import csms.vo.SharingGoods;

public class PopupManager {

	// 찾는 아이디 비번 실패
	public void failFind() {
		TwoMessage pop = new TwoMessage("해당하는 회원정보를 찾을 수 없습니다.", "정보를 다시 확인해주세요");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 가입을 성공하셨습니다. 팝업창
	public void sucJoin() {
		TwoMessage pop = new TwoMessage("가입이 완료되었습니다", "CSMS를 선택해주셔서 감사합니다.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 비밀번호 변경 성공알림창
	public void sucChanPw() {
		TwoMessage pop = new TwoMessage("고객님이 입력하신 비밀번호로 변경되었습니다.", "다시 한번 로그인 해주세요.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 비밀번호 변경창
	public void changePw(String cid) {
		ChangePw pop = new ChangePw(cid);
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 입력한 두 비밀번호가 일치하지 않음
	public void pwNotEqual() {
		TwoMessage pop = new TwoMessage("비밀번호의 값이 일치하지 않습니다.", "다시 입력해주세요.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 삭제 성공창
	public void sucDel() {
		OneMessage pop = new OneMessage("성공적으로 삭제되었습니다.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 중복삭제
	public void failDel() {
		TwoMessage tab = new TwoMessage("이미 삭제되었습니다.", "새로고침을 해주세요.");
		tab.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		tab.setVisible(true);
	}

	// 등록에 성공함
	public void sucAdd() {
		OneMessage pop = new OneMessage("성공적으로 등록되었습니다");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 등록에 성공함
	public void sucSAdd() {
		OneMessage pop = new OneMessage("성공적으로 공유하였습니다.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 수정에 성공함
	public void sucUpdate() {
		OneMessage pop = new OneMessage("성공적으로 수정되었습니다");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 재고가 숫자가 아닌 경우
	public void notSNum() {
		OneMessage pop = new OneMessage("재고는 반드시 숫자로 입력해주세요");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 가격이 숫자가 아닌경우
	public void notPNum() {
		OneMessage pop = new OneMessage("가격은 반드시 숫자로 입력해주세요");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 회사 이름이 공란인경우
	public void notNullName() {
		OneMessage pop = new OneMessage("회사 이름은 공란일 수 없습니다");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 이름이 공란인 경우
	public void nulName() {
		OneMessage pop = new OneMessage("상품명은 공란일 수 없습니다");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 전화번호 입력 이상
	public void showTelRule() {
		OneMessage pop = new OneMessage("전화번호를 다시 확인해주세요.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 상품번호 중복
	public void dupGid() {
		OneMessage pop = new OneMessage("상품고유번호는 중복될 수 없습니다.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

//가격이 10자리 넘음
	public void overPrice() {
		OneMessage pop = new OneMessage("가격은 1원부터 9,999,999,999원까지입니다.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 재고가 10자리 넘음
	public void overStock() {
		OneMessage pop = new OneMessage("재고는 1개부터 9,999,999,999개까지입니다.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 비밀번호 생성 규칙 보여주기
	public void showPwRule() {
		TwoMessage pop = new TwoMessage("비밀번호는 8~16자 영문자, 숫자,", "특수문자를 혼합하세요");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 주소 형식에 안맞다고 알려주기
	public void showAddrRule() {
		OneMessage pop = new OneMessage("주소를 다시 확인해주세요.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	//사업자등록번호 형식 알려주기
	public void showRegiRule() {
		OneMessage pop = new OneMessage("사업자등록번호를 다시 확인해주세요.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}
	// 보내는거 실패
	public void failSub() {
		OneMessage pop = new OneMessage("제목과 받을 기업란은 반드시 입력되어야합니다.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 보내는거 성공했다고 알려주기
	public void sucSub() {
		OneMessage pop = new OneMessage("전송에 성공하였습니다.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	//회사 추가
	public void addCom() {
		OneMessage pop = new OneMessage("성공적으로 추가되었습니다.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	//내가 나를 공유회사로 지정하는 걸 막는 알람
	public void notdub() {
		OneMessage pop = new OneMessage("자사를 거래처로 추가할 수 없습니다.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}
	
	//아이디를 못찾을경우
	public void noIdfind() {
		OneMessage pop = new OneMessage("보내는 사람을 다시 확인해주세요.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}
	
	//내가 나에게 물건 공유하는 걸 막는 알람
		public void notGdub() {
			OneMessage pop = new OneMessage("자사에게 물건 공유를 할 수 없습니다.");
			pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			pop.setVisible(true);
		}
	
	// 커멘트 룰 알려주기
	public void showComRule() {
		OneMessage pop = new OneMessage("커멘트는 100자 이하로 작성해주세요.");
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 상품 삭제창
	public void addGoods(String cid) {
		Tab2AdG pop = new Tab2AdG(cid);
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 상품 업데이트창
	public void updateGoods(Goods goods) {
		Tab2UG pop = new Tab2UG(goods);
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 공유한 상품 공유설정
	public void ShareGoods(SharingGoods sharing) {
		Tab3US pop = new Tab3US(sharing);
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 공유받은 상품 공유설정
	public void SharedGoods(SharingGoods sharing) {
		Tab3USNotUp pop = new Tab3USNotUp(sharing);
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 공유상품 추가
	public void addSharing(String userId) {
		Tab3AdS pop = new Tab3AdS(userId);
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 공유상품(정보 불러와서) 추가
	public void addSharing(String userId, SharingGoods shares) {
		Tab3AdS pop = new Tab3AdS(userId, shares);
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 회사정보 불러오기
	public void showComInfo(Company company) {
		ShowComInfo pop = new ShowComInfo(company);
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 메시지 보내기
	public void sendMessage(String userId) {
		SendMessage pop = new SendMessage(userId);
		pop.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		pop.setVisible(true);
	}

	// 메시지 열기 - int변수 있는 경우
	public void openMessage(String userId, Inquiry inq, int i) {
		OpenMessage a = new OpenMessage(userId, inq, i);
		a.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		a.setVisible(true);
	}




}
