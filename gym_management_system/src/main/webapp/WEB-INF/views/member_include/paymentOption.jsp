
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
			<li class="breadcrumb-item active">My Dashboard</li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h3
				style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		</div>
		<div class="container py-5">
			<!-- For demo purpose -->
			<div class="row mb-4">
				<div class="col-lg-8 mx-auto text-center">
						<div class="alert alert-primary text-center" role="alert">
			<h1> Payment Amount ${requestScope.amount}</h1>
		</div>
					<h1 class="display-6">Choose Payment Option</h1>
				</div>
			</div>
			<!-- End -->
			<div class="row">
				<div class="col-lg-6 mx-auto">
					<div class="card ">
						<div class="card-header">
							<div class="bg-white shadow-sm pt-4 pl-2 pr-2 pb-2">
								<!-- Credit card form tabs -->
								<ul role="tablist"
									class="nav bg-light nav-pills rounded nav-fill mb-3">
									<li class="nav-item"><a data-toggle="pill"
										href="#credit-card" class="nav-link active "> <i
											class="fas fa-credit-card mr-2"></i> Credit Card
									</a></li>
									<li class="nav-item"><a data-toggle="pill" href="#paypal"
										class="nav-link "> <i class="fab fa-paypal mr-2"></i> UPI
									</a></li>
									
								</ul>
							</div>
							<!-- End -->
							<!-- Credit card form content -->
							<div class="tab-content">
								<!-- credit card info-->
								<div id="credit-card" class="tab-pane fade show active pt-3">
									<form role="form" method="post" action='<spring:url value="/member/cardPayment"/>'>
										<div class="form-group">
											<label for="username">
												<h6>Card Owner</h6>
											</label>
											<input type="hidden" name="amount" value="${requestScope.amount}"/>
											 <input type="text" name="username"
												placeholder="Card Owner Name" required class="form-control ">
										</div>
										<div class="form-group">
											<label for="cardNumber">
												<h6>Card number</h6>
											</label>
											<div class="input-group">
												<input type="text" name="cardNumber"
													placeholder="Valid card number" class="form-control "
													required>
												<div class="input-group-append">
													<span class="input-group-text text-muted"> <i
														class="fab fa-cc-visa mx-1"></i> <i
														class="fab fa-cc-mastercard mx-1"></i> <i
														class="fab fa-cc-amex mx-1"></i>
													</span>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-8">
												<div class="form-group">
													<label><span class="hidden-xs">
															<h6>Expiration Date</h6>
													</span></label>
													<div class="input-group">
														<input type="number" placeholder="MM" name="month"
															class="form-control" required> <input
															type="number" placeholder="YY" name="year"
															class="form-control" required>
													</div>
												</div>
											</div>
											<div class="col-sm-4">
												<div class="form-group mb-4">
													<label data-toggle="tooltip"
														title="Three digit CV code on the back of your card">
														<h6>
															CVV <i class="fa fa-question-circle d-inline"></i>
														</h6>
													</label> <input type="text" name="cvv" required
														class="form-control">
												</div>
											</div>
										</div>
										<div class="card-footer">
											<input type="submit" value="Confirm Payment" class="subscribe btn btn-primary btn-block shadow-sm"/>
									</form>
								</div>
							</div>
							<!-- End -->
							<!-- Paypal info -->
							<div id="paypal" class="tab-pane fade pt-3">
							<form method="post" action='<spring:url value="/member/upiPayment"/>'>
								<h6 class="pb-2">Enter Your Upi Id</h6>
								<div class="form-group ">
									
										<div class="input-group">
										<input type="hidden" name="amount" value="${requestScope.amount}"/>
											<input type="text"  name="upi"
												class="form-control" required> 
										</div>
								</div>
								<p>
									<i class="fab fa-paypal mr-2"></i><input type="submit" class="btn btn-primary " value="Process Payment">
										
									</button>
									</form>
								</p>
								<p class="text-muted">Note: After clicking on the button,
									you will be directed to a secure gateway for payment. After
									completing the payment process, you will be redirected back to
									the website to view details of your order.</p>
							</div>
							<!-- End -->
							<!-- bank transfer info -->
							
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>