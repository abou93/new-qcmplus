<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="titleDiv">
		Modifier Questionnaire
	</div>

	<s:actionerror />

	<s:form action="modifierQuestionnaire">
		
			<s:select list="listQuestionnaire" listValue="nom" />
		
		<br />			
			<s:submit key="Bouton.valider" cssClass="butStnd" />

	</s:form>
</body>
</html>