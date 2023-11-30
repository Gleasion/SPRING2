package kr.or.ddit.controller.email.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.controller.email.service.IWebMailService;
import kr.or.ddit.controller.email.vo.EmailVO;

@Controller
@RequestMapping("/email")
public class webMailController {
	
	@Inject
	private IWebMailService webMailService;
	
	@RequestMapping(value = "/webmail", method = RequestMethod.GET)
	public String webMailForm() {
		return "email/emailForm";
	}
	
	@RequestMapping(value = "/sendmail", method = RequestMethod.POST)
	public String webMailSend(@RequestBody EmailVO emailVO, Model model) {
		ServiceResult result = webMailService.sendWebMail(emailVO);
        if (result.equals(ServiceResult.OK)) {
            model.addAttribute("message", "이메일이 성공적으로 전송되었습니다.");
        } else {
            model.addAttribute("message", "이메일 전송 중 오류가 발생했습니다.");
        }
        return "email/success";
    }
	
	
}
