package dev.sgp.service;
import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {
	List<Departement> departements = new ArrayList<>();
	
	public List<Departement> listerDepartement(){
		return this.departements;
	}
	
	public void sauvegarderDepartement(Departement dept){
		departements.add(dept);
	}
}
