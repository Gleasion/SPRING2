package kr.or.ddit.service.Impl;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.MemberAuth;
import kr.or.ddit.vo.MemberVO;

@Service
public class MemberServiceImpl implements IMemberService{

	@Inject
	private MemberMapper mapper;
	
//	@Transactional(rollbackFor = {IOException.class, Exception.class})
//	@Transactional
	@Override
	public void register(MemberVO member) throws IOException {
		
		// 1. 회원정보를 등록
		mapper.create(member);
		
		// 2. 회원 등록 후 채번된 회원번호를 리턴 받아서 회원 역할을 등록
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_USER");
		
//		// 에러 발생 (롤백? -> 안됨)
//		if(true) {
//			throw new IOException();
//		}
		
//		// 에러 발생 (롤백? -> 됨)
//		if(true) {
//			throw new NullPointerException();
//		}
		mapper.createAuth(memberAuth);
	}

	@Override
	public List<MemberVO> list() {
		return mapper.list();
	}

	@Override
	public MemberVO read(int userNo) {
		return mapper.read(userNo);
	}

	@Override
	public void modify(MemberVO member) {
		// 1. 회원 데이터를 수정 (역할명을 제외)
		mapper.update(member);
		
		// 2. 회원번호에 해당하는 역할명들을 삭제
		int userNo = member.getUserNo();
		mapper.deleteAuth(userNo);
		
		// 3. 넘겨받은 수정을 위한 역할명들을 다시 등록
		List<MemberAuth> authList = member.getAuthList();
		
		for(int i = 0; i < authList.size(); i++) {
			MemberAuth memberAuth = authList.get(i);
			String auth = memberAuth.getAuth();
			
			if(auth == null) {
				continue;
			}
			
			if(auth.trim().length() == 0) {
				continue;
			}
			
			memberAuth.setUserNo(userNo);
			mapper.createAuth(memberAuth);
		}
		
	}

	@Override
	public void remove(int userNo) {
		mapper.deleteAuth(userNo);
		mapper.delete(userNo);
	}

}
