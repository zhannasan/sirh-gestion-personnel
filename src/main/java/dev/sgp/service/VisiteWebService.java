package dev.sgp.service;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {
	List<VisiteWeb> visiteWebs = new ArrayList<VisiteWeb>();

	public List<VisiteWeb> listerVisiteWeb() {
		return this.visiteWebs;
	}

	public void sauvegarderVisiteWeb(VisiteWeb visiteWeb) {
		this.visiteWebs.add(visiteWeb);
	}

	public long numberVisiteWeb(String chemin) {
		return this.visiteWebs.stream().filter(v -> v.getChemin().equals(chemin.trim())).count();
	}

	public IntSummaryStatistics timeStats() {
		return this.visiteWebs.stream().map(v -> v.getTempsExecution()).mapToInt(i -> i).summaryStatistics();
	}

	public List<String> getPaths(List<String> paths) {
		List<String> visitePaths = new ArrayList<>();
		for (VisiteWeb v : this.visiteWebs) {
			visitePaths.add(v.getChemin().trim());
			System.out.println("VisiteWebs: " + v.getChemin());
		}
		visitePaths.removeAll(paths);
		paths.addAll(visitePaths);
		for (String s : visitePaths) {
			System.out.println(s);
		}
		return paths;
	}

}
