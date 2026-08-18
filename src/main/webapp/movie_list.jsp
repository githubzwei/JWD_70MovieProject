<%@page import="model.MovieBean"%>
<%@page import="java.util.List"%>

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
<h3>Movie List</h3>
<%-- <%

List<MovieBean> movlist =(List<MovieBean>) request.getAttribute("movie_list");

%>
 --%>
 <form action="selected-movie" method="post">
<select name="mname">
<option value="none">None</option>
<%-- <%
for(MovieBean obj:movlist){
%>
<option value="<%= obj.getId() %>"><%= obj.getTitle()%>, <%= obj.getReleaseYear().getYear() %></option>	
<%	
}
%> --%>

<c:forEach items="${movie_list}" var="movie">
	<option value="${movie.id}">${movie.title}, ${movie.releaseYear}</option>
</c:forEach>



</select> <br> <br>

<input type="submit" value="choose">
</form>
</body>
</html>