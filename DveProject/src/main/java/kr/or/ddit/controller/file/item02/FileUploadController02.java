package kr.or.ddit.controller.file.item02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.controller.file.item02.service.IItemService2;
import kr.or.ddit.vo.Item2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/item2")
public class FileUploadController02 {
	
	/*
		13장 파일 업로드
		
		3. 여러 개의 이미지 업로드
		- 한 번에 여러 개의 이미지를 업로드하는 파일 업로드 기능을 구현한다.
		 
		# 데이터베이스 만들기
		- item	2 이미 만듬
		
		# 파일 업로드 구현 설명
			          
			- 파일 업로드 등록 화면 컨트롤러 만들기 (FileUploadController02)
			- 파일 업로드 등록 화면 메소드 만들기 (item2RegisterForm:get)
			- 파일 업로드 등록 화면 만들기 (item2/register.jsp)
          	
          	- 파일 업로드 등록 기능 컨트롤러 메소드 만들기(item2Register:post)
			- 파일 업로드 등록 기능 서비스 인터페이스 메소드 만들기
			- 파일 업로드 등록 기능 서비스 클래스 메소드 만들기
			- 파일 업로드 등록 기능 서비스 Mapper 인터페이스 메소드 만들기
			- 파일 업로드 등록 기능 Mpper xml 쿼리 만들기
			- 파일 업로드 등록 완료 페이지 만들기
			
			- 파일 업로드 목록 화면 컨트롤러 메소드 만들기 (item2List:get)
			- 파일 업로드 목록 화면 서비스 인터페이스 메소드 만들기
			- 파일 업로드 목록 화면 서비스 클래스 메소드 만들기
			- 파일 업로드 목록 화면 Mapper 인터페이스 메소드 만들기
			- 파일 업로드 목록 화면 Mapper xml 쿼리 만들기
			- 파일 업로드 목록 화면 만들기 (ite2m/list.jsp)
			
			- 파일 업로드 수정 화면 컨트롤러 메소드 만들기 (item2ModifyForm:get)
			- 파일 업로드 수정 화면 서비스 인터페이스 메소드 만들기
			- 파일 업로드 수정 화면 서비스 클래스 메소드 만들기
			- 파일 업로드 수정 화면 Mapper 인터페이스 메소드 만들기
			- 파일 업로드 수정 화면 만들기 (item2/modify.jsp)
			
			- 파일 업로드 수정 기능 컨트롤러 메소드 만들기 (item2Modify:post)
			- 파일 업로드 수정 기능 서비스 인터페이스 메소드 만들기
			- 파일 업로드 수정 기능 서비스 클래스 메소드 만들기
			- 파일 업로드 수정 기능 Mapper 인터페이스 메소드 만들기
			- 파일 업로드 수정 기능 Mapper xml 쿼리 만들기
			
			- 파일 업로드 삭제 화면 컨트롤러 메소드 만들기 (item2RemoveForm:get)
			- 파일 업로드 삭제 화면 서비스 인터페이스 메소드 만들기
			- 파일 업로드 삭제 화면 서비스 클래스 메소드 만들기
			- 파일 업로드 삭제 화면 Mapper 인터페이스 메소드 만들기
			- 파일 업로드 삭제 화면 만들기 (item2/remove.jsp)
			
			- 파일 업로드 삭제 기능 컨트롤러 메소드 만들기 (item2Remove:post)
			- 파일 업로드 삭제 기능 서비스 인터페이스 메소드 만들기
			- 파일 업로드 삭제 기능 서비스 클래스 메소드 만들기
			- 파일 업로드 삭제 기능 Mapper 인터페이스 메소드 만들기
			- 파일 업로드 삭제 기능 Mapper xml 쿼리 만들기
			
		
	 */
	
	@Resource(name="uploadPath")
	private String resourcePath;
	
