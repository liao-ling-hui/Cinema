<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0;"/>
<title>登录页面</title>
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/client/js/layer-v3.0.3/layer/mobile/need/layer.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/client/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/phone.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/layer-v3.0.3/layer/mobile/layer.js"></script>
</head>
<body>
	<header class="header">
        <a href="javascript:history.back(-1)" class="fa fa-angle-left"></a>
        <span class="names">登录</span>
    </header>
    <form action="${pageContext.request.contextPath }/LoginServlet" type="post">
    	<div class="login_contnet">
    	<div class="commons user">
        	<i class="fa fa-user"></i>
            <input type="text"  name="name" class="name"  placeholder="请输入您的手机号或者账号名" />
        </div>
        <div class="commons pasd">
        	<i class="fa fa-unlock-alt"></i>
            <input type="password"   name="password" class="pasd"  placeholder="请输入6~16位密码" />
        </div>
        <button class="login" onclick="submit()">登录</button>
        <a href="register.jsp" class="common_use register">还没有用户,请注册!</a>
        <a href="javascript:void(0)" class="common_use change">忘记密码?</a>
    </div>
    
    </form>
    
<script type="text/javascript" >
$(function(){




	function mesLay(content){
		layer.open({
			content: content
			,skin: 'msg'
			,time: 3
		});	
	}

	function submit(){
		var psd = $('.pasd').val();
		var name = $('.name').val();
		if(name==""){
			alert("用户名不能为空！");
		}else if(psd==""){
			alert("密码不能为空！");
		}else{
			alert("登录成功！");
		}
	}
	
})
	
</script>
    
</body>
</html>