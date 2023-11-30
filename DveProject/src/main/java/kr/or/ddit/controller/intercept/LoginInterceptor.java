package kr.or.ddit.controller.intercept;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final String USER_INFO = "userInfo";
	
	// 지정된 컨트롤러의 동작 이전에 가로채는 역할로 사용한다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle() 실행...!");
		
		String requestURL = request.getRequestURL().toString();		// http://localhost/login1
		String requestURI = request.getRequestURI();				// /login1
		
		log.info("requestURL : " + requestURL);
		log.info("requestURI : " + requestURI);
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		log.info("Bean : " + method.getBean());	// kr.or.ddit.controller.login.LoginController@3215g22
		log.info("method : " + methodObj);		// public java.lang.String kr.or.ddit.controller.login.LoingController.loginForm();
		
		// 'userInfo' 키를 가지고 있는 세션이 존재하면 삭제 처리로 초기화
		HttpSession session = request.getSession();
		if(session.getAttribute(USER_INFO) != null) {
			session.removeAttribute(USER_INFO);
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle() 실행...!");
		
		String requestURL = request.getRequestURL().toString();		// http://localhost/login1
		String requestURI = request.getRequestURI();				// /login1
		
		log.info("requestURL : " + requestURL);
		log.info("requestURI : " + requestURI);
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		log.info("Bean : " + method.getBean());	// kr.or.ddit.controller.login.LoginController@3215g22
		log.info("method : " + methodObj);		// public java.lang.String kr.or.ddit.controller.login.LoingController.loginForm();
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object member = modelMap.get("user");
		
		// 넘겨받은 데이터가 null이 아닌 경우 세션에 등록한다.
		if(member != null) {
			log.info("member : " + member);
			log.info("member != null");
			session.setAttribute(USER_INFO, member);
			response.sendRedirect("/");
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion() 실행...!");
		
		String requestURL = request.getRequestURL().toString();		// http://localhost/login1
		String requestURI = request.getRequestURI();				// /login1
		
		log.info("requestURL : " + requestURL);
		log.info("requestURI : " + requestURI);
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		log.info("Bean : " + method.getBean());	// kr.or.ddit.controller.login.LoginController@3215g22
		log.info("method : " + methodObj);		// public java.lang.String kr.or.ddit.controller.login.LoingController.loginForm();
		
	}
	
	
	
}
