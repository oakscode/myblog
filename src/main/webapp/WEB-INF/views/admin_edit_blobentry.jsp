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
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript"
	src="assets/js/plugins/forms/selects/select2.min.js"></script>

<script type="text/javascript" src="assets/js/core/app.js"></script>
<script type="text/javascript" src="assets/js/pages/editor_ckeditor.js"></script>
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
									class="text-semibold">Editors</span> - CKEditor
							</h4>
						</div>
					</div>
				</div>
				<!-- /page header -->


				<!-- Content area -->
				<div class="content">
					<!-- CKEditor default -->
					<div class="panel panel-flat">
						<div class="panel-heading">
							<h5 class="panel-title">Full featured CKEditor</h5>
						</div>

						<div class="panel-body">
							<p class="content-group">CKEditor is a ready-for-use HTML
								text editor designed to simplify web content creation. It's a
								WYSIWYG editor that brings common word processor features
								directly to your web pages. It benefits from an active community
								that is constantly evolving the application with free add-ons
								and a transparent development process.</p>
							<form action="editblog" method="post"
								enctype="multipart/form-data">
								<c:forEach items="${list.post}" var="var">

									<div class="content-group">


										<div class="form-group">
											<div class="row">
												<div class="col-md-6">
													<label>Main Title</label> <input type="text"
														value="${var.title}" class="form-control" name="title">
												</div>
												<div class="col-md-6">
													<label>Cover photo :</label> <input type="file"
														class="form-control" name="file">
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>Description</label>
													<textarea name="desc" class="form-control" rows="4"
														cols="4">
														${var.desc}
												</textarea>

												</div>
											</div>
										</div>

										<input type="hidden" name="id_sc" value="${var.id_sc}">
										<input type="hidden" name="id_be" value="${var.id_be}">

										<textarea name="body" id="editor-full" rows="4" cols="4">
											${var.body}
						           	    </textarea>
									</div>

									<div class="text-right">
										<button type="submit" class="btn bg-teal-400">
											Submit form <i class="icon-arrow-right14 position-right"></i>
										</button>
									</div>
								</c:forEach>
							</form>
						</div>
					</div>
					<!-- /CKEditor default -->
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
