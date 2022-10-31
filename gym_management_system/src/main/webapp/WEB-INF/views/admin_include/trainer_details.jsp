
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Trainer</a></li>
			<li class="breadcrumb-item active">Trainer Details</li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Trainer List</h2>
			<h3
				style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${sessionScope.message}</h3>
		</div>

		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Name</th>
							<th scope="col">Mobile No</th>
							<th scope="col">Email</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="trainer" items="${sessionScope.trainerList}">
							<tr>
								<td scope="row">${trainer.id}</td>
								<td>${trainer.name}</td>
								<td>${trainer.mobileNo}</td>
								<td>${trainer.email}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
