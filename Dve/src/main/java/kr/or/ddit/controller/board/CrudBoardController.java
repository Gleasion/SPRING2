package kr.or.ddit.controller.board;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.Board;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/crud/board")
public class CrudBoardController {
	
	@Inject
	private IBoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String crudRegisterForm() {
		log.info("crudRegisterForm() 실행");
		return "crud/register";
	}
	
	// action="/crud/board/register"
	//    /dev/crud/board/register
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String crudRegister(Board board, Model model) {
		log.info("crudRegister() 실행");
		
		service.register(board);
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		
		//forwarding
		//servlet-context.xml 
		//<beans:property name="prefix" value="/WEB-INF/views/" />
		//<beans:property name="suffix" value=".jsp" />
		// /WEB-INF/views/crud/success.jsp
		return "crud/success";
	}
	
	
	
	
	
}
