
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <jsp:include page="../../loaders/file-loader.jsp" /> 

<script src="https://apis.google.com/js/platform.js" async defer></script>
 <meta name="google-signin-client_id" content="629956852235-3sd1jn49lcdcpf7efg66aidof9l2qkaj.apps.googleusercontent.com">
 
  <!-- 
    This is use onclick event for google SignIn
     
 -->

<script src="https://apis.google.com/js/client.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script>
  function auth() {
    var config = {
      'client_id': '629956852235-3sd1jn49lcdcpf7efg66aidof9l2qkaj.apps.googleusercontent.com',
      'scope': 'https://www.googleapis.com/auth/userinfo.email'
    };
    gapi.auth.authorize(config, function() {
      console.log('login complete');
      console.log(gapi.auth.getToken());
      gapi.client.load('oauth2', 'v2', function() {
    	  gapi.client.oauth2.userinfo.get().execute(function(resp) {
    	    // Shows user email
    	    console.log(resp.email);
    	    $("#eml").val(resp.email);
    	    alert($("#eml").val());
    	    $( "#target" ).submit();
    	    
    	    alert($("#eml").val());
    	  })
    	});
    });
  }
</script>

<!-- Finished the onclick event login with Google -->
 
<title>Action Google Login here</title>
</head>
<body>
	<form:form id="target" modelAttribute="login" action="gooleLogin" method="post" enctype="multipart/form-data">
		<input type="text" id="eml" name="email"  />
		<input type="text" id="tkn" name="tokenId" hidden />
		
	</form:form>
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
                    <div class="col-sm-2">
		            	<div class="g-signin2" onclick="auth()"></div>
		            </div>
                    </div>
                    </div>
                  </header>
</body>
</html>