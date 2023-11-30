package kr.or.ddit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ajax")
public class AjaxMemberFileController {
	
	@RequestMapping(value = "registerFileForm", method = RequestMethod.GET)
	public String ajaxRegisterFileForm() {
		return "member/ajaxRegisterFile";
	}
	
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file){
		String orginalFileName = file.getOriginalFilename();
		log.info("originalName : " + orginalFileName);
		
		ResponseEntity<String> entity = new ResponseEntity<String>("UPLOAD SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
