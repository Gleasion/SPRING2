package kr.or.ddit.controller;

import java.security.Principal;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private PasswordEncoder pe;
	
	@PostConstruct
	public void init() {
		log.info("password(encode) : " + pe.encode("1234"));
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "board/list";
	}
	
	// 2개를 넣어주려고 hasAnyRole 사용
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(Principal principal) {
		
	// 사용자 정보 가져오기
		// 방법1 - principal 객체를 이용
		log.info("principal 사용자 Name : " + principal.getName());
		
		// 방법2 - SecurityContextHolder 객체를 이용
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.info("SecurityContextHolder.username : " + user.getUsername());
		log.info("SecurityContextHolder.password : " + user.getPassword());
		
		Iterator<GrantedAuthority> ite = user.getAuthorities().iterator();
		while(ite.hasNext()) {
			log.info("권한 : " + ite.next().getAuthority());
		}
		
		return "board/register";
	}
	
	
	
}
