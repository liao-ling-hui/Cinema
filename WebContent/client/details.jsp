<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>影片详情</title>
<link href="${pageContext.request.contextPath}/client/css/details.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/client/js/layer-v3.0.3/layer/mobile/need/layer.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/phone.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/layer-v3.0.3/layer/layer.js"></script>
</head>
<body>

<c:forEach items="${movie_list }" var="detail">
	<div class="whole">
	<div class="movie">
    	<div class="back"><img src="${pageContext.request.contextPath}/client/image/back.png" /></div>
    	<img src="${pageContext.request.contextPath}${detail[14]}" />
        <span>
        	<img src="${pageContext.request.contextPath}/client/image/start.png" />
        </span>
    </div>
    <div class="detail">
    	<div class="bol"><img src="${pageContext.request.contextPath}/client/image/bg-bg.png" /></div>
        <div class="det-con">
        	<div class="common det-c">
            	<div class="jz-pic">
                	<img src="${pageContext.request.contextPath}${detail[12]}" />
                </div>
                <div class="det-inf">
                	<p class="det-titles">
                    	<span>${detail[1] }</span>
                        <span class="eng">Operation Mekong</span>
                    </p>
                    <!-- 评分 -->
                    <ul class="stars">
                    	<li><img src="${pageContext.request.contextPath}/client/image/stars.png" /></li>
                        <li><img src="${pageContext.request.contextPath}/client/image/stars.png" /></li>
                        <li><img src="${pageContext.request.contextPath}/client/image/stars.png" /></li>
                        <li><img src="${pageContext.request.contextPath}/client/image/stars.png" /></li>
                        <li><img src="${pageContext.request.contextPath}/client/image/stars.png" /></li>
                    </ul>
                    <p class="det-tag">${detail[6] }</p>
                    <a class="footer" href="${pageContext.request.contextPath}/ShowCinemaServlet?name=${detail[1] }">立即订票</a>
                </div>
            </div>
            
            <div class="common parti">
            	<span>${detail[8] }</span>
            </div>
            
            <div class="common stage-photo">
            	<h3>更多详情</h3>
 				
 				<div id="details">
 					<div class="details_left">
 						<div class="left">
 							<hr style="border: 1px dotted #838585;"><br />
 							<label>影片名</label>
 							<hr style="border: 1px dotted #838585;"><br />
 							<label>导演</label>
 							<hr style="border: 1px dotted #838585;"><br />
 							<label>类型</label>
 							<hr style="border: 1px dotted #838585;"><br />
 							
 						</div>
 						
 						<div class="right">
 							<hr style="border: 1px dotted #838585;"><br />
 							<span style="color: #8A869E;margin: 30px;">${detail[1] }</span><br />
 							<hr style="border: 1px dotted #838585;"><br />
 							<span style="color: #8A869E;margin: 30px;">${detail[2] }</span><br />
 							<hr style="border: 1px dotted #838585;"><br />
 							<span style="color: #8A869E;margin: 30px;">${detail[6] }</span><br />
 							<hr style="border: 1px dotted #838585;"><br />
 						</div>
 						
 					</div>
 				
 					<div class="details_right">
 						<div class="left">
 						<hr style="border: 1px dotted #838585;"><br />
 							<label>上映时间</label>
 							<hr style="border: 1px dotted #838585;"><br />
 							<label>演员</label>
 							<hr style="border: 1px dotted #838585;"><br />
 							<label>时长</label>
 							<hr style="border: 1px dotted #838585;"><br />
 							
 						</div>
 						
 						<div class="right">
 							<hr style="border: 1px dotted #838585;"><br />
 							<span style="color: #8A869E;margin: 30px;">${detail[7] }</span><br />
 							<hr style="border: 1px dotted #838585;"><br />
 							<span style="color: #8A869E;margin: 30px;">${detail[3] }</span><br />
 							<hr style="border: 1px dotted #838585;"><br />
 							<span style="color: #8A869E;margin: 30px;">${detail[9] }</span><br />
 							<hr style="border: 1px dotted #838585;"><br />
 							
 						</div>
 						
 					</div>
 				
 				</div>
 				
            	<h3>剧照</h3>
            	
            	<div id="pirture">
            		<ul>
            			<li><img src="${pageContext.request.contextPath}${detail[14]}" /></li>
                   		<li><img src="${pageContext.request.contextPath}${detail[15]}" /></li>
            		</ul>
            	</div>
            	
            </div>
            
        </div>
    </div>
    
</div>
<script type="text/javascript">
$(document).ready(function() {
	
	$('.movie').click(function(){
		movie();
	});
	
	function movie(){
		layer.open({
		  type: 2,
		  title: false,
		  area: ['630px', '360px'],
		  shade: 0.8,
		  closeBtn: 0,
		  shadeClose: true,
		  content: 'movies/meigonghe.mp4'
		});	
	}
	
	$('.back').on('click',function(){
		window.history.go(-1);
	});
	
});
</script>
</c:forEach>


</body>
</html>