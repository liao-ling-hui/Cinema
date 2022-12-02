<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>排片管理</title>
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
<div class="x-nav">
		<span class="layui-breadcrumb"> <a><cite>首页</cite></a> <a><cite>排片管理</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<form class="layui-form x-center" action="${pageContext.request.contextPath}/SearchScheduleByMovieName" style="width: 500px">
			<div class="layui-form-pane">
				<div class="layui-form-item">
					<div class="layui-input-inline" style="width: 400px">
						<input type="text" name="start_time" placeholder="请输入开始时间查询"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-input-inline" style="width: 80px">
						<button class="layui-btn" lay-submit="" lay-filter="sreach">
							<i class="layui-icon">&#xe615;</i>
						</button>
					</div>
				</div>
			</div>
		</form>
		<xblock>
		<button class="layui-btn"
			onclick="user_add()">
			<i class="layui-icon">&#xe608;</i>添加
		</button>

		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon">&#xe640;</i>批量删除
		</button>
		<table class="layui-table">
			<thead>
				<tr>
					<th><input type="checkbox" name="" value=""></th>
					<th>排片编号</th>
					<th>影院</th>
					<th>放映厅</th>
					<th>影片</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>观看费用</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list_schedule }" var="sch">
				<tr>
					<td><input type="checkbox" value="1" name=""></td>
					<td>${sch.schedule_id }</td> 
					<td><u style="cursor: pointer" onclick="question_show()">
							${sch.theater.theater_name } </u></td>
					<td>${sch.hall.hall_name }</td>
					<td>${sch.movie.movie_name }</td>
					<td>${sch.start_time }</td>
					<td>${sch.end_time }</td>
					<td>${sch.fare }</td>
					<td class="td-manage"><a  href="${pageContext.request.contextPath}/ScheduleDetailsServlet?schedule_id=${sch.schedule_id }" 
					title="查看" href="javascript:;" class="ml-5" style="text-decoration: none"> <i
							class="layui-icon"><img src="${pageContext.request.contextPath}/admin/images/look.png" width="15"
								height="15"></img></i>
					</a> <a title="删除" href="${pageContext.request.contextPath}/DeleteScheduleServlet?schedule_id=${sch.schedule_id }"
						style="text-decoration: none"> <i class="layui-icon">&#xe640;</i>
					</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<br />
	<br />
	<br />
	<script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/admin/js/x-layui.js" charset="utf-8"></script>
	<script>
		layui.use([ 'laydate', 'element', 'laypage', 'layer' ], function() {
			$ = layui.jquery; //jquery
			laydate = layui.laydate; //日期插件
			lement = layui.element(); //面包导航
			laypage = layui.laypage; //分页
			layer = layui.layer; //弹出层
			//以上模块根据需要引入
			laypage({
				cont : 'page',
				pages : 100,
				first : 1,
				last : 100,
				prev : '<em><</em>',
				next : '<em>></em>'
			});
		});
		//批量删除提交
		function delAll() {
			layer.confirm('确认要删除吗？', function(index) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
			});
		}
		
		/*添加*/
		function user_add() {
			window.location.href="${pageContext.request.contextPath}/GeneralScheduleServlet";
			}
		
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