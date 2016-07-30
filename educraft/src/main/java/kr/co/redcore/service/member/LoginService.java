package kr.co.redcore.service.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import kr.co.redcore.domain.Tbl_member;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	public static String LOGININFO_KEY = "admin_loginInfo";

	public void setLoginInfo(HttpServletRequest request, HttpServletResponse response, Tbl_member tbl_member) {
		HttpSession session = request.getSession(true);
		session.setAttribute(LOGININFO_KEY, tbl_member);
		// session.setMaxInactiveInterval(-1);
	}

	public Tbl_member getLoginInfo(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		return (Tbl_member) session.getAttribute(LOGININFO_KEY);
	}

	public boolean isLogin(HttpServletRequest request) {
		return (getLoginInfo(request) != null);
	}

	public void removeLoginInfo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.removeAttribute(LOGININFO_KEY);
	}
}
