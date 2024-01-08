<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REPORT PAGE</title>
</head>
<body bgcolor="cyan"'>
<c:choose>
<c:when test="${dtolist ne null || !empty dtolist }">
<table border='1'>
<tr>
<th>PID</th>
<th>PNAME</th>
<th>PTENURE</th>
<th>PTYPE</th>
</tr>
<c:forEach var="dto" items="${dtolist }">
<tr>
<td>${dto.pid}</td>
<td>${dto.pname}</td>
<td>${dto.ptype}</td>
<td>${dto.ptenure}</td>
</tr>
</c:forEach>
</table>

</c:when>

</c:choose>

<c:if test="${pageNo>1}">
<a href='./controller?pageNo=${pageNo-1}&s1=link'>PREVIOUS</a>&nbsp;&nbsp;

</c:if>

<c:forEach var='i' begin='1' end='${pageCount}' step='1'>
<a href='./controller?pageNo=${i}&s1=link'>[${i}]</a>
</c:forEach>

<c:if test="${pageNo<pageCount}">
<a href='./controller?pageNo=${pageNo+1}&s1=link'>NEXT</a>&nbsp;&nbsp;

</c:if>

<h1 style='color:red; text-align:center'>
<a href='./index.jsp'>[HOME]</a>
</h1>

</body>
</html>