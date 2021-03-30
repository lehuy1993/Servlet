<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


					<!-- Sidebar -->
	<jsp:include page="header.jsp"></jsp:include>
					<!-- End of Topbar -->
					<!-- Begin Page Content -->

					<div id="wait" class="col-lg-9 pr-0">
						<!-- Page Heading -->
						<h1 class="  h3 mt-4 ml-4 mb-4 text-gray-800 border-bottom pb-4">Employee
							List</h1>
						<!-- From search -->
						<div class="col-lg-12  d-flex flex-row-reverse">
							<form class=" form-inline action="<%=request.getContextPath()%>/login" ">
								<div class="input-group ">
									<div class="input-group-prepend btn-light ">
										<span class="input-group-text " id="basic-addon1 "><i
											class="fa fa-search " aria-hidden="true "></i></span>
									</div>
									<input type="text " class="form-control "
										placeholder="Username " aria-label="Username "
										aria-describedby="basic-addon1 ">

								</div>
								<div class="input-group ml-3 mr-3 ">
									<div class="input-group-prepend ">
										<div class="input-group-text bg-light ">
											<i class="fa fa-filter " aria-hidden="true "> Filter By </i>
										</div>
									</div>
									<select class="form-control text-justify "
										id="exampleFormControlSelect1 ">
										<option>Name</option>
										<option>Date of birth</option>
										<option>Address</option>
										<option>Phone number</option>
										<option>Department</option>
									</select>
								</div>
								<button type="submit " class="btn btn-primary ">Submit</button>
							</form>
						</div>
						<div class="col-lg-12 ">
							<table id="table " class="table table-bordered ">
								<thead>
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Gender</th>
										<th>Date of birth</th>
										<th>Address</th>
										<th>Phone number</th>
										<th>Department</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${employees != null}">
										<c:forEach var="employee" items="${employees}">

											<tr>
												<td>${employee.employeeId}</td>
												<td>${employee.firsName}</td>
												<td>${employee.gender == 1 ? 'Male' : 'Female'}</td>
												<td>${employee.dateOfBirth}</td>
												<td>${employee.address}</td>
												<td>${employee.phone}</td>
												<td>${employee.departmentName}</td>
												<td><a href="#"><i class="fa fa-eye"
														aria-hidden="true"></i> View</a></td>


											</tr>
										</c:forEach>
									</c:if>

								</tbody>

							</table>

							<nav aria-label="...">
								<ul class="pagination">
									<c:if test="${currentPage != 1 }">
										<li class="page-item "><a class="page-link"
											href="list-employees?page=${currentPage - 1}" tabindex="-1">Previous</a></li>
									</c:if>
									<c:forEach begin="1" end="${numberOfPages}" var="i">
										<c:choose>
											<c:when test="${currentPage eq i }">
												<li class="page-item active"><a class="page-link">${i }
														<span class="sr-only">(current)</span>
												</a></li>
											</c:when>
											<c:otherwise>
												<li class="page-item "><a class="page-link"
													href="list-employees?page=${i}">${i} </a></li>
											</c:otherwise>
										</c:choose>

									</c:forEach>
									<c:if test="${currentPage lt  numberOfPages }">
										<li class="page-item"><a class="page-link"
											href="list-employees?page=${currentPage + 1}">Next</a>
									</c:if>

									</li>
								</ul>
							</nav>
						</div>
					</div>

				</div>


			</div>

		</div>
		
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>