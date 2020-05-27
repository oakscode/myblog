<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<div class="sidebar sidebar-main sidebar-default sidebar-fixed">
				<div class="sidebar-content">

					<!-- Main navigation -->
					<div class="sidebar-category sidebar-category-visible">
						<div class="category-content no-padding">
							<ul class="navigation navigation-main navigation-accordion">

								<!-- Main -->
								<c:forEach var="menu" items="${list.menu}">
									<li><a href="#"><i class="icon-stack2"></i> <span>${menu.title}</span></a>
										<ul>
											<c:forEach var="subMenu" items="${menu.post}">
												<li><a
													href="${menu.mc_slug}-${menu.slug}-${subMenu.id_be}">${subMenu.title}</a></li>
											</c:forEach>
										</ul></li>
								</c:forEach>


							</ul>
						</div>
					</div>
					<!-- /main navigation -->

				</div>
			</div>