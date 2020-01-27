<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html lang="fr">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-tofit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<c:url value="/bootstrap-4.4.1-dist/css/bootstrap.css"/>">
<link rel="stylesheet" type="text/css"	href="<c:url value="/style.css"/>">
<title>SGP - Editer</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#"><img src="<c:url value="/LogoFish.svg"/>"
				height="40" width="40"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="<c:url value="/collaborateurs/lister"/>">Collaborateurs
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value="/collaborateurs/stats"/>">Statistiques</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="activites.html">Activités</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>

	<div class=container-fluid>
		<form name="editerCollabForm"
			action="<c:url value="/collaborateurs/editer"/>"
			method="post">
			<c:set var="ec" value="${requestScope.editCollab}"/>
			<c:out value ="${ec.prenom}"/>
			<div class="row mt-3">
				<div class="col align-self-start mr-3">
					<div class="text-right">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input" name="actif"
								id="defaultUnchecked"> 
							<label class="custom-control-label" for="defaultUnchecked">Désactiver</label>
						</div>
					</div>
				</div>
			</div>
			<div class="row mt-1">
				<div
					class="col-12 col-lg-3 col-md-4 col-sm-4 col-xs-12 offset-1 mt-5">
					<img src="<c:url value="/Profile.svg"/>"
						alt="Profile picture" height="220" width="220">
				</div>
				<!--Accordion-->
				<div class="col-12 col-lg-7 col-md-12 col-sm-12 col-xs-12">
					<h1><c:out value ="${fn:toUpperCase(ec.nom)}"/> <c:out value ="${ec.prenom}"/> - <c:out value ="${ec.matricule}"/></h1>
					<div class="accordion" id="accordionEdit">
						<div class="card">
							<div class="card-header" id="headingOne">
								<h2 class="mb-0">
									<button class="btn btn-link" type="button" id="accordeonBtn"
										data-toggle="collapse" data-target="#collapseOne"
										aria-expanded="true" aria-controls="collapseOne">
										Identité</button>
								</h2>
							</div>

							<div id="collapseOne" class="collapse"
								aria-labelledby="headingOne" data-parent="#accordionEdit">
								<div class="card-body">
									<div class="row">
										<div class="col-3 col-xs-10 offset-1 text-right">
											<label class="control-label " for="controlSelect1">Civilité</label>
										</div>
										<div class="col-5 col-xs-10">
											<div class="form-select">
												<select class="form-control" id="controlSelect1">
													<option>Madame</option>
													<option>Monsieur</option>
												</select>
											</div>
										</div>
									</div>
									<div class="row mt-3">
										<div class="col-3 offset-1 text-right">
											<label class="control-label" for="formCtrlNom">Nom</label>
										</div>
										<div class="col-5">
											<input type="text" class="form-control" name="nom"
												id="formCtrlNom" value="<c:out value ="${ec.nom}"/>"  readonly>
										</div>
									</div>
									<div class="row mt-3">
										<div class="col-3 offset-1 text-right">
											<label class="control-label" for="formCtrlPrenom">Prénom</label>
										</div>
										<div class="col-5">
											<input type="text" class="form-control" name="prenom"
												id="formCtrlPrenom" value="<c:out value ="${ec.prenom}"/>" readonly>
										</div>
									</div>
									<div class="row mt-3">
										<div class="col-3 offset-1 text-right">
											<label class="control-label" for="formCtrlDate">Date
												de naissance</label>
										</div>
										<div class="col-5">
											<input type="date" class="form-control" name="dateNassance"
												id="formCtrlDate" value="<c:out value ="${ec.dateNaissance}"/>" readonly>
										</div>
									</div>
									<div class="row mt-3">
										<div class="col-3 offset-1 text-right">
											<label class="control-label" for="formCtrlAddresse">Adresse</label>
										</div>
										<div class="col-5">
											<textarea type="text" class="form-control" name="adresse"
												id="formCtrlAddresse" maxlength="400" required><c:out value ="${ec.adresse}"/></textarea>
										</div>
									</div>
									<div class="row mt-3">
										<div class="col-3 offset-1 text-right">
											<label class="control-label" for="formCtrlNSS">Numéro
												de sécurité sociale</label>
										</div>
										<div class="col-5">
											<input type="text" class="form-control" name="numeroSecu"
												id="formCtrlNSS" value="<c:out value ="${ec.numeroSecu}"/>" readonly>
										</div>
									</div>
									<div class="row mt-3">
										<div class="col-3 offset-1 text-right">
											<label class="control-label" for="formCtrlTel">Téléphone</label>
										</div>
										<div class="col-5">
											<input type="text" class="form-control" name="telephone"
												id="formCtrltel" value="<c:out value ="${ec.telephone}"/>">
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--Card 2-->
						<div class="card">
							<div class="card-header" id="headingTwo">
								<h2 class="mb-0">
									<button class="btn btn-link collapsed" type="button"
										id="accordeonBtn" data-toggle="collapse"
										data-target="#collapseTwo" aria-expanded="false"
										aria-controls="collapseTwo">Poste</button>
								</h2>
							</div>
							<div id="collapseTwo" class="collapse"
								aria-labelledby="headingTwo" data-parent="#accordionEdit">
								<div class="card-body">
									<div class="row mt-3">
										<div class="col-3 offset-1 text-right">
											<label class="control-label" for="formCtrlDept">Département</label>
										</div>
										<div class="col-5">
											<div class="form-select">
												<select class="form-control" name="departement"
													id="formCtrlDept">
													<option></option>
													<c:forEach items="${listeD}" var="d">
														<option><c:out value="${d.nomDept}"/></option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="row mt-3">
										<div class="col-3 offset-1 text-right">
											<label class="control-label" for="formCtrlNomPoste">Intitulé de poste</label>
										</div>
										<div class="col-5">
											<input type="text" class="form-control" name="intitulePoste"
												id="formCtrlNomPoste" value="<c:out value ="${ec.intitulePoste}"/>">
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--Card 3-->
						<div class="card">
							<div class="card-header" id="headingThree">
								<h2 class="mb-0">
									<button class="btn btn-link collapsed" type="button"
										id="accordeonBtn" data-toggle="collapse"
										data-target="#collapseThree" aria-expanded="false"
										aria-controls="collapseThree">Coordonnéees banquaires</button>
								</h2>
							</div>
							<div id="collapseThree" class="collapse"
								aria-labelledby="headingThree" data-parent="#accordionEdit">
								<div class="card-body">
									<div class="row mt-3">
										<div class="col-3 offset-1 text-right">
											<label class="control-label" for="formCtrlIban">Banque</label>
										</div>
										<div class="col-5">
											<input type="text" class="form-control" name="banque"
												id="formCtrlBanque" value="<c:out value ="${ec.banque}"/>">
										</div>
									</div>
									<div class="row mt-3">
										<div class="col-3 offset-1 text-right">
											<label class="control-label" for="formCtrlIban">IBAN</label>
										</div>
										<div class="col-5">
											<input type="text" class="form-control" name="iban"
												id="formCtrlIban" value="<c:out value ="${ec.iban}"/>" pattern="[A-Za-z0-9]{14-34}">
										</div>
									</div>
									<div class="row mt-3">
										<div class="col-3 offset-1 text-right">
											<label class="control-label" for="formCtrlBic">BIC</label>
										</div>
										<div class="col-5">
											<input type="text" class="form-control" name="bic"
												id="formCtrlBic" value="<c:out value ="${ec.bic}"/>" pattern="[A-Za-z0-9]{8-11}">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--Button-->
					<div class="row mt-3">
						<div class="col-5 offset-7">
						<input type="hidden" value="<c:out value="${ec.matricule}"/>" name ="matrcule">
							<button type="submit" class="btn btn-primary float-right"
								value="submit" id="btnSave">Sauvegarder</button>
						</div>
					</div>
			</form>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>