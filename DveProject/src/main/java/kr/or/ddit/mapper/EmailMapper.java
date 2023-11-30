package kr.or.ddit.mapper;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.controller.email.vo.EmailVO;
import kr.or.ddit.vo.DDITMemberVO;

public interface EmailMapper {

	// 이메일 인증 코드 DB 저장
	public int saveEmailCode(@Param("email") String email, @Param("code") String code);
	
	// 인증 코드 확인
	public EmailVO selectEmailCode(String code);

	// 이메일로 아이디 찾기
	public String findIdEmail(DDITMemberVO member);

	// 이메일로 비밀번호 찾기
	public String findPwEmail(DDITMemberVO member);

	// 기존 비밀번호 초기화(update)
	public int resetPwEmail(@Param("member") DDITMemberVO member, @Param("randomPw") String randomPw);



}
