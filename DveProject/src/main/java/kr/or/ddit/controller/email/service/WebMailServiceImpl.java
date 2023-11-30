package kr.or.ddit.controller.email.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.controller.email.vo.AttachmentVO;
import kr.or.ddit.controller.email.vo.EmailVO;
import kr.or.ddit.mapper.EmailMapper;

@Service
public class WebMailServiceImpl implements IWebMailService {
	
	@Inject
	private JavaMailSender emailsender;
	
	@Inject
	private EmailMapper emailMapper;
	
	@Override
	public ServiceResult sendWebMail(EmailVO emailVO) {
		ServiceResult result = null;
		
		try {
			MimeMessage message = createMessage(emailVO);
			emailsender.send(message);
			result = ServiceResult.OK;
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
			result = ServiceResult.FAILED;
		}
		return result;
	}
	
	private MimeMessage createMessage(EmailVO emailVO) throws MessagingException, IOException {
		MimeMessage message = emailsender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setFrom(emailVO.getFrom());
		helper.setTo(emailVO.getTo());
		helper.setSubject(emailVO.getSubject());
		helper.setText(emailVO.getText(), true);
		
		addAttachments(helper, emailVO.getAttachments());
		
		return message;
	}
	
	private void addAttachments(MimeMessageHelper helper, List<AttachmentVO> attachments) throws MessagingException, IOException {
		if (attachments != null && !attachments.isEmpty()) {
			for (AttachmentVO attachment : attachments) {
				File file = new File(attachment.getFilePath());
			
				if (file.exists()) {
					DataSource source = new FileDataSource(file);
			
					try {
						// 첨부 파일 이름 설정 및 한글 인코딩
						helper.addAttachment(MimeUtility.encodeText(attachment.getOriginName()), source);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
