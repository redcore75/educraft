package kr.co.redcore.domain;

import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;

public class Tbl_member extends BaseObject {
	private int member_seq;

	@Min(value = 1, message = "관리자권한등급을 선택하세요.")
	private int member_level_seq;

	@NotBlank(message = "관리자ID를 입력하세요.")
	private String member_id;

	@NotBlank(message = "관리자명을 입력하세요.")
	private String member_name;

	@NotBlank(message = "비밀번호를 입력하세요.")
	private String password;
	private String member_type;
	private String email_addr;
	private String mobile_num;
	private long curr_point;// 현재포인트

	@NotBlank(message = "사용여부를 선택하세요.")
	private String is_valid;
	private String is_del;
	private String memo;

	private String recom_member_id;// 추천인아이디
	private String recom_type;// 추천인타입
	private String recom_group;// 추천인소속

	private String regby;
	private String regdate;
	private String uptby;
	private String uptdate;

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

	public int getMember_level_seq() {
		return member_level_seq;
	}

	public void setMember_level_seq(int member_level_seq) {
		this.member_level_seq = member_level_seq;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMember_type() {
		return member_type;
	}

	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}

	public String getEmail_addr() {
		return email_addr;
	}

	public void setEmail_addr(String email_addr) {
		this.email_addr = email_addr;
	}

	public String getMobile_num() {
		return mobile_num;
	}

	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}

	public String getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
	}

	public String getIs_del() {
		return is_del;
	}

	public void setIs_del(String is_del) {
		this.is_del = is_del;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public long getCurr_point() {
		return curr_point;
	}

	public void setCurr_point(long curr_point) {
		this.curr_point = curr_point;
	}

	public String getRecom_member_id() {
		return recom_member_id;
	}

	public void setRecom_member_id(String recom_member_id) {
		this.recom_member_id = recom_member_id;
	}

	public String getRecom_type() {
		return recom_type;
	}

	public void setRecom_type(String recom_type) {
		this.recom_type = recom_type;
	}

	public String getRecom_group() {
		return recom_group;
	}

	public void setRecom_group(String recom_group) {
		this.recom_group = recom_group;
	}

	public String getRegby() {
		return regby;
	}

	public void setRegby(String regby) {
		this.regby = regby;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getUptby() {
		return uptby;
	}

	public void setUptby(String uptby) {
		this.uptby = uptby;
	}

	public String getUptdate() {
		return uptdate;
	}

	public void setUptdate(String uptdate) {
		this.uptdate = uptdate;
	}
}
