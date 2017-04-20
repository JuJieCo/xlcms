<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>君益达汽车维修管理系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>


<style type="text/css">
body {
	background: #0066A8 url(${pageContext.request.contextPath}/resource/images/login_bg.png) no-repeat center 0px;
}

.tit {
	margin: auto;
	margin-top: 170px; 
	text-align: center;
	width: 350px;
	padding-bottom: 20px;
}

.login-wrap {
	width: 220px;
	padding: 30px 50px 0 330px;
	height: 220px;
	background: #fff url(${pageContext.request.contextPath}/resource/images/20150212154319.jpg) no-repeat 30px 40px;
	margin: auto;
	overflow: hidden;
}

.login_input {
	display: block;
	width: 210px;
}

.login_user {
	background: url(${pageContext.request.contextPath}/resource/images/input_icon_1.png) no-repeat 200px center;
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif
}

.login_password {
	background: url(${pageContext.request.contextPath}/resource/images/input_icon_2.png) no-repeat 200px center;
	font-family: "Courier New", Courier, monospace
}

.btn-login {
	background: #40454B;
	box-shadow: none;
	text-shadow: none;
	color: #fff;
	border: none;
	height: 35px;
	line-height: 26px;
	font-size: 14px;
	font-family: "microsoft yahei";
}

.btn-login:hover {
	background: #333;
	color: #fff;
}

.copyright {
	margin: auto;
	margin-top: 10px;
	text-align: center;
	width: 370px;
	color: #CCC
}

@media ( max-height : 700px) {
	.tit {
		margin: auto;
		margin-top: 100px;
	}
}

@media ( max-height : 500px) {
	.tit {
		margin: auto;
		margin-top: 50px;
	}
}
</style>
</head>

<body>

	<div class="tit">
		<img src="${pageContext.request.contextPath}/resource/images/tit.png" alt="" />
	</div>
	<div class="login-wrap">

		<form action="${pageContext.request.contextPath}/loginAction!login">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="25" valign="bottom">用户名：</td>
			</tr>
			<tr>
				<td><input type="text"  name="user.username"  class="login_input login_user" value="${user.username}" /></td>
			</tr>
			<tr>
				<td height="35" valign="bottom">密 码：</td>
			</tr>
			<tr>
				<td><input type="password"  name="user.password"  class="login_input login_password"  value="${user.password}" /></td>
			</tr>
			<tr>
				<td height="60" valign="bottom"><input type="submit"  name="login"  class="btn btn-block btn-login"  value="登录" /></td>
			</tr>
		</table>
		</form>
		
	</div>
	<div class="copyright">建议使用IE8以上版本或谷歌浏览器</div>
</body>
</html>