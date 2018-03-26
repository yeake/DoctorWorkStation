<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医嘱界面</title>
</head>
<body>
	<%
	String time = (String)request.getParameter("time");
	System.out.println(time);
	%>
	<form action="${pageContext.request.contextPath}/DiagnosisServlet">
		请输入您的诊断结果:<br/>
		<input type=hidden name="time" value="<%=time%>" readonly="true" ></text>
		<textarea rows="3" cols="100" name="diagnosis" id="textarea"></textarea>
		<input type="submit" value="提交" />
	</form>
</body>
</html>