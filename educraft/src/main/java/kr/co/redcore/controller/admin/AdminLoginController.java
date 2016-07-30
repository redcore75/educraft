package kr.co.redcore.controller.admin;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminLoginController {
	private static final Logger logger = LoggerFactory.getLogger(AdminLoginController.class);
	
	@RequestMapping(value = "/admin/login/loginForm.do")
	public ModelAndView loginForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/login/loginForm");
		return mv;
	}
	
	@RequestMapping(value = "/admin/login/logout.do")
	public ModelAndView logout(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) {
//	public String logout(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) {
//		session = req.getSession(true);
//		session.removeAttribute(WebConstants.ADMIN_SESSION_INFO);
		
		//return "redirect:/admin/login/loginForm.do";
		logger.info("---- logout -------");
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/login/logoutDone");
		return mv;
	}
}
