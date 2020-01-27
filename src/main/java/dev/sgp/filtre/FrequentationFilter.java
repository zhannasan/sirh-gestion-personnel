package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

@WebFilter("/stats")
public class FrequentationFilter implements Filter{
	private VisiteWebService visiteService = Constantes.FREQ_SERVICE;
	private FilterConfig config;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {		
		this.config = filterConfig;
		config.getServletContext().log("FrequentationFilter initialized");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long start = System.currentTimeMillis();
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		String path = ((HttpServletRequest)request).getRequestURI();
		
		Integer tempsExecution = Math.toIntExact(end - start);

		VisiteWeb visiteWeb = new VisiteWeb();
		visiteWeb.setChemin(path);
		visiteWeb.setTempsExecution(tempsExecution);

		visiteService.sauvegarderVisiteWeb(visiteWeb);
	}

	@Override
	public void destroy() {
	}

}
