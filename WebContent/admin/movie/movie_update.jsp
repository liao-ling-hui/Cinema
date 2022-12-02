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
            <form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/UpdateMovieServlet">
            
            	<c:forEach items="${Movie }" var="Movie">
            	 <div class="layui-form-item">
                 
                        <input type="hidden" id="L_title" name="movie_id"  value="${Movie.movie_id }"/>
                   
                    
                    
                    <label for="L_title" class="layui-form-label">
                        影片名
                  </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="movie_name" required lay-verify="title" value="${Movie.movie_name }"
                        autocomplete="off" class="layui-input" disabled="disabled">
                    </div>
                    <label for="L_title" class="layui-form-label">
                        导演
                    </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="movie_director" required lay-verify="title" value="${Movie.movie_director }"
                        autocomplete="off" class="layui-input" disabled="disabled">
                    </div>
                    
                <label for="L_title" class="layui-form-label">
                        演员
                   </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="movie_actor" required lay-verify="title"   value="${Movie.movie_actor }"
                        autocomplete="off" class="layui-input" disabled="disabled">
                    </div>
                    
                  <label for="L_title" class="layui-form-label">
                        影片评分
                   </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="movie_sorce" required lay-verify="title"   value="${Movie.movie_sorce }"
                        autocomplete="off" class="layui-input" disabled="disabled">
                    </div>
                    
                    
                    
                     <label for="L_title" class="layui-form-label">
                        放映厅
                   </label>
                    <div class="layui-input-block">
                    
                     <input type="text" id="L_title" name="hall_id" required lay-verify="title"   value="${Movie.hall.hall_name }---${Movie.hall.hall_category}"
                        autocomplete="off" class="layui-input" disabled="disabled">
                    
                    </div>
                    
                    
                     <label for="L_title" class="layui-form-label">
                        影片类型
                   </label>
                    <div class="layui-input-block">
                    
                     <input type="text" id="L_title" name="category_id" required lay-verify="title"   value="${Movie.category.category_name }"
                        autocomplete="off" class="layui-input" disabled="disabled">
                    
                    </div>
                    
                    
                  
                  
                     <label for="L_title" class="layui-form-label">
                        上映时间
                   </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="movie_release_date" required lay-verify="title"   value="${Movie.movie_release_date }"
                        autocomplete="off" class="layui-input" disabled="disabled">
                    </div>
                    
                     <label for="L_title" class="layui-form-label">
                        影片时长
                   </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="movie_duration" required lay-verify="title"   value="${Movie.movie_duration }"
                        autocomplete="off" class="layui-input" disabled="disabled">
                    </div>
                    
                     <label for="L_title" class="layui-form-label">
                        票价
                   </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="movie_price" required lay-verify="title"   value="${Movie.movie_price }"
                        autocomplete="off" class="layui-input">
                    </div>
                    
                    
                       <label for="L_title" class="layui-form-label">
                        商品描述
                   </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="movie_descrption" required lay-verify="title"   value="${Movie.movie_descrption }"
                        autocomplete="off" class="layui-input" disabled="disabled">
                    </div>
                    
                    
                       <label for="L_title" class="layui-form-label">
                        影片主图
                   </label>
                    <div class="layui-input-block">
                    	<img src="${pageContext.request.contextPath}${Movie.movie_img }" width="50px" height="30px" />
                    	<img src="${pageContext.request.contextPath}${Movie.movie_pic1 }" width="50px" height="30px" />	
                    	 <img src="${pageContext.request.contextPath}${Movie.movie_pic2 }" width="50px" height="30px" />
                    </div>
                    
 
                   
			
                <div class="layui-form-item">
                    <button class="layui-btn" lay-filter="add" lay-submit>
                        修改信息
                    </button>
                </div>
            	</c:forEach>
            	
               
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