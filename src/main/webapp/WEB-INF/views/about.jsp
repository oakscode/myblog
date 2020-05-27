<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Oakscode-About</title>

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

			<!-- Main content -->
			<div class="content-wrapper">


				<!-- Content area -->
				<div class="content">


					<%-- <c:forEach items="${list.blog}" var="var">
						${var.body}
					</c:forEach> --%>
					<!-- Icomoon icon set -->
					<div class="panel panel-flat">
						<div class="panel-body">
							

												
<header class="post-header" style="box-sizing: border-box; margin-bottom: 30px; text-align: center; color: rgba(0, 0, 0, 0.87); font-family: &quot;Open Sans&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 19px;">
<h1 class="post-title" style="box-sizing: border-box; font-size: 2em; margin: 0px 0px 15px; padding: 0px; font-weight: 600; line-height: 1.3;">About Oakscode</h1>
</header>

<div class="post-content" style="box-sizing: border-box; margin-bottom: 30px; color: rgba(0, 0, 0, 0.87); font-family: &quot;Open Sans&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 19px;">
<figure class="about-image" style="box-sizing: border-box; display: block; margin: 0px 0px 15px 15px; padding: 0px; width: 230px; float: right;"><picture style="box-sizing: border-box;"><source media="(max-width: 520px)" srcset="assets/images/vishnu.jpeg" style="box-sizing: border-box;" /><img alt="About oakscode" src="assets/images/vishnu.jpeg" style="box-sizing: border-box; border-style: none; max-width: 100%; vertical-align: middle; border-radius: 5px; margin-bottom: 15px;" /></picture></figure>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">Dear Readers, Welcome to the oakscode blog.</p>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">My name is Vishnu P venugopal. I&rsquo;m the founder, designer and editor of this blog.</p>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">I work as a Java Proggrammer at <a href="http://www.supplycokerala.com">Civil supplies Corporation</a>, Southeast India.</p>

<h2 id="about-callicoder" style="box-sizing: border-box; margin: 30px 0px; padding: 0px; font-weight: 600; font-size: 1.5em; line-height: 1.3; position: relative;">About Oakscode<a class="header-link" href="https://www.callicoder.com/about/#about-callicoder" style="box-sizing: border-box; background-color: transparent; color: rgb(65, 155, 232); text-decoration-line: none; overflow-wrap: break-word; position: absolute; top: 0px; left: -40px; padding: 5px 8px 5px 5px; opacity: 0; font-size: 0.8em; margin-left: 5px; transition: opacity 0.2s ease-in-out 0.1s;"><svg height="24" viewbox="0 0 24 24" width="24"><path d="M10.59,13.41C11,13.8 11,14.44 10.59,14.83C10.2,15.22 9.56,15.22 9.17,14.83C7.22,12.88 7.22,9.71 9.17,7.76V7.76L12.71,4.22C14.66,2.27 17.83,2.27 19.78,4.22C21.73,6.17 21.73,9.34 19.78,11.29L18.29,12.78C18.3,11.96 18.17,11.14 17.89,10.36L18.36,9.88C19.54,8.71 19.54,6.81 18.36,5.64C17.19,4.46 15.29,4.46 14.12,5.64L10.59,9.17C9.41,10.34 9.41,12.24 10.59,13.41M13.41,9.17C13.8,8.78 14.44,8.78 14.83,9.17C16.78,11.12 16.78,14.29 14.83,16.24V16.24L11.29,19.78C9.34,21.73 6.17,21.73 4.22,19.78C2.27,17.83 2.27,14.66 4.22,12.71L5.71,11.22C5.7,12.04 5.83,12.86 6.11,13.65L5.64,14.12C4.46,15.29 4.46,17.19 5.64,18.36C6.81,19.54 8.71,19.54 9.88,18.36L13.41,14.83C14.59,13.66 14.59,11.76 13.41,10.59C13,10.2 13,9.56 13.41,9.17Z"></path></svg></a></h2>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">Oakscode is a computer science education blog where I write about programming languages, web development, desktop app development and system design.</p>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">I started this blog so that I can share whatever I learn during my day-to-day job with other programmers. It gives me immense pleasure when people read my articles and say that It has helped them.</p>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">Moreover, This blog helps me organize my thoughts and improve my overall knowledge because It forces me to do thorough research before writing any article.</p>

