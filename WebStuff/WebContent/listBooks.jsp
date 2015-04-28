<%@include file="include.html"%>

<%@page import="com.gcit.training.lws.domain.Book"%>
<%@page import="com.gcit.training.lws.domain.Author"%>
<%@page import="com.gcit.training.lws.domain.Publisher"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.training.lws.service.AdministratorService"%>
<%
	List<Book> books = null;
	if (request.getAttribute("books") != null) {
		
		books = (List<Book>) request.getAttribute("books");
	} else {
		
		//String authorId = request.getParameter("pageNo");
		
		books = new AdministratorService().getBooks();
			
	}
%>
<%-- <%@include file="include.html"%> --%>
${result}
<form action="searchBooks" method="post">
	<input type="text" name="searchString" class="col-md-8"
		placeholder="Enter string to search Books" /><input type="submit"
		value="Search!" />
</form>


<table class="table">
	<tr>
		<th>Book Id</th>
		<th>Book Title</th>
		<th>Book Author</th>
		<th>Book Publisher</th>
	</tr>

	<%
		for (Book b : books) {
	%>
	<tr>
		<td><%=b.getBookId()%></td>
		<td><%=b.getTitle()%></td>
		<td>
			<%
				for (Author a : b.getAuthors()) {
			%> <%-- 		<tr><%=a.getAuthorName()%>  </tr> --%> <%=a.getAuthorName()%>
			<br /> <%
 	}
 %>

		</td>
		<td><%=b.getPublisher().getName()%></td>
		<td><button class="btn btn-success">Edit</button></td>
		<td><button class="btn btn-danger"
				onclick="javascript:location.href='deleteAuthor?authorId=<%=b.getBookId()%>';">Delete</button></td>
	</tr>
	<%
		}
	%>
</table>