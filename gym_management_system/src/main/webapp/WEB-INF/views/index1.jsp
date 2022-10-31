 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gym Management System</title>
   <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="<spring:url value='/ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'/>"></script>
<link rel="stylesheet" href="<spring:url value='/css/admin_trainer.css'/>" type="text/css" />
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-2"> </div>
            <div class="col-lg-6 col-md-8 login-box">
                <div class="col-lg-12 login-key">
                    <i class="fa fa-key" aria-hidden="true"></i>
                </div>
                <div class="col-lg-12 login-title">
                    
                </div>
<h1><a class="btn btn-outline-primary" href='<spring:url value="/trainer/login"/>'>Trainer Login</a></h1>
<h1><a class="btn btn-outline-primary" href='<spring:url value="/admin/login"/>'>Admin Login</a></h1>
<h1><a class="btn btn-outline-primary" href='<spring:url value="/member/login"/>'>Member Login</a></h1>
                
                <div class="col-lg-3 col-md-2"></div>
            </div>
        </div>
</div>

</body>
</html>



