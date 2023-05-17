<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<%	
		if ( session.getAttribute("current-user")== null)
			response.sendRedirect("loginCheck");
	
	%>
				<div class="d-flex justify-content-between"> 
					<h4 class="m-3">Welcome <%=session.getAttribute("current-user") %></h4>
					<a href="/assignment5/loginCheck"><button id= type="button" class="m-3 btn btn-primary" onclick="deleteSession()">logout</button>
				</a></div>
			
</body>
<script>
function deleteSession() {
	<%
	session.setAttribute("current-user", null);%>
	
	
	
	}
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</html>