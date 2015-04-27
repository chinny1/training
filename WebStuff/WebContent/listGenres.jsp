

<%@page import="com.gcit.training.lws.domain.Genre"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.training.lws.service.AdministratorService;"%>
<%
	List<Genre> genres = new AdministratorService().getGenres();
%>
<%-- <%@include file="include.html"%> --%>
<%@include file="include.html" %>
${result}



<table class="table">
	<tr>
		<th>Genre Id</th>
		<th>Genre Name</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>

	<%
		for (Genre a : genres) {
	%>
	<tr>
		<td><%=a.getGenreId()%></td>
		<td><%=a.getName()%></td>
		<td><button class="btn btn-success"
				href="editAuthor.jsp?authorIdToEdit=<%=a.getGenreId()%>"
				data-target="#myModal1" data-toggle="modal">Edit</button></td>
		<td><button class="btn btn-danger"
				onclick="javascript:location.href='deleteAuthor?authorId=<%=a.getGenreId()%>';">Delete</button></td>
	</tr>
	<%
		}
	%>
</table>


<div id="myModal1" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">

</div>
	</div>

</div>

