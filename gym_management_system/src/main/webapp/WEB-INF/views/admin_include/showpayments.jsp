   
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Layout </a>
        </li>
        <li class="breadcrumb-item active">Page Payments</li>
      </ol>
   <div class="alert alert-primary text-center" role="alert">
			<h2>Payments List</h2>
			<h3
				style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${sessionScope.message}</h3>
		</div>
		
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">payment Mode</th>
							<th scope="col">Amount</th>
							<th scope="col">Payment Date</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="payment" items="${sessionScope.paymentList}">
							<tr>
								<td scope="row">${payment.id}</td>
								<td>${payment.paymentMode}</td>
								<td>${payment.amount}</td>
								<td>${payment.paymentDate}</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
   </div>
</div>
   