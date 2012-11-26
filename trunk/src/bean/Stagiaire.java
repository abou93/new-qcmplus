/**
 * 
 */
package bean;

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
