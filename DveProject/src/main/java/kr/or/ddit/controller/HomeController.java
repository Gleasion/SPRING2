package kr.or.ddit.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/formHome", method = RequestMethod.GET)
	public String formHome() {
		return "formHome";
	}
	
	@RequestMapping(value = "/ajaxHome", method = RequestMethod.GET)
	public String ajaxHome() {
		return "ajaxHome";
	}
	
	/* 4. 컨트롤러 응답
		1) void 타입
			호출하는 URL과 동일한 뷰 이름을 나타내기 위해 사용
	 */
	
	// 요청 경로(/goHome0101)와 동일 한 뷰 (/goHome0101.jsp) 실행
	@RequestMapping(value = "/goHome0101", method = RequestMethod.GET)
	public void goHome0101() {
		log.info("goHome0101() 실행...!");
	}
	
	// 요청 경로(/sub/goHome0102)와 동일 한 뷰 (/sub/goHome0102.jsp) 실행
	@RequestMapping(value = "/sub/goHome0102", method = RequestMethod.GET)
	public void goHome0102() {
		log.info("goHome0102() 실행...!");
	}
	
	/* String 타입
	 * - 뷰 파일의 경로와 파일 이름을 나타냄
	 */
	@RequestMapping(value = "/goHome0201", method = RequestMethod.GET)
	public String goHome0201() {
		log.info("goHome0201() 실행...!");
		return "home0201";
	}
	
	// 반환값이 "/sub/goHome0202"이므로, 뷰("home0202.jsp")를 나타냄
	@RequestMapping(value = "/sub/goHome0202", method = RequestMethod.GET)
	public String goHome0202() {
		log.info("goHome0202() 실행...!");
		return "home0202";
	}
	
	// 반환값이 "sub/home0203"이므로, 뷰("/sub/home0203.jsp")를 나타냄
	@RequestMapping(value = "/sub/goHome0203", method = RequestMethod.GET)
	public String goHome0203() {
		log.info("goHome0203() 실행...!");
		return "sub/home0203";
	}
	
	// "redirect:"로 시작하려면 리다이렉트 방식으로 처리한다.
	@RequestMapping(value = "/sub/goHome0204", method = RequestMethod.GET)
	public String goHome0204() {
		log.info("goHome0204() 실행...!");
		return "redirect:/sub/goHome0203";
	}
	
	// "/"로 시작하면 웹 애플리케이션의 컨텍스트 경로에 영향을 받지 않는 절대경로를 의미함
	// 해당 경로 : E:\99.Class\02.Spring02\workspace_spring2\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\
	// DveProject\WEB-INF\views\sub\home0205.jsp와 같은 경로로 설정
	@RequestMapping(value = "/sub/goHome0205", method = RequestMethod.GET)
	public String goHome0205() {
		log.info("goHome0205() 실행...!");
		return "/sub/home0205";
	}
	
