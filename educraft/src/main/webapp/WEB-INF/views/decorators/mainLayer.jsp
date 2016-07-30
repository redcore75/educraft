<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 			uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 		uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" 			uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" 		uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" 		uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="decorator" 	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" 		uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="f"           uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf"          uri="/WEB-INF/tld/xmerce-tags.tld"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
response.setContentType("text/html; charset=UTF-8"); 
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	
	<style type="text/css">
		input.error, textarea.error{border:1px dashed red;}
		label.error{margin-left:10px;color:red;}
	</style>	
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			// readonly 에서 백스페이스 무시.
			$("input[readonly]").keydown(function(event) {
				if ( event.keyCode === 8 ) {
					return false;
				}
			});
		});
	</script>
	
	<decorator:head />
</head>
<body>
	<!-- START:TOP Area -->
	<page:applyDecorator name="admin_top" />
	<!-- END:TOP Area -->
	
	<!-- START:MAIN Area -->
	<decorator:body />
	<!-- END:MAIN Area -->
	
	<!-- START:BOTTOM Area -->
	<page:applyDecorator name="admin_bottom" />
	<!-- END:BOTTOM Area -->
</body>
</html>