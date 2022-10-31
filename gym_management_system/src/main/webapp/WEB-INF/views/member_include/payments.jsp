   
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Activity</a>
        </li>
        <li class="breadcrumb-item active">Subscribe MemberShip</li>
      </ol>
       <div class="alert alert-danger text-center" role="alert">
			<h3 style="color: purpul; font-size: 30px; font-style:solid; letter-spacing:2px; text-shadow:2px 3px 5px gray; margin-right: 150px; margin-left: 150px;">Special Subscription Packs</h3>
		</div>
     <div class="row">
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-primary o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
              <i class="fa fa-sign-language" aria-hidden="true"></i>
              </div>
               <div class="mr-5">
              <h1>Platinum</h1>
              <h3><i class="fa fa-cubes" aria-hidden="true"></i> 3999  <i class="fa fa-cubes" aria-hidden="true"></i></h3>
              <h4>  6 Monthly</h4>
              <h6> Daily 4 Hrs </h6>
              <h6> 250 G Protein Gift</h6>
              <h6> Steam Room Access</h6>
              <h6> Trainer Guidance</h6>
              <h6> Wifi Password</h6>
              </div>
             
            </div>
            <a class="card-footer text-white clearfix small z-1" href='<spring:url value="/member/processPayment?rs=${3999}"/>'>
              <span class="float-center">Pay </span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-primary bg-warning o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                  <i class="fa fa-sign-language" aria-hidden="true"></i>
              </div>
              
               <div class="mr-5">
              <h1>Gold</h1>
              <h3><i class="fa fa-cubes" aria-hidden="true"></i> 1299  <i class="fa fa-cubes" aria-hidden="true"></i></h3>
              <h4> Monthly</h4>
              <h6> Daily 4 Hrs </h6>
              <h6> 250 G Protein Gift</h6>
              <h6> Steam Room Access</h6>
              <h6> <strike>Trainer Guidance</strike></h6>
              <h6> <strike>Wifi Password</strike></h6>
              </div>
            
            </div>
            <a class="card-footer text-white clearfix small z-1" href='<spring:url value="/member/processPayment?rs=${1299}"/>'>
              <span class="float-left">Pay</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-black bg-light o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                  <i class="fa fa-sign-language" aria-hidden="true"></i>
              </div>
             <div class="mr-5">
              <h1>Silver</h1>
              <h3><i class="fa fa-cubes" aria-hidden="true"></i> 999  <i class="fa fa-cubes" aria-hidden="true"></i></h3>
              <h4> Monthly</h4>
              <h6> Daily 4 Hrs </h6>
              <h6> 250 G Protein Gift</h6>
              <h6> <strike> Steam Room Access</strike></h6>
              <h6> <strike>Trainer Guidance</strike></h6>
              <h6> <strike>Wifi Password</strike> </h6>
              </div>
            </div>
            <a class="card-footer text-dark clearfix small z-1" href='<spring:url value="/member/processPayment?rs=${999}"/>'>
              <span class="float-left">Pay</span>
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
                  <i class="fa fa-sign-language" aria-hidden="true"></i>
              </div>
             <div class="mr-5">
              <h1>Basic</h1>
              <h3><i class="fa fa-cubes" aria-hidden="true"></i> 699  <i class="fa fa-cubes" aria-hidden="true"></i></h3>
              <h4> Monthly</h4>
              <h6> Daily 2 Hrs </h6>
              <h6> 250 G Protein Gift</h6>
              <h6> <strike>Steam Room Access</strike></h6>
              <h6><strike> Trainer Guidance</strike></h6>
              <h6><strike>Wifi Password</strike></h6>
              </div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href='<spring:url value="/member/processPayment?rs=${699}"/>'>
              <span class="float-left">Pay</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
      </div>
   </div>
</div>
   