
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Member</a></li>
			<li class="breadcrumb-item active">Add Diet</li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Add Diet</h2>
			<h3
				style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>

		</div>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post">
					<fieldset>
						<div class="row">
							<div class="col-lg-4 panel">
								<h2>Diet Information</h2>
							</div>
							<div class="col-lg-4 panel panel-heading"
								style="display: none; color: red" id="contact_error"></div>
						</div>

						<div class="row form-group">
						<label class="col-lg-2 control-label" for="mobile">
								Select Member Name </label>
							<div class="col-lg-3">
								<div class="input-group">
								<select name="member" id="member" class="form-control">
								<c:forEach items="${memberList}" var="m">
								<option value="${m.id}">${m.name}</option>
								</c:forEach>
								</select>
								</div>
							</div>
							
							<label class="col-lg-2 control-label" for="forDate">For Date </label>
							<div class="col-lg-4">
								<div class="input-group">
									<input name="forDate" id="forDate" name="mobile" class="form-control" type="date" />
								</div>
							</div>
							
							<div class="row">
							<div class="row form-group">
								<label class="col-lg-4 control-label" for=breakFast>Breakfast Content</label>
								<div class="col-lg-6">
									<div class="input-group">
									<textarea class="form-control" name="breakFast" id="breakFast" rows=4></textarea>
									</div>
								</div>
							</div>
							</div>
							<div class="row">
							<div class="row form-group">
								<label class="col-lg-2 control-label" for="lunch">Lunch Content</label>
								<div class="col-lg-6">
									<div class="input-group">
									<textarea class="form-control" name="lunch" id="lunch" rows=4></textarea>
									</div>
								</div>
							</div>
							</div>
							<div class="row">
							<div class="row form-group">
								<label class="col-lg-4 control-label" for="eveningSnacks">Evening Snacks Content</label>
								<div class="col-lg-6">
									<div class="input-group">
									<textarea class="form-control" name="eveningSnacks" id="eveningSnacks" rows=4></textarea>
									</div>
								</div>
							</div>
							</div>
							<div class="row">
							<div class="row form-group">
								<label class="col-lg-4 control-label" for="dinner">Dinner Content</label>
								<div class="col-lg-6">
									<div class="input-group">
									<textarea class="form-control" name="dinner" id="dinner" rows=4></textarea>
									</div>
								</div>
							</div>

						</div>
						</div>
						<div class="form-group row">
							<div class="col-md-8 text-center">
								<input type="submit" id="save" value="Register" name="save"
									class="btn btn-large btn-success">

								<button class="btn btn-large btn-danger" type="reset">Cancel</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>


	</div>
</div>
