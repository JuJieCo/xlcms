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
			 var temp=/^\d+(\.\d+)?$/;
			 var yunfei = $("#danhao").val();
			 var cphm = $("#cphm").val();
			 var clpp = $("#clpp").val();
			 var clxh = $("#clxh").val();
			 var cjh = $("#cjh").val();
			 var fdjh = $("#fdjh").val();
			 var fdjpx = $("#fdjpx").val();
			 var cllc = $("#cllc").val();
			 var scrq = $("#scrq").val();
			 var khmc = $("#khmc").val();
			 var khdh = $("#khdh").val();
			 
			 var wxgw = $("#wxgw").val();
			 var khlx = $("#khlx").val();
			 var sflx = $("#sflx").val();
			 var wxlx = $("#wxlx").val();
			 var wxzt = $("#wxzt").val();
			 
			 var jxzxr = $("#jxzxr").val(); 
			 var jxzjr = $("#jxzjr").val();
			 var bpzxr = $("#bpzxr").val();
			 var bpzjr = $("#bpzjr").val();
			 
			 var dwmc = $("#dwmc").val();
			 var yjpf = $("#yjpf").val();
			 var sjpf = $("#sjpf").val();
			 
			 var yjwgrq = $("#yjwgrq").val();
			 
			 var tbgs = $("#tbgs").val();
			 var bxdqrq = $("#bxdqrq").val();
		
			
			 
			 
			 if($.trim(danhao)==""){
					 alert("施工单号不能为空");
					 $("#danhao").focus();
					 return false;
				}
			 if($.trim(cphm)==""){
				 alert("车牌号码不能为空");
				 $("#cphm").focus();
				 return false;
			}
			 if($.trim(clpp)==""){
				 alert("车辆品牌不能为空");
				 $("#clpp").focus();
				 return false;
			}
			 if($.trim(clxh)==""){
				 alert("车辆型号不能为空");
				 $("#clxh").focus();
				 return false;
			}
			 if($.trim(cjh)==""){
				 alert("车架号不能为空");
				 $("#cjh").focus();
				 return false;
			}
			 if($.trim(fdjh)==""){
				 alert("发动机号不能为空");
				 $("#fdjh").focus();
				 return false;
			}
			 if($.trim(fdjpx)==""){
				 alert("发动机排量不能为空");
				 $("#fdjpx").focus();
				 return false;
			}
			 if($.trim(cllc)==""){
				 alert("车辆里程不能为空");
				 $("#cllc").focus();
				 return false;
			}
			 if($.trim(scrq)==""){
				 alert("生产日期不能为空");
				 $("#scrq").focus();
				 return false;
			}
			 if($.trim(khmc)==""){
				 alert("客户名称不能为空");
				 $("#khmc").focus();
				 return false;
			}
			 if($.trim(khdh)==""){
				 alert("客户电话不能为空");
				 $("#khdh").focus();
				 return false;
			}
			 if($.trim(wxgw)==0){
				 alert("请选择维修顾问");
				 $("#wxgw").focus();
				 return false;
			}
			 
			 
			 
			 
			 
			 
			 if($.trim(khlx)==0){
				 alert("请选择客户类型");
				 $("#khlx").focus();
				 return false;
			}
			 /*逻辑--客户类型&收费类型--开始*/
			 if($.trim(khlx)==1&&$.trim(sflx)!=0){
				 if($.trim(sflx)!=1&&$.trim(sflx)!=2){
					 alert("收费类型请选择 付现/刷卡 或 会员消费");
					 $("#sflx").focus();
					 return false;
				}
			}
			 if($.trim(khlx)==2&&$.trim(sflx)!=0){
				 if($.trim(sflx)!=3){
					 alert("收费类型请选 保险赔付");
					 $("#sflx").focus();
					 return false;
				}
			}
			 if($.trim(khlx)==3&&$.trim(sflx)!=0){
				 if($.trim(sflx)!=3){
					 alert("收费类型请选 保险赔付");
					 $("#sflx").focus();
					 return false;
				}
			}
			 if($.trim(khlx)==4&&$.trim(sflx)!=0){
				 if($.trim(sflx)!=4){
					 alert("收费类型请选 单位挂账");
					 $("#sflx").focus();
					 return false;
				}
			}
			 if($.trim(khlx)==5&&$.trim(sflx)!=0){
				 if($.trim(sflx)!=5){
					 alert("收费类型请选 免收费用");
					 $("#sflx").focus();
					 return false;
				}
			}
			 if($.trim(khlx)==6&&$.trim(sflx)!=0){
				 if($.trim(sflx)!=6){
					 alert("收费类型请选 i保养客户");
					 $("#sflx").focus();
					 return false;
				}
			}
			 /*逻辑--客户类型&收费类型--开始*/
			 
			 
			 
			 
			 
			 
			 if($.trim(sflx)==0){
				 alert("请选择收费类型");
				 $("#sflx").focus();
				 return false;
			}
			 /*逻辑--收费类型&客户类型--开始*/
			 
			 if($.trim(sflx)==1&&$.trim(khlx)!=0){
				 if($.trim(khlx)!=1){
					 alert("客户类型请选 自主进店");
					 $("#khlx").focus();
					 return false;
				}
			}
			 if($.trim(sflx)==2&&$.trim(khlx)!=0){
				 if($.trim(khlx)!=1){
					 alert("客户类型请选 自主进店");
					 $("#khlx").focus();
					 return false;
				}
			}
			 if($.trim(sflx)==3&&$.trim(khlx)!=0){
				 if($.trim(khlx)!=2&&$.trim(khlx)!=3){
					 alert("客户类型请选 快速理赔 或 自报保险");
					 $("#khlx").focus();
					 return false;
				}
			} 
			 if($.trim(sflx)==4&&$.trim(khlx)!=0){
				 if($.trim(khlx)!=4){
					 alert("客户类型请选 协议单位");
					 $("#khlx").focus();
					 return false;
				}
			}
			 if($.trim(sflx)==5&&$.trim(khlx)!=0){
				 if($.trim(khlx)!=5){
					 alert("客户类型请选 返工免单");
					 $("#khlx").focus();
					 return false;
				}
			}
			 if($.trim(sflx)==6&&$.trim(khlx)!=0){
				 if($.trim(khlx)!=6){
					 alert("客户类型请选 i保养客户");
					 $("#khlx").focus();
					 return false;
				}
			}
			 /*逻辑--收费类型&客户类型--结束*/
			 
			 

			 
			 if($.trim(wxlx)==0){
				 alert("请选择维修类型");
				 $("#wxlx").focus();
				 return false;
			}
			 /*逻辑--维修类型&机修或钣喷--开始*/
			 if($.trim(wxlx)==1){
				 if($.trim(jxzxr)==0){
					 alert("请选择机修主修人");
					 $("#jxzxr").focus();
					 return false;
				 }
				if($.trim(jxzjr)==0){
					alert("请选择机修终检人");
					 $("#jxzjr").focus();
					 return false;
				 }
			}

			 if($.trim(wxlx)==2){
				 if($.trim(bpzxr)==0){
					 alert("请选择钣喷主修人");
					 $("#bpzxr").focus();
					 return false;
				 }
				if($.trim(bpzjr)==0){
					alert("请选择钣喷终检人");
					 $("#bpzjr").focus();
					 return false;
				 }
			}
			 if($.trim(wxlx)==3){
				 if($.trim(jxzxr)==0){
					 alert("请选择机修主修人");
					 $("#jxzxr").focus();
					 return false;
				 }
				if($.trim(jxzjr)==0){
					alert("请选择机修终检人");
					 $("#jxzjr").focus();
					 return false;
				 }
				 if($.trim(bpzxr)==0){
					 alert("请选择钣喷主修人");
					 $("#bpzxr").focus();
					 return false;
				 }
				if($.trim(bpzjr)==0){
					alert("请选择钣喷终检人");
					 $("#bpzjr").focus();
					 return false;
				 }
			}
			 /*逻辑--维修类型&机修或钣喷--结束*/
			        
			 
			 
			 if($.trim(wxzt)==0){
				 alert("请选择维修状态");
				 $("#wxzt").focus();
				 return false;
			}
			 
			 
			 
			 if($.trim(yjwgrq)==""){
				 alert("请选择预计完工日期");
				 $("#yjwgrq").focus();
				 return false;
			}
			 
			  
			 if($.trim(tbgs)==0){
				 alert("请选择车辆保险投保公司");
				 $("#tbgs").focus();
				 return false;
			}
			 
			 
			 if($.trim(bxdqrq)==""){
				 alert("请选择保险到期日期");
				 $("#bxdqrq").focus();
				 return false;
			}
			 
			 
			 /*逻辑--客户类型(协议单位)&协议单位名称--开始*/
			 if($.trim(khlx)==4&&$.trim(sflx)==4){
				 if($.trim(dwmc)==15){
					 alert("请选择协议单位名称");
					 $("#dwmc").focus();
					 return false;
				}
			}
			 /*逻辑--客户类型(协议单位)&协议单位名称--结束*/
			 
			 
			 
			 /*逻辑--客户类型(快速理赔/自报保险)&保险预计赔付金额--开始*/
			 if($.trim(khlx)==2&&$.trim(sflx)==3){
				 if($.trim(yjpf)==""){
					 alert("请输入保险预计赔付金额");
					 $("#yjpf").focus();
					 return false;
				}
			}
			 if($.trim(khlx)==3&&$.trim(sflx)==3){
				 if($.trim(yjpf)==""){
					 alert("请输入保险预计赔付金额");
					 $("#yjpf").focus();
					 return false;
				}
			}
			 /*逻辑--客户类型(快速理赔/自报保险)&保险预计赔付金额-结束*/
			 
			 
			 
			 /*逻辑--维修状态(结账离店/挂账离店)&客户类型(快速理赔/自报保险)&保险实际赔付金额--开始*/
			 if($.trim(wxzt)==4&&$.trim(khlx)==2&&$.trim(sflx)==3){
				 if($.trim(sjpf)==""){
					 alert("请输入保险实际赔付金额");
					 $("#sjpf").focus();
					 return false;
				}
			}
			 if($.trim(wxzt)==6&&$.trim(khlx)==2&&$.trim(sflx)==3){
				 if($.trim(sjpf)==""){
					 alert("请输入保险实际赔付金额");
					 $("#sjpf").focus();
					 return false;
				}
			}
			 if($.trim(wxzt)==4&&$.trim(khlx)==3&&$.trim(sflx)==3){
				 if($.trim(sjpf)==""){
					 alert("请输入保险实际赔付金额");
					 $("#sjpf").focus();
					 return false;
				}
			 }	 
			 if($.trim(wxzt)==6&&$.trim(khlx)==3&&$.trim(sflx)==3){
				 if($.trim(sjpf)==""){
						 alert("请输入保险实际赔付金额");
						 $("#sjpf").focus();
						 return false;
				}
			 }
			 /*逻辑--维修状态(结账离店/挂账离店)&客户类型(快速理赔/自报保险)&保险实际赔付金额--结束*/
			 
			 
			 
			 /*逻辑--维修状态(施工完毕)&实际完工日期--开始*/
			 if($.trim(wxzt)!=1&&$.trim(wxzt)!=2){
				 if($.trim(sjwgrq)==""){
					 alert("请选择实际完工日期");
					 $("#sjwgrq").focus();
					 return false;
				}
			}
			 /*逻辑--维修状态(施工完毕)&实际完工日期--结束*/
			 
			 
			 

			 
		
		
			 
		
			 
			if(temp.test(yunfei)==false){
				 $("#yunfei").val(0);
				 alert("请输入运费金额");
				 return false;
			}
			
		}
 
	</script>
	
 
 

