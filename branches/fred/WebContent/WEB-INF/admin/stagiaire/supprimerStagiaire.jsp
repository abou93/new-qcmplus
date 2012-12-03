<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<title><s:text name="Titre.stagiaire.supprimer" /></title>
</head>
<body>

	<div class="titleDiv">
		<s:text name="Titre.stagiaire.supprimer" />
	</div>

	<p>
		<s:form action="selectionStagiaireSuppression">
			<s:include value="selectionStagiaire.jsp" />
		</s:form>
	</p>

	<s:actionerror />

	<s:form action="supprimerStagiaire" onsubmit="confirm('sur?');">
		<s:include value="formulaireStagiaire.jsp" />
	</s:form>


</body>
</html>