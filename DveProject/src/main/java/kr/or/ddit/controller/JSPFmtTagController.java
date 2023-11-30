package kr.or.ddit.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("fmttag")
public class JSPFmtTagController {
	
	/*
		7. 숫자 및 날짜 포멧팅 처리 태그
		- 숫자 및 날짜의 포맷팅과 관련된 태그입니다.
		
			1) <fmt:formataNumber>
			- 숫자를 형식화 한다.
				──────────────────────────────────────────────────────────────────
						속성		|		타입		|		설명
				──────────────────────────────────────────────────────────────────
					value		|	String		|	서식에 맞춰 출력할 숫자
								|	of Number	|	
					type		|	String		|	어떤 서식으로 출력할지를 정한다.
					pattern		|	String		|	직접 숫자를 출력할 서식을 정한다.
					var			|	String		|	포맷팅한 결과를 지정할 변수 이름
				──────────────────────────────────────────────────────────────────
				type 속성 : number일 경우 숫자 형식으로, percent일 경우 % 형식으로, currency 일 경우 통화형식으로 출력된다.
				기본값은 number이다.
				
			
			2) <fmt:parseNumber>
			- 문자열을 숫자로 변환한다.
				──────────────────────────────────────────────────────────────────
						속성		|		타입		|		설명
				──────────────────────────────────────────────────────────────────
					value		|	String		|	 파싱할 문자열
					type		|	String		|	value 속성의 문자열 타입을 지정
					parttern	|	String		|	파싱할 때 직접 사용할 서식을 지정한다.
					var			|	String		|	파싱할 결과를 저장할 변수 이름을 지정한다.
				──────────────────────────────────────────────────────────────────
				type: 속성 number, currency, parcent가 올 수 있다.
				기본값은 number이다.
			
				
			3) <fmt:formatDate>
			- Date 객체를 문자열로 변환한다.
				──────────────────────────────────────────────────────────────────
						속성		|		타입		|		설명
				──────────────────────────────────────────────────────────────────
					value		|	Date		|	포맷팅한 날짜 및 시간 값
					type		|	String		|	날짜, 시간 또는 둘 다 포맷팅 할지의 여부를 지정한다.
					dateStyle	|	String		|	날짜에 대해 미리 정의된 포맷팅 스타일을 지정한다.
					timeStyle	|	String		|	시간에 대해 미리 정의된 포맷팅 스타일을 지정한다.
					pattern		|	String		|	파싱할 때 직접 사용할 서식을 지정한다.
					var			|	String		|	파싱한 결과를 저장할 변수 이름을 지정한다.
				──────────────────────────────────────────────────────────────────
				type 속성: time, date, both 중 한가지 값을 가질 수 있으며 기본값은 date이다.
				dateStyle 속성 : default, short, medium, long, full 중 한가지 값을 가질 수 있으며, 기본값은 default이다.
				timeStyle 속성 : default, short, medium, long, full 중 한가지 값을 가질 수 있으며, 기본값은 default이다.
				
			4) <fmt:parseDate>
			- 문자열을 Date 객체로 변환한다.
				──────────────────────────────────────────────────────────────────
						속성		|		타입		|		설명
				──────────────────────────────────────────────────────────────────
					value		|	String		|	파싱할 문자열
					type		|	String		|	날짜, 시간 또는 둘 다 포맷팅 할지의 여부를 지정한다.
					dateStyle	|	String		|	날짜에 대해 미리 정의된 포맷팅 스타일을 지정한다.
					timeStyle	|	String		|	시간에 대해 미리 정의된 포맷팅 스타일을 지정한다.
					pattern		|	String		|	파싱할 때 직접 사용할 서식을 지정한다.
					var			|	String		|	파싱한 결과를 저장할 변수 이름을 지정한다.
				──────────────────────────────────────────────────────────────────
				type 속성: time, date, both 중 한가지 값을 가질 수 있으며 기본값은 date이다.
				dateStyle 속성 : default, short, medium, long, full 중 한가지 값을 가질 수 있으며, 기본값은 default이다.
				timeStyle 속성 : default, short, medium, long, full 중 한가지 값을 가질 수 있으며, 기본값은 default이다.
	 */
	
	
	// 1) type 속성을 지정하거나 pattern 속성을 지정하여 숫자를 형식화 한다.
	@RequestMapping(value = "/home0101", method = RequestMethod.GET)
	public String home0101(Model model) {
		int coin = 100;
		model.addAttribute("coin", coin);
		return "home/fmttag/home0101";
	}
	
	// 2) type 속성이 지정되지 않으면 기본값은 number이다.
	@RequestMapping(value = "/home0201", method = RequestMethod.GET)
	public String home0201(Model model) {
//		int coin = 1000;
//		String coin = "￦1000";
		String coin = "1000%";
		model.addAttribute("coin", coin);
		return "home/fmttag/home0201";
	}
	
	// 3) pattern 속성을 사용하여 직접 사용할 서식을 지정한다.
	@RequestMapping(value = "/home0202", method = RequestMethod.GET)
	public String home0202(Model model) {
		String coin = "1,000.25";
		model.addAttribute("coin", coin);
		return "home/fmttag/home0202";
	}
	
	// 4) type 속성을 date로 지정하여 날자 포맷팅을 한다.
	@RequestMapping(value = "/home0301", method = RequestMethod.GET)
	public String home0301(Model model) {
		Date date = new Date();
		model.addAttribute("now", date);
		return "home/fmttag/home0301";
	}
	
	// 4) type 속성을 time로 지정하여 날자 포맷팅을 한다.
	@RequestMapping(value = "/home0302", method = RequestMethod.GET)
	public String home0302(Model model) {
		Date date = new Date();
		model.addAttribute("now", date);
		return "home/fmttag/home0302";
	}
	
	// 5) type 속성을 both로 지정하여 날자 포맷팅을 한다.
	@RequestMapping(value = "/home0303", method = RequestMethod.GET)
	public String home0303(Model model) {
		Date date = new Date();
		model.addAttribute("now", date);
		return "home/fmttag/home0303";
	}
	
	// 7) dateStyle 속성을 short로 지정하여 문자열을 Date 객체로 변환한다.
	   @RequestMapping(value = "/home0401", method = RequestMethod.GET)
	   public String home0401(Model model) {
	      String dateValue = "20. 2. 1";
	      model.addAttribute("dateValue", dateValue);
	      return "home/fmttag/home0401";
	   }
	
	// 6) dateStyle 속성을 long로 지정하여 문자열을 Date 객체로 변환한다.
	@RequestMapping(value = "/home0402", method = RequestMethod.GET)
	public String home0402(Model model) {
		String dateValue = "2019년 2월 1일 (금)";
		model.addAttribute("dateValue", dateValue);
		return "home/fmttag/home0402";
	}
	
	
	
	
}
