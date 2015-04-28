

<%@page import="com.gcit.training.lws.domain.Author"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.training.lws.service.AdministratorService;"%>
<%
	//List<Author> authors = new AdministratorService().getAuthors();


//List<Book> books = null;
List<Author> authors = null;
if(request.getAttribute("authors") != null) {
	//books = (List<Book>) request.getAttribute("books");
	authors = (List<Author>) request.getAttribute("authors");
	
} else{
	//books = new AdministratorService().getBooks();
	//authors = new AdministratorService().getAuthors();
	int pageNo = 0;
// 	if (pageNo > 0){
		
// 		pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
// 	}else{
	
// 		pageNo = 1;
		
// 	}
	
	authors = new AdministratorService().getAuthors(pageNo, 5);
}
%>
<%-- <%@include file="include.html"%> --%>
<%@include file="include.html"%>
${result}

<form action="searchAuthors" method="post">
	<input type="text" name="searchString" class="col-md-8"
		placeholder="Enter string to search Authors" /><input type="submit"
		value="Search!" />
</form>


<nav>
	<ul class="pagination">
		<li><a href="pageAuthors?pageNo=1">1</a></li>
		<li><a href="pageAuthors?pageNo=2">2</a></li>
	</ul>
</nav>

<table class="table">
	<tr>
		<th>Author Id</th>
		<th>Author Name</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>

	<%
		for (Author a : authors) {
	%>
	<tr>
		<td><%=a.getAuthorId()%></td>
		<td><%=a.getAuthorName()%></td>
		<td><button class="btn btn-success"
				href="editAuthor.jsp?authorIdToEdit=<%=a.getAuthorId()%>"
				data-target="#myModal1" data-toggle="modal">Edit</button></td>
		<td><button class="btn btn-danger"
				onclick="javascript:location.href='deleteAuthor?authorId=<%=a.getAuthorId()%>';">Delete</button></td>
	</tr>
	<%
		}
	%>
</table>


<div id="myModal1" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content"></div>
	</div>
</div>

