package kr.or.ddit.controller.email.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.DDITMemberVO;

public interface IEmailService {

	// 인증코드 메일 발송
	public ServiceResult sendCode(String email) throws Exception;

	// 이메일 인증코드 확인
	public ServiceResult emailCodeCheck(String code);

	// 이메일로 아이디 찾기 & 메일 발송
	public ServiceResult findIdEmail(DDITMemberVO member) throws UnsupportedEncodingException, MessagingException;
	
	// 이메일로 비밀번호 찾기 & 메일 발송
	public ServiceResult findPwEmail(DDITMemberVO member) throws UnsupportedEncodingException, MessagingException;

	// 이메일로 비밀번호 재설정 & 메일발송
	public ServiceResult resetPwEmail(DDITMemberVO member) throws UnsupportedEncodingException, MessagingException;

	






}
