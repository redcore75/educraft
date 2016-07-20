<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
	Log log = LogFactory.getLog(getClass());

	AdminMember adminMember = (AdminMember) session.getAttribute(WebConstants.ADMIN_SESSION_INFO);

	ServletContext ctx = pageContext.getServletContext();
	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(ctx);
	CommonMenuService commonMenuService = (CommonMenuService) wac.getBean("commonMenuService");
	
	List commonMenuTopList = commonMenuService.getCommonMenuListByParent_common_menu_seqEtc(0, WebConstants.MENU_TYPE_ADMIN, adminMember.getAdmin_level_seq());
	List commonMenuSubList = commonMenuService.getVw_CommonMenuListByAdmin_level_seq(adminMember.getAdmin_level_seq());
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Channys</title>
<script type="text/javascript" src="/resources/common/js/common.js"></script>
</head>

<script type="text/javascript">

	function goLogout() {
		if(confirm("시스템에서 로그아웃 하시겠습니까?")) {
			location.href = "/admin/login/logout.do";
		}
	}
	
</script>

<div id="LblockHeder">
	<div id="LblockHeadWrap">
		<h1><a href="#"><img src="/resources/admin/images/Top_logo_temporary.png" alt="Channys" /></a></h1>
		<strong class="Lsubtitle">Mobile Price Administrator</strong>
		<div class="memberUser">${ADMIN_SESSION_INFO.member_id} (${ADMIN_SESSION_INFO.member_name}) 님 로그인<a href="javascript:goLogout();" class="logoutBtn">로그아웃</a></div>
	</div>
	<div id="LblockTopMenu" class="Lclear">
		<table class="gnb">
			<tr>
				<%
					Iterator itTop = commonMenuTopList.iterator();
					while (itTop.hasNext()) {
						CommonMenu commonMenuTop = (CommonMenu) itTop.next();
				%>
				<td><a href="<%=commonMenuTop.getLink_url()%>"><%=commonMenuTop.getMenu_name()%></a>
					<ul>
						<%
							Iterator itSub = commonMenuSubList.iterator();
								while (itSub.hasNext()) {
									Vw_CommonMenu vw_commonMenuSub = (Vw_CommonMenu) itSub.next();
									if (vw_commonMenuSub.getCommon_menu_seq() == commonMenuTop.getCommon_menu_seq()) {
						%>
						<li><a href="<%=vw_commonMenuSub.getLink_url_sub()%>"><%=vw_commonMenuSub.getMenu_name_sub()%></a></li>
						<%
							}
								}
						%>
					</ul></td>
				<%
					}
				%>
			</tr>
		</table>
	</div>
</div>