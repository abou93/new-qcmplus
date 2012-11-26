/**
 * 
 */
package bean;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class Reponse {
	
	private long id;
	private String libelle;
	private boolean estCorrecte;
	/**
	 * 
	 */
	public Reponse() {
		super();
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the estCorrecte
	 */
	public boolean isEstCorrecte() {
		return estCorrecte;
	}
	/**
	 * @param estCorrecte the estCorrecte to set
	 */
	public void setEstCorrecte(boolean estCorrecte) {
		this.estCorrecte = estCorrecte;
	}
	
	
}
