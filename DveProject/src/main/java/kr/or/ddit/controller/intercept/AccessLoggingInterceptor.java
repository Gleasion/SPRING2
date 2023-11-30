package kr.or.ddit.controller.intercept;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccessLoggingInterceptor extends HandlerInterceptorAdapter{

	PrintWriter writer;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle() 실행...!");
		
		File file = new File("C:/logs/ddit_logging.log");
		
		writer = new PrintWriter(new FileWriter(file, true), true);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle() 실행...!");
		String requestURI = request.getRequestURI();
		log.info("requestURI : " + requestURI);
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		Class clazz = methodObj.getDeclaringClass();		// class kr.or.ddit.controller.BoardController와 같은 녀석
		
		String clazzName = clazz.getName();					// 컨트롤러명
		String clazzSimpleName = clazz.getSimpleName();		// 패키지명을 제외한 컨트롤러명
		String methodName = methodObj.getName();			// 메소드 명
		
		writer.printf("현재일시 : %s %n", getCurrentTime());
		writer.printf("Access Controller : %s %n", clazzName + "." + methodName);
		writer.println("===========================");
	}

	public String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(cal.getTime());
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion() 실행...!");
	}

	
}
