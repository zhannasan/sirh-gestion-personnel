package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import dev.sgp.entite.Collaborateur;

public class CollaborateurService {
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}

	public Collaborateur rechercherCollaborateur(String matricule) {
		Collaborateur collaborateur = listeCollaborateurs.stream()
				.filter(c -> c.getMatricule().equals(matricule)).findAny().orElse(null);
		return collaborateur;
	}

	public List<Collaborateur> rechercherCollaborateurs(String nomPrenom, String dept) {
		List<Collaborateur> collaborateurs = new ArrayList<>();
		Predicate<Collaborateur> nomContient = c -> c.getNom().toLowerCase().startsWith(nomPrenom.toLowerCase());
		Predicate<Collaborateur> prenomContient = c -> c.getPrenom().toLowerCase().startsWith(nomPrenom.toLowerCase());		
		Predicate<Collaborateur> deptContient = c -> c.getDepartement().equals(dept);
		if(nomPrenom.trim().equals("") && dept.equals("Tous")){
			collaborateurs = listeCollaborateurs;
		}else if(nomPrenom.trim().equals("")){
			collaborateurs = listeCollaborateurs.stream().filter(deptContient).collect(Collectors.toList());
		}else if(dept.equals("Tous")){
			collaborateurs=	listeCollaborateurs.stream()
					.filter(nomContient.or(prenomContient)).collect(Collectors.toList());
		}else{
			collaborateurs=	listeCollaborateurs.stream()
				.filter(nomContient.or(prenomContient).or(deptContient)).collect(Collectors.toList());}
		return collaborateurs;
	}
}
