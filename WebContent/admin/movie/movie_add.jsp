<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath}/admin/css/Style.css" type="text/css" rel="stylesheet">
</HEAD>
<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/AddMovieServlet" method="post"
		enctype="multipart/form-data">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加影片</STRONG> </strong>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">影片名：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="movie_name" class="bg" /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">导演：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="movie_director" class="bg" /></td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">演员：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="movie_actor" class="bg" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">影片评分：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="movie_sorce" class="bg" />
				</td>
			</tr>
			
			
			<tr>
			<td align="center" bgColor="#f5fafe" class="ta_01">放映厅：</td> 
				<td class="ta_01" bgColor="#ffffff">
					<select name="hall_id" id="category">
						<option value="" selected="selected">--选择放映厅类别--</option>
										<option value=1>1号厅</option>
										<option value=2>2号厅</option>
										<option value=3>3号厅</option>
										<option value=4>4号厅</option>
										
				</select>
				</td>
				
				<td align="center" bgColor="#f5fafe" class="ta_01">影片类型：</td> 
				<td class="ta_01" bgColor="#ffffff">
					<select name="category_id" id="category">
						<option value="" selected="selected">--选择影片类型--</option>
									<option value="1">喜剧片</option>
                                    <option value="2">动作片</option>
                                    <option value="3">青春、爱情、校园</option>
                                    <option value="4">犯罪、恐怖、悬疑</option>
                                    <option value="5">医疗、抗疫</option>
                                    <option value="6">运动、喜剧、励志</option>
                                    <option value="7">剧情片</option>
										
				</select>
				</td>
			</tr>
			
			
			<tr>
			<td align="center" bgColor="#f5fafe" class="ta_01">上映时间：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="movie_release_date" class="bg" />
				</td>
				
			<td align="center" bgColor="#f5fafe" class="ta_01">影片时长：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="movie_duration" class="bg" />
				</td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">票价：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
				<input type="text" name="movie_price" size="30" value="" />
				</td>
			</tr>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">商品描述：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
					<textarea name="movie_descrption" cols="30" rows="3" style="WIDTH: 96%"></textarea>
				</TD>
			</TR>
			
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">影片主图：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
					<input type="file" name="movie_img" size="30" value="" />
				</TD>
			</TR>
			
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">影片副图：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
					<input type="file" name="movie_pic1" size="30" value="" />
				</TD>
			</TR>
			
			
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">影片副图：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
					<input type="file" name="movie_pic2" size="30" value="" />
				</TD>
			</TR>
			
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</TR>
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