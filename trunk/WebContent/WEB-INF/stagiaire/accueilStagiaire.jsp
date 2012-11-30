<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<p>Bonjour Stagiaire <s:property value="%{#session.utilisateur.nom}"/> !</p>
</body>
</html>