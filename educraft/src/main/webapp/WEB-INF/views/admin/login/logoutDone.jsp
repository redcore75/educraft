<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<script>
	alert("로그아웃에 성공했습니다.");
	window.location = "${pageContext.request.contextPath}/admin/login/loginForm.do";
</script>
</body>