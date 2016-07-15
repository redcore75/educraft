package kr.co.educraft.mapper;

import java.sql.SQLException;
import java.util.List;
import kr.co.educraft.util.ParamMap;

public interface Tbl_memberMapper {
	public long getPageHelperCntByParamMap(ParamMap paramMap) throws SQLException;
	public List getPageHelperByParamEtc(long start, long size, ParamMap paramMap) throws SQLException;
}
