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
import kr.co.redcore.service.member.MemberService;
import kr.co.redcore.util.PageHelper;
import kr.co.redcore.util.ParamMap;

@Controller
public class MemberController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService mmeberService;	
	
	@RequestMapping(value = "/admin/member/searchList.do")
	public ModelAndView loginForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {		
		ParamMap paramMap = new ParamMap();
		paramMap.put("sch_member_id", params.get("sch_member_id"));
		paramMap.put("sch_member_name", params.get("sch_member_name"));
		paramMap.put("sch_start_date", params.get("sch_start_date"));
		paramMap.put("sch_end_date", params.get("sch_end_date"));
		
		PageHelper pageHelper;
		if(params.get("curr_page") != null && !params.get("curr_page").equals("")) {
			pageHelper = new PageHelper(Long.parseLong((String) params.get("curr_page")), PageHelper.DEFAULT_GROUP_SIZE, PageHelper.DEFAULT_PAGE_SIZE);
		} else {
			pageHelper = new PageHelper(curr_page, PageHelper.DEFAULT_GROUP_SIZE, PageHelper.DEFAULT_GROUP_SIZE);
		}
		mmeberService.getPageHelperByParamEtc(paramMap, pageHelper);
		
		//logger.debug("-->>>>-" + pageHelper.getList().size());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/member/searchList");
		//mv.addObject("paramMap", paramMap);
		//mv.addObject("curr_page", curr_page);
		mv.addObject("pageHelper", pageHelper);
		
		return mv;
	}
}
