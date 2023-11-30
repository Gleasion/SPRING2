package kr.or.ddit.mapper;

import java.util.Map;

import kr.or.ddit.vo.DDITMemberVO;

public interface LoginMapper {

	public DDITMemberVO loginCheck(DDITMemberVO member);

	public DDITMemberVO idCheck(String memId);

	public int signup(DDITMemberVO memberVO);

	public String idFind(Map<String, String> map);

	public String pwFind(Map<String, String> map);

	public DDITMemberVO readByUserId(String username);

	public void signupAuth(int memNo);

}
