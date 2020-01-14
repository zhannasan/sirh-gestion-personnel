package dev.sgp.web;

import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;
import dev.sgp.util.DateFormatMatcher;

public class CreerCollaborateurController extends HttpServlet {
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("nom", "");
		req.setAttribute("prenom", "");
		req.setAttribute("dateNaissance", "");
		req.setAttribute("adresse", "");
		req.setAttribute("numeroSecu", "");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/collab/creerCollaborateur.jsp").forward(req, resp);
}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");	
		Map<String, String> params = new HashMap<>();
		for (Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
		    String key = entry.getKey();
		    System.out.println(entry.getKey()+" "+entry.getValue()[0] );
		    if(entry.getValue()[0]==null || entry.getValue()[0].trim().equals("")){
		    	resp.setStatus(400);
		    	req.setAttribute("nom", false);
		    }
		    String value = entry.getValue()[0];
	    	params.put(key, value);
		}
		
		for(Map.Entry<String,String> entry : params.entrySet()){
			String nom = entry.getValue();
			
		}
				resp.setStatus(201);
				//for(Map.Entry<String,String> entry : params.entrySet()){
					String nom = req.getParameter("nom");
					String prenom = req.getParameter("prenom");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			    	String date = req.getParameter("dateNaissance");
			        LocalDate dateNaissance = LocalDate.parse(date, formatter);
			    	
					String adresse = req.getParameter("adresse");
					String numeroSecu = req.getParameter("numeroSecu");
				
				//----- get domain name
						ResourceBundle myConfig = ResourceBundle.getBundle("application");
						Enumeration<String> keys = myConfig.getKeys();
						String domain = "";
						while (keys.hasMoreElements()) {
							String key=keys.nextElement();
							if(key.contains("domain")){
								domain = myConfig.getString(key);
							}
						}
						//-----check the age
						if(Period.between(LocalDate.now(), dateNaissance).toTotalMonths()/12 < 18){
							
						}
							
						
						Collaborateur collab = new Collaborateur(nom, prenom, dateNaissance, adresse, numeroSecu);
						ZonedDateTime dateHeureCreation = ZonedDateTime.now();
						collab.setDateHeureCreation(dateHeureCreation);
						collab.setEmail(prenom+"."+nom+"@"+domain);
						collab.setActif(true);
						System.out.println(collab.toString());
						//add to list
						collabService.sauvegarderCollaborateur(collab);
						req.setAttribute("nouveauC", collab);
						resp.sendRedirect("/sgp/collaborateurs/lister");
		
		
	}	
}
