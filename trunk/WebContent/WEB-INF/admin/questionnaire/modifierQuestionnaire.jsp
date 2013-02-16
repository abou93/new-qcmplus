<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<s:url value="/css/menu.css"/>" rel="stylesheet"
	type="text/css" />
<title><s:text name="Titre.questionnaire.modifier" /></title>
</head>
<body>
	<div class="titleDiv"><s:text name="Titre.questionnaire.modifier" /></div>

	<div id="menu">
		<s:include value="/WEB-INF/admin/menuAdmin.jsp" />
	</div>
	<br />
	<div class="formList">
		<s:form action="selectModifierQuestionnaire">
			<s:include value="selectionQuestionnaire.jsp" />
			
		</s:form>
	</div>

	<s:if test="qr != null">
	
		<s:actionerror />
		
		<div class="form">
			<s:form action="selectValiderQuestionnaire">
				<s:include value="formulaireQuestionnaire.jsp" />
				<s:submit key="Bouton.modifier" cssClass="butStnd" />
			</s:form>
		</div>
	</s:if>
</body>
</html>