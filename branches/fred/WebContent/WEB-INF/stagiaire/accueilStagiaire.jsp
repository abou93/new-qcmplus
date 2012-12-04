<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<s:url value="/css/menu.css"/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/js/menu.js"></script>
</head>
<body>
<div id="menu">
		<s:include value="menuStagiaire.jsp" />
	</div>
	<div id="content">
		<p>
			Bonjour Stagiaire <s:property value="%{#session.utilisateur.nom}" />
		</p>
	</div>
</body>
</html>