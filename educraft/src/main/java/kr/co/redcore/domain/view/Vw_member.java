package kr.co.redcore.domain.view;

import kr.co.redcore.domain.Tbl_member;

public class Vw_member extends Tbl_member {
	private String level_name;
	private int recom_count;

	public String getLevel_name() {
		return level_name;
	}

	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}

	public int getRecom_count() {
		return recom_count;
	}

	public void setRecom_count(int recom_count) {
		this.recom_count = recom_count;
	}
}
