<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 			uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 		uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" 			uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" 		uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" 		uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="decorator" 	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" 		uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="f"           uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" 			uri="/WEB-INF/tld/xmerce-tags.tld"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*"%>
<%@ page import="org.springframework.web.context.*,org.springframework.web.context.support.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<jsp:scriptlet>
	pageContext.setAttribute("newline", "\n");
</jsp:scriptlet>
<spring:htmlEscape defaultHtmlEscape="true" />
<script type="text/javascript" src="http://www.google.com/recaptcha/api/js/recaptcha_ajax.js"></script>
<script src='https://www.google.com/recaptcha/api.js'></script>
<%
	// 모바일에서 접근중인지 체크
	int isMobile = 0;
	String agent = request.getHeader("USER-AGENT");
	String[] mobileos = {"iPhone","iPod","Android","BlackBerry","Windows CE","Nokia","Webos","Opera Mini","SonyEricsson","Opera Mobi","IEMobile"};
	int j = -1;
	
	for (int i = 0; i < mobileos.length; i++) {
		j = agent.indexOf(mobileos[i]);
		if (j > -1) {
			// 모바일로 접근했을 때
			isMobile = 1;
			break;
		}
	}
	
	request.setAttribute("isMobile", isMobile);
%>