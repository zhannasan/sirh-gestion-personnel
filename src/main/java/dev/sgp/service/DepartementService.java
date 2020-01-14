package dev.sgp.service;
import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {
	List<Departement> departements = new ArrayList<>();
	
	/**
	 * 
	 */
	public DepartementService() {
	}

	public List<Departement> listerDepartement(){
		this.departements.add(new Departement(1,"Comptabilite"));
		this.departements.add(new Departement(2,"Ressources Humaines"));
		this.departements.add(new Departement(3,"Informatique"));
		this.departements.add(new Departement(4,"Administratif"));
		return this.departements;
	}
	
	public void sauvegarderDepartement(Departement dept){
		departements.add(dept);
	}
	
}
