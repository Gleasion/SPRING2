package kr.or.ddit.controller.file.item03;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	
	// 파일 업로드를 처리하고 업로드된 파일의 경로를 반환하는 역할
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws IOException {
		
		//  UUID는 중복을 피하기 위한 고유 식별자 : 파일명을 고유하게 생성
		UUID uuid = UUID.randomUUID();
		String savedName = uuid.toString() + "_" + originalName;
		
		// 2023/09/04 폴더 경로를 만들고, /2023/09/04 폴더 경로를 리턴한다.
		String savedPath = clacPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);
		
		// 위에서 만들어진 경로와 파일명을 가지고 파일 복사를 진행한다.
		FileCopyUtils.copy(fileData, target);
		
		// 확장자를 추출하는 이유 : 이미지 파일인지 일반 파일인지를 구분학하위해서
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);	// 확장자 추출
		String uploadedFileName = savedPath.replace(File.separatorChar, '/') + "/" + savedName;
		
		if(MediaUtils.getMediaType(formatName) != null) {
	         makeThumbnail(uploadPath, savedPath, savedName);
		}
		return uploadedFileName;
	}
	
	// 현재 날짜를 기반으로 년/월/일 형식의 경로를 생성
	// /2023/09/04 경로 생성
	private static String clacPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		
		// DecimalFormat("00") :: 두자리에서 빈자리는 0으로 채움
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		return datePath;
	}
	
	// 주어진 경로 배열을 기반으로 디렉토리를 생성
	// 가변인자 : 배열형식으로 들어옴
	// 키워드 "..." 를 사용한다.
	// [사용법] 타입... 변수명 형태로 사용
	// 순서대로 yearPath, mothPath, dataPath가 배열로 들어가 처리
	private static void makeDir(String uploadPath, String ...paths) {
		
		// datePath가 있으면 return
		if(new File(paths[paths.length - 1]).exists()) {
			return;
		}
		
		// 있다면 폴더 구조를 하나씩 만들어줌
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			
			// /2023/09/04과 같은 경로에 각 폴더가 없으면 각각 만들어준다.
			if(!dirPath.exists()) {
				dirPath.mkdirs();
			}
		}
	}
	
	// 이미지 파일에 대한 썸네일 이미지를 생성
	private static void makeThumbnail(String uploadPath, String path, String fileName) throws IOException {
		// 썸네일 이미지를 만들기 위해 원본이미지를 읽는다.
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		
		// Method.AUTOMATIC : 최소 시간 내에 가장 잘 보이는 이미지를 얻기 위한 사용 방식
		// Mode.FIT_TO_HEIGHT : 이미지 방향과 상관없이 주어진 높이 내에서 가장 잘 맞는 이미지로 계산
		// targetSize : 값 100, 정사각형 사이즈로 100x100
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		// 업로드 한 원본 이미지를 가지고 "s_"를 붙여서 임시 파일로 만들기 위해 썸네일 경로 + 파일명을 작성한다.
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
	}
	
}
