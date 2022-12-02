<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hndysf.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人中心---我的订单</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/css/myOrder.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/css/myAccount.css">
</head>
<body>
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
<!-- 				<div class="login_info fl"> -->
<%-- 					欢迎您：<em>${user.user_name }</em> --%>
<!-- 				</div> -->
<!-- 				<div class="login_btn fl"> -->
<!-- 					<a href="login.html">登录</a> -->
<!-- 					<span>|</span> -->
<!-- 					<a href="register.html">注册</a> -->
<!-- 				</div> -->
<!-- 				<div class="user_link fl"> -->
<!-- 					<span>|</span> -->
<!-- 					<a href="user_center_info.html">用户中心</a> -->
<!-- 				</div> -->
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
				<li><a href="${pageContext.request.contextPath}/client/myInfo/myAccount.jsp">· 个人信息</a></li>
				<li><a href="${pageContext.request.contextPath}/FindUserOrder?user_id=${user.user_id}" class="active">· 全部订单</a></li>
				<li><a href="${pageContext.request.contextPath}/LayoutServlet">· 退出登录</a></li>
			</ul>
		</div>
		<div class="right_content clearfix">
				<h3 class="common_title2">全部订单</h3>
				<table class="order_list_table w980">
					<tbody>
						
						<tr>
							<td bgcolor="#A3E6DF" class="tableopentd01" style="font-size: 20px;">订单编号</td>
							<td bgcolor="#A3E6DF" class="tableopentd01" style="font-size: 20px;">影片名</td>
							<td bgcolor="#A3E6DF" class="tableopentd01" style="font-size: 20px;">影片时间</td>
							<td bgcolor="#A3E6DF" class="tableopentd01" style="font-size: 20px;">观看影院</td> 
							<td bgcolor="#A3E6DF" class="tableopentd01" style="font-size: 20px;">影票总价</td> 
							<td bgcolor="#A3E6DF" class="tableopentd01" style="font-size: 20px;">取票码</td>
							<td bgcolor="#A3E6DF" class="tableopentd01" style="font-size: 20px;">状态</td>
							<td bgcolor="#A3E6DF" class="tableopentd01" style="font-size: 20px;">操作</td>
						</tr>
						<c:forEach items="${list_user_order }" var="u_order">
						<tr>
							<td width="25%" height="30px">${u_order[0] }</td>
							<td>${u_order[1] }</td>
							<td>${u_order[2] }&nbsp;&nbsp;&nbsp;${u_order[3] }-${u_order[4] }</td>
							<td>${u_order[5] }</td>
							<td>${u_order[8] }</td>
							<td>${u_order[6] }</td>
<%-- 							<td>${u_order[7]==0?"未支付":"已支付"} --%>
							<td>
							<c:choose>
								<c:when test="${u_order[7]==0 }">
									未支付
								</c:when>
								<c:when test="${u_order[7]==1 }">
									已支付
								</c:when>
								<c:otherwise>
									已退票
								</c:otherwise>
							</c:choose>
							</td>
							<td>
<%-- 								<input type="button" value="查看座位" onclick="${pageContext.request.contextPath}/CheckSeatServlet?order_id=${u_order[0]}">&nbsp;&nbsp; --%>
								<a href="${pageContext.request.contextPath}/CheckSeatServlet?order_id=${u_order[0]}">查看座位</a>&nbsp;&nbsp;
												<c:if test="${order.status==0 }">
													<a href="${pageContext.request.contextPath}/DeleteOrderServlet?order_id=${u_order[0]}"  onclick="javascript:return o_del()">退票</a>
												</c:if> 
												<c:if test="${order.status!=0 }">
													<a href="${pageContext.request.contextPath}/DeleteOrderServlet?order_id=${u_order[0]}" onclick="javascript:return o_del()">退票</a>
												</c:if>
							</td>
						</tr>
						</c:forEach>
						
					</tbody>
				</table>
				
				
		</div>
	</div>
</body>

 <script>  
<!--  //取出传回来的参数error并与yes比较 -->
<%--   var info ='<%=request.getParameter("info")%>'; --%>
<!--   alert(info); -->


<!-- <script>  -->

<!--  //取出传回来的参数error并与yes比较 -->
  var errori ='<%=request.getParameter("error")%>';
   if(errori=="yes"){
    alert("退票成功！");
    window.location.href="${pageContext.request.contextPath}/FindUserOrder?user_id=${user.user_id}";
  }
</script>

</html>