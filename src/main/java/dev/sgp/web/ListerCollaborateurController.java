package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class ListerCollaborateurController extends HttpServlet {
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
		req.getSession().setAttribute("listeC", collaborateurs);

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req,
				resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String rechNomPrenom = req.getParameter("nomPrenom");
		String rechDept = req.getParameter("rechDept");
		List<Collaborateur> collabsTrouve = collabService.rechercherCollaborateurs(rechNomPrenom, rechDept);
		req.getSession().setAttribute("listeT", collabsTrouve);
		
		resp.sendRedirect("/sgp/collaborateurs/chercher");
	}

}
