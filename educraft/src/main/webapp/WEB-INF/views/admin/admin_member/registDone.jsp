<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
%>
<body>
<script>
	alert("등록 완료했습니다.");
	window.location = "${pageContext.request.contextPath}/admin/admin_member/searchList.do";
</script>
</body>