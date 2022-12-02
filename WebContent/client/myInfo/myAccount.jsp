<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hndysf.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人中心---基本信息</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/css/myOrder.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/css/myAccount.css">
	<script type="text/javascript"  src="${pageContext.request.contextPath}/client/js/jquery-1.7.2.min.js"></script>
	
</head>
<body>
<div class="header_con">
		<div class="header">
			<div class="welcome fl">电影院票务管理</div>
			<div class="fr">
			
				<%
				User user = (User) request.getSession().getAttribute("user");
				if (user == null) {
				%>
				<div class="login_btn fl">
					<a href="${pageContext.request.contextPath}/client/login.jsp">登录</a> 
 					<span>|</span>
 					<a href="${pageContext.request.contextPath}/client/register.jsp">注册</a> 
				</div>
				<% }else{ %>
				
					<div class="user_link fl"> 
					<span>|</span> 
					<a href="user_center_info.html">欢迎您：<em>${user.user_name }</em></a> 
 				</div> 
 				
 				<%} %>
			</div>
		</div>		
	</div>

	<div class="search_bar clearfix">
		<a href="index.html" class="logo fl"><img src="${pageContext.request.contextPath}/client/image/title.jpg" width="70px" style="margin-left: 50px;"></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;用户中心</div>
	</div>

	<div class="main_con clearfix">
		<div class="left_menu_con clearfix">
			<h3>用户中心</h3>
			<ul>
				<li><a href="${pageContext.request.contextPath}/client/myInfo/myAccount.jsp" class="active">· 个人信息</a></li>
				<li><a href="${pageContext.request.contextPath}/FindUserOrder?user_id=${user.user_id}">· 全部订单</a></li>
				<li><a href="${pageContext.request.contextPath}/LayoutServlet">· 退出登录</a></li>
			</ul>
		</div>
		
		<form action="${pageContext.request.contextPath}/UpdatePwdOrSexServlet?user_id=${user.user_id}" method="post">
				
		<div class="right_content clearfix">
				<div class="info_con clearfix">
				<h3 class="common_title2">基本信息</h3>
						<ul class="user_info_list">
							<li><span>用户名：</span>${user.user_name }</li>
							<li><span>原密码：</span>${user.user_password }</li>
							<li><span>修改密码：</span><input type="text" value="" name="pwd" /></li>
							<li><span>默认性别：</span><select style="width:160px"  value="${user.user_sex }" name="sex">
															<option>男</option>
															<option>女</option>
														</select></li>
							<li><span>联系方式：</span>${user.user_phone }</li>		
						</ul>
						
						<input type="submit" value="提交" style="margin-left: 46px;width: 100px;" onclick="updateSex()"/>
				</div>
		</form>
	
				
				<h3 class="common_title2">最近浏览</h3>
				<div class="has_view_list">
					<ul class="goods_type_list clearfix">
				<li>
					<a href="detail.html"><img src="${pageContext.request.contextPath}/client/image/pushui.jpg"></a>
					<h4><a href="detail.html">五个扑水的少年</a></h4>
					
				</li>

				<li>
					<a href="#"><img src="${pageContext.request.contextPath}/client/image/doctor.jpg"></a>
					<h4><a href="#">中国医生</a></h4>
					
				</li>

				<li>
					<a href="#"><img src="${pageContext.request.contextPath}/client/image/zyx1.jpg"></a>
					<h4><a href="#">一出好戏</a></h4>
				
				</li>

				<li>
					<a href="#"><img src="${pageContext.request.contextPath}/client/image/future.jpg"></a>
					<h4><a href="#">盛夏未来</a></h4>
					
				</li>

			</ul>
		</div>
		</div>
	</div>




</body>
</html>