<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
Tbl_member tbl_member = (Tbl_member) session.getAttribute(GlobalConstants.ADMIN_LOGININFO_KEY);
%>
    <header>
		<div class="row">
			<div class="col-md-11">
				<strong>Email: </strong><%=tbl_member.getEmail_addr() %>&nbsp;&nbsp;<strong>Support: </strong><%=tbl_member.getMobile_num() %>
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
		              		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">회원관리<span class="caret"></span></a>
		              		<ul class="dropdown-menu">
		                		<li><a href="${pageContext.request.contextPath}/admin/member/searchList.do">회원리스트</a></li>
		              		</ul>
		            	</li>
		            	
		            	<li class="dropdown">
		              		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">상품권관리<span class="caret"></span></a>
		              		<ul class="dropdown-menu">
		                		<li><a href="#">상품권발급현황</a></li>
		                		<li role="separator" class="divider"></li>
		                		<li><a href="#">상품권리스트</a></li>
		              		</ul>
		            	</li>
					</ul>
				</div>
			</div>
		</div>
	</section>