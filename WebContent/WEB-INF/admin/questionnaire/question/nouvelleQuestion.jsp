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
	<div class="titleDiv">Nouvelle question</div>
	<div id="menu">
		<s:include value="/WEB-INF/admin/menuAdmin.jsp" />
	</div>
	<br>
	<br />
	<!-- DEBUT selection questionnaire -->
	<s:form action="questionnaireNouvelleQuestion">

		<s:select name="qrid" list="listeQuestionnaires" listValue="nom"
			size="10" listKey="id" />
		<s:submit value="Afficher" name="afficher" />

	</s:form>
	<!-- FIN selection questionnaire -->

	<!-- DEBUT affichage questionnaire -->
	<s:if test="qr != null">
		<s:textfield name="qr.nom" size="30" cssClass="tdLabel" key="Label.nom" disabled="true"/>
		<s:textfield name="qr.description" size="100" cssClass="tdLabel" key="Label.description" disabled="true"/>
	<!-- FIN affichage questionnaire -->

	<!-- DEBUT affichage liste questions questionnaire -->
	<s:if test="listeQuestionsQuestionnaire != null">
	<br/>
		<s:select name="QuestionsQuestionnaire" list="listeQuestionsQuestionnaire" listValue="intitule" size="10" listKey="id" />		
	</s:if>
	<!-- FIN affichage liste questions questionnaire -->
	<br/>
	<!-- DEBUT formulaire nouvelle question  -->

	<s:actionerror />
	<form action="nouvelleQuestion">
	
		<s:include value="formulaireQuestion.jsp"/>
		
		<s:submit key="Bouton.valider" cssClass="butStnd" name="validerQuestion"/>
		
	</form>

	<!-- FIN formulaire nouvelle question -->
	</s:if>
</body>
</html>