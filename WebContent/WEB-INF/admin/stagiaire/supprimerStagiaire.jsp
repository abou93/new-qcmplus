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
	<div class="titleDiv">
		<s:text name="Titre.stagiaire.supprimer" />
	</div>
	<div id="menu">
		<s:include value="/WEB-INF/admin/menuAdmin.jsp" />
	</div>
	<br/>

	<div class="formList">
		<s:form action="selectionStagiaireSuppression">
			<s:include value="selectionStagiaire.jsp" />
		</s:form>
	</div>
	<s:if test="s != null">
		<s:actionerror />

		<div class="form">
			<s:form action="supprimerStagiaire" onsubmit="confirm('sur?');">
				<s:include value="formulaireStagiaire.jsp" />
				<s:submit key="Bouton.supprimer" cssClass="butStnd" />
			</s:form>
		</div>
	</s:if>

</body>
</html>