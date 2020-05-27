<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Main sidebar -->
	<div class="sidebar sidebar-main sidebar-fixed">
		<div class="sidebar-content">

			<!-- User menu -->
			<div class="sidebar-user">
			<c:forEach items="${list.user}" var="var">
				<div class="category-content">
					<div class="media">
						<a href="#" class="media-left"><img
							src="get_user_image/<c:out value='${var.id_user}'/>" class="img-circle img-sm"
							alt="">
							</a>
						<div class="media-body">
							
								<span class="media-heading text-semibold">${var.fname}</span>
								<!-- <div class="text-size-mini text-muted">
									<i class="icon-pin text-size-small"></i> &nbsp;Santa Ana, CA
								</div> -->
							
						</div>

						<div class="media-right media-middle">
							<ul class="icons-list">
								<li><a href="#"><i class="icon-cog3"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<!-- /user menu -->


			<!-- Main navigation -->
			<div class="sidebar-category sidebar-category-visible">
				<div class="category-content no-padding">
					<ul class="navigation navigation-main navigation-accordion">

						<!-- Main -->
						<li class="navigation-header"><span>Main</span> <i
							class="icon-menu" title="Main pages"></i></li>
						<li><a href="dashboard"><i class="icon-home4"></i> <span>Dashboard</span></a></li>
						<li><a href="admin_list_cat"><i class="icon-home4"></i> <span>Blog Management</span></a></li>
						<li><a href="admin_user_mngt"><i class="icon-copy"></i> <span>User Management</span></a></li>
						<li><a href="admin_add_main_cat"><i class="icon-copy"></i> <span>Add New Category</span></a></li>
						<li><a href="admin_edit_priority"><i class="icon-copy"></i> <span>Edit Priority</span></a></li>
						<li><a href="admin_edit_defaultoption"><i class="icon-copy"></i> <span>Edit Default Options</span></a></li>
						
			<!-- 			<li><a href="#"><i class="icon-copy"></i> <span>Category Management</span></a>
							<ul>
							
								<li><a href="admin_add_main_cat" id="layout2">Add Category</a></li>
								<li><a href="admin_list_cat" id="layout4">List All </a></li>

							</ul></li> -->

					</ul>
				</div>
			</div>
			<!-- /main navigation -->

		</div>
	</div>
</body>
</html>