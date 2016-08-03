package kr.co.redcore.service.member;

import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.mapper.Tbl_memberMapper;
import kr.co.redcore.service.PageObject;
import kr.co.redcore.util.PageHelper;
import kr.co.redcore.util.ParamMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MemberService extends PageObject {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private Tbl_memberMapper tbl_memberMapper;
	
	public Tbl_member getTbl_memberByMember_idEtc(String member_id, String password) throws Exception {
		return tbl_memberMapper.getTbl_memberByMember_idEtc(member_id, password);		
	}

	@Override
	public PageHelper getPageHelperByParamEtc(ParamMap paramMap, PageHelper pageHelper) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public PageHelper getPageHelperByParamEtc(ParamMap paramMap, PageHelper pageHelper) throws Exception {
//		pageHelper.setTotalRows(tbl_memberMapper.getPageHelperCntByParamMap(paramMap));
//		pageHelper.setList(tbl_memberMapper.getPageHelperByParamMapEtc(pageHelper.getStartRow(), pageHelper.getPageSize(), paramMap));
//
//		return pageHelper;
//	}
}
