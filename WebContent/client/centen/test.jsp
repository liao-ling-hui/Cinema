<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hndysf.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"  src="${pageContext.request.contextPath}/client/js/jquery-1.7.2.min.js"></script>
</head>
<body>

</body>
<script type="text/javascript"> 
<!--  //取出传回来的参数error并与yes比较 -->
<%%>
 var info1 ='<%=request.getParameter("info1")%>';
 var info2 ='<%=request.getParameter("info2")%>';
  alert(info1+"     "+info2); 
  window.location.href="${pageContext.request.contextPath}/FindUserOrder?user_id=${user.user_id}";
</script> 

 
</html>