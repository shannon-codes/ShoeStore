<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<style>
#women1 {
	background-image: url('/images/women/women1.jpg');
}
</style>


<link rel="icon" href="../../../../favicon.ico">

<title>Welcome to 2N</title>

<!-- Bootstrap core CSS -->
<link href="main.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="Product.css" rel="stylesheet">
</head>

<body>

	<nav class="site-header sticky-top py-1">
	<div
		class="container d-flex flex-column flex-md-row justify-content-between">
		<a class="py-2 d-none d-md-inline-block" href="AskLogout.jsp">LOG
			OUT</a> <a class="py-2 d-none d-md-inline-block"
			href="UserEditOrderForm.jsp">EDIT ORDER PLACED</a> <a
			class="py-2 d-none d-md-inline-block" href="Cart.jsp">CART</a>

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
		</a> <a class="py-2 d-none d-md-inline-block" href="Women.jsp">Women's</a>
		<a class="py-2 d-none d-md-inline-block" href="Men.jsp">Men's</a> <a
			class="py-2 d-none d-md-inline-block" href="Kid.jsp">Kids'</a>

	</div>
	</nav>




	<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
		<div
			class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
			<div class="my-3 py-3">
				<c:if test="${(empty requestScope.customerBean)}">
					<% RequestDispatcher rd=request.getRequestDispatcher("UserEditController");
			rd.forward(request, response); %>
				</c:if>
				<c:if test="${!(empty requestScope.ordersList)}">

					<h3 style="text-align: center">Your Orders List</h3>
					<table align="center" width="30%">

						<tr>
							<th colspan="7">Orders(s)</th>
						</tr>
						<tr>
							<th height="80">Order ID</th>
							<th>Customer ID</th>
							<th>Item ID</th>
							<th>Order Date</th>
							<th>Quantity</th>
							<th>Status</th>
						</tr>
						<c:forEach var="order" items="${requestScope.ordersList}">
							<tr>
								<td height="50"><c:out value="${order.orderId}" /></td>
								<td><c:out value="${order.customerId}" /></td>
								<td><c:out value="${order.itemId}" /></td>
								<td><c:out value="${order.orderDate}" /></td>
								<td><c:out value="${order.quantity}" /></td>
								<td><c:out value="${order.status}" /></td>

							</tr>
						</c:forEach>
					</table>
				</c:if>

			</div>
		</div>
	</div>



	<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
		<div
			class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
			<div class="my-3 py-3">
				<c:if test="${!(empty requestScope.feedback)}">
					<h4>${requestScope.feedback}</h4>
				</c:if>

				<h1 style="text-align: center">Edit Orders</h1>
				<br>
				<br>
				<form name="editOrder" method="post" action="UserEditController">
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



						<input type="hidden" name="status" value="order placed" />




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


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
	<script src="../../assets/js/vendor/popper.min.js"></script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<script>
      Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
      });
    </script>
</body>
</html>