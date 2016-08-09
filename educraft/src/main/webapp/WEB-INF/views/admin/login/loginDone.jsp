<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<script>
	alert("로그인에 성공했습니다.");
	window.location = "${pageContext.request.contextPath}/admin/admin_member/searchList.do";
</script>
</body>