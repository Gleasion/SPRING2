package kr.or.ddit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "notice/list";
	}
	
	// 회원권한을 가진 사용자만 접근이 가능하다.
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm() {
		return "notice/register";
	}
	
	
	
	
	
	
	
	
}
