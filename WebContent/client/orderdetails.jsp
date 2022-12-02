<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/order.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/order1.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/jquery-1.7.2.min.js"></script>
		
</head>
<body>
<div id="head">
			<span class="log">欢迎登录：${user.user_name }</span>
			<span class="info"><a href="${pageContext.request.contextPath}/client/myInfo/myAccount.jsp">个人中心</a></span>
			<span class="help">帮助中心</span>
		</div>

		<div id="content">
			<div class="content_head">
				<span class="log"><h3>确认订单信息</h3></span>
				<span class="info"><a href="${pageContext.request.contextPath}/index.jsp">返回首页</a></span>
			</div>

		<c:forEach items="${order_list }" var="o">
			<div class="content_centen">
				<div class="left">
					<img src="${pageContext.request.contextPath}${o[5]}" />
					<div class="span">
						<span><h3>${o[0] }</h3></span>
						<p><span>影院：${o[3] }</span></p>
						<p><span>影厅：${o[4] }</span></p>
						<p><span>票价：${o[6] }</span></p>
						<p><span>场次：${o[7] }-${o[8] }</span></p>
						<p><span>座位：${seats}</span></p>
						<p><span>总价：${o[2] }</span></p>
					</div>

					<div class="info">
						<p><span><h2>取票手机号:${o[9] }</h2></span></p>
						<p><span><h2>生成随机码：${o[10] }</h2></span></p>
						<p><span><h3>取票短信可能会被手机软件拦截，请注意！</h3></span></p>

					</div>

				</div>

				<div class="method">
					<span>更多电影</span>
					<hr>
				</div>

			</div>
			
		</c:forEach>
			
			<div class="foot">
				<!-- 可删除 -->
				<div class="Service-box">
					<div class="Service-content clearfix">
						<a href="javascript:;" class="Service-item">
							<div class="item-image">
								<img src="${pageContext.request.contextPath}/client/image/pushui_pic2.jpg" alt="">
							</div>
							<h3 class="item-title">五个扑水的少年</h3>
<!-- 							<div class="item-text">用户在商家网站上完成付款</div> -->
							<span class="item-link">我要观看</span>
						</a>
						<a href="javascript:;" class="Service-item">
							<div class="item-image">
								<img src="${pageContext.request.contextPath}/client/image/wusha_pic2.jpg" alt="">
							</div>
							<h3 class="item-title">误杀</h3>
<!-- 							<div class="item-text">用户在商家手机网站进行付款</div> -->
							<span class="item-link">我要观看</span>
						</a>
						<a href="javascript:;" class="Service-item">
							<div class="item-image">
								<img src="${pageContext.request.contextPath}/client/image/future_pic2.jpg" alt="">
							</div>
							<h3 class="item-title">盛夏未来</h3>
<!-- 							<div class="item-text">用户在商家app内进行付款</div> -->
							<span class="item-link">我要观看</span>
						</a>
						<a href="javascript:;" class="Service-item">
							<div class="item-image">
								<img src="${pageContext.request.contextPath}/client/image/doctor_pic2.jpg" alt="">
							</div>
							<h3 class="item-title">中国医生</h3>
<!-- 							<div class="item-text">只需扫描用户的付款码，或用户扫描商家的二维码完成付款</div> -->
							<span class="item-link">我要观看</span>
						</a>
<!-- 						<a href="javascript:;" class="Service-item"> -->
<!-- 							<div class="item-image"> -->
<!-- 								<img src="index/img/icon-tag005.png" alt=""> -->
<!-- 							</div> -->
<!-- 							<h3 class="item-title">收钱码</h3> -->
<!-- 							<div class="item-text">支付宝最新收钱工具，收钱、提钱均免费</div> -->
<!-- 							<div class="item-background"> -->
<%-- 								<img src="${pageContext.request.contextPath}/client/image/icon-tag-bj.png" alt=""> --%>
<!-- 							</div> -->
<!-- 							<div class="item-tag">免手续费</div> -->
<!-- 							<span class="item-link">我要观看</span> -->
<!-- 						</a> -->
					</div>
				</div>

			</div>

		</div>
</body>
<script type="text/javascript">
	console.log(MathRand());
	function MathRand() {
		var Num = "";
		for (var i = 0; i < 6; i++) {
			Num += Math.floor(Math.random() * 10);
			console.log(Num);
		}
		$("#random").html(Num);
		return Num;
	}
</script>
</html>