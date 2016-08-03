<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
alert("로그인에 성공했습니다.");
window.location = "${pageContext.request.contextPath}/admin/member/searchList.do";
</body>