<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0;" />
<title>购票</title>
<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/client/css/tickets.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/client/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/client/js/phone.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/client/js/menu_x.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/dateTime.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/dateTime.css">
</head>
<body>
	<div class="whole">

		<header class="header">
			<a href="javascript:history.back(-1)" class="fa fa-angle-left"></a> <span
				class="names">${Tbean.cinema_name }</span> <span class="collect">
				<i class="fa fa-star-o"></i>
			</span>
		</header>

		<div class="film-length">
			<span>片长：${Tbean.hall_category }</span> <span class="imax">原版${Tbean.movie_duration }</span>
			<span class="imax" style="float: right;">影片:${Tbean.movie_name }</span>
		</div>

		<div class="tips">温馨提示：电影开场前30分钟关闭在线售票</div>

		 
			<div class="tab date">
			<!---tab日期标签滑动--->
			<div id="J_MenuX">
				<div class="xs-container">
					<ul class="xs-content nav nav-pills nav-justified" id="menus_xx" _xx="0">
							<li id="text"></li>
							<li id="text1"></li>
							<li id="text2"></li>
							<li id="text3"></li>
						</ul>
				</div>
			</div>
			<!---tab标签滑动END--->
		</div>

		<div class="tickets-list">
			<ul>
				<c:forEach items="${schedule }" var="s">
					<li>
						<div class="ticket-info">
							<span class="start">${s[4] }</span> 
							<span style="font-size: 20px;color: #000000;">原版${s[2] }</span>
							<span style="font-size: 20px;color: #000000;">${s[5] }(结束)</span> 
							<span style="font-size: 20px;color: #000000;">${s[1] }</span>
						</div>
						<div class="buy-btn">
							<span style="font-size: 20px;color: #000000;">${s[6] }<b>元</b></span> 
							<a	href="${pageContext.request.contextPath}/ChooseSeatServlet?schedule_id=${s[0] }&cinema_name=${Tbean.cinema_name}&hall_name=${s[1]}&movie_name=${Tbean.movie_name }">选座购票</a>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
			
		
	</div>

	<script type="text/javascript">
		var menux = new menuX("#J_MenuX", 0);
	</script>

	<script type="text/javascript">
		$(function() {

			$('.collect .fa').click(function() {
				if ($(this).hasClass('fa-star-o')) {
					$(this).removeClass('fa-star-o').addClass('fa-star');
				} else {
					$(this).removeClass('fa-star').addClass('fa-star-o');
				}
			});

		})
	</script>
	<script language="JavaScript">
			console.log(getNowTime());
			//获取当前时间
			function getNowTime() {
				var date = new Date();
				//年 getFullYear()：四位数字返回年份
				var year = date.getFullYear(); //getFullYear()代替getYear()
				//月 getMonth()：0 ~ 11
				var month = date.getMonth() + 1;
				//日 getDate()：(1 ~ 31)
				var day = date.getDate();
				var time =  addZero(month) + '-' + addZero(day);
				for (i = 1; i <= 3; i++) {
					if (i == 1) {
						var time1 = addZero(month) + '-' + addZero(day + i);
						$("#text1").html(time1);
					} else if (i == 2) {
						var time2 =  addZero(month) + '-' + addZero(day + i);
						$("#text2").html(time2);
					} else {
						var time3 = addZero(month) + '-' + addZero(day + i);
						$("#text3").html(time3);
					}
				}
				$("#text").html(time);
				return time;
			}
			//小于10的拼接上0字符串
			function addZero(s) {
				return s < 10 ? ('0' + s) : s;
			}
		</script>

	
	
</body>
</html>