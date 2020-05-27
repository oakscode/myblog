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
									class="text-semibold">Home</span> - Edit Main category priority
							</h4>
						</div>
					</div>
				</div>
				<!-- /page header -->


				<!-- Content area -->
				<div class="content">

					<div class="panel panel-flat">
						<div class="panel-heading">
							<h5 class="panel-title">Main Category</h5>
						</div>


						<table class="table datatable-sorting">
							<thead>
								<tr>
									<th>id_mc</th>
									<th>by</th>
									<th>title</th>
									<th>active</th>
									<th>priority</th>
									<th>Sub Categories</th>
									<th>Update</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list.maincategory}" var="var">
								
									<tr>
									
									
									
										<td>${var.id_mc}</td>
										<td>${var.id_user}</td>
										<td><a href="admin_list_subcat?id=${var.id_mc}">${var.title}</a></td>
										
										<td><input type="text" value="${var.active}"
											class="form-control" name="title"
											style="border: 1px solid #f56733; width: 60px; height: 20px;">
										</td>
										
										<td><input type="text" value="${var.priority}"
											class="form-control" name="title" id="${var.id_mc}"
											style="border: 1px solid #73AD21; width: 60px; height: 20px;" onblur="pass_data(this.id)">
										</td>
										<td>${var.countsc}</td>
										<td><button type="submit">Update</button></td>
									</tr>
								
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /default ordering -->


					<!-- Footer -->
					<div class="footer text-muted">
						&copy; 2015. <a href="#">Limitless Web App Kit</a> by <a
							href="http://themeforest.net/user/Kopyov" target="_blank">Eugene
							Kopyov</a>
					</div>
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
