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
xhttp.open("GET", "updatebepriority?value="+name+"&id="+id, true);
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
									class="text-semibold">Home</span> Main Category -> Sub Category -> Blog Post
							</h4>
						</div>
					</div>
				</div>
				<!-- /page header -->


				<!-- Content area -->
				<div class="content">

					<div class="panel panel-flat">
						<div class="panel-heading">
							<h5 class="panel-title">Blog Post</h5>
							<div class="heading-elements">
								<ul class="icons-list">
									<li><a data-action="collapse"></a></li>
									<li><a data-action="reload"></a></li>
									<li><a data-action="close"></a></li>
								</ul>
							</div>
						</div>



						<table class="table datatable-sorting">
							<thead>
								<tr>
									<th>id_be</th>
									<th>id_sc</th>
									<th>by</th>
									<th>title</th>
									<th>active</th>
									<th>priority</th>
									<th>Edit Post</th>
									<th class="text-center">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list.blogs}" var="var">
									<tr>
										<td>${var.id_be}</td>
										<td>${var.id_sc}</td>
										<td>${var.id_user}</td>
										<td> ${var.title}</td>
										<td>${var.active}</td>
										<td>
										
										<input type="text" value="${var.priority }"
											class="form-control" name="title" id="${var.id_be}"
											style="border: 1px solid #73AD21; width: 60px; height: 20px;" onblur="pass_data(this.id)">
										
										</td>
										<td><a href="editblog?id_sc=${var.id_sc}&id_be=${var.id_be}"> <i class="icon-pencil7"></i></a></td>
										
										<td class="text-center">
											<ul class="icons-list">
												<li class="dropdown"><a href="#"
													class="dropdown-toggle" data-toggle="dropdown"> <i
														class="icon-menu9"></i>
												</a>

													<ul class="dropdown-menu dropdown-menu-right">
														<li><a href=""><i class="icon-cog6"></i>Edit</a></li>
														<li><a href="deletepost?id_sc=${var.id_sc}&id_be=${var.id_be}"><i class="icon-cancel-circle2"></i>Remove</a></li>
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
