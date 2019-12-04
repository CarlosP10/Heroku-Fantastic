<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Offer</title>
<link href="../resources/css/bootstrap.css" media="all" type="text/css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900"
	rel="stylesheet">
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">

<link rel="stylesheet" href="../resources/css/normalize.css">
<link rel="stylesheet" href="../resources/css/ofertasDia.css">
<link rel="stylesheet" href="../resources/css/specific_offer.css">
</head>
<body>
	<header class="site-header">
		<div class="contenedor contenido-header">
			<h2>FantasticCode</h2>
			<div>
				<nav id="navegacion" class="navegacion">
					<a href="nosotros.html">Nosotros</a> <a href="anuncios.html">Anuncios</a>
					<a href="blog.html">Blog</a> <a href="contacto.html">Contacto</a>
				</nav>
			</div>
		</div>
	</header>
	<div class="anuncio">
		<img alt="Anuncio 1" src="${specific_offer.urlposter}"
			class="imageOfferSpecific">
		<div class="btn btn-outline-dark"
			style="display: block; font-size: 20px; margin-left: 100px; margin-right: 100px;">
			${specific_offer.offername}</div>

		<div class="card shadow mb-4"
			style="margin-left: 100px; margin-right: 100px;">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Descripcion de la
					Oferta</h6>
			</div>
			<div class="card-body">${specific_offer.description}</div>
		</div>

		<div class="row" style="margin-left: 90px; margin-right: 90px">

			<!-- Earnings (Monthly) Card Example -->
			<div class="col-xl-3 col-md-6 mb-4">
				<div class="card border-left-primary shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div
									class="text-xs font-weight-bold text-primary text-uppercase mb-1">Precio
								</div>
								<div class="h5 mb-0 font-weight-bold text-gray-800">${specific_offer.price_range}</div>
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
									class="text-xs font-weight-bold text-success text-uppercase mb-1">Cupones
									Disponibles</div>
								<div class="h5 mb-0 font-weight-bold text-gray-800">${specific_offer.availability}</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-comments fa-2x text-gray-300"></i>
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
									class="text-xs font-weight-bold text-warning text-uppercase mb-1">Fecha
									inicio</div>
								<fmt:formatDate pattern="yyyy-MM-dd"
									value="${specific_offer.startdate}" var="theFormattedDate" />
								<div class="h5 mb-0 font-weight-bold text-gray-800">${theFormattedDate}</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-calendar fa-2x text-gray-300"></i>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-xl-3 col-md-6 mb-4">
				<div class="card border-left-warning shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div
									class="text-xs font-weight-bold text-warning text-uppercase mb-1">Fecha
									Fin</div>
								<fmt:formatDate pattern="yyyy-MM-dd"
									value="${specific_offer.enddate}" var="theFormattedDate" />
								<div class="h5 mb-0 font-weight-bold text-gray-800">${theFormattedDate}</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-calendar fa-2x text-gray-300"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<a href="${pageContext.request.contextPath}/show_offer"
		class="boton boton-amarillo"
		style="display: block; margin-left: 100px; margin-right: 100px; margin-bottom: 30px; border-radius: 10px">Reservar</a>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous" type="text/javascript"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js"
	integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP"
	crossorigin="anonymous" type="text/javascript"></script>
<script src="https://kit.fontawesome.com/38aafe1360.js"
	crossorigin="anonymous"></script>
</html>