package dev.sgp.entite;

public class Departement {
	private int id;
	private String nomDept;
	/**
	 * @param id
	 * @param nomDept
	 */
	public Departement(int id, String nomDept) {
		super();
		this.id = id;
		this.nomDept = nomDept;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nomDept
	 */
	public String getNomDept() {
		return nomDept;
	}
	/**
	 * @param nomDept the nomDept to set
	 */
	public void setNomDept(String nomDept) {
		this.nomDept = nomDept;
	}
	
	
}
