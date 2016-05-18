<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manual Server Startup</title>
  
  <jsp:include page="../../loaders/file-loader.jsp" />
  
  
    <script>
    $( document ).ready(function() {
    	$(".dropdown-button").dropdown({ 
					             hover: false
					    		});
    });
  </script>
  
</head>
<body>
	
	<jsp:include page="../../partial-files/header.jsp" />
	
	<div class="container">
		<br/><br/>
		<div class="row">
			<div class="col-sm-3">
				<img alt="" src="resources/images/serverlogo.jpg" style="height:200px;weight:200px;">
			</div>
			<div class="col-sm-6 z-depth-5">
				<div class="row">
				    <form class="col s12" action="manualserverSave" attribute="manualserver" method="post">
				      <div class="row">
				        <div class="input-field col s6">
				          <input  style="font-size: 15px;" id="server_id" name="id" type="text" class="validate">
				          <label for="server_id" style="font-size: 15px;">Server ID</label>
				        </div>
				        <div class="input-field col s6">
				          <input id="server_name" name="serverName" style="font-size: 15px;" type="text" class="validate">
				          <label for="server_name" style="font-size: 15px;">Server Name</label>
				        </div>
				      </div>
				      <div class="row">
				        <div class="input-field col s6">
				          <input  style="font-size: 15px;" id="port_no" name="portNo" type="text" class="validate">
				          <label for="port_no" style="font-size: 15px;">Port No</label>
				        </div>
				        <div class="input-field col s6">
				          <input id="ip_address" name="ipAddress" style="font-size: 15px;" type="text" class="validate">
				          <label for="ip_address" style="font-size: 15px;">IP Address</label>
				        </div>
				      </div>
				      <div class="row">
				        <div class="input-field col s6">
				          <button class="btn waves-effect waves-light" type="submit" name="action">Submit
						    <i class="material-icons right">send</i>
						  </button>
						  <a class="waves-effect waves-light btn"><i class="material-icons right">cloud</i>reset</a>
				        </div>
				        <div class="input-field col s6">  
                       		
				        </div>
				      </div>
				    </form>
				  </div>
			</div>
			<div class="col-sm-3">
			</div>
		</div>
		<br/>
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Note!</strong> This server will active if Admin approved otherwise it only registered in our database ! 
				    </div>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">

/* $(document).ready(function() {
	$("#ip_address").shieldMaskedTextBox({
        enabled: true,
        mask: "099.099.099.099"
    });
	
	$("#port_no").shieldMaskedTextBox({
        enabled: true,
        mask: "00.00"
    });
}); */
</script>