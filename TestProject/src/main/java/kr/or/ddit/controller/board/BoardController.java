package kr.or.ddit.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping(value="/list.do", method = RequestMethod.GET)
	public String boardList() {
		return "board/list";
	}
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String boardDetail() {
		return "board/detail";
	}
	
	@RequestMapping(value="/form.do", method = RequestMethod.GET)
	public String boardForm() {
		return "board/form";
	}
	
}
