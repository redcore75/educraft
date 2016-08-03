package kr.co.redcore.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import kr.co.redcore.GlobalConstants;
import kr.co.redcore.service.member.LoginService;

public class LoginAdminFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(LoginAdminFilter.class);
	
	protected FilterConfig filterConfig = null;

	private Map fileExtMap = new HashMap();
	private Map notCheckMap = new HashMap();

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;

		String fileExt = filterConfig.getInitParameter("fileExt");
		String notCheck = filterConfig.getInitParameter("notCheck");

		if (fileExt != null) {
			String[] fileExtArray = fileExt.toLowerCase().split(",");
			int size = (fileExtArray == null) ? 0 : fileExtArray.length;
			for (int i = 0; i < size; i++) {
				fileExtMap.put(fileExtArray[i].trim(), fileExtArray[i].trim());
			}
		}

		if (notCheck != null) {
			String[] notCheckArray = notCheck.toLowerCase().split(",");
			int size = (notCheckArray == null) ? 0 : notCheckArray.length;
			for (int i = 0; i < size; i++) {
				notCheckMap.put(notCheckArray[i].trim(), notCheckArray[i].trim());
			}
		}
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		int lastIndex = -1;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		if (!"true".equals((String) request.getAttribute("IS_ADMINLOGIN_CHECK"))) {
			String URI = request.getRequestURI();

			String uriExtName = null;
			lastIndex = URI.lastIndexOf(".");
			if (lastIndex > -1) {
				uriExtName = URI.substring(lastIndex + 1).toLowerCase();
			} else {
				uriExtName = URI.toLowerCase();
			}

			//logger.debug("LoginAdminFilter >>> uriExtName : " + uriExtName);
			
			String uriLastName = null;
			lastIndex = URI.lastIndexOf("/");
			if (lastIndex > -1) {
				uriLastName = URI.substring(0, lastIndex + 1).toLowerCase();
			} else {
				uriLastName = URI.toLowerCase();
			}
			
			//logger.debug("LoginAdminFilter >>> uriLastName : " + uriLastName);
			//logger.debug("LoginAdminFilter >>> uriLastName : " + uriLastName.replaceFirst(request.getContextPath(), ""));
			
			if (fileExtMap.containsKey(uriExtName) && !notCheckMap.containsKey(uriLastName.replaceFirst(request.getContextPath(), ""))) {
				logger.debug("LoginAdminFilter >>> check isLogin");
				
				LoginService loginService = new LoginService();
				if (!loginService.isLogin(request, GlobalConstants.ADMIN_LOGININFO_KEY)) {
					logger.debug("------------------ not login status ------------");
					response.sendRedirect(request.getContextPath() + "/admin/login/loginForm.do");
					return;
				}
			}

			request.setAttribute("IS_ADMINLOGIN_CHECK", "true");
			//logger.debug("LoginAdminFilter >>> IS_ADMINLOGIN_CHECK setting...");
		}
		
		filterChain.doFilter(request, servletResponse);
	}
}
