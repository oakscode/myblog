<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>oakscode-Home</title>

	<!-- Global stylesheets -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet" type="text/css">
	<link href="assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
    <link href="assets/css/minified/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="assets/css/minified/core.min.css" rel="stylesheet" type="text/css">
	<link href="assets/css/minified/components.min.css" rel="stylesheet" type="text/css">
	<link href="assets/css/minified/colors.min.css" rel="stylesheet" type="text/css">
	<!-- /global stylesheets -->

	<!-- Core JS files -->
	<script type="text/javascript" src="assets/js/core/libraries/jquery.min.js"></script>
	<script type="text/javascript" src="assets/js/core/libraries/bootstrap.min.js"></script>
	<!-- /core JS files -->

	<!-- Theme JS files -->
	<script type="text/javascript" src="assets/js/plugins/ui/drilldown.js"></script>

	<script type="text/javascript" src="assets/js/core/app.js"></script>
	<!-- /theme JS files -->

</head>

<body class="navbar-top">

	<!-- Main navbar -->
	<%@ include file="blognavbar.jsp" %>
	<!-- /main navbar -->


	<!-- Page container -->
	<div class="page-container">

		<!-- Page content -->
		<div class="page-content" >

			<!-- Main content -->
			<div class="content-wrapper">

				<!-- Page header -->

				<!-- /page header -->


				<!-- Content area -->
				<div class="content" >
				
				<!-- Icomoon icon set -->
					<div class="panel panel-flat">
						<div class="panel-body">
						
						

					<h6 class="content-group text-semibold">
						Latest Uploads
					</h6>

	
					<div class="row">
					  <c:forEach items="${list.thumb}" var="var">
						
						<div class="col-lg-3 col-sm-6">
							<div class="thumbnail">
								<div class="thumb">
									<img  src="get_thumb_image/<c:out value='${var.id_be}'/>" alt="">
								</div>

								<div class="caption">
									<h6 class="no-margin-top text-semibold"><a href="${var.mc_slug}-${var.sc_slug}-${var.id_be}" class="text-default">${var.title}</a> <a href="#" class="text-muted"></a></h6>
									${var.desc}
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
					<!-- /thumbnail examples -->
					<!-- Icomoon icon set -->
					<div class="panel panel-flat">
						<div class="panel-body">

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