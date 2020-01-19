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

<title>CSR Shoes Management</title>

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
				Your Shopping Cart<br>
			</p>
			<p class="lead font-weight-normal">Hi</p>
		</div>
	</div>


	<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
		<div
			class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
			<div class="my-3 py-3">
				<%@ page import="a3.ShoesDAO"%>

				<p>${sessionScope.userName}'s Cart</p>



				<form name="editOrder" method="post" action="UserSubmitOrder">
					<table align="center" width="30%">

						<tr>
							<td>Customer ID</td>
							<td height="50"><input type="text" name="customerId"
								value="${requestScope.customerId}" /></td>
						</tr>
						<tr>
							<td>Item ID</td>
							<td height="50"><input type="text" name="itemId"
								value="${requestScope.myBean.itemId}" /></td>
						</tr>
						<tr>
							<td>Order Date</td>
							<td height="50"><input type="date" name="orderDate"
								value="2018-12-25" /></td>
						</tr>
						<tr>
							<td>Quantity</td>
							<td height="50"><input type="number" name="quantity"
								value="1" /></td>
						</tr>

						<input type="hidden" value="order placed" name="status">
						
					


					</table>
					<br>
					<br>
					<table>
						<tr>
							<td><input type="submit" name="submit" value="Order" /></td>
						</tr>
					</table>
				</form>


			</div>
		</div>
	</div>




</body>
</html>