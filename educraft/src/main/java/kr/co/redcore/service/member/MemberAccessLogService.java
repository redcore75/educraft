package kr.co.redcore.service.member;

import kr.co.redcore.domain.Tbl_member_access_log;
import kr.co.redcore.mapper.Tbl_member_access_logMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberAccessLogService {
	private static final Logger logger = LoggerFactory.getLogger(MemberAccessLogService.class);
	
	@Autowired
	private Tbl_member_access_logMapper tbl_member_access_logMapper;
	
	public int insertTbl_member_access_log(Tbl_member_access_log tbl_member_access_log) throws Exception {
		return tbl_member_access_logMapper.insertTbl_member_access_log(tbl_member_access_log);
	}
}
