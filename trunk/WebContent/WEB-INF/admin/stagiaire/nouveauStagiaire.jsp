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
	<br />
	<div class="titleDiv">
		<s:text name="Titre.stagiaire.nouveau" />
	</div>
	<div id="menu">
		<s:include value="/WEB-INF/admin/menuAdmin.jsp" />
	</div>
	<br/>
	<s:actionerror />

	<div class="form">
		<s:form action="creerStagiaire">
			<s:include value="formulaireStagiaire.jsp" />
			<s:submit key="Bouton.creer" cssClass="butStnd" />
		</s:form>
	</div>


</body>
</html>