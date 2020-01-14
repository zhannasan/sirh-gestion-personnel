package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;
import dev.sgp.util.Matricule;

public class CreerCollaborateurController extends HttpServlet {
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	//String matricule;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("nomError", false);
		req.setAttribute("prenomError", false);
		req.setAttribute("dateNaissanceError", false);
		req.setAttribute("adresseError", false);
		req.setAttribute("numeroSecuError", false);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/collab/creerCollaborateur.jsp").forward(req,
				resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ----- get domain name
		ResourceBundle myConfig = ResourceBundle.getBundle("application");
		String domain = myConfig.getString("sgp.domain");

		resp.setContentType("text/html");
		Map<String, String> params = new HashMap<>();
		List<String> nullParams = new ArrayList<>();
		for (Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
			params.put(entry.getKey(), entry.getValue()[0]);
		}

		for (Entry<String, String> entryP : params.entrySet()) {
			String key = entryP.getKey();
			String value = entryP.getValue();
			if (value == null || value.trim().equals("")) {
				resp.setStatus(400);
				req.setAttribute(key + "Error", true);
				nullParams.add(key);
				System.out.println(key + "Error");
			}
			req.setAttribute(key, value);
		}

		String nom = "", prenom = "", adresse = "", numeroSecu = "";
		LocalDate dateNaissance = LocalDate.now();
		if (nullParams.isEmpty()) {
			for (Entry<String, String> entry : params.entrySet()) {
				if (entry.getKey().equals("nom")) {
					nom = entry.getValue();
				} else if (entry.getKey().equals("prenom")) {
					prenom = entry.getValue();
				} else if (entry.getKey().equals("adresse")) {
					adresse = entry.getValue();
				} else if (entry.getKey().equals("dateNaissance")) {
					String date = entry.getValue();
					dateNaissance = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				} else if (entry.getKey().equals("numeroSecu")) {
					numeroSecu = entry.getValue();
				}
			}
		}

		// ------creation d'un collaborateur
		Collaborateur collab = new Collaborateur(nom, prenom, dateNaissance, adresse, numeroSecu);
		ZonedDateTime dateHeureCreation = ZonedDateTime.now();
		collab.setDateHeureCreation(dateHeureCreation);
		String email = prenom + "." + nom + "@" + domain;
		collab.setEmail(email);
		String matricule = Matricule.creerMatricule();
		/*boolean alreadyM = collabService.listerCollaborateurs().stream().filter(c -> c.getMatricule() != null)
				.anyMatch(c -> matricule.equals(c.getMatricule()));
		if (alreadyM == true) {
			matricule += 1;
		}*/
		collab.setMatricule(matricule);
		collab.setActif(true);
		collab.setDepartement("");
		collab.setIntitulePoste("");
		collab.setTelephone("");
		collab.setBanque("");
		collab.setBic("");
		collab.setIban("");
		// add to list
		req.getSession().setAttribute("matricule", matricule);
		collabService.sauvegarderCollaborateur(collab);

		resp.sendRedirect("/sgp/collaborateurs/lister");

	}
}
