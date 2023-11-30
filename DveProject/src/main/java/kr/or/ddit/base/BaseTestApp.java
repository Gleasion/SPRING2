package kr.or.ddit.base;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.vo.PaginationInfoVO;

public class BaseTestApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"/kr/or/ddit/base/context-test.xml"});
		
		
		NoticeBoardMapper noticeBoardMapper = (NoticeBoardMapper)context.getBean("noticeBoardMapper");
		
		System.out.println(noticeBoardMapper);
		
		PaginationInfoVO<HeadBoardVO> pagingVO = new PaginationInfoVO<HeadBoardVO>();
		pagingVO.setStartRow(0);
		pagingVO.setEndRow(10);
		
		List<HeadBoardVO> list = noticeBoardMapper.selectBoardList(pagingVO);
		for(HeadBoardVO headBoardVO:list) {
			System.out.println(headBoardVO);
		}		
	}
}
