package kr.or.ddit.controller.noticeboard.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.or.ddit.controller.noticeboard.service.INoticeService;
import kr.or.ddit.controller.noticeboard.view.NoticeDownloadView;
import kr.or.ddit.vo.NoticeFileVO;

@Controller
public class NoticeDownloadController {
	
	@Inject
	private INoticeService noticeService;
	
	@RequestMapping(value = "/notice/download.do")
	public View noticeProcess(int fileNo, ModelMap model) {
		
		// 선택한 파일을 다운로드 하기 위한 정보를 파일번호에 해당하는 파일 정보로 얻어온다.
		NoticeFileVO noticeFileVO = noticeService.noticeDownload(fileNo);
		
		// 데이터 전달자를 통해서 파일정보를 전달하기 위한 Map 선언
		Map<String, Object> noticeFileMap = new HashMap<String, Object>();
		noticeFileMap.put("fileName", noticeFileVO.getFileName());
		noticeFileMap.put("fileSize", noticeFileVO.getFileSize());
		noticeFileMap.put("fileSavepath", noticeFileVO.getFileSavepath());
		model.addAttribute("noticeFileMap", noticeFileMap);
		
		// 리턴되는 noticeDownloadView는 jsp페이지로 존재하는 Name을 요청하는게 아니라,
		// 클래스를 요청하는 것인데 해당 클래스가 스프링에서 제공하는 AbstractView 클래스를 상속받은 클래스
		return new NoticeDownloadView();	// 클래스를 페이지처럼 만들어 리턴
	}
	
	
	
	
}
