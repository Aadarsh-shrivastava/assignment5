<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("BookCode"));
	%>

	<div class="container card m-5">
		<div>
			<div class="d-flex justify-content-between">

				<div></div>
				<%@include file="logout.jsp"%> 
			</div>
		</div>



		<div class="justify-content-between col">
			<div>
				<h1></h1>
			</div>
			<div>
				<h1 class="row">Edit Book Details</h1>
				<div id="content row">
					<form action="editBook?BookCode=<%=id %>" class="col">
						<input type="text" class="row m-3" placeholder="BookCode"name="BookCode" value="<%=id %>"readonly> 
						<input type="text" class="row m-3"placeholder="BookName" name="BookName"> 
						<input type="text" class="row m-3" placeholder="Author" name="Author">
						<input type="text" class="row m-3" placeholder="Addedon"name="Addedon">
						<input type="submit" class="row m-3 btn btn-primary"
							onclick="if (!(confirm('Are you sure you want to Edit this product?'))) return false"
							value="Submit">
						<input type="submit" class="row m-3 btn btn-danger" formaction="listBooks.jsp"
							onclick="if (!(confirm('Are you sure you want to cancelthe progress?'))) return false"
							value="Cancel">
					</form>
				</div>
			</div>
		</div>


	</div>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>