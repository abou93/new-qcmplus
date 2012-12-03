<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<title><s:text name="Titre.stagiaire.modifier" /></title>
</head>
<body>

	<div class="titleDiv">
		<s:text name="Titre.stagiaire.modifier" />
	</div>
	<p>
		<s:form action="selectionStagiaireModification">
			<s:include value="selectionStagiaire.jsp" />
		</s:form>
	</p>
	<s:if test="s != null">
		<s:actionerror />

		<s:form action="modifierStagiaire">
			<s:include value="formulaireStagiaire.jsp" />
		</s:form>
	</s:if>
</body>
</html>