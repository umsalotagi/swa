<%@page import="com.swapasya.domains.Person"%>
<%@page import="com.swapasya.model.DBConnect"%>
<%@page import="com.swapasya.repo.PersonRepositoryMongoDB,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Gentelella Alela! |</title>

<!-- Bootstrap -->
<link href="./vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="./vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="./vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- iCheck -->
<link href="./vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- bootstrap-progressbar -->
<link
	href="./vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet">
<!-- PNotify -->
<link href="./vendors/pnotify/dist/pnotify.css" rel="stylesheet">
<link href="./vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
<link href="./vendors/pnotify/dist/pnotify.nonblock.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="./build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-paw"></i>
							<span>Gentelella Alela!</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="images/img.jpg" alt="..."
								class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2>John Doe</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>General</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i> Home <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="index.html">Dashboard</a></li>
										<li><a href="index2.html">Dashboard2</a></li>
										<li><a href="index3.html">Dashboard3</a></li>
									</ul></li>
								<li><a><i class="fa fa-edit"></i> Forms <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="form.html">General Form</a></li>
										<li><a href="form_advanced.html">Advanced Components</a></li>
										<li><a href="form_validation.html">Form Validation</a></li>
										<li><a href="form_wizards.html">Form Wizard</a></li>
										<li><a href="form_upload.html">Form Upload</a></li>
										<li><a href="form_buttons.html">Form Buttons</a></li>
									</ul></li>
								<li><a><i class="fa fa-desktop"></i> UI Elements <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="general_elements.html">General Elements</a></li>
										<li><a href="media_gallery.html">Media Gallery</a></li>
										<li><a href="typography.html">Typography</a></li>
										<li><a href="icons.html">Icons</a></li>
										<li><a href="glyphicons.html">Glyphicons</a></li>
										<li><a href="widgets.html">Widgets</a></li>
										<li><a href="invoice.html">Invoice</a></li>
										<li><a href="inbox.html">Inbox</a></li>
										<li><a href="calendar.html">Calendar</a></li>
									</ul></li>
								<li><a><i class="fa fa-table"></i> Tables <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="tables.html">Tables</a></li>
										<li><a href="tables_dynamic.html">Table Dynamic</a></li>
									</ul></li>
								<li><a><i class="fa fa-bar-chart-o"></i> Data
										Presentation <span class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="chartjs.html">Chart JS</a></li>
										<li><a href="chartjs2.html">Chart JS2</a></li>
										<li><a href="morisjs.html">Moris JS</a></li>
										<li><a href="echarts.html">ECharts</a></li>
										<li><a href="other_charts.html">Other Charts</a></li>
									</ul></li>
								<li><a><i class="fa fa-clone"></i>Layouts <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="fixed_sidebar.html">Fixed Sidebar</a></li>
										<li><a href="fixed_footer.html">Fixed Footer</a></li>
									</ul></li>
							</ul>
						</div>
						<div class="menu_section">
							<h3>Live On</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-bug"></i> Additional Pages <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="e_commerce.html">E-commerce</a></li>
										<li><a href="projects.html">Projects</a></li>
										<li><a href="project_detail.html">Project Detail</a></li>
										<li><a href="contacts.html">Contacts</a></li>
										<li><a href="profile.html">Profile</a></li>
									</ul></li>
								<li><a><i class="fa fa-windows"></i> Extras <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="page_403.html">403 Error</a></li>
										<li><a href="page_404.html">404 Error</a></li>
										<li><a href="page_500.html">500 Error</a></li>
										<li><a href="plain_page.html">Plain Page</a></li>
										<li><a href="login.html">Login Page</a></li>
										<li><a href="pricing_tables.html">Pricing Tables</a></li>
									</ul></li>
								<li><a><i class="fa fa-sitemap"></i> Multilevel Menu <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="#level1_1">Level One</a>
										<li><a>Level One<span class="fa fa-chevron-down"></span></a>
											<ul class="nav child_menu">
												<li class="sub_menu"><a href="level2.html">Level
														Two</a></li>
												<li><a href="#level2_1">Level Two</a></li>
												<li><a href="#level2_2">Level Two</a></li>
											</ul></li>
										<li><a href="#level1_2">Level One</a></li>
									</ul></li>
								<li><a href="javascript:void(0)"><i
										class="fa fa-laptop"></i> Landing Page <span
										class="label label-success pull-right">Coming Soon</span></a></li>
							</ul>
						</div>

					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Settings">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
							<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Logout"
							href="login.html"> <span class="glyphicon glyphicon-off"
							aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>

						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;"
								class="user-profile dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false"> <img src="images/img.jpg" alt="">John
									Doe <span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="javascript:;"> Profile</a></li>
									<li><a href="javascript:;"> <span
											class="badge bg-red pull-right">50%</span> <span>Settings</span>
									</a></li>
									<li><a href="javascript:;">Help</a></li>
									<li><a href="login.html"><i
											class="fa fa-sign-out pull-right"></i> Log Out</a></li>
								</ul></li>

							<li role="presentation" class="dropdown"><a
								href="javascript:;" class="dropdown-toggle info-number"
								data-toggle="dropdown" aria-expanded="false"> <i
									class="fa fa-envelope-o"></i> <span class="badge bg-green">6</span>
							</a>
								<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
									role="menu">
									<li><a> <span class="image"><img
												src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li><a> <span class="image"><img
												src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li><a> <span class="image"><img
												src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li><a> <span class="image"><img
												src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li>
										<div class="text-center">
											<a> <strong>See All Alerts</strong> <i
												class="fa fa-angle-right"></i>
											</a>
										</div>
									</li>
								</ul></li>
						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">



				<div class="" role="tabpanel" data-example-id="togglable-tabs">
					<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
						<li role="presentation" class="active"><a
							href="#tab_content1" id="home-tab" role="tab" data-toggle="tab"
							aria-expanded="true">Search User</a></li>
						<li role="presentation" class=""><a href="#tab_content2"
							role="tab" id="profile-tab" data-toggle="tab"
							aria-expanded="false">Add User</a></li>

					</ul>
					<div id="myTabContent" class="tab-content">
						<!--  tab panel first start -->
						<div role="tabpanel" class="tab-pane fade active in"
							id="tab_content1" aria-labelledby="home-tab">

							<div class="">


								<div class="clearfix"></div>

								<div class="">

									<div class="x_panel">
										<div class="x_title">
											<h2>
												Search User <small>search users</small>
											</h2>

											<div class="clearfix"></div>
										</div>
										<div class="x_content">
											<br />
											<form id="demo-form2" data-parsley-validate
												class="form-horizontal form-label-left">




												<div class="form-group">

													<div class="col-md-3 col-sm-3 col-xs-12">
														<select class="form-control">
															<option>Person ID</option>
															<option>Person Name</option>
														</select>
													</div>

													<div class="col-md-9 col-sm-9 col-xs-12">
														<input type="text" id="first-name" required="required"
															class="form-control col-md-7 col-xs-12">
													</div>
												</div>

												<div class="form-group">
													<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
														<button class="btn btn-primary" type="button">Cancel</button>
														<button type="submit" class="btn btn-success">Submit</button>
													</div>
												</div>

											</form>
										</div>
									</div>



									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="x_panel">
											<div class="x_title">
												<h2>
													<i class="fa fa-align-left"></i> Search Results <small></small>
												</h2>
												<!--tool box removed -->
												<div class="clearfix"></div>
											</div>
											<div class="x_content">

												<!-- start accordion -->
												<div class="accordion" id="accordion1" role="tablist"
													aria-multiselectable="true">
													<div class="panel">


														<table id="datatable"
															class="table table-striped table-bordered">
															<thead>
																<tr>
																	<th>Person ID</th>
																	<th>Person Name</th>
																	<th>Role</th>
																	<th>Class</th>
																	<th>Address</th>

																</tr>
															</thead>
															
															
															<tbody>
																
																<%! List<Person> users; 
																//	List<Object> justForAuth;
																
																%>
																<%
																
																String search=request.getParameter("search");
																String txt=request.getParameter("txt");
																
																
																if(search!=null && txt!=null){
																	PersonRepositoryMongoDB personRepo=new PersonRepositoryMongoDB(DBConnect.getConnection());
														if("Person ID".equals(search))
														{
															users = new ArrayList <Person> ();
															users.add(personRepo.findOne(txt));	
														}
														else if("Person Name".equals(search))
														{
															users=personRepo.findByName(txt);	
														}
														
																
																%>
																
																<% Iterator<Person> i=users.iterator(); 
																
																while(i.hasNext()){
																	Person user=i.next();
																%>
																<tr>
																	<%--<td><%=o %></td> --%>
																	
																	
																	<td><a ng-href="#" ng-click="select(PersonId='<%=user.getPersonID()%>')"><%=user.getPersonID()%> </a></td>
																	<td><%=user.getPersonName()%></td>
																	<td><%=user.getRole()%></td>
																	<td><%=user.getDegree() + " " + user.getBranch() + " " + user.getDivision() + " " + user.getRollNo() %></td>
																	<td><%=user.getPermanentAddress().getCity()%></td> 
															</tr>
																<%}%>
																
																<% }%>
															</tbody>
														</table>


													</div>
												</div>
											</div>

										</div>
										<!-- end of accordion -->

									</div>

									<!--                 </div>
              </div> -->

									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="x_panel" id="redirected1">
											<div class="x_title">
												<h2>
													<i class="fa fa-align-left"></i> Person Details <small></small>
												</h2>
												<!--      <button class="btn btn-app">Edit</button>-->
												<div class="pull-right">
													<a class="btn btn-round btn-info" href="form_edituser.html">
														<i class="fa fa-edit"> </i> Edit
													</a>
												</div>
												<div class="clearfix"></div>
											</div>
											<div class="x_content">

												<!-- start accordion -->
												<div class="accordion" id="accordion" role="tablist"
													aria-multiselectable="true">

													<div class="panel ">

														<div class="col-sm-9 invoice-col">
															<b>Person ID: </b> B13455 <br> <b>Name: </b> 4F3S8J
															<br> <b>Role: </b> 2/22/2014 <br> <b>Degree:
															</b> 968-34567 <br> <b>Branch: </b> 968-34567 <br>
															<b>Class: </b> 968-34567 <br> <b>Mobile: </b>
															968-34567 <br> <b>E-mail: </b> 968-34567 <br> <b>Admission
																Date: </b> 968-34567 <br> <b>Parent Name: </b>
															968-34567 <br> <b>Parent Contact: </b> 968-34567 <br>
															<b>Current Address: </b> 968-34567 <br> <b>Permanent
																Address: </b> 968-34567 <br> <br>
														</div>

														<div class="col-md-3 col-sm-3 col-xs-12 profile_right">
															<div class="profile_img">
																<div id="crop-avatar">
																	<!-- Current avatar -->
																	<img class="img-responsive avatar-view"
																		src="images/picture.jpg" alt="Avatar"
																		title="Change the avatar">
																</div>
															</div>
														</div>

														<div class="clearfix"></div>


													</div>

													<div class="panel">
														<a class="panel-heading collapsed" role="tab"
															id="headingThree" data-toggle="collapse"
															href="#collapseThree" aria-expanded="false"
															aria-controls="collapseThree">
															<h4 class="panel-title">Wait Listed</h4>
														</a>
														<div id="collapseThree" class="panel-collapse collapse"
															role="tabpanel" aria-labelledby="headingThree">
															<div class="panel-body">

																<table id="" class="table table-striped table-bordered">
																	<thead>
																		<tr>
																			<th>#</th>
																			<th>Book ID</th>
																			<th>Book Title</th>
																			<th>Author</th>
																		</tr>
																	</thead>


																	<tbody>
																		<tr>
																			<td>1</td>
																			<td>System Architect</td>
																			<td>Edinburgh</td>
																			<td>System Architect</td>
																		</tr>
																		<tr>
																			<td>2</td>
																			<td>Accountant</td>
																			<td>Tokyo</td>
																			<td>System Architect</td>
																		</tr>
																		<tr>
																			<td>3</td>
																			<td>Junior Technical Author</td>
																			<td>San Francisco</td>
																			<td>System Architect</td>
																		</tr>
																	</tbody>
																</table>

															</div>
														</div>
													</div>


													<div class="panel">
														<a class="panel-heading collapsed" role="tab"
															id="headingThree1" data-toggle="collapse"
															href="#collapseThree1" aria-expanded="false"
															aria-controls="collapseThree">
															<h4 class="panel-title">Assigned</h4>
														</a>
														<div id="collapseThree1" class="panel-collapse collapse"
															role="tabpanel" aria-labelledby="headingThree">
															<div class="panel-body">

																<table id="" class="table table-striped table-bordered">
																	<thead>
																		<tr>
																			<th>#</th>
																			<th>Book ID</th>
																			<th>Book Title</th>
																			<th>Time</th>
																		</tr>
																	</thead>


																	<tbody>
																		<tr>
																			<td>1</td>
																			<td>System Architect</td>
																			<td>Edinburgh</td>
																			<td>Accountant</td>
																		</tr>
																		<tr>
																			<td>2</td>
																			<td>Accountant</td>
																			<td>Tokyo</td>
																			<td>Accountant</td>
																		</tr>
																		<tr>
																			<td>3</td>
																			<td>Junior Technical Author</td>
																			<td>San Francisco</td>
																			<td>Accountant</td>
																		</tr>
																	</tbody>
																</table>


															</div>
														</div>
													</div>



													<div class="panel">
														<a class="panel-heading  collapsed" role="tab"
															id="headingOne" data-toggle="collapse"
															href="#collapseOne" aria-expanded="false"
															aria-controls="collapseOne">
															<h4 class="panel-title">Books In Possession</h4>
														</a>
														<div id="collapseOne" class="panel-collapse collapse in"
															role="tabpanel" aria-labelledby="headingOne">
															<div class="panel-body">


																<table id="datatable2"
																	class="table table-striped table-bordered">
																	<thead>
																		<tr>
																			<th>Book ID</th>
																			<th>Book Title</th>
																			<th>Issue Date</th>
																			<th>Issue Type</th>
																			<th>Exp. Return</th>
																		</tr>
																	</thead>


																	<tbody>
																		<tr>
																			<td>Tiger Nixon</td>
																			<td>System Architect</td>
																			<td>Edinburgh</td>
																			<td>System Architect</td>
																			<td>Edinburgh</td>
																		</tr>
																		<tr>
																			<td>Garrett Winters</td>
																			<td>Accountant</td>
																			<td>Tokyo</td>
																			<td>Accountant</td>
																			<td>Edinburgh</td>
																		</tr>
																		<tr>
																			<td>Ashton Cox</td>
																			<td>Junior Technical Author</td>
																			<td>San Francisco</td>
																			<td>Junior Technical Author</td>
																			<td>Edinburgh</td>
																		</tr>
																	</tbody>
																</table>




															</div>
														</div>
													</div>



												</div>
												<!-- end of accordion -->


											</div>
										</div>
									</div>

									<div class="clearfix"></div>

								</div>


							</div>
						</div>
						<!--  tab panel first ended -->
						<div class="clearfix"></div>

						<!--  Tab panel second -->
						<div role="tabpanel" class="tab-pane fade" id="tab_content2"
							aria-labelledby="profile-tab">




							<div class="row">



								<div class="col-md-12 col-xs-12">
									<div class="x_panel">
										<div class="x_title">
											<h2>
												Add User <small>add user</small>
											</h2>
											<ul class="nav navbar-right panel_toolbox">
												<li><a class="collapse-link"><i
														class="fa fa-chevron-up"></i></a></li>
												<li class="dropdown"><a href="#"
													class="dropdown-toggle" data-toggle="dropdown"
													role="button" aria-expanded="false"><i
														class="fa fa-wrench"></i></a>
													<ul class="dropdown-menu" role="menu">
														<li><a href="#">Settings 1</a></li>
														<li><a href="#">Settings 2</a></li>
													</ul></li>
												<li><a class="close-link"><i class="fa fa-close"></i></a>
												</li>
											</ul>
											<div class="clearfix"></div>
										</div>
										<div class="x_content">
											<br />

											<form class="form-horizontal form-label-left" novalidate>

												<!--                       <span class="section">Personal Info</span> -->

												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Person ID <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input id="name" class="form-control col-md-7 col-xs-12"
															data-validate-length-range="6" data-validate-words="2"
															name="name" placeholder="first name e.g John"
															required="required" type="text">
													</div>
												</div>
												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="email">Email <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input type="email" id="email" name="email"
															required="required"
															class="form-control col-md-7 col-xs-12">
													</div>
												</div>

												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="telephone">Mobile No. </label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input type="tel" id="telephone" name="phone"
															data-validate-length-range="8,20"
															class="form-control col-md-7 col-xs-12">
													</div>
												</div>

												<div class="item form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="name">Role <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input id="name" class="form-control col-md-7 col-xs-12"
															data-validate-length-range="6" data-validate-words="2"
															name="name" placeholder="e.g Teacher, Student"
															required="required" type="text">
													</div>
												</div>


												<div class="ln_solid"></div>
												<div class="form-group">
													<div class="col-md-6 col-md-offset-3">
														<button type="submit" class="btn btn-primary">Cancel</button>
														<button id="send" type="submit" class="btn btn-success">Submit</button>
													</div>
												</div>
											</form>


										</div>
									</div>
								</div>





								<div class="clearfix"></div>

								<div class="">

									<div class="x_panel">
										<div class="x_title">
											<h2>
												Search UnValidated User <small>search unvalidated
													users</small>
											</h2>

											<div class="clearfix"></div>
										</div>
										<div class="x_content">
											<br />
											<form id="demo-form2" data-parsley-validate
												class="form-horizontal form-label-left">




												<div class="form-group">

													<div class="col-md-3 col-sm-3 col-xs-12">
														<select class="form-control">
															<option>Person ID</option>
															<option>Person Name</option>
														</select>
													</div>

													<div class="col-md-9 col-sm-9 col-xs-12">
														<input type="text" id="first-name" required="required"
															class="form-control col-md-7 col-xs-12">
													</div>
												</div>

												<div class="form-group">
													<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
														<button class="btn btn-primary" type="button">Cancel</button>
														<button type="submit" class="btn btn-success">Submit</button>
													</div>
												</div>

											</form>
										</div>
									</div>



									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="x_panel">
											<div class="x_title">
												<h2>
													<i class="fa fa-align-left"></i> Search Results <small></small>
												</h2>
												<!--tool box removed -->
												<div class="clearfix"></div>
											</div>
											<div class="x_content">

													<div class="panel">
													<div class="panel-body">

														<table id="datatable-checkbox"
															class="table table-striped table-bordered">
															<thead>
																<tr>
																	<th>Person ID</th>
																	<th>Person Name</th>
																	<th>Roll No.</th>
																	<th>Class</th>
																	<th>Address</th>

																</tr>
															</thead>

															<tbody>
																<tr>
																	<td><a href="form_editbook.html">Tiger Nixon
																	</a></td>
																	<td><a href="form_editbook.html">System
																			Architect</a></td>
																	<td><a href="form_editbook.html">Edinburgh</a></td>
																	<td><a href="form_editbook.html">61</a></td>
																	<td><a href="form_editbook.html">2011/04/25</a></td>
																</tr>
																<tr>
																	<td><a href="form_editbook.html">Garrett
																			Winters</a></td>
																	<td><a href="form_editbook.html">Accountant</a></td>
																	<td><a href="form_editbook.html">Tokyo</a></td>
																	<td><a href="form_editbook.html">63</a></td>
																	<td><a href="form_editbook.html">2011/07/25</a></td>
																</tr>
																<tr>
																	<td><a href="form_editbook.html">Ashton Cox</a></td>
																	<td><a href="form_editbook.html">Junior
																			Technical Author</a></td>
																	<td><a href="form_editbook.html">San
																			Francisco</a></td>
																	<td><a href="form_editbook.html">66</a></td>
																	<td><a href="form_editbook.html">2009/01/12</a></td>
																</tr>
															</tbody>
														</table>


													</div>
													</div>
													<div class="clearfix"></div>
												</div>
											</div>

									</div>



									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="x_panel" id="redirected1">
											<div class="x_title">
												<h2>
													<i class="fa fa-align-left"></i> Person Details <small></small>
												</h2>
												<!--      <button class="btn btn-app">Edit</button>-->
												<div class="pull-right">
													<a class="btn btn-round btn-info"> <i
														class="fa fa-edit"> </i> Validate User
													</a>
												</div>
												<div class="clearfix"></div>
											</div>
											<div class="x_content">

													<div class="panel ">

														<div class="col-sm-9 invoice-col">
															<b>Person ID: </b> B13455 <br> <b>Name: </b> 4F3S8J
															<br> <b>Role: </b> 2/22/2014 <br> <b>Degree:
															</b> 968-34567 <br> <b>Branch: </b> 968-34567 <br>
															<b>Class: </b> 968-34567 <br> <b>Mobile: </b>
															968-34567 <br> <b>E-mail: </b> 968-34567 <br> <b>Admission
																Date: </b> 968-34567 <br> <b>Parent Name: </b>
															968-34567 <br> <b>Parent Contact: </b> 968-34567 <br>
															<b>Current Address: </b> 968-34567 <br> <b>Permanent
																Address: </b> 968-34567 <br> <br>
														</div>

														<div class="col-md-3 col-sm-3 col-xs-12 profile_right">
															<div class="profile_img">
																<div id="crop-avatar">
																	<!-- Current avatar -->
																	<img class="img-responsive avatar-view"
																		src="images/picture.jpg" alt="Avatar"
																		title="Change the avatar">
																</div>
															</div>
														</div>

														<div class="clearfix"></div>


													</div>
												</div>
										</div>
									</div>
								</div>


							</div>








						</div>

					</div>
				</div>
				<!--  total tabpanel complete -->






				<div class="clearfix"></div>
			</div>
			<!-- /page content -->

			<!-- footer content -->
			<footer>
				<div class="pull-right">
					Gentelella - Bootstrap Admin Template by <a
						href="https://colorlib.com">Colorlib</a>
				</div>
				<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
		</div>
	</div>

	<div id="custom_notifications" class="custom-notifications dsp_none">
		<ul class="list-unstyled notifications clearfix"
			data-tabbed_notifications="notif-group">
		</ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div>
	</div>

	<!-- jQuery -->
	<script src="./vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="./vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="./vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="./vendors/nprogress/nprogress.js"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="./vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- iCheck -->
	<script src="./vendors/iCheck/icheck.min.js"></script>
	<!-- PNotify -->
	<script src="./vendors/pnotify/dist/pnotify.js"></script>
	<script src="./vendors/pnotify/dist/pnotify.buttons.js"></script>
	<script src="./vendors/pnotify/dist/pnotify.nonblock.js"></script>

	<!-- jQuery Tags Input -->
	<script src="./vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>

	<!-- validator -->
	<script src="./vendors/validator/validator.js"></script>

	<!-- jquery.inputmask -->
	<script
		src="./vendors/jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js"></script>

	<!-- Datatables -->
	<script src="./vendors/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="./vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script
		src="./vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
		
		
		<!-- Datatables -->
     <script src="./vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
         <script src="./vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="./vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="./vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="./build/js/custom.min.js"></script>



</body>
</html>