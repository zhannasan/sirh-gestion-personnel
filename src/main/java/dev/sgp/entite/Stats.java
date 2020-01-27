package dev.sgp.entite;

public class Stats {
	private String path;
	private long numberVisits;
	private int min;
	private int max;
	private double moyenne;

	/**
	 * @param path
	 * @param numberVisits
	 * @param min
	 * @param max
	 * @param moyenne
	 */
	public Stats(String path, long numberVisits, int min, int max, double moyenne) {
		super();
		this.path = path;
		this.numberVisits = numberVisits;
		this.min = min;
		this.max = max;
		this.moyenne = moyenne;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the numberVisits
	 */
	public long getNumberVisits() {
		return numberVisits;
	}

	/**
	 * @param numberVisits
	 *            the numberVisits to set
	 */
	public void setNumberVisits(long numberVisits) {
		this.numberVisits = numberVisits;
	}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @param min
	 *            the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @param max
	 *            the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/**
	 * @return the moyenne
	 */
	public double getMoyenne() {
		return moyenne;
	}

	/**
	 * @param moyenne
	 *            the moyenne to set
	 */
	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

}
