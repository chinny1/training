<%@page import="com.gcit.training.lws.domain.Author"%>
<%@page import="com.gcit.training.lws.service.AdministratorService"%>
<%

String authorToEdit = request.getParameter("authorIdToEdit");
Author a = new AdministratorService().getAuthor(Integer.parseInt(authorToEdit));

%>

<div class="modal-body">

	<form action="editAuthor" method="post">
		Enter Author Name: <input type="text" name="authorName" value="<%=a.getAuthorName()%>"/>
		<input type="hidden" value="<%=a.getAuthorId()%>" name="authorId" />
		<input type="submit"/>
	</form>
</div>