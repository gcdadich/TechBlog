<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
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

	<main class="primary-background p-5 banner-background" style="padding-bottom: 80px;">
		<div class="container">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center primary-background text-white">
						<span class="fa fa-3x fa-user-circle"></span>
						<br>
						<p>Register Here</p>
					</div>
					<div class="card-body">
						<form id="reg-form" action="RegisterServlet" method="POST">
							<div class="form-group">
  							  <label for="exampleInputEmail1">User Name</label>
  							  <input name="user_name" type="text" class="form-control" aria-describedby="emailHelp" placeholder="Enter name">
  							</div>
						
  							<div class="form-group">
  							  <label for="exampleInputEmail1">Email address</label>
  							  <input name="user_email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
  							  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  							</div>
  							
  							<div class="form-group">
  							  <label for="exampleInputPassword1">Password</label>
  							  <input name="user_password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
 							</div>
 							
 							<!-- <div class="form-group">
  							  <label for="exampleInputPassword1">Confirm password</label>
  							  <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
 							</div> -->
 							
 					  		<div class="form-group">
  							  <label for="gender">Select Gender</label>
  							  <br>
  							  <input type="radio" id="gender" name="gender" value="Male"> Male
  							  <input type="radio" id="gender" name="gender" value="Female"> Female
 							</div>
 							
 							<div class="form-group">
 								<textarea name="about" class="form-control" id="" rows="4" placeholder="Enter something about yourself"></textarea>
 							</div>
 							  
  							<div class="form-check">
  							  <input name="check" type="checkbox" class="form-check-input" id="exampleCheck1">
  							  <label class="form-check-label" for="exampleCheck1">By clicking "Sign up" I agree that I have read and accepted the <a href="terms_page.jsp">Terms of Use</a></label>
  							</div>
  							
  							<br>
  							<div class="container text-center" id="loader" style="display:none" >
  								<span class="fa fa-refresh fa-spin fa-3x"></span>
  								<h5>Please wait...</h5>
  							</div>
  							<button id="submit-btn" type="submit" class="btn btn-primary">Sign up</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	
	</main>


	<!-- javascript -->
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" >>="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="js/myjs.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<script>
		$(document).ready(function(){
			console.log("loaded........")
			
			$('#reg-form').on('submit', function(event){ // reg-from on submit ye function apna aap cal ho jayaga
				event.preventDefault(); // to stop from going to the servlet page
				
				
				
				
				let form = new FormData(this);
				$("#submit-btn").hide();
				$("#loader").show();
			
				
			// send register servlet
			$.ajax({
				url: "RegisterServlet",
				type: 'POST',
				data: form,
				success: function(data, textStatus, jqXHR){
					console.log(data);
					
					$("#submit-btn").show();
					$("#loader").hide();
					
					if(data.trim()=='done')
					{	
						swal("Registered Succesfully... directing to Login Page")
						.then((value) => {
					 	 window.location="login_page.jsp"
						});
					}
					else
					{
						swal(data);
					}
				},
				error: function(jqXHR, textStatus, errorThrown){
					$("#submit-btn").show();
					$("#loader").hide();
					swal("Something went wrong... Try Again");
				},
				processData: false,
				contentType: false
			});
			});
		});  
	</script>


</body>
</html>