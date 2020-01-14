package dev.sgp.service;

import static java.util.stream.Collectors.partitioningBy;

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

	public Optional<Collaborateur> rechercherCollaborateur(String matricule) {
		Optional<Collaborateur> collaborateur = listeCollaborateurs.stream()
				.filter(c -> c.getMatricule().equals(matricule)).findFirst();
		return collaborateur;
	}

	public List<Collaborateur> rechercherCollaborateurs(String str, String dept) {
		List<Collaborateur> collaborateurs = new ArrayList<>();
		Predicate<Collaborateur> nomContient = c -> c.getNom().toLowerCase().startsWith(str.toLowerCase());
		Predicate<Collaborateur> prenomContient = c -> c.getPrenom().toLowerCase().startsWith(str.toLowerCase());		
		Predicate<Collaborateur> deptContient = c -> c.getDepartement().equals(dept);
		if(dept.equals("Tous")){
			collaborateurs=	listeCollaborateurs.stream()
					.filter(nomContient.or(prenomContient)).collect(Collectors.toList());
		}else{
			collaborateurs=	listeCollaborateurs.stream()
				.filter(nomContient.or(prenomContient).or(deptContient)).collect(Collectors.toList());}
		return collaborateurs;
	}
}
