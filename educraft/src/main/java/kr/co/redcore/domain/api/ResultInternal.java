package kr.co.redcore.domain.api;

import java.io.Serializable;
import java.util.List;

public class ResultInternal implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;
	private String msg;
	private String desc;
	private List<Object> dataList;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}
}
