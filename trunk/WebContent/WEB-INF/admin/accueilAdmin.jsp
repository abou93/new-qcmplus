<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<p>Bonjour Admin <s:property value="%{#session.utilisateur.nom}"/> !</p>
	<a href="admin/test">CREER QUESTIONNAIRE</a> <br>
	<a href="admin/trouverQuestionnaire">MODIFIER QUESTIONNAIRE</a><br>
	<a href="admin/test">TROUVER QUESTIONNAIRE</a><br>
	<a href="admin/test">SUPPRIMER QUESTIONNAIRE</a><br>
</body>
</html>