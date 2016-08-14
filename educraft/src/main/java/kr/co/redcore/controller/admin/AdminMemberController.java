package kr.co.redcore.controller.admin;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import kr.co.redcore.GlobalConstants;
import kr.co.redcore.annotation.CheckToken;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.exception.Member_id_dupException;
import kr.co.redcore.service.member.LoginService;
import kr.co.redcore.service.member.MemberService;
import kr.co.redcore.util.PageHelper;
import kr.co.redcore.util.ParamMap;

@Controller
@SessionAttributes(value = { "tbl_member" })
public class AdminMemberController {
	private static final Logger logger = LoggerFactory.getLogger(AdminMemberController.class);

	@Autowired
	private LoginService loginService;	
	
	@Autowired
	private MemberService mmeberService;

	@RequestMapping(value = "/admin/admin_member/searchList.do")
	public ModelAndView searchList(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {
		ParamMap paramMap = new ParamMap();
		paramMap.put("sch_member_id", params.get("sch_member_id"));
		paramMap.put("sch_member_name", params.get("sch_member_name"));
		paramMap.put("sch_start_date", params.get("sch_start_date"));
		paramMap.put("sch_end_date", params.get("sch_end_date"));
		paramMap.put("sch_member_type", "A");// 관리자

		PageHelper pageHelper;
		if (params.get("curr_page") != null && !params.get("curr_page").equals("")) {
			pageHelper = new PageHelper(Long.parseLong((String) params.get("curr_page")), PageHelper.DEFAULT_GROUP_SIZE, PageHelper.DEFAULT_PAGE_SIZE);
		} else {
			pageHelper = new PageHelper(PageHelper.DEFAULT_CURR_PAGE, PageHelper.DEFAULT_GROUP_SIZE, PageHelper.DEFAULT_PAGE_SIZE);
		}
		mmeberService.getPageHelperByParamEtc(paramMap, pageHelper);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/admin_member/searchList");
		mv.addObject("paramMap", paramMap);
		mv.addObject("pageHelper", pageHelper);
		
		return mv;
	}

	@RequestMapping(value = "/admin/admin_member/registForm.do")
	public ModelAndView registForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {
		Tbl_member tbl_member = new Tbl_member();
		tbl_member.setMember_seq(12345);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/admin_member/registForm");
		mv.addObject("tbl_member", tbl_member);
		
		return mv;
	}

	@CheckToken
	@RequestMapping(value = "/admin/admin_member/regist.do", method = RequestMethod.POST)
	public ModelAndView regist(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, @ModelAttribute @Valid Tbl_member tbl_member, BindingResult bindingResult, SessionStatus status) throws Exception {
		// ParamMap paramMap = new ParamMap();

		String tokenError = (String) req.getAttribute(GlobalConstants.TOKEN_ERROR_KEY);
		if (bindingResult.hasErrors() || (tokenError != null)) {
			List<ObjectError> list = bindingResult.getAllErrors();
			for (ObjectError oe : list) {
				logger.error("ObjectError: " + oe);
			}

			if (tokenError != null) {
				logger.debug(">>>>>>> " + tokenError);
			}			
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("admin/admin_member/registForm");
			
			return mv;
		}

		try {
			logger.debug("tbl_member.toString() >>> " + tbl_member.toString());

			tbl_member.setCurr_point(0);
			tbl_member.setIs_del("N");
			tbl_member.setIs_valid("Y");
			tbl_member.setRegby(loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY).getMember_id());
			tbl_member.setUptby(loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY).getMember_id());
			
			mmeberService.insertTbl_member(tbl_member);
			
			status.setComplete();
		} catch (DuplicateKeyException ex) {
			bindingResult.rejectValue("member_id", "error_member_id_dup");
		} catch (Member_id_dupException ex) {
			bindingResult.rejectValue("member_id", "error_member_id_dup");
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/admin_member/registDone");
		// mv.addObject("paramMap", paramMap);
		
		return mv;
	}
}