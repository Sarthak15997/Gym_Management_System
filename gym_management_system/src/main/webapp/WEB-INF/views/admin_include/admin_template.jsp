<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
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
 
<link rel="stylesheet" href="<spring:url value='/css/admin_style.css'/>"
	type="text/css" />

	 <script>$("#sidenavToggler").click(function(e) {
	    e.preventDefault();
	    $("body").toggleClass("sidenav-toggled");
	    $(".navbar-sidenav .nav-link-collapse").addClass("collapsed");
	    $(".navbar-sidenav .sidenav-second-level, .navbar-sidenav .sidenav-third-level").removeClass("show");
	  });</script>
	<script type="text/javascript" src="<spring:url value='/js/admin_dashboard.js'/>"></script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="<spring:url value='/admin/admin_dashboard'/>">${sessionScope.adminDetails.name}</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="<spring:url value='/admin/admin_dashboard'/>">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Dashboard</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="layout">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#layout" data-parent="#exampleAccordion">
             <i class="fa fa-fw fa-sitemap"></i>
            <span class="nav-link-text">Layout</span>
          </a>
            <ul class="sidenav-second-level collapse" id="layout">
            <li>  
              <a href="<spring:url value='/admin/showpayments'/>"> <i class="fa fa-fw fa-link"></i> Payments</a>
            </li>
            
          </ul>
        </li>
         <li class="nav-item" data-toggle="tooltip" data-placement="right" title="vendor">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#vendor" data-parent="#exampleAccordion">
              <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">Trainer</span>
          </a>
            <ul class="sidenav-second-level collapse" id="vendor">
            <li>  
              <a href="<spring:url value='/admin/trainer_details'/>">  <i class="fa fa-fw fa-file"></i> Trainer Details</a>
            </li>
            <li>
              <a href="<spring:url value='/admin/trainer_registration'/>"><i class="fa fa-fw fa-file"></i>Trainer Registration</a>
            </li>

          </ul>
        </li>
      
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Member</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseComponents">
            <li>
              <a href="<spring:url value='/admin/member_details'/>">Member Details</a>
            </li>
            <li>
              <a href="<spring:url value='/admin/member_registration'/>">Member Registration</a>
            </li>
          </ul>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="<spring:url value='/admin/showFeedback'/>">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">FeedBAck</span>
          </a>
        </li>
        
         
           
          </ul>
        </li>
        
      </ul>
      
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
 
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-bell"></i>
            <span class="d-lg-none">Payments
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="alertsDropdown">
            <h6 class="dropdown-header">Payment Alerts:</h6>
            <div class="dropdown-divider"></div>
            <c:forEach var="payment" items="${sessionScope.paymentList}">
            <a class="dropdown-item" href='<spring:url value="/admin/showpayments"/>'>
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>${payment.username}</strong>
              </span>
              
              <div class="dropdown-message small"> ${payment.amount} recived on ${payment.paymentDate} Via ${payment.paymentMode}</div>
            </a>
            </c:forEach>
            <div class="dropdown-divider"></div>
            </div>
            
        </li>
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Search for...">
              <span class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>