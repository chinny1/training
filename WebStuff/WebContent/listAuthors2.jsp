<%@page import="com.gcit.training.lws.domain.Author"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.training.lws.service.AdministratorService;"%>
<%
	List<Author> authors = null;
	int pageNo = 1;
	int pageSize =5;
	int count = 0;

	if(request.getAttribute("authors") != null) {
		count = (int) request.getAttribute("count");
		authors = (List<Author>) request.getAttribute("authors");
	} else{
		authors = new AdministratorService().getAuthors();
		count = new AdministratorService().getAuthorsCount();
	}
	
%>
<%@include file="include.html"%>

<script>
	
// 	$('a').click(function (event) 
// 		{ 
// 		   event.preventDefault(); 

// 		   var url = $(this).attr('href');
// 		   $.get(url, function(data) {
// 		     alert(data);
// 		    });

// 		 });
	
	function pageAuthors(pageNo) {
// 		var searchString = document.getElementById("searchString").value;
// 		location.href="pageAuthors2?pageNo="+pageNo+"&searchString="+searchString;
		
 		$("#pageNo").val(pageNo);
 		$.ajax({
			  url: "pageAuthors2",
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
	
	function searchAuthors() {
		$.ajax({
			  url: "pageAuthors2",
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
			<li><a href="javascript:pageAuthors(<%=i%>);"><%=i%></a></li>
		<% } %>
		
	</ul>
</nav>
<form action="searchAuthors2" method="post">
	<input type="text" id="searchString" name="searchString" value="${searchString}"
	class="col-md-8" placeholder="Enter string to search Authors"/><input type="button" onclick="javascript:searchAuthors();" value="Search!" />
	<input type="hidden" id="pageNo" name="pageNo" value="<%=pageNo %>" />
	<input type="hidden" id="pageSize" name="pageSize" value="<%=pageSize%>" />
</form>
<table class="table" id="resultSection">
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
		<td><button class="btn btn-success" href="editAuthor.jsp?authorIdToEdit=<%=a.getAuthorId()%>"
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