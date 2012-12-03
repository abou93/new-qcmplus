<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<s:url value="/css/menu.css"/>" rel="stylesheet"
	type="text/css" />
	<script type="text/javascript" src="/js/menu.js"></script>
<title><s:text name="Titre.stagiaire.supprimer" /></title>
</head>
<body>

	<div id="menu">
		<s:include value="../menuAdmin.jsp" />
	</div>

	<div class="titleDiv">
		<s:text name="Titre.stagiaire.supprimer" />
	</div>

	<p>
		<s:form action="selectionStagiaireSuppression">
			<s:include value="selectionStagiaire.jsp" />
		</s:form>
	</p>
	<s:if test="s != null">
		<s:actionerror />

		<s:form action="supprimerStagiaire" onsubmit="confirm('sur?');">
			<s:include value="formulaireStagiaire.jsp" />
		</s:form>
	</s:if>

</body>
</html>