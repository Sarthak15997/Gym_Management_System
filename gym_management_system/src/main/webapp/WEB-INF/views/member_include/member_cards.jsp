   
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">My Dashboard</li>
      </ol>
       <div class="alert alert-primary text-center" role="alert">
			<h3 style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		</div>
     <div class="row">
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-primary o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-comments"></i>
              </div>
              <div class="mr-5">Yesterdayes Diet()
              <h5>Break Fast: ${sessionScope.yesterdayDiet.breakFast}</h5>
              <h5>Lunch: ${sessionScope.yesterdayDiet.lunch}</h5>
              <h5>Evening Snacks: ${sessionScope.yesterdayDiet.eveningSnacks}</h5>
             <h5>Dinner :${sessionScope.yesterdayDiet.dinner}</h5>
              </div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href='<spring:url value="/member/mydiet"/>'>
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-warning o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-list"></i>
              </div>
              <div class="mr-5">Todayes Diet()</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href='<spring:url value="/member/mydiet"/>'>
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-success o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-shopping-cart"></i>
              </div>
              <div class="mr-5">Tomorrows Diet()</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href='<spring:url value="/member/mydiet"/>'>
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-danger o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-support"></i>
              </div>
              <div class="mr-5">(-----)()</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href='<spring:url value="#"/>'>
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
      </div>
   </div>
</div>
   