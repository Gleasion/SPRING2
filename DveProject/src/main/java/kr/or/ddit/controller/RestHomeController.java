package kr.or.ddit.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

// @RestController는 @Controller과 @ResponseBody를 포함하고 있는 어노테이션 이다.
@Slf4j
@RestController
public class RestHomeController {
	
	// 반환값이 객체 타입이면 JSON 타입으로 자동 변환된다.
	@RequestMapping(value = "/goRestHome0301", method = RequestMethod.GET)
	public Member restHome0301() {
		log.info("restHome0301() 실행...!");
		Member member = new Member();
		return member;
	}
	
/* 4) 컬렉션 List 타입
 * - JSON 객체 배열 타입의 데이터르 만들어서 반환하는 용도로 사용한다.
 */
	
	@RequestMapping(value = "/goRestHome0401", method = RequestMethod.GET)
	public List<Member> goRestHome0401(){
		log.info("goRestHome0401() 실행...!");
		
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
	
	@RequestMapping(value = "/goRestHome0501", method = RequestMethod.GET)
	public Map<String, Member> goRestHome0501(){
		log.info("goRestHome0501() 실행...!");
		
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
	@RequestMapping(value = "/goRestHome0601", method = RequestMethod.GET)
	public ResponseEntity<Void> goRestHome0601(){
		log.info("goRestHome0601() 실행...!");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
/* 7) ResponseEntity<String> 타입
 * - response 할때 HTTP 헤더 정보와 문자열 데이터를 전달하는 용도로 사용
 */
	
	// "SUCCESS" 메세지와 200 OK 상태 메세지 전송
	@RequestMapping(value = "/goRestHome0701", method = RequestMethod.GET)
	public ResponseEntity<String> goRestHome0701(){
		log.info("goRestHome0701() 실행...!");
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
/* 8) ResponseEntity<자바빈즈 클래스> 타입
 * - response 할 때 HTTP 헤더 정보와 객체 데이터를 전달하는 용도로 사용한다.
 */
	@RequestMapping(value = "/goRestHome0801", method = RequestMethod.GET)
	public ResponseEntity<Member> goRestHome0801(){
		log.info("goRestHome0801() 실행...!");
		Member member = new Member();
		return new ResponseEntity<Member>(member,HttpStatus.OK);
	}
	
/* 9) ResponseEntity<List> 타입
 * - response 할 때 HTTP 헤더 정보와 객체 배열 데이터를 전달하는 용도로 사용한다.
 */
	
	@RequestMapping(value = "/goRestHome0901", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> goRestHome0901(){
		log.info("goRestHome0901() 실행...!");
		
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
	
	@RequestMapping(value = "/goRestHome1001", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Member>> goRestHome1001(){
		log.info("goRestHome1001() 실행...!");
		
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
	@RequestMapping(value = "/goRestHome1101", method = RequestMethod.GET)
	public ResponseEntity<byte[]> goRestHome1101(){
		log.info("goRestHome1101() 실행...!");
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
	
	@RequestMapping(value = "/goRestHome1102", method = RequestMethod.GET)
	public ResponseEntity<byte[]> goRestHome1102(){
		log.info("goRestHome1102() 실행...!");
		
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
