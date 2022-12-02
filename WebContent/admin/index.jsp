<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台首页</title>
<link href="${pageContext.request.contextPath}/client/css/style.css" type="text/css" rel="stylesheet" />


<meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/x-admin.css" media="all">
</head>
<body>
 <div class="layui-layout layui-layout-admin">
            <div class="layui-header header header-demo">
                <div class="layui-main">

                    </a>
                    <ul class="layui-nav" lay-filter="">
                      <li class="layui-nav-item"><img src="${pageContext.request.contextPath}/admin/images/0.jpg" class="layui-circle" style="border: 2px solid #A9B7B7;" width="35px" alt=""></li>
                      <li class="layui-nav-item">
                        <a href="javascript:;">
                       
                        ${admin.name }
                        </a>
                        <dl class="layui-nav-child"> <!-- 二级菜单 -->
                          <dd><a href="#">个人信息</a></dd>
                          <dd><a href="#">切换帐号</a></dd>
                          <dd><a href="${pageContext.request.contextPath}/LayoutAdminServlet">退出</a></dd>
                        </dl>
                      </li>
                      <li class="layui-nav-item x-index"><a href="${pageContext.request.contextPath}/index.jsp">前台首页</a></li>
                    </ul>
                </div>
            </div>
            <div class="layui-side layui-bg-black x-side">
                <div class="layui-side-scroll">
                    <ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">
                    	 <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="">
                               <i class="laydate-icon">首页</i>
                            </a>
                        </li>
                    <!--数据管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="${pageContext.request.contextPath}/AllMovieInfoServlet">
                               <i class="layui-icon" style="top: 3px;">&#xe62d;</i><cite>影片管理</cite>
                            </a>
                        </li>
                        <!--用户管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="${pageContext.request.contextPath}/AllUserInfoServlet">
                                <i class="layui-icon" style="top: 3px;">&#xe613;</i><cite>用户管理</cite>
                            </a>
                        </li>
                        <!--影片管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="${pageContext.request.contextPath}/AllOrderInfoServlet">
                                <i class="layui-icon" style="top: 3px;">&#xe612;</i><cite>订单管理</cite>
                            </a>
                        </li>
                        <!--排片管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="${pageContext.request.contextPath}/AllScheduleInfoServlet">
                                <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>排片管理</cite>
                            </a>
                        </li>
                    </ul>
                </div>

            </div>
            <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true">
                <div class="x-slide_left"></div>
                <ul class="layui-tab-title">
                    <li class="layui-this">
                        首页
                        <i class="layui-icon layui-unselect layui-tab-close">ဆ</i>
                    </li>
                </ul>
                <div class="layui-tab-content site-demo site-demo-body">
                    <div class="layui-tab-item layui-show">
                        <iframe frameborder="0" src="" class="x-iframe"></iframe>
                    </div>
                </div>
            </div>
            <div class="site-mobile-shade">
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
        <script src="${pageContext.request.contextPath}/admin/js/x-admin.js"></script>
        <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
</body>
</html>