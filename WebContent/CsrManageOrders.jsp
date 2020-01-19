
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Insert title here</title>

<link rel="icon" href="../../../../favicon.ico">
<link href="main.css" rel="stylesheet">
<link href="Product.css" rel="stylesheet">

</head>
<body>
	<nav class="site-header sticky-top py-1">
		<div
			class="container d-flex flex-column flex-md-row justify-content-between">
			<a class="py-2 d-none d-md-inline-block" href="AskLogout.jsp">LOG
				OUT</a>
		</div>
	</nav>

	<nav class="site-header sticky-top py-1">
		<div
			class="container d-flex flex-column flex-md-row justify-content-between">
			<a class="py-2" href="MainPage.jsp"> <svg
					xmlns="http://www.w3.org/2000/svg" width="24" height="24"
					viewBox="0 0 24 24" fill="none" stroke="currentColor"
					stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
					class="d-block mx-auto">
					<circle cx="12" cy="12" r="10"></circle>
					<line x1="14.31" y1="8" x2="20.05" y2="17.94"></line>
					<line x1="9.69" y1="8" x2="21.17" y2="8"></line>
					<line x1="7.38" y1="12" x2="13.12" y2="2.06"></line>
					<line x1="9.69" y1="16" x2="3.95" y2="6.06"></line>
					<line x1="14.31" y1="16" x2="2.83" y2="16"></line>
					<line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
			</a> <a class="py-2 d-none d-md-inline-block"
				href="CsrManageCustomers.jsp">Customer</a> <a
				class="py-2 d-none d-md-inline-block" href="CsrManageOrders.jsp">Order</a>
			<a class="py-2 d-none d-md-inline-block" href="CsrManageShoes.jsp">Shoes</a>
		</div>
	</nav>

	<div
		class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
		<div class="col-md-5 p-lg-5 mx-auto my-5">
			<p class="display-4 font-weight-normal">
				Customer Service Representative<br>
			</p>
			<p class="lead font-weight-normal">Order Management</p>
		</div>
	</div>


	<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
		<div
			class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
			<div class="my-3 py-3">
				<c:if test="${!(empty requestScope.message)}">
					<h4>${requestScope.message}</h4>
					<p>
						<a href="CsrOrdersController">View all Orders</a>
					</p>
				</c:if>


				<c:if
					test="${(empty requestScope.ordersList) and (empty requestScope.customerId)}">
					<% RequestDispatcher rd=request.getRequestDispatcher("CsrOrdersController");
					rd.forward(request, response); %>
				</c:if>

				<c:if test="${!(empty requestScope.ordersList)}">

					<div class="my-3 p-3">
						<table align="center" width="70%">

							<tr>
								<th colspan="7">Orders</th>
							</tr>
							<tr>
								<th height="80">Order ID</th>
								<th>Customer ID</th>
								<th>Item ID</th>
								<th>Order Date</th>
								<th>Quantity</th>
								<th>Status</th>
								<th>Action</th>
							</tr>
							<c:forEach var="order" items="${requestScope.ordersList}">
								<tr>
									<td height="50"><c:out value="${order.orderId}" /></td>
									<td><c:out value="${order.customerId}" /></td>
									<td><c:out value="${order.itemId}" /></td>
									<td><c:out value="${order.orderDate}" /></td>
									<td><c:out value="${order.quantity}" /></td>
									<td><c:out value="${order.status}" /></td>
									<td><a href="CsrOrdersController?orderId=${order.orderId}">Edit</a>
									</td>
								</tr>

							</c:forEach>
						</table>
					</div>
				</c:if>

			</div>
		</div>
	</div>

	<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
		<div
			class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
			<div class="my-3 py-3">


				<h1 style="text-align: center">Edit Orders</h1>
				<br>
				<br>
				<form name="editOrder" method="post" action="CsrOrdersController">
					<table align="center" width="30%">
						<tr>
							<td>Order ID</td>
							<td height="50"><input type="text" name="orderId"
								value="${requestScope.order.orderId}" /></td>
						</tr>
						<tr>
							<td>Customer ID</td>
							<td height="50"><input type="text" name="customerId"
								value="${requestScope.order.customerId}" /></td>
						</tr>
						<tr>
							<td>Item ID</td>
							<td height="50"><input type="text" name="itemId"
								value="${requestScope.order.itemId}" /></td>
						</tr>
						<tr>
							<td>Order Date</td>
							<td height="50"><input type="date" name="orderDate"
								value="${requestScope.order.orderDate}" /></td>
						</tr>
						<tr>
							<td>Quantity</td>
							<td height="50"><input type="number" name="quantity"
								value="${requestScope.order.quantity}" /></td>
						</tr>

						<tr>
							<td>Status</td>
							<td height="50"><select name="status">
									<option value="order placed" selected>Order placed</option>
									<option value="in-process">In-Process</option>
									<option value="delivered">Delivered</option>
							</select></td>
						</tr>


					</table>
					<br>
					<br>
					<table>
						<tr>
							<td><input type="submit" name="submit" value="Edit" /></td>
						</tr>
					</table>
				</form>

			</div>
		</div>
	</div>


</body>
</html>
