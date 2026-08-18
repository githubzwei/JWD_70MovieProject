<%@page import="java.util.List"%>
<%@page import="model.CategoryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Category List</h3>
<%-- <%

List<CategoryBean> catlist =(List<CategoryBean>) request.getAttribute("catlist");

for(CategoryBean obj:catlist){
%>
	<a href="movie-list?catId=<%= obj.getId() %>"><%= obj.getName() %></a> <br>
<%	
}
%> --%>

<c:forEach items="${catlist}" var="category">
	<a href="movie-list?catId=${category.id}">${category.name}</a>
</c:forEach>


</body>
</html>