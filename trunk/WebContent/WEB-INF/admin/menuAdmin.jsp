<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul id="menu">
	<li>
    <s:url value="/admin/accueilAdmin" var="url_accueil_admin"/>
    <a href='<s:property value="#url_accueil_admin"/>'><s:text name="Menu.accueil"/></a>
    </li>
        
    <li>
    <a href="#"><s:text name="Menu.gestion.stagiaires"/></a>
    	<ul>
          	<s:url value="/admin/stagiaire/nouveauStagiaire" var="url_nouv_stag"/>
           	<s:url value="/admin/stagiaire/selectionStagiairePourMod" var="url_mod_stag"/>
          	<s:url value="/admin/stagiaire/selectionStagiairePourSuppr" var="url_supp_stag"/>
           	<li><a href='<s:property value="#url_nouv_stag"/>'><s:text name="Menu.nouveau"/></a></li>
			<li><a href='<s:property value="#url_mod_stag"/>'><s:text name="Menu.modifier"/></a></li>
			<li><a href='<s:property value="#url_supp_stag"/>'><s:text name="Menu.supprimer"/></a></li>
        </ul>
	</li>
        
    <li>
    <a href="#"><s:text name="Menu.gestion.questionnaires"/></a>
    	<ul>
        	<s:url value="/admin/questionnaire/nouveauQuestionnaire" var="url_nouv_questR"/>
            <s:url value="/admin/questionnaire/modifierQuestionnaire" var="url_mod_questR"/>
            <s:url value="/admin/questionnaire/supprimerQuestionnaire" var="url_supp_questR"/>
            <li><a href='<s:property value="#url_nouv_questR"/>'><s:text name="Menu.nouveau"/></a></li>
			<li><a href='<s:property value="#url_mod_questR"/>'><s:text name="Menu.modifier"/></a>
				<ul>
					<s:url value="/admin/questionnaire/question/gestionQuestions" var="url_gest_quest"/>
                	<li><a href='<s:property value="#url_gest_quest"/>'><s:text name="Menu.gestion.questions"/></a>
                		<ul>
               				<s:url value="/admin/questionnaire/question/initQuestionnaireNouvelleQuestion" var="url_nouv_quest"/>
              			 	<s:url value="/admin/questionnaire/question/initQuestionnaireModificationQuestion" var="url_mod_quest"/>
            				<s:url value="/admin/questionnaire/question/initQuestionnaireSuppressionQuestion" var="url_supp_quest"/>
        	   				<li><a href='<s:property value="#url_nouv_quest"/>'><s:text name="Menu.nouveau"/></a></li>
							<li><a href='<s:property value="#url_mod_quest"/>'><s:text name="Menu.modifier"/></a></li>
							<li><a href='<s:property value="#url_supp_quest"/>'><s:text name="Menu.supprimer"/></a></li>
          			    </ul>
                	</li>
				</ul>
			</li>
			<li><a href='<s:property value="#url_supp_questR"/>'><s:text name="Menu.supprimer"/></a></li>        
        </ul>
        <li>
        	<s:url value="/accueil" var="url_accueil"/>
            <a href='<s:property value="#url_accueil"/>'>Quitter</a>
        </li>      
</ul>
