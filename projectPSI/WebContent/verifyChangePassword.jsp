<%@include file="/includes/header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-6">
			<h2><label>Potwierdź zmianę hasła</label></h2></br>
			<form method="post" action="verifyChangePassword">
				<input id="password" name="password" type="hidden" value=<%=request.getAttribute("password") %>>
				<input id="yes" name="decision" type="hidden" value="yes">
				<input type="submit" value="Tak" class="btn btn-primary">
			</form>
			<form method="post" action="verifyChangePassword">
				<input id="password" name="password" type="hidden" value=<%=request.getAttribute("password") %>>
				<input id="no" name="decision" type="hidden" value="no">
				<input type="submit" value="Nie" class="btn btn-primary">
			</form>
		</div>
		<div class="col-lg-3"></div>
	</div>
</div>
<%@include file="/includes/footer.jsp"%>