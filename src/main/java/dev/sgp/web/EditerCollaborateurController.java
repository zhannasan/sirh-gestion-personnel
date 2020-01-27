package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

public class EditerCollaborateurController extends HttpServlet{
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private DepartementService deptService = Constantes.DEPT_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricule=req.getParameter("matricule");
		Collaborateur editCollab = collabService.rechercherCollaborateur(matricule);
		req.setAttribute("editCollab", editCollab);
		req.setAttribute("matricule", matricule);
		List<Departement> departements = deptService.listerDepartement();
		req.setAttribute("listeD", departements);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp").forward(req, resp);
			
}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		resp.setContentType("text/html");
		String matricule = (String) req.getAttribute("matricule");
		if(matricule==null){
			matricule=(String)req.getAttribute("matricule");
		}
		System.out.println(matricule);
		boolean actif = false;
		if (req.getParameter("actif").equals("on") && req.getParameter("actif")!=null){
			actif=true;
		}else{
			actif=false;
		}
		String telephone=req.getParameter("telephone");
		String departement = req.getParameter("departement");
		String intitulePoste = req.getParameter("intitulePoste");
		
		String banque = req.getParameter("banque");
		String iban = req.getParameter("iban");
		String bic = req.getParameter("bic");
		Collaborateur collab = collabService.rechercherCollaborateur(req.getParameter("matricule"));
		System.out.println(collab.toString());
		collab.setActif(actif);
	
		collab.setTelephone(telephone);
		collab.setDepartement(departement);
		collab.setIntitulePoste(intitulePoste);
		collab.setBanque(banque);
		collab.setIban(iban);
		collab.setBic(bic);		

		resp.sendRedirect("/sgp/collaborateurs/lister");
	}	
}
