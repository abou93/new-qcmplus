package actions;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.struts2.interceptor.SessionAware;

import services.UtilisateurImplementService;
import services.UtilisateurService;
import beans.Administrateur;
import beans.Stagiaire;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stephane Sikora & Frederic Aubry
 * 
 */
public class Login extends ActionSupport implements SessionAware {
	// Variables pour jsp
	/**
	 * L'utilisateur du portail
	 */
	private Utilisateur u;
	/**
	 * Le nom d'utilisateur
	 */
	private String nom;
	/**
	 * Le mot de passe de l'utilisateur
	 */
	private String mdp;

	// session pour stocker les attributs
	/**
	 * La session utilisateur
	 */
	private Map<String, Object> session;
	
	//chaine retournee par l'action
	/**
	 * Le resultat de l'action
	 */
	private String result;

	// service pour gerer les utilisateurs (on ne sait pas encore si admin ou stagiaire)
	/**
	 * Implementation d'un service pour les actions faites sur un utilisateur
	 */
	private UtilisateurService userv;
	
	
	/**
	 * Constructeur par defaut qui instancie le service
	 */
	public Login() {
		super();
		this.userv = new UtilisateurImplementService();
	}

	// action de login
	@Override
	public String execute() {
		//Creation d'un logger ou recuperation de l'existant
		Logger logger = Logger.getLogger("logger");
		//ecrit dans les logs
		logger.log(Level.INFO, this.toString());
		
		/*
		 * recuperation de l'utilisateur 
		 * la suppression des espaces et mise en
		 * minuslules prealables se fait au niveau du service lui-meme
		 */
		u = userv.trouverParNomEtMdp(this.getNom(), this.getMdp());

		// utilisateur trouve
		if (u != null) {
			System.out.println(u + " de type " + u.getClass());
			/*
			 * L'utilisateur existe bien en bdd : on détermine s'il est de type Stagiaire 
			 * ou Administrateur puis on le place en session pour utilisation future
			 */				
			// redirection en fonction du r�le stagiaire ou admin ?
			if (u instanceof Stagiaire) {
				result = "stagiaire";
			}
			if (u instanceof Administrateur) {
				result = "admin";
			}
			session.put("utilisateurSession", u);
		} else {
		// sinon ajout message d'erreur et renvoi vers le formulaire
		final String MESSAGE = "Login.erreur";
		this.addActionError(getText(MESSAGE));
		result = ERROR;
		}
		return result;
	}
	
	

	@Override
	public void validate() {
		if (getNom().length()==0){
			addFieldError("nom", getText("Login.erreur.nom"));
		}
		
		if (getMdp().length()==0){
			addFieldError("mdp", getText("Login.erreur.mdp"));
		}
	}



	/**
	 * @return Retourne l'utilisateur.
	 */
	public Utilisateur getU() {
		return u;
	}

	/**
	 * @param u L'utilisateur
	 */
	public void setU(Utilisateur u) {
		this.u = u;
	}

	/**
	 * @return Retourne le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom Le nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return Le mot de passe
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp Le mot de passe
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @param session La session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
