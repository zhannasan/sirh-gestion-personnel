package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		Map<String, String> params = new HashMap<>();
		for (Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue()[0];
		    params.put(key, value);
		}
		for(Map.Entry<String,String> entry : params.entrySet()){
			if(entry.getValue()==null || entry.getValue().trim().equals("")){
				resp.setStatus(400);
				req.setAttribute("error"+entry.getKey(), true);
			}
		}
		
		List<String> nullParams = new ArrayList<>();
		
		for(Map.Entry<String,String> entry : params.entrySet()){
			if(entry.getValue()==null || entry.getValue().trim().equals("")){
				nullParams.add(entry.getKey());
			}
		}
		
		resp.setStatus(200);
			
}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		Map<String, String> params = new HashMap<>();
		for (Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue()[0];
		    params.put(key, value);
		}
		for(Map.Entry<String,String> entry : params.entrySet()){
			if(entry.getValue()==null || entry.getValue().trim().equals("")){
				resp.setStatus(400);
				req.setAttribute("error"+entry.getKey(), true);
			}
		}
		
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
			resp.getWriter().write("Creation d'un collaborateur avec les informations suivantes :<ul>");
			for(Map.Entry<String,String> entry : params.entrySet()){	
				resp.setStatus(201);
				resp.getWriter().write("<li>"+entry.getKey()+" : "+entry.getValue()+"</li>");
			}
			resp.getWriter().write("</ul>");
		}
		resp.sendRedirect("/sgp/collaborateurs/editer");
	}	
}
