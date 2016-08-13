package kr.co.redcore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import kr.co.redcore.GlobalConstants;
import kr.co.redcore.annotation.CheckToken;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

	@Autowired
	private org.springframework.cache.CacheManager cacheManager;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean valid = true;

		if (handler instanceof ResourceHttpRequestHandler) {
			return true;
		} else {
			HandlerMethod method = (HandlerMethod) handler;
			CheckToken annotation = method.getMethodAnnotation(CheckToken.class);
			if (annotation != null) {
				String token = request.getParameter("token");
				logger.debug("token in the request <" + token + ">.");
				Cache cache = cacheManager.getCache("tokens");
				if (StringUtils.isEmpty(token)) {
					valid = false;
					logger.debug("token not found in the request.");
				} else if (!StringUtils.isEmpty(token) && cache.get(token) != null && !token.equals(cache.get(token).get())) {
					valid = false;
					logger.debug("token in the cache <" + cache.get(token) == null ? "" : cache.get(token).get() + ">.");
				} else {
					if (annotation.remove()) {
						cache.evict(token);
					}
				}

				if (!valid) {
					logger.debug("token is not valid , set error to request");
					request.setAttribute(GlobalConstants.TOKEN_ERROR_KEY, "invalid token");
				}
			}

			return super.preHandle(request, response, handler);
		}
	}
}