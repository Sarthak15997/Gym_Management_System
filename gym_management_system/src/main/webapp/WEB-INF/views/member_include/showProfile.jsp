   
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  <div class="content-wrapper">
    <div class="container-fluid">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">My Profile</a>
        </li>
        <li class="breadcrumb-item active">Show Profile</li>
      </ol>
    

			<div class="tab-content no-border padding-24">
				<div id="home" class="tab-pane in active">
					<div class="row">
						<div class="col-xs-12 col-sm-3 center">
							<span class="profile-picture">
								<img  class="editable img-responsive" style="width: 350px; height: 350px;" alt=" profile Image" id="avatar2" src="data:image/jpeg;base64,${myInfo.imgUtility}">
							</span>

							<div class="space space-4"></div>

						
						</div><!-- /.col -->

						<div class="col-xs-12 col-sm-9">
							<h4 class="blue">
								<span style="margin-left: 10%;"class="text-center">Full name:${myInfo.name}</span>
							</h4>

							<div class="profile-user-info">
								<div class="profile-info-row">
									<div class="profile-info-name"> Mobile No :${myInfo.mobileNo} </div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name"> Email :${myInfo.email} </div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name"> Address :${myInfo.address} </div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name"> Date Of Birth :${myInfo.dateOfBirth} </div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name"> Joined: ${myInfo.joinDate} </div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name"> Gym Start Time: ${myInfo.startTime} </div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name"> Gym End Time: ${myInfo.endTime} </div>
								</div>
							</div>

							
								</div>
								</div>
								</div>
								</div>
								
   </div>
</div>
   