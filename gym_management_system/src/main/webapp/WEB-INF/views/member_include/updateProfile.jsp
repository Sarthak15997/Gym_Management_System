
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">My Profile</a></li>
			<li class="breadcrumb-item active">Update Profile</li>
			<li class="breadcrumb-item">
			<a class="btn btn-primary right" href='<spring:url value="/member/member_dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Update Profile</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post" enctype="multipart/form-data">
					<fieldset>
					<input type="hidden" name="id" value="${myInfo.id}"/>
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
									
									<input name="mobileNo" id="mobileNo" maxlength="10"  placeholder="xxxxxxxxxxxx" class="form-control" type="number" value="${myInfo.mobileNo}"/>
								</div>
							</div>
							<div class="row form-group">
								<label class="col-lg-2 control-label" for="email">
									Email. 
								</label>
								<div class="col">
									<div class="input-group">
										
										<input name="email" id="email"  placeholder="example@gmail.com" class="form-control" type="email" value="${myInfo.email}"/>
									</div>
								</div>
							</div>
							<div class="row form-group">								
								<div class="col-lg-12">
								<label class="col control-label text-center " for="first_name">
								Full Name.
								</label>
									<div class="input-group">
										<input name="name" id="name"  placeholder="" class="form-control" type="text" value="${myInfo.name}" />
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
							<label class="col-md-2 control-label" for="city">City</label>
							<div class="col-md-2">
								<div class="input-group">
								
									<input name="city" id="city"  placeholder="" class="form-control" type="text" value="${myInfo.address.city}"/>
								</div>
							</div>

							<label class="col-md-1 control-label" for="state">State.</label>
							<div class="col-md-2">
								<div class="input-group">
									
									<input name="state" id="state"  placeholder="" class="form-control" type="text" value="${myInfo.address.state}"/>
								</div>
							</div>

							<label class="col-md-1 control-label" for="district">District.</label>
							<div class="col-md-2">
								<div class="input-group">
									 
									<input name="district" id="district" placeholder="" class="form-control" type="text" value="${myInfo.address.district}"/>
								</div>
							</div>
						</div>
						
						<div class="row form-group">
							<label class="col-lg-2 control-label" for="add_ln_1">Address Line 1.</label>
							<div class="col-lg">
								<input name="addLine1" id="add_ln_1"  placeholder="street address" class="form-control" type="text" value="${myInfo.address.addLine1}" />
							</div>

							<label class="col-lg-2 control-label" for="add_ln_2">Address Line 2. </label>
							<div class="col-lg ">
								<div class="input-group">
									
									<input name="addLine2" id="add_ln_2" placeholder="street address" class="form-control" type="text" value="${myInfo.address.addLine2}"/>
								</div>
							</div>
						</div>
						
						</div>
						<div class="row form-group">
							<label class="col-lg-2 control-label" for="pin_code">Pin Code.</label>
							<div class="col-lg-2">
								<input name="pincode" id="pin_code" placeholder="" class="form-control" type="text" value="${myInfo.address.pincode}" />
							</div>

							<label class="col-lg-1 control-label" for="country">Country</label>
							<div class="col-lg-5">
								<div class="input-group">
								
									<input name="country" id="country" placeholder="" class="form-control" type="text" value="${myInfo.address.country}" />
								</div>
							</div>
						</div>
						<!-- address over -->
						<div class="row">
							<div class="col-lg-12 panel ">
								<h2>Other Information</h2>
							</div>
						</div>
						
						<div class="row form-group">
							<label class="col-md-2 control-label" for="dob">Bith Date</label>
							<div class="col-md-3">
								<div class="input-group">
								
									<input  id="dateOfBirth" name="dateOfBirth" placeholder="" class="form-control" type="date"  value="${myInfo.dateOfBirth}"/>
								</div>
							</div>

							<label class="col-md-1 control-label" for="state">Gender</label>
							<div class="col-md-2">
								<div class="input-group">
								<input  id="gender" name="gender" placeholder="" class="form-control" type="text"  value="${myInfo.gender}"/>
								</div>
							</div>

							<label class="col-md-1 control-label" for="height">Height</label>
							<div class="col-md-2">
								<div class="input-group">
									<input name="height" id="height" placeholder="" class="form-control" type="text" value="${myInfo.height}" />
								</div>
							</div>
						</div>
						<div class="row form-group">
							<label class="col-md-2 control-label" for="weight">Weight</label>
							<div class="col-md-2">
								<div class="input-group">
									<input  id="weight" name="weight" placeholder="" class="form-control" type="text" value="${myInfo.weight}"/>
								</div>
							</div>

							<label class="col-md-1 control-label" for="startTime">Start Time</label>
							<div class="col-md-2">
								<div class="input-group">
								<input type="time" name="startTime" id="startTime" class="form-control" value="${myInfo.startTime}"required/>
								</div>
							</div>

							<label class="col-md-1 control-label" for="endTime">End Time</label>
							<div class="col-md-2">
								<div class="input-group">
									<input name="endTime" id="endTime" placeholder="" class="form-control" type="time" value="${myInfo.endTime}"/>
								</div>
							</div>
						</div>
						<div class="row form-group">
						<label class="col-lg-2 control-label" for="image">Profile Image</label>
							<div class="col-lg-4">
								<input type="file" id="myFile" name="image">
							</div>
							
						</div>
						
						<!-- button -->
						<div class="form-group row">
							<div class="col-md-8 text-center">
								<input type="submit" id="save" value="Update" name="save"
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
