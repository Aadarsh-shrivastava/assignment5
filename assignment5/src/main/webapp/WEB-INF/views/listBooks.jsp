<%@page import="java.sql.Blob"%>
<%@page import="com.nagarro.assignment5.Entities.*"%>
<%@page import="com.nagarro.assignment5.Services.*"%>

<%@page import="java.io.*,java.util.*,java.sql.*"%>
<%@page import="javax.servlet.http.*,javax.servlet.*"%>

<%@page import="java.util.List"%>
<html>
<head>
<script src=""></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>

	</div>
	
	

<!-- 
	<form action="productServelet" method="Post"
		enctype="multipart/form-data">
		
		<input type="text" placeholder="title" name="title" class="row m-2"> <input
			type="text" placeholder="quantity" name="quantity" class="row m-2"> <input
			type="text" placeholder="size" name="size" class="row m-2"> 
			<div class="d-flex justify-content-start">
			<input type="file" placeholder="image" name="image" class=" m-2 "> <input
			type="submit" value="Upload" class="">
			</div>
	</form>
- -->

	<div class="container card m-5">
		<div>
			<div class="d-flex justify-content-between">
			
				<div> </div>
				<%@include file="logout.jsp"%> 
				
			</div>
		</div>
	
		<div class="m-3 d-flex justify-content-between">
		<div> </div>
		<h1 class="col-2">Book Listing</h1>
		<button type="button" class="btn btn-primary"  onclick="location.href='addBookPage'">Add a Book</button>
		</div>
	
	
	<div class="card ">
		<div id="content">
			<table class="table table-bordered m-2 p-2">
				<tr>
					<th>S No.</th>
					<th>Title</th>
					<th>Quantity</th>
					<th>Size</th>
					<th>Action</th>
					
				</tr>

		
				<%
					BookService bookService=new BookService();
					List<Book> allBooks= bookService.getAllBooks();
					for(Book book:allBooks){
						
				%>

				<tr>
					<td><%=book.getBookCode() %></td>
					<td><%=book.getBookName() %></td>
					<td><%=book.getAuthor() %></td>
					<td><%=book.getAddedOn() %></td>
					
					<td><div class="d-flex"><a href="editBookPage?BookCode=<%=book.getBookCode() %>"><div class="card border border-dark m-1 p-1">EDIT</div></a> <a
						href="/assignment5/deleteBook?BookCode=<%=book.getBookCode()%>"
						onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"><div class="card border border-danger m-1 p-1">DELETE</div> </a></div></td>
				</tr>

				<%
					}
				%>

			</table>
		</div>
	</div>


</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>



</body>
</html>
