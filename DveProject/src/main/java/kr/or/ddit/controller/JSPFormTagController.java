package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/formtag")
public class JSPFormTagController {
	
	/*
		8장 스프링 폼 태그
		
		1. 스프링 폼 태그 라이브러리
		- 스프링 폼은 HTML 폼을 표시하기 위한 태그 라이브러리 입니다.
		- 스프링 폼을 이용하면 HTML 폼과 자바 객체를 쉽게 바인딩 할 수 있습니다.
		
			클라이언트 	------	서버
			form 태그			데이터(java)
			
			우리가 앞으로 배울 JSP Form 태그는 클라이언트와 서버 간의 순환 체계가 연결되어 있어야함을 꼭 잊지 말자!
			순환체계란 form 태그 내 modelattribute 속성을 기반으로 서버에서 제공되는 데이터 타입이 일치됨을 의미한다.
			클라이언트에서 form 태그 내에서 활용하고 있는 여러 자원들이 예로 Member 자바빈즈 클래스 객체에서 사용되는 필드들이라고 가정하자.
			그렇다면 서버내에서도 Member에 해당하는 자바빈즈 클래스 객체를 클라이언트로 전달해줄 수 있는 로직이 추가 되어 있어야한다.
			이 과정이 처리되어 있지 않으면 순환 체계가 연결 되어 있지 않아 에러를 발생시킨다.
			
			form 태그를 꼭 활용해야한다는 법은 없다.
			form 태그를 활용하면 form 태그와 form 태그 내에서 사용 가능 한 input 요소들의 태그들을 쉽고 빠르게 만들 수 있다는 장점이 있기 때문이지
			꼭 활용하여 사용 해야한다는 것은 아닌다.
			
			# 스프링 폼 커스텀 태그 목록
			
			<form:form>
			- 폼 요소를 생성한다.
			
			<form:input>
			-텍스트 필드 요소를 생성한다.
			
			<form:password>
			- 패스워드 필드 요소를 생성한다.
			
			<form:textaread>
			- 텍스트 영역 요소를 생성한다.
			
			<form:checkbox>
			- 여러개의 체크 박스 요소를 생성한다.
			
			<form:radiobuttons>
			- 라디오 버튼 요소를 생성한다.
			
			<form:select>
			- 셀렉트 박스 요소를 생성한다.
			
			<form:hidden>
			- 숨겨진 필드 요소를 생성한다.
			
			<form:label>
			- 라벨 요소를 생성한다.
			
			<form:button>
			- 버튼 요소를 생성한다.
			
			<form:errors>
			- 입력값 검증 오류를 표시한다.
			
			스프링 폼 태그 라이브러리 선언
			<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
			
		2. 폼 요소
		- HTML 폼을 출력하려면 <form:form> 요소를 사용한다.
		
			*** JSP에서 <form:form>태그를 선언하고 modelAttribute의 속성을 설정 후 서버 컨트롤러 메소드의 model 이라는 데이터 전달자를 통해서
				전달되어지는 데이터가 modelAttribute 속성에 설정된 값과 일치하지 않는 경우 순환체계의 연결이 부적절하므로 에러가 발생한다.
				하지만, 일치하는 경우 순환 체계의 연결이 정상이므로 에러가 발생하지 않는다.
				
		3. 폼 항목의 공통 속성 
		- HTML 폼 항목을 출력하기 위한 태그 라이브러리에는 몇가지 공통 속성이 있다.
		
			path
			- 폼 항목에 바인딩 되는 폼 객체의 프로퍼티를 지정한다.
			
			disabled
			- 폼 항목을 비활성화할지 여부를 지정한다. (기본값은 false)
			readonly
			- 폼 항목을 읽기 전용으로 만들지 여부를 지정한다. (기본값은 false)
			

	 */
	
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String regusterForm01(Model model) {
		log.info("registerForm01() 실행...!");
		model.addAttribute("member", new Member());
		return "home/formtag/registerForm01";
	}
	
	// 2) 폼 객체의 속성명과 스프링 폼 태그의 modelAttribute 속성값이 일치하지 않으면 에러가 발생한다.
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String regigsterForm02(Model model) {
		log.info("registerForm02() 실행...!");
		model.addAttribute("user", new Member());
		return "home/formtag/registerForm01";
		
	}
	
	// 3) 컨트롤러 매소드의 매개변수로 자바빈즈 객체가 전달이 되면 기본적으로 다시 화면으로 전달된다.
	@RequestMapping(value = "/registerForm03", method = RequestMethod.GET)
	public String registerForm03(Member member) {
		log.info("registerForm03() 실행...!");
		return "home/formtag/registerForm01";
	}
	
	// 4) @ModelAttribute 어노테이션으로 폼 객체의 속성명을 직접 지정할 수 있다.
	@RequestMapping(value = "/registerForm04", method = RequestMethod.GET)
	public String registerForm04(@ModelAttribute("user") Member member) {
		log.info("registerForm04() 실행...!");
		return "home/formtag/registerForm01";
	}
	
	// 5) 폼 객첼의 프로퍼티에 값을 지정하여 모델을 통하여 전달한다.
	@RequestMapping(value = "/registerForm05", method = RequestMethod.GET)
	public String registerForm05(Model model) {
		log.info("registerForm05() 실행...!");
		
		Member member = new Member();
		member.setUserId("hongkildong");
		member.setUserName("홍길동");
		
		model.addAttribute("user", member);
		return "home/formtag/registerForm01";
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String reigster(Member member, Model model) {
		log.info("reigster() 실행...!");
		log.info("userId : " + member.getUserId());
		log.info("userName : " + member.getUserName());
		
		model.addAttribute("member", member);
		return "home/formtag/result";
	}
	
	
	
}
