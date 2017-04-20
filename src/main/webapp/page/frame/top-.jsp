	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
	
	<div class="header">
		<div class="logo"> <img src="${pageContext.request.contextPath}/resource/images/logo.png" /> </div>
		<div class="header-right">
			<i class="icon-question-sign icon-white"></i> <a href="#">帮助</a> 
			<i class="icon-off icon-white"></i> <a id="modal-973558" href="#modal-container-973558" role="button" data-toggle="modal">注销</a>
			  <a href="#">发送短信</a>
			<div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 300px; margin-left: -150px; top: 30%">
			<div class="modal-header"> <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> <h3 id="myModalLabel">注销系统</h3> </div>
			<div class="modal-body"> <p>您确定要注销退出系统吗？</p> </div>
			<div class="modal-footer"> <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> <a class="btn btn-primary" style="line-height: 20px;" href="登录.html">确定退出</a></div>
			</div>
		</div>
	</div>
	<!-- 顶部 -->

<div id="middle">
<div class="left">
			<script type="text/javascript">
				var myMenu;
				window.onload = function() {
					myMenu = new SDMenu("my_menu");
					myMenu.init();
				};
			</script>

			<div id="my_menu" class="sdmenu">
			
				<div >
					<span>施工单管理</span>
					<a href="${pageContext.request.contextPath}/shiGongDanAction!showShiGongDanForModifyAsSave">创建施工单</a> 
					<a href="${pageContext.request.contextPath}/shiGongDanAction!showShiGongDanList">查询施工单</a>
					<a href="${pageContext.request.contextPath}/shiGongDanAction!showShiGongDanTempForModify">创建临时施工单</a> 
					<a href="${pageContext.request.contextPath}/shiGongDanAction!showShiGongDanTempList">查询临时施工单</a>
					<a href="${pageContext.request.contextPath}/shiGongDanAction!showShiGongDanJiesuanList">查询结账施工单</a>
					<a href="${pageContext.request.contextPath}/shiGongDanAction!showBeiliaoShiGongDanList">查询待备料工单</a>
				</div>
				
				<div class="collapsed">
					<span>报价管理</span>
					<a href="${pageContext.request.contextPath}/baoJiaAction!showBaoliaoSGDList">报料工单</a> 
					<a href="${pageContext.request.contextPath}/baoJiaAction!showBaoJiaSGDList">报价工单</a> 
					<a href="${pageContext.request.contextPath}/baoJiaAction!showBeiLiaoSGDList">备料工单</a>
					<a href="${pageContext.request.contextPath}/baoJiaAction!showLingLiaoSGDList">领料出库</a>
					<a href="${pageContext.request.contextPath}/baoJiaAction!showBuLiaoSGDList">工单补料</a>
				</div>
				
				<div class="collapsed">
					<span>人员管理</span> 
					<a href="${pageContext.request.contextPath}/ryglAction!showRyglList">人员信息</a>
				</div>
	 
				<div class="collapsed">
					<span>资产设备管理</span> 
					<a href="${pageContext.request.contextPath}/">资产设备信息</a> 
				</div>
				
				<div class="collapsed">
					<span>库存管理</span>
					<a href="${pageContext.request.contextPath}/kuCunAction!showKuCunTYList">通用配件库存</a> 
					<a href="${pageContext.request.contextPath}/kuCunAction!showKuCunYFList">油漆辅料库存</a>
					<a href="${pageContext.request.contextPath}/kuCunAction!showKuCunZYList">专用配件库存</a>
					<a href="${pageContext.request.contextPath}/kuCunAction!showYfckList">油漆辅料出库</a>
				</div>
				
				<div class="collapsed">
					<span>会员卡管理</span>
					<a href="${pageContext.request.contextPath}/">会员卡信息</a> 
				</div>
				
				<div class="collapsed">
					<span>协议单位管理</span>
					<a href="${pageContext.request.contextPath}/">协议单位信息</a> 
				</div>
				
				<div class="collapsed">
					<span>供货商管理</span>
					<a href="${pageContext.request.contextPath}/ghsglAction!showGhsglList">供货商信息</a> 
				</div>
				
				<div class="collapsed">
					<span>财务台账管理</span>
					<a href="${pageContext.request.contextPath}/">财务台账信息</a> 
				</div>
				
			    <div class="collapsed">
					<span>车辆台账管理</span>
					<a href="${pageContext.request.contextPath}/">车辆台账信息</a> 
				</div>
							
			    <div class="collapsed">
					<span>快赔台账管理</span>
					<a href="${pageContext.request.contextPath}/">快赔台账信息</a> 
				</div>
				
				<div class="collapsed">
					<span>产值台账管理</span>
					<a href="${pageContext.request.contextPath}/">产值台账信息</a> 
				</div>
		
				<div class="collapsed">
					<span>系统管理</span> 
					<a href="${pageContext.request.contextPath}/userAction!showSysUserList">系统用户管理</a>
					<a href="${pageContext.request.contextPath}/roleAction!showSysRoleList">系统角色管理</a>
				</div>
			</div>

		</div>
		
		
		<div class="Switch"></div>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".Switch").click(function() {
					$(".left").toggle();
				});
			});
		</script>

		