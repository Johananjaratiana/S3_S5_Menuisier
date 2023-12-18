<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="content-wrapper">
	<form class="form-horizontal" action="/Johan_S3/Controller" method="post">
		<input type="hidden" name="action" value="style_insert">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">nom</label>
			<div class="col-sm-10">
			<input type="text" class="form-control" id="inputEmail3" placeholder="nom" name="nom">
			</div>
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</div>