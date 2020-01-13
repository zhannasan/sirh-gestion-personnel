<%@page import="java.util.List" %>
<%@page import ="dev.sgp.entite.Collaborateur"%>
<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-tofit=
	no">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>SGP - Créer</title>
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
					<li class="nav-item active">
						<a class="nav-link" href="index.html">Collaborateurs <span class="sr-only">(current)</span></a>
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

<div class=container-fluid>
	<div class="row mt-3">
		<div class="csol-10 offset-1">
			<h1>Nouveau Collaborateur</h1>
		</div>
	</div>
	<form name="creerCollabForm" id="creerCollabForm" action="<%=request.getContextPath()%>/collaborateurs/creer" method="post">
		<div class ="row mt-3">
			<div class="col-3 offset-1">
				<label class="control-label" for="formCtrlNom">Nom</label>
			</div>
			<div class="col-5">
				<input type="text" class="form-control" name="nom" id="formCtrlNom" required>
			</div>
		</div>
		<div class ="row mt-3">
			<div class="col-3 offset-1">
				<label class="control-label" for="formCtrlPrenom">Prénom</label>
			</div>
			<div class="col-5">
				<input type="text" class="form-control" name="prenom" id="formCtrlPrenom" required>
			</div>
		</div>
		<div class ="row mt-3">
			<div class="col-3 offset-1">
				<label class="control-label" for="formCtrlDate">Date de naissance</label>
			</div>
			<div class="col-5">
				<input type="date" class="form-control" name="dateNaissance" id="formCtrlDate" required>
			</div>
		</div>
		<div class ="row mt-3">
			<div class="col-3 offset-1">
				<label class="control-label" for="formCtrlAdresse">Adresse</label>
			</div>
			<div class="col-5">
				<textarea type="text" class="form-control" name="adresse" id="formCtrlAdresse" maxlength="400" required></textarea>
			</div>
		</div>
		<div class ="row mt-3">
			<div class="col-3 offset-1">
				<label class="control-label" for="formCtrlNSS">Numéro de sécurité sociale</label>
			</div>
			<div class="col-5">
				<input type="text" class="form-control" name="numeroSecu" id="formCtrlNSS" required pattern="[0-9]{15}">
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-5 offset-4">
			 <button type="button" class="btn btn-primary float-right" data-toggle="modal" data-target="#confirmModal" onclick="showCollab()">Créer</button>
			 <!--<button type="submit" class="btn btn-primary float-right" value="submit" id="btnCreer">Créer</button>-->
			 </div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Vous êtes sur le point de créer un nouveau collaborateur</h5>
		      </div>
		      <div class="modal-body">
		      	
		      </div>
		      <div class="modal-footer">
		        <button type="reset" class="btn btn-secondary" data-dismiss="modal" value="reset">Annuler</button>
		        <button type="submit" class="btn btn-secondary" data-dismiss="modal"name="save" onclick="form_submit()" value="submit" id="confirmerBtn">Confirmer</button>
		      </div>
		    	</div>
		  	  </div>
		</div>

	</form>
</div>
<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<!--<script type="text/javascript" src="src/main/resources/static/js/custom.js"></script>-->
<script>
function showCollab() {
		 $(".modal-body").html('<p>Nom : '+ $("#formCtrlNom").val()+'<br>'+
	                'Prénom : '+$("#formCtrlPrenom").val()+'<br>'+
		    	    'Addresse : '+$("#formCtrlAdresse").val()+'<br>'+
		    		'Numéro de sécurité sociale :'+$("#formCtrlNSS").val()+'</p>');
	 };
	 </script>
<script>
 function form_submit(){
	document.creerCollabForm.submit();
}
</script>
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