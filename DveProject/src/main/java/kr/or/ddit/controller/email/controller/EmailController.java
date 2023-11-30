package kr.or.ddit.controller.email.controller;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.controller.email.service.IEmailService;
import kr.or.ddit.controller.email.vo.EmailVO;
import kr.or.ddit.vo.DDITMemberVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/email")
public class EmailController {
	private static final Logger log = LoggerFactory.getLogger(EmailController.class);
	
	// IEmailService 의존성 주입
	@Inject
	private IEmailService emailService;
	
	// 이메일 인증시 인증코드 전송
	@ResponseBody
	@RequestMapping(value = "/sendEmailCode", method = RequestMethod.POST)
	public ServiceResult sendEmailCode(@RequestBody String email) throws Exception {
		ServiceResult result = emailService.sendCode(email);
		EmailVO emailVO = new EmailVO();
		emailVO.setEmail(email);
		return result;
	}
	
	// 인증코드 체크
	@ResponseBody
	@RequestMapping(value = "/emailCheck", method = RequestMethod.POST)
	public ServiceResult emailCheck(@RequestBody String code) {
		ServiceResult result = emailService.emailCodeCheck(code);
		return result;
	}
	
	@RequestMapping(value = "/findemail.do", method = RequestMethod.GET)
	public String findEmail() {
		return "noticeboard/findemail";
	}
	
	// 이메일로 아이디 찾기 & 메일 발송
	@ResponseBody
	@RequestMapping(value = "/findIdEmail.do", method = RequestMethod.POST)
	public ServiceResult findIdByEmail(@RequestBody DDITMemberVO member) throws UnsupportedEncodingException, MessagingException{
		ServiceResult result = emailService.findIdEmail(member);
		return result;
	}
	
	// 이메일로 비밀번호 찾기 & 메일 발송
	@ResponseBody
	@RequestMapping(value = "/findPwEmail.do", method = RequestMethod.POST)
	public ServiceResult findPwEmail(@RequestBody DDITMemberVO member) throws UnsupportedEncodingException, MessagingException{
		ServiceResult result = emailService.findPwEmail(member);
		return result;
	}
	
	// 이메일로 비밀번호 재설정 & 메일 발송
	@ResponseBody
	@RequestMapping(value = "/resetPwEmail.do", method = RequestMethod.POST)
	public ServiceResult resetPwEmail(@RequestBody DDITMemberVO member) throws UnsupportedEncodingException, MessagingException{
		ServiceResult result = emailService.resetPwEmail(member);
		return result;
	}
	
	
	
}
