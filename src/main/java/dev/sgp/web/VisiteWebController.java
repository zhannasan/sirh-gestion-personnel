package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Stats;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

public class VisiteWebController extends HttpServlet {
	private VisiteWebService visiteWebService = Constantes.FREQ_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> paths = new ArrayList<>();
		List<Stats> allStats = new ArrayList<>();
		List<String> webVisits = this.visiteWebService.getPaths(paths);
		for (String path : webVisits) {
			long numberVisits = this.visiteWebService.numberVisiteWeb(path);
			IntSummaryStatistics timeStats = this.visiteWebService.timeStats();
			allStats.add(
					new Stats(path, numberVisits, timeStats.getMin(), timeStats.getMax(), timeStats.getAverage()));
		}
		req.setAttribute("stats", allStats);
		req.getRequestDispatcher("/WEB-INF/views/collab/statsFrequentation.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
