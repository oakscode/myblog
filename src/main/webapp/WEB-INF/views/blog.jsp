<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Oakscode-Blog</title>

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
<script type="text/javascript" src="assets/js/plugins/ui/prism.min.js"></script>
<script type="text/javascript" src="assets/js/core/app.js"></script>
<!-- /theme JS files -->

</head>

<body class="navbar-top navbar-bottom-xs">

	<!-- Main navbar -->
	<%@ include file="blognavbar.jsp"%>
	<!-- /main navbar -->


	<!-- Second navbar -->
	<div class="navbar navbar-default navbar-xs navbar-fixed-bottom">
		<ul class="nav navbar-nav no-border visible-xs-block">
			<li><a class="text-center collapsed" data-toggle="collapse"
				data-target="#navbar-second"><i class="icon-circle-up2"></i></a></li>
		</ul>

		<div class="navbar-collapse collapse" id="navbar-second">
			<div class="navbar-right">
				<ul class="nav navbar-nav">
					<li><a href="index" class="text-semibold">OAKSCODE</a></li>

					<li><a href="#">© 2020-2022</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <i class="icon-cog3"></i> <span
							class="visible-xs-inline-block position-right">Connect</span> <span
							class="caret"></span>
					</a>

						<ul class="dropdown-menu dropdown-menu-right">


							<c:forEach items="${list.connect}" var="var">

								<li><a href="${var.key_value}"><i class="${var.icon}"></i>
										${var.key_name}</a></li>
							</c:forEach>

						</ul></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- /second navbar -->


	<!-- Page container -->
	<div class="page-container">

		<!-- Page content -->
		<div class="page-content">

			<!-- Main sidebar -->
			<%@ include file="blogsidebar.jsp"%>
			<!-- /main sidebar -->


			<!-- Main content -->
			<div class="content-wrapper">


				<!-- Content area -->
				<div class="content">

					<div class="panel panel-flat">
						<div class="panel-body">


							<c:forEach items="${list.blog}" var="var">
						${var.body}
					</c:forEach>
						</div>
					</div>


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
