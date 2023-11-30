package kr.or.ddit.controller.email.service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.controller.email.vo.EmailVO;

public interface IWebMailService {

	public ServiceResult sendWebMail(EmailVO emailVO);

}
