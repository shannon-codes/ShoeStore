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

<title>Customer Management</title>
<script>
	function validate(){
	if (document.editCustomers.customerId.value=="" ||
		document.editCustomers.userName.value==""||
		document.editCustomers.password.value==""||
		document.editCustomers.firstname.value==""||
			document.editCustomers.lastname.value==""||
				document.editCustomers.address.value==""||
				document.editCustomers.postalCode.value==""||
				document.editCustomers.city.value==""
				){
	alert("All fields are required");
	return false;
	}
	else{
	return true;
	}
}
</script>
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
				Customer Service Representative <br>
			</p>
			<p class="lead font-weight-normal">Customer Management</p>
		</div>
	</div>



	<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
		<div
			class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
			<div class="my-3 py-3">
				<c:if test="${!(empty requestScope.message)}">
					<h4>${requestScope.message}</h4>
				</c:if>

				<c:if test="${(empty requestScope.customerList)}">
					<% RequestDispatcher rd=request.getRequestDispatcher("CsrCustomerController");
					rd.forward(request, response); %>
				</c:if>

				<c:if test="${!(empty requestScope.customerList)}">
					<div class="my-3 p-3">
						<table align="center" width="70%">

							<tr>
								<th colspan="10"><h1>Customers</h1></th>
							</tr>
							<tr>
								<th height="80">ID</th>
								<th>Username</th>
								<th>Password</th>
								<th>First name</th>
								<th>Last name</th>
								<th>Address</th>
								<th>City</th>
								<th>Postal Code</th>
								<th>Action</th>
							</tr>
							<c:forEach var="customer" items="${requestScope.customerList}">
								<tr>
									<td height="50"><c:out value="${customer.customerId}" /></td>
									<td><c:out value="${customer.userName}" /></td>
									<td><c:out value="${customer.password}" /></td>
									<td><c:out value="${customer.firstname}" /></td>
									<td><c:out value="${customer.lastname}" /></td>
									<td><c:out value="${customer.address}" /></td>
									<td><c:out value="${customer.city}" /></td>
									<td><c:out value="${customer.postalCode}" /></td>
									<td><a
										href="CsrCustomerController?userName=${customer.userName}">Edit</a>&nbsp;&nbsp;
										<a
										href="CsrCustomerController?customerId=${customer.customerId}">Delete</a>
										&nbsp;&nbsp; <a
										href="CsrOrdersController?customerId=${customer.customerId}">View
											Order</a></td>
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
				<h1 style="text-align: center">Modify Customers</h1>

				<br>
				<br>
				<form name="editCustomers" method="post"
					onSubmit="return validate()" action="CsrCustomerController">
					<table align="center" width="30%">
						<tr>
							<td>Customer ID</td>
							<td height="50"><input type="text" name="customerId"
								value="${requestScope.customer.customerId}" /></td>
						</tr>
						<tr>
							<td>User name</td>
							<td height="50"><input type="text" name="userName"
								value="${requestScope.customer.userName}" /></td>
						</tr>
						<tr>
							<td>Password</td>
							<td height="50"><input type="text" name="password"
								value="${requestScope.customer.password}" /></td>
						</tr>
						<tr>
							<td>First Name</td>
							<td height="50"><input type="text" name="firstname"
								value="${requestScope.customer.firstname}" /></td>
						</tr>
						<tr>
							<td>Last Name</td>
							<td height="50"><input type="text" name="lastname"
								value="${requestScope.customer.lastname}" /></td>
						</tr>
						<tr>
							<td>Address</td>
							<td height="50"><input type="text" name="address"
								value="${requestScope.customer.address}" /></td>
						</tr>
						<tr>
							<td>City</td>
							<td height="50"><input type="text" name="city"
								value="${requestScope.customer.city}" /></td>
						</tr>
						<tr>
							<td>Postal Code</td>
							<td height="50"><input type="text" name="postalCode"
								value="${requestScope.customer.postalCode}" /></td>
						</tr>
					</table>
					<br>
					<br>
					<table align="center" width="10%">
						<tr>
							<td><input type="submit" name="submit" value="Edit" /></td>
							<td><input type="submit" name="submit" value="Add" /></td>
					</table>
				</form>

			</div>
		</div>
	</div>

</body>
</html>