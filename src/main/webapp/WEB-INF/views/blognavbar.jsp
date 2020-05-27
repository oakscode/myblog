<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<div class="navbar navbar-inverse bg-teal navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="/oakscode/"><img
				src="assets/images/logo_light.png" alt=""></a>

			<ul class="nav navbar-nav pull-right visible-xs-block">
				<li><a data-toggle="collapse" data-target="#navbar-mobile"><i
						class="icon-tree5"></i></a></li>
				<li><a class="sidebar-mobile-main-toggle"><i
						class="icon-paragraph-justify3"></i></a></li>
			</ul>
		</div>

		<div class="navbar-collapse collapse" id="navbar-mobile">
			<ul class="nav navbar-nav navbar-left">
				

				<c:forEach items="${list.maincategory}" var="var">
					<li><a href="${var.slug}">${var.title}</a></li>
				</c:forEach>
				
				<li><a href="about">About</a></li>
				
				<!-- class="active" for active menu -->

			</ul>
		</div>
	</div>


    