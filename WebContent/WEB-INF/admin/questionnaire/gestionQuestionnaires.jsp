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

	<ul id="Menu">
		<li><a href="admin/questionnaire/nouveauQuestionnaire">Nouveau Questionnaire</a></li>
		<li><a href="admin/questionnaire/modifierQuestionnaire">Modifier Questionnaire</a></li>
			<ul id="Gestion des questions">
				<li><a href="admin/questionnaire/question/nouvelleQuestion">Nouvelle Question</a></li>
				<li><a href="admin/questionnaire/question/modifierQuestion">Modifier Question</a></li>
				<li><a href="admin/questionnaire/question/supprimerQuestion">Supprimer Question</a></li>
			</ul>
		<li><a href="admin/questionnaire/afficherSupprimerQuestionnaire">Supprimer Questionnaire</a></li>
	</ul>
	
</body>
</html>