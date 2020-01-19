<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Customer Service Representative Home Page</h2>
	<h2>Welcome,${sessionScope.usernameAttrib}</h2>
	<a href="<c:url value='/CsrManageCustomers.jsp' />">Customer
		Management</a>
	<br />
	<br />
	<a href="<c:url value='/CsrManageOrders.jsp' />">Order Management</a>
	<br />
	<br />
	<a href="<c:url value='/CsrManageShoes.jsp' />">Shoes Management</a>
	<br />
	<br />
	<a href="<c:url value='/logout.jsp' />">Log Out</a>
</body>
</html>