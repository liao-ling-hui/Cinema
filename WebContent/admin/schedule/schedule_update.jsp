<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理---详情</title>
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
            <form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/UpdateScheduleTime">
            
            	<c:forEach items="${scheduleDetails }" var="sd">
            	 <div class="layui-form-item">
                 
                        <input type="hidden" id="L_title" name="schedule_id"  value="${sd[0] }"/>
                   
                    
                    
                    <label for="L_title" class="layui-form-label">
                        影院
                  </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="theater_name" required lay-verify="title" value="${sd[3] }"
                        autocomplete="off" class="layui-input" disabled="disabled">
                    </div>
                    <label for="L_title" class="layui-form-label">
                 影片       
                    </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="movie_name" required lay-verify="title" value="${sd[2] }"
                        autocomplete="off" class="layui-input" disabled="disabled">
                    </div>
                    
                <label for="L_title" class="layui-form-label">
                        放映厅
                   </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="hall_name" required lay-verify="title"   value="${sd[1] }"
                        autocomplete="off" class="layui-input" disabled="disabled">
                    </div>
                     
                    
                     <label for="L_title" class="layui-form-label">
                       开始时间
                   </label>
                    <div class="layui-input-block">
                    
                     <input type="text" id="L_title" name="start_time" required lay-verify="title"   value="${sd[5] }"
                        autocomplete="off" class="layui-input" palacholder="输入开始时间">
                    
                    </div>
                    
                    
                    <label for="L_title" class="layui-form-label">
                        结束时间
                   </label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="end_time" required lay-verify="title"   value="${sd[6] }"   autocomplete="off" class="layui-input"  palacholder="输入结束时间" />
                       
                    </div>
                    
                    
                     <label for="L_title" class="layui-form-label">
                        费用
                   </label>
                    <div class="layui-input-block">
                    
                     <input type="text" id="L_title" name="fare" required lay-verify="title"   value="${sd[4]}"
                        autocomplete="off" class="layui-input" >
                    
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