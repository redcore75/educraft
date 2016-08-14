package kr.co.redcore.domain.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.redcore.GlobalConstants;
import kr.co.redcore.util.string.UserString;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

public class JsonView extends AbstractView {
	private static final Logger logger = LoggerFactory.getLogger(JsonView.class);

	@Override
	protected void renderMergedOutputModel(Map<String, Object> modelMap, HttpServletRequest req, HttpServletResponse res) throws Exception {
		StringBuffer json = new StringBuffer();

		json.append(modelMap.get(GlobalConstants.API_FORMAT_JSON));

		res.setContentType("application/json");
		res.setCharacterEncoding("utf-8");
		res.setHeader("Cache-Control", "no-cache");
		res.setContentLength(json.toString().getBytes("utf-8").length);
		res.getWriter().print(json.toString());

		logger.debug("result data >>>> " + UserString.replace(json.toString(), "\n", ""));
	}
}
