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
<%
response.setContentType("text/html; charset=UTF-8"); 
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
//request.setCharacterEncoding("UTF-8");
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="/resources/admin/css/import.css" />
<link rel="stylesheet" type="text/css" href="/resources/admin/css/jquery-ui.css"/>
<link rel="stylesheet" type="text/css" href="/resources/admin/css/selectric.css"/>
<script type="text/javascript" src="/resources/admin/js/dui_prototype.js"></script>
<script type="text/javascript" src="/resources/admin/js/dui_effect.js"></script>
<script type="text/javascript" src="/resources/admin/js/dui_dragndrop.js"></script>
<script type="text/javascript" src="/resources/admin/js/dui_hhmenu.js"></script>
<script type="text/javascript" src="/resources/admin/js/dui_tree.js"></script>
<script type="text/javascript" src="/resources/admin/js/dui_slidemenu.js"></script>
<script type="text/javascript" src="/resources/admin/js/dui_tab.js"></script>
<script type="text/javascript" src="/resources/admin/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/resources/admin/js/jquery-ui.js"></script>
<script type="text/javascript" src="/resources/admin/js/common.js"></script>
<script type="text/javascript" src="/resources/admin/js/monthpicker.js"></script>
<script type="text/javascript" src="/resources/admin/js/jquery.selectric.min.js"></script>
<script type="text/javascript" src="/resources/common/js/common.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		// readonly 에서 백스페이스 무시.
		$("input[readonly]").keydown(function(event) {
			if ( event.keyCode === 8 ) {
				return false;
			} 
		});
		
		/*
		SyntaxHighlighter.defaults['auto-links'] = false;
		SyntaxHighlighter.all();
		*/
	});
</script>

<script type="text/javascript">
/**
 * 공통 기반.
 */

/**
 * ajax error 발생 시 공통 정보 출력.
 */
function alertAjaxError(jqXHR, textStatus, errorThrown) {
	var jqXhrText = '';
	// for (var propName in jqXHR) {
	// jqXhrText += '\n'+ propName +' : '+ jqXHR[propName];
	// }
	jqXhrText += '\n' + 'readyState' + ' : ' + jqXHR['readyState'];
	jqXhrText += '\n' + 'status' + ' : ' + jqXHR['status'];
	jqXhrText += '\n' + 'statusText' + ' : ' + jqXHR['statusText'];
	// jqXhrText += '\n'+ 'responseXML' +' : '+ jqXHR['responseXML'];
	// jqXhrText += '\n'+ 'responseText' +' : '+ jqXHR['responseText'];

	var message = '!Ajax Error! [관리자에게 문의하세요.]';
	message += '\n====================';
	message += '\n ▶ jqXHR';
	message += '\n--------------------\n';
	message += jqXhrText;
	message += '\n====================';
	message += '\n ▶ textStatus';
	message += '\n--------------------\n';
	message += textStatus;
	message += '\n====================';
	message += '\n ▶ errorThrown';
	message += '\n--------------------\n';
	message += errorThrown;

	alert(message);
}

//공백제거 함수
function trim(str) {
	return (str == null) ? "" : str.replace(/^\s+|\s+$/g,"");
}

</script>

<decorator:head />
<!-- page script -->
</head>

<body>
	<div id="LblockWrapper">
		<!-- START:TOP Area -->
		<page:applyDecorator name="admin_top" />
		<!-- END:TOP Area -->
		<!-- START:MAIN Area -->
		<decorator:body />
		<!-- END:MAIN Area -->
	</div>
	<script type="text/javascript" src="/resources/admin/js/colors.js"></script>
	<script type="text/javascript" src="/resources/admin/js/jqColorPicker.js"></script>
	<script type="text/javascript" src="/resources/admin/js/index.js"></script>
</body>
</html>