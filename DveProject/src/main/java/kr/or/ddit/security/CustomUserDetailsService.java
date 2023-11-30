package kr.or.ddit.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.or.ddit.mapper.LoginMapper;
import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.vo.CustomUser;
import kr.or.ddit.vo.DDITMemberVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Inject
	private LoginMapper loginMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loadUserByUsername() 실행...!");
		
		DDITMemberVO member;
		try {
			member = loginMapper.readByUserId(username);
			log.info("queried by member mapper : " + member);
			return member == null ? null : new CustomUser(member);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
