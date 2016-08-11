package kr.co.redcore.taglib;

import java.util.List;
import javax.servlet.jsp.JspException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;
import kr.co.redcore.domain.Tbl_common_code;
import kr.co.redcore.mapper.Tbl_common_codeMapper;
import kr.co.redcore.util.string.UserString;

public class CommonCodeSelectTag extends RequestContextAwareTag {
	private static final Logger logger = LoggerFactory.getLogger(CommonCodeSelectTag.class);
	private static final long serialVersionUID = 1L;

	private String code_group_id;
	private String tag_id;
	private String tag_name;
	private String tag_value;
	private String tag_header;
	private String tag_class;
	private String tag_style;

	@SuppressWarnings("unchecked")
	public int doStartTagInternal() throws JspException {
		try {
			WebApplicationContext ctx = getRequestContext().getWebApplicationContext();
			Tbl_common_codeMapper tbl_common_codeMapper = ctx.getBean(Tbl_common_codeMapper.class);

			List tbl_common_codeList = tbl_common_codeMapper.getTbl_common_codeListByCode_group_id(code_group_id);
			if (tbl_common_codeList.size() > 0) {
				StringBuffer sb = new StringBuffer();

				sb.append("<select id=\"" + tag_id + "\" name=\"" + tag_name + "\" {class} {style}>");				
				if ((tag_header != null) && !tag_header.equals("")) {
					sb.append("<option>" + tag_header + "</option>");
				}

				for (int i = 0; tbl_common_codeList.size() > i; i++) {
					Tbl_common_code tbl_common_code = (Tbl_common_code) tbl_common_codeList.get(i);
					if ((tag_value != null) && !tag_value.equals("") && tag_value.equals(tbl_common_code.getCode_id())) {
						sb.append("<option value=\"" + tbl_common_code.getCode_id() + "\" selected=\"selected\">" + tbl_common_code.getCode_name() + "</option>");
					} else {
						sb.append("<option value=\"" + tbl_common_code.getCode_id() + "\">" + tbl_common_code.getCode_name() + "</option>");
					}
				}
				sb.append("</select>");

				String outTags = sb.toString();				
				outTags = UserString.replace(outTags, "{class}", "class=\"" + tag_class + "\"");				
				outTags = UserString.replace(outTags, "{style}", "sytle=\"" + tag_style + "\"");
				
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

	public String getTag_header() {
		return tag_header;
	}

	public void setTag_header(String tag_header) {
		this.tag_header = tag_header;
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
}
