<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
PageHelper pageHelper = (PageHelper)request.getAttribute("pageHelper");

logger.debug("web page ----" + pageHelper.getList().size());

%>
<head>	 				
	<script type="text/javascript">
		$(document).ready(function(){
            $("input[name='schDateType']:radio").change(function(){
                //라디오 버튼 값을 가져온다.
                var serviceType = this.value;
                if(serviceType == "T") {
                	var today = new Date();
                    $("#schStartDate" ).val(today.format("yyyyMMdd"));
                    $("#schEndDate" ).val(today.format("yyyyMMdd"));
                } else if(serviceType == "W") {
                	var today = new Date();
                	var week = new Date(Date.parse(new Date()) - 7 * 1000 * 60 * 60 * 24);
                    $("#schStartDate" ).val(week.format("yyyyMMdd"));
                    $("#schEndDate" ).val(today.format("yyyyMMdd"));
                } else if(serviceType == "M") {
                	var today = new Date();
                	var month = new Date(Date.parse(new Date()) - 30 * 1000 * 60 * 60 * 24);
                    $("#schStartDate" ).val(month.format("yyyyMMdd"));
                    $("#schEndDate" ).val(today.format("yyyyMMdd"));                	
                }
            });
		});
	</script>
</head>
<body>

	<div class="content">
  		<form>
      		<div class="box box-default">
        		<div class="box-header with-border">
          			<h3 class="box-title">회원관리 > 회원리스트</h3>
        		</div>
        		<!-- /.box-header -->
        		<div class="box-body">
          			<div class="row">
            			<div class="col-md-6">
              				<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label>회원아이디</label></div>
									<div class="col-md-10"><input type="text" id="schMember_id" name="schMember_id" class="form-control" style="width: 100%;"/></div>
								</div>
              				</div>
            			</div>
            			<!-- /.col -->
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
									<div class="col-md-2"><label>회원명</label></div>
									<div class="col-md-10"><input type="text" id="schMember_id" name="schMember_id" class="form-control" style="width: 100%;"/></div>
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
									<div class="col-md-2"><label>검색기간</label></div>
									<div class="col-md-10">
          								<div class="row">
          									<div class="col-md-3">
          										<div class="input-group date">
													<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
													<input type="text" id="schStartDate" name="schStartDate" class="form-control datepicker" style="width: 100%;" readonly/>
												</div>
											</div>
											<div class="col-md-1" align="center">
												~
											</div>
											<div class="col-md-3">
          										<div class="input-group date">
													<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
													<input type="text" id="schEndDate" name="schEndDate" class="form-control datepicker" style="width: 100%;" readonly/>
												</div>
											</div>
											<div class="col-md-5">
								                <label>
								                  <input type="radio" id="schDateType" name="schDateType" class="minimal-red" value="T">일별
								                </label>
								                <label>
								                  <input type="radio" id="schDateType" name="schDateType" class="minimal-red" value="W">주별
								                </label>
								                <label>
								                  <input type="radio" id="schDateType" name="schDateType" class="minimal-red" value="M">월별
								                </label>
                							</div>
										</div>
									</div>
              					</div>
            				</div>
						</div>
            			<div class="col-md-6">
	              			<div class="form-group">
								<div class="row">
								</div>
	              			</div>
            			</div>
					</div>
					<!-- /.row -->
				</div>
				
        		<!-- /.box-body -->
        		<div class="box-footer pull-right">
					<button type="submit" class="btn btn-info pull-right">검색하기</button>
        		</div>
      		</div>
      		<!-- /.box -->
		</form>

      	<div class="row">
        	<div class="col-xs-12">
          		<div class="box">
            		<div class="box-header">
              			<h3 class="box-title">총 10 건</h3>
            		</div>
            		<!-- /.box-header -->
            		<div class="box-body">
              			<table id="example2" class="table table-bordered table-hover">
                			<thead>
                				<tr>
                  					<th width="10%">회원번호</th>
                  					<th width="10%">회원아이디</th>
                  					<th>회원명</th>
                  					<th>이메일</th>
                  					<th width="10%">등록일</th>
                  					<th width="10%">수정일</th>
                				</tr>
                			</thead>                			
                			<tbody>
                				<c:forEach items="${pageHelper.list}" var="list">
	                				<tr>
	                  					<td>${list.member_seq}</td>
	                  					<td>${list.member_id}</td>
	                  					<td>${list.member_name}</td>
	                  					<td>${list.email_addr}</td>
	                  					<td>${list.regdate}</td>
	                  					<td>${list.uptdate}</td>
	                				</tr>
                				</c:forEach>
                			</tbody>
              			</table>
            		</div>
            		<!-- /.box-body -->
          		</div>
          		<!-- /.box -->
        	</div>
        	<!-- /.col -->
      	</div>
      	<!-- /.row -->
    				
		<div>
			
		</div>
	</div>
	<!-- /.content -->
	
</body>