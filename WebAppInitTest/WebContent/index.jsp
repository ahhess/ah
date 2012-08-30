<%@page import="ah.AppConfig"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebAppInitTest</title>
</head>
<body>
	<%
		AppConfig appConfig = AppConfig.getInstance();
	
		if("reinit".equals(request.getParameter("cmd"))) {
			appConfig.initFromSystemEnv();
		}
		
		String p = request.getParameter("p");
		String val = null;
		String val2 = null;
		String contextPath = appConfig.getProperty("contextPath");
		if (p != null){
			val = appConfig.getProperty(p);
		}
		if(contextPath != null) {
			val2 = "ITTCONF" + contextPath.replace("/", "_");
		}
	%>
	<h1>WebAppInitTest</h1>
	<form method="post" action="">
		<table>
			<tr>
				<td><input name="p" value="<%= p %>"></td>
				<td><input type="submit"></td>
				<td><%= val %></td>
			</tr>
			<tr>
				<td>ITT Value</td>
				<td><%= contextPath %></td>
				<td><%= val2 %></td>
			</tr>
		</table>
	</form>

	<form method="post" action="">
		<input type="hidden" name="cmd" value="reinit">
		<table>
			<tr>
				<td><input type="submit" value="Reinit"></td>
			</tr>
		</table>
	</form>

	<h2>AppInit Properties</h2>
	<table>
		<%
			for (String key : appConfig.getSortedPropertiesKeys()) {
		%>
		<tr>
			<td><%=key%></td>
			<td><%=appConfig.get(key)%></td>
		</tr>
		<%
			}
		%>
	</table>

	<h2>AppInit Properties</h2>
	<table>
		<%
			for (String key : AppConfig.getSortedPropertiesKeys(System
					.getProperties())) {
		%>
		<tr>
			<td><%=key%></td>
			<td><%=System.getProperty(key)%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>