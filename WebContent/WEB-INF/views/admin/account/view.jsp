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
					class="col-sm-10 col-md-8 col-lg-8 offset-sm-1 offset-md-2 offset-lg-2">
					<h1>Ver Usuario</h1>


					<div class="form-group">
						<label for="inputName">Nombre</label> <input type="text"
							class="form-control" id="inputName" name="uname"
							aria-describedby="nameHelp" value="${account.user.name}"
							readonly> <small id="nameHelp"
							class="form-text text-muted">Nombre persona.</small>
					</div>

					<div class="form-group">
						<label for="inputLastName">Apellido</label> <input type="text"
							class="form-control" id="inputLastName" name="ulastname"
							aria-describedby="lastnameHelp" value="${account.user.ulastname}"
							readonly> <small id="lastnameHelp"
							class="form-text text-muted">Apellido persona.</small>
					</div>

					<div class="form-group">
						<label for="inputBirthdate">Fecha Nacimiento</label> <input
							type="text" class="form-control" id="inputBirthdate"
							name="ubirthdate" aria-describedby="birthdateHelp"
							value="${account.user.ubirthdate}" readonly> <small
							id="birthdateHelp" class="form-text text-muted">Fecha de
							Nacimiento.</small>
					</div>

					<div class="form-group">
						<label for="inputPoster">Pais</label> <input type="text"
							class="form-control" id="inputCountry" name="ucountry"
							aria-describedby="countryHelp" value="${account.user.country}"
							readonly> <small id="countryHelp"
							class="form-text text-muted">Pais de la persona.</small>
					</div>
					<div class="form-group">
						<label for="inputMunicipality">Municipio</label> <input
							type="text" class="form-control" id="inputMunicipality"
							name="umunicipality" aria-describedby="municipalityHelp"
							value="${account.user.municipality}" readonly> <small
							id="municipalityHelp" class="form-text text-muted">Municipio
							de la persona.</small>
					</div>


					<div class="form-group">
						<label for="inputUsername">Username</label> <input type="text"
							class="form-control" id="inputUsername" name="username"
							aria-describedby="usernameHelp" value="${account.username}"
							readonly> <small id="usernameHelp"
							class="form-text text-muted">Nombre de Usuario.</small>
					</div>
					<div class="form-group">
						<label for="inputPassword">Password</label> <input type="text"
							class="form-control" id="inputPassword" name="password"
							aria-describedby="passwordHelp" value="${account.password}"
							readonly> <small id="passwordHelp"
							class="form-text text-muted"> Contraseña de Usuario.</small>
					</div>


					<input type="text" class="form-control" id="inputState name="
						activestate" aria-describedby="activestateHelp"
						value="${account.activestate}" readonly hidden> <input
						type="text" class="form-control" id="inputOnline"
						name="onlinestatus" aria-describedby="OnlineHelp"
						value="${account.onlinestatus}" readonly hidden>

					<div class="form-group">
						<label for="inputState">Estado del usuario</label> <br>
						<c:set var="active" value="${account.activestate}" />
						<c:if test="${active<1}">
							<td><a class="btn btn-danger btn-sm">Inactivo</a></td>
						</c:if>
						<c:if test="${active>0}">
							<td><a class="btn btn-success btn-sm")" >Activo</a></td>
						</c:if>

						<small id="activestateHelp" class="form-text text-muted">Estado
							activo o inactivo</small>
					</div>
					<div class="form-group">
						<label for="inputOnline">Online</label> <br>
						<c:set var="onlinestatus" value="${account.onlinestatus}" />
						<c:if test="${onlinestatus<1}">

							<td><a class="btn btn-danger btn-sm">Inactivo</a></td>
						</c:if>
						<c:if test="${onlinestatus>0}">
							<td><a class="btn btn-success btn-sm">Activo</a></td>
						</c:if>
						<small id="OnlineHelp" class="form-text text-muted">
							Estado Online.</small>
					</div>

					<div class="form-group">
						<label for="inputComentario">Comentario</label> <input type="text"
							class="form-control" id="inputComentario" name="comment"
							aria-describedby="commentHelp" value="${account.comment}"
							readonly> <small id="commentHelp"
							class="form-text text-muted">Comentario en caso de ser
							desactivado.</small>
					</div>
					

					<div class="form-group">
						<label for="inputRole">Rol</label> <input type="text"
							class="form-control" id="inputCredit" name="idrole"
							aria-describedby="roleHelp" value="${account.role.role}" readonly>
						<small id="roleHelp" class="form-text text-muted"> Rol del
							usuario.</small>
					</div>
				</div>
				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
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