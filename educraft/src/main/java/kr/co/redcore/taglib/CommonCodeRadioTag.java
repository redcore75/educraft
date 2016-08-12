package kr.co.redcore.taglib;

import java.util.List;
import javax.servlet.jsp.JspException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;
import kr.co.redcore.domain.Tbl_common_code;
import kr.co.redcore.mapper.Tbl_common_codeMapper;
import kr.co.redcore.util.string.UserString;

public class CommonCodeRadioTag extends RequestContextAwareTag {
	private static final Logger logger = LoggerFactory.getLogger(CommonCodeRadioTag.class);
	private static final long serialVersionUID = 1L;

	private String code_group_id;
	private String tag_id;
	private String tag_name;
	private String tag_value;
	private String tag_class;
	private String tag_style;
	private String tag_onclick;

	@SuppressWarnings("unchecked")
	public int doStartTagInternal() throws JspException {
		try {
			WebApplicationContext ctx = getRequestContext().getWebApplicationContext();
			Tbl_common_codeMapper tbl_common_codeMapper = ctx.getBean(Tbl_common_codeMapper.class);

			List tbl_common_codeList = tbl_common_codeMapper.getTbl_common_codeListByCode_group_id(code_group_id);
			if (tbl_common_codeList.size() > 0) {
				StringBuffer sb = new StringBuffer();

				for (int i = 0; tbl_common_codeList.size() > i; i++) {
					Tbl_common_code tbl_common_code = (Tbl_common_code) tbl_common_codeList.get(i);

					if ((tag_value != null) && !tag_value.equals("") && tag_value.equals(tbl_common_code.getCode_id())) {
						sb.append("<input type=\"radio\" id=\"" + tag_id + "\" name=\"" + tag_name + "\" value=\"" + tbl_common_code.getCode_id() + "\" {class} {style} {onclick} checked>");
						sb.append(tbl_common_code.getCode_name() + "</input>");
					} else {
						sb.append("<input type=\"radio\" id=\"" + tag_id + "\" name=\"" + tag_name + "\" value=\"" + tbl_common_code.getCode_id() + "\" {class} {style} {onclick}>");
						sb.append(tbl_common_code.getCode_name() + "</input>");
					}
				}

				String outTags = sb.toString();
				outTags = UserString.replace(outTags, "{class}", tag_class != null ? "class=\"" + tag_class + "\"" : "");
				outTags = UserString.replace(outTags, "{style}", tag_style != null ? "sytle=\"" + tag_style + "\"" : "");
				outTags = UserString.replace(outTags, "{onclick}", tag_onclick != null ? "onclick=\"" + tag_onclick + "\"" : "");
				
				pageContext.getOut().print(outTags);
			} else {
				pageContext.getOut().print("");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

		return SKIP_BODY;
	}

	public String getCode_group_id() {
		return code_group_id;
	}

	public void setCode_group_id(String code_group_id) {
		this.code_group_id = code_group_id;
	}

	public String getTag_id() {
		return tag_id;
	}

	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

	public String getTag_value() {
		return tag_value;
	}

	public void setTag_value(String tag_value) {
		this.tag_value = tag_value;
	}

	public String getTag_class() {
		return tag_class;
	}

	public void setTag_class(String tag_class) {
		this.tag_class = tag_class;
	}

	public String getTag_style() {
		return tag_style;
	}

	public void setTag_style(String tag_style) {
		this.tag_style = tag_style;
	}

	public String getTag_onclick() {
		return tag_onclick;
	}

	public void setTag_onclick(String tag_onclick) {
		this.tag_onclick = tag_onclick;
	}

}
