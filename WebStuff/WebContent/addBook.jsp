<%@page import="com.gcit.training.lws.domain.Author"%>
<%@page import="com.gcit.training.lws.domain.Publisher"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.training.lws.service.AdministratorService"%>
<%
	List<Author> authors = new AdministratorService().getAuthors();
List<Publisher> publishers = new AdministratorService().getPublishers();

%>
<%-- <%@include file="include.html"%> --%>
${result}
<%@include file="include.html" %>
<form action="addBook" method="post">
<table class="table">
	
	
	<tr><td>
	
	Enter Book Title: <input type="text" name="title"/>
	
	</td></tr>

	<tr>
	<td>
	Choose Book Author: 
		<select name="authorId">
		<%for (Author a : authors) {%>
  	<option value="<%=a.getAuthorId()%>"><%=a.getAuthorName() %></option>
	<%}%>
		</select>
	</td>
	</tr>
	
	
	<tr><td>
	
	
	Choose Book Publisher: 
		<select name="publisherId">
		<%for (Publisher p : publishers) {%>
  	<option value="<%=p.getId() %>" > <%=p.getName() %></option>
	<%}%>
		</select>
		
	</td></tr>
	
	<tr><td>
	
	<input type="submit"/>
	
	</td></tr>
	</form>

	
	
</table>