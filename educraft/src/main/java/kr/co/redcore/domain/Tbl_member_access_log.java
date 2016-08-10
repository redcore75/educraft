package kr.co.redcore.domain;

public class Tbl_member_access_log extends BaseObject {
	private int member_access_log_seq;
	private int member_seq;
	private String member_id;
	private String ip_addr;
	private String access_url;
	private String regby;
	private String regdate;

	public int getMember_access_log_seq() {
		return member_access_log_seq;
	}

	public void setMember_access_log_seq(int member_access_log_seq) {
		this.member_access_log_seq = member_access_log_seq;
	}

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getIp_addr() {
		return ip_addr;
	}

	public void setIp_addr(String ip_addr) {
		this.ip_addr = ip_addr;
	}

	public String getAccess_url() {
		return access_url;
	}

	public void setAccess_url(String access_url) {
		this.access_url = access_url;
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
}
