package kr.or.ddit.controller.noticeboard.web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelegramSendController {
	
	public void sendGet(String name, String title) throws IOException{
		String chatId = "-951855941";
		String urlName = "https://api.telegram.org/bot6310783618:AAEI3ptPtCArMaRYoKBHxfHhjOuYcDbVUaY/sendMessage";
		String text = "";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String timeStr = format.format(time);
		
		text = name + "님께서 글 작성을 완료!\n"
					+ "[제목]\n" + title + "\n"
					+ "[작성자]\n " + timeStr + "\n";
		
		URL url = new URL(urlName + "?chat_id=" + chatId + "&text=" + URLEncoder.encode(text, "UTF-8"));
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		int respCode = conn.getResponseCode();
		System.out.println("요청 상태 코드 :" + respCode);
	}
	
}
