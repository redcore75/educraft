package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.mapper.Tbl_memberMapper;
import kr.co.redcore.util.ParamMap;

@Repository
public class Tbl_memberMapperImpl implements Tbl_memberMapper {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public long getTbl_memberCntByMember_id(String member_id) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Tbl_member.getTbl_memberCntByMember_id", member_id);
	}
	
	@Override
	public Tbl_member getTbl_memberByMember_idEtc(String member_id, String password) throws SQLException {
		// TODO Auto-generated method stub
		HashMap param = new HashMap();
		param.put("member_id", member_id);
		param.put("password", password);
		
		return sqlSession.selectOne("Tbl_member.getTbl_memberByMember_idEtc", param);
	}
	
	public long getPageHelperCntByParamMap(ParamMap paramMap) throws SQLException {
		return sqlSession.selectOne("Tbl_member.getPageHelperCntByParamMap", paramMap);
	}
	
	public List getPageHelperListByParamMapEtc(long start, long size, ParamMap paramMap) throws SQLException {
		paramMap.put("start", (int)start);
		paramMap.put("size", (int)size);
		
		return sqlSession.selectList("Tbl_member.getPageHelperListByParamMapEtc", paramMap);
	}
	
	public int insertTbl_member(Tbl_member tbl_member) throws SQLException {
		return sqlSession.insert("Tbl_member.insertTbl_member", tbl_member);
	}
}
