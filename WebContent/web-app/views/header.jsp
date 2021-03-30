	
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Blank</title>

<!-- Custom fonts for this template-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/web-app/resources/css/stylecss.css">
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">
	<nav
			class=" border-bottom navbar navbar-light bg-light justify-content-between pb-0">
			<a class="navbar-brand">CMS</a>
			<div class="btn-group">
				Wellcome ${userLogin }
				<button type="button" class="btn btn-light dropdown-toggle"
					data-toggle="dropdown" data-display="static" aria-haspopup="true"
					aria-expanded="false">
					<i class="fa fa-user" aria-hidden="true"></i>
				</button>
				<div class="dropdown-menu ">

					<a class="dropdown-item" 
						href="<%=request.getContextPath()%>/logout"><i
						class="fa fa-sign-out" aria-hidden="true"></i>Logout</a>
				</div>
			</div>
		</nav>

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="wrapper">
				<div class="row m-0">
					<!-- Topbar -->
					<div class=" sidebar w-30 bg-light border-right ">
						<nav class="  navbar-light  sidebar-collapse">
							<!-- Topbar Search -->
							<form class="form-inline p-3 ">
								<div class="input-group ">
									<input type="text " class="form-control "
										placeholder="Username " aria-label="Username "
										aria-describedby="basic-addon1 ">
									<div class="input-group-prepend btn-light ">
										<span class="input-group-text " id="basic-addon1 "><i
											class="fa fa-search " aria-hidden="true "></i></span>
									</div>
								</div>
							</form>
							<ul class="nav flex-column    ">
								<li class="nav-item "><a class="nav-link" href="#"
									data-toggle="collapse" data-target="#collapseTwo"><i
										class="fa fa-bar-chart" aria-hidden="true"></i> Employee
										manager <i class="fa fa-angle-down nav-link"
										aria-hidden="true"></i> </a>
									<div data-toggle="collapse" data-target="#demo"
										id="collapseTwo" class="collapse "
										aria-labelledby="headingTwo" data-parent="#accordionSidebar"
										style="">
										<div class=" py-2 collapse-inner rounded">
											<a class="nav-link" id="listEmpsLink" href="<%=request.getContextPath()%>/list-employees"><i
												class="fa fa-list"></i> Employee list</a><br /> 
												<a  href="<%=request.getContextPath()%>/add-emp" class="nav-link" id= "addEmpLink"><i class="fa fa-plus"></i>
												Add Employee</a>
										</div>
									</div></li>

							</ul>
						</nav>
					</div>