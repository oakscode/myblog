<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Oakscode</title>

<!-- Global stylesheets -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900"
	rel="stylesheet" type="text/css">
<link href="assets/css/icons/icomoon/styles.css" rel="stylesheet"
	type="text/css">
<link href="assets/css/minified/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="assets/css/minified/core.min.css" rel="stylesheet"
	type="text/css">
<link href="assets/css/minified/components.min.css" rel="stylesheet"
	type="text/css">
<link href="assets/css/minified/colors.min.css" rel="stylesheet"
	type="text/css">
<!-- /global stylesheets -->

<!-- Core JS files -->
<script type="text/javascript"
	src="assets/js/plugins/loaders/pace.min.js"></script>
<script type="text/javascript"
	src="assets/js/core/libraries/jquery.min.js"></script>
<script type="text/javascript"
	src="assets/js/core/libraries/bootstrap.min.js"></script>
<script type="text/javascript"
	src="assets/js/plugins/loaders/blockui.min.js"></script>
<!-- /core JS files -->

<!-- Theme JS files -->

<script type="text/javascript"
	src="assets/js/plugins/tables/datatables/datatables.min.js"></script>
<script type="text/javascript"
	src="assets/js/plugins/forms/selects/select2.min.js"></script>

<script type="text/javascript" src="assets/js/core/app.js"></script>
<script type="text/javascript"
	src="assets/js/pages/datatables_sorting.js"></script>
<!-- /theme JS files -->

</head>

<script>
function pass_data(id)
{
var name=document.getElementById(id).value;
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
       // Typical action to be performed when the document is ready:
       document.getElementById("response_result").innerHTML = xhttp.responseText;
    }
};
xhttp.open("GET", "updatepriority?value="+name+"&id="+id, true);
xhttp.send();
}
</script>

<body class="navbar-top">

	<!-- Main navbar -->
	<%@ include file="mainnavbar.jsp"%>
	<!-- /main navbar -->


	<!-- Page container -->
	<div class="page-container">

		<!-- Page content -->
		<div class="page-content">

			<!-- Main sidebar -->
			<%@ include file="mainsidenavbar.jsp"%>
			<!-- /main sidebar -->


			<!-- Main content -->
			<div class="content-wrapper">

				<!-- Page header -->
				<div class="page-header">
					<div class="page-header-content">
						<div class="page-title">
							<h4>
								<i class="icon-arrow-left52 position-left"></i> <span
									class="text-semibold">Home</span> - Edit Default Option
							</h4>
						</div>
					</div>
				</div>
				<!-- /page header -->


				<!-- Content area -->
				<div class="content">

					<div class="panel panel-flat">
						<div class="panel-heading">
							<h5 class="panel-title">Links </h5>
						</div>


						<table class="table datatable-sorting">
							<thead>
								<tr>
									<th>Key Code</th>
									<th>Key Name</th>
									<th>key Value</th>
									<th>Css icon</th>
									<th>Edit</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list.defaultoption}" var="var">
								
									<tr>
									
									
									
										<td>${var.key_code}</td>
										<td>${var.key_name}</td>
										<td>${var.key_value}</td>
										<td>${var.icon}</td>
										<td class="text-center">
											<ul class="icons-list">
												<li class="dropdown"><a href="#"
													class="dropdown-toggle" data-toggle="dropdown"> <i
														class="icon-menu9"></i>
												</a>

													<ul class="dropdown-menu dropdown-menu-right">
														<li><a href=""><i class="icon-cog6"></i>Edit</a></li>
														<li><a href="deletedefaultoption?id=${var.key_name}"><i class="icon-cancel-circle2"></i>Remove</a></li>
													</ul></li>
											</ul>
										</td>
									
									</tr>
								
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /default ordering -->


					<!-- Footer -->
					<!-- /footer -->

				</div>
				<!-- /content area -->

			</div>
			<!-- /main content -->

		</div>
		<!-- /page content -->

	</div>
	<!-- /page container -->

</body>
</html>
