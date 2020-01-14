<%@page import="java.util.List" %>
<%@page import ="dev.sgp.entite.Collaborateur"%>
<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.css">
</head>
<body>
<div class="row">
			<div class="col-12 col-lg-4 col-md-6 col-sm-8 col-xs-12">
				<div class="card mb-2">
					<h5 class="card-header">NOM Prénom</h5>
					<div class="card-body">
						<div class="row no-gutters">
							<div class="media">
								<img class="align-self-center" src="Profile.svg" alt="Profile picture" height="100" width="100">
							</div>
							<div class="media-body">
								<ul class="card-text pl-2">
								<%  List<Collaborateur> collaborateurs = (List<Collaborateur>) request.getAttribute("listeC");
	for (Collaborateur c : collaborateurs) {%>
									<li>Fonction :<%= c.getNom()%> </li>
									<li>Département : <%= c.getPrenom()%></li>
									<li>Email :<%= c.getEmail()%></li>
									<li>Téléphone :<%= c.getNumeroSecu()%></li>
									<%}	%>
								</ul>
							</div>
						</div>
					</div>
					<div class="card-footer">
						<div class="btn-edit text-right">
							<a href="editer.html" class="btn btn-primary text-right">Edit</a>
						</div>
					</div>
				</div>
			</div>
	
	
		<li></li>
		
		</ul>

</body>
</html>