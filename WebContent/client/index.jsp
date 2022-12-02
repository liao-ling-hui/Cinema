<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/client/css/style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/phone.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/TouchSlide.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/movie.js"></script>
</head>
<body>
	
	<div>
		<%@ include file="public/head.jsp" %>
	</div>

	<div class="whole">
		<!--头部轮播-->
		<div id="carousel" class="carousel">
			<div class="hd">
				<ul></ul>
			</div>
			<div class="bd">
				<ul>
					<li><a href="details.html"><img _src="${pageContext.request.contextPath}/client/image/zyx_pic1.jpg"
							src="${pageContext.request.contextPath}/client/image/blank.png" /></a></li>
					<li><a href="details.html"><img _src="${pageContext.request.contextPath}/client/image/future_pic1.jpg"
							src="${pageContext.request.contextPath}/client/image/blank.png" /></a></li>
				</ul>
			</div>
			<div class="search sear-show">
				<img src="${pageContext.request.contextPath}/client/image/search.png" />
			</div>
			<div class="search-new">
				<input type="text" value="" placeholder="请输入您要搜索的内容" />
				<div class="sear">
					<img src="${pageContext.request.contextPath}/client/image/search.png" />
				</div>
				<div class="close">
					<i class="fa fa-forward"></i>
				</div>
			</div>
		</div>
		<!--头部轮播END-->

		<div class="movie">
			<ul>
			
			<c:forEach items="${list_movie}" var="m">
				<li><a href="${pageContext.request.contextPath}/MovieDetailServlet?id=${m[0]}"> <span class="tag">${m[4]}</span>
					<div class="posters"> 
							<img src="${pageContext.request.contextPath}${m[12]}" />
 						</div> 
 						<div class="post-content"> 
							<div class="left-con"> 
								<p class="tit"> 
									<small>${m[1] }</small> <span> <i>${m[5] }</i> <i>IMAX</i> 
 									</span> 
								</p> 
 								<p class="eng">Operation Mekong</p> 
								<p class="act">${m[6] }</p> 
 								<p class="tim"> 
									上映时间<span>${m[7]}</span>
								</p>
 							</div> 
							<div class="right-btn"> 
								<div class="ticket-btn">购票</div> 
							</div> 
						</div> 
				</a></li> 
			</c:forEach>
			
			</ul>
		</div>

	</div>
	<script type="text/javascript">
		TouchSlide({
			slideCell : "#carousel",
			titCell : ".hd ul", //开启自动分页 autoPage:true ，此时设置 titCell 为导航元素包裹层
			mainCell : ".bd ul",
			effect : "left",
			autoPlay : true,//自动播放
			autoPage : true, //自动分页
			switchLoad : "_src" //切换加载，真实图片路径为"_src" 
		});
		
		console.log("1111");
	</script>
</body>
</html>

