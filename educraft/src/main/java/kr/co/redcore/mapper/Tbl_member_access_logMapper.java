package kr.co.redcore.mapper;

import java.sql.SQLException;
import kr.co.redcore.domain.Tbl_member_access_log;

public interface Tbl_member_access_logMapper {
	public int insertTbl_member_access_log(Tbl_member_access_log tbl_member_access_log) throws SQLException;
}
