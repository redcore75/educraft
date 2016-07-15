package kr.co.educraft.service;

import kr.co.educraft.util.PageHelper;
import kr.co.educraft.util.ParamMap;

public abstract class PageObject {
	public abstract PageHelper getPageHelperByParamEtc(ParamMap paramMap, PageHelper pageHelper) throws Exception;
}
