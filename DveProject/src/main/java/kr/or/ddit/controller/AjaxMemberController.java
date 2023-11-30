package kr.or.ddit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.Card;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ajax")
public class AjaxMemberController {
	
	// 9. Ajax 방식 요청 처리 페이지
	@RequestMapping(value = "/registerForm")
	public String ajaxRegisterForm() {
		return "member/ajaxRegisterForm";
	}
	
	// 1) URL 경로 상의 여러개의 경로 변수값을 @PathVariable 어노테이션을 지정하여 여러개의 문자열 매개변수로 처리한다.
	@RequestMapping(value = "/register/{userId}/{password}", method = RequestMethod.POST)
	public ResponseEntity<String> register01(
			@PathVariable("userId") String userId,
			@PathVariable("password") String password
			){
		log.info("register01() 실행...!");
		
		log.info("userId : " + userId);
		log.info("password : " + password);
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 2) 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 자바빈즈 매개변수로 처리한다.
	 @RequestMapping(value = "/register02", method = RequestMethod.POST)
	public ResponseEntity<String> register02(@RequestBody Member member){
		log.info("register02() 실행...!");
		
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassWord() : " + member.getPassword());
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	

	 // 3) 객체 타입의 JSON 요청 데이터는 문자열 매개변수로 처리할수 [없다.]
	 @RequestMapping(value = "/register03", method = RequestMethod.POST)
	 public ResponseEntity<String> register03(@RequestBody String userId){
		 // 요청 본문에서 데이터가 바인딩 되지 않아 userId가 null이 나온다.
		 // 요청 본문에서 데이터를 가져오려면 @RequestBody 어노테이션이 필요함
		 log.info("register03() 실행...!");
		 
		 log.info("userId : " + userId);
		 
		 ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		 return entity;
	 }
	 
	// 4) 객체 타입의 JSON 요청 데이터를 @PathVariable 어노테이션을 지정한 문자열 매개변수와 @RequestBody 어노테이션을 지정한 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/register04/{userId}", method = RequestMethod.POST)
	public ResponseEntity<String> register04(
			@PathVariable String userId, @RequestBody Member member
			){
		log.info("register04() 실행...!");
		
		log.info("userId : " + userId);
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassWord() : " + member.getPassword());
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 5) 객체 배열 타입의 JSON 요청 데이터를 자바빈즈 요소를 가진 리스트 컬렉션 매개변수에 @RequestBody 어노테이션을 지정하여 처리한다.
	@RequestMapping(value = "/register05", method = RequestMethod.POST)
	public ResponseEntity<String> register05(@RequestBody List<Member> memberList){
		log.info("register05() 실행...!");
		
		for(Member member : memberList) {
			log.info("userId : " + member.getUserId());
			log.info("password : " + member.getPassword());
		}
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 6) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/register06", method = RequestMethod.POST)
	public ResponseEntity<String> register06(@RequestBody Member member){
		log.info("register06() 실행...!");
		
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassword( : " + member.getPassword());
		
		Address address = member.getAddress();
		if(address != null) {
			log.info("address.getPostCode() : " + address.getPostCode());
			log.info("address.getLocation() : " + address.getLocation());
		}else {
			log.info("address == null");
		}
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 7) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/register07", method = RequestMethod.POST)
	public ResponseEntity<String> register07(@RequestBody Member member){
		log.info("register07() 실행...!");
		
		log.info("member.getUserId : " + member.getUserId());
		log.info("member.getPassword : " + member.getPassword());
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null && cardList.size() > 0) {
			log.info("cardList.size() : " + cardList.size());
			
			for(int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				
				log.info("card.getNo() : " + card.getNo());
				log.info("card.getValidMonth() : " + card.getValidMonth());
			}
		}else {
			log.info("cardList == null");
		}
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
		
	}
	
	
	
	
	
	
}
