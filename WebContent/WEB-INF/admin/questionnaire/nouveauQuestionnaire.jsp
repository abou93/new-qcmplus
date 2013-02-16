<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<s:url value="/css/menu.css"/>" rel="stylesheet"
	type="text/css" />
	<title><s:text name="Titre.questionnaire.nouveau" /></title>
</head>
<body>
	<div class="titleDiv">
		<s:text name="Titre.questionnaire.nouveau" />
	</div>
	<div id="menu">
		<s:include value="/WEB-INF/admin/menuAdmin.jsp" />
	</div>
	<br/>

	<s:actionerror />

	<s:form action="creerQuestionnaire">
		
			<s:include value="formulaireQuestionnaire.jsp" />			
			<s:submit key="Bouton.creer" cssClass="butStnd" />

	</s:form>
</body>
</html>