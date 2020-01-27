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
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-tofit=
	no">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>SGP - Statistiques</title>
</head>
<body>
<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#"><img src="LogoFish.svg" height="40" width="40"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item ">
						<a class="nav-link" href="<c:url value="/collaborateurs/lister"/>">Collaborateurs</a>
					</li>
					<li class="nav-item">
						<a class="nav-link active" href="#">Statistiques<span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="activites.html">Activités</a>
					</li>
				</ul>
			</div>
		</nav>
    </header>
    
	<div class="row mt-3">
		<div class="col align-self-start mr-3">
			<div class="text-right">
				<button class="btn btn-primary" id="btnAdd"><a href="creer.html">Ajouter un nouveau collaborateur</a></button>
			</div>
		</div>
    </div>
    
<div class=container-fluid>
  <div class="row mt-3">
    <div class="col-10 offset-1">
      <h1>Statistiques</h1>
    </div>
  </div>
  <div class="row">
    <div class="col-10 offset-1">
    
    <table class="table table-striped table-bordered table-responsive-md">
        <thead>
          <tr>
            <th scope="col">Chemin</th>
            <th scope="col">Nombre de visites</th>
            <th scope="col">Min (ms)</th>
            <th scope="col">Max (ms)</th>
            <th scope="col">Moyenne (ms)</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${stats}" var="s">
          <tr>
            <td><c:out value="${s.path}"/></td>
            <td><c:out value="${s.numberVisits}"/></td>
            <td><c:out value="${s.min}"/></td>
            <td><c:out value="${s.max}"/></td>
            <td><c:out value="${s.moyenne}"/></td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
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