package kr.co.redcore.service.member;

import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.exception.Member_id_dupException;
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
	
	public PageHelper getPageHelperByParamEtc(ParamMap paramMap, PageHelper pageHelper) throws Exception {
		pageHelper.setTotalRows(tbl_memberMapper.getPageHelperCntByParamMap(paramMap));
		pageHelper.setList(tbl_memberMapper.getPageHelperListByParamMapEtc(pageHelper.getStartRow() - 1, pageHelper.getPageSize(), paramMap));

		return pageHelper;
	}
	
	public int insertTbl_member(Tbl_member tbl_member) throws Exception {
		int tmCnt = tbl_memberMapper.getTbl_memberCntByMember_id(tbl_member.getMember_id());
		if(tmCnt > 0) {
			throw new Member_id_dupException(tbl_member.getMember_id());
		} else {
			return tbl_memberMapper.insertTbl_member(tbl_member);
		}
	}
}
