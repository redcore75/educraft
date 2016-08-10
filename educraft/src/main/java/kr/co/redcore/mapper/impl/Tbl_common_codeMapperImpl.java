package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.redcore.domain.view.Vw_common_code;
import kr.co.redcore.mapper.Tbl_common_codeMapper;
import kr.co.redcore.util.ParamMap;

@Repository
public class Tbl_common_codeMapperImpl implements Tbl_common_codeMapper {	
	@Autowired
	private SqlSessionTemplate sqlSession;	

	@Override
	public Vw_common_code getVw_common_codeByParamMap(ParamMap paramMap) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Tbl_member.getVw_common_codeByParamMap", paramMap);
	}

	@Override
	public List getTbl_common_codeListByCode_group_id(String code_group_id) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Tbl_member.getTbl_common_codeListByCode_group_id", code_group_id);
	}
}
