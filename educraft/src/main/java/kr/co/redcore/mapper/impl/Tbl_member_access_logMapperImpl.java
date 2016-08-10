package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.domain.Tbl_member_access_log;
import kr.co.redcore.mapper.Tbl_memberMapper;
import kr.co.redcore.mapper.Tbl_member_access_logMapper;
import kr.co.redcore.util.ParamMap;

@Repository
public class Tbl_member_access_logMapperImpl implements Tbl_member_access_logMapper {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertTbl_member_access_log(Tbl_member_access_log tbl_member_access_log) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.insert("Tbl_member_access_log.insertTbl_member_access_log", tbl_member_access_log);
	}
	
	
}
