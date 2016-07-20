package kr.co.educraft.util.taglib;

import javax.servlet.jsp.JspException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;
import kr.co.educraft.domain.view.Vw_common_code;
import kr.co.educraft.mapper.Tbl_common_codeMapper;
import kr.co.educraft.util.ParamMap;

public class CommonCodeNameTag extends RequestContextAwareTag {
	private final Log log = LogFactory.getLog(this.getClass());
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
			log.error(this, ex);
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
