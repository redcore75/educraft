package kr.co.redcore.mapper;

import java.sql.SQLException;
import java.util.List;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.util.ParamMap;

public interface Tbl_memberMapper {
	public Tbl_member getTbl_memberByMember_idEtc(String member_id, String password) throws SQLException;
	//public long getPageHelperCntByParamMap(ParamMap paramMap) throws SQLException;
	//public List getPageHelperByParamMapEtc(long start, long size, ParamMap paramMap) throws SQLException;
}
