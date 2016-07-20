package kr.co.educraft.service.member;

import kr.co.educraft.mapper.Tbl_memberMapper;
import kr.co.educraft.service.PageObject;
import kr.co.educraft.util.PageHelper;
import kr.co.educraft.util.ParamMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MemberService extends PageObject {
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	@Qualifier("tbl_memberMapper")
	private Tbl_memberMapper tbl_memberMapper;
	
	public PageHelper getPageHelperByParamEtc(ParamMap paramMap, PageHelper pageHelper) throws Exception {
		pageHelper.setTotalRows(tbl_memberMapper.getPageHelperCntByParamMap(paramMap));
		pageHelper.setList(tbl_memberMapper.getPageHelperByParamEtc(pageHelper.getStartRow(), pageHelper.getPageSize(), paramMap));

		return pageHelper;
	}
}
