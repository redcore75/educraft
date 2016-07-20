package kr.co.educraft.util.taglib;

import java.util.List;
import javax.servlet.jsp.JspException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;
import kr.co.educraft.domain.Tbl_common_code;
import kr.co.educraft.mapper.Tbl_common_codeMapper;

public class CommonCodeRadioButtonTag extends RequestContextAwareTag {
	private final Log log = LogFactory.getLog(this.getClass());
	private static final long serialVersionUID = 1L;	

	private String code_group_id;

	@SuppressWarnings("unchecked")
	public int doStartTagInternal() throws JspException {
		try {
			WebApplicationContext ctx = getRequestContext().getWebApplicationContext();
			Tbl_common_codeMapper tbl_common_codeMapper = ctx.getBean(Tbl_common_codeMapper.class);

			List tbl_common_codeList = tbl_common_codeMapper.getTbl_common_codeListByCode_group_id(code_group_id);

			if (tbl_common_codeList.size() > 0) {
				for (int i = 0; tbl_common_codeList.size() > i; i++) {
					Tbl_common_code tbl_common_code = (Tbl_common_code) tbl_common_codeList.get(i);
					pageContext.getOut().print("<input type=\"radio\" id=\"" + code_group_id.toLowerCase() + "_" + i + "\" name=\"" + code_group_id.toLowerCase() + "\" value=\"" + tbl_common_code.getCode_id() + "\"/><label for=\"" + code_group_id.toLowerCase() + "_" + i + "\">" + tbl_common_code.getCode_name() + "</label>&nbsp;&nbsp;&nbsp;");
				}
			} else {
				pageContext.getOut().print("");
			}
		} catch (Exception ex) {
			log.error(this, ex);
		}

		return SKIP_BODY;
	}

	public String getCode_group_id() {
		return code_group_id;
	}

	public void setCode_group_id(String code_group_id) {
		this.code_group_id = code_group_id;
	}
}
