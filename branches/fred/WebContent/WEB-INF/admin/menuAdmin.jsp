<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul id="menu">

        <li>
        	<s:url value="/accueil" var="url_accueil"/>
            <a href='<s:property value="url_accueil"/>'><s:text name="Menu.accueil"/></a>
        </li>
        
        <li>
            <a href="#">Gestion des Stagiaires</a>
            <ul>
               	<s:url value="/admin/stagiaire/nouveauStagiaire" var="url_nouv_stag"/>
               	<s:url value="/admin/stagiaire/selectionStagiairePourMod" var="url_mod_stag"/>
            	<s:url value="/admin/stagiaire/selectionStagiairePourSuppr" var="url_supp_stag"/>
        	   	<li><a href='<s:property value="url_nouv_stag"/>'><s:text name="Menu.nouveau"/></a></li>
				<li><a href='<s:property value="url_mod_stag"/>'><s:text name="Menu.modifier"/></a></li>
				<li><a href='<s:property value="url_supp_stag"/>'><s:text name="Menu.supprimer"/></a></li>
            </ul>
        </li>
        
        <li>
                <a href="#">Gestion des Questionnaires</a>
                <ul>
                <s:url value="/admin/questionnaire/nouveauQuestionnaire" var="url_nouv_questR"/>
                <s:url value="/admin/questionnaire/modifierQuestionnaire" var="url_mod_questR"/>
                <s:url value="/admin/questionnaire/supprimerQuestionnaire" var="url_supp_questR"/>
                    <li><a href='<s:property value="#url_nouv_questR"/>'><s:text name="Menu.nouveau"/></a></li>
					<li><a href='<s:property value="#url_mod_questR"/>'><s:text name="Menu.modifier"/></a></li>
					<li><a href='<s:property value="#url_supp_questR"/>'><s:text name="Menu.supprimer"/></a></li>
                </ul>
        </li>
        
        <li>
        	<s:url value="/accueil" var="url_accueil"/>
            <a href='<s:property value="#url_accueil"/>'>Quitter</a>
        </li>      
</ul>
