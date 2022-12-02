<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.hndysf.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>头部</title>
<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/client/css/header.css"
	rel="stylesheet" type="text/css" />
<script type="${pageContext.request.contextPath}/client/text/javascript"
	src="js/jquery-1.7.2.min.js"></script>
<script type="${pageContext.request.contextPath}/client/text/javascript"
	src="js/phone.js"></script>

<script type="text/javascript">
	function login() {
		window.location.href = "${pageContext.request.contextPath}/ToLoginServlet"
	}

	function reg() {
		window.location.href = "client/register.jsp"
	}
	
	function userinfo(){
		alert("您还没有登录，请先登录！");
		window.location.href="${pageContext.request.contextPath}/client/login.jsp";
	}
	
	function userinfo_success(){
		window.location.href="${pageContext.request.contextPath}/client/myInfo/myAccount.jsp";
	}
	
	
</script>
</head>
<body>
	<header class="header">
		<a href="javascript:history.back(-1)" class="fa fa-angle-left"></a> <span>在线购票</span>

		<div id="button">
			<%
				User user = (User) request.getSession().getAttribute("user");
				if (user == null) {
			%>
			<button class="btn1" onclick="login()">登录</button>
			<button class="btn1" onclick="reg()">注册</button>
			<button class="btn1" id="userinfo" onclick="userinfo()">个人中心</button>
			<%
				} else {
			%>
			<span style="font-size:15px;color:red;">欢迎您：${user.user_name }</span>
			<button class="btn1" id="userinfo" onclick="userinfo_success()">个人中心</button>
			<%
				}
			%>
				
		</div>

	</header>
</body>
</html>