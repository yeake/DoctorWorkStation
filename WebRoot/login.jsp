<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>医生工作站管理系统</title>
	<meta charset="utf-8">
	<meta name="author" content="祖秋雨">
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
		height: 250px;
		width: 400px;
		background-color: #FEFEFE;
		margin: 120px auto 0;
		padding: 50px;
		color: #333333;
		text-align: center;
	}
	.main h1{
		font-size: 30px;
	}
	.main input{
		height: 30px;
		line-height: 28px;
		width: 200px;
		margin: 10px auto;
		font-size:12px;
		color:grey;
	}
	.main button{
		width: 261px;
		height: 44px;
	    background: url(img/login.png);
   		border: 0;
    	cursor: pointer;
    	margin-top: 15px;
	}
	.main button:hover{
		background: url(img/login_h.png);
	}
	.link{
		margin-right: -20px;
		margin-top: 10px;
		text-align: right;
	}
	.link a{
		text-decoration: none;
		font-size: 14px;
		color: #DC3C00;
	}
	.copy{
		position: relative;
  		left: 30px;
  		top: 20px;
		width:100%;
		height: 30px;
		text-align:center;
		line-height:28px;
		margin-top:5px;
		color:#000000;
		font-size:10px;
	}
	.copy:hover{
		color:#37C4D0;
	}
	</style>
	<script type="text/javascript">
		function check(form){
			var username=document.getElementById("username").value;
			if(!/^[0-9a-zA-Z_]+$/.test(username)){
				alert('用户名不符合规范');
				return false;
			}
			var password=document.getElementById("password").value;
			if(/^[\s\n\r\t]*$/.test(password)){
				alert('密码不能为空');
				return false;
			}
		}
	</script>
</head>
<body>
<div class="main">
	<h1>医生工作站管理系统</h1><br/>
	<form action="${pageContext.request.contextPath}/LoginServlet" method="post" onsubmit="return check(this)">
		账 号 <input type="text" name="username" id="username" value="请输入用户名/邮箱/手机号" onblur="if (this.value=='') this.value='请输入用户名/邮箱/手机号';" onfocus="if (this.value=='请输入用户名/邮箱/手机号') this.value='';"><br/>
		密 码 <input type="password" name="password" id="password"><br/>
		<button type="submit" value="登陆"></button>
	</form>
	<div class="link"><a href="register.html">没有账号，快速注册</a></div>
</div>
<div class="copy">
<%=new pers.qiuyuzu.servlet.User().getCopy()%></div>
</body>
</html>