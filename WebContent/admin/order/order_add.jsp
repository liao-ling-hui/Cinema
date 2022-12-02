<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hndysf.entity.*" %>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath}/admin/css/Style.css" type="text/css" rel="stylesheet">
</HEAD>
<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/AddOrderServlet" method="post">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加订单</STRONG> </strong>
				</td>
			</tr>
			
			
			
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">影片名：</td> 
				<td class="ta_01" bgColor="#ffffff">
					<select name="movie_id" id="">
						<option value="" selected="selected">请选择影片</option>
						<c:forEach items="${movie }" var="m">
							<option value="${m.movie_id }" >${m.movie_name }</option>
						</c:forEach>
						

				</select>
				</td>
				
				<td align="center" bgColor="#f5fafe" class="ta_01">排片：</td>
				<td class="ta_01" bgColor="#ffffff">
				<select name="schedule_id" id="category">
						<option value="" selected="selected">请选择时间段</option>
						<c:forEach items="${schedule }" var="sch">
							<option value="${sch.schedule_id }">${sch.start_time }---${sch.end_time }</option>
						</c:forEach>
										
				</select>
				
				</td>
			</tr>
			
			
			
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">所属用户：</td>
				<td class="ta_01" bgColor="#ffffff">
				<select name="user_id" id="category">
						<option value="" selected="selected">请选择用户</option>
						<c:forEach items="${user }" var="u">
							<option value="${u.user_id }">${u.user_name }</option>
						</c:forEach>
										
				</select>
				</td>
				
				
				<td align="center" bgColor="#f5fafe" class="ta_01">影院：</td>
				<td class="ta_01" bgColor="#ffffff">
				<select name="cinema_id" id="category">
						<option value="" selected="selected">请选择影院</option>
						<c:forEach items="${cinema }" var="c">
							<option value="${c.cinema_name }">${c.cinema_name }</option>
						</c:forEach>
										
				</select>
				</td>
			</tr>
			
			
			<tr>
			<td align="center" bgColor="#f5fafe" class="ta_01">放映厅：</td>
				<td class="ta_01" bgColor="#ffffff">
				<select name="hall_id" id="category">
						<option value="" selected="selected">请选择放映厅</option>
						<c:forEach items="${hall }" var="h">
							<option value="${h.hall_id }">${h.hall_name }</option>
						</c:forEach>
										
				</select>
				
				</td>
				
				<td align="center" bgColor="#f5fafe" class="ta_01">影片类型：</td> 
				<td class="ta_01" bgColor="#ffffff">
					<select name="category_id" id="category">
					<option value="" selected="selected">--选择影片类型--</option>
					<c:forEach items="${category }" var="cate">
								
									<option value=${cate.category_id }>${cate.category_name }</option>
                                    
				</c:forEach>						
				</select>
				
				</td>
			</tr>
			
			
			<tr>
			<td align="center" bgColor="#f5fafe" class="ta_01">订单总价：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="order_total_price" class="bg" />
				</td>
				
			<td align="center" bgColor="#f5fafe" class="ta_01">购票数量：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="order_count" class="bg" />
				</td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">观看时间：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
				<input type="text" name="see_time" size="30" value="" />
				</td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">座位：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
						 <input type="text" id="L_title" name="rows" required lay-verify="title"   value=""   autocomplete="off" class="layui-input"  palacholder="输入1-10之内" />
                        <input type="text" id="L_title" name="movie_sorce" required lay-verify="title"   value="排"    autocomplete="off" class="layui-input" disabled="disabled" />
                        <input type="text" id="L_title" name="cols" required lay-verify="title"   value=""    autocomplete="off" class="layui-input"  palacholder="输入1-10之内"/>
                        <input type="text" id="L_title" name="movie_sorce" required lay-verify="title"   value="座"    autocomplete="off" class="layui-input" disabled="disabled" />
				</td>
			</tr>
			
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					<input type="submit" class="button_ok" value="确定">	
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<input type="reset" value="重置" class="button_cancel">					
					<FONT face="宋体">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</FONT> 
					<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>