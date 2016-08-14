<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
ParamMap paramMap = (ParamMap) request.getAttribute("paramMap");
%>
<head>	 				
	<script type="text/javascript">
		$(document).ready(function(){
			$("#checkMemberDup").click(function(){
				var member_id = $("#member_id").val();
				if(member_id == "") {
					alert("아이디를 입력하세요.");
				} else {
					$.ajax({
						url:"${pageContext.request.contextPath}/api/checkMemberDup.do?member_id=" + member_id,
						type:"GET",
						data: {},
						dataType:"json",
						cache:false,
						success:function(data){
							if(data.code == 0000) {
								$("#member_id").val("");
								alert("사용중인 아이디입니다.");
							} else {
								alert("사용가능한 아이디입니다.");
							}
						},
						error : function(request, status, error) {
							alert("code : " + request.status + "\r\nmessage : " + request.responseText + "\r\nerror : " + error);
						}
					});
				}
			});
		});
	</script>
</head>
<body>

	<div class="content">
  		<form:form modelAttribute="tbl_member" class="form-signin" id="registForm" name="registForm" method="post" action="regist.do">
  			<cf:token/>
  			<form:input path="member_type" type="hidden" value="A"/>
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
									<div class="col-md-10">
										<div class="row">
											<div class="col-md-6">
												<form:errors path="member_id" cssClass="text-red" element="div"/>
												<form:input path="member_id" type="text" class="form-control" maxlength="30" style="width: 100%;"/>
											</div>
											<div class="col-md-6">
												<button id="checkMemberDup" type="button" class="btn btn-info btn-flat">중복체크</button>
											</div>
										</div>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label>비밀번호</label></div>
									<div class="col-md-10">
										<form:errors path="password" cssClass="text-red" element="div"/>
										<form:input path="password" type="password" class="form-control" maxlength="100" style="width: 100%;"/>
									</div>
								</div>
	              			</div>
            			</div>
            			<!-- /.col -->
					</div>
					<!-- /.row -->
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label>관리자명</label></div>
									<div class="col-md-10">
										<form:errors path="member_name" cssClass="text-red" element="div"/>
										<form:input path="member_name" type="text" class="form-control" maxlength="50" style="width: 100%;"/>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label>이메일</label></div>
									<div class="col-md-10">
										<form:errors path="email_addr" cssClass="text-red" element="div"/>
										<form:input path="email_addr" type="text" class="form-control" maxlength="100" style="width: 100%;"/>
									</div>
								</div>
	              			</div>
            			</div>
            			<!-- /.col -->
					</div>
					<!-- /.row -->
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label>관리자권한</label></div>
									<div class="col-md-10">
										<form:errors path="member_level_seq" cssClass="text-red" element="div"/>
										<form:select path="member_level_seq" class="form-control" style="width: 100%;">
											<option value="0">---선택하세요.---</option>
											<option value="1">관리자</option>
										</form:select>
									</div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label>전화번호</label></div>
									<div class="col-md-10">
										<form:errors path="mobile_num" cssClass="text-red" element="div"/>
										<form:input path="mobile_num" type="text" class="form-control" maxlength="12" style="width: 100%;"/>
									</div>
								</div>
	              			</div>
            			</div>
            			<!-- /.col -->
					</div>
					<!-- /.row -->					
				</div>
        		<!-- /.box-body -->
      		</div>
      		<!-- /.box -->
		</form:form>
		
		<div class="row">
			<div class="col-md-12">
				<div align="right">
					<button type="submit" class="btn btn-default btn-flat" onclick="javascript:document.registForm.submit();this.disabled=true">등록하기</button>
					<a href="searchList.do"><button type="button" class="btn btn-default btn-flat">목록으로</button></a>
				</div>
			</div>
		</div>		
	</div>
	<!-- /.content -->
	
</body>