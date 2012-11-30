<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<p>Administrateur <s:property value="%{#session.utilisateur.nom}"/> </p>
	<a href="admin/gestionStagiaires">Gestion des stagiaires</a> <br>
	<a href="admin/gestionQuestionnaires">Gestion des questionnaires</a><br>
</body>
</html>