<h2 id="what-does-callicoder-mean" style="box-sizing: border-box; margin: 30px 0px; padding: 0px; font-weight: 600; font-size: 1.5em; line-height: 1.3; position: relative;">What does Oakscode mean?<a class="header-link" href="https://www.callicoder.com/about/#what-does-callicoder-mean" style="box-sizing: border-box; background-color: transparent; color: rgb(65, 155, 232); text-decoration-line: none; overflow-wrap: break-word; position: absolute; top: 0px; left: -40px; padding: 5px 8px 5px 5px; opacity: 0; font-size: 0.8em; margin-left: 5px; transition: opacity 0.2s ease-in-out 0.1s;"><svg height="24" viewbox="0 0 24 24" width="24"><path d="M10.59,13.41C11,13.8 11,14.44 10.59,14.83C10.2,15.22 9.56,15.22 9.17,14.83C7.22,12.88 7.22,9.71 9.17,7.76V7.76L12.71,4.22C14.66,2.27 17.83,2.27 19.78,4.22C21.73,6.17 21.73,9.34 19.78,11.29L18.29,12.78C18.3,11.96 18.17,11.14 17.89,10.36L18.36,9.88C19.54,8.71 19.54,6.81 18.36,5.64C17.19,4.46 15.29,4.46 14.12,5.64L10.59,9.17C9.41,10.34 9.41,12.24 10.59,13.41M13.41,9.17C13.8,8.78 14.44,8.78 14.83,9.17C16.78,11.12 16.78,14.29 14.83,16.24V16.24L11.29,19.78C9.34,21.73 6.17,21.73 4.22,19.78C2.27,17.83 2.27,14.66 4.22,12.71L5.71,11.22C5.7,12.04 5.83,12.86 6.11,13.65L5.64,14.12C4.46,15.29 4.46,17.19 5.64,18.36C6.81,19.54 8.71,19.54 9.88,18.36L13.41,14.83C14.59,13.66 14.59,11.76 13.41,10.59C13,10.2 13,9.56 13.41,9.17Z"></path></svg></a></h2>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">Everyone who hears the name callicoder asks me what does it mean?</p>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">Well, &nbsp;&#39;Oak&#39; was an older name of java project&nbsp; thats why i choose oakcode :P&nbsp;&nbsp;</p>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">The Logo of this blog is built around the idea of Zen symbol.</p>

<blockquote style="box-sizing: border-box; margin: 0px 0px 15px; padding: 20px 0px 20px 15px; border-left-width: 6px; border-left-color: rgb(8, 178, 127); line-height: 1.8;">
<p style="box-sizing: border-box; margin: 0px; padding: 0px;"><span style="box-sizing: border-box; font-weight: 600;">In Zen, ensō (&ldquo;circle&rdquo;) is a circle that is hand-drawn in one or two uninhibited brushstrokes to express a moment when the mind is free to let the body create.</span>&nbsp;(<em style="box-sizing: border-box;">Excerpt from&nbsp;<a href="https://en.wikipedia.org/wiki/Ens%C5%8D" style="box-sizing: border-box; background-color: transparent; color: rgb(65, 155, 232); text-decoration-line: none; overflow-wrap: break-word;">wikipedia</a></em>)</p>
</blockquote>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">&nbsp;</p>