	@Inject
	private IItemService2 itemService;
	
//	@GetMapping(value = "/register")
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String item2RegisterForm() {
		log.info("item2RegisterForm() 실행...!");
		return "item2/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String item2Register(Item2 item, Model model) throws IOException {
		log.info("item2Register() 실행...!");
		
		List<MultipartFile> pictures = item.getPictures();
		
		for(int i = 0; i < pictures.size(); i++) {
			MultipartFile file = pictures.get(i);
			
			log.info("originalName : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
			log.info("contextType : " + file.getContentType());
			
			String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
			
			if(i == 0) {			// 첫번째 URL 정보 세팅
				item.setPictureUrl(savedName);
			}else if(i == 1) {		// 두번째 URL 정보 세팅
				item.setPictureUrl2(savedName);
			}
		}
		
		itemService.register(item);
		
		model.addAttribute("msg","등록이 완료 되었습니다.");
		
		return "item2/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String itemList(Model model) {
		log.info("itemList() 실행...!");
		
		List<Item2> itemList = itemService.list();
		
		model.addAttribute("itemList", itemList);
	
		return "item2/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String itemModifyForm(int itemId, Model model) {
		log.info("itemModifyForm() 실행...!");
		
		Item2 item = itemService.read(itemId);
		
		model.addAttribute("item", item);
		return "item2/modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String itemModify(Item2 item, Model model) throws IOException {
		log.info("itemModify() 실행...!");
		
		List<MultipartFile> pictures = item.getPictures();
		
		for(int i = 0; i < pictures.size(); i++) {
			MultipartFile file = pictures.get(i);
			
			log.info("originalName : + " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
			log.info("contextType : " + file.getContentType());
			
			String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
			
			if(i == 0) {
				item.setPictureUrl(savedName);
			}else if(i == 1) {
				item.setPictureUrl2(savedName);
			}
		}
		
		itemService.modify(item);
		
		model.addAttribute("msg","수정이 완료되었습니다.");
		
		return "item2/success";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String item2RemoveForm(int itemId, Model model) {
		log.info("item2RemoveForm() 실행...!");
		
		Item2 item = itemService.read(itemId);
		
		model.addAttribute("item",item);
		
		return "item2/remove";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String item2Remove(Item2 item, Model model) {
		log.info("item2Remove() 실행...!");
		
		itemService.remove(item.getItemId());
		
		model.addAttribute("msg","삭제가 완료되었습니다.");
		
		return "item2/success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/display")
	public ResponseEntity<byte[]> displayFile(int itemId) throws IOException{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		String fileName = itemService.getPicture(itemId);
		log.info("fileName : " + fileName);
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);	// 확장자 추출
			MediaType mType = getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			
			// 예) C:/upload/UUID + "_" + 원본 파일명
			in = new FileInputStream(resourcePath + File.separator + fileName);
			if(mType != null) {
				headers.setContentType(mType);
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/display2")
	public ResponseEntity<byte[]> displayFile2(int itemId) throws IOException{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		String fileName = itemService.getPicture2(itemId);
		log.info("fileName : " + fileName);
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);	// 확장자 추출
			MediaType mType = getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			
			// 예) C:/upload/UUID + "_" + 원본 파일명
			in = new FileInputStream(resourcePath + File.separator + fileName);
			if(mType != null) {
				headers.setContentType(mType);
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		
		return entity;
	}
	
	// 확장자에 알맞는 미디어타입(ContentType) 가져오기
	private MediaType getMediaType(String formatName) {
		if(formatName != null) {
			if(formatName.toUpperCase().equals("JPG")) {
				return MediaType.IMAGE_JPEG;
			}
			if(formatName.toUpperCase().equals("GIF")) {
				return MediaType.IMAGE_GIF;
			}
			if(formatName.toUpperCase().equals("PNG")) {
				return MediaType.IMAGE_PNG;
			}
		}
		
		return null;
	}
	
	private String uploadFile(String originalName, byte[] fileData) throws IOException {
		log.info(resourcePath);	// root-context.xml에서 설정한 uploadPath
		
		UUID uuid = UUID.randomUUID();	// UUID로 파일명 생성
		String createFileName = uuid.toString() + "_" + originalName;
		
		File file = new File(resourcePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		File target = new File(resourcePath, createFileName);	// 파일 업로드 준비
		FileCopyUtils.copy(fileData, target);	// 파일 복사 진행
		
		return createFileName;
	}
	
}
