package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

public class RechercherCollaborateurController extends HttpServlet {
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private DepartementService deptService = Constantes.DEPT_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateur.jsp").forward(req, resp);
}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		resp.setContentType("text/html");
		
	
	}
	
}
