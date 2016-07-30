package kr.co.redcore.aop;

import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ControllerAspect {
	private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

	@Pointcut("execution(* kr.co.redcore.**.*Controller.**(..))")
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
		logger.debug("URL => " + httpReq.getRequestURI());

		logger.debug("################################################################################");
		logger.debug("Params => ");
		
		Set<String> keys = httpReq.getParameterMap().keySet();
		for (String key : keys) {
			logger.debug(key + " = " + httpReq.getParameter(key));
		}
		logger.debug("################################################################################");

		logger.debug("### Controller Before Advice End !! ###");
	}
}