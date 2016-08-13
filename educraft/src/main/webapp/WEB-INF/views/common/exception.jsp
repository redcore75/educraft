<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
%>
<head>	 				
	<script type="text/javascript">
		$(document).ready(function(){
		});
	</script>
</head>
<body>
	<div class="container">	
		<div class="box-body">
			<div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <h4><i class="icon fa fa-ban"></i> Alert!</h4>
				${exception}
			</div>
		</div>
	</div>
</body>