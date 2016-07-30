<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	page import="java.util.*"%>
<%@	page import="org.apache.commons.logging.*"%>
<%@	page import="kr.co.redcore.util.*"%>
<div>
	<ul>
<%
String pageLink = request.getParameter("pageLink");
String pageName = request.getParameter("pageName");
String pageValue = request.getParameter("pageValue");
PageHelper pageHelper = (PageHelper) request.getAttribute("pageHelper");

if (pageHelper.hasPrevBlock()) {
	//out.println("<span class=\"\"><span class=\"\"><a href=\"" + pageLink + "?" + pageName + "=1&" + pageValue + "\" class=\"btn first\">1page</a></span></span>");
	out.println("<span class=\"\"><span><a href=\"" + pageLink + "?" + pageName + "=" + (pageHelper.getStartPage() - 1) + "&" + pageValue + "\" class=\"btn\">◀ 이전</a></span></span>");
} else {
	//out.println("<a href=\"#\" class=\"btn prev\">이전페이지</a>");
}

for (long i = pageHelper.getStartPage(); i <= pageHelper.getEndPage(); i++) {
	if (i == pageHelper.getCurrPage()) {
		out.println("<a class=\"\"><strong>[" + i + "]</strong></a>");
	} else {
		out.println("<span><a href=\"" + pageLink + "?" + pageName + "=" + i + "&" + pageValue + "\">[" + i + "]</a></span>");
	}
}

if (pageHelper.hasNextBlock()) {
	out.println("<span class=\"\"><span><a href=\"" + pageLink + "?" + pageName + "=" + (pageHelper.getEndPage() + 1) + "&" + pageValue + "\" class=\"btn\">다음 ▶</a></span></span>");
	//out.println("<a href=\"" + pageLink + "?" + pageName + "=" + (pageHelper.getTotalPage()) + "&" + pageValue + "\" class=\"btn last\">" + pageHelper.getTotalPage() + "page</a>");		
} else {
	//out.println("<a href=\"#\" class=\"btn next\">마지막페이지</a>");
}
%>
	</ul>
</div>