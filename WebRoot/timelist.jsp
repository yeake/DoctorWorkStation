<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String time = "aaaaa";
	String name = "bbbbb";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
	/*通用样式*/
	*{
		padding: 0;
		margin: 0;
		
	}
	body{
		font: 18px/28px '微软雅黑','Microsoft YaHei',Arial;
		background-color: #37A6D0;
	}
	img{
		border: none;
	}
	/*登录框样式*/
	.main{
		height: 300px;
		width: 500px;
		background-color: #FEFEFE;
		margin: 120px auto 0;
		padding: 50px;
		color: #333333;
		text-align: center;
		overflow:auto;
	}
	.main h1{
		font-size: 30px;
	}
	.main a{

	}
	</style>
<title>记录列表</title>
</head>
<body>
<div class="main">
	<h1>记录列表<h1>
	<%
		String[] timeList = (String[]) (request.getAttribute("timeList"));
	%>
	<!-- 显示时间列表 -->
	<br />
	<%
		for (int i = 0; i < timeList.length; i++) {
			time = timeList[i];
			name = timeList[i].substring(0,4)+"年"+timeList[i].substring(4,6)+"月"+
					timeList[i].substring(6,8)+"日"+timeList[i].substring(8,10)+"时"+
					timeList[i].substring(10,12)+"分"+timeList[i].substring(12,14)+"秒";
	%>
	<a
		href="${pageContext.request.contextPath }/RecordServlet?time=<%=time%>"
		value=<%=name%>><%=name%></a>
		</br>
	<br />
	<%
		}
	%>
</div>
</body>
</html>