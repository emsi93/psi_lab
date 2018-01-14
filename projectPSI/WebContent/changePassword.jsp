<%@include file="/includes/header.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-6">
			<h2><label>Zmiana hasła</label></h2></br>
			<% 
				if(request.getAttribute("msg") != null){%>
					<div class="alert alert-danger">
						<%=  request.getAttribute("msg").toString()%>
					</div>
				 	
				<% }
				if(request.getAttribute("success") != null){%>
				<div class="alert alert-success">
					<%=  request.getAttribute("success").toString()%>
				</div>
			 	
				<% }
			%>
			
			
			<%
				if (session.getAttribute("session") == null) {
			%>
			<div class="alert alert-danger">Musisz się zalogować.</div>

			<%
				} else {
			%>
				<form method="post" action="reset">
				<div class="form-group">
					<label for="login">Hasło</label><br/>
					<input id="login" type="password" name="password" class="form-control" maxlength="30"><br/>
				</div>
				<div class="form-group">
					<label for="password">Potwierdź hasło</label><br/> 
					<input id="password" type="password" name="confirmPassword" class="form-control" maxlength="30"><br/>
				</div>
				<input type="submit" value="Zmień" class="btn btn-primary">
				<input type="reset" value="Wyczyść" class="btn btn-primary">
				</form>
				<br/>
				<form method="post" action="logout">
						<input type="submit" value="Wyloguj" class="btn btn-primary">
				</form>
				<%
				}
			%>
			
		</div>
		<div class="col-lg-3"></div>
	</div>
</div>
<%@include file="/includes/footer.jsp" %>