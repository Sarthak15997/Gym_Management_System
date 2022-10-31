
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Activity</a></li>
			<li class="breadcrumb-item active">Check Diet</li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Diet Information</h2>
			<h3
				style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<a style="float: right;" class="btn btn-primary" href='<spring:url value="/trainer/add_diet"/>'>Add Diet</a>
		</div>
		<form method="post" action='<spring:url value="/trainer/searchDiet"/>'>
		<div class="row">
			<div class="col-lg-2">
				<h5>Select Member</h5>
			</div>
			<div class="col-lg-4">
				<select name="member" id="member" class="form_control">
				<c:forEach items="${memberList}" var="m">
				<option value="${m.id}">${m.name}</option>
				</c:forEach>
				</select>
			</div>
			<div  class="col-lg-2">
			<button class="btn btn-primary">Search</button>
			</div>
			</form>
		</div>
		<hr>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Date</th>
							<th scope="col">Break Fast</th>
							<th scope="col">Lunch</th>
							<th scope="col">Evening Snacks</th>
							<th scope="col">Dinner</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="diet" items="${dietInfoUser}">
							<tr>
								<td scope="row">${diet.forDate}</td>
								<td>${diet.breakFast}</td>
								<td>${diet.lunch}</td>
								<td>${diet.eveningSnacks}</td>
								<td>${diet.dinner}</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
