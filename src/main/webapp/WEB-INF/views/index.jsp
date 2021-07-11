<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
<%--<link href="<c:url value="/resources/css/style.css" />">
    <script src="<c:url value="/resources/js/script.js" />"></script> --%>
    
    <title>Home Page</title>
  </head>
  <body>
	<h1>Welcome to Spring MVC</h1>
	<%-- <img alt="image" src="<c:url value="/resources/image/profile.jpg" />"> --%>

	<%
		String myname = (String) request.getAttribute("name");
	%>
	<h1>Name is <%=myname%></h1>
	<h1>With JSP Expression language name: ${name}</h1>
	<h1>With JSP Expression language names: ${names}</h1>
	
<%--<c:forEach var="item" items="${names}">
      <h3>${item}</h3>
	</c:forEach> --%>
	
	<hr>
	
	<form action="upload" method="post" enctype="multipart/form-data">
       <label>Enter file</label>
       <input type="file" name="file">
       <button type="submit">Upload</button>
    </form>
	
  </body>
</html>