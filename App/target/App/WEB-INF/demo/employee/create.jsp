<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  
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
	
	<form action="employeeSave" attribute="employee">
    	
    	
    	
    </form>
</body>
</html>