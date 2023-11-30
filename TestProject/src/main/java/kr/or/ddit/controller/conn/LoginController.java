package kr.or.ddit.controller.conn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/signin.do", method = RequestMethod.GET)
	public String signIn() {
		return "conn/signin";
	}
	
	@RequestMapping(value="/signup.do", method = RequestMethod.GET)
	public String signUpForm() {
		return "conn/signup";
	}
}
