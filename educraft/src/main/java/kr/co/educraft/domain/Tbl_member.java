package kr.co.educraft.domain;

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
	private String email_addr;
	private String mobile_num;

	@NotBlank(message = "사용여부를 선택하세요.")
	private String is_valid;
	private String is_del;
	private String memo;
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
