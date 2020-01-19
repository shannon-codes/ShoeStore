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
		<a class="py-2" href="#"> <svg xmlns="http://www.w3.org/2000/svg"
				width="24" height="24" viewBox="0 0 24 24" fill="none"
				stroke="currentColor" stroke-width="2" stroke-linecap="round"
				stroke-linejoin="round" class="d-block mx-auto">
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






	<div
		class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
		<div class="col-md-5 p-lg-5 mx-auto my-5">
		
		
			<form method="get" action="LoginThird.jsp">
				<input type="radio" value="user" name="login"> USER
				<!-- onClick="location.href='UserLogin.jsp'" -->
				<input type="radio" value="csr" name="login"> ADMIN <input
					type="submit" value="choose">
			</form>
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
