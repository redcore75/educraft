package kr.co.redcore.service;

import kr.co.redcore.util.PageHelper;
import kr.co.redcore.util.ParamMap;

public abstract class PageObject {
	public abstract PageHelper getPageHelperByParamEtc(ParamMap paramMap, PageHelper pageHelper) throws Exception;
}
