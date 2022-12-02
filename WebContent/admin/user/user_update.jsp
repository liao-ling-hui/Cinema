<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理---添加</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/x-admin.css" media="all">
</head>
<body>
 <div class="x-body">
            <form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/UpdateUserServlet">
            	
                <div class="layui-form-item">
                 

                    <div class="layui-input-block">
                        <input type="hidden" id="L_title" name="user_id" required lay-verify="title" value="${user.user_id }"
                        autocomplete="off" class="layui-input">
                    </div>
                    
                    
                    <label for="L_title" class="layui-form-label">
                        用户账号
                  </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="user_name" required lay-verify="title" value="${user.user_name }"
                        autocomplete="off" class="layui-input">
                    </div>
                    <label for="L_title" class="layui-form-label">
                        用户密码
                    </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="user_pwd" required lay-verify="title" value="${user.user_password }"
                        autocomplete="off" class="layui-input">
                    </div>
                    
                <label for="L_title" class="layui-form-label">
                        电话号码
                   </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="user_phone" required lay-verify="title"   value="${user.user_phone }"
                        autocomplete="off" class="layui-input">
                    </div>
                   
			 <label for="L_title" class="layui-form-label">
                       用户性别
                   </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="user_sex" required lay-verify="title"  value="${user.user_sex }"
                        autocomplete="off" class="layui-input">
                    </div>
                   
               </div>
              
                <div class="layui-form-item">
                    <button class="layui-btn" lay-filter="add" lay-submit>
                        修改信息
                    </button>
                </div>
            </form>
        </div>
        <script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="${pageContext.request.contextPath}/admin/js/x-layui.js" charset="utf-8">
        </script>
        <script>
            layui.use(['form','layer','layedit'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer
              ,layedit = layui.layedit;


                layedit.set({
                  uploadImage: {
                    url: "./upimg.json" //接口url
                    ,type: 'post' //默认post
                  }
                })
  
            //创建一个编辑器
            editIndex = layedit.build('L_content');
            
              


        </script>
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