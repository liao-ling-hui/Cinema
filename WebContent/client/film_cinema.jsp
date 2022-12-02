<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0;" />
<title>电影院</title>
<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/client/css/film_cinema.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/phone.js"></script>
</head>
</head>
<body>
	<div class="whole">

		<header class="header">
			<a href="javascript:history.back(-1)" class="fa fa-angle-left"></a> <span
				class="names">${name }</span>
			<!--<span class="collect">
        	<i class="fa fa-search"></i>
        </span>-->
		</header>

		<div class="film_content">
			<div class="tab">
				<ul>
					<li class="active">附近<i class="fa fa-caret-down"></i></li>
					<li>区域<i class="fa fa-caret-down"></i></li>
					<li>服务<i class="fa fa-caret-down"></i></li>
					<li>其他<i class="fa fa-caret-down"></i></li>
				</ul>
			</div>
			<div class="address">
				<ul>
				<c:forEach items="${list_cinema }"  var="c">
					<li><a href="${pageContext.request.contextPath}/ScheduleServlet?c_id=${c[8]}&m_id=${c[7]}">
							<div class="film_addr">
								<span>${c[1] }</span>
								<p>
									${c[3] }<span>元起</span>
								</p>
								<span class="resort">营业时间：${c[6] }</span>
							</div>
							<div class="det_addr">
								<span>${c[2] }</span>
								<p>${c[4] }</p>
							</div>
							<div class="session">${c[5] }</div>
					</a></li>
					
				</c:forEach>

				</ul>
			</div>
		</div>


	</div>
</body>
</html>