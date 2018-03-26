<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="org.jfree.data.general.DefaultPieDataset,org.jfree.chart.ChartFactory  
,org.jfree.chart.JFreeChart,org.jfree.chart.servlet.*" %>  
<!DOCTYPE html>
<html>
<head>
<title>用户记录</title>
<meta charset="utf-8">
</head>
<body>
	<%
	String time = (String)request.getAttribute("time");
	%>
	<a href="${pageContext.request.contextPath }/DiagnosisUIServlet?time=<%=time%>">医嘱系统</a>
	<br /> 以下是用户生理参数：
	<br /> 呼吸率:${userResp}bmp&nbsp;心率:${userHr}bmp
	<br /> 血氧饱和度:${userSpo2}%&nbsp;脉率:${userPr}bmp
	<br /> 收缩压:${userSBP}mmHg&nbsp;舒张压:${userDBP}mmHg&nbsp;体温:${userTEMP}&#8451;
	<br /> <a href="${pageContext.request.contextPath }/TimeListServlet">返回上一页</a>
	<div> 
		<%
			String filenameECG = ServletUtilities.saveChartAsPNG(
					(JFreeChart) request.getAttribute("mECGChart"), 1000, 600,session);
			//ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）  
			//
			String urlECG = request.getContextPath()
					+ "/servlet/DisplayChart?filename=" + filenameECG;
			//根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
		%>
		<img src="<%=urlECG%>" width="1024" height="600">
		
	</div>
</body>
</html>
