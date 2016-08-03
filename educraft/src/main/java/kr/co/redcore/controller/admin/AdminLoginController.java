package kr.co.redcore.controller.admin;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import kr.co.redcore.GlobalConstants;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.service.member.LoginService;

@Controller
public class AdminLoginController {
	private static final Logger logger = LoggerFactory.getLogger(AdminLoginController.class);
	
	@Autowired
	private LoginService loginService;	
		
	@RequestMapping(value = "/admin/login/loginForm.do")
	public ModelAndView loginForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/login/loginForm");
		return mv;
	}

	@RequestMapping(value = "/admin/login/login.do")
	public ModelAndView login(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {		
		String member_id = (String) params.get("member_id");
		String password = (String) params.get("password");
		
		ModelAndView mv = new ModelAndView();
		if(loginService.loginProcess(req, res, GlobalConstants.ADMIN_LOGININFO_KEY, member_id, password)) {
			mv.setViewName("admin/login/loginDone");			
			return mv;
		} else {
			mv.setViewName("admin/login/loginForm");
			return mv;
		}
	}
	
	@RequestMapping(value = "/admin/login/logout.do")
	public ModelAndView logout(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {
		Tbl_member tbl_member = loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY);
		logger.debug(">>> login out !!! member_id >>> " + tbl_member.getMember_id());
		
		loginService.removeLoginInfo(req, res, GlobalConstants.ADMIN_LOGININFO_KEY);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/login/logoutDone");
		return mv;
	}
}
