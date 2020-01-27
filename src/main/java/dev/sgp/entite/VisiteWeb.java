package dev.sgp.entite;

public class VisiteWeb {
	private int id;
	private String chemin;
	private Integer tempsExecution;

	/**
	 * 
	 */
	public VisiteWeb() {
		super();
	}
	/**
	 * @param id
	 * @param chemin
	 * @param tempsExecution
	 */
	public VisiteWeb(int id, String chemin, Integer tempsExecution) {
		super();
		this.id = id;
		this.chemin = chemin;
		this.tempsExecution = tempsExecution;
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
	 * @return the chemin
	 */
	public String getChemin() {
		return chemin;
	}
	/**
	 * @param chemin the chemin to set
	 */
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	/**
	 * @return the tempsExecution
	 */
	public Integer getTempsExecution() {
		return tempsExecution;
	}
	/**
	 * @param tempsExecution the tempsExecution to set
	 */
	public void setTempsExecution(Integer tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
	
	
}
