package kr.or.ddit.base;

import java.util.List;

import kr.or.ddit.vo.PaginationInfoVO;

public interface NoticeBoardMapper {
	
	//
	public List<HeadBoardVO> selectBoardList(PaginationInfoVO<HeadBoardVO> pagingVO);

}
