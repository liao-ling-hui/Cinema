<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0;" />
<title>注册</title>
<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/client/js/layer-v3.0.3/layer/mobile/need/layer.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/client/css/login.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/client/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/client/js/phone.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/client/js/layer-v3.0.3/layer/mobile/layer.js"></script>

</head>
<body>
	<header class="header">
		<a href="javascript:history.back(-1)" class="fa fa-angle-left"></a> <span
			class="names">注册</span>
	</header>
	<form action="${pageContext.request.contextPath}/RegisterServlet" type="post">
		<div class="login_contnet">
			<div class="commons user">
				<i class="fa fa-user"></i> <input type="text" value="" name="name"
					class="name" placeholder="请输入您的账号" />
			</div>
			<div class="commons user">
				<i class="fa fa-home"></i> <input type="text" value="13716446688"
					name="tel" class="tel" placeholder="请输入您的手机号" />
			</div>
			<div class="commons pasd">
				<i class="fa fa-unlock-alt"></i> <input type="password" value=""
					name="password" class="pasd" placeholder="请输入6~16位密码" />
			</div>
			 <button class="login" onclick="submit()">注册</button>
			<a href="login.jsp" class="common_use register">已有账号，去登录！</a>
			<a href="index.jsp" class="common_use change">首页</a>
		</div>
	</form>


	<script type="text/javascript">
		// $(function(){

		// 	function phone(){
		// 		var reg = /^1[34578]\d{9}$/;
		// 		var phoneVal = $('.tel').val();
		// 		if(reg.test(phoneVal)){

		// 		}else{
		// 			mesLay('手机号码有误！')
		// 			return false;
		// 		}
		// 	}

		// 	function pasd(){
		// 		var psdVal = $('.pasd').val();
		// 		if(psdVal<6){
		// 			mesLay('您的密码少于6位数！');
		// 			return false;
		// 		}else{

		// 		}
		// 	}

		// 	$('.tel').blur(function(){
		// 		phone();
		// 	});

		// 	$('.pasd').blur(function(){
		// 		pasd();
		// 	});

		// 	function mesLay(content){
		// 		layer.open({
		// 			content: content
		// 			,skin: 'msg'
		// 			,time: 3
		// 		});	
		// 	}

		// 	$('.login').on('click',function(){

		// 	});
		// })
	</script>

</body>
</html>