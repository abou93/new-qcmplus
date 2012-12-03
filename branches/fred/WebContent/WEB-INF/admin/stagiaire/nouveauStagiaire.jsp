<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<title><s:text name="Titre.stagiaire.nouveau" /></title>
</head>
<body>

	<div class="titleDiv">
		<s:text name="Titre.stagiaire.nouveau" />
	</div>

	<s:actionerror />

	<s:form action="creerStagiaire">
		<s:include value="formulaireStagiaire.jsp"/>
	</s:form>


</body>
</html>