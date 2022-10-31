
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active"><a href="#">Change Password</a></li>
			
			<li class="breadcrumb-item">
			<a class="btn btn-primary right" href='<spring:url value="/member/member_dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Change Password</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post">
					<fieldset>
					
						<div class="row form-group">
							<label class="col-lg-2 control-label" for="old">
								Old Password 
							</label>
							<div class="col-lg-4">
								<div class="input-group">
									
									<input name="old" id="old"  class="form-control" type="text" />
								</div>
							</div>
							</div>
							<div class="row form-group">
								<label class="col-lg-2 control-label" for="newp">
									New Passsword
								</label>
								<div class="col">
									<div class="input-group">
										
										<input name="newp" id="newp" class="form-control" type="password" />
									</div>
								</div>
								</div>
								<div class="row form-group">
								<label class="col-lg-2 control-label" for="con">
									Conform Password
																	</label>
								<div class="col">
									<div class="input-group">
										
										<input name="con" id="con"  class="form-control" type="password" />
									</div>
								</div>
							</div>
							<div class="form-group row">
							<div class="col-md-8 text-center">
								<input type="submit" id="save" value="change" name="save"
									class="btn btn-large btn-success">

								<button class="btn btn-large btn-danger" type="reset">Cancel</button>
							</div>
						</div>
							
						</div>
					</fieldset>
				</form>
			</div>


		</div>
	</div>
</div>
