package kr.or.ddit.controller.validation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/validation")
public class ValidationController {
	
	/*
		9장 입력 유효성 검증
		
		1. 입력값 검증
		- 스프링 MVC는 Bean Validation 기능을 이용해 요청 파라미터 값이 바인딩된 도메인 클래스(또는 커멘드 클래스)의 입력값 검증을 한다.
		
			#의존관계 정의
			- 입력값 검증을 위한 의존 라이브러리를 추가한다.
			- pom.xml에서 hivernate-validator 추가
			
			# 입력값 검증 활성화
			- Member 클래스로 넘어가 userId, userName에 규칙을 활성화 한다.
			- 입력값 검증을 하기 위해서는 메소드 매개변수에 도메인 클래스를 정의하고 @Validation를 지정한다.
			- 입력값 검증 대상의 도메인 클래스 직후에 BindingResult를 정의한다.
			- BindingResult에는 요청 데이터의 바인딩 오류와 입력값 검증 오류 정보가 저장된다.
			
			# 환경 설정 순서
			
				1. 입력값 검증을 위한 의존 라이브러리를 추가한다.
				2. 입력값 검증 활성화
					> 활성화를 할 도메인 클래스에다가 @Validation 어노테이션을 지정한다.
				3. 도메인 클래스 내 필드에다가 검증을 위한 어노테이션들로 데이터 검증을 활성화한다.(@NotBlank, @Size 등등)
				4. 에러를 받을 BindingResult를 설정한다.
	 */
	
	// Validation 테스트할 폼 페이지 컨트롤러 메소드
	@RequestMapping(value = "/registerValidationForm01", method = RequestMethod.GET)
	public String registerValidtaionForm01(Model model) {
		model.addAttribute("member", new Member());
		return "validation/registerValidationForm01";
	}
	
	// validation 처리
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String registerValidationForm01Process(@Validated Member member, BindingResult result) {
		log.info("registerValidationForm01Process() 실행...!");
		
		if(result.hasErrors()) {
			return "validation/registerValidationForm01";
		}
		
		log.info("userId : " + member.getUserId());
		log.info("password : " + member.getPassword());
		log.info("userName : " + member.getUserName());
		log.info("email : " + member.getEmail());
		log.info("gender : " + member.getGender());
		
		return "validation/success";
	}
	
	/*
		2. 입력값 검증 결과
		- 입력값 검증 대상의 도메인 클래스 직후에 BindingResult를 정의한다.
		
			# BindingResult에는 요청 데이터의 바인딩 에러와 입력값 검증 에러 정보가 저장된다.
				
				1) 에러 정보 확인을 위한 BindingResult 메소드
				
					hasErrors()
					-에러가 발생한 경우 true를 반환한다.
					
					hasGlobalErrors()
					- 객체 레벨의 에러가 발생한 경우 true를 반환한다.
					
					hasFieldErrors()
					- 필드 레벨의 에러가 발생한 경우 true를 반환한다.
					
					hasFieldErrors(String)
					- 인수에 저장한 필드에서 에러가 발생한 경우 true를 반환한다.
	 */
	
	// 1) 입력값 검증 대상의 도메인 클래스 직후에 BindingResult를 정의하여 에러정보를 확인할 수 있다.(확인인은 처리 메소드에서)
	@RequestMapping(value = "/registerValidationForm02", method = RequestMethod.GET)
	public String registerValidationForm02(Model model) {
		model.addAttribute("member", new Member());
		return "validation/registerValidationForm02";
	}
	
	// 결과
	@RequestMapping(value = "/result2", method = RequestMethod.POST)
	public String registerValidationForm02Process(@Validated Member member, BindingResult result) {
		log.info("registerValidationForm02Process() 실행...!");
		
		// 입력값 검증 에러가 발생한 경우 true를 반환
		log.info("result.hasError() : " + result.hasErrors());
		
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			log.info("allErrors.size(" + allErrors.size() + ")");
			log.info("globalErrors.size(" + globalErrors.size() + ")");
			log.info("fieldErrors.size(" + fieldErrors.size() + ")");
			
			for(int i = 0; i< allErrors.size(); i++) {
				ObjectError objError = allErrors.get(i);
				log.info("allError : " + objError);
			}
			
			for(int i = 0; i< globalErrors.size(); i++) {
				ObjectError objError = globalErrors.get(i);
				log.info("globalErrors : " + objError);
			}
			
			for(int i = 0; i< fieldErrors.size(); i++) {
				FieldError fieldError = fieldErrors.get(i);
				log.info("fieldError : " + fieldError);
				log.info("fieldErrors. : " + fieldError.getDefaultMessage());
			}
			
			return "validation/registerValidationForm02";
		}
		
		log.info("userId : " + member.getUserId());
		log.info("userName : " + member.getUserName());
		log.info("Email : " + member.getEmail());
		log.info("gender : " + member.getGender());
		
		return "validation/success";
	}
	
	
	
	
}
