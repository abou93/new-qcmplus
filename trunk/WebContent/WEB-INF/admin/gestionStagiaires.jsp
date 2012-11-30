<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<p><s:property value="%{#session.utilisateur.nom}"/> !</p>
	<a href="admin/newQuestionnaire">Nouveau Questionnaire</a> <br>
	<a href="admin/modifierQuestionnaire">Modifier Questionnaire</a><br>
	<a href="admin/supprimerQuestionnaire">SupprimerQuestionnaire</a><br>
</body>
</html>