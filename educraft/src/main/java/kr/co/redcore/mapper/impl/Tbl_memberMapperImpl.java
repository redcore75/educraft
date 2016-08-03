package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import java.util.HashMap;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.mapper.Tbl_memberMapper;

@Repository
public class Tbl_memberMapperImpl implements Tbl_memberMapper {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Tbl_member getTbl_memberByMember_idEtc(String member_id, String password) throws SQLException {
		// TODO Auto-generated method stub
		HashMap param = new HashMap();
		param.put("member_id", member_id);
		param.put("password", password);
		
		return sqlSession.selectOne("getTbl_memberByMember_idEtc", param);
	}
}
