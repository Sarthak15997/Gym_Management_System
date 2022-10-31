   
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Payment Page</li>
      </ol>
       <div class="alert alert-primary text-center" role="alert">
			<h1>Payment Successfull</h1>
		</div>
    	 <div class="alert alert-danger text-center" role="alert">
			<a class ="btn btn-primary"href='<spring:url value="/member/member_dashboard"/>'>Back To dashboard</a>
		</div>
   </div>
</div>
   