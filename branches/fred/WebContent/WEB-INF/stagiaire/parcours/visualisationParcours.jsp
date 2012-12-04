<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<s:url value="/css/menu.css"/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/js/menu.js"></script>
<title><s:text name="Titre.stagiaire.parcours" /></title>
</head>
<body>

	<div id="menu">
		<s:include value="../menuStagiaire.jsp" />
	</div>
	<br />
	<div class="titleDiv">
		<s:text name="Titre.stagiaire.parcours" />
	</div>
	<div class="formList">
		<s:form action="visualisationParcours">
			<s:select name="qrid" theme="css_xhtml" list="listeQuestionnaires" listKey="id" listValue="nom" size="5" />
<s:submit key="Bouton.valider" cssClass="butStnd" name="selection" />

		</s:form>
	</div>
	<s:if test="listeParcours != null">
		<s:actionerror />

		<div class="form">
			Affiche le parcours
		</div>
	</s:if>
</body>
</html>