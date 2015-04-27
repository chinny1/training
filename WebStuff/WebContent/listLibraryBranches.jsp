

<%@page import="com.gcit.training.lws.domain.LibraryBranch"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.training.lws.service.AdministratorService;"%>
<%
	List<LibraryBranch> libraryBranches = new AdministratorService().getLibraryBranches();
%>
<%-- <%@include file="include.html"%> --%>
<%@include file="include.html" %>
${result}



<table class="table">
	<tr>
		<th>Branch Id</th>
		<th>Branch Name</th>
		<th>Branch Address</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>

	<%
		for (LibraryBranch a : libraryBranches) {
	%>
	<tr>
		<td><%=a.getBranchId()%></td>
		<td><%=a.getBranchName()%></td>
		<td><%=a.getBranchAddress()%></td>
		<td><button class="btn btn-success"
				href="editAuthor.jsp?authorIdToEdit=<%=a.getBranchId()%>"
				data-target="#myModal1" data-toggle="modal">Edit</button></td>
		<td><button class="btn btn-danger"
				onclick="javascript:location.href='deleteAuthor?authorId=<%=a.getBranchId()%>';">Delete</button></td>
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

