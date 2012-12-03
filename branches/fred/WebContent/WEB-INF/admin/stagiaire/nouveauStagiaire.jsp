<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<s:url value="/css/menu.css"/>" rel="stylesheet"
	type="text/css" />
	<script type="text/javascript" src="/js/menu.js"></script>
<title><s:text name="Titre.stagiaire.nouveau" /></title>
</head>
<body>

	<div id="menu">
		<s:include value="../menuAdmin.jsp" />
	</div>

	<div class="titleDiv">
		<s:text name="Titre.stagiaire.nouveau" />
	</div>

	<s:actionerror />

	<s:form action="creerStagiaire">
		<s:include value="formulaireStagiaire.jsp" />
	</s:form>


</body>
</html>