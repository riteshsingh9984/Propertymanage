<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://apis.google.com/js/platform.js" async defer></script>
 <meta name="google-signin-client_id" content="629956852235-3sd1jn49lcdcpf7efg66aidof9l2qkaj.apps.googleusercontent.com">
 
 <script>
	 function signOut() {
	   var auth2 = gapi.auth2.getAuthInstance();
	   auth2.signOut().then(function () {
		 console.log('User signed out.');
	   });
	 }
function onSignIn(googleUser) {
  var profile = googleUser.getBasicProfile();
  var id_token = googleUser.getAuthResponse().id_token;
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Image URL: ' + profile.getImageUrl());
  console.log('Email: ' + profile.getEmail());
  console.log('Token: ' + id_token);

  var xhr = new XMLHttpRequest();
  xhr.open('POST', 'http://localhost:8080/GoogleAppv1/tokenSignin');
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhr.onload = function() {
    console.log('Signed in as: ' + xhr.responseText);
  };
  xhr.send('idtoken=' + id_token);

}


</script>
 
 
 
 
 
 
 

<title>Google Login here</title>
 <jsp:include page="../../loaders/file-loader.jsp" /> 
</head>
<body>

 <header class="jumbotron hero-space" style="background-color:white;"  >
                   <div class="container">
                   <br />
                   <br />
                   <br />
                   <br />
                   <br />
                   <br />
                   <div class="row">
                    <div class="col-sm-5"></div>
                   <div class="col-sm-3">
                   <img src="resources/images/logo1.png" style="width:150px; height:60px;" />
                   </div>
                   <div class="col-sm-6"></div>
                   </div>
                   <div class="row">
                   <div class="col-sm-3"></div>
                   <div class="col-sm-6">
                    <h3 style="text-align:center;font-size:30px;">Welcome to BookMyPacket Admin  Login Google </h3>
                    </div>
                   <div class="col-sm-3">
                   		<div class="g-signin2" data-onsuccess="onSignIn"></div>
                   </div>
                   <div class="col-sm-3">
                   		<a href="#" onclick="signOut();">Sign out</a>
                   </div>
                    </div>
                    </div>
                  </header>
</body>
</html>