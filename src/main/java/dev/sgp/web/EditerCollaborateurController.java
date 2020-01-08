package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String matricule = req.getParameter("matricule");
		
		resp.setContentType("text/html");
		if(matricule==null){
			resp.setStatus(400);
			resp.getWriter().write("Un matricule est attendu");
		}else{
			resp.setStatus(200);
			resp.getWriter().write("Matricule:"+ matricule);
		}
}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String matricule = req.getParameter("matricule");
		String titre = req.getParameter("titre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		
		Map<String, String> params = new HashMap<>();
		params.put("matricule", matricule);
		params.put("titre",titre);
		params.put("nom",nom);
		params.put("prenom",prenom);
		
		List<String> nullParams = new ArrayList<>();
		resp.setContentType("text/html");
		for(Map.Entry<String,String> entry : params.entrySet()){
			if(entry.getValue()==null){
				nullParams.add(entry.getKey());
			}
		}
		
		if(!nullParams.isEmpty()){
			resp.setStatus(400);
			resp.getWriter().write("Les paramètres suivants sont incorrects :"+"<ul>");
			for(String s : nullParams){
				resp.getWriter().write("<li>"+s+"</li>");
			}
			resp.getWriter().write("</ul>");
		}else{
			resp.getWriter().write("<ul>");
			for(Map.Entry<String,String> entry : params.entrySet()){	
				resp.setStatus(201);
				resp.getWriter().write("<li>"+entry.getKey()+" : "+entry.getValue()+"</li>");
			}
			resp.getWriter().write("</ul>");
		}
	}	
}
