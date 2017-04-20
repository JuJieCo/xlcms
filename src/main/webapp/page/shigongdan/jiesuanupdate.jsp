<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>君益达管理系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/css.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/sdmenu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/add.js"></script>
<script type="text/javascript">
function validateForm(formname){
	
	var wxzt = $("#wxzt").val();
	var sflx = $("#sflx").val();
	var sjpf = 	$("#sjpf").val();
	var sjzfy = $("#sjzfy").val();
	var sjwgrq = $("#sjwgrq").val();
	var temp=/^\d+(\.\d+)?$/;
	
	 
	if($.trim(sjwgrq)==""){
		alert("请选择实际完工日期");
		$("#sjwgrq").focus();
		return false;
	}
	 
	if(wxzt==2){
		 alert("维修状态有误!");
		 $("#wxzt").focus();
		 return false;
	}
	if(wxzt==4||wxzt==5||wxzt==6){
	if(sflx==3){//保险赔付
		if(temp.test(sjpf)==false){
			 alert("保险实际赔付金额有误!");
			 $("#sjpf").focus();
			 return false;
		}
		if(temp.test(sjzfy)==false){
			 alert("实际收款金额有误!");
			 $("#sjzfy").focus();
			 return false;
		}
	}else{
		if(temp.test(sjzfy)==false){
			 alert("实际收款金额有误!");
			 $("#sjzfy").focus();
			 return false;
		}
	}
	}
}

</script>
</head>

