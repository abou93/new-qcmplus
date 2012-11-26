/**
 * 
 */
package bean;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class Utilisateur {

	/**
	 * 
	 */
	private long id;
	
	/**
	 * 
	 */
	private String nom;
	
	/**
	 * 
	 */
	private String motDePasse;
	
	/**
	 * 
	 */
	public Utilisateur() {
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	

	
}
