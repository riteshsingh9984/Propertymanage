<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  
  <jsp:include page="../../loaders/file-loader.jsp" />
  
  
</head>
<body>
	<form action="loginEntry" attribute="login">
    <div class="row" >
      <div class="col-sm-12">
        <div class="card-panel teal #607d8b blue-grey" style="background-image: url(resources/images/loginhomebase.gif); height:690px;">
        	<div class="row" style="margin:10%;">
        		<div class="col-sm-1">
        		</div>
        		<div class="col-sm-10 white-text">
        			
        			<div class="card #673ab7 deep-purple">
					    <div class="card-image waves-effect waves-block waves-light" style="background-image: url(resources/images/loginhomebase.gif);" >
					      			<img class="activator" src="resources/images/loginhomebase.gif" style="height:400px;" >
					    </div>
					    <!-- 
					    <div class="card-content">
					      <span class="card-title activator grey-text text-darken-4"> LOGIN here..! <i class="material-icons right">more_vert</i></span>
					    <!-- </div>  -->
					    <div class="card-reveal">
					      <span class="card-title black-text text-darken-4">LOGIN here..!<i class="material-icons right">close</i></span>
					      <div class="col-sm-12">
					      	
					      	<div class="modal-body">
				              <div class="row">
				                  <div class="col-xs-6">
				                      <div class="well">
				                              <div class="form-group">
				                                  <label for="username" class="control-label flow-text">Username</label>
				                                  <input type="text" class="form-control" id="username" name="loginName" value="" required="" title="Please enter you username" >
				                                  <span class="help-block"></span>
				                              </div>
				                              <div class="form-group">
				                                  <label for="password" class="control-label flow-text">Password</label>
				                                  <input type="password" class="form-control" id="password" name="password" value="" required="" title="Please enter your password">
				                                  <span class="help-block"></span>
				                              </div>
				                              <div id="loginErrorMsg" class="alert alert-error hide">Wrong username og password</div>
				                              <div class="checkbox">
				                                  <label>
				                                      <input type="checkbox" name="remember" id="remember"> Remember login
				                                  </label>
				                                  <p class="help-block">(if this is a private computer)</p>
				                              </div>
				                              <button type="submit" class="btn btn-success btn-block">Login</button>
				                              <br/>
				                              <a href="/forgot/">Need help?</a>
				                      </div>
				                  </div>
				                  <div class="col-xs-6 text-center">
				                  <br/><br/>
				                  	<img src="resources/images/logo1.png" style="height:200px; width:200px;" class="img-responsive"/>
				                  </div>
				              </div>
				              <div class="row">
				              	<div class="col-sm-12 text-right">
				              		<a href="http://www.bookmypacket.com" style="text-decoration:none;"><p>Copyright &copy; BMP eGroup Sol Pvt.Ltd</p></a>
				              	</div>
				              </div>
				          </div>
					      	
					      	
					      	
					      
					      </div>
					      
					    </div>
					  </div>
        			
        			
        			
        			
        			
        			
        			
        		</div>
        		<div class="col-sm-1">
        		</div>
        	</div>
          
        </div>
      </div>
    </div>
    </form>
</body>
</html>