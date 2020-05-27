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
	src="assets/js/plugins/visualization/d3/d3.min.js"></script>
<script type="text/javascript"
	src="assets/js/plugins/visualization/d3/d3_tooltip.js"></script>
<script type="text/javascript"
	src="assets/js/plugins/forms/styling/switchery.min.js"></script>
<script type="text/javascript"
	src="assets/js/plugins/forms/styling/uniform.min.js"></script>
<script type="text/javascript"
	src="assets/js/plugins/forms/selects/bootstrap_multiselect.js"></script>
<script type="text/javascript"
	src="assets/js/plugins/ui/moment/moment.min.js"></script>
<script type="text/javascript"
	src="assets/js/plugins/pickers/daterangepicker.js"></script>
<script type="text/javascript"
	src="assets/js/plugins/ui/nicescroll.min.js"></script>

<script type="text/javascript" src="assets/js/core/app.js"></script>
<script type="text/javascript" src="assets/js/pages/dashboard.js"></script>
<script type="text/javascript"
	src="assets/js/pages/layout_fixed_custom.js"></script>

<!-- /theme JS files -->

</head>

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
									class="text-semibold">Home</span> - Add Category
							</h4>
						</div>
					</div>

				</div>
				<!-- /page header -->


				<!-- Content area -->
				<div class="content">

					<!-- Main charts -->

					<div class="col-lg-9">

						<!-- Profile info -->
						<div class="panel panel-flat">
							<div class="panel-heading">
								<h6 class="panel-title">Add Main category</h6>
							</div>

							<div class="panel-body">
								<form action="admin_add_main_cat" method="post"
									enctype="multipart/form-data">
									<div class="form-group">
										<div class="row">
											<div class="col-md-6">
												<label>Title</label> <input type="text" value=""
													class="form-control" name="title">
											</div>
										</div>
									</div>
									<div class="text-right">
										<button type="submit" class="btn btn-primary">
											Save <i class="icon-arrow-right14 position-right"></i>
										</button>
									</div>
								</form>
							</div>
						</div>



						<div class="panel panel-flat">



							<div class="panel-heading">
								<h6 class="panel-title">Add Sub category</h6>
							</div>

							<div class="panel-body">
								<form action="admin_add_sub_cat" method="post">

									<div class="form-group">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Select Category:</label> <select name="id_mc"
														data-placeholder="Select main category" class="select">

														<c:forEach items="${list.maincategory}" var="var">
															<option value="${var.id_mc}">${var.title}</option>
														</c:forEach>

													</select>
												</div>
												<label>Title</label> <input type="text" value=""
													class="form-control" name="title">
											</div>
										</div>
									</div>
									<div class="text-right">
										<button type="submit" class="btn btn-primary">
											Save <i class="icon-arrow-right14 position-right"></i>
										</button>
									</div>
								</form>
							</div>
						</div>
						
						<div class="panel panel-flat">



							<div class="panel-heading">
								<h6 class="panel-title">Add New Default Option</h6>
							</div>

							<div class="panel-body">
								<form action="admin_add_defaultoption" method="post">

									<div class="form-group">
										<div class="row">
											<div class="col-md-6">

												<label>key code</label> <input type="text" value="" class="form-control" name="key_code">
												<label>key name</label> <input type="text" value="" class="form-control" name="key_name">
												<label>key value</label> <input type="text" value="" class="form-control" name="key_value">
												<label>icon</label> <input type="text" value="" class="form-control" name="icon">
										
											</div>
										</div>
									</div>
									<div class="text-right">
										<button type="submit" class="btn btn-primary">
											Save <i class="icon-arrow-right14 position-right"></i>
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>



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
