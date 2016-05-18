<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.w3c.dom.*"%>
<%@page import="org.xml.sax.SAXException"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Animal Game</title>
<style>
a:link, a:visited {
	width: 150px;
    background-color: Black;
    color: skyblue;
    padding: 14px 25px;
    text-align: center;	
    text-decoration: none;
    display: inline-block;
}
.center {
    margin: auto;
    width: 25%;
    
    padding: 10px;
}

a:hover, a:active {
    background-color: green;
}

body {
    background-color: #D0D0D0 ;
}
</style>
</head>
<body>
	<form id="form1" name="form1" method="post" action="/Assignment/GameServlet">
	<a href="/Assignment/GameServlet">Play Again</a>
	<a href="/Assignment/AddAnimal">Add Animal</a>
	<%Element queContent = (Element) request.getAttribute("queContent");
	 %>
	<%Element truthy = (Element) request.getAttribute("truthy");%>
	<%Element falsy = (Element) request.getAttribute("falsy");%>
		<h1 class="center"><%=queContent.getTextContent()%></h1>
		<% if (truthy !=null && falsy !=null) { %>
		<h1 class="center"><a href="/Assignment/GameServlet?responseClient=<%=truthy.getTextContent()%>">yes</a></h1>
		<h1 class="center"><a href="/Assignment/GameServlet?responseClient=<%=falsy.getTextContent()%>">No</a></h1>
		<% } %>
</form>
</body>
</html>