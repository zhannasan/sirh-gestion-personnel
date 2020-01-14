<%@page import="java.util.List" %>
<%@page import ="dev.sgp.entite.Collaborateur"%>
<%@page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#"><img src="<%=request.getContextPath()%>/LogoFish.svg" height="40" width="40"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="#">Collaborateurs <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="stats.html">Statistiques</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="activites.html">Activités</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<!--Button-->
	<div class="row mt-3">
		<div class="col align-self-start mr-3">
			<div class="text-right">
				<button class="btn btn-primary" id="btnAdd"><a href="<%=request.getContextPath()%>/collaborateurs/creer">Ajouter un nouveau collaborateur</a></button>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row mt-3">
			<div class="col-10 offset-0">
				<h1>Les Collaborateurs</h1>
			</div>
		</div>
		<form name="searchCollab" action="<%=request.getContextPath()%>/collaborateurs/lister" method="get">
			<div class="form-group row mt-2">
					<div class="col-12 col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12 text-right">
						<label class="control-label" for="search1">Rechercher un nom ou un prénom qui commence par :</label>
					</div>
					<div class="col-12 col-xl-3 col-lg-3 col-md-4 col-sm-4 col-xs-12 mb-2">
						<input class="form-control" type="search" placeholder="Rechercher" aria-label="Rechercher" name="nomPrenom" id="search1">
					</div>
					<div class="col-12 col-xl-1 col-lg-1 col-md-2 col-sm-2 col-xs-12 mb-2">
						<button class="btn btn-primary" type="submit">Rechercher</button>
					</div>
					<div class="col-12 col-xl-4 col-lg-4 col-md-5 col-sm-8 col-xs-12">
						<div class="form-check pl-0">
								<div class="custom-control custom-checkbox">
										<input type="checkbox" class="custom-control-input" id="defaultUnchecked">
										<label class="custom-control-label" for="defaultUnchecked">Voir les collaborateurs désactivés</label>
								</div>
						</div>
					</div>
			</div>
				
			<div class ="form-group row mt-2">
				<div class="col-12 col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12 text-right">
						<label class="control-label" for="controlSelect1">Filtrer par département :</label>
				</div>
				<div class="col-12 col-xl-3 col-lg-3 col-md-3 col-sm-4 col-xs-12">
					<div class="form-select">
						<select class="form-control" id="controlSelect1" name="rechDept">
							<option>Tous</option>
							<option>Comptabilité</option>
							<option>Ressources Humaines</option>
							<option>Informatique</option>
							</select>
					</div>
				</div>
				</div>
		</form>

		<div class="row">
		<%  List<Collaborateur> collaborateurs = (List<Collaborateur>) request.getAttribute("listeC");
										for (Collaborateur c : collaborateurs) {%>
			<div class="col-12 col-lg-4 col-md-6 col-sm-8 col-xs-12">
				<div class="card mb-2">
					<h5 class="card-header"><%=c.getNom().toUpperCase()%> <%=c.getPrenom()%></h5>
					<div class="card-body">
						<div class="row no-gutters">
							<div class="media">
								<img class="align-self-center" src="<%=request.getContextPath()%>/Profile.svg" alt="Profile picture" height="100" width="100">
							</div>
							<div class="media-body">
								<ul class="card-text pl-2">
										<li>Fonction : <%= c.getIntitulePoste()%></li>
										<li>Département : <%= c.getDepartement()%></li>
										<li>Email : <%= c.getEmail()%></li>
										<li>Téléphone : <%= c.getTelephone()%></li>
										
									</ul>
							</div>
						</div>
					</div>
					<div class="card-footer">
						<div class="btn-edit text-right">
							<a href="<%=request.getContextPath()%>/collaborateurs/editer" class="btn btn-primary text-right">Edit</a>
						</div>
					</div>
				</div>
			</div>
			<%}	%>

		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-
	J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
	<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
</body>
</html>