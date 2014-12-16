<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	Object o = null;
	String lookup = request.getParameter("lookup");
	if (lookup==null) {
		lookup = "";
		o=null;
	} else {	
		InitialContext initialContext = new InitialContext();
		o = initialContext.lookup(lookup);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JNDI Lookup Test</title>
</head>
<body>
	<h1>JNDI Lookup Test</h1>
	<p>JNDI looup für : <input name="lookup" value='<%= request.getParameter("lookup") %>'></p>
	<p>Ergebnis: <%= o!=null?o.toString():"" %> 
	</p>
</body>
</html>