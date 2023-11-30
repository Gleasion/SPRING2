package kr.or.ddit.controller.form.validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/validation")
public class JSPFormValidationController {
	
	/*
		15. 입력값 검증 에러
		- 입력값 검증 에러를 출력하려면 <form:errors> 요소를 사용한다.
	 */
	
	// 클라이언트에서 서버로 modelAttribute에서 바인할 객체를 설정하고 아이디를 누락 시킨 후 서버로 요청했을 때,
	// form:errors 에 담길 메세지는 바인딩 되지만, 바인딩 됐다고 출력을 위한 validation 역할자가 없어서 없는채로 결과 페이지 출력
	// 메세지를 출력할 조력자가 필요한 상황
	@RequestMapping(value = "/registerFormValidation01", method = RequestMethod.GET)
	public String registerFormValidation01(Model model) {
		log.info("registerFormValidation01() 실행...!");
		
		Member member = new Member();
		member.setUserId("hongkildong123");
		member.setUserName("홍길동123");
		member.setEmail("aaa@ccc.com");
		
		model.addAttribute("member", member);
		return "form/validation/registerFormValidation01";
	}
	
	/*
		3. 입력값 검증 규칙
		- 입력값 검증 규칙은 Bean Validation이 제공하는 제약 어노테이션으로 설정한다.
		
			검사규칙은 크게 다음 세가지로 분류할 수 있다.
			
			- Bean Validation 표준 제약 어노테이션
			- 서드 파티에서 구현한 제약 어노테이션(서드파티란, 제 3자에서 만든)
			- 직접 구현한 제약 어노테이션
			
		1) Member 클래스에서 테스트위한 어노테이션으로 설정(아래 명시되어있는 내용들을 가지고 테스트 해보세요!)
		
			@NotNull				:	빈 값이 아닌지를 검사한다.
			@Null					:	null인지를 검사한다.
			@NotBlank				:	문자열이 null이 아니고 trim한 길이가 0보다 크다는 것을 검사한다.
			@NotEmpty				:	문자열이 null이거나 비어있는지를 검사한다.
			@Size					:	글자수나 컬렉션 요소 개수를 검사한다.
				> @Size(max=, min=)
			@Max(value=)			:	value보다 작은걸 검사한다.
			@MIN(value=)			:	value보다 크거나 같은걸 검사한다.
			@Email					:	이메일 주소 형식인지를 검사한다.
			@Past					:	과거 날짜인지를 검사한다.
			@Future					:	미래 날짜인지를 검사한다.
			@Pattern(refexp=)		:	CharSequence는 지정된 정규식과 일치해야하고, 정규식은 Java 정규식 규칙을 따른다.
			@Positive				:	양수여야 한다.(0도 에러)
			@PositiveOrZero			:	양수 또는 0이어야 한다.
			@Length(min=, max=)		:	문자열의 길이가 min과 max 사이인지 확인한다.
			
			이 외에도 많은 어노테이션이 존재하지만, 모든 어노테이션을 다루기 어려우므로 공식 문서를 참고
			
			[테스트 시나리오]
			- Member 클래스의 검증 활성화 추가
				> userId, password, userName, email, dateOfBirth
			- /validation/registerValidationForm02 URL로 요청해서 테스트 진행.
			
	 */
	
	/*
		4. 중첩된 자바빈즈 입력값 검증
		- 중첩된 자바빈즈와 자바빈즈의 컬렉션에서 정의한 프로퍼티에 대해 입력값 검증을 할 때는 @Valid를 지정한다.
		
			1) 중첩된 자바빈즈 클래스를 정의하고 @Valid를 지정한다.
			- Member 클래스 내 Address address 필드에 @Valid 어노테이션 지정
			- Member 클래스 내 List<Card> cardList 필드에 @Valid 어노테이션 지정
			
			2) Address 클래스에도 Validation을 설정한다.
				> 입력값 규칙 활성화
				
			3) Card 클래스에도 Validation을 설정한다.
				> 입력값 규칙 활성화
	 */
	
	@RequestMapping(value = "/registerValidationForm03", method = RequestMethod.GET)
	public String registerValidation03(Model model) {
		log.info("registerValidation03() 실행...!");
		
		model.addAttribute("member", new Member());
		return "validation/registerValidationForm03";
	}
	
	// 결과
	@RequestMapping(value = "/result3", method = RequestMethod.POST)
	public String registerFormValidationResult3(@Validated Member member, BindingResult result) {
		log.info("registerFormValidationResult3() 실행...!");
		
		if(result.hasErrors()) {
			return "validation/registerValidationForm03";
		}
		
		return "validation/success";
	}
	
	
	
}
