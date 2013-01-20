<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<s:url value="/css/menu.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="titleDiv">
		Nouveau Questionnaire
	</div>
	<div id="menu">
		<s:include value="/WEB-INF/admin/menuAdmin.jsp" />
	</div>
	<br/>

	<s:actionerror />

	<s:form action="creerQuestionnaire">
		
			<s:textfield name="q.nom" size="30" cssClass="tdLabel" key="Label.nom" />
			<s:textfield name="q.description" size="100" cssClass="tdLabel" key="Description" />
		
		<br />			
			<s:submit key="Bouton.valider" cssClass="butStnd" />

	</s:form>
</body>
</html>