package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;
import dev.sgp.util.DateFormatMatcher;

public class EditerCollaborateurController extends HttpServlet{
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private DepartementService deptService = Constantes.DEPT_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Collaborateur editCollab = collabService.rechercherCollaborateur((String)req.getSession().getAttribute("matricule")).get();
		req.setAttribute("editCollab", editCollab);
		req.setAttribute("listeDept", deptService.listerDepartement());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp").forward(req, resp);
			
}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		resp.setContentType("text/html");
				
		Map<String, String> params = new HashMap<>();
		List<String> nullParams = new ArrayList<>();
		for (Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
			String key = entry.getKey();
		    String value = entry.getValue()[0];
			if(value==null || value.trim().equals("")){
				resp.setStatus(400);
				req.setAttribute(key+"Error", true);
				nullParams.add(key);
			}
		    params.put(key, value);
		}
		
		String intitulePoste ="",departement ="",banque ="", bic ="", iban="", telephone="";
		LocalDate dateNaissance = LocalDate.now();
		if(nullParams.isEmpty()){
			resp.setStatus(201);
			for (Entry<String, String> entry : params.entrySet()) {
				if(entry.getKey().equals("intitulePoste")){
					intitulePoste = entry.getValue();
				}else if(entry.getKey().equals("departement")){
					departement = entry.getValue();
				}else if(entry.getKey().equals("banque")){
					banque = entry.getValue();
				}else if(entry.getKey().equals("bic")){
					bic = entry.getValue();
				}else if(entry.getKey().equals("iban")){
					iban = entry.getValue();
				}else if(entry.getKey().equals("telephone")){
					telephone = entry.getValue();
				}
				
			}
		}
		resp.setStatus(201);
		Collaborateur collab = collabService.rechercherCollaborateur((String)req.getSession().getAttribute("matricule")).get();
		
		collab.setIntitulePoste(intitulePoste);
		collab.setDepartement(departement);
		collab.setBanque(banque);
		collab.setBic(bic);
		collab.setIban(iban);
		collab.setTelephone(telephone);
		
		System.out.println(intitulePoste+" "+departement+" "+banque+" "+bic+" "+iban);
		//collabService.sauvegarderCollaborateur(collab);
		//req.setAttribute("departement", departement);

		resp.sendRedirect("/sgp/collaborateurs/lister");
	}	
}
