<%@page import="com.gcit.training.lws.domain.Book"%>
<%@page import="com.gcit.training.lws.domain.Author"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.training.lws.service.AdministratorService"%>
<%
	List<Book> books = null;
	int pageNo = 1;
	int pageSize = 5;
	int count = 0;

	if(request.getAttribute("books") != null) {
		count = (int) request.getAttribute("count");
		books = (List<Book>) request.getAttribute("books");
		//pageNo = request.getAttribute("pageNo");
		
	} else{
		books = new AdministratorService().getBooks();
		count = new AdministratorService().getBooksCount();
	}
	
%>
<%@include file="include.html"%>

<script>
	function pageBooks(pageNo) {
//		var searchString = document.getElementById("searchString").value;
//		location.href="pageBooks?pageNo="+pageNo+"&searchString="+searchString;
		$("#pageNo").val(pageNo);
		$.ajax({
			  url: "pageBooks",
			  data: {
				  		searchString: $("#searchString").val(),
				  		pageNo: pageNo,
				  		pageSize: $("#pageSize").val()
				  	}
			}).done(function(data) {
			  //alert(data);
			  $("#resultSection").html(data);
			});
		
	}
	
	function searchBooks() {
		$.ajax({
			  url: "pageBooks",
			  data: {
				  		searchString: $("#searchString").val(),
				  		pageNo: $("#pageNo").val(),
				  		pageSize: $("#pageSize").val()
				  	}
			}).done(function(data) {
			  //alert(data);
			  $("#resultSection").html(data);
			});
		
	}

</script>

${result}
<nav>
	<ul class="pagination">

		<%	int end = (count/pageSize);
			if(count%pageSize != 0) 
				end++;
			for(int i = 1; i <= end; i++) { %>
			<li><a href="javascript:pageBooks(<%=i%>);"><%=i%></a></li>
		<% } %>
		
	</ul>
</nav>
<form action="searchBooks" method="post">
	<input type="text" id="searchString" name="searchString" value="${searchString}"
	class="col-md-8" placeholder="Enter string to search Books"/><input type="button" onclick="javascript:searchBooks();" value="Search!" />
	<input type="hidden" id="pageNo" name="pageNo" value="<%=pageNo %>" />
	<input type="hidden" id="pageSize" name="pageSize" value="<%=pageSize%>" />
</form>
<table class="table" id="resultSection">
	<tr>
		<th>Id</th>
		<th>Title</th>
		<th>Publisher</th>
		<th>Author(s)</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>


	<%
		for (Book b : books) {
	%>
	<tr>
		<td><%=b.getBookId()%></td>
		<td><%=b.getTitle()%></td>
		<td>
		<% if(b.getPublisher() != null) { %>
		<%=b.getPublisher().getName()%>
		<% } %>
		</td>
		
		<td><% if(b.getAuthors() != null && b.getAuthors().size() > 0) {
		for(Author a : b.getAuthors()) { %>
			<%=a.getAuthorName() %>,
		<% }
		}%>
		</td>
		<td><button class="btn btn-success"
				href="editAuthor.jsp?authorIdToEdit=<%=b.getBookId()%>"
				data-target="#myModal1" data-toggle="modal">Edit</button></td>
		<td><button class="btn btn-danger"
				onclick="javascript:location.href='deleteAuthor?authorId=<%=b.getBookId()%>';">Delete</button></td>
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