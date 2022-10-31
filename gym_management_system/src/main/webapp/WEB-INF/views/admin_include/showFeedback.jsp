   
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Feedback</a>
        </li>
        <li class="breadcrumb-item active">Show Feedback</li>
      </ol>
   <div class="alert alert-primary text-center" role="alert">
			<h2>Feedback List</h2>
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
							<th scope="col">Comment</th>
						
						</tr>
					</thead>
					<tbody>
						<c:forEach var="feedback" items="${sessionScope.feedbackList}">
							<tr>
								<td scope="row">${feedback.id}</td>
								<td>${feedback.name}</td>
								<td>${feedback.mobileNo}</td>
								<td>${feedback.email}</td>
								<td>${feedback.comment}</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
   </div>
</div>
   