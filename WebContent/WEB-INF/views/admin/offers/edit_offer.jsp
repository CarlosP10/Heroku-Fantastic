<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Todos</title>
<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link
	href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<link href="../resources/css/bootstrap.css" media="all" type="text/css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900"
	rel="stylesheet">
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">

<link rel="stylesheet" href="./resources/css/normalize.css">
<link rel="stylesheet" href="./resources/css/ofertasDia.css">
<link rel="stylesheet" href="./resources/css/specific_offer.css">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/resources/css/sb-admin.css"
	rel="stylesheet">
</head>
<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1">Dashboard</a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<a class="nav-link " href="${pageContext.request.contextPath}/logout">
				<button class="btn btn-outline-danger btn-sm btn-block">Logout</button>
			</a>
		</ul>

	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/view_offers"> <i
					class="fas fa-fw fa-users"></i> <span>Ofertas</span>
			</a></li>
<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/account/list"> <i
					class="fas fa-fw fa-users"></i> <span>Cuentas</span>
			</a></li>
		</ul>

		<div id="content-wrapper">

			<div class="container-fluid">
				<!-- DataTables Example -->
				<div
					class="col-sm-10 col-md-10 col-lg-10 offset-sm-1 offset-md-1 offset-lg-1">

					<!-- 					AQUIII TIENE QUE IR EL CONTENIDO -->

					<form
						action="${pageContext.request.contextPath}/admin/save_edit_offer/${offer.idoffer}"
						method="post">
						<div class="anuncio">
							<div class="card shadow mb-4"
								style="margin-left: 100px; margin-right: 100px;">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Informacion
										general</h6>
								</div>
								<div class="card-body">
									<div class="form-group">
										<label for="inputPoster">(URL)</label> <input type="text"
											class="form-control" id="inputPoster" name="urlposter"
											aria-describedby="posterHelp" required
											value="${offer.urlposter}"> <small id="posterHelp"
											class="form-text text-muted">Ingresa la url de la
											imagen relacionada a la oferta.</small>
									</div>
									<div class="form-group">
										<label for="inputName">Nombre Oferta</label> <input
											type="text" class="form-control" id="inputName"
											name="offername" aria-describedby="nameHelp" required
											value="${offer.offername}"> <small id="nameHelp"
											class="form-text text-muted">Ingrese el nombre de la
											oferta.</small>
									</div>
									<div class="form-group">
										<label for="offer_type_list">Tipo de Oferta</label> <select
											id="offer_type_list" class="form-control" name="type"
											required value="${offer.type}">

											<c:forEach items="${offer_type_list}" var="offer_type_list">
												<option value="${offer_type_list.idtype}">${offer_type_list.type}</option>
											</c:forEach>
										</select>

									</div>
								</div>
							</div>
							<div class="card shadow mb-4"
								style="margin-left: 100px; margin-right: 100px;">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Descripcion
										de la oferta</h6>
								</div>
								<div class="card-body">
									<div class="form-group">
										<label for="inputName">Descripcion</label> <input type="text"
											class="form-control" id="inputName" name="description"
											aria-describedby="nameHelp" required
											value="${offer.description}"> <small id="nameHelp"
											class="form-text text-muted">Ingrese descripcion
											detallada de la oferta</small>
									</div>
								</div>
							</div>

							<div class="row" style="margin-left: 90px; margin-right: 90px">

								<!-- Earnings (Monthly) Card Example -->
								<div class="col-xl-3 col-md-6 mb-4">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">
													<div
														class="text-xs font-weight-bold text-primary text-uppercase mb-1">
														Precio</div>
													<div class="h5 mb-0 font-weight-bold text-gray-800">
														<div class="form-group">
															<label for="inputName">Precio</label> <input
																type="number" class="form-control" id="inputName"
																name="price_range" min="0" aria-describedby="nameHelp"
																required value="${offer.price_range}"> <small
																id="nameHelp" class="form-text text-muted">Ingrese
																el precio de la oferta.</small>
														</div>
													</div>
												</div>
												<div class="col-auto">
													<i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- Earnings (Monthly) Card Example -->
								<div class="col-xl-3 col-md-6 mb-4">
									<div class="card border-left-success shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">
													<div
														class="text-xs font-weight-bold text-success text-uppercase mb-1">Disponibilidad</div>
													<div class="h5 mb-0 font-weight-bold text-gray-800">
														<div class="form-group">
															<label for="inputName">Limite de cupones</label> <input
																type="number" class="form-control" id="inputName"
																name="availability" min="0" aria-describedby="nameHelp"
																required value="${offer.availability}"> <small
																id="nameHelp" class="form-text text-muted">Ingrese
																la cantidad maxima de los cupones</small>
														</div>
													</div>
												</div>
												<div class="col-auto">
													<i class="fas fa-comments fa-2x text-gray-300"></i>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- Earnings (Monthly) Card Example -->
								<div class="col-xl-3 col-md-6 mb-4">
									<div class="card border-left-info shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">
													<div
														class="text-xs font-weight-bold text-info text-uppercase mb-1">Fecha
														Inicio</div>
													<div class="row no-gutters align-items-center">
														<div class="col-auto">
															<div class="h5 mb-0 font-weight-bold text-gray-800">
																<div class="form-group">
																	<fmt:formatDate pattern="yyyy-MM-dd"
																		value="${offer.startdate}" var="theFormattedDate" />
																	<input type="date" class="form-control" id="fechainc"
																		min="2019-01-01" max="2100-12-31" name="startdate"
																		required value="${theFormattedDate}"> <small
																		id="nameHelp" class="form-text text-muted">Ingrese
																		la fecha de inicio de la oferta</small>
																</div>
															</div>
														</div>

													</div>
												</div>
												<div class="col-auto">
													<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- Earnings (Monthly) Card Example -->
								<div class="col-xl-3 col-md-6 mb-4">
									<div class="card border-left-info shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">
													<div
														class="text-xs font-weight-bold text-info text-uppercase mb-1">Fecha
														Fin</div>
													<div class="row no-gutters align-items-center">
														<div class="col-auto">
															<div class="h5 mb-0 font-weight-bold text-gray-800">
																<div class="form-group">
																	<fmt:formatDate pattern="yyyy-MM-dd"
																		value="${offer.startdate}" var="theFormattedDateStart" />
																	<fmt:formatDate pattern="yyyy-MM-dd"
																		value="${offer.enddate}" var="theFormattedDate" />
																	<input type="date" class="form-control" id="fechainc"
																		min="${theFormattedDateStart}" max="2100-12-31"
																		name="enddate" required value="${theFormattedDate}">
																	<small id="nameHelp" class="form-text text-muted">Ingrese
																		la fecha de fin de la oferta</small>
																</div>
															</div>
														</div>

													</div>
												</div>
												<div class="col-auto">
													<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- Pending Requests Card Example -->
								<div class="col-xl-3 col-md-6 mb-4">
									<div class="card border-left-warning shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">
													<div
														class="text-xs font-weight-bold text-warning text-uppercase mb-1">Codigo</div>
													<div class="h5 mb-0 font-weight-bold text-gray-800">
														<input type="text" class="form-control" id="inputName"
															name="offer_code" aria-describedby="nameHelp" required
															value="${offer.offer_code}">
													</div>
												</div>
												<div class="col-auto">
													<i class="fas fa-qrcode fa-2x text-gray-300"></i>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!--Agregando estado de la oferta  -->
								<div class="col-xl-3 col-md-6 mb-4">
									<div class="card border-left-warning shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">
													<div
														class="text-xs font-weight-bold text-success text-uppercase mb-1">Estado</div>
													<div class="h5 mb-0 font-weight-bold text-gray-800 ">
														<label class="switch align-items-center"> <input
															type="checkbox" name="offer_state" value="1"
															style="color: #428bca;"> <input type="hidden"
															name="offer_state" value="0">
														</label>
													</div>
												</div>
												<div class="col-auto">
													<i class="far fa-check-circle fa-2x text-gray-300"></i>
												</div>
											</div>
										</div>
									</div>
								</div>


							</div>

							
							<button type="submit" class="btn-outline-success btn "
								value="Submit"
								style="width: 500px; margin-right: 100px; margin-left: 100px">Guardar</button>

						</div>

					</form>

				</div>

			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © Ingenieria de Software 2019</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

</body>
</html>