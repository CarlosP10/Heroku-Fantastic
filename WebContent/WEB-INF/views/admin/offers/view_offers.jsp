<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<!-- Custom fonts for this template-->
<link href="./../resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link href="./../resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="./../resources/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
			<li class="nav-item"><a class="nav-link"
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
					<h1>Listado Ofertas Registradas</h1>
					<div class="btn-toolbar justify-content-between" role="toolbar"
						aria-label="Toolbar with button groups">
						<div class="btn-group" role="group">
							<a class="btn btn-secondary"
								href=" ${pageContext.request.contextPath}/admin/new_offer">Nueva
								Oferta</a>
						</div>
						<div class="btn-group align-rigth" role="group"
							aria-label="Button group with nested dropdown">
							<c:if test="${pagina > 1}">
								<a
									href=" ${pageContext.request.contextPath}/function/list?page=${pagina-2}"
									class="btn btn-secondary">Anterior</a>
							</c:if>

							<c:if test="${pagina < total/10}">
								<a
									href=" ${pageContext.request.contextPath}/function/list?page=${pagina}"
									class="btn btn-secondary">Siguiente</a>
							</c:if>
						</div>
					</div>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Accion</th>
								<th scope="col">Codigo</th>
								<th scope="col">Nombre Oferta</th>
								<th scope="col">Disponibilidad</th>
								<th scope="col">Fecha Inicio</th>
								<th scope="col">Fecha Fin</th>
								<th scope="col">Estado</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${offer_list}" var="offer_list">
								<tr>
									<td>
										<div class="btn-group">
											<a
												href="${pageContext.request.contextPath}/admin/view_offer/${offer_list.idoffer}"
												class="btn btn-dark">Ver</a> <a
												href="${pageContext.request.contextPath}/admin/edit_offer/${offer_list.idoffer}"
												class="btn btn-secondary">Editar</a> <a
												href="${pageContext.request.contextPath}/admin/delete_offer/${offer_list.idoffer}"
												class="btn btn-secondary">Eliminar</a>
										</div>
									</td>
									<td>${offer_list.idoffer}</td>
									<td>${offer_list.offername}</td>
									<td>${offer_list.availability}</td>
									<fmt:formatDate pattern="yyyy-MM-dd"
										value="${offer_list.startdate}" var="theFormattedDate" />
									<td>${theFormattedDate}</td>
									<fmt:formatDate pattern="yyyy-MM-dd"
										value="${offer_list.enddate}" var="theFormattedDate" />
									<td>${theFormattedDate}</td>
									<c:set var="active" value="${offer_list.offer_state}" />
									<c:if test="${active<1}">
										<td><a class="btn btn-danger btn-sm">Inactivo</a></td>
									</c:if>
									<c:if test="${active>0}">
										<td><a class="btn btn-success btn-sm")" >Activo</a></td>
									</c:if>

								</tr>
							</c:forEach>
						</tbody>


					</table>
					<p class="text-right">Mostrando ${actual}/${total}</p>
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

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>



	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin.min.js"></script>



</body>

</html>