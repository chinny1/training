<%@page import="com.gcit.training.lws.domain.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.training.lws.service.AdministratorService"%>
<%
	List<Book> books = new AdministratorService().getBooks();
%>
<%-- <%@include file="include.html"%> --%>
${result}
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
		<td><%=b.getAuthors()%></td>
		<td><%=b.getPublisher()%></td>
		<td><button class="btn btn-success">Edit</button></td>
		<td><button class="btn btn-danger"
				onclick="javascript:location.href='deleteAuthor?authorId=<%=b.getBookId()%>';">Delete</button></td>
	</tr>
	<%
		}
	%>
</table>