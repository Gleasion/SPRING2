package kr.or.ddit.controller.email.service;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.controller.email.vo.EmailVO;
import kr.or.ddit.mapper.EmailMapper;
import kr.or.ddit.vo.DDITMemberVO;
import lombok.extern.slf4j.Slf4j;

@Service
public class EmailServiceImpl implements IEmailService {
	
	// 자바 메일 sender 의존성 주입
	@Inject
	private JavaMailSender emailsender;
	
	// EmailMapper 의존성 주입
	@Inject
	private EmailMapper emailMapper;
	
	// 인증코드 메일 발송
	@Override
	public ServiceResult sendCode(String email) throws Exception {
		ServiceResult result = null;
		
		String code = createKey();									// 랜덤 인증 번호 생성
		MimeMessage message = createMessage(email, code); 			// 메일 내용 작성
		
		try {
			emailsender.send(message);								// 메일 발송
			int status = emailMapper.saveEmailCode(email, code);	// 인증 코드 DB 저장
			if(status > 0) {
				result = ServiceResult.OK;
			}else {
				result = ServiceResult.FAILED;
			}
		}catch (MailException e) {
			e.printStackTrace();
			result = ServiceResult.FAILED;
		}
		return result; // DB 저장 결과 반환
	}
	
	// 랜덤 인증 코드 생성
	public String createKey() {
		UUID uuid = UUID.randomUUID();
		String code = uuid.toString().replace("-", "").substring(0,8);
		
		return code;
	}
	
	// 인증코드 메일 작성
	public MimeMessage createMessage(String email, String code) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = emailsender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setTo(email);
		helper.setSubject("OHHO 이메일 인증");
		
		String emailContent = getEmailContent(code);
		
		helper.setText(emailContent, true);
		helper.setFrom(new InternetAddress("nammj0419@gmail.com", "OHHO_ADMIN"));
		
