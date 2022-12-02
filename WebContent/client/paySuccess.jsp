<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>支付成功跳转</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/my.js"></script>
<style type="text/css">
#divcontent {
	width: 900px;
	background-color: #ffffff;
	border: 1px solid #EEEDDB;
	MARGIN-RIGHT: auto;
	MARGIN-LEFT: auto;
}
</style>
</head>
<body>
	<div id="divcontent">
		<table width="850px" border="0" cellspacing="0">
			<tr>
				<td style="padding:30px; text-align:center"><table width="60%"
						border="0" cellspacing="0" style="margin-top:70px">
						<tr>
							<td style="width:98">
								<img src="${pageContext.request.contextPath }/client/image/IconTexto_WebDev_009.jpg" width="128" height="128" />
							</td>
							<td style="padding-top:30px">
								<font style="font-weight:bold; color:#FF0000">支付成功</font><br /><br /> 
								<a href="${pageContext.request.contextPath }/OrderDetailsServlet?order_id=${order_id}&seats=${seats}">
									<span id="second">60</span>秒后自动为您转跳回订单详情
								</a>
							</td>
						</tr>
					</table>
					<h1>&nbsp;</h1>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>