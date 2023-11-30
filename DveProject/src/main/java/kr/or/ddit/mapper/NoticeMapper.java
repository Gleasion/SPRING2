package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.vo.NoticeFileVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface NoticeMapper {

	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);

	public int insertNotice(NoticeVO noticeVO);

	public void incrementHit(int boNo);

	public NoticeVO selectNotice(int boNo);

	public int updateNotice(NoticeVO noticeVO);

	public int deleteNotice(int boNo);

	public void insertNoticeFile(NoticeFileVO noticefileVO);

	public NoticeFileVO noticeDownload(int fileNo);

	public void incrementNoticeDownloadCount(int fileNo);

	public NoticeFileVO selectNoticeFile(Integer integer);

	public void deleteNoticeFile(Integer integer);

	public void deleteNoticeFileByBoNo(int boNo);

}
