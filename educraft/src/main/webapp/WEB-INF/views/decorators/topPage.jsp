<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
Tbl_member tbl_member = (Tbl_member) session.getAttribute(GlobalConstants.ADMIN_LOGININFO_KEY);
%>
    <header>
		<div class="row">
			<div class="col-md-11">
				<strong>접속자 : </strong><%=tbl_member.getMember_id() %>(<%=tbl_member.getMember_name() %>)
			</div>
			<div class="col-md-1">
				<a href="${pageContext.request.contextPath}/admin/login/logout.do">
					<button type="submit" class="btn btn-default">로그아웃</button>
				</a>
			</div>
		</div>
    </header>

	<section class="menu-section">
		<div class="navbar navbar-inverse">
			<div class="container">
	        	<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
	        	</div>
				
				<div id="navbar" class="navbar-collapse collapse">
	          		<ul class="nav navbar-nav">		            	
		            	<li class="dropdown">
		              		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">시스템관리<span class="caret"></span></a>
		              		<ul class="dropdown-menu">
		                		<li><a href="${pageContext.request.contextPath}/admin/admin_member/searchList.do">관리자리스트</a></li>
		              		</ul>
		            	</li>
		            	<li class="dropdown">
		              		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">회원관리<span class="caret"></span></a>
		              		<ul class="dropdown-menu">
		                		<li><a href="${pageContext.request.contextPath}/admin/front_member/searchList.do">회원리스트</a></li>
		                		<li><a href="${pageContext.request.contextPath}/admin/recom_member/searchList.do">추천인리스트</a></li>
		              		</ul>
		            	</li>
		            	<li class="dropdown">
		              		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">상품권관리<span class="caret"></span></a>
		              		<ul class="dropdown-menu">
		                		<li><a href="#">상품권발행현황</a></li>		                		
		                		<li><a href="#">상품권발송현황</a></li>
		              		</ul>
		            	</li>
					</ul>
				</div>
			</div>
		</div>
	</section>