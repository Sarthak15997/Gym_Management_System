   
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Trainer</a>
        </li>
        <li class="breadcrumb-item active">Request for Trainer Change</li>
      </ol>
   <div class="alert alert-primary text-center" role="alert">
			<h2>Trainer List</h2>
			<h3
				style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		</div>
		
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Trainer Name</th>
							<th scope="col">Trainer Mobile No</th>
							<th scope="col">Experience</th>
							<th scope="col">Status</th>
							<th scope="col">Request</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="trainer" items="${requestScope.tainerInfo}">
							<tr>
								<td scope="row">${trainer.id}</td>
								<td>${trainer.name}</td>
								<td>${trainer.mobileNo}</td>
								<td>${trainer.experience}</td>
								<td>${trainer.status}</td>
								<td><a
									href='<spring:url value="/member/requestTrainer?tid=${trainer.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="far fa-request"></i>
										</button></a> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
   </div>
</div>
   