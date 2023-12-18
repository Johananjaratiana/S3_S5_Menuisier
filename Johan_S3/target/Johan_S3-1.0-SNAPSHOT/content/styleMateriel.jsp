<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="content-wrapper">
	<form class="form-horizontal" action="/Johan_S3/Controller" method="post">
		<input type="hidden" name="action" value="styleMateriel_insert">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">idStyle</label>
			<div class="col-sm-10">
			<select class= "form-control" name="idStyle">
			</select>
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">idMateriel</label>
			<div class="col-sm-10">
			<select class= "form-control" name="idMateriel">
			</select>
			</div>
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</div>