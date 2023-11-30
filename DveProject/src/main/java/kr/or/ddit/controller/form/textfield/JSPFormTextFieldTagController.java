package kr.or.ddit.controller.form.textfield;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/formtag/textfield")
public class JSPFormTextFieldTagController {

	/*
		4. 텍스트 필드 요소
		- HTML 텍스트 필드를 출력하려면 <form:input> 요소를 사용한다.
	 */
	
	// 모델에 기본 생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		log.info("registerForm01() 실행...!");
		// Member 자바빈즈 클래스안에 default로 설정되어 잇는 값들을 기반으로
		// 클라이언트(jsp)에서 만들어진 form input 요소들의 데이터가 value 속성에 채워진다.
		model.addAttribute("member", new Member());
		Member member = new Member();
		member.setUserId("hongkildong");
		member.setUserName("홍길동");
		member.setEmail("ddit@n.com");
		
		return "form/textfield/registerForm01";
	}
	
	
	
	
	
	
	
	
	
	
}
