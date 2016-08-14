package kr.co.redcore.controller.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import kr.co.redcore.GlobalConstants;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.domain.api.JsonView;
import kr.co.redcore.domain.api.ResultInternal;
import kr.co.redcore.service.member.LoginService;
import kr.co.redcore.service.member.MemberService;
import kr.co.redcore.util.string.ConvertUtil;

@Controller
public class InternalApiController {
	private static final Logger logger = LoggerFactory.getLogger(InternalApiController.class);
	
	@Autowired
	private MemberService mmeberService;
	
	@RequestMapping(value = "/api/checkMemberDup.do")
	public View checkMemberDup(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, ModelMap modelMap) throws Exception {
		String member_id = (String) params.get("member_id");

		long memberCount = mmeberService.getTbl_memberCntByMember_id(member_id);
		ResultInternal ri = new ResultInternal();
		if(memberCount > 0) {
			ri.setCode(GlobalConstants.API_RESULT_SUCCESS);
		} else {
			ri.setCode(GlobalConstants.API_RESULT_FAIL);
		}
		
		modelMap.put(GlobalConstants.API_FORMAT_JSON, ConvertUtil.generateJson(ri));

		return new JsonView();
	}
}
