   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Activity</a>
        </li>
        <li class="breadcrumb-item active">Excercise</li>
      </ol>ExcerciseImage
      
       <div class="alert alert-primary text-center" role="alert">
			<h3 style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		</div>
		<c:forEach var="e" items="${sessionScope.excerciseImage}">
     <img src="data:image/jpeg;base64,${e.imgUtility}" alt='${e.title}' height=60% width=80%/>
     </c:forEach>
   </div>
</div>
   