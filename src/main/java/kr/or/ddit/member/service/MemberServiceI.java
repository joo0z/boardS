package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.model.MemberVo;

public interface MemberServiceI {
	

	/**
	 * 마이페이지에 회원정보를 출력하는 메서드
	 * @param 로그인 한 회원의 memId 
	 * @author 박주영
	 * @return 해당 회원의 정보 vo
	 */
	public MemberVo getMemberInfo(String mem_id);
	
	/**
	 * 회원의 비밀번호를 update하는 메서드
	 * @param vo
	 * @return 작업 성공 1, 작업실패 0
	 * @throws SQLException
	 */
	public int updatePass(MemberVo memberVo);
	
	/**
	 * 회원 탈퇴하는 메서드
	 * @param vo
	 * @return 작업 성공 1, 작업실패 0 
	 * @throws SQLException
	 */
	public int dropMember(MemberVo memberVo);
	
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param mv DB에 insert할 자료가 저장된 MemberVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int insertMember(MemberVo memberVo);
}
