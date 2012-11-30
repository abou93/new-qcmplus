<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<p>Administrateur <s:property value="%{#session.utilisateur.nom}"/></p>

	
	<div class="titleDiv">
		Gestion des questionnaires
	</div>

	<s:actionerror />

	<s:form action="gestionQuestionnaires">
		
	<br />
				
	<a href="admin/questionnaire/nouveauQuestionnaire">Nouveau Questionnaire</a> <br>
	<a href="admin/questionnaire/modifierQuestionnaire">Modifier Questionnaire</a><br>
	<a href="admin/questionnaire/supprimerQuestionnaire">SupprimerQuestionnaire</a><br>
		
	<br />

	</s:form>
	
</body>
</html>