<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<s:url value="/css/menu.css"/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/js/menu.js"></script>
<title><s:text name="Titre.stagiaire.modifier" /></title>
</head>
<body>

	<div id="menu">
		<s:include value="../menuAdmin.jsp" />
	</div>
	<br />
	<div class="titleDiv">
		<s:text name="Titre.stagiaire.modifier" />
	</div>
	<div class="formList">
		<s:form action="selectionStagiaireModification">
			<s:include value="selectionStagiaire.jsp" />
		</s:form>
	</div>
	<s:if test="s != null">
		<s:actionerror />

		<div class="form">
			<s:form action="modifierStagiaire">
				<s:include value="formulaireStagiaire.jsp" />
			</s:form>
		</div>
	</s:if>
</body>
</html>