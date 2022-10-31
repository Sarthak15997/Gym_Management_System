   
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Activity</a>
        </li>
        <li class="breadcrumb-item active">Feedback</li>
      </ol>
    <div class="alert alert-primary text-center" role="alert">
			<h2>Feedback Form</h2>
			<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		</div>
		<form method="post">
		<div class="row">
		<div class="col-lg-2"> Full Name </div>
		<div class="col-lg-4"> <input type="text" class="form-control" name="name"/></div>
		</div><br>
		
		<div class="row">
		<div class="col-lg-2"> Contact No </div>
		<div class="col-lg-4"> <input type="text" class="form-control" name="mobileNo"/></div>
		</div><br>
		<div class="row">
		<div class="col-lg-2"> Email </div>
		<div class="col-lg-4"> <input type="email" class="form-control" name="email"/></div>
		</div><br>
		<div class="row">
		<div class="col-lg-2"> comment </div>
		<div class="col-lg-4"> <textarea  class="form-control" rows="4" cols="300" name="comment"></textarea></div>
		</div>
		<br>
		<div class="row">
		
		<div class="col-lg-10"><center><input type="reset" class="btn btn-danger" value="clear"/> <input type="submit" class="btn btn-primary" value="submit"/></center></div>
		</div>
		</form>
   </div>
</div>
   