<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
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