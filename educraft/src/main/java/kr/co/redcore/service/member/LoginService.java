package kr.co.redcore.service.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.redcore.GlobalConstants;
import kr.co.redcore.domain.Tbl_member;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	private MemberService memberService;

	@Transactional(rollbackFor = {Exception.class})
	public boolean loginProcess(HttpServletRequest request, HttpServletResponse response, String key, String member_id, String password) throws Exception {
		Tbl_member tbl_member = memberService.getTbl_memberByMember_idEtc(member_id, password);
		if (tbl_member != null) {
			setLoginInfo(request, response, key, tbl_member);
			logger.debug(">>> login success !!! member_id >>> " + member_id);
			return true;
		} else {
			logger.debug(">>> login fail !!! member_id >>> " + member_id);
			return false;
		}
	}

	public boolean isLogin(HttpServletRequest request, String key) {
		return (getLoginInfo(request, key) != null ? true : false);
	}

	public Tbl_member getLoginInfo(HttpServletRequest request, String key) {
		HttpSession session = request.getSession(true);
		
		if(key.equals(GlobalConstants.ADMIN_LOGININFO_KEY)) {
			return (Tbl_member) session.getAttribute(GlobalConstants.ADMIN_LOGININFO_KEY);
		} else {
			return null;
		}
	}

	public void setLoginInfo(HttpServletRequest request, HttpServletResponse response, String key, Tbl_member tbl_member) {
		HttpSession session = request.getSession(true);
		
		if(key.equals(GlobalConstants.ADMIN_LOGININFO_KEY)) {
			session.setAttribute(GlobalConstants.ADMIN_LOGININFO_KEY, tbl_member);
			// session.setMaxInactiveInterval(-1);
		}
	}

	public void removeLoginInfo(HttpServletRequest request, HttpServletResponse response, String key) {
		HttpSession session = request.getSession(true);
		if(key.equals(GlobalConstants.ADMIN_LOGININFO_KEY)) {
			session.removeAttribute(GlobalConstants.ADMIN_LOGININFO_KEY);
		}
	}
}
