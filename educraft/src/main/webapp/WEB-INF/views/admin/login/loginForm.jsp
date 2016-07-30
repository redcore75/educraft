<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					member_id: { required: "아이디를 입력하시오." },
					password: { required: "암호를 입력하시오." },
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
    <div class="container">
		<form class="form-signin" id="loginForm" name="loginForm" method="post" action="login.do">
			<h2 class="form-signin-heading">관리자로그인</h2>
			<label for="member_id" class="sr-only">아이디</label>
			<input type="text" id="member_id" name="member_id" class="form-control" placeholder="아이디를 입력하시오." autofocus/>
			<label for="password" class="sr-only">비밀번호</label>
			<input type="password" id="password" name="password" class="form-control" placeholder="비밀번호를 입력하시오."/>
			<div class="checkbox">
				<label><input type="checkbox" id="remember"/>아이디저장</label>
        	</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
		</form>
    </div>
</body>