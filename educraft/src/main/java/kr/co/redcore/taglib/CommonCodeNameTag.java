package kr.co.redcore.taglib;

import javax.servlet.jsp.JspException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;
import kr.co.redcore.domain.view.Vw_common_code;
import kr.co.redcore.mapper.Tbl_common_codeMapper;
import kr.co.redcore.util.ParamMap;

public class CommonCodeNameTag extends RequestContextAwareTag {
	private static final Logger logger = LoggerFactory.getLogger(CommonCodeNameTag.class);
	private static final long serialVersionUID = 1L;	

	private String code_id;
	private String code_group_id;

	@SuppressWarnings("unchecked")
	public int doStartTagInternal() throws JspException {
		try {
			WebApplicationContext ctx = getRequestContext().getWebApplicationContext();
			Tbl_common_codeMapper tbl_common_codeMapper = ctx.getBean(Tbl_common_codeMapper.class);

			ParamMap paramMap = new ParamMap();
			paramMap.put("code_id", code_id);
			paramMap.put("code_group_id", code_group_id);

			Vw_common_code vw_common_code = tbl_common_codeMapper.getVw_common_codeByParamMap(paramMap);
			if (vw_common_code != null) {
				pageContext.getOut().print(vw_common_code.getCode_name());
			} else {
				pageContext.getOut().print("");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

		return SKIP_BODY;
	}

	public String getCode_id() {
		return code_id;
	}

	public void setCode_id(String code_id) {
		this.code_id = code_id;
	}

	public String getCode_group_id() {
		return code_group_id;
	}

	public void setCode_group_id(String code_group_id) {
		this.code_group_id = code_group_id;
	}
}
