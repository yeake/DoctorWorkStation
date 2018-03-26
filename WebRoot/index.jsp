<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>首页</title>
	<meta charset="utf-8">
	<meta name="author" content="祖秋雨">
	<style type="text/css">
	*{
		padding: 0;
		margin: 0;
	}
	div{
		height: 50px;
		background-color: #37A6D0;
	}
	div p{
		font: 18px/32px '宋体';
		color: #FEFEFE;
		line-height:50px;
		margin-left:50px;
	}
	div a{
		color: #EFEFDC;
		line-height:50px;
	}
	div #user{
		text-decoration:none;
	}
	</style>
</head>
<body>
<div>
	<p>欢迎您! ${user.username}!  <a href="/DoctorWorkStation/login.html">退出登录</a></p>
  	<br/>
</div>
</body>
</html>