</head>
<body>
	<%@include file="/page/frame/top.jsp"%>
	
	
	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>施工单管理<span class="divider">/</span>提交到正式施工单</li></ul>
			<div class="title_right">
				<strong>提交到正式施工单</strong>
			</div>
			 
			<form name="form" method="post" action="${pageContext.request.contextPath}/shiGongDanAction!modifyShiGongDanTempTijiaoForUpdate"   onsubmit="return validateForm(this)">
				<s:token name="s_token"></s:token>
				<div style="width: 95%; margin: auto">
					<table class="table table-bordered">
					
					<tr>
						<td width="10%" align="right" bgcolor="#f1f1f1">工单登记日期：</td>
							<td>
								<input type="text" name="shiGongDan.gddjrq" class="span1-1" value="${shiGongDan.gddjrq}"  readonly="readonly"/>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">施工单号：</td>
							<td colspan="5">
								<input type="text" name="shiGongDan.danhao"  id="danhao"  class="span3" value="${shiGongDan.danhao}"  readonly="readonly"/>
								<input type="hidden" name="shiGongDan.gdid"   value="${shiGongDan.gdid}" />	
							</td>
					</tr>
					
					
						<tr>
						 
							<td width="10%" align="right" bgcolor="#f1f1f1">车牌号码：</td>
							<td>
								<input type="text" name="shiGongDan.cphm"  id="cphm"  class="span1-1" value="${shiGongDan.cphm}" />
							</td>
							
							<td width="10%" align="right" bgcolor="#f1f1f1">车辆品牌：</td>
							<td>
								<input type="text" name="shiGongDan.clpp"  id="clpp"  class="span1-1" value="${shiGongDan.clpp}" />
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">车辆型号：</td>
							<td>
								<input type="text" name="shiGongDan.clxh" id="clxh"  class="span1-1" value="${shiGongDan.clxh}" />
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">车架号：</td>
							<td>
								<input type="text" name="shiGongDan.cjh"  id="cjh"  class="span2" value="${shiGongDan.cjh}" />
							</td>
						</tr>
						
						<tr>
							
							<td width="10%" align="right" bgcolor="#f1f1f1">发动机号：</td>
							<td>
								<input type="text" name="shiGongDan.fdjh"  id="fdjh" class="span1-1" value="${shiGongDan.fdjh}" />
							</td>
							
							<td width="10%" align="right" bgcolor="#f1f1f1">发动机排量：</td> 
							<td >
								<input type="text" name="shiGongDan.fdjpx" id="fdjpx"  class="span1-1" value="${shiGongDan.fdjpx}" />
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">车辆里程：</td>
							<td>
								<input type="text" name="shiGongDan.cllc"  id="cllc"  class="span1-1" value="${shiGongDan.cllc}" />
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">生产日期：</td> 
							<td>
								<input type="text"  name="shiGongDan.scrq"  id="scrq"   value="${shiGongDan.scrq}"  class="laydate-icon span1-1" readonly="readonly"/>
							</td>
						</tr>
						
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">客户类型：</td>
							<td>
								<select name="shiGongDan.khlx"  id="khlx"  class="span1-1" >
							 		<option value="0">--请选择--</option>
							 		<option value="1" ${shiGongDan.khlx==1?"selected":"" }>自主进店</option>
							 		<option value="2" ${shiGongDan.khlx==2?"selected":"" }>快速理赔</option>
							 		<option value="3" ${shiGongDan.khlx==3?"selected":"" }>自报保险</option>
							 		<option value="4" ${shiGongDan.khlx==4?"selected":"" }>协议单位</option>
							 		<option value="5" ${shiGongDan.khlx==5?"selected":"" }>返工免单</option>
							 		<option value="6" ${shiGongDan.khlx==6?"selected":"" }>i保养客户</option>
								</select>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">客户名称：</td>
							<td>
								<input type="text" name="shiGongDan.khmc"  id="khmc"  class="span1-1" value="${shiGongDan.khmc}" />
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">客户电话：</td>
							<td >
								<input type="text" name="shiGongDan.khdh"  id="khdh"  class="span1-1" value="${shiGongDan.khdh}" />
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">维修顾问：</td>
							<td >
									<select name="shiGongDan.wxgw"  id="wxgw"  class="span1-1">
							 		
							 		<option value="${sessionRygl.ryid}">${sessionRygl.name}</option>
							 	 
								</select>
							</td>
						</tr>
						
						<tr>
							
							<td width="10%" align="right" bgcolor="#f1f1f1">收费类型：</td>
							<td >
								<select name="shiGongDan.sflx" id="sflx"  class="span1-1">
							 		<option value="0">--请选择--</option>
							 		<option value="1" ${shiGongDan.sflx==1?"selected":"" }>付现/刷卡</option>
							 		<option value="2" ${shiGongDan.sflx==2?"selected":"" }>会员消费</option>
							 		<option value="3" ${shiGongDan.sflx==3?"selected":"" }>保险赔付</option>
							 		<option value="4" ${shiGongDan.sflx==4?"selected":"" }>单位挂账</option>
							 		<option value="5" ${shiGongDan.sflx==5?"selected":"" }>免收费用</option>
							 		<option value="6" ${shiGongDan.sflx==6?"selected":"" }>i保养客户</option>
								</select>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">维修类型：</td>
							<td>
								<select name="shiGongDan.wxlx"  id="wxlx"  class="span1-1">
							 		<option value="0">--请选择--</option>
							 		<option value="1" ${shiGongDan.wxlx==1?"selected":"" }>保养维修</option>
							 		<option value="2" ${shiGongDan.wxlx==2?"selected":"" }>钣金喷漆</option>
							 		<option value="3" ${shiGongDan.wxlx==3?"selected":"" }>机电钣喷</option>
							 		<option value="4" ${shiGongDan.wxlx==4?"selected":"" }>洗车美容</option>
							 		<option value="5" ${shiGongDan.wxlx==5?"selected":"" }>商品零售</option>
								</select>
							</td>
							 <td width="10%" align="right" bgcolor="#f1f1f1">维修状态：</td>
							<td>
								<select name="shiGongDan.wxzt"  id="wxzt"  class="span1-1">
							 		<option value="1" selected="selected">报价/备料</option>
								</select>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">协议单位名称：</td>
							<td>
								<select name="shiGongDan.dwmc"  id="dwmc"  class="span1-1">
							 		<option value="15">--请选择--</option>
							 		<option value="1" ${shiGongDan.dwmc==1?"selected":"" }>老村长酒业</option>
							 		<option value="2" ${shiGongDan.dwmc==2?"selected":"" }>四十七军部队</option>
							 		<option value="3" ${shiGongDan.dwmc==3?"selected":"" }>火箭军工程大学</option>
							 		<option value="4" ${shiGongDan.dwmc==4?"selected":"" }>洪庆城管</option>
							 		<option value="5" ${shiGongDan.dwmc==5?"selected":"" }>新市社区</option>
							 		<option value="6" ${shiGongDan.dwmc==6?"selected":"" }>向阳公司</option>
							 		<option value="7" ${shiGongDan.dwmc==7?"selected":"" }>志风工贸</option>
							 		<option value="8" ${shiGongDan.dwmc==8?"selected":"" }>天风建筑</option>
							 		<option value="9" ${shiGongDan.dwmc==9?"selected":"" }>诚惠金属</option>
							 		<option value="10" ${shiGongDan.dwmc==10?"selected":"" }>福宝铸造</option>
							 		<option value="11" ${shiGongDan.dwmc==11?"selected":"" }>中谷中实</option>
							 		<option value="12" ${shiGongDan.dwmc==12?"selected":"" }>瑞莱科技</option>
							 		<option value="13" ${shiGongDan.dwmc==13?"selected":"" }>个人协议车辆</option>
							 		<option value="14" ${shiGongDan.dwmc==14?"selected":"" }>秦农银行</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">机修主修人：</td>
							<td>
								<select name="shiGongDan.jxzxr" id="jxzxr"  class="span1-1">
							 		<option value="0">--请选择--</option>
							 		<option value="7" ${shiGongDan.jxzxr==7?"selected":"" }>康金榜</option>
							 		<option value="14" ${shiGongDan.jxzxr==14?"selected":"" }>张伟</option>
							 		<option value="16" ${shiGongDan.jxzxr==16?"selected":"" }>董俊康</option>
							 		<option value="17" ${shiGongDan.jxzxr==17?"selected":"" }>刘锐</option>
							 		<option value="18" ${shiGongDan.jxzxr==18?"selected":"" }>李晓斌</option>
							 		<option value="19" ${shiGongDan.jxzxr==19?"selected":"" }>闫龙飞</option>
								</select>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">机修终检人：</td>
							<td >
								<select name="shiGongDan.jxzjr"  id="jxzjr"  class="span1-1">
							 		<option value="0">--请选择--</option>
							 		<option value="7" ${shiGongDan.jxzjr==7?"selected":"" }>康金榜</option>
							 		<option value="14" ${shiGongDan.jxzjr==14?"selected":"" }>张伟</option>
								</select>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">钣喷主修人：</td>
							<td>
								<select name="shiGongDan.bpzxr"  id="bpzxr"  class="span1-1">
							 		<option value="0">--请选择--</option>
							 		<option value="9" ${shiGongDan.bpzxr==9?"selected":"" }>王兴</option>
							 		<option value="10" ${shiGongDan.bpzxr==10?"selected":"" }>马建兵</option>
							 		<option value="8" ${shiGongDan.bpzxr==8?"selected":"" }>薛旭光</option>
								</select>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">钣喷终检人：</td>
							<td>
								<select name="shiGongDan.bpzjr"  id="bpzjr"  class="span1-1">
							 		<option value="0">--请选择--</option>
							 		<option value="9" ${shiGongDan.bpzjr==9?"selected":"" }>王兴</option>
							 		<option value="10" ${shiGongDan.bpzjr==10?"selected":"" }>马建兵</option>
							 		<option value="8" ${shiGongDan.bpzxr==8?"selected":"" }>薛旭光</option>
								</select>
							</td>
						</tr>	 
						
						<tr>
						 
							<td width="10%" align="right" bgcolor="#f1f1f1">预计完工日期：</td>
							<td >
								<input type="text"  name="shiGongDan.yjwgrq"  id="yjwgrq"  value="${shiGongDan.yjwgrq}"  class="laydate-icon span1-1"  readonly="readonly"/>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">投保公司：</td>
							<td >
								<select name="shiGongDan.tbgs"  id="tbgs"  class="span1-1">
							 		<option value="0">--请选择--</option>
							 			<option value="1" ${shiGongDan.tbgs==1?"selected":"" }>人保保险</option>
										<option value="2" ${shiGongDan.tbgs==2?"selected":"" }>平安保险</option>
										<option value="3" ${shiGongDan.tbgs==3?"selected":"" }>永安保险</option>
										<option value="4" ${shiGongDan.tbgs==4?"selected":"" }>阳光保险</option>
										<option value="5" ${shiGongDan.tbgs==5?"selected":"" }>太平洋保险</option>
										<option value="6" ${shiGongDan.tbgs==6?"selected":"" }>大地保险</option>
										<option value="7" ${shiGongDan.tbgs==7?"selected":"" }>中华联合保险</option>
										<option value="8" ${shiGongDan.tbgs==8?"selected":"" }>国寿财保险</option>
										<option value="9" ${shiGongDan.tbgs==9?"selected":"" }>天安保险</option>
										<option value="10" ${shiGongDan.tbgs==10?"selected":"" }>安邦保险</option>
										<option value="11" ${shiGongDan.tbgs==11?"selected":"" }>太平保险</option>
										<option value="12" ${shiGongDan.tbgs==12?"selected":"" }>华泰保险</option>
										<option value="13" ${shiGongDan.tbgs==13?"selected":"" }>出口信用保险</option>
								</select>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">保险到期日期：</td>
							<td >
								<input type="text"  name="shiGongDan.bxdqrq"  id="bxdqrq"  value="${shiGongDan.bxdqrq}"  class="laydate-icon span1-1"  readonly="readonly"/>
							</td>
							<td width="10%"   align="right" bgcolor="#f1f1f1">保险预计赔付金额：</td>
							<td><input type="text" name="shiGongDan.yjpf"  id="yjpf"  class="span1-1" value="${shiGongDan.yjpf}" /></td>
						</tr>
						
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">备注：</td>
							<td colspan="8"><textarea name="shiGongDan.remark"  rows="3" cols="50" class="span11">${shiGongDan.remark}</textarea></td>
						</tr>
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
				elem : '#scrq',
				format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#yjwgrq',
				format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#sjwgrq',
				format : 'YYYY-MM-DD'
			});
		}();
	</script>
</body>
</html>