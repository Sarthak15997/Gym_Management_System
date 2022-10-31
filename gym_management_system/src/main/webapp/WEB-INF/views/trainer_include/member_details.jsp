   
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Member</a>
        </li>
        <li class="breadcrumb-item active">Member Details</li>
      </ol>
   <div class="alert alert-primary text-center" role="alert">
			<h2>Member List</h2>
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
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="member" items="${sessionScope.memberList}">
							<tr>
								<td scope="row">${member.id}</td>
								<td>${member.name}</td>
								<td>${member.mobileNo}</td>
								<td>${member.email}</td>
								<td><a
									href='<spring:url value="/trainer/member_delete?mid=${member.id}"/>'><button
											type="button" class="btn btn-danger">
											<i class="far fa-trash-alt"></i>
										</button></a> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
   </div>
</div>
   