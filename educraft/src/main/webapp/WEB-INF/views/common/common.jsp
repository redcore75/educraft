<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 			uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 		uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" 			uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" 		uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" 		uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="decorator" 	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" 		uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="cf"          uri="/WEB-INF/tld/redcore-tags.tld"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*"%>
<%@ page import="org.slf4j.*"%>
<%@ page import="kr.co.redcore.GlobalConstants"%>
<%@ page import="kr.co.redcore.domain.*"%>
<%@ page import="kr.co.redcore.domain.view.*"%>
<%@ page import="kr.co.redcore.service.*"%>
<%@ page import="kr.co.redcore.util.*"%>
<%@ page import="kr.co.redcore.util.string.*"%>
<jsp:scriptlet>
	pageContext.setAttribute("newline", "\n");
</jsp:scriptlet>
<spring:htmlEscape defaultHtmlEscape="true" />
<%
// 모바일에서 접근중인지 체크
int isMobile = 0;
String userAgent = request.getHeader("USER-AGENT");
String[] mobileOsType = {"iPhone", "iPod", "Android", "BlackBerry", "Windows CE", "Nokia", "Webos", "Opera Mini", "SonyEricsson", "Opera Mobi", "IEMobile"};

for (int i = 0, j = -1; i < mobileOsType.length; i++) {
	if (userAgent.indexOf(mobileOsType[i]) > -1) {
		// 모바일로 접근했을 때
		request.setAttribute("isMobile", isMobile);
		break;
	}
}
%>