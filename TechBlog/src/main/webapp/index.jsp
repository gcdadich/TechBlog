<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import="com.tech.blog.helper.*"%>
<%@ page import="java.sql.Connection"%>
    
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="css/mystyle.css" rel="stylesheet" type="text/css"/><script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	.banner-background
	{
		clip-path: polygon(0 0, 100% 0, 100% 100%, 86% 93%, 61% 99%, 19% 93%, 0 99%);
	}
</style>
</head>
<body>
	<!-- navbar --> 
	<%@include file="normal_navbar.jsp" %>

	<!-- banner -->
	<div class="container-fluid p-0 m-0">
		<div class="jumbotron primary-background text-white banner-background">
			<div class="container">
				 <h3 class="display-3">Welcome to TechBlog</h3>
				<p> Welcome to a technical blog, world of technology
					A programming language is usually described in terms of its syntax (form) and semantics (meaning). These are usually defined by a formal language
				</p>
				<p>A language usually has at least one implementation in the form of a compiler or interpreter, allowing programs written in the language to be executed. And gives the correct output correspond to the code.</p>
			
				<a href="register_page.jsp" class="btn btn-outline-light btn-lg mr-2"><span class="fa fa-user-plus"></span> Start! it's Free</a>
				<a href="login_page.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-circle fa-spin "></span> Login</a>
			
			</div>
		</div>
	</div>
	
	<!-- Cards --> 
	<div class="container">
		
		<div class="row mb-2" >
			<div class="col-md-4 mb-2">
				<div class="card">
  					<!--<img class="card-img-top" src="..." alt="Card image cap">-->
  					<div class="card-body">
    					<h5 class="card-title">Java Programming</h5>
    					<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    					<a href="#" class="btn primary-background text-white">Go somewhere</a>
  					</div>
				</div>
			</div>
			<div class="col-md-4 mb-2">
				<div class="card">
  					<!--<img class="card-img-top" src="..." alt="Card image cap">-->
  					<div class="card-body">
    					<h5 class="card-title">Servlet</h5>
    					<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    					<a href="#" class="btn primary-background text-white">Go somewhere</a>
  					</div>
				</div>
			</div>
			<div class="col-md-4 mb-2">
				<div class="card">
  					<!--<img class="card-img-top" src="..." alt="Card image cap">-->
  					<div class="card-body">
    					<h5 class="card-title">JSP</h5>
    					<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    					<a href="#" class="btn primary-background text-white">Go somewhere</a>
  					</div>
				</div>
			</div>
		</div>
		 
		<div class="row mb-2" >
			<div class="col-md-4 mb-2">
				<div class="card">
  					<!--<img class="card-img-top" src="..." alt="Card image cap">-->
  					<div class="card-body">
    					<h5 class="card-title">Java Programming</h5>
    					<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    					<a href="#" class="btn primary-background text-white">Go somewhere</a>
  					</div>
				</div>
			</div>
			<div class="col-md-4 mb-2">
				<div class="card">
  					<!--<img class="card-img-top" src="..." alt="Card image cap">-->
  					<div class="card-body">
    					<h5 class="card-title">Servlet</h5>
    					<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    					<a href="#" class="btn primary-background text-white">Go somewhere</a>
  					</div>
				</div>
			</div>
			<div class="col-md-4 mb-2">
				<div class="card">
  					<!--<img class="card-img-top" src="..." alt="Card image cap">-->
  					<div class="card-body">
    					<h5 class="card-title">JSP</h5>
    					<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    					<a href="#" class="btn primary-background text-white">Go somewhere</a>
  					</div>
				</div>
			</div>
		</div>
		
	</div> 
	
	<!-- javascript -->
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" >>="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="js/myjs.js" type="text/javascript"></script>

</body>
</html>