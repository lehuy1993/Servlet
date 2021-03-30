<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-5">
				<div class="card shadow-lg border-0 rounded-lg mt-5">
					<div class="card-header">
						<h4 class="font-weight-light">Please Sign In</h4>
						<c:if test="${msg != null }">
							<p class="alert alert-warning">${msg }</p>
						</c:if>
					</div>
					<div class="card-body">
						<form action="<%=request.getContextPath()%>/login" id="loginFrom"
							method="post">
							<div class="form-group">
								<input class="form-control py-4" name="userName"
									id="inputUserName" type="text" required placeholder="Username">
								<div class="invalid-feedback">Please choose a username.</div>
							</div>
							<div class="form-group">
								<input class="form-control py-4" name="password"
									id="inputPassword" required type="password"
									placeholder="Password">
								<div class="invalid-feedback">Please choose a password.</div>
							</div>

							<div>
								<input type="submit" onclick="validateLogin()"
									class="btn btn-success btn-lg btn-block" value="Login"></input>

							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/web-app/resources/js/myjs.js"></script>

</body>

</html>