<%@include file="/includes/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="com.project.psi.db.entity.History" %>
<div class="container">
	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-6">
			<%
				if (session.getAttribute("session") == null) {
			%>
			<div class="alert alert-danger">Musisz się zalogować.</div>

			<%
				} else {
			%>
			<a href="changePassword.jsp" class="btn btn-primary" role="button">Zmień
				hasło</a>
			<form method="post" action="logout">
				<input type="submit" value="Wyloguj" class="btn btn-primary">
			</form>
			
			<button onclick="myFunction1()" class="btn btn-primary">Pokaż/Ukryj</button>
			
			
			<div id="myDIV">
				<br /> <input type="text" id="myInput" onkeyup="myFunction()"
					placeholder="Filtruj" class="form-control">
	
				<table id="myTable" class="table">
					<tr class="header">
						<th>Data</th>
						<th>Opis</th>
					</tr>
					<%
					List<History> saa = (List<History>)request.getAttribute("history");
					for(int i=0; i<saa.size(); i++){
						%> <tr><td> <%= saa.get(i).getData() %> </td>
						<td> <%= saa.get(i).getDescription() %> </td></tr> <%
					}
					%>
				</table>
			</div>
			<%
				}
			%>
		</div>
		<div class="col-lg-3"></div>
	</div>
</div>
<%@include file="/includes/footer.jsp"%>