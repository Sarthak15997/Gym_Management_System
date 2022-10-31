
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Trainer</a></li>
			<li class="breadcrumb-item active">Trainer Registration</li>
			<li class="breadcrumb-item">
			<a class="btn btn-primary right" href='<spring:url value="/admin/admin_dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Trainer Registration</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post">
					<fieldset>
						<div class="row">
							<div class="col-lg-4 panel">
								<h2>Contact Information</h2>
							</div>
							<div class="col-lg-4 panel panel-heading"
								style="display: none; color: red" id="contact_error"></div>
						</div>

						<div class="row form-group">
							<label class="col-lg-2 control-label" for="mobile">
								Contact No. 
							</label>
							<div class="col-lg-4">
								<div class="input-group">
									
									<input name="mobileNo" id="mobileNo" maxlength="10" name="mobile" placeholder="xxxxxxxxxxxx" class="form-control" type="number" />
								</div>
							</div>
							<div class="row form-group">
								<label class="col-lg-2 control-label" for="email">
									Email. 
								</label>
								<div class="col">
									<div class="input-group">
										
										<input name="email" id="email" name="email" placeholder="example@gmail.com" class="form-control" type="email" />
									</div>
								</div>
								<label class="col-lg-2 control-label" for="experience">
									Experience In year. 
								</label>
								<div class="col">
									<div class="input-group">
										
										<input name="experience" id="experience"  class="form-control" type="String" />
									</div>
								</div>
							</div>
							<div class="row form-group">
								<label class="col-md-1 control-label " for="first_name">
								First Name.
								</label>
								<div class="col-md-2">
									<div class="input-group">
									
										<input name="firstName" id="first_name" name="first_name" placeholder="" class="form-control" type="text" />
									</div>
								</div>

								<label class="col-md-1 control-label" for="middle_name">
								Mid Name.
								</label>
								<div class="col-md-2">
									<div class="input-group">
 								
										<input name="middleName" id="middle_name" name="middle_name" placeholder="" class="form-control" type="text" />
									</div>
								</div>
								
								<label class="col-md-1 control-label" for="last_name">
								Last Name.
								</label>
								<div class="col-md-2">
									<div class="input-group">
									
										<input name="lastName" id="last_name" name="last_name" placeholder="" class="form-control" type="text" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-12 panel ">
								<h2>Address Information</h2>
							</div>
							
							<div class="col-md-4 panel panel-heading"
								style="display: none; color: red" id="address_error"></div>
						</div>

						<div class="row form-group">
							<label class="col-md-2 control-label" for="city">City.</label>
							<div class="col-md-2">
								<div class="input-group">
								
									<input name="city" id="city" name="city" placeholder="" class="form-control" type="text" />
								</div>
							</div>

							<label class="col-md-1 control-label" for="state">State.</label>
							<div class="col-md-2">
								<div class="input-group">
									
									<input name="state" id="state" name="state" placeholder="" class="form-control" type="text" />
								</div>
							</div>

							<label class="col-md-1 control-label" for="district">District.</label>
							<div class="col-md-2">
								<div class="input-group">
									 
									<input name="district" id="district" name="district" placeholder="" class="form-control" type="text" />
								</div>
							</div>
						</div>
						
						<div class="row form-group">
							<label class="col-lg-2 control-label" for="add_ln_1">Address Line 1.</label>
							<div class="col-lg">
								<input name="addLine1" id="add_ln_1" name="add_ln_1" placeholder="street address" class="form-control" type="text" />
							</div>

							<label class="col-lg-2 control-label" for="add_ln_2">Address Line 2. </label>
							<div class="col-lg ">
								<div class="input-group">
									
									<input name="addLine2" id="add_ln_2" name="add_ln_2" placeholder="street address" class="form-control" type="text" />
								</div>
							</div>
						</div>
						
						</div>
						<div class="row form-group">
							<label class="col-lg-2 control-label" for="pin_code">Pin Code.</label>
							<div class="col-lg-2">
								<input name="pincode" id="pin_code" name="pin_code" placeholder="" class="form-control" type="text" />
							</div>

							<label class="col-lg-1 control-label" for="country">Country</label>
							<div class="col-lg-5">
								<div class="input-group">
								
									<input name="country" id="country" name="country" placeholder="" class="form-control" type="text" />
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