/* 3) 자바빈즈 클래스 타입
 * - JSON 객체 타입의 데이터를 만들어서 변환하는 용도로 사용
 * > ResponseBody를 이용하는 방식
 * > RestController를 이용하는 방식
 * 
 * @ResponseBody를 지정하지 않으면 HTTP 404 에러 발생(jackson-databind 라이브러리가 설정되어 있지 않은 경우)
 * @ResponseBody가 객체를 리턴하여 객체를 응답 데이터로 보내는 역할을 한다.
 * @ResponseBody의 리턴 default 데이터 형식은 json이다.
 * @ResponseBody 대신에 @RestController를 이용하여 대체할 수 있다.
 */
	
	@ResponseBody
	@RequestMapping(value = "/goHome0301", method = RequestMethod.GET)
	public Member goHome0301() {
		log.info("goHome0301() 실행...!");
		Member member = new Member();
		return member;
	}
	
	/* 4) 컬렉션 List 타입
	 * - JSON 객체 배열 타입의 데이터르 만들어서 반환하는 용도로 사용한다.
	 */
		
		@ResponseBody
		@RequestMapping(value = "/goHome0401", method = RequestMethod.GET)
		public List<Member> goHome0401(){
			log.info("goHome0401() 실행...!");
			
			List<Member> list = new ArrayList<Member>();
			
			Member member = new Member();
			list.add(member);
			
			Member member2 = new Member();
			list.add(member2);
			
			return list;
		}
		
	/* 5) 컬렉션 Map 타입
	 * - Map 형태의 컬렉션 자료를 JSON 객체 타입의 데이터로 만들어서 반환하는 용도로 사용
	 */
		
		@ResponseBody
		@RequestMapping(value = "/goHome0501", method = RequestMethod.GET)
		public Map<String, Member> goHome0501(){
			log.info("goHome0501() 실행...!");
			
			Map<String, Member> map = new HashMap<String, Member>();
			
			Member member = new Member();
			Member member2 = new Member();
			
			map.put("key1", member);
			map.put("key2", member2);
			
			return map;
		}
		
	/* 6) ResponseEntity<Void> 타입
	 * - response 할 때 HTTP 헤더 정보와 내용을 가공하는 용도로 사용
	 */

		// 200 OK 상태 코드를 전송
		// Void 타입은 아무런 형태가 아닌데 제네릭타입의 뭔가는 채워야겠어서 채우는 Placeholder와 같은 느낌이라 생각하면 됨
		@ResponseBody
		@RequestMapping(value = "/goHome0601", method = RequestMethod.GET)
		public ResponseEntity<Void> goHome0601(){
			log.info("goHome0601() 실행...!");
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
	/* 7) ResponseEntity<String> 타입
	 * - response 할때 HTTP 헤더 정보와 문자열 데이터를 전달하는 용도로 사용
	 */
		
		// "SUCCESS" 메세지와 200 OK 상태 메세지 전송
		@ResponseBody
		@RequestMapping(value = "/goHome0701", method = RequestMethod.GET)
		public ResponseEntity<String> goHome0701(){
			log.info("goHome0701() 실행...!");
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		
	/* 8) ResponseEntity<자바빈즈 클래스> 타입
	 * - response 할 때 HTTP 헤더 정보와 객체 데이터를 전달하는 용도로 사용한다.
	 */

		@ResponseBody
		@RequestMapping(value = "/goHome0801", method = RequestMethod.GET)
		public ResponseEntity<Member> goHome0801(){
			log.info("goHome0801() 실행...!");
			Member member = new Member();
			return new ResponseEntity<Member>(member,HttpStatus.OK);
		}
		
	/* 9) ResponseEntity<List> 타입
	 * - response 할 때 HTTP 헤더 정보와 객체 배열 데이터를 전달하는 용도로 사용한다.
	 */
		
		@ResponseBody
		@RequestMapping(value = "/goHome0901", method = RequestMethod.GET)
		public ResponseEntity<List<Member>> goHome0901(){
			log.info("goHome0901() 실행...!");
			
			List<Member> list = new ArrayList<Member>();
			
			Member member = new Member();
			Member member2 = new Member();
			
			list.add(member);
			list.add(member2);
			
			return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
		}
		
		/* 10) ResponseEntity<Map> 타입
		 * - response 할 때 HTTP 헤더 정보와 객체 데이터를 Map 형태로 전달하는 용도로 사용
		 */
		
		@ResponseBody
		@RequestMapping(value = "/goHome1001", method = RequestMethod.GET)
		public ResponseEntity<Map<String, Member>> goHome1001(){
			log.info("goHome1001() 실행...!");
			
			Map<String, Member> map = new HashMap<String, Member>();
			
			Member member = new Member();
			Member member2 = new Member();
			
			map.put("key1", member);
			map.put("key2", member2);
			
			return new ResponseEntity<Map<String,Member>>(map, HttpStatus.OK);
			
		}
		
		/* 11) ResponseEntity<byte[]> 타입
		 * - response 할 때 HTTP 헤더 정보와 바이너리 파일 데이터를 전달하는 용도로 사용한다.
		 * - 파일을 처리하기 위해서 commons-io 의존라이브러리를 추가(pom.xml)
		 * 
		 * > 무료/유료 이미지 다운로드 홈페이지를 사용해보면 이미지 미리보기 또는 미리보기 후 다운로드를 할 수 있는 기능 제공
		 * 	이와 같은 리턴타입의 형태를 설정해서 내보내는 것과 같다.
		 */
		
		// 바이트 배열로 이미지 파일의 데이터를 전송한다.
		@ResponseBody
		@RequestMapping(value = "/goHome1101", method = RequestMethod.GET)
		public ResponseEntity<byte[]> goHome1101(){
			log.info("goHome1101() 실행...!");
			InputStream in = null;
			ResponseEntity<byte[]> entity = null;
			
			try {
				HttpHeaders headers = new HttpHeaders();
				in = new FileInputStream("E:/99.JSP&SPRING/02.SPRING2/image/cat.jpg");
				headers.setContentType(MediaType.IMAGE_JPEG);
				entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			}catch(Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			}
			
			return entity;
		}
		
	// 12) 다운로드
		
		@ResponseBody
		@RequestMapping(value = "/goHome1102", method = RequestMethod.GET)
		public ResponseEntity<byte[]> goHome1102(){
			log.info("goHome1102() 실행...!");
			
			String fileName = "cat.jpg";
			InputStream in = null;
			ResponseEntity<byte[]> entity = null;
			
			try {
				HttpHeaders headers = new HttpHeaders();
				in = new FileInputStream("E:/99.JSP&SPRING/02.SPRING2/image/" + fileName);
				
				// 내보낼 데이터를 이진 데이터로 처리
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
				entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			}catch(Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			}
			return entity;
		}
	
}
