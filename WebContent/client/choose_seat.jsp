<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>选座并支付</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/client/css/reset.css" />
</head>
<body>
	<div class="demo clearfix">
		<!---左边座位列表----->
		<div id="seat_area">
			<div class="front">屏幕</div>
			<div id="legend"></div>
		</div>
		<!---右边选座信息----->

		<div class="booking_area">

			<div id="left">
				<img src="${pageContext.request.contextPath}${BaseInfo.movie_img}" />
				<p>
					电影：<span>${BaseInfo.movie_name }</span>
				</p>
				<p>
					场次：<span id="date"></span>&nbsp;<span>${BaseInfo.start_time }-${BaseInfo.end_time }</span>
				</p>
				<p>
					片长：<span>${BaseInfo.movie_durtion }</span>
				</p>
				<p>
					影院：<span>${BaseInfo.cinema_name }</span>
				</p>
				<p>
					放映厅：<span>${BaseInfo.hall_name }&nbsp;&nbsp;&nbsp;${BaseInfo.hall_category }</span>
				</p>
				<p>
					票价：<span id="movie_price">${BaseInfo.fare }</span>
				</p>
				<p>座位：</p>
				<ul id="seats_chose" name="seats_chose"></ul>
				<p>
					票数：<span id="tickects_num">0</span>
				</p>
				<p>
					总价：<b>￥<span id="total_price">0</span></b>
				</p>
				<input type="button" class="btn" value="确定购买" onclick="pay()" />

			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/client/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/client/js/jquery.seat-charts.min.js"></script>
	<script type="text/javascript">
		var p = document.getElementById("movie_price").innerText; //电影票价
		var price = parseInt(p);
		
		$(document)
				.ready(
						function() {
							var $cart = $('#seats_chose'), //座位区
							$tickects_num = $('#tickects_num'), //票数
							$total_price = $('#total_price'); //票价总额

							var sc = $('#seat_area')
									.seatCharts(
											{
												map : [//座位结构图 a 代表座位; 下划线 "_" 代表过道
												'cccccccccc', 'cccccccccc',
														'__________',
														'cccccccc__',
														'cccccccccc',
														'cccccccccc',
														'cccccccccc',
														'cccccccccc',
														'cccccccccc',
														'cc__cc__cc' ],
												naming : {//设置行列等信息
													top : false, //不显示顶部横坐标（行） 
													getLabel : function(
															character, row,
															column) { //返回座位信息 
														return column;
													}
												},
												legend : {//定义图例
													node : $('#legend'),
													items : [
															[ 'c', 'available',
																	'可选座' ],
															[
																	'c',
																	'unavailable',
																	'已售出' ] ]
												},
												click : function() {
													if (this.status() == 'available') { //若为可选座状态，添加座位
														$(
																'<li>'
																		+ (this.settings.row + 1)
																		+ '排'
																		+ this.settings.label
																		+ '座</li>')
																.attr(
																		'id',
																		'cart-item-'
																				+ this.settings.id)
																.data(
																		'seatId',
																		this.settings.id)
																.appendTo($cart);

														$tickects_num
																.text(sc
																		.find('selected').length + 1); //统计选票数量
														$total_price
																.text(getTotalPrice(sc)
																		+ price);//计算票价总金额

														return 'selected';
													} else if (this.status() == 'selected') { //若为选中状态

														$tickects_num
																.text(sc
																		.find('selected').length - 1);//更新票数量
														$total_price
																.text(getTotalPrice(sc)
																		- price);//更新票价总金额
														$(
																'#cart-item-'
																		+ this.settings.id)
																.remove();//删除已预订座位

														return 'available';
													} else if (this.status() == 'unavailable') { //若为已售出状态
														return 'unavailable';
													} else {
														return this.style();
													}
												}
											});
							//设置已售出的座位
							<c:forEach items="${ch_seat}" var="cs">
							sc.get('${cs.rows}_${cs.cols}').status(
									'unavailable');
							</c:forEach>

							

						});

		function getTotalPrice(sc) { //计算票价总额
			var total = 0;
			sc.find('selected').each(function() {
				total += price;
			});
			return total;
		}
		
		function pay() {
			var d=document.getElementById("date").innerText;//日期
			var total_price=document.getElementById("total_price").innerText;//总价
			var tickects_num=document.getElementById("tickects_num").innerText;//票价
			var seats_chose=document.getElementById("seats_chose").innerText;//座位号
			window.location.href = "${pageContext.request.contextPath}/CreateSeatServlet?schedule_id=${schedule_id}&fare=${BaseInfo.fare }&hall_name=${BaseInfo.hall_name }&movie_name=${BaseInfo.movie_name }&cinema_name=${BaseInfo.cinema_name}&total_price="+total_price+"&tickects_num="+tickects_num+"&seats_chose="+seats_chose+"&data="+d;
		}
	</script>

	<script language="JavaScript">
		console.log(getNowTime());
		//获取当前时间
		function getNowTime() {
			var date = new Date();
			//年 getFullYear()：四位数字返回年份
			var year = date.getFullYear(); //getFullYear()代替getYear()
			//月 getMonth()：0 ~ 11
			var month = date.getMonth() + 1;
			//日 getDate()：(1 ~ 31)
			var day = date.getDate();
			var time =addZero(year)+'年'+ addZero(month) + '月' + addZero(day) + '日';

			$("#date").html(time);
			return time;
		}
		//小于10的拼接上0字符串
		function addZero(s) {
			return s < 10 ? ('0' + s) : s;
		}
		
	
	</script>



</body>
</html>