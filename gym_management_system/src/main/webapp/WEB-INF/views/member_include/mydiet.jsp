   
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">My Activities</a>
        </li>
        <li class="breadcrumb-item active">Diet Details</li>
      </ol>
   <div class="alert alert-primary text-center" role="alert">
			<h2>Todayes Diet Information</h2>
			<h3
				style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		</div>
		
		<div class="row">
			<div class="col-12">
				<h2>Break Fast :${sessionScope.dietInfo.breakFast}</h2>
				<h2>Lunch :${sessionScope.dietInfo.lunch}</h2>
				<h2>Evening Snacks :${sessionScope.dietInfo.eveningSnacks}</h2>
					<h2>Dinner :${sessionScope.dietInfo.dinner}</h2>
				
			</div>
		</div>
   </div>
</div>
   