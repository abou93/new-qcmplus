<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<p><s:property value="%{#session.utilisateur.nom}"/> !</p>
	<a href="admin/nouveauStagiaire">Nouveau stagiaire</a> <br>
	<a href="admin/modifierStagiaire">Modifier stagiaire</a><br>
	<a href="admin/supprimerStagiaire">Supprimer stagiaire</a><br>
</body>
</html>