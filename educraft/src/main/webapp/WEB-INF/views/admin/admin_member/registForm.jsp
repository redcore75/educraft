<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>	 				
	<script type="text/javascript">
		$(document).ready(function(){
 
		});
	</script>
</head>
<body>

	<div class="content">
  		<form:form modelAttribute="tbl_member" class="form-signin" id="registForm" name="registForm" method="post" action="regist.do">
  			<cf:token/>
      		<div class="box box-default">
        		<div class="box-header with-border">
          			<h3 class="box-title">시스템관리 > 관리자등록</h3>
        		</div>
        		<!-- /.box-header -->
        		<div class="box-body">
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label>관리자아이디</label></div>
									<div class="col-md-10"><form:input path="member_id" type="text" class="form-control" style="width: 100%;"/></div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label>관리자명</label></div>
									<div class="col-md-10"><form:input path="member_name" type="text" class="form-control" style="width: 100%;"/></div>
								</div>
	              			</div>
            			</div>
            			<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				
        		<!-- /.box-body -->
        		<div class="box-footer pull-right">
					<button type="submit" class="btn btn-default btn-flat" onclick="javascript:submit();this.disabled=true">등록하기</button>
					<a href="searchList.do"><button type="button" class="btn btn-default btn-flat">목록으로</button></a>
        		</div>
      		</div>
      		<!-- /.box -->
		</form:form>
	</div>
	<!-- /.content -->
	
</body>