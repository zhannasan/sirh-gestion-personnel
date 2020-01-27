package dev.sgp.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;

public class DepartementService {
	List<Departement> departements = new ArrayList<>();
	
	/**
	 * 
	 */
	public DepartementService() {
		this.departements.add(new Departement(1,"Comptabilite"));
		this.departements.add(new Departement(2,"Ressources Humaines"));
		this.departements.add(new Departement(3,"Informatique"));
		this.departements.add(new Departement(4,"Administratif"));
	}

	public List<Departement> listerDepartement(){
		return this.departements;
	}
	
	public void sauvegarderDepartement(Departement dept){
		departements.add(dept);
	}
	public List<Departement> rechercheParDepartement(String dept) {
		List<Departement> parDepart = departements.stream().filter(c -> c.getNomDept().equals(dept)).collect(Collectors.toList());
		return parDepart;
	}
}
