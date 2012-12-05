<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul id="menu">

        <li>
        	<s:url value="/accueil" var="url_accueil"/>
            <a href='<s:property value="#url_accueil"/>'><s:text name="Menu.accueil"/></a>
        </li>
        
        <li>
        	<s:url value="/stagiaire/" var="url_lancer_questR"/>
            <a href='<s:property value="url_lancer_questR"/>'><s:text name="Menu.questionnaires"/></a>
        </li>
        
        <li>
        	<s:url value="/stagiaire/initVisualisationParcours" var="url_pracours"/>
            <a href='<s:property value="url_pracours"/>'><s:text name="Menu.parcours.effectues"/></a>
        </li>
        
        <li>
        	<s:url value="/accueil" var="url_accueil"/>
            <a href='<s:property value="#url_accueil"/>'><s:text name="Menu.quitter"/></a>
        </li>      
</ul>