<center style="box-sizing: border-box;"><svg height="250px" version="1.1" viewbox="0 0 50 50" width="250px" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><defs></defs><g fill="none" fill-rule="evenodd" id="Page-1" stroke="none" stroke-width="1"><g fill="#000000" fill-rule="nonzero" id="noun_185803_cc"><g id="Group"><g id="Shape"><path d="M35.5789349,42.2699132 C38.9825808,40.095434 39.1716433,40.2839757 37.3752891,41.607934 C35.5789349,42.9308507 38.7935183,41.0407465 37.0919558,42.2699132 L36.3357058,43.0261632 C36.3357058,43.0261632 35.1065391,44.4443924 34.2554974,44.5386632 C33.4044558,44.632934 35.2002891,44.4443924 33.9716433,45.0121007 C32.7424766,45.5787674 23.7502891,49.636059 9.2008099,39.0553299 C13.2669558,45.8626215 20.4518516,48.8881424 26.5028933,48.9824132 C26.5028933,48.9824132 24.6112266,48.9824132 25.6518516,49.1714757 C26.6919558,49.3605382 25.1789349,50.7782465 16.2914349,47.4699132 C16.6706016,48.320434 16.7648724,48.6037674 17.8049766,49.1714757 C17.8049766,49.1714757 6.1752891,45.2001215 2.11070578,33.4772049 C2.20497661,34.8949132 2.29924745,36.5027257 2.29924745,36.5027257 C2.29924745,36.5027257 -3.56325255,26.1022049 3.43414328,13.2443924 C10.4304974,0.38657986 25.8414349,-0.08581598 27.9211224,0.00845486 C30.0013308,0.10272569 41.6294558,2.75012152 44.2768516,5.492309 C46.9247683,8.2334549 42.9539349,6.4376215 42.9539349,6.4376215 C42.9539349,6.4376215 41.6294558,7.1938715 43.8049766,8.3277257 C45.9789349,9.4631424 48.3424766,13.2443924 46.5456016,11.8261632 C44.7497683,10.4084549 47.3966433,13.5282465 47.6804974,13.717309 C47.9638308,13.9063715 43.7096641,11.8261632 44.8445599,13.0553299 C45.9789349,14.2839757 50.8950808,19.673559 49.2883099,21.2813715 C47.6804974,22.8881424 47.1127891,18.4443924 46.8294558,18.161059 C46.5456016,17.876684 47.3034141,24.6844965 46.8294558,25.8183507 C46.3565391,26.9532465 46.4513308,23.2667882 45.5065391,22.1318924 C44.5612266,20.9975174 44.2768516,21.0917882 43.6148724,21.0917882 C42.9539349,21.0917882 41.1575808,19.2959549 40.9679974,18.2553299 C40.7789349,17.2152257 40.2117474,16.9313715 39.3601849,16.0808507 C38.5096641,15.229809 37.1862266,14.3792882 35.5789349,14.473559 C33.9716433,14.5683507 34.8226849,12.5824132 32.0804974,12.5824132 C29.3388308,12.5824132 27.7310183,12.1105382 25.3679974,13.1501215 C23.0049766,14.1902257 18.6554974,15.4188715 18.2768516,15.5131424 C17.8987266,15.607934 22.2476849,13.1501215 22.9101849,12.7714757 C23.5716433,12.3938715 12.6044558,15.229809 10.8081016,19.5787674 C9.0112266,23.9287674 7.4049766,31.3969965 13.5502891,38.2037674 C19.6956016,45.0121007 30.6622683,45.6730382 35.5789349,42.2699132"></path></g></g></g></g></svg></center>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">&nbsp;</p>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">The above icon is built by&nbsp;<a href="https://thenounproject.com/nickbluth/" style="box-sizing: border-box; background-color: transparent; color: rgb(65, 155, 232); text-decoration-line: none; overflow-wrap: break-word;">Nick Bluth</a>&nbsp;of the&nbsp;<a href="https://thenounproject.com/" style="box-sizing: border-box; background-color: transparent; color: rgb(65, 155, 232); text-decoration-line: none; overflow-wrap: break-word;">noun project</a>&nbsp;(credits to him for this awesome icon). I customized this icon further to create the logo of my blog.</p>

