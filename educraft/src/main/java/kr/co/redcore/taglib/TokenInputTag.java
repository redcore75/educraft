package kr.co.redcore.taglib;

import javax.servlet.jsp.JspException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;
import kr.co.redcore.handler.TokenHandler;

public class TokenInputTag extends RequestContextAwareTag {
	private static final Logger logger = LoggerFactory.getLogger(CommonCodeSelectTag.class);
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public int doStartTagInternal() throws JspException {
		try {
			WebApplicationContext ctx = getRequestContext().getWebApplicationContext();
			TokenHandler tokenHandler = ctx.getBean(TokenHandler.class);

			pageContext.getOut().print("<input type=\"hidden\" id=\"token\" name=\"token\"  value=\"" + tokenHandler.generate() + "\"" + "/>");
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

		return SKIP_BODY;
	}
}
