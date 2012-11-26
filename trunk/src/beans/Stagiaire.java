/**
 * 
 */
package beans;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class Stagiaire extends Utilisateur {
	
	/**
	 * 
	 */
	private String prenom;
	
	/**
	 * 
	 */
	private String societe;
	
		
	/**
	 * 
	 */
	public Stagiaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the societe
	 */
	public String getSociete() {
		return societe;
	}
	/**
	 * @param societe the societe to set
	 */
	public void setSociete(String societe) {
		this.societe = societe;
	}
	
	
}