<h3 id="what-powers-this-blog" style="box-sizing: border-box; margin: 30px 0px; padding: 0px; font-weight: 600; font-size: 1.25em; line-height: 1.3; position: relative;">What powers this blog?<a class="header-link" href="" style="box-sizing: border-box; background-color: transparent; color: rgb(65, 155, 232); text-decoration-line: none; overflow-wrap: break-word; position: absolute; top: 0px; left: -40px; padding: 5px 8px 5px 5px; opacity: 0; font-size: 0.8em; margin-left: 5px; transition: opacity 0.2s ease-in-out 0.1s;"><svg height="24" viewbox="0 0 24 24" width="24"><path d="M10.59,13.41C11,13.8 11,14.44 10.59,14.83C10.2,15.22 9.56,15.22 9.17,14.83C7.22,12.88 7.22,9.71 9.17,7.76V7.76L12.71,4.22C14.66,2.27 17.83,2.27 19.78,4.22C21.73,6.17 21.73,9.34 19.78,11.29L18.29,12.78C18.3,11.96 18.17,11.14 17.89,10.36L18.36,9.88C19.54,8.71 19.54,6.81 18.36,5.64C17.19,4.46 15.29,4.46 14.12,5.64L10.59,9.17C9.41,10.34 9.41,12.24 10.59,13.41M13.41,9.17C13.8,8.78 14.44,8.78 14.83,9.17C16.78,11.12 16.78,14.29 14.83,16.24V16.24L11.29,19.78C9.34,21.73 6.17,21.73 4.22,19.78C2.27,17.83 2.27,14.66 4.22,12.71L5.71,11.22C5.7,12.04 5.83,12.86 6.11,13.65L5.64,14.12C4.46,15.29 4.46,17.19 5.64,18.36C6.81,19.54 8.71,19.54 9.88,18.36L13.41,14.83C14.59,13.66 14.59,11.76 13.41,10.59C13,10.2 13,9.56 13.41,9.17Z"></path></svg></a></h3>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">This Blog i built using java Spring MVC 4 and Mavan 3 which give a structural and neat coding&nbsp;</p>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">I&rsquo;ve hosted this blog on&nbsp;<a href="https://www.netlify.com/" style="box-sizing: border-box; background-color: transparent; color: rgb(65, 155, 232); text-decoration-line: none; overflow-wrap: break-word;">Netlify</a>, a cloud hosting platform for static websites.</p>

<h3 id="how-can-i-contact-you" style="box-sizing: border-box; margin: 30px 0px; padding: 0px; font-weight: 600; font-size: 1.25em; line-height: 1.3; position: relative;">How can I contact you?<a class="header-link" href="" style="box-sizing: border-box; background-color: transparent; color: rgb(65, 155, 232); text-decoration-line: none; overflow-wrap: break-word; position: absolute; top: 0px; left: -40px; padding: 5px 8px 5px 5px; opacity: 0; font-size: 0.8em; margin-left: 5px; transition: opacity 0.2s ease-in-out 0.1s;"><svg height="24" viewbox="0 0 24 24" width="24"><path d="M10.59,13.41C11,13.8 11,14.44 10.59,14.83C10.2,15.22 9.56,15.22 9.17,14.83C7.22,12.88 7.22,9.71 9.17,7.76V7.76L12.71,4.22C14.66,2.27 17.83,2.27 19.78,4.22C21.73,6.17 21.73,9.34 19.78,11.29L18.29,12.78C18.3,11.96 18.17,11.14 17.89,10.36L18.36,9.88C19.54,8.71 19.54,6.81 18.36,5.64C17.19,4.46 15.29,4.46 14.12,5.64L10.59,9.17C9.41,10.34 9.41,12.24 10.59,13.41M13.41,9.17C13.8,8.78 14.44,8.78 14.83,9.17C16.78,11.12 16.78,14.29 14.83,16.24V16.24L11.29,19.78C9.34,21.73 6.17,21.73 4.22,19.78C2.27,17.83 2.27,14.66 4.22,12.71L5.71,11.22C5.7,12.04 5.83,12.86 6.11,13.65L5.64,14.12C4.46,15.29 4.46,17.19 5.64,18.36C6.81,19.54 8.71,19.54 9.88,18.36L13.41,14.83C14.59,13.66 14.59,11.76 13.41,10.59C13,10.2 13,9.56 13.41,9.17Z"></path></svg></a></h3>

<p style="box-sizing: border-box; margin: 0px 0px 15px; padding: 0px;">You can write to me at <a href="http://oakscode@gmail.com">oakscode@gmail.com</a>. I&rsquo;ll try to respond as soon as possible. Alternatively, you can connect with me directly on <a href="https://www.instagram.com/oakscode/">Instagram</a>&nbsp;or&nbsp;<a href="https://https://github.com/oakscode" style="box-sizing: border-box; background-color: transparent; color: rgb(65, 155, 232); text-decoration-line: none; overflow-wrap: break-word;">github</a>.</p>

<h3 id="how-can-i-support-you" style="box-sizing: border-box; margin: 30px 0px; padding: 0px; font-weight: 600; font-size: 1.25em; line-height: 1.3; position: relative;">&nbsp;</h3>
</div>

						
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
