package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RedirectAttributeMemberController {
	
	/*
	 * 4. RedirectAttribute 타입
	 * - RedirectAttribute는 일회성으로 데이터를 전달하는 용도로 사용합니다.
	 */
	
	// RedirectAttribute Form 테스트 페이지
	@RequestMapping(value = "/redirectattribute/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		return "member/registerRedirectAttributeForm";
	}
	
	// 데이터 처리
	// 1) RedirectAttriubte 객체에 일회성 데이터를 지정하여 전달한다.
	@RequestMapping(value = "/redirectattribute/register", method = RequestMethod.POST)
	public String register(Member member, RedirectAttributes redirectattribute) {
		log.info("register() 실행...!");
		redirectattribute.addFlashAttribute("msg", "success");
		return "redirect:/redirectattribute/result";
	}
	
	// 결과 페이지로 이동
	@RequestMapping(value = "/redirectattribute/result", method = RequestMethod.GET)
	public String result() {
		log.info("result() 실행...!");
		return "result";
		
	}
	
	
	
	
	
	
	
	
	
}
