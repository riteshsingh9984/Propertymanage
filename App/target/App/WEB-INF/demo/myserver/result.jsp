<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyServer Create</title>
  
  <jsp:include page="../../loaders/file-loader.jsp" />
  
  
   
</head>
<body style="background-image: url('resources/images/server.jpg')">
	
	<jsp:include page="../../partial-files/header.jsp" />
	
	<div class="container">
		<br/><br/>
		<div class="row">
			<div class="col-sm-12 z-depth-5">
				<div class="row" style="height:500px;weight:500px;">
					<div class="row">
						<div class="col-sm-12">
							<i style="color:black;font-size: 20px;">My Server Room</i>
						</div>
					</div>
					<div class="row">
						<div class="table-responsive">   
			   				<table id="real" class="display">
		    
							</table>	
							
	            	    </div>
					</div> 
					<div class="row">
						<div id="div1">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<script type="text/javascript" src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
<script>
	$(document).ready(function() {
		
		$('#real').DataTable( {
			
			"ajax" : "myservers",
	  	  		"columnDefs": [
	  	  	    				{
	  	  	    	  				"title" : "Server ID",	
	   	  		       	        	"targets": 0,
	   	  		       	        	"searchable": true
	  	  	        			},
	  	  	        			{
	  	  	        				"title" : "Server Name",
	   	  		       	        	"targets": 1,
	   	  		       	        	"searchable": true,
	  	  	        			 },
	  	  	        			 {
	  	  	        			 	"title" : "Port No",
	   	  		       	         	"targets": 2,
	   	  		       	         	"searchable": true
	  	  	        			 },
	  	  	        			 {
	  	  	        			 	"title" : "IP Address",
	   	  		       	         	"targets": 3,
	   	  		       	         	"searchable": true
	  	  	        			 },
	  	  	        			{
		  	  	        			 	"title" : "Status",
		   	  		       	         	"targets": 4,
		   	  		       	         	"searchable": true,
		   	  		       	            "mData" : null,
		  	  	        			    "render": function ( data, type, full, meta ) {
		  	  	        			    			if(data[4] == 0)
		  	  	        			      				return '<span id='+data[0]+' style="color:red;" class=" glyphicon glyphicon-thumbs-down" onclick="sh(this.id)" ></span>';
		  	  	        			    			else
		  	  	        			    				return '<span id='+data[0]+' style="color:green;" class=" glyphicon glyphicon-thumbs-up" onclick="sh(this.id)"></span>';
		  	  	        			    }
		  	  	        			 },
	  	  	        			 {
	  	  	        			 	"title" : "Action",  
	  	  	        			    "targets": 5,
	  	  	        				"orderable" : false,
	  	  	        			    "data": 1,
	  	  	        			    "render": function ( data, type, full, meta ) {
	  	  	        			      				return '<a href="client_view?key='+data+'"><span class="glyphicon glyphicon-eye-open"></span></a>&nbsp;&nbsp;<a href="client_edit?key='+data+'"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;<a href="#" id='+data+' onclick="getData(this.id);"><span class="glyphicon glyphicon-trash"></span></a>';
	  	  	        			    			}
	  	  	        			  } 
	  	  	      				],	      
	  	      	 "paging": false,
	  	      	 "responsive": true,
	  	      	 // processing view for large amount of data durring sorting the inserted data
	  	      	 "processing": true
	  	      } );
	        } );
	
	
	
	function sh(str){
		alert(str);
        $.ajax({url: "upserver?serverId="+str, success: function(result){
            
        	var array = result.split(",");
        	
        	$("#div1").html("serverID= "+array[0]+"status= "+array[1]);
        	
            if(array[1] == 1){
            	$("#"+array[0]).removeClass(' glyphicon glyphicon-thumbs-down');
                $("#"+array[0]).addClass(' glyphicon glyphicon-thumbs-up');
                $('#'+array[0]).css('color','green');	
            }else{
            	$("#"+array[0]).removeClass(' glyphicon glyphicon-thumbs-up');
                $("#"+array[0]).addClass(' glyphicon glyphicon-thumbs-down');
                $('#'+array[0]).css('color','red');
            }
            
            
        }});
	}
</script>