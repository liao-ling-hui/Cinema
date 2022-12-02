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
		action="${pageContext.request.contextPath}/AddScheduleServlet" method="post">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加排片</STRONG> </strong>
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
				
				<td align="center" bgColor="#f5fafe" class="ta_01">影院：</td>
				<td class="ta_01" bgColor="#ffffff">
				<select name="theater_id" id="category">
						<option value="" selected="selected">请选择影院</option>
						<c:forEach items="${t_list }" var="t">
							<option value="${t.theater_id}">${t.theater_name }</option>
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
				
				<td align="center" bgColor="#f5fafe" class="ta_01">花费：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="fare" class="bg" />
				</td>
				
				
				
			</tr>
			<tr>
			
			<td align="center" bgColor="#f5fafe" class="ta_01">开始时间：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="start_time" class="bg" />
				</td>
				
				<td align="center" bgColor="#f5fafe" class="ta_01">结束时间：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="end_time" class="bg" />
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