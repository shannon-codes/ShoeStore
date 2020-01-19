
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
				Customer Service Representative<br>
			</p>
			<p class="lead font-weight-normal">Shoes Management</p>
		</div>
	</div>


	<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
		<div
			class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
			<div class="my-3 py-3">
				<c:if test="${!(empty requestScope.message)}">
					<h4>${requestScope.message}</h4>
				</c:if>


				<c:if test="${(empty requestScope.shoesList)}">
					<% RequestDispatcher rd=request.getRequestDispatcher("ShoesController");
						rd.forward(request, response); %>
				</c:if>

				<c:if test="${!(empty requestScope.shoesList)}">
					<div class="my-3 p-3">
						<table align="center" width="70%">

							<tr>
								<th colspan="10"><h1>List of Shoes</h1></th>
							</tr>

							<tr>
								<th height="80">ID</th>
								<th>Item Name</th>
								<th>Category</th>
								<th>Shoe Size</th>
								<th>Price</th>
							</tr>
							<c:forEach var="shoes" items="${requestScope.shoesList}">
								<tr>
									<td height="50"><c:out value="${shoes.itemId}" /></td>
									<td><c:out value="${shoes.itemName}" /></td>
									<td><c:out value="${shoes.category}" /></td>
									<td><c:out value="${shoes.shoeSize}" /></td>
									<td><c:out value="${shoes.price}" /></td>
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
			<div class="my-3 py-3" title="Shoes Products Management">
				<h1>Add/Edit Shoes Products</h1>
				<br>
				<br>
				<form name="editShoes" method="post" action="ShoesController">
					<table align="center" width="50%">
						<tr>
							<td>Item ID</td>
							<td height="50"><input type="text" name="itemId"
								placeholder="Item ID" /></td>
						</tr>
						<tr>
							<td>Item Name</td>
							<td height="50"><input type="text" name="itemName"
								placeholder="Item Name" /></td>
						</tr>
						<tr>
							<td>Category</td>
							<td height="50"><select name="category">
									<option value="women" selected>womens</option>
									<option value="mens">mens</option>
									<option value="children">children</option>
							</select></td>
						</tr>
						<tr>
							<td>Shoe Size</td>
							<td height="50"><input type="text" name="shoeSize"
								placeholder="8.5" /></td>
						</tr>
						<tr>
							<td>Price</td>
							<td height="50"><input type="text" name="price"
								placeholder="price" /></td>
						</tr>
					</table>
					<br>
					<br>
					<table align="center" width="10%">
						<tr>
							<td><input type="submit" name="submit" value="Add" /></td>
							<td><input type="submit" name="submit" value="Edit" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>

</body>
</html>