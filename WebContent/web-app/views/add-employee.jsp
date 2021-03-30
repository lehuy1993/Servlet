<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="header.jsp"></jsp:include>

					<!-- End of Topbar -->
					<!-- Begin Page Content -->

					<div id="wait" class="col-lg-9 pr-0">

						<!-- Page Heading -->
						<h1 class="h3 mt-4 ml-4 mb-4 text-gray-800 border-bottom pb-4">Add
							Employee
							<c:if test="${message != null }">
							<p class="alert alert-warning">${message }</p>
							</c:if>
							</h1>
						<div class="card shadow mb-4 ml-4">
							<div class="card-header py-3">
								<h6 class="m-0 ">Content Frorm Elements</h6>
							</div>
							<div class="card-body">
								<form action="<%=request.getContextPath()%>/add-emp" method="post" name="frm-addEmp">
									<div class="form-group font-weight-bold">
										<label>Frist name <span class="text-danger">(*)</span></label>
										<input type="text" class="form-control" id="firsName"
											name="firsName" value="${employee.firsName }"
											placeholder="Frist name">
									</div>
									<div class="form-group font-weight-bold">
										<label>Last Name <span class="text-danger">(*)</span></label>
										<input type="text" class="form-control" name="lastName"
											value="${employee.lastName }" placeholder="Last Name">
									</div>
									<div class="form-group font-weight-bold">
										<label>Phone number<span class="text-danger">(*)</span></label>
										<input type="text" class="form-control" name="phone"
											value="${employee.phone }" placeholder="Phone number">
									</div>
									<div class="form-group font-weight-bold">
										<label>Date Of brith<span class="text-danger">(*)</span></label>
										<input type="date" class="form-control" name="dateOfBirth"
											value="${employee.dateOfBirth }" placeholder="mm/dd/yyyy">
									</div>
									<div class="form-group font-weight-bold">
										<label>Gender<span class="text-danger">(*)</span></label><br/>
										<div class="form-check-inline">
											<label class="form-check-label"> <input type="radio"
												class="form-check-input" value="0" name="gender">Female
											</label>
										</div>
										<div class="form-check-inline">
											<label class="form-check-label"> <input type="radio"
												class="form-check-input" value="1" name="gender">Male
											</label>
										</div>
									</div>
									<div class="form-group font-weight-bold">
										<label>Account<span class="text-danger">(*)</span></label> <input
											type="text" class="form-control" name="account"
											value="${account2.account }" placeholder="Account">
									</div>
									<div class="form-group font-weight-bold">
										<label>Email<span class="text-danger">(*)</span></label> <input
											type="text" class="form-control" name="email"
											value="${account2.email }" placeholder="Email">
									</div>
									<div class="form-group font-weight-bold">
										<label>Password<span class="text-danger">(*)</span></label> <input
											type="password" class="form-control" name="password"
											value="${account2.password }" placeholder="Password">
									</div>
									<div class="form-group font-weight-bold">
										<label for="exampleFormControlTextarea1">Address</label>
										<textarea class="form-control" name="address"
											value="${employee.address}" id="address" rows="3"></textarea>
									</div>
									<div class="form-group font-weight-bold">
										<label>Status</label><br/>
										<div class="form-check-inline ">
											<label class="form-check-label"> 
											<input type="checkbox" name="status" checked disabled class="form-check-input" value="0" >Active
											</label>
										</div>
									</div>
									<div class="form-group font-weight-bold">
										<label>Deparment<span class="text-danger">(*)</span></label> <input
											type="text" class="form-control" name="departmentName"
											value="${employee.departmentName }"
											placeholder="departmentName">
									</div>
									<div class="form-group font-weight-bold">
										<label for="exampleFormControlTextarea1">Remark</label>
										<textarea class="form-control" name="remark"
											value="" id="remark" rows="3"></textarea>
									</div>
									<button onclick="goBack()" class="btn btn-info"><i class="fa fa-backward" ></i> Go
										Back</button>



									<button type="reset" class="btn btn-warning"><i class="fa fa-history" ></i> Reset</button>
									<button type="submit" class="btn btn-success"><i class="fa fa-plus" ></i> Add</button>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
	<script>
function goBack() {
  window.history.back()
}
</script>
	

</html>