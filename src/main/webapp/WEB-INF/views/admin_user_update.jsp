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
									class="text-semibold">Home</span> - User E dit
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
								<h6 class="panel-title">Profile information</h6>
								<div class="heading-elements">
									<ul class="icons-list">
										<li><a data-action="collapse"></a></li>
										<li><a data-action="reload"></a></li>
										<li><a data-action="close"></a></li>
									</ul>
								</div>
							</div>

							<div class="panel-body">
								<form action="admin_user_update" method="post"
									enctype="multipart/form-data">
									<c:forEach items="${list.useredit}" var="var">


										<div class="form-group">
											<div class="row">
												<div class="col-md-6">
													<label>First Name</label> <input type="text"
														value="${var.fname}" class="form-control" name="fname">
												</div>
												<div class="col-md-6">
													<label>Last name</label> <input type="text"
														value="${var.lname}" class="form-control" name="lname">
												</div>
											</div>
										</div>

										<div class="form-group">
											<div class="row">
												<div class="col-md-6">
													<label>Email</label> <input type="text"
														value="${var.email}" class="form-control" name="email">
												</div>
												<div class="col-md-6">
													<label>Phone </label> <input type="text"
														value="${var.phone}" class="form-control" name="phone">
													<span class="help-block">Created on : ${var.con}</span>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-md-6">
													<label>Image </label> <input type="file" name="file"
														class="file-input">
												</div>
												<div class="col-md-6">
													<label>About </label>
													<textarea rows="5" cols="5" class="form-control"
														placeholder="Enter your message here" name="bio">${var.bio}</textarea>
												</div>
											</div>
										</div>

										<input type="hidden" value="${var.id_user}" name="id_user">

										<div class="text-right">
											<button type="submit" class="btn btn-primary">
												Save <i class="icon-arrow-right14 position-right"></i>
											</button>
										</div>
									</c:forEach>
								</form>
							</div>
						</div>
						<!-- /profile info -->
						<!-- Account settings -->
						<c:forEach items="${list.credential}" var="var">

							<div class="panel panel-flat">
								<div class="panel-heading">
									<h6 class="panel-title">Account settings</h6>
									<div class="heading-elements">
										<ul class="icons-list">
											<li><a data-action="collapse"></a></li>
											<li><a data-action="reload"></a></li>
											<li><a data-action="close"></a></li>
										</ul>
									</div>
								</div>

								<div class="panel-body">
									<form action="admin_cred_update">
										<div class="form-group">
											<div class="row">
												<div class="col-md-6">
													<label>Username</label> <input type="text"
														value="${var.username}" 
														class="form-control" name="username">
												</div>

												<div class="col-md-6">
													<label>Current password</label> <input type="text"
														value="${var.password}" 
														class="form-control" name="password">
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-md-6">
													<div class="checkbox">
														<label> <input type="checkbox" class="styled"
															checked="checked"> Active Status
														</label>
													</div>
												</div>
											</div>
										</div>
										<input type="hidden" value="${var.id_user}" name="id_user">
										<div class="text-right">
											<button type="submit" class="btn btn-primary">
												Save <i class="icon-arrow-right14 position-right"></i>
											</button>
										</div>
									</form>
								</div>
							</div>
						</c:forEach>
						<!-- /account settings -->

					</div>

					<div class="col-lg-3">

						<!-- User thumbnail -->

						<c:forEach items="${list.useredit}" var="var">
							<div class="thumbnail">
								<div class="thumb thumb-rounded thumb-slide">
									
										<img  src="get_user_image/<c:out value='${var.id_user}'/>" alt="">

									<div class="caption">
										<span> <a href="#"
											class="btn bg-success-400 btn-icon btn-xs"
											data-popup="lightbox"><i class="icon-plus2"></i></a> <a
											href="user_pages_profile.html"
											class="btn bg-success-400 btn-icon btn-xs"><i
												class="icon-x"></i></a>
										</span>
									</div>
								</div>

								<div class="caption text-center">
									<h6 class="text-semibold no-margin">
										${var.fname} ${var.lname} <small class="display-block">UX/UI
											designer</small>
									</h6>
									<ul class="icons-list mt-15">
										<li><a href="#" data-popup="tooltip" title="Google Drive"><i
												class="icon-google-drive"></i></a></li>
										<li><a href="#" data-popup="tooltip" title="Twitter"><i
												class="icon-twitter"></i></a></li>
										<li><a href="#" data-popup="tooltip" title="Github"><i
												class="icon-github"></i></a></li>
									</ul>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- /user thumbnail -->

					<!-- /main charts -->


					<!-- Dashboard content -->

					<!-- /dashboard content -->


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
