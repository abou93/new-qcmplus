/**
 * 
 */
package actions.admin.stagiaire;

import java.util.Map;

import services.StagiaireImplementService;
import services.UtilisateurService;
import beans.Stagiaire;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class CreerStagiaire extends ActionSupport {
	// Variables pour jsp
		private Stagiaire s;
		private String titre;

		// service pour g�rer les utilisateurs
		UtilisateurService userv = new StagiaireImplementService();

		// action de login
		@Override
		public String execute() {
			System.out.println("actions.admin.stagiaire.creer");
			// titre de la fen�tre
			titre = getText("Titre.stagiaire.nouveau");
			// tentative de cr�ation du stagiaire
			if (userv.creer(s) <= 0) {
				addActionError(getText("Erreur.creation.stagiaire"));
				return ERROR;
			}
			// message de confirmation et retour � l'interface de gestion
			addActionMessage(getText("Confirmation.creation.stagiaire"));
			return SUCCESS;
		}

		/**
		 * @return the s
		 */
		public Stagiaire getS() {
			return s;
		}

		/**
		 * @param s
		 *            the s to set
		 */
		public void setS(Stagiaire s) {
			this.s = s;
		}

		/**
		 * @return the titre
		 */
		public String getTitre() {
			return titre;
		}

		/**
		 * @param titre
		 *            the titre to set
		 */
		public void setTitre(String titre) {
			this.titre = titre;
		}
}
