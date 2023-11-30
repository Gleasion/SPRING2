package kr.or.ddit.controller.email.vo;

import java.util.List;

import lombok.Data;

@Data
public class EmailVO {

	private String email;
	private String code;
	
	private String from;
	private String to;
	private String subject;
	private String text;
	private List<AttachmentVO> attachments;
}
