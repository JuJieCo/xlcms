<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>君益达管理系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/css.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/sdmenu.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/laydate/laydate.js"></script>



<script type="text/javascript">

	function selectPage(currentPage){
		var form = document.forms.form1;
		form.action = form.action+"?page.currentPage="+currentPage;
		//alert(form.action);
		form.submit();
	}
	
</script>
</head>
 


<body>
		<%@include file="/page/frame/top.jsp" %>
		<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>人员管理<span class="divider">/</span>查询人员信息</li></ul>
				<div class="title_right">
					<strong>查询人员信息</strong>
				</div>
				
				<div style="width: 95%; margin: auto">
				<form action="${pageContext.request.contextPath}/ryglAction!showRyglList" name="form1"  method="post" >
				<s:token name="s_token"></s:token>
				
					<table class="table table-bordered">
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">姓名：</td>
							<td width="10%" ><input type="text" name="rygl.name"  value="${rygl.name}"  class="span1-1" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">部门：</td>
							<td width="10%" >
								<select name="rygl.dept"  id="dept"  class="span1-1">
									<option value="0" ${rygl.dept==0?"selected":"" }>--请选择--</option>
									<option value="1" ${rygl.dept==1?"selected":"" }>前台</option>
									<option value="2" ${rygl.dept==2?"selected":"" }>快速理赔</option>
									<option value="3" ${rygl.dept==3?"selected":"" }>机修车间</option>
									<option value="4" ${rygl.dept==4?"selected":"" }>钣喷车间</option>
									<option value="5" ${rygl.dept==5?"selected":"" }>美容装潢车间</option>
									<option value="6" ${rygl.dept==6?"selected":"" }>洗车房</option>
									<option value="7" ${rygl.dept==7?"selected":"" }>行政/财务部门</option>
									<option value="8" ${rygl.dept==8?"selected":"" }>库房</option>
									<option value="9" ${rygl.dept==9?"selected":"" }>后勤部门</option>
								</select>
							</td>
						</tr>
					</table>


					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center"><input type="submit" value="查询" class="btn btn-info " style="width: 80px;" /></td>
							<td class="text-center"><input type="button" value="新建"  onclick="location.href='${pageContext.request.contextPath}/ryglAction!showRyglForModify'"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" /></td>
						</tr>
					</table>
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>姓名</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>性别</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>部门</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>职务</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>级别</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>工种</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>状态</strong></td>
							<td width="15%" align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>操作</strong></td>
						</tr>
						<s:iterator value="ryglList" var="list">
						<tr>
							<td align="center">&nbsp;${list.name }</td>
							<td align="center">&nbsp;
								<c:if test="${list.sex eq 1 }">男</c:if>
						 		<c:if test="${list.sex eq 2 }">女</c:if>
							</td>
						 	<td align="center">&nbsp;
						 		<c:if test="${list.dept eq 1 }">前台</c:if>
						 		<c:if test="${list.dept eq 2 }">快速理赔</c:if>
						 		<c:if test="${list.dept eq 3 }">机修车间</c:if>
						 		<c:if test="${list.dept eq 4 }">钣喷车间</c:if>
						 		<c:if test="${list.dept eq 5 }">美容装潢车间</c:if>
						 		<c:if test="${list.dept eq 6 }">洗车房</c:if>
						 		<c:if test="${list.dept eq 7 }">行政/财务部门</c:if>
						 		<c:if test="${list.dept eq 8 }">库房</c:if>
						 		<c:if test="${list.dept eq 9 }">后勤部门</c:if>
						 	</td>
							<td align="center">&nbsp;${list.duty }</td>
							<td align="center">&nbsp;
								<c:if test="${list.level eq 1 }">大工</c:if>
								<c:if test="${list.level eq 2 }">中工</c:if>
								<c:if test="${list.level eq 3 }">小工</c:if>
								<c:if test="${list.level eq 4 }">学徒</c:if>
								<c:if test="${list.level eq 5 }">其它</c:if>
							</td>	 
							<td align="center">&nbsp;
								<c:if test="${list.workType eq 1 }">接待服务</c:if>
								<c:if test="${list.workType eq 2 }">机电工</c:if>
								<c:if test="${list.workType eq 3 }">钣金工</c:if>
								<c:if test="${list.workType eq 4 }">喷漆工</c:if>
								<c:if test="${list.workType eq 5 }">美容工</c:if>
								<c:if test="${list.workType eq 6 }">洗车工</c:if>
								<c:if test="${list.workType eq 7 }">行政/财务</c:if>
								<c:if test="${list.workType eq 8 }">库管员</c:if>
								<c:if test="${list.workType eq 9 }">后勤人员</c:if>
							</td>	
						 	<td align="center">&nbsp;
						 		<c:if test="${list.status eq 1 }">在职</c:if>
						 		<c:if test="${list.status eq 2 }">离职</c:if>
						 	</td>
							<td align="center">
								<a href="${pageContext.request.contextPath}/ryglAction!showRyglByID?ryid=${list.ryid}">查看</a>&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath}/ryglAction!showRyglForModify?ryid=${list.ryid}">修改</a>&nbsp;&nbsp;
							</td>
						</tr>
						</s:iterator>
					</table>
					 <%@include file="/page/plugin/page.jsp" %>
					</form>
				</div>

				
			</div>
		</div>
	</div>

	<!-- 底部 -->
	<div id="footer">
		版权所有：jujie &copy; 2016&nbsp;&nbsp;&nbsp;&nbsp; 
	</div>



	<script>
		!function() {
			laydate.skin('molv');
			laydate({
				elem : '#Calendar1',
				//istime : 'true',
				//format : 'YYYY-MM-DD hh-mm-ss',
				format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar2',
					//istime : 'true',
					format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar3',
					//istime : 'true',
					format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar4',
					//istime : 'true',
					format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar5',
					//istime : 'true',
					format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar6',
					//istime : 'true',
					format : 'YYYY-MM-DD'
			});
		}();
	</script>





</body>
</html>