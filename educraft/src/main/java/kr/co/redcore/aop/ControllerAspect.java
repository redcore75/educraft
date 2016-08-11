package kr.co.redcore.aop;

import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import kr.co.redcore.GlobalConstants;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.domain.Tbl_member_access_log;
import kr.co.redcore.mapper.Tbl_memberMapper;
import kr.co.redcore.service.member.LoginService;
import kr.co.redcore.service.member.MemberAccessLogService;

@Aspect
@Component
public class ControllerAspect {
	private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private MemberAccessLogService memberAccessLogService;
	
	@Pointcut("execution(* kr.co.redcore..*Controller.**(..))")
	public void allControllerMethod() {		
	}
	
	/**
	 * Controller 요청 정보를 로그로 남긴다.
	 * 
	 * @param joinPoint
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Before("allControllerMethod()")
	public void printLog(JoinPoint joinPoint) throws Exception {
		logger.debug("### Controller Before Advice Start !! ###");

		HttpServletRequest httpReq = null;
		HttpServletResponse httpRes = null;
		Map<String, Object> params = null;
		
		for (Object object : joinPoint.getArgs()) {
			if (object instanceof HttpServletRequest) {
				httpReq = (HttpServletRequest) object;
			} else if (object instanceof HttpServletResponse) {
				httpRes = (HttpServletResponse) object;
			} else if (object instanceof Map) {
				params = (Map<String, Object>) object;
			}
		}
		
		logger.debug("Controller Class => " + joinPoint.getTarget().getClass().getSimpleName());
		logger.debug("Controller Method => " + joinPoint.getSignature().getName());
		
		if(httpReq != null) {
			logger.debug("URL => " + httpReq.getRequestURI() == null ? "httpReq.getRequestURI() is null" : httpReq.getRequestURI());
	
			logger.debug("################################################################################");
			logger.debug("Params => ");
			
			Set<String> keys = httpReq.getParameterMap().keySet();
			for (String key : keys) {
				logger.debug(key + " = " + httpReq.getParameter(key));
			}
			logger.debug("################################################################################");

			if(loginService.isLogin(httpReq, GlobalConstants.ADMIN_LOGININFO_KEY)) {
				Tbl_member tbl_member = loginService.getLoginInfo(httpReq, GlobalConstants.ADMIN_LOGININFO_KEY);
				
				Tbl_member_access_log tbl_member_access_log = new Tbl_member_access_log();
				tbl_member_access_log.setMember_seq(tbl_member.getMember_seq());
				tbl_member_access_log.setMember_id(tbl_member.getMember_id());
				tbl_member_access_log.setIp_addr(httpReq.getRemoteAddr());
				tbl_member_access_log.setAccess_url( httpReq.getRequestURI());
				tbl_member_access_log.setRegby(tbl_member.getMember_id());
				memberAccessLogService.insertTbl_member_access_log(tbl_member_access_log);
				
				logger.debug("URL => " + httpReq.getRequestURI() + " : access log insert !!!");
			}
		} else {
			logger.debug("HttpServletRequest is null");
		}
		
		logger.debug("### Controller Before Advice End !! ###");
		logger.debug("------------------- controller start -----------------------------------------------------");
	}
	
	/**
	 * Controller 실행시간을 남긴다.
	 * 
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@SuppressWarnings("unchecked")
	@Around("allControllerMethod()")
	public Object printLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.debug("@@@@@@@@@@@@@ >>> Around Action Execution Time Start !! >>>");
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object retObj = proceedingJoinPoint.proceed();
		
		stopWatch.stop();
		
		logger.debug("------------------- controller end -------------------------------------------------------");
		logger.debug(">>> " + proceedingJoinPoint.getTarget().getClass() + " Execution time : " + stopWatch.getTotalTimeSeconds());
		logger.debug("@@@@@@@@@@@@@ >>> Around Action Execution Time END !! >>>");
		
		return retObj;
	}
}