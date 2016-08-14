<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<head>	 				
	<script type="text/javascript">
		$(document).ready(function(){
			if($.cookie("member_id") != null) {
				//alert("get cookies " +  $.cookie("member_id"));
				$("#member_id").val( $.cookie("member_id"));
			}
			
			$("#loginForm").validate({
				rules: {
					member_id: { required: true },
					password: { required: true },
				},
				messages: {
					member_id: { required: "아이디를 입력하세요." },
					password: { required: "비밀번호를 입력하세요." },
				},
				submitHandler: function (form) {
					form.submit();
				}
			});
			
			$("#remember").click(function(){
				//alert("member_id " + $("#member_id").val());
				 $.cookie("member_id", $("#member_id").val(), {expires:365});
			});
		});
	</script>
</head>
<body>
	
	<div class="login-box">
  		<div class="login-logo">
    		관리자로그인
  		</div>
  		<!-- /.login-logo -->
  		<div class="login-box-body">
    		<form class="form-signin" id="loginForm" name="loginForm" method="post" action="login.do">
      			<div class="form-group has-feedback">
					<input type="text" id="member_id" name="member_id" class="form-control" placeholder="아이디를 입력하세요." autofocus/>
        			<span class="glyphicon glyphicon-user form-control-feedback"></span>
      			</div>
      			<div class="form-group has-feedback">
        			<input type="password" id="password" name="password" class="form-control" placeholder="비밀번호를 입력하세요."/>
        			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
      			</div>
      			<div class="row">
	        		<div class="col-xs-8" align="right">
	          			<div class="checkbox icheck">
	            			<label><input type="checkbox" id="remember"/> 아이디저장</label>
	          			</div>
	        		</div>
	        		<div class="col-xs-4">
	          			<button type="submit" class="btn btn-primary btn-block btn-flat">로그인</button>
	        		</div>
      			</div>
    		</form>
		</div>
	</div>
    
</body>