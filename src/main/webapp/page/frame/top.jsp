	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
	<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
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
		 
				<c:forEach items="${sessionSysUser.treeRole.resourceList}" var="root">
					<c:if test="${root.resourceUrl eq null}">
						<div class="collapsed">
							<span>${root.resourceName }</span> 
							
							<c:forEach items="${sessionSysUser.treeRole.resourceList}" var="roo">
								<c:if test="${root.resourceSign == roo.resourceSign}">
								 <c:if test="${roo.resourceUrl ne null}">
									<a href="${pageContext.request.contextPath}${roo.resourceUrl}">${roo.resourceName}</a>
								 </c:if>
								 </c:if>
							</c:forEach>
							
						</div>
					</c:if>
				</c:forEach>
					
				
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

		