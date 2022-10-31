   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Trainer</a>
        </li>
        <li class="breadcrumb-item active">Trainer Details</li>
      </ol>
   <div class="alert alert-primary text-center" role="alert">
			<h2>Trainer Information</h2>
			<h3
				style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		</div>
		
		<div class="row">
			<div class="col-12">
				<h2>Trainer name :${sessionScope.trainerI.name}</h2>
				<h2>Trainer Email :${sessionScope.trainerI.email}</h2>
				<h2>Trainer Mobile :${sessionScope.trainerI.mobileNo}</h2>
				
				
			</div>
		</div>
   </div>
</div>
   