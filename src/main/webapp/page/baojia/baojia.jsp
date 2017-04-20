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
function count(){
	var danjia = 0;
	var gsf = 0;
	var zfy =0 ;
	var shuliang =0;
	for(var i=0 ; i<'${baoJiaList.size()}'; i++){  
		if($("#danjia"+i).val()!=""){
			danjia += Number($("#danjia"+i).val())*Number($("#shuliang"+i).val());
		}
		if($("#gsf"+i).val()!=""){
			gsf += Number($("#gsf"+i).val());
		}
		zfy = Number(danjia)+Number(gsf);
	}  
	//alert(zfy);
	 $("#zfy").val(zfy);
}  




function validateForm(formname){
	var temp=/^\d+(\.\d+)?$/;
	for(var i=0 ; i<'${baoJiaList.size()}'; i++){  
		var danjia = $("#danjia"+i).val();
		if(temp.test(danjia)==false){
			 alert("物料费(单价)为空或不是纯数字!");
			 $("#danjia"+i).focus();
			 return false;
		}
		
	}
	
}

</script>

</head>
 


 


<body>
		<%@include file="/page/frame/top.jsp" %>
		<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>报价管理 <span class="divider">/</span>创建报价单</li></ul>
				<div class="title_right">
					<strong>创建报价单</strong>
				</div>
				
				
			<form name="form" method="post" action="${pageContext.request.contextPath}/baoJiaAction!modifyBaojiaForSave?gdid=${shiGongDan.gdid}"   onsubmit="return validateForm(this)">
				<s:token name="s_token"></s:token>
				<div style="width: 95%; margin: auto">
					<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">施工单号：</td>
							<td>
								<input type="text" name="shiGongDan.danhao"  id="danhao"  class="span2" value="${shiGongDan.danhao}"  readonly="readonly"/>
								<input type="hidden" name="shiGongDan.gdid"   value="${shiGongDan.gdid}" />
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">车牌号码：</td>
							<td>
								<input type="text" name="shiGongDan.cphm"  id="cphm"  class="span1-1" value="${shiGongDan.cphm}" readonly="readonly"/>
							</td>
							
							<td width="10%" align="right" bgcolor="#f1f1f1">车辆品牌：</td>
							<td>
								<input type="text" name="shiGongDan.clpp"  id="clpp"  class="span1-1" value="${shiGongDan.clpp}" readonly="readonly"/>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">车辆型号：</td>
							<td>
								<input type="text" name="shiGongDan.clxh" id="clxh"  class="span1-1" value="${shiGongDan.clxh}"  readonly="readonly"/>
							</td>
						</tr>
						
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">车架号：</td>
							<td>
								<input type="text" name="shiGongDan.cjh"  id="cjh"  class="span2" value="${shiGongDan.cjh}" readonly="readonly"/>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">发动机号：</td>
							<td>
								<input type="text" name="shiGongDan.fdjh" class="span1-1" value="${shiGongDan.fdjh}" readonly="readonly"/>
							</td>
							
							<td width="10%" align="right" bgcolor="#f1f1f1">发动机排量：</td>
							<td >
								<input type="text" name="shiGongDan.fdjpx" class="span1-1" value="${shiGongDan.fdjpx}" readonly="readonly"/>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">生产日期：</td>
							<td>
								<input type="text" name="shiGongDan.danhao"  id="danhao"  class="span1-1" value="${shiGongDan.scrq}"  readonly="readonly"/>
							</td>
							
						</tr>
						
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">客户类型：</td>
							<td>
								<c:if test="${shiGongDan.khlx eq 1}"><input type="text" name="shiGongDan.cllc" class="span1-1" value="自主进店" readonly="readonly"/></c:if>
								<c:if test="${shiGongDan.khlx eq 2}"><input type="text" name="shiGongDan.cllc" class="span1-1" value="快速理赔" readonly="readonly"/></c:if>
								<c:if test="${shiGongDan.khlx eq 3}"><input type="text" name="shiGongDan.cllc" class="span1-1" value="自报保险" readonly="readonly"/></c:if>
								<c:if test="${shiGongDan.khlx eq 4}"><input type="text" name="shiGongDan.cllc" class="span1-1" value="协议单位" readonly="readonly"/></c:if>
								<c:if test="${shiGongDan.khlx eq 5}"><input type="text" name="shiGongDan.cllc" class="span1-1" value="返工免单" readonly="readonly"/></c:if>
								<c:if test="${shiGongDan.khlx eq 6}"><input type="text" name="shiGongDan.cllc" class="span1-1" value="i保养客户" readonly="readonly"/></c:if>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">收费类型：</td>
							<td>
								<c:if test="${shiGongDan.sflx eq 1}"><input type="text" name="shiGongDan.sflx"  id="sflx"  class="span1-1" value="付现/刷卡"  readonly="readonly"/></c:if>
								<c:if test="${shiGongDan.sflx eq 2}"><input type="text" name="shiGongDan.sflx"  id="sflx"  class="span1-1"  value="会员消费"  readonly="readonly"/></c:if>	
								<c:if test="${shiGongDan.sflx eq 3}"><input type="text" name="shiGongDan.sflx"  id="sflx"  class="span1-1"  value="保险赔付"  readonly="readonly"/></c:if>	
								<c:if test="${shiGongDan.sflx eq 4}"><input type="text" name="shiGongDan.sflx"  id="sflx"  class="span1-1"  value="单位挂账"  readonly="readonly"/></c:if>	
								<c:if test="${shiGongDan.sflx eq 5}"><input type="text" name="shiGongDan.sflx"  id="sflx"  class="span1-1"  value="免收费用"  readonly="readonly"/></c:if>
								<c:if test="${shiGongDan.sflx eq 6}"><input type="text" name="shiGongDan.sflx"  id="sflx"  class="span1-1"  value="i保养客户"  readonly="readonly"/></c:if>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">保险预计赔付：</td>
							<td>
								<input type="text" name="shiGongDan.cphm"  id="yjpf"  class="span1-1" value="${shiGongDan.yjpf}" readonly="readonly"/>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">协议单位名称：</td>
							<td>
								<input type="text" name="shiGongDan.clxh" id="dwmc"  class="span1-1" value="${shiGongDan.dwmc}"  readonly="readonly"/>
							</td>
						</tr>
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">备注：</td>
							<td colspan="8"><textarea name="shiGongDan.remark"  rows="2" cols="50" class="span11">${shiGongDan.remark}</textarea></td>
						</tr>
					</table>
		 
		 			<table class="table table-bordered">
						<tr>
							<td width="10%"  height="30"  align="right" bgcolor="#f1f1f1">总费用：</td>
							<td align="left">&nbsp;<input type="text" name="shiGongDan.zfy"  id="zfy"  class="span1-1"  value="${shiGongDan.zfy}"  readonly="readonly" style="color:red ; font-weight:bold "/></td>
						</tr>
					</table>
					
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>报价状态</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料名称</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料质量</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>数量</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>申请报价日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料费(单价)</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>工时费</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>操作</strong></td>
						</tr>
						
						<s:iterator value="baoJiaList" var="list" status="st">
						<tr>
							<td align="center">&nbsp;
								<font color="red">
								<c:if test="${list.bjzt eq 1}">等待报价</c:if> 
								<c:if test="${list.bjzt eq 2}">已报价</c:if> 
								<c:if test="${list.bjzt eq 3}">申请备料</c:if>
								<c:if test="${list.bjzt eq 4}">备料到货</c:if> 
								<c:if test="${list.bjzt eq 5}">领料出库</c:if>
								</font>
								<input type="hidden" name="baoJiaList[<s:property value='#st.index'/>].bjid"  id="bjid<s:property value='#st.index'/>"  class="span1" value="${list.bjid}"/>
						 		<input type="hidden" name="baoJiaList[<s:property value='#st.index'/>].bjzt"  id="bjzt<s:property value='#st.index'/>"  class="span1" value="${list.bjzt}"/>
								<input type="hidden" name="baoJiaList[<s:property value='#st.index'/>].shuliang"  id="shuliang<s:property value='#st.index'/>"  class="span1" value="${list.shuliang}"   />
							</td>
							<td align="center">&nbsp;${list.wlmc }</td>  
							<td align="center">&nbsp;
								<c:if test="${list.wlzl eq 1}">原车</c:if> 
								<c:if test="${list.wlzl eq 2}">其它</c:if> 
							</td>
							<td align="center">&nbsp;${list.shuliang }</td>
							<td align="center">&nbsp;${list.bjrq }</td>
						 	<td align="center">&nbsp; 
						 		<c:if test="${list.danjia eq null }">  
						 			<input type="text" name="baoJiaList[<s:property value='#st.index'/>].danjia"  id="danjia<s:property value='#st.index'/>"  class="span1" value=""  onblur="count();" />
						 		</c:if>
						 		<c:if test="${list.danjia ne null }">  
						 			<input type="text" name="baoJiaList[<s:property value='#st.index'/>].danjia"  id="danjia<s:property value='#st.index'/>"  class="span1" value="${list.danjia}"  readonly="readonly"  onblur="count();" />
						 		</c:if>
						 	</td>
						 	<td align="center">&nbsp;
						 		<c:if test="${list.gsf eq null }">  
						 			<input type="text" name="baoJiaList[<s:property value='#st.index'/>].gsf"  id="gsf<s:property value='#st.index'/>"  class="span1" value=""  onblur="count();" />
						 		</c:if>
						 		<c:if test="${list.gsf ne null }">  
						 			<input type="text" name="baoJiaList[<s:property value='#st.index'/>].gsf"  id="gsf<s:property value='#st.index'/>"  class="span1" value="${list.gsf}"  readonly="readonly"  onblur="count();" />
						 		</c:if>
						 	</td>
						 	<td align="center"><a href="${pageContext.request.contextPath}/baoJiaAction!modifyBaoJiaForDelete?tag=baojia&bjid=${list.bjid }&gdid=${shiGongDan.gdid}" onclick="return(confirm('确认要删除吗?'));">删除</a>&nbsp;&nbsp;</td>  
						</tr>
						</s:iterator>
					</table>
					
					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center">
								<input type="submit" value="提交"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" />
								<input type="button" value="返回"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" onclick="history.go(-1)"/>	
							</td>
						</tr>
					</table>
				</div>
			</form>

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