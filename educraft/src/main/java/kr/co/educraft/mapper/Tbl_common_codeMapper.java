package kr.co.educraft.mapper;

import java.sql.SQLException;
import java.util.List;

import kr.co.educraft.domain.view.Vw_common_code;
import kr.co.educraft.util.ParamMap;

public interface Tbl_common_codeMapper {
	public Vw_common_code getVw_common_codeByParamMap(ParamMap paramMap);
	public List getTbl_common_codeListByCode_group_id(String code_group_id) throws SQLException;
	public long getPageHelperCntByParamMap(ParamMap paramMap) throws SQLException;
	public List getPageHelperByParamEtc(long start, long size, ParamMap paramMap) throws SQLException;
}
