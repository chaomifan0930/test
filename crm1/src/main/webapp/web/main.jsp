<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>管理平台</title>
</head>

<frameset rows="61,*,24" cols="*" framespacing="0" frameborder="no" border="0">
	<frame src="top.html" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
	<frame src="center.html" name="mainFrame" id="mainFrame" />
	<frame src="down.html" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>

<noframes>
<body>
</body>
</noframes>
</html>