<body>
	<%@include file="/page/frame/top.jsp"%>
	 
	
	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>施工单管理<span class="divider">/</span>结算施工单</li></ul>
			<div class="title_right">
				<strong>结算施工单</strong>
			</div>
			 
				<form name="form" method="post" action="${pageContext.request.contextPath}/shiGongDanAction!modifyShiGongDanJiesuanForUpdate"   onsubmit="return validateForm(this)">
				<s:token name="s_token"></s:token>
				<div style="width: 95%; margin: auto">
					<table class="table table-bordered">
					<tr>
						<td width="10%" align="right" bgcolor="#f1f1f1">工单登记日期：</td>
							<td>&nbsp;${shiGongDan.gddjrq}</td>
						<td width="10%" align="right" bgcolor="#f1f1f1">施工单号：</td>
						<td width="10%" >&nbsp;${shiGongDan.danhao} 
							<input type="hidden" name="shiGongDan.gdid"   value="${shiGongDan.gdid}" />	
							<input type="hidden" name="shiGongDan.wlzt"  id="wlzt"  value="${shiGongDan.wlzt}">
						</td>
					</tr>
						<tr>
							
							<td width="10%" align="right" bgcolor="#f1f1f1">车牌号码：</td>
							<td width="10%" >&nbsp;${shiGongDan.cphm} </td>
							<td width="10%" align="right" bgcolor="#f1f1f1">车辆品牌：</td>
							<td width="10%" >&nbsp;${shiGongDan.clpp}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">车辆型号：</td>
							<td width="10%" >&nbsp;${shiGongDan.clxh}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">车架号：</td>
							<td  width="10%" >&nbsp;${shiGongDan.cjh}</td>
						</tr>
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">发动机号：</td>
							<td  width="10%" >&nbsp;${shiGongDan.fdjh}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">发动机排量：</td> 
							<td  width="10%" >&nbsp;${shiGongDan.fdjpx}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">车辆里程：</td>
							<td  width="10%" >&nbsp;${shiGongDan.cllc}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">生产日期：</td> 
							<td  width="10%" >&nbsp;${shiGongDan.scrq}</td>
						</tr>
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">客户类型：</td>
							<td width="10%" >&nbsp;
								<c:if test="${shiGongDan.khlx eq 1}">自主进店</c:if>
								<c:if test="${shiGongDan.khlx eq 2}">快速理赔</c:if>
								<c:if test="${shiGongDan.khlx eq 3}">自报保险</c:if>
								<c:if test="${shiGongDan.khlx eq 4}">协议单位</c:if>
								<c:if test="${shiGongDan.khlx eq 5}">返工免单</c:if>
								<c:if test="${shiGongDan.khlx eq 6}">i保养客户</c:if>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">客户名称：</td>
							<td  width="10%" >&nbsp;${shiGongDan.khmc}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">客户电话：</td>
							<td  width="10%" >&nbsp;${shiGongDan.khdh}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">维修顾问：</td>
							<td  width="10%" >&nbsp;
								<c:if test="${shiGongDan.wxgw eq 1}">田晓松</c:if>
								<c:if test="${shiGongDan.wxgw eq 2}">金爱</c:if>
								<c:if test="${shiGongDan.wxgw eq 19}">乔倩</c:if>
							</td>
						</tr>
						<tr>
							
							<td width="10%" align="right" bgcolor="#f1f1f1">收费类型：</td>
							<td width="10%" >&nbsp;
							 		<c:if test="${shiGongDan.sflx eq 1}">付现/刷卡</c:if>
							 		<c:if test="${shiGongDan.sflx eq 2}">会员消费</c:if>
							 		<c:if test="${shiGongDan.sflx eq 3}">保险赔付</c:if>
							 		<c:if test="${shiGongDan.sflx eq 4}">单位挂账</c:if>
							 		<c:if test="${shiGongDan.sflx eq 5}">免收费用</c:if>
							 		<c:if test="${shiGongDan.sflx eq 6}">i保养客户</c:if>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">维修类型：</td>
							<td width="10%" >&nbsp;
							 		<c:if test="${shiGongDan.wxlx eq 1}">保养维修</c:if>
							 		<c:if test="${shiGongDan.wxlx eq 2}">钣金喷漆</c:if>
							 		<c:if test="${shiGongDan.wxlx eq 3}">机电钣喷</c:if>
							 		<c:if test="${shiGongDan.wxlx eq 4}">洗车美容</c:if>
							 		<c:if test="${shiGongDan.wxlx eq 5}">商品零售</c:if>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">维修状态：</td>
							<td>
								<select name="shiGongDan.wxzt"  id="wxzt"  class="span1-1">
									<option value="2" ${shiGongDan.wxzt==2?"selected":"" }>维修施工</option>
							 		<option value="3" ${shiGongDan.wxzt==3?"selected":"" }>等待结账</option>
							 		<option value="4" ${shiGongDan.wxzt==4?"selected":"" }>结账离店</option>
							 		<option value="5" ${shiGongDan.wxzt==5?"selected":"" }>检查未修/无费用</option>
							 		<option value="6" ${shiGongDan.wxzt==6?"selected":"" }>挂账离店</option>
								</select>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">协议单位名称：</td>
							<td width="10%" >&nbsp;
							 		<c:if test="${shiGongDan.dwmc eq 1}">老村长酒业</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 2}">四十七军部队</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 3}">火箭军工程大学</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 4}">洪庆城管</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 5}">新市社区</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 6}">向阳公司</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 7}">志风工贸</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 8}">天风建筑</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 9}">诚惠金属</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 10}">福宝铸造</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 11}">中谷中实</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 12}">瑞莱科技</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 13}">个人协议车辆</c:if>
							 		<c:if test="${shiGongDan.dwmc eq 14}">秦农银行</c:if>
							</td>
						</tr>
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">机修主修人：</td>
							<td width="10%" >&nbsp;
							 		<c:if test="${shiGongDan.jxzxr eq 7}">康金榜</c:if>
							 		<c:if test="${shiGongDan.jxzxr eq 14}">张伟</c:if>
							 		<c:if test="${shiGongDan.jxzxr eq 16}">董俊康</c:if>
							 		<c:if test="${shiGongDan.jxzxr eq 17}">刘锐</c:if>
							 		<c:if test="${shiGongDan.jxzxr eq 18}">李晓斌</c:if>
							 		<c:if test="${shiGongDan.jxzxr eq 19}">闫龙飞</c:if>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">机修终检人：</td>
							<td width="10%" >&nbsp;
							 		<c:if test="${shiGongDan.jxzjr eq 7}">康金榜</c:if>
							 		<c:if test="${shiGongDan.jxzjr eq 14}">张伟</c:if>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">钣喷主修人：</td>
							<td width="10%" >&nbsp;
							 		<c:if test="${shiGongDan.bpzxr eq 9}">王兴</c:if>
							 		<c:if test="${shiGongDan.bpzxr eq 10}">马建兵</c:if>
							 		<c:if test="${shiGongDan.bpzxr eq 8}">薛旭光</c:if>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">钣喷终检人：</td>
							<td width="10%" >&nbsp;
							 		<c:if test="${shiGongDan.bpzxr eq 9}">王兴</c:if>
							 		<c:if test="${shiGongDan.bpzxr eq 10}">马建兵</c:if>
							 		<c:if test="${shiGongDan.bpzxr eq 8}">薛旭光</c:if>
							</td>
						</tr>
						<tr>
							
							<td width="10%" align="right" bgcolor="#f1f1f1">实际完工日期：</td>
							<td>
								<input type="text"  name="shiGongDan.sjwgrq"  id="sjwgrq"  value="${shiGongDan.sjwgrq}"  class="laydate-icon span1-1" />
							</td>
							 <td width="10%" align="right" bgcolor="#f1f1f1">投保公司：</td>
							<td >&nbsp;
							 		<c:if test="${shiGongDan.tbgs eq 1}">人保保险</c:if>
									<c:if test="${shiGongDan.tbgs eq 2}">平安保险</c:if>
									<c:if test="${shiGongDan.tbgs eq 3}">永安保险</c:if>
									<c:if test="${shiGongDan.tbgs eq 4}">阳光保险</c:if>
									<c:if test="${shiGongDan.tbgs eq 5}">太平洋保险</c:if>
									<c:if test="${shiGongDan.tbgs eq 6}">大地保险</c:if>
									<c:if test="${shiGongDan.tbgs eq 7}">中华联合保险</c:if>
									<c:if test="${shiGongDan.tbgs eq 8}">国寿财保险</c:if>
									<c:if test="${shiGongDan.tbgs eq 9}">天安保险</c:if>
									<c:if test="${shiGongDan.tbgs eq 10}">安邦保险</c:if>
									<c:if test="${shiGongDan.tbgs eq 11}">太平保险</c:if>
									<c:if test="${shiGongDan.tbgs eq 12}">华泰保险</c:if>
									<c:if test="${shiGongDan.tbgs eq 13}">出口信用保险</c:if>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">保险到期日期：</td>
							<td  width="10%" >&nbsp;${shiGongDan.bxdqrq}</td>
							<td width="10%"  align="right" bgcolor="#f1f1f1">保险预计赔付金额：</td>
							<td>&nbsp;${shiGongDan.yjpf}</td>
						</tr>
						
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">备注：</td>
							<td colspan="8"><textarea name="shiGongDan.remark"  rows="3" cols="50" class="span11">${shiGongDan.remark}</textarea></td>
						</tr>
						 <tr>
							<td width="10%"  height="50"  align="right" bgcolor="#f1f1f1">总费用：</td>
							<td  colspan="2" align="center"><font color="red" size="9">¥ ${shiGongDan.zfy}</font></td>
							<td width="10%"  height="50"  align="right" bgcolor="#f1f1f1">实际收款金额：</td>
							<td colspan="2" align="left"> &nbsp;&nbsp;
		 						<input type="text" name="shiGongDan.sjzfy"  id="sjzfy"   value="${shiGongDan.sjzfy}"    style="font-weight:bold ; color:red ; font-size:35px; height:40px;"  />
							</td>
							<td width="10%"  height="50"  align="right" bgcolor="#f1f1f1">保险实际赔付金额：</td>
							<td colspan="2" align="left"> &nbsp;&nbsp;
								<input type="text" name="shiGongDan.sjpf"  id="sjpf"   value="${shiGongDan.sjpf}"    style="font-weight:bold ; color:red ; font-size:35px; height:40px;"  />
							</td>
						</tr>
					</table>

					
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>备料状态</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料名称</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料质量</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>数量</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>申请报价日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>申请备料日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料入库日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>车间领料日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料费(单价)</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>工时费</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>是否要货</strong></td>
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
							</td>
							 
							<td align="center">&nbsp;${list.wlmc }</td>  
							<td align="center">&nbsp;
								<c:if test="${list.wlzl eq 1}">原车</c:if> 
								<c:if test="${list.wlzl eq 2}">其它</c:if> 
							</td>
							<td align="center">&nbsp;${list.shuliang }</td>
							<td align="center">&nbsp;${list.bjrq }</td>
							<td align="center">&nbsp;${list.fhrq }</td>
							<td align="center">&nbsp;${list.rkrq }</td>
							<td align="center">&nbsp;${list.llrq }</td>
						 	<td align="center">&nbsp;${list.danjia }</td>
						 	<td align="center">&nbsp;${list.gsf}</td>
						 	 <td align="center">&nbsp;
						 	 	<c:if test="${list.sfyh eq 0}">否</c:if>
						 	 	<font color="red">
						 	 	<c:if test="${list.sfyh eq 1}">是</c:if>
						 	 	</font>
						 	</td>
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
	<div id="footer">版权所有：jujie &copy; 2016&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<script>
		!function() {
			laydate.skin('molv');
			laydate({
				elem : '#sjwgrq',
				format : 'YYYY-MM-DD'
			});
		}();
	</script>
</body>
</html>