		return message;
	}
	
	// 인증코드 내용 작성
	private String getEmailContent(String code) {
		StringBuilder emailContent = new StringBuilder();
		String content = "";
		content += "<html>";
		content += "<head>";
		content += "<title>OHHO 이메일</title>";
		content += "</head>";
		content += "<body>";
		content += "<div style='margin:100px;'>";
		content += "<h1>안녕하세요</h1>";
		content += "<h1>OHHO 이메일 인증입니다.</h1>";
		content += "<br/>";
		content += "<p>아래 코드를 입력해주세요.<p>";
		content += "<div align='center' style='border:1px solid black; font-family:verdana';>";
		content += "<h3 style='color:blue;'>인증 코드입니다.</h3>";
		content += "<div style='font-size:130%'>";
		content += "CODE : <strong>";
		content += code + "</strong><div><br/> "; 				// 메일에 인증번호 넣기
		content += "</div>";
		content += "</body>";
		emailContent.append(content);
		
		return emailContent.toString();
	}

	// 이메일 인증코드 확인
	@Override
	public ServiceResult emailCodeCheck(String code) {
		ServiceResult result = null;
		EmailVO emailVO = emailMapper.selectEmailCode(code);
		if(code.equals(emailVO.getCode())) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}
	
	//이메일로 아이디 찾기 & 메일발송
	@Override
	public ServiceResult findIdEmail(DDITMemberVO member) throws UnsupportedEncodingException, MessagingException {
		ServiceResult result = null;
		String memName = member.getMemName();
		String memEmail = member.getMemEmail();
		String findId = emailMapper.findIdEmail(member);
		if(findId != null && findId != "") {
			try {
				MimeMessage message = findIdMessage(memEmail, findId, memName);		// 내용 작성
				emailsender.send(message);											// 메일 발송
				result = ServiceResult.OK;
			}catch (MailException e) {
				e.printStackTrace();
				result = ServiceResult.FAILED;
			}
		}
		return result;
	}
	
	// 아이디 찾기 메일 작성
	private MimeMessage findIdMessage(String memEmail, String findId, String memName) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = emailsender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setTo(memEmail);
		helper.setSubject("OHHO 아이디 찾기");
		
		String emailContent = findIdEmailContent(findId, memName);
		helper.setText(emailContent, true);
		helper.setFrom(new InternetAddress("nammj0419@gmail.com", "OHHO_ADMIN"));
		
		return message;
	}
	
	// 아이디 찾기 내용
	private String findIdEmailContent(String findId, String memName) {
		StringBuilder findIdContent = new StringBuilder();
		
		String content = "";
		content += "<html>";
		content += "<head>";
		content += "<title>OHHO 이메일</title>";
		content += "</head>";
		content += "<body>";
		content += "<div style='margin:100px;'>";
		content += "<h1>안녕하세요.</h1>";
		content += "<h1>OHHO 아이디 찾기 입니다.</h1>";
		content += "<br/>";
		content += "<p>아이디를 확인해주세요.<p>";
		content += "<div align='center' style='border:1px solid black; font-family:verdana';>";
		content += "<h3 style='color:blue;'> " + memName + "님의 아이디는</h3>";
		content += "<div style='font-size:130%'>";
		content += "ID : <strong>";
		content += findId + "입니다.</strong><div><br/>"; 				// 메일에 찾는 아이디 넣기
		content += "</div>";
		content += "</body>";
		findIdContent.append(content);
		
		return findIdContent.toString();
	}

	// 이메일로 비밀번호 찾기 & 메일 발송
	@Override
	public ServiceResult findPwEmail(DDITMemberVO member) throws UnsupportedEncodingException, MessagingException {
		ServiceResult result = null;
		
		String memEmail = member.getMemEmail();
		String memId = member.getMemId();
		
		String findPw = emailMapper.findPwEmail(member);
		
		if(findPw != "" && findPw != null) {
			try {
				MimeMessage message = findPwMessage(memEmail, findPw, memId);		// 내용 작성
				emailsender.send(message);											// 메일 발송
				result = ServiceResult.OK;
			}catch (MailException e) {
				e.printStackTrace();
				result = ServiceResult.FAILED;
			}
		}
		
		return result;
	}
	
	// 비밀번호 찾기 메일 작성
	private MimeMessage findPwMessage(String memEmail, String findPw, String memId) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = emailsender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setTo(memEmail);
		helper.setSubject("OHHO 비밀번호 찾기");
		
		String emailContent = findPwEmailContent(findPw, memId);
		helper.setText(emailContent, true);
		helper.setFrom(new InternetAddress("nammj0419@gmail.com", "OHHO_ADMIN"));
		
		return message;
	}
	
	// 비밀번호 찾기 내용
	private String findPwEmailContent(String findPw, String memId) {
		StringBuilder findIdContent = new StringBuilder();
		
		String content = "";
		content += "<html>";
		content += "<head>";
		content += "<title>OHHO 이메일</title>";
		content += "</head>";
		content += "<body>";
		content += "<div style='margin:100px;'>";
		content += "<h1>안녕하세요.</h1>";
		content += "<h1>OHHO 비밀번호 찾기 입니다.</h1>";
		content += "<br/>";
		content += "<p>비밀번호를 확인해주세요.<p>";
		content += "<div align='center' style='border:1px solid black; font-family:verdana';>";
		content += "<h3 style='color:blue;'> " + memId + "님의 비밀번호는</h3>";
		content += "<div style='font-size:130%'>";
		content += "ID : <strong>";
		content += findPw + "입니다.</strong><div><br/>"; 				// 메일에 찾는 비밀번호 넣기
		content += "</div>";
		content += "</body>";
		findIdContent.append(content);
		
		return findIdContent.toString();
	}

	// 이메일로 비밀번호 재설정
	@Transactional
	@Override
	public ServiceResult resetPwEmail(DDITMemberVO member) throws UnsupportedEncodingException, MessagingException {
		ServiceResult result = null;
		
		String memEmail = member.getMemEmail();
		String memId = member.getMemId();
		
		String findPw = emailMapper.findPwEmail(member);								// 회원정보에 일치하는 비밀번호
		
		if(findPw != "" && findPw != null) {											// 찾는 비밀번호가 null 또는 공백이 아니라면
			String randomPw = createPw();												// 랜덤 비밀번호 생성
			int status = emailMapper.resetPwEmail(member, randomPw);					// 비밀번호 초기화(update)
			if(status > 0) {															// 비밀번호 update 성공 시
				try {
					MimeMessage message = resetPwMessage(memEmail, randomPw, memId);	// 내용 작성
					emailsender.send(message);											// 메일 발송
					result = ServiceResult.OK;
				}catch (MailException e) {
					e.printStackTrace();
					result = ServiceResult.FAILED;
				}
			}
		}
		
		return result;
	}
	
	// 랜덤 비밀번호 생성
	public String createPw() {
		UUID uuid = UUID.randomUUID();												// UUID를 이용하여 ramdom 생성
		String randomPw = uuid.toString().replace("-", "").substring(0,10);			// 10자리의 랜덤 비밀번호 생성

		return randomPw;
	}
		
	// 비밀번호 재설정 메일 작성
	private MimeMessage resetPwMessage(String memEmail, String randomPw, String memId) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = emailsender.createMimeMessage();						// MimeMessage를 활용한 메세지 작성	
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");	// MimeMessageHelper를 이용하여 메일 설정
		
		helper.setTo(memEmail);														// set 받는 사람 이메일
		helper.setSubject("OHHO 비밀번호 초기화");										// set 메일 제목
		
		String emailContent = randomPwContent(randomPw, memId);						// 메일 내용
		helper.setText(emailContent, true);											// set 메일 내용
		
		helper.setFrom(new InternetAddress("nammj0419@gmail.com", "OHHO_ADMIN"));	// set 보내는 사람 메일주소, 이름
		
		return message;
	}
	
	// 비밀번호 메일 내용 (html 문서를 동적으로 생성)
	private String randomPwContent(String randomPw, String memId) {
		StringBuilder findIdContent = new StringBuilder();
		
		String content = "";
		content += "<html>";
		content += "<head>";
		content += "<title>OHHO 이메일</title>";
		content += "</head>";
		content += "<body>";
		content += "<div style='margin:100px;'>";
		content += "<h1>안녕하세요.</h1>";
		content += "<h1>OHHO 비밀번호 재설정 입니다.</h1>";
		content += "<br/>";
		content += "<p>비밀번호를 확인해주시고, 로그인 후 반드시 비밀번호를 변경하여 주세요.<p>";
		content += "<div align='center' style='border:1px solid black; font-family:verdana';>";
		content += "<h3 style='color:blue;'> " + memId + "님의 비밀번호는</h3>";
		content += "<div style='font-size:130%'>";
		content += "ID : <strong>";
		content += randomPw + "입니다.</strong><div><br/>"; 				// 메일 내용상에 랜덤 비밀번호 추가하여 넣기
		content += "</div>";
		content += "</body>";
		findIdContent.append(content);
		
		return findIdContent.toString();
	}

	
	
	

}
