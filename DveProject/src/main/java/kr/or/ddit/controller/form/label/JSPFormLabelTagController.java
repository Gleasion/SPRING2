package kr.or.ddit.controller.form.label;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/formtag/label")
public class JSPFormLabelTagController {
	
	/*
		13. 라벨 요소
		- HTML 라벨을 출력하려면 <form:label> 요소를 사용한다.
	 */
	
	// 모델에 기본 생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormLabel01", method = RequestMethod.GET)
	public String registerFormLabel01(Model model) {
		log.info("registerFormLabel01() 실행...!");
		
		model.addAttribute("member",new Member());
		
		return "form/label/registerFormLabel01";
	}

	
	
	
	